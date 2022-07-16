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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telemune.marketplace.rest.common.Constants;
import com.telemune.marketplace.rest.common.Pages;
import com.telemune.marketplace.rest.common.Response;
import com.telemune.marketplace.rest.entity.vo.PackPriority;
import com.telemune.marketplace.rest.entity.vo.PackVO;
import com.telemune.marketplace.rest.service.IPackService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/pack")
public class PackController {

	@Autowired
	IPackService packService;

	private static final Logger logger = Logger.getLogger(PackController.class);

	@GetMapping("/packid")
	public Response findByPackId(@RequestParam("id") Integer id,
			@RequestParam(name = "langId", required = false) String languageId) {

		try {

			logger.info("Inside findByPackId() method of PackController class");
			logger.info("PackId ==>" + id + "--languageId ==>" + languageId);
			PackVO packVOdb = null;
			List<PackVO> packVOlst = new ArrayList<>();
			if (null != id && null != languageId) {
				packVOdb = packService.findByPackIdAndLanguageId(id, languageId);
				packVOlst.add(packVOdb);
				logger.debug(packVOlst.toString());
			} else if (null != id) {
				packVOlst = packService.findById(id);
				logger.debug(packVOlst.toString());
			}

			if (null != packVOlst && !packVOlst.isEmpty()) {
				logger.info("Exit findByPackId() method of PackController class");
				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, packVOlst, "Pack list",
						Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);

			} else {
				logger.info("Exit findByPackId() method of PackController class");
				return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST, packVOlst,
						"Data not found", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}

		} catch (

		Exception exception) {
			logger.error(exception.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(), "",
					Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}

	}

