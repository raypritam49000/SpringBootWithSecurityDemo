package com.telemune.marketplace.rest.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telemune.marketplace.rest.common.Constants;
import com.telemune.marketplace.rest.common.Pages;
import com.telemune.marketplace.rest.common.Response;
import com.telemune.marketplace.rest.entity.ChargingLogs;
import com.telemune.marketplace.rest.entity.TransactionCdr;
import com.telemune.marketplace.rest.entity.vo.MplaceCustCareCdrReportVO;
import com.telemune.marketplace.rest.entity.vo.MplaceCustCareRetentionReportVO;
import com.telemune.marketplace.rest.entity.vo.MplaceCustCareTotalUsageReportVO;
import com.telemune.marketplace.rest.entity.vo.MplaceCustcareTpsReportVO;
import com.telemune.marketplace.rest.entity.vo.PackAlertAnalyticsVO;
import com.telemune.marketplace.rest.entity.vo.PackagesPurchaseReportVO;
import com.telemune.marketplace.rest.entity.vo.RevenueReportVO;
import com.telemune.marketplace.rest.service.IReportService;
import com.telemune.marketplace.rest.utility.CsvUtility;

@CrossOrigin
@RequestMapping("/api/auth/report")
@RestController
public class ReportController {

	@Autowired
	IReportService reportService;

	private static final Logger logger = Logger.getLogger(ReportController.class);

