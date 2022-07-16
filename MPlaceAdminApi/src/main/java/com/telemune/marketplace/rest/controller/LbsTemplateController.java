package com.telemune.marketplace.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telemune.marketplace.rest.common.Constants;
import com.telemune.marketplace.rest.common.Pages;
import com.telemune.marketplace.rest.common.Response;
import com.telemune.marketplace.rest.entity.vo.LbsTemplateVO;
import com.telemune.marketplace.rest.service.ILbsTemplateService;

/**
 * @author manjeet
 * @version 4.0.0
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/lbstemp")
public class LbsTemplateController {

	@Autowired
	ILbsTemplateService lbsTemplateService;

	private static final Logger logger = Logger.getLogger(LbsTemplateController.class);

	@GetMapping()
	public Response findByTemplateIdAndLanguageId(@RequestParam("tempId") Integer tempId,
			@RequestParam(name = "langId", required = false) Integer langId) {

		try {

			logger.info("Inside findByTemplateIdAndLanguageId() method of LbsTemplateController class");
			LbsTemplateVO lbsTemplateVO = null;
			List<LbsTemplateVO> lbsTemplateVOVOlst = new ArrayList<>();
			if (null != tempId && null != langId) {
				logger.info("Temp id --" + tempId.toString() + "langId --" + langId.toString());
				lbsTemplateVO = lbsTemplateService.findByTemplateIdAndLanguageId(tempId, langId);
				lbsTemplateVOVOlst.add(lbsTemplateVO);
				logger.debug(lbsTemplateVO.toString());
			} else if (null != tempId) {
				logger.info("Temp id --" + tempId.toString());
				lbsTemplateVOVOlst = lbsTemplateService.findByTemplateId(tempId);
				logger.debug(lbsTemplateVOVOlst.toString());
			}

			if (null != lbsTemplateVOVOlst && !lbsTemplateVOVOlst.isEmpty()) {
				logger.info("Exit findByTemplateIdAndLanguageId() method of LbsTemplateController class");
				logger.info(lbsTemplateVOVOlst.toString());
				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, lbsTemplateVOVOlst, "",
						Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);

			} else {
				logger.info("value is null");
				logger.info("Exit findByTemplateIdAndLanguageId() method of LbsTemplateController class");
				return new Response(HttpStatus.NOT_FOUND, Constants.HTTP_STATUS_CODE_NOT_FOUND, new ArrayList<>(),
						"Data not found", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}

		} catch (

		Exception exception) {
			logger.error(exception.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}
	}

	@SuppressWarnings("unused")
	@PutMapping()
	public Response updateTemplate(@RequestBody LbsTemplateVO lbsTemplateVO) {
		try {

			logger.info("Inside updateTemplate() method of LbsTemplateController class" + lbsTemplateVO.toString());
			if (null != lbsTemplateVO) {
				LbsTemplateVO lbsTemplate = lbsTemplateService.updateTemplate(lbsTemplateVO);

				logger.debug(lbsTemplate.toString());
				if (null != lbsTemplate && lbsTemplate.getTemplateId() != null) {
					logger.info(lbsTemplate.toString());
					return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, new ArrayList<>(),
							"Template is updated", Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);

				} else {
					logger.info("Template not update");
					logger.info("Exit updateTemplate() method of LbsTemplateController class");
					return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST,
							new ArrayList<>(), "Template is not updated", Constants.STATUS_FAILURE,
							Constants.STATUS_FAILURE_MESSAGE);
				}
			}
			logger.info("Exit updateTemplate() method of LbsTemplateController class");
			return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					"Id is null", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		} catch (

		Exception exception) {
			logger.error(exception.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(), "",
					Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}
	}

	@DeleteMapping("/{Id}/")
	public Response deleteByTempId(@PathVariable(name = "Id") Integer tempId) {

		try {
			logger.info("Inside deleteByTempId() method of LbsTemplateController class ---tempId---" + tempId);
			if (null != tempId) {
				if (lbsTemplateService.templateDeleteById(tempId)) {
					logger.info("Temp deleted with " + tempId);
					return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, new ArrayList<>(),
							"Id is Deleted", Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);
				} else

					return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST,
							new ArrayList<>(), "Not found value", Constants.STATUS_FAILURE,
							Constants.STATUS_FAILURE_MESSAGE);

			} else {
				logger.info("Temp not deleted");
				logger.info("Exit updateTemplate() method of LbsTemplateController class");
				return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
						"Not found value", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}

		} catch (

		Exception exception) {
			logger.info(exception.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(), "",
					Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}

	}

	@GetMapping("/pagination/")
	public Response findTempWithPagination(@RequestParam("pageNo") Integer pageNo,
			@RequestParam(name = "langId", required = false) String langId,
			@RequestParam(name = "pageSize") Integer pageSize,
			@RequestParam(name = "sortBy", required = false) String sortBy,
			@RequestParam(name = "query", required = false) String query) {

		try {
			logger.info("Inside findTempWithPagination() method of LbsTemplateController class");
			logger.info("user input ==>"
					+ "--pageNo--" + pageNo + "--pageSize--" + pageSize);

			List<Object> lbsTempVOlst;
			if (null != pageSize && null != pageNo) {

				if (langId != null) {
					if (langId.equals("undefined") || langId.equals("0")) {
						langId = null;
					}
				}
				Pages page = lbsTemplateService.findAllTmplateWithPagination(pageNo, pageSize, langId, query);
				logger.debug(page.toString());

				if (page != null && page.getContent() != null) {
					lbsTempVOlst = new ArrayList<>();
					lbsTempVOlst.add(page);
					logger.info("Exit findTempWithPagination() method of LbsTemplateController class");
					return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, lbsTempVOlst, "",
							Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);
				} else {
					logger.info("Exit findTempWithPagination() method of LbsTemplateController class");
					return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST,
							new ArrayList<>(), "No data found", Constants.STATUS_FAILURE,
							Constants.STATUS_FAILURE_MESSAGE);
				}

			} else {
				logger.info("Exit findTempWithPagination() method of LbsTemplateController class");
				return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
						"Not found value", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}
		} catch (Exception exception) {
			logger.error(exception.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(), "",
					Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}
	}
	
	/**
	 * 
	 * @return
	 */

	@GetMapping("/all/")
	public Response findAllTemp() {

		try {
			logger.info("Inside findAllTemp() method of LbsTemplateController class");
			List<LbsTemplateVO> lbsTempVOlst = lbsTemplateService.findAllTemplate();
			logger.debug(lbsTempVOlst.toString());
			if (lbsTempVOlst != null && !(lbsTempVOlst.isEmpty())) {
				logger.info("Exit findAllTemp() method of LbsTemplateController class");
				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, lbsTempVOlst, " ",
						Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);
			}
			logger.info("Exit findAllTemp() method of LbsTemplateController class");
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					"Data not found", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);

		} catch (Exception exception) {
			logger.error(exception.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);

		}

	}

}
