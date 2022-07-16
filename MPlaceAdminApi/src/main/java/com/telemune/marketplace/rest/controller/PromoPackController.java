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
import com.telemune.marketplace.rest.entity.vo.PromoPackVO;
import com.telemune.marketplace.rest.service.IPromoPackService;


/*
 * author mayank
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/promoPack")
public class PromoPackController {

	@Autowired
	IPromoPackService promoPackService;
	
	private static final Logger logger = Logger.getLogger(PromoPackController.class);
	
	
	@GetMapping("/pagination/")
	public Response findPlanWithPagination(@RequestParam("pageNo") Integer pageNo,
			@RequestParam(name = "status", required = false) String status,
			@RequestParam(name = "pageSize") Integer pageSize,
			@RequestParam(name = "query", required = false) String query,
			@RequestParam(name = "sortBy", required = false) String sortBy) {

		try {
			logger.info("inside findPlanWithPagination() method of PromoPackController class");
			logger.info("user input ==> --pageNo" + pageNo + "--pageSize" + pageSize);
			List<Object> promoPackVOlst = null;
			if (null != pageSize && null != pageNo) {
					/*
					 * created by mayank
					 */
				if (status != null) {
					if (status.equals("undefined") || status.equals("0")) {
						status = null;
						System.out.print("inside if of status"+ status);
					}
				}
		      Pages pages = promoPackService.findAllPlanWithPagination(pageNo, pageSize, status);
				logger.debug(pages.toString());
				if (pages != null && pages.getContent() != null) {
					promoPackVOlst = new ArrayList<>();
					promoPackVOlst.add(pages);
					logger.info(promoPackVOlst);
					logger.info("exit findPlanWithPagination() method of PromoPackController class");
					return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, promoPackVOlst, "PromoPack List",
							Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);
				}
			} else {
				logger.info("exit findPlanWithPagination() method of PromoPackController class");
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
	
	
	
	@DeleteMapping("/{packId}")
	public Response deleteByPackId(@PathVariable(name = "packId") Integer packId) {

		try {

			logger.info("inside deleteByPackId() method of PromoPackController class");
			logger.info("Promopack deleted by id ==>" + packId);
                     System.out.print("here is the id we get"+packId);
			if (null != packId) {
				boolean isPromoPackDeleted = promoPackService.promoPlanDeleteById(packId);
				logger.debug("PromoPack delete status" + isPromoPackDeleted);
				if (isPromoPackDeleted) {
					logger.info("exit deleteByPackId() method of PromoPackController class");
					return new Response(HttpStatus.NO_CONTENT, Constants.HTTP_STATUS_CODE_NO_CONTACT, new ArrayList<>(),
							"PromoPack deleted", Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);

				} else {
					logger.info("exit deleteByPackId() method of PromoPackController class");
					return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST,
							new ArrayList<>(), "PromoPlan is not deleted", Constants.STATUS_FAILURE,
							Constants.STATUS_FAILURE_MESSAGE);
				}

			} else {
				return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
						"PromoPlan is not deleted", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}

		} catch (

		Exception exception) {
			logger.error(exception.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}

	}
	
	
	@GetMapping("/packid")
	public Response findByPromoPackId(@RequestParam("id") Integer id,
			@RequestParam(name = "langId", required = false) String languageId) {

		try {

			logger.info("Inside findByPromoPackId() method of PromoPackController class");
			logger.info("PackId ==>" + id + "--languageId ==>" + languageId);
			PromoPackVO promoPackVOdb = null;
			List<PromoPackVO> promoPackVOlst = new ArrayList<>();
			if (null != id && null != languageId) {
				promoPackVOdb = promoPackService.findByPackIdAndLanguageId(id, languageId);
				promoPackVOlst.add(promoPackVOdb);
				logger.debug(promoPackVOlst.toString());
			} else if (null != id) {
				promoPackVOlst = promoPackService.findByPackId(id);
				logger.debug(promoPackVOlst.toString());
			}

			if (null != promoPackVOlst && !promoPackVOlst.isEmpty()) {
				logger.info("Exit findByPromoPackId() method of PromoPackController class");
				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, promoPackVOlst, "Pack list",
						Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);

			} else {
				logger.info("Exit findByPromoPackId() method of PromoPackController class");
				return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST, promoPackVOlst,
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
	public Response createPromoPlan(@RequestBody PromoPackVO promoPackVO) {
		logger.info("Inside createPromoPlan() method of PromoPackController class");
		logger.info("user input ==>" + promoPackVO.toString());
		try {
			PromoPackVO promoPackVOdb = promoPackService.createPromoPlan(promoPackVO);
			logger.debug(promoPackVOdb.toString());
			if (null != promoPackVOdb && promoPackVOdb.getPackId() != null) {
				logger.info("Exit createPromoPlan() method of PromoPackController class");
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
	public Response updatePromoPlan(@RequestBody PromoPackVO promoPackVO) {
		logger.info("Inside updatePlan() method of PackController class");
		logger.info("User input ==>" + promoPackVO.toString());
		try {
			PromoPackVO promoPackVOdb = promoPackService.updatePromoPlan(promoPackVO);
			logger.debug(promoPackVOdb.toString());
			if (null != promoPackVOdb && promoPackVOdb.getPackId() != null) {
				logger.info("Exit updatePromoPlan() method of PromoPackController class");
				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, new ArrayList<>(),
						"PromoPlan Updated", Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);
			} else {
				logger.info("Exit updatePlan() method of PromoPackController class");
				return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
						"PromoPlan is not updated", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}
		} catch (Exception exception) {
			logger.error(exception.toString());
			exception.printStackTrace();
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}
	}



}