	@GetMapping("/packpurchase/filter/date")
	public Response findPackPurchaseByDateAndShortCode(@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate,
			@RequestParam(name = "packList", required = false) List<Integer> packList,
			@RequestParam(name = "shortCode", required = false) String shortCode,
			@RequestParam("pageNo") Integer pageNo, @RequestParam(name = "pageSize") Integer pageSize,
			@RequestParam(name = "query", required = false) String query,
			@RequestParam(name = "sortBy", required = false) String sortBy) {
		try {

			logger.info("Inside findPackPurchaseByDateAndShortCode() method of ReportController class");
			logger.info("User input ==> --startDate--" + startDate + "--endDate--" + endDate + "shortCode--" + shortCode
					+ "--pageNo--" + pageNo + "--pageSize--" + pageSize);

			List<Object> packagesPurchaseReportlst;
			Pages page = reportService.findPackPurhaseByDateAndShortCode(startDate, endDate, packList, shortCode,
					pageNo, pageSize, sortBy, query);
			logger.debug(page.toString());
			if (page != null && page.getContent() != null) {
				packagesPurchaseReportlst = new ArrayList<>();
				packagesPurchaseReportlst.add(page);

				logger.info("Exit findPackPurchaseByDateAndShortCode() method of ReportController class");
				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, packagesPurchaseReportlst,
						"All packages purchase reportlst list", Constants.STATUS_SUCCESS,
						Constants.STATUS_SUCCESS_MESSAGE);
			} else {
				logger.info("Exit findPackPurchaseByDateAndShortCode() method of ReportController class");
				return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
						"List is empty", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}
		} catch (Exception exception) {
			logger.info(exception.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);

		}

	}

	@GetMapping("/packpurchase/download/packagesPurchaseReport.csv")
	public void downloadPackagesPurchaseReportCsv(HttpServletResponse response,
			@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate,
			@RequestParam(name = "packList", required = false) List<Integer> packList,
			@RequestParam(name = "shortCode", required = false) String shortCode) throws IOException {

		logger.info("Inside downloadPackagesPurchaseReportCsv() method of ReportController class");
		logger.info("user input ==> --startDate--" + startDate + "--endDate--" + endDate + "shortCode--" + shortCode);

		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment; file=packagesPurchaseReport.csv");

		List<PackagesPurchaseReportVO> pprVOlst = reportService.csvFiledateForDownload(startDate, endDate, packList,
				shortCode);

		logger.debug(pprVOlst);

		if (pprVOlst != null)
			CsvUtility.downloadPackagesPurchaseReportCsv(response.getWriter(), pprVOlst);
		logger.info("Exit downloadPackagesPurchaseReportCsv() method of ReportController class");

	}

	@GetMapping("/revenue/filter/date")
	public Response findRevenueByDateAndRequestType(@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate,
			@RequestParam(name = "requestType", required = false) Integer requestType,
			@RequestParam("pageNo") Integer pageNo, @RequestParam(name = "pageSize") Integer pageSize,
			@RequestParam(name = "query", required = false) String query,
			@RequestParam(name = "sortBy", required = false) String sortBy,
			@RequestParam(name = "aggregateType", required = false) String aggregateType

	) {
		try {

			logger.info("Inside findRevenueByDateAndRequestType() method of ReportController class");
			logger.info("user input ==> --startDate--" + startDate + "--endDate--" + endDate + "--requestType--"
					+ requestType + "--pageNo--" + pageNo + "--pageSize--" + pageSize + "--aggregateType--"
					+ aggregateType);
			List<Object> revenueReportVOlst;
			Pages page = reportService.findRevenueByDateAndRequestType(startDate, endDate, requestType, pageNo,
					pageSize, sortBy, query, aggregateType);

			logger.debug(page);
			if (page != null && !page.getContent().isEmpty()) {
				revenueReportVOlst = new ArrayList<>();
				revenueReportVOlst.add(page);
				logger.info("Exit findRevenueByDateAndRequestType() method of ReportController class");
				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, revenueReportVOlst,
						"All packages revenue report list", Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);
			} else {
				logger.info("Exit findRevenueByDateAndRequestType() method of ReportController class");
				return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
						"data not found", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}
		} catch (Exception exception) {
			logger.error(exception.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);

		}

	}

	@GetMapping("/revenue/download/revenueReport.csv")
	public void downloadRevenueReportCsv(HttpServletResponse response, @RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate,
			@RequestParam(name = "aggregateType", required = false) String aggregateType,
			@RequestParam(name = "requestType", required = false) Integer requestType) throws IOException {
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment; file=revenueReport.csv");

		logger.info("Inside downloadRevenueReportCsv() method of ReportController class");
		logger.info("user input ==> --startDate--" + startDate + "--endDate--" + endDate);

		List<RevenueReportVO> revenueReportlst = reportService.revenueCsvFiledateForDownload(startDate, endDate,
				requestType, aggregateType);
		logger.debug(revenueReportlst);

		if (revenueReportlst != null)
			CsvUtility.downloadRevenueReportCsv(response.getWriter(), revenueReportlst);
		logger.info("Exit downloadRevenueReportCsv() method of ReportController class");
	}

	@GetMapping("/revenue/requesttype/all")
	public Response findAllRequestType() {

		try {
			logger.info("Inside findAllRequestType() method of ReportController class");
			List<RevenueReportVO> revenueReportVOlst = reportService.findAllRequestType();
			logger.debug(revenueReportVOlst);
			if (revenueReportVOlst != null && !revenueReportVOlst.isEmpty()) {
				logger.info("Exit findAllRequestType() method of ReportController class");
				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, revenueReportVOlst, "All",
						Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);
			}
		} catch (Exception exception) {
			logger.error(exception.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);

		}
		logger.info("Exit findAllRequestType() method of ReportController class");
		return new Response(HttpStatus.NO_CONTENT, Constants.HTTP_STATUS_CODE_NO_CONTACT, new ArrayList<>(),
				"data not found", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
	}

	@GetMapping("/pack/alert/filter/date")
	public Response findPackAlertByDate(@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate, @RequestParam("pageNo") Integer pageNo,
			@RequestParam(name = "pageSize") Integer pageSize,
			@RequestParam(name = "query", required = false) String query,
			@RequestParam(name = "sortBy", required = false) String sortBy

	) {
		try {
			logger.info("Inside findPackAlertByDate() method of ReportController class");
			logger.info("user input ==> --startDate--" + startDate + "--endDate--" + endDate + "--pageNo--" + pageNo
					+ "--pageSize--" + pageSize);

			List<Object> packAlartVOlst;
			Pages page = reportService.findPackAlertByDate(startDate, endDate, pageNo, pageSize, sortBy, query);
			logger.debug(page.toString());
			if (page != null && page.getContent() != null) {
				packAlartVOlst = new ArrayList<>();
				packAlartVOlst.add(page);
				logger.info("Exit findPackAlertByDate() method of ReportController class");
				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, packAlartVOlst, "",
						Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);
			} else {
				logger.info("Exit findPackAlertByDate() method of ReportController class");
				return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
						"data not found", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}
		} catch (Exception exception) {
			logger.error(exception.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);

		}

	}

	@GetMapping("/pack/alert/download/packAlertReport.csv")
	public void downloadPackAlertReprtCsv(HttpServletResponse response, @RequestParam("alertDate") String alertDate

	) throws IOException {

		logger.info("Inside downloadPackAlertReprtCsv() method of ReportController class");
		logger.info("user input ==> --alertDate--" + alertDate);
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment; file=packAlertReport.csv");

		List<PackAlertAnalyticsVO> revenueReportVOlst = reportService.packAlertReprtCsv(alertDate);
		logger.debug(revenueReportVOlst);

		if (revenueReportVOlst != null)
			CsvUtility.downloadPackAlertReprtCsv(response.getWriter(), revenueReportVOlst);
		logger.info("Exit downloadPackAlertReprtCsv() method of ReportController class");
	}

	@GetMapping("/custcare/cdr/filter/date")
	public Response findByCustCareCdrByDate(@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate, @RequestParam("pageNo") Integer pageNo,
			@RequestParam(name = "pageSize") Integer pageSize,
			@RequestParam(name = "query", required = false) String query,
			@RequestParam(name = "sortBy", required = false) String sortBy

	) {
		try {
			logger.info("Inside findByCustCareCdrByDate() method of ReportController class");
			logger.info("user input ==> --startDate--" + startDate + "--endDate--" + endDate + "--pageNo--" + pageNo
					+ "--pageSize--" + pageSize);

			List<Object> packAlartVOlst;
			Pages page = reportService.findByCustCareCdrByDate(startDate, endDate, pageNo, pageSize, sortBy, query);
			logger.debug(page.toString());
			if (page != null && page.getContent() != null) {
				packAlartVOlst = new ArrayList<>();
				packAlartVOlst.add(page);
				logger.info("Exit findByCustCareCdrByDate() method of ReportController class");
				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, packAlartVOlst, "",
						Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);
			} else {
				logger.info("Exit findByCustCareCdrByDate() method of ReportController class");
				return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
						"data no found", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}
		} catch (Exception exception) {
			logger.error(exception.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);

		}

	}

	@GetMapping("/custcare/cdr/filter/date/custCareCdrReport.csv")
	public void downloadCustCareCdrByDateCsv(HttpServletResponse response, @RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate

	) throws IOException, ParseException {

		logger.info("Inside downloadCustCareCdrByDateCsv() method of ReportController class");
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment; file=custCareCdrReport.csv");

		List<MplaceCustCareCdrReportVO> mplaceCustCareCdrReportlst = reportService.mplaceCustCareCdrCsv(startDate,
				endDate);
		logger.debug(mplaceCustCareCdrReportlst);
		if (mplaceCustCareCdrReportlst != null)
			CsvUtility.downloadMplaceCustCareCdrReportCsv(response.getWriter(), mplaceCustCareCdrReportlst);
		logger.info("Exit downloadCustCareCdrByDateCsv() method of ReportController class");
	}

	@GetMapping("/product/purchase/filter/date")
	public Response findProductPurchaseReportByDate(@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate, @RequestParam("pageNo") Integer pageNo,
			@RequestParam(name = "aggregateType", required = false) String aggregateType,
			@RequestParam(name = "pageSize") Integer pageSize,
			@RequestParam(name = "query", required = false) String query,
			@RequestParam(name = "sortBy", required = false) String sortBy

	) {
		try {
			logger.info("Inside findProductPurchaseReportByDate() method of ReportController class");
			logger.info("user input ==> --startDate--" + startDate + "--endDate--" + endDate + "--pageNo--" + pageNo
					+ "--pageSize--" + pageSize);
			List<Object> productPurchaseReportlst;
			Pages page = reportService.findProductPurchaseReportByDate(startDate, endDate, pageNo, pageSize, sortBy,
					query, aggregateType);
			logger.debug(page);
			List<String> productNamelst = reportService.productPurchaseProductName(startDate, endDate, aggregateType);
			logger.debug(productNamelst);
			if (page != null && page.getContent() != null) {
				productPurchaseReportlst = new ArrayList<>();
				productPurchaseReportlst.add(page);
				productPurchaseReportlst.add(productNamelst);
				logger.info("Exit findProductPurchaseReportByDate() method of ReportController class");
				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, productPurchaseReportlst, "",
						Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);
			} else {
				logger.info("Exit findProductPurchaseReportByDate() method of ReportController class");
				return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
						"data no found", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}
		} catch (Exception exception) {
			logger.error(exception.toString());
			exception.printStackTrace();
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);

		}

	}

	@GetMapping("/product/purchase/filter/date/productPurchaseReport.csv")
	public void downloadProductPurchaseReportByDateCsv(HttpServletResponse response,
			@RequestParam(name = "aggregateType", required = false) String aggregateType,
			@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate

	) throws IOException, ParseException {

		logger.info("Inside downloadProductPurchaseReportByDateCsv() method of ReportController class");
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment; file=productPurchaseReport.csv");

		List<Object[]> productPurchaseReportlst = reportService.productPurchaseReportCsv(startDate, endDate,
				aggregateType);
		List<String> productNamelst = reportService.productPurchaseProductName(startDate, endDate, aggregateType);

		logger.debug(productPurchaseReportlst.toString());
		logger.debug(productNamelst.toString());

		if (productPurchaseReportlst != null)
			CsvUtility.downloadProductPurchaseReportCsv(response.getWriter(), productPurchaseReportlst, productNamelst);
		logger.info("Exit downloadProductPurchaseReportByDateCsv() method of ReportController class");
	}

	@GetMapping("/custcare/total/usageReport/filter/date")
	public Response findMplaceCustCareTotalUsageReportByDate(@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate, @RequestParam("pageNo") Integer pageNo,
			@RequestParam(name = "aggregateType", required = false) String aggregateType,
			@RequestParam(name = "pageSize") Integer pageSize,
			@RequestParam(name = "query", required = false) String query,
			@RequestParam(name = "sortBy", required = false) String sortBy

	) {
		try {
			logger.info("Inside findMplaceCustCareTotalUsageReportByDate() method of ReportController class");
			logger.info("user input ==> --startDate--" + startDate + "--endDate--" + endDate + "--pageNo--" + pageNo
					+ "--pageSize--" + pageSize + "--aggregateType--" + aggregateType);

			List<Object> mplaceCustCareTotalUsageReportlst;
			Pages page = reportService.findMplaceCustCareTotalUsageReportByDate(startDate, endDate, pageNo, pageSize,
					sortBy, query, aggregateType);
			logger.debug(page.toString());
			if (page != null && page.getContent() != null) {
				mplaceCustCareTotalUsageReportlst = new ArrayList<>();
				mplaceCustCareTotalUsageReportlst.add(page);
				logger.info("Exit findMplaceCustCareTotalUsageReportByDate() method of ReportController class");
				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS,
						mplaceCustCareTotalUsageReportlst, "", Constants.STATUS_SUCCESS,
						Constants.STATUS_SUCCESS_MESSAGE);
			} else {
				logger.info("Exit findMplaceCustCareTotalUsageReportByDate() method of ReportController class");
				return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
						"data not found", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}
		} catch (Exception exception) {
			logger.error(exception.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);

		}

	}

	@GetMapping("/custcare/total/usageReport/filter/date/mplaceCustCareTotalUsageReport.csv")
	public void downloadMplaceCustCareTotalUsageReportByDateCsv(HttpServletResponse response,
			@RequestParam("startDate") String startDate,
			@RequestParam(name = "aggregateType", required = false) String aggregateType,
			@RequestParam("endDate") String endDate

	) throws IOException, ParseException {

		logger.info("Inside downloadMplaceCustCareTotalUsageReportByDateCsv() method of ReportController class");
		logger.info("user input ==> --startDate--" + startDate + "--endDate--" + endDate + "--aggregateType--"
				+ aggregateType);
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment; file=mplaceCustCareTotalUsageReport.csv");

		List<MplaceCustCareTotalUsageReportVO> mplaceCustCareTotalUsageReportlst = reportService
				.FindMplaceCustCareTotalUsageReportCsv(startDate, endDate, aggregateType);
		logger.debug(mplaceCustCareTotalUsageReportlst);
		if (mplaceCustCareTotalUsageReportlst != null)
			CsvUtility.downloadMplaceCustCareTotalUsageReportCsv(response.getWriter(),
					mplaceCustCareTotalUsageReportlst);
		logger.info("Exit downloadMplaceCustCareTotalUsageReportByDateCsv() method of ReportController class");
	}

	@GetMapping("/custcare/retention/filter/date")
	public Response findRetentionReportByDate(@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate, @RequestParam("pageNo") Integer pageNo,
			@RequestParam(name = "pageSize") Integer pageSize,
			@RequestParam(name = "query", required = false) String query,
			@RequestParam(name = "sortBy", required = false) String sortBy

	) {
		try {

			logger.info("Inside findRetentionReportByDate() method of ReportController class");
			logger.info("User input ==> --startDate--" + startDate + "--endDate--" + endDate + "--pageNo--" + pageNo
					+ "--pageSize--" + pageSize);

			List<Object> packAlartVOlst;
			Pages page = reportService.findRetentionReportByDate(startDate, endDate, pageNo, pageSize, sortBy, query);
			logger.debug(page.toString());

			if (page != null && page.getContent() != null) {
				packAlartVOlst = new ArrayList<>();
				packAlartVOlst.add(page);
				logger.info("Exit findRetentionReportByDate() method of ReportController class");
				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, packAlartVOlst, "",
						Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);
			} else {
				logger.info("Exit findRetentionReportByDate() method of ReportController class");
				return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
						"data not found", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}
		} catch (Exception exception) {
			logger.info("Exit findRetentionReportByDate() method of ReportController class");
			logger.error(exception.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);

		}

	}

	@GetMapping("/custcare/retention/filter/date/mplaceCustCareRetentionReport.csv")
	public void downloadMplaceCustcareRetentionReportByDateCsv(HttpServletResponse response,
			@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate

	) throws IOException, ParseException {

		logger.info("Inside downloadMplaceCustcareRetentionReportByDateCsv() method of ReportController class");
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment; file=mplaceCustCareRetentionReport.csv");

		List<MplaceCustCareRetentionReportVO> mplaceCustcareRetentionReportlst = reportService
				.FindMplaceCustcareRetentionReportReportCsv(startDate, endDate);
		logger.debug(mplaceCustcareRetentionReportlst.toString());
		if (mplaceCustcareRetentionReportlst != null)
			CsvUtility.downloadFindMplaceCustcareRetentionReportReportCsv(response.getWriter(),
					mplaceCustcareRetentionReportlst);
		logger.info("Exit downloadMplaceCustcareRetentionReportByDateCsv() method of ReportController class");
	}

	@GetMapping("/custcare/tps/filter/date")
	public Response findTpsReportByDate(@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate, @RequestParam("pageNo") Integer pageNo,
			@RequestParam(name = "pageSize") Integer pageSize,
			@RequestParam(name = "aggregateType", required = false) String aggregateType,
			@RequestParam(name = "query", required = false) String query,
			@RequestParam(name = "sortBy", required = false) String sortBy

	) {
		try {

			logger.info("Inside findTpsReportByDate() method of ReportController class");
			logger.info("user input ==> --startDate--" + startDate + "--endDate--" + endDate + "--aggregateType--"
					+ aggregateType);

			List<Object> mplaceCustcareTpsReportlst;
			Pages page = reportService.findTpsReportByDate(startDate, endDate, pageNo, pageSize, sortBy, query,
					aggregateType);
			logger.debug(page);

			if (page != null && page.getContent() != null) {
				mplaceCustcareTpsReportlst = new ArrayList<>();
				mplaceCustcareTpsReportlst.add(page);
				logger.info("Exit findTpsReportByDate() method of ReportController class");

				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, mplaceCustcareTpsReportlst, "",
						Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);
			} else {
				logger.info("Exit findTpsReportByDate() method of ReportController class");
				return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
						"Data not found", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}
		} catch (Exception exception) {
			logger.error(exception.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);

		}

	}

	@GetMapping("/custcare/tps/mplaceCustCareTpsReport.csv")
	public void downloadTpsReportByDateCsv(HttpServletResponse response,
			@RequestParam(name = "aggregateType", required = false) String aggregateType,
			@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate

	) throws IOException, ParseException {

		logger.info("Inside downloadTpsReportByDateCsv() method of ReportController class");
		logger.info("user input ==> --startDate--" + startDate + "--endDate--" + endDate + "--aggregateType--"
				+ aggregateType);
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment; file=mplaceCustCareTpsReport.csv");

		List<MplaceCustcareTpsReportVO> mplaceCustcareTpsReportlst = reportService.FindTpsReportReportCsv(startDate,
				endDate, aggregateType);
		logger.debug(mplaceCustcareTpsReportlst);
		if (mplaceCustcareTpsReportlst != null) {
			CsvUtility.downloadTpsReportReportCsv(response.getWriter(), mplaceCustcareTpsReportlst);
		}
		logger.info("Exit downloadTpsReportByDateCsv() method of ReportController class");
	}

	@GetMapping("/custcare/user/transaction/success")
	public Response findUserTransactionDetail(@RequestParam("msisdn") String msisdn,
			@RequestParam("pageNo") Integer pageNo, @RequestParam(name = "pageSize") Integer pageSize) {
		try {

			logger.info("Inside findUserTransactionDetail() method of ReportController class");
			logger.info("user input ==> --msisdn--" + msisdn + "--pageno--" + pageNo + "--pageSize--" + pageSize);

			List<Object> userTransactionlst;
			Pages page = reportService.findUserSuccedTransaction(msisdn, pageNo, pageSize);
			logger.debug("   " + page);

			if (page != null && page.getContent() != null) {
				userTransactionlst = new ArrayList<>();
				userTransactionlst.add(page);
				logger.info("Exit findUserTransactionDetail() method of ReportController class");

				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, userTransactionlst, "",
						Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);
			} else {
				logger.info("Exit findUserTransactionDetail() method of ReportController class");
				return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
						"Data not found", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}
		} catch (Exception exception) {
			logger.error(exception.toString());
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}
	}

