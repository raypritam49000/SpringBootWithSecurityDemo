package com.telemune.marketplace.rest.controller;
/**
 * @author mayank
 *
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
import com.telemune.marketplace.rest.entity.vo.PackTypeVO;
import com.telemune.marketplace.rest.entity.vo.PackVO;
import com.telemune.marketplace.rest.entity.vo.PackagesPurchaseReportVO;
import com.telemune.marketplace.rest.entity.vo.PromoPackVO;
import com.telemune.marketplace.rest.entity.vo.WhiteBlackVO;
import com.telemune.marketplace.rest.service.IPackService;
import com.telemune.marketplace.rest.service.IWhiteBlackService;
import com.telemune.marketplace.rest.utility.CsvUtility;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/whiteBlackList")
public class WhiteBlackListController {

	@Autowired
	IWhiteBlackService whiteBlackService;
	
	private static final Logger logger = Logger.getLogger(WhiteBlackListController.class);


	@GetMapping("/pagination/")
	public Response findListWithPagination(@RequestParam("pageNo") Integer pageNo,
			@RequestParam("type") String type,
			@RequestParam("msisdn") String msisdn,
			@RequestParam(name = "pageSize") Integer pageSize, 
			@RequestParam(name = "query", required = false) String query,
			@RequestParam(name = "sortBy" ,required = false)String sortBy) {

		try {
			logger.info("inside findListWithPagination() method of WhiteBlackListController class");
			logger.info("user input ==> --pageNo" + pageNo + "--pageSize" + pageSize);
			List<Object> whiteBlackVOlst =null;
			if (null != pageSize && null != pageNo) {
				 if (type != null) {
					if (type.equals("undefined") || type.equals("0")) {
						type = null;
						System.out.print("inside if of status"+ type);
					}
				}
				if(msisdn!=null)
					{
						if(msisdn.equals("undefined") || msisdn.equals("0"))
						{
							msisdn=null;
							System.out.println("inside if of msisdn"+msisdn);
						}
					}
			
			Pages pages =whiteBlackService.findAllListWithPagination(pageNo, pageSize,type,msisdn);
			logger.debug(pages.toString());
			if (pages != null && pages.getContent() != null) 
			{
				whiteBlackVOlst = new ArrayList<>();
				whiteBlackVOlst.add(pages);
			  //logger.debug(packTypeVOlst.toString());
				logger.info(whiteBlackVOlst);
				logger.info("exit findAllListWithPagination() method of WhiteBlackListController class");
				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, whiteBlackVOlst, "WhiteBlack List",
						Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);
			    } 
			
			}else {
				logger.info("exit findAllListWithPagination() method of WhiteBlackListController class");
				return new Response(HttpStatus.NO_CONTENT, Constants.HTTP_STATUS_CODE_NO_CONTACT, new ArrayList<>(),
						"Not found value", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}
		} catch (Exception exception) {
			logger.error(exception.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}
		return new Response(HttpStatus.NO_CONTENT, Constants.HTTP_STATUS_CODE_NO_CONTACT, new ArrayList<>(),
				"value not found", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
	
	}
	
	@GetMapping()
	public Response findByMsisdn(@RequestParam("msisdn") String msisdn) {
			System.out.println("inside find by msisdn method");
		try {
			logger.info("Inside findByMsisdn() method of WhiteBlackListController class");
			logger.info("Msisdn==>" + msisdn );
			WhiteBlackVO whiteBlackVOdb = null;
			List<WhiteBlackVO> whiteBlackVOlst = new ArrayList<>();
			
			if (null != msisdn) {
				System.out.println("here we get the msisdn"+msisdn);
				whiteBlackVOlst = whiteBlackService.findByMsisdn(msisdn);
				logger.debug(whiteBlackVOlst.toString());
			}

			if (null != whiteBlackVOlst && !whiteBlackVOlst.isEmpty()) {
				logger.info("Exit findByMsisdn() method of WhiteBlackListController class");
				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, whiteBlackVOlst, "",
						Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);

			} else {
				logger.info("Exit findByMsisdn() method of WhiteBlackListController class");
				return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST, whiteBlackVOlst,
						"Not found value", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}

		} catch (Exception exception) {
			logger.error(exception.toString());
			exception.printStackTrace();
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(), "",
					Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}

	}
	
	@DeleteMapping("/{msisdn}")
	public Response deleteByMsisdn(@PathVariable(name = "msisdn") String msisdn) {

		try {

			logger.info("inside deleteByMsisdn() method of WhiteBlackListController class");
			logger.info("Msisdn deleted by id ==>" + msisdn);

			if (null != msisdn) {
				boolean isMsisdnDeleted = whiteBlackService.DeleteByMsisdn(msisdn);
				logger.debug("Msisdn delete status" + isMsisdnDeleted);
				if (isMsisdnDeleted) {
					logger.info("exit deleteByMsisdn() method of WhiteBlackListController class");
					return new Response(HttpStatus.NO_CONTENT, Constants.HTTP_STATUS_CODE_NO_CONTACT, new ArrayList<>(),
							"Msisdn deleted", Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);

				} else {
					logger.info("exit deleteByMsisdn() method of WhiteBlackListController class");
					return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST,
							new ArrayList<>(), "Msisdn is not deleted", Constants.STATUS_FAILURE,
							Constants.STATUS_FAILURE_MESSAGE);
				}

			} else {
				return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
						"Msisdn is not deleted", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}

		} catch (

		Exception exception) {
			logger.error(exception.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}

	}
	
	@PutMapping()
	public Response updateWhiteBlackList(@RequestBody WhiteBlackVO whiteBlackVO) {
		logger.info("Inside updateWhiteBlackList() method of WhiteBlackListController class");
		logger.info("User input ==>" + whiteBlackVO.toString());
		try {
			WhiteBlackVO whiteBlackVOdb = whiteBlackService.updateList(whiteBlackVO);
			logger.debug(whiteBlackVOdb.toString());
			if (null != whiteBlackVOdb && whiteBlackVOdb.getMsisdn() != null) {
				logger.info("Exit updateWhiteBlackList() method of WhiteBlackListController class");
				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, new ArrayList<>(),
						"List Updated", Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);
			} else {
				logger.info("Exit updateWhiteBlackList() method of WhiteBlackListController class");
				return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
						"List is not updated", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}
		} catch (Exception exception) {
			logger.error(exception.toString());
			exception.printStackTrace();
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}
	}
	
	
	@PostMapping()
	public Response addMsisdn(@RequestBody WhiteBlackVO whiteBlackVO) {
		logger.info("Inside addMsisdn() method of WhiteBlackListController class");
		logger.info("user input ==>" + whiteBlackVO.toString());
		try {
			WhiteBlackVO whiteBlackVOdb = whiteBlackService.addMsisdn(whiteBlackVO);
			logger.debug(whiteBlackVOdb.toString());
			if (null != whiteBlackVOdb && whiteBlackVOdb.getMsisdn()!= null) {
				logger.info("Exit addMsisdn() method of WhiteBlackListController class");
				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, new ArrayList<>(),
						"Msisdn Added", Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);
			} else {
				logger.info("Exit addMsisdn() method of WhiteBlackListController class");
				return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
						"Msisdn is not added", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.info(exception.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}
	}
	

	/*@PostMapping()
	public Response addMsisdn(@RequestBody WhiteBlackVO whiteBlackVO) {
		logger.info("Inside addMsisdn() method of WhiteBlackListController class");
		logger.info("user input ==>" + whiteBlackVO.toString());
		try {
			WhiteBlackVO whiteBlackVOdb = whiteBlackService.addMsisdn(whiteBlackVO);
			logger.debug(whiteBlackVOdb.toString());
			if (null != whiteBlackVOdb && whiteBlackVOdb.getMsisdn() != null) {
				logger.info("Exit addMsisdn() method of WhiteBlackListController class");
				return new Response(HttpStatus.CREATED, Constants.HTTP_STATUS_CODE_CREATED, new ArrayList<>(),
						"Msisdn Added", Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);
			} else {
				logger.info("Exit addMsisdn() method of WhiteBlackListController class");
				return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
						"Msisdn is not Added", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.info(exception.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}
	}
	
	
	@GetMapping("/count")
	public Response findtotalCount( @RequestParam("pageNo") Integer pageNo,
			@RequestParam(name = "pageSize") Integer pageSize,
			@RequestParam(name = "query", required = false) String query,
			@RequestParam(name = "sortBy", required = false) String sortBy

	) {
		try {
			logger.info("Inside findtotalCount() method of WhiteBlackListController class");
			logger.info("user input ==> --pageNo--" + pageNo
					+ "--pageSize--" + pageSize);
			List<Object> whiteBlacklst;
			Pages page = whiteBlackService.findWhiteBlackCount(pageNo, pageSize, sortBy,
					query);
			logger.debug(page);
			
			if (page != null && page.getContent() != null) {
				whiteBlacklst = new ArrayList<>();
				whiteBlacklst.add(page);
			
				logger.info("Exit findtotalCount() method of WhiteBlackListController class");
				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, whiteBlacklst, "",
						Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);
			} else {
				logger.info("Exit findtotalCount() method of WhiteBlackListController class");
				return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
						"data no found", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}
		} catch (Exception exception) {
			logger.error(exception.toString());
			exception.printStackTrace();
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);

		}

	}*/
	
	/*@GetMapping("/systemList.csv")
	public void downloadWhiteBackCsv(HttpServletResponse response,
			@RequestParam("type") String type)
					 throws IOException {

		logger.info("Inside downloadWhiteBackCsv() method of WhiteBlackListController class");
		logger.info("user input ==> --type--" + type );

		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment; file=whiteBlackListReport.csv");

		List<WhiteBlackVO> wbVOlst = whiteBlackService.csvFiledateForDownload(type);

		logger.debug(wbVOlst);

		if (wbVOlst != null)
			CsvUtility.downloadWhiteBlackCsv(response.getWriter(), wbVOlst);
		logger.info("Exit downloadWhiteBackCsv() method of WhiteBlackListController class");

	}*/
	

}
