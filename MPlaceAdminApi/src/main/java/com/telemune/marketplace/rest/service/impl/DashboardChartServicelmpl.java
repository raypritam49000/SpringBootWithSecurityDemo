package com.telemune.marketplace.rest.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telemune.marketplace.rest.controller.DashboardChartController;
import com.telemune.marketplace.rest.entity.MplaceCustcareRetReportCurrent;
import com.telemune.marketplace.rest.entity.MplaceCustcareRetentionReport;
import com.telemune.marketplace.rest.entity.vo.MplaceCustCareRetentionReportVO;
import com.telemune.marketplace.rest.repository.MplaceCustCareProductPurchaseReportRepository;
import com.telemune.marketplace.rest.repository.MplaceCustcareRetReportCurrentRepository;
import com.telemune.marketplace.rest.repository.MplaceCustcareRetentionReportRepository;
import com.telemune.marketplace.rest.service.IDashboardChartService;
import com.telemune.marketplace.rest.utility.CommonUtility;

@Service
public class DashboardChartServicelmpl implements IDashboardChartService {

	@Autowired
	MplaceCustcareRetentionReportRepository mplaceCustcareRetentionReportRepository;

	@Autowired
	MplaceCustcareRetReportCurrentRepository mplaceCustcareRetReportCurrentRepository;

	@Autowired
	MplaceCustCareProductPurchaseReportRepository mplaceCustCareProductPurchaseReportRepository;

	private List<MplaceCustCareRetentionReportVO> mplaceCustcareRetentionReportlst;

	private static final Logger logger = Logger.getLogger(DashboardChartController.class);

	@Override
	public List<MplaceCustCareRetentionReportVO> getGarphDataUniqueCallMonthly() throws ParseException {
		// TODO Auto-generated method stub

		logger.info("Inside getGarphDataUniquCall() method of DashboardChartServicelmpl class");

		try {
			LocalDate todayDate = LocalDate.now();
			LocalDate endDate = null;
			LocalDate startDate = null;

			int monthDay = todayDate.getDayOfMonth();

			if (monthDay == 1) {
				startDate = todayDate.minusMonths(1);
				endDate = todayDate.minusDays(1);

			} else {
				startDate = todayDate.minusDays(monthDay - 1);
				endDate = todayDate.minusDays(1);
			}

			logger.info("Garph Data Unique Call monthly startDate ==> " + startDate);
			logger.info("Garph Data Unique Call monthly endDate ==> " + endDate);

			Date startDateInFromat = CommonUtility.stingDateConvertToSqlDate(startDate.toString());
			Date endDate2InFromat = CommonUtility.stingDateConvertToSqlDate(endDate.toString());

			Timestamp startDateInTimSta = new Timestamp(startDateInFromat.getTime());

			Timestamp endDateInTimSta = new Timestamp(endDate2InFromat.getTime());

			List<MplaceCustcareRetentionReport> mccrrlst;

			mccrrlst = mplaceCustcareRetentionReportRepository
					.findByMplaceCustCareRetentionReportIdsReportDateBetween(startDateInTimSta, endDateInTimSta);

			logger.debug(mccrrlst);

			mplaceCustcareRetentionReportlst = new ArrayList<MplaceCustCareRetentionReportVO>();

			if (mccrrlst != null) {
				MplaceCustCareRetentionReportVO mre;

				for (MplaceCustcareRetentionReport mredb : mccrrlst) {
					mre = new MplaceCustCareRetentionReportVO();
					mre.setReportDate(CommonUtility
							.timestampConvertToDate(mredb.getMplaceCustCareRetentionReportIds().getReportDate()));
					mre.setCallBackCounts(mredb.getCallBackCounts());
					mre.setCallBackPercentage(mredb.getCallBackPercentage());
					mre.setTotalCallsCount(mredb.getTotalCallsCount());
					mre.setTotalUniqueCallCount(mredb.getTotalUniqueCallCount());

					mplaceCustcareRetentionReportlst.add(mre);
				}

			}
			logger.info("Exit getGarphDataUniquCall() method of DashboardChartServicelmpl class");
			return mplaceCustcareRetentionReportlst;
		} catch (Exception e) {
			logger.info("Exception ===>" + e);
		}
		return mplaceCustcareRetentionReportlst;
	}