	@PostMapping()
	public Response createPlan(@RequestBody PackVO packVO) {
		logger.info("Inside createPlan() method of PackController class");
		logger.info("user input ==>" + packVO.toString());
		try {
			PackVO packVOdb = packService.createPlan(packVO);
			logger.debug(packVOdb.toString());
			if (null != packVOdb && packVOdb.getPackId() != null) {
				logger.info("Exit createPlan() method of PackController class");
				return new Response(HttpStatus.CREATED, Constants.HTTP_STATUS_CODE_CREATED, new ArrayList<>(),
						"Plan created", Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);
			} else {
				logger.info("Exit createPlan() method of PackController class");
				return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
						"Plan is not create", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.info(exception.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}
	}

	@PutMapping()
	public Response updatePlan(@RequestBody PackVO packVO) {
		logger.info("Inside updatePlan() method of PackController class");
		logger.info("User input ==>" + packVO.toString());
		try {
			PackVO packVOdb = packService.updatePlan(packVO);
			logger.debug(packVOdb.toString());
			if (null != packVOdb && packVOdb.getPackId() != null) {
				logger.info("Exit updatePlan() method of PackController class");
				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, new ArrayList<>(),
						"Plan Updated", Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);
			} else {
				logger.info("Exit updatePlan() method of PackController class");
				return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
						"Plan is not updated", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}
		} catch (Exception exception) {
			logger.error(exception.toString());
			exception.printStackTrace();
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}
	}

	@DeleteMapping("/{packId}")
	public Response deleteByPackId(@PathVariable(name = "packId") Integer packId) {

		try {

			logger.info("inside deleteByPackId() method of PackController class");
			logger.info("pack deleted by id ==>" + packId);

			if (null != packId) {
				boolean isPackDeleted = packService.planDeleteById(packId);
				logger.debug("Pack delete status" + isPackDeleted);
				if (isPackDeleted) {
					logger.info("exit deleteByPackId() method of PackController class");
					return new Response(HttpStatus.NO_CONTENT, Constants.HTTP_STATUS_CODE_NO_CONTACT, new ArrayList<>(),
							"Pack deleted", Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);

				} else {
					logger.info("exit deleteByPackId() method of PackController class");
					return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST,
							new ArrayList<>(), "Plan is not deleted", Constants.STATUS_FAILURE,
							Constants.STATUS_FAILURE_MESSAGE);
				}

			} else {
				return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
						"Plan is not deleted", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}

		} catch (

		Exception exception) {
			logger.error(exception.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}

	}

	@GetMapping("/pagination/")
	public Response findPlanWithPagination(@RequestParam("pageNo") Integer pageNo,
			@RequestParam(name = "status", required = false) String status,
			@RequestParam(name = "packName", required = false) String packName,
			@RequestParam(name = "pageSize") Integer pageSize,
			@RequestParam(name = "query", required = false) String query,
			@RequestParam(name = "sortBy", required = false) String sortBy) {

		try {
			logger.info("inside findPlanWithPagination() method of PackController class");
			logger.info("user input ==> --pageNo" + pageNo + "--pageSize" + pageSize);
			List<Object> packVOlst = null;
			if (null != pageSize && null != pageNo) {
					/*
					 * updated by mayank
					 */
				if (status != null) {
					if (status.equals("undefined") || status.equals("0")) {
						status = null;
						System.out.print("inside if of status"+ status);
					}
				}
		       if(packName!=null)
				{
					if(packName.equals("undefined") || packName.equals("0"))
					{
						packName=null;
						System.out.println("inside if of packName");
					}
				}
				Pages pages = packService.findAllPlanWithPagination(pageNo, pageSize,status,packName);
				logger.debug(pages.toString());
				if (pages != null && pages.getContent() != null) {
					packVOlst = new ArrayList<>();
					packVOlst.add(pages);
					logger.info(packVOlst);
					logger.info("exit findPlanWithPagination() method of PackController class");
					return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, packVOlst, "Pack List",
							Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);
				}
			} else {
				logger.info("exit findPlanWithPagination() method of PackController class");
				return new Response(HttpStatus.NO_CONTENT, Constants.HTTP_STATUS_CODE_NO_CONTACT, new ArrayList<>(),
						"value not found", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}
		} catch (Exception exception) {
			logger.error(exception.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}
		return new Response(HttpStatus.NO_CONTENT, Constants.HTTP_STATUS_CODE_NO_CONTACT, new ArrayList<>(),
				"value not found", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
	}

	@GetMapping("/all/plan/")
	public Response findAllPlan() {

		try {
			logger.info("inside findAllPlan() method of PackController class");
			List<PackVO> packVOlst = packService.findAllPlans();
			logger.debug(packVOlst.toString());
			if (packVOlst != null && !packVOlst.isEmpty()) {
				logger.info(packVOlst);
				logger.info("exit findAllPlan() method of PackController class");
				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, packVOlst, "All Pack List",
						Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);
			}
		} catch (Exception exception) {
			logger.error(exception.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);

		}
		logger.info("exit findAllPlan() method of PackController class");
		return new Response(HttpStatus.NO_CONTENT, Constants.HTTP_STATUS_CODE_NO_CONTACT, new ArrayList<>(),
				"Pack list not found", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
	}

	@GetMapping("/priority")
	public Response findPlanPriorityWithPagination(@RequestParam(name = "packTypeId") Integer packTypeId,
			@RequestParam(name = "langId") Integer langId) {

		try {
			logger.info("inside findPlanPriorityWithPagination() method of PackController class");
			logger.info("user input ==>--packTypeId--"+packTypeId+"--langId"+langId);
			List<Object> packVOlst;
			if (null != langId && null != packTypeId) {
				packVOlst = packService.findAllPlanPriority(packTypeId, langId);
				logger.debug(packVOlst.toString());
				logger.info("exit findPlanPriorityWithPagination() method of PackController class");
				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, packVOlst, "Pack List",
						Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);
			} else {
				logger.info("exit findPlanPriorityWithPagination() method of PackController class");
				return new Response(HttpStatus.NO_CONTENT, Constants.HTTP_STATUS_CODE_NO_CONTACT, new ArrayList<>(),
						"value not found", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}
		} catch (Exception exception) {
			logger.error(exception.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}
	}

	@PutMapping("/Priority/Update")
	public Response updatePlanPriority(@RequestBody PackPriority packPriority) {

		try {
			logger.info("inside updatePlanPriority() method of PackController class");
			logger.info("user input ==> packPriority--" + packPriority.toString());
			{
				boolean isPackPriorityUpdate = packService.updatePlanPriority(packPriority);
				logger.debug("update status" + isPackPriorityUpdate);

				if (isPackPriorityUpdate) {
					logger.info(isPackPriorityUpdate);
					logger.info("Exit updatePlanPriority() method of PackController class");
					return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, new ArrayList<>(),
							"Plan Priority Updated", Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);

				} else {
					logger.info("Exit updatePlanPriority() method of PackController class");
					return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST,
							new ArrayList<>(), "Plan is not updated", Constants.STATUS_FAILURE,
							Constants.STATUS_FAILURE_MESSAGE);
				}
			}
		} catch (Exception exception) {
			logger.error(exception.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}
	}
	
}