@GetMapping("/custcare/user/succed/mplaceCustCareUserTransaction.csv")
public void downloadUserSuccedTransactionCsv(HttpServletResponse response,
		@RequestParam(name="msisdn")String msisdn) throws IOException, ParseException {

	logger.info("Inside downloadUserSuccedTransactionCsv() method of ReportController class");
	logger.info("user input ==> --msisdn--" + msisdn);
	response.setContentType("text/csv");
	response.setHeader("Content-Disposition", "attachment; file=mplaceCustCareUserTransaction.csv");

	List<TransactionCdr>     transactionCdrSuccedlst = reportService.FindUserSuccedTransactionCsv(msisdn);
	logger.debug(transactionCdrSuccedlst);
	if (transactionCdrSuccedlst != null) {
		CsvUtility.downloadUserSuccedTransactionCsv(response.getWriter(), transactionCdrSuccedlst);
	}
	logger.info("Exit downloadUserSuccedTransactionCsv() method of ReportController class");
    }


@GetMapping("/custcare/user/all/transaction")
public Response findUserAllTransactionDetail(@RequestParam("msisdn") String msisdn,
		@RequestParam("pageNo") Integer pageNo, @RequestParam(name = "pageSize") Integer pageSize) {
	try {

		logger.info("Inside findAllUserTransactionDetail() method of ReportController class");
		logger.info("user input ==> --msisdn--" + msisdn+ "--pageno--" + pageNo + "--pageSize--" + pageSize);

		List<Object> userAllTransactionlst;
		Pages page = reportService.findUserAllTransaction(msisdn, pageNo, pageSize);
		logger.debug("   " + page);

		if (page != null && page.getContent() != null) {
			userAllTransactionlst = new ArrayList<>();
			userAllTransactionlst.add(page);
			logger.info("Exit findAllUserTransactionDetail() method of ReportController class");

			return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, userAllTransactionlst, "",
					Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);
		} else {
			logger.info("Exit findAllUserTransactionDetail() method of ReportController class");
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					"Data not found", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}
	} catch (Exception exception) {
		logger.error(exception.toString());
		
		exception.printStackTrace();
		return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
				exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
	}
		}

@GetMapping("/custcare/user/all/mplaceCustCareUserallTransaction.csv")
public void downloadUserAllTransactionCsv(HttpServletResponse response,
		@RequestParam(name="msisdn")String msisdn) throws IOException, ParseException {

	logger.info("Inside downloadUserAllTransactionCsv() method of ReportController class");
	logger.info("user input ==> --msisdn--" + msisdn);
	response.setContentType("text/csv");
	response.setHeader("Content-Disposition", "attachment; file=mplaceCustCareUserAllTransaction.csv");

	List<ChargingLogs>     chargingTransactionlst = reportService.FindUserAllTransactionCsv(msisdn);
	logger.debug(chargingTransactionlst);
	if (chargingTransactionlst != null) {
		CsvUtility.downloadUserAllTransactionCsv(response.getWriter(), chargingTransactionlst);
	}
	logger.info("Exit downloadUserAllTransactionCsv() method of ReportController class");
    }


}