	@Override
	public List<Object[]> getGarphPackagePurchaseData() throws ParseException {
		// TODO Auto-generated method stub

		logger.info("Inside getGarphPackagePurchaseData() method of DashboardChartServicelmpl class");

		List<Object[]> productPurchaseReportVOlst = null;
		try {
			LocalDate todayDate = LocalDate.now();
			LocalDate endDate = null;
			LocalDate startDate = null;

			int monthDay = todayDate.getDayOfMonth();

			if (monthDay == 1) {
				startDate = todayDate.minusMonths(1);
				endDate = todayDate.minusDays(1);

			} else {
				startDate = todayDate.minusDays(monthDay - 1);
				endDate = todayDate.minusDays(1);
			}

			logger.info("garph package purchase data startDate ==> " + startDate);
			logger.info("garph package purchase data endDate ==> " + endDate);

			Date startDateInFromat = CommonUtility.stingDateConvertToSqlDate(startDate.toString());
			Date endDate2InFromat = CommonUtility.stingDateConvertToSqlDate(endDate.toString());

			Timestamp startDateInTimSta = new Timestamp(startDateInFromat.getTime());

			Timestamp endDateInTimSta = new Timestamp(endDate2InFromat.getTime());

			int startElement = 0;
			int ElementLimit = 10000;

			productPurchaseReportVOlst = mplaceCustCareProductPurchaseReportRepository
					.custcareProductPurchaseDash(startDateInTimSta, endDateInTimSta, startElement,
							ElementLimit);

			logger.debug(productPurchaseReportVOlst);

			logger.info("Extt getGarphPackagePurchaseData() method of DashboardChartServicelmpl class");
			return productPurchaseReportVOlst;
		} catch (Exception e) {
			logger.info("Exception ===>" + e.toString());
		}
		return productPurchaseReportVOlst;

	}

	@Override
	public List<MplaceCustCareRetentionReportVO> getGarphDataUniqueCallDaily() throws ParseException {
		// TODO Auto-generated method stub

		try {

			logger.info("Inside getGarphDataUniqueCallDaily() method of DashboardChartServicelmpl class");
			LocalDate todayDate = LocalDate.now();

			LocalDate tomorrow = todayDate.plusDays(1);

			logger.info("Garph Data Unique Call Daily Date ==> " + todayDate);

			Date startDateInFromat = CommonUtility.stingDateConvertToSqlDate(todayDate.toString());

			Date endDateInFromat = CommonUtility.stingDateConvertToSqlDate(tomorrow.toString());

			Timestamp startDateInTimSta = new Timestamp(startDateInFromat.getTime());

			Timestamp endDateInTimSta = new Timestamp(endDateInFromat.getTime());

			List<MplaceCustcareRetReportCurrent> mccrrlst;
			mplaceCustcareRetentionReportlst = new ArrayList<MplaceCustCareRetentionReportVO>();

			mccrrlst = mplaceCustcareRetReportCurrentRepository
					.findByMplaceCustcareRetReportCurrentIdsReportDateBetween(startDateInTimSta, endDateInTimSta);

			logger.debug(mccrrlst);

			if (mccrrlst != null) {
				MplaceCustCareRetentionReportVO mre;

				for (MplaceCustcareRetReportCurrent mredb : mccrrlst) {
					mre = new MplaceCustCareRetentionReportVO();
					mre.setReportDate(CommonUtility.timestampConvertWithDateTimeHours(
							mredb.getMplaceCustcareRetReportCurrentIds().getReportDate()));
					mre.setCallBackCounts(mredb.getCallBackCounts());
					mre.setCallBackPercentage(mredb.getCallBackPercentage());
					mre.setTotalCallsCount(mredb.getTotalCallsCount());
					mre.setTotalUniqueCallCount(mredb.getTotalUniqueCallCount());

					mplaceCustcareRetentionReportlst.add(mre);
				}

			}
		} catch (Exception e) {
			logger.info("Exception ===>" + e);

		}
		logger.info("Exit getGarphDataUniqueCallDaily() method of DashboardChartServicelmpl class");
		return mplaceCustcareRetentionReportlst;

	}

	@Override
	public List<String> productPurchaseProductName() throws ParseException {

		List<String> productPurchaseReportVOlst = null;

		try {

			logger.info("Inside productPurchaseProductName() method of DashboardChartServicelmpl class");

			// TODO Auto-generated method stub

			LocalDate todayDate = LocalDate.now();
			LocalDate endDate = null;
			LocalDate startDate = null;

			int monthDay = todayDate.getDayOfMonth();

			if (monthDay == 1) {
				startDate = todayDate.minusMonths(1);
				endDate = todayDate.minusDays(1);

			} else {
				startDate = todayDate.minusDays(monthDay - 1);
				endDate = todayDate.minusDays(1);
			}

			logger.info("product purchase product name startDate ==> " + startDate);
			logger.info("product purchase product name  endDate ==> " + endDate);

			Date startDateInFromat = CommonUtility.stingDateConvertToSqlDate(startDate.toString());
			Date endDate2InFromat = CommonUtility.stingDateConvertToSqlDate(endDate.toString());

			Timestamp startDateInTimSta = new Timestamp(startDateInFromat.getTime());

			Timestamp endDateInTimSta = new Timestamp(endDate2InFromat.getTime());

			productPurchaseReportVOlst = mplaceCustCareProductPurchaseReportRepository
					.findDistinctProductName(startDateInTimSta, endDateInTimSta);

			logger.debug(productPurchaseReportVOlst);

			if (productPurchaseReportVOlst != null) {

				productPurchaseReportVOlst.add(0, "reportDate");

				logger.info("Exit productPurchaseProductName() method of DashboardChartServicelmpl class");

				return productPurchaseReportVOlst;
			}
		} catch (Exception e) {
			logger.info("Exception ===>" + e);

		}

		return productPurchaseReportVOlst;

	}

}
