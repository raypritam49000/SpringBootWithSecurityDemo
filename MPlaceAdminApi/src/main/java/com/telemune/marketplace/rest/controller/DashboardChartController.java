package com.telemune.marketplace.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telemune.marketplace.rest.common.Constants;
import com.telemune.marketplace.rest.common.Response;
import com.telemune.marketplace.rest.entity.vo.MplaceCustCareRetentionReportVO;
import com.telemune.marketplace.rest.service.IDashboardChartService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/charts")
public class DashboardChartController {

	@Autowired
	IDashboardChartService dashboardChartService;

	private static final Logger logger = Logger.getLogger(DashboardChartController.class);

	@GetMapping("/monthly/product/rentation/data")
	public Response findIDashboardChartReportByDate() {
		try {
			logger.info("Inside findIDashboardChartReportByDatC() method of DashboardChartController class");

			List<MplaceCustCareRetentionReportVO> retentionReportVOlst;
			List<MplaceCustCareRetentionReportVO> retentionReportVOlst1;
			List<Object[]> productPurchaseVOlst;
			List<String> productlst;

			logger.info("Calling getGarphDataUniqueCall() method of dashboardChartServiceImpl class");
			retentionReportVOlst = dashboardChartService.getGarphDataUniqueCallMonthly();
			logger.debug(retentionReportVOlst.toString());

			logger.info("Calling getGarphPackagePurchaseData() method of dashboardChartServiceImpl class");
			productPurchaseVOlst = dashboardChartService.getGarphPackagePurchaseData();
			logger.debug(productPurchaseVOlst.toString());

			logger.info("Calling getGarphDataUniquCallDaily()"
					+ " method of dashboardChartServiceImpl class");
			retentionReportVOlst1 = dashboardChartService.getGarphDataUniqueCallDaily();
			logger.debug(retentionReportVOlst1.toString());

			logger.info("Calling productPurchaseProductName() method of dashboardChartServiceImpl  class");
			productlst = dashboardChartService.productPurchaseProductName();
			logger.debug(productlst.toString());

			if (productPurchaseVOlst != null && !productPurchaseVOlst.isEmpty() && retentionReportVOlst != null
					&& !retentionReportVOlst.isEmpty()) {
				List<Object> allDatalst = new ArrayList<Object>();

				allDatalst.add(retentionReportVOlst);
				allDatalst.add(productPurchaseVOlst);
				allDatalst.add(retentionReportVOlst1);
				allDatalst.add(productlst);
				
				logger.info(allDatalst.toString());

				logger.info("Exit findIDashboardChartReportByDate() method of DashboardChartController class");

				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, allDatalst, "",
						Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);
			} else {
				logger.info("Exit findIDashboardChartReportByDate method of DashboardChartController class");
				return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
						"Data not found", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}
		} catch (Exception exception) {

			logger.info("Exception in  findIDashboardChartReportByDate() of  DashboardChartController class ==> "
					+ exception.toString());
			exception.printStackTrace();
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);

		}

	}

}
