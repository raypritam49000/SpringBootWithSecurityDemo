package com.telemune.marketplace.rest.service.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.telemune.marketplace.rest.common.Pages;
import com.telemune.marketplace.rest.entity.ChargingLogs;
import com.telemune.marketplace.rest.entity.MplaceCustCareCdrReport;
import com.telemune.marketplace.rest.entity.MplaceCustcareRetentionReport;
import com.telemune.marketplace.rest.entity.MplaceCustcareTpsReport;
import com.telemune.marketplace.rest.entity.PackAlertAnalytics;
import com.telemune.marketplace.rest.entity.PackagesPurchaseReport;
import com.telemune.marketplace.rest.entity.RevenueReport;
import com.telemune.marketplace.rest.entity.TransactionCdr;
import com.telemune.marketplace.rest.entity.vo.MplaceCustCareCdrReportVO;
import com.telemune.marketplace.rest.entity.vo.MplaceCustCareRetentionReportVO;
import com.telemune.marketplace.rest.entity.vo.MplaceCustCareTotalUsageReportVO;
import com.telemune.marketplace.rest.entity.vo.MplaceCustcareTpsReportVO;
import com.telemune.marketplace.rest.entity.vo.PackAlertAnalyticsVO;
import com.telemune.marketplace.rest.entity.vo.PackagesPurchaseReportVO;
import com.telemune.marketplace.rest.entity.vo.RevenueReportVO;
import com.telemune.marketplace.rest.repository.ChargingLogsRepository;
import com.telemune.marketplace.rest.repository.IPackAlertAnalyticsRepository;
import com.telemune.marketplace.rest.repository.IRevenueRepository;
import com.telemune.marketplace.rest.repository.MplaceCustCareCdrReportRepository;
import com.telemune.marketplace.rest.repository.MplaceCustCareProductPurchaseReportRepository;
import com.telemune.marketplace.rest.repository.MplaceCustCareTotalUsageReportRepository;
import com.telemune.marketplace.rest.repository.MplaceCustCareTpsReportRepository;
import com.telemune.marketplace.rest.repository.MplaceCustcareRetentionReportRepository;
import com.telemune.marketplace.rest.repository.ProductPurchaseReportRepository;
import com.telemune.marketplace.rest.repository.ReportRepository;
import com.telemune.marketplace.rest.repository.TransactionCdrRepository;
import com.telemune.marketplace.rest.service.IReportService;
import com.telemune.marketplace.rest.utility.CommonUtility;

@Service
public class ReportServicelmpl implements IReportService {

	@Autowired
	ReportRepository reportRepository;

	@Autowired
	IRevenueRepository revenueRepository;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	TransactionCdrRepository transactionCdrRepository;
	
	@Autowired
	ChargingLogsRepository chargingLogsRepository;
	

	@Autowired
	MplaceCustCareCdrReportRepository mplaceCustCareCdrReportRepository;

	@Autowired
	ProductPurchaseReportRepository productPurchaseReportRepository;

	@Autowired
	IPackAlertAnalyticsRepository packAlertAnalyticsRepository;

	@Autowired
	MplaceCustCareTotalUsageReportRepository mplaceCustCareTotalUsageReportRepository;

	@Autowired
	MplaceCustcareRetentionReportRepository mplaceCustcareRetentionReportRepository;

	@Autowired
	MplaceCustCareTpsReportRepository mplaceCustcareTpsReportRepository;

	@Autowired
	MplaceCustCareProductPurchaseReportRepository mplaceCustCareProductPurchaseReportRepository;

	private static final Logger logger = Logger.getLogger(IReportService.class);

	private List<PackagesPurchaseReportVO> packagesPurchaseReportVoLst;

	private List<PackAlertAnalyticsVO> packAlertAnalyticsVOlst;

	private List<RevenueReportVO> revenueReportVOLst;

	private List<MplaceCustCareCdrReportVO> mplaceCustCareCdrReportlst;

	private List<Object[]> productPurchaseReportlst;

	private List<MplaceCustCareTotalUsageReportVO> mplaceCustCareTotalUsageReportlst;

	private List<MplaceCustCareRetentionReportVO> mplaceCustcareRetentionReportlst;

	private List<MplaceCustcareTpsReportVO> mplaceCustcareTpsReportlst;

	@Override
	public Pages findPackPurhaseByDateAndShortCode(String startDate, String endDate, List<Integer> packList,
			String shortCode, Integer pageNo, Integer pageSize, String sortBy, String query) throws ParseException {

		logger.info("Inside findPackPurhaseByDateAndShortCode() method of ReportServicelmpl class");

		try {
			Pageable paging = PageRequest.of(pageNo, pageSize);

			packagesPurchaseReportVoLst = null;

			packagesPurchaseReportVoLst = new ArrayList<>();

			Page<PackagesPurchaseReport> pagedResult = null;

			Date startDateInFormat = CommonUtility.stingDateConvertToSqlDateTime(startDate + " 00:00:00");
			Date endDateInFormat = CommonUtility.stingDateConvertToSqlDateTime(endDate + " 23:59:59");
			String fShortCode = shortCode + "#";

			if ((packList.isEmpty() && shortCode.equals("-1"))) {

				pagedResult = reportRepository.findByPackagesPurchaseReportIdsReportDateBetween(startDateInFormat,
						endDateInFormat, paging);

			}

			else if (!packList.isEmpty()) {

				if (!(shortCode.equals("-1"))) {

					pagedResult = reportRepository
							.findByPackagesPurchaseReportIdsShortCodeAndPackagesPurchaseReportIdsProductCodeInAndPackagesPurchaseReportIdsReportDateBetween(
									fShortCode, packList, startDateInFormat, endDateInFormat, paging);
				} else {

					pagedResult = reportRepository
							.findByPackagesPurchaseReportIdsProductCodeInAndPackagesPurchaseReportIdsReportDateBetween(
									packList, startDateInFormat, endDateInFormat, paging);
				}

			} else {

				pagedResult = reportRepository
						.findByPackagesPurchaseReportIdsShortCodeAndPackagesPurchaseReportIdsReportDateBetween(
								fShortCode, startDateInFormat, endDateInFormat, paging);
			}

			if (pagedResult.hasContent()) {

				Pages pages = new Pages();
				pages.setTotalElements(pagedResult.getTotalElements());
				pages.setTotalPages(pagedResult.getTotalPages());

				for (PackagesPurchaseReport ppr : pagedResult.getContent()) {
					PackagesPurchaseReportVO packagesPurchaseReportVO = new PackagesPurchaseReportVO();
					packagesPurchaseReportVO.setProductName(ppr.getProductName());
					packagesPurchaseReportVO.setTotalCount(ppr.getTotalCount());
					packagesPurchaseReportVO.setProductCode(ppr.getPackagesPurchaseReportIds().getProductCode());
					packagesPurchaseReportVO.setTotalAmount(ppr.getTotalAmount() != null ? ppr.getTotalAmount() : 0);
					packagesPurchaseReportVO.setShortCode(ppr.getPackagesPurchaseReportIds().getShortCode());
					packagesPurchaseReportVO.setReportDate(ppr.getPackagesPurchaseReportIds().getReportDate());

					packagesPurchaseReportVoLst.add(packagesPurchaseReportVO);

				}
				pages.setContent(packagesPurchaseReportVoLst);
				logger.info("Exit findPackPurhaseByDateAndShortCode() method of ReportServicelmpl class");
				return pages;

			}
		} catch (Exception ex) {
			ex.printStackTrace();

		}
		logger.info("Exit findPackPurhaseByDateAndShortCode() method of ReportServicelmpl class");
		return new Pages();

	}

	@Override
	public List<PackagesPurchaseReportVO> csvFiledateForDownload(String startDate, String endDate,
			List<Integer> packList, String shortCode) {

		logger.info("Inside csvFiledateForDownload() method of ReportServicelmpl class");

		try {
			List<PackagesPurchaseReport> packagesPurchaseReportlst = null;
			packagesPurchaseReportVoLst = new ArrayList<>();

			Date startDateInFormat = CommonUtility.stingDateConvertToSqlDate(startDate);
			Date endDateInFormat = CommonUtility.stingDateConvertToSqlDate(endDate);
			String fShortCode = shortCode + "#";

			if ((packList.isEmpty() && shortCode.equals("-1"))) {

				packagesPurchaseReportlst = reportRepository
						.findByPackagesPurchaseReportIdsReportDateBetween(startDateInFormat, endDateInFormat);

			}

			else if (!packList.isEmpty()) {

				if (!(shortCode.equals("-1"))) {

					packagesPurchaseReportlst = reportRepository
							.findByPackagesPurchaseReportIdsShortCodeAndPackagesPurchaseReportIdsProductCodeInAndPackagesPurchaseReportIdsReportDateBetween(
									fShortCode, packList, startDateInFormat, endDateInFormat);
				} else {

					packagesPurchaseReportlst = reportRepository
							.findByPackagesPurchaseReportIdsProductCodeInAndPackagesPurchaseReportIdsReportDateBetween(
									packList, startDateInFormat, endDateInFormat);
				}

			} else {

				packagesPurchaseReportlst = reportRepository
						.findByPackagesPurchaseReportIdsShortCodeAndPackagesPurchaseReportIdsReportDateBetween(
								fShortCode, startDateInFormat, endDateInFormat);

			}

			if (packagesPurchaseReportlst != null) {

				for (PackagesPurchaseReport ppr : packagesPurchaseReportlst) {
					PackagesPurchaseReportVO packagesPurchaseReportVO = new PackagesPurchaseReportVO();

					packagesPurchaseReportVO.setProductName(ppr.getProductName());
					packagesPurchaseReportVO.setTotalCount(ppr.getTotalCount());
					packagesPurchaseReportVO.setProductCode(ppr.getPackagesPurchaseReportIds().getProductCode());
					packagesPurchaseReportVO.setTotalAmount(ppr.getTotalAmount() != null ? ppr.getTotalAmount() : 0);
					packagesPurchaseReportVO.setShortCode(ppr.getPackagesPurchaseReportIds().getShortCode());
					packagesPurchaseReportVO.setReportDate(ppr.getPackagesPurchaseReportIds().getReportDate());

					packagesPurchaseReportVoLst.add(packagesPurchaseReportVO);

				}
				logger.debug(packagesPurchaseReportVoLst);
				logger.info("Exit csvFiledateForDownload() method of ReportServicelmpl class");
				return packagesPurchaseReportVoLst;

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error(ex.toString());

		}
		logger.info("Exit csvFiledateForDownload() method of ReportServicelmpl class");
		return new ArrayList<>();

	}

	@Override
	public Pages findRevenueByDateAndRequestType(String startDate, String endDate, Integer requestType, Integer pageNo,
			Integer pageSize, String sortBy, String query, String aggregateType) throws ParseException {
		// TODO Auto-generated method stub
		try {

			logger.info("Inside findRevenueByDateAndRequestType() method of ReportServicelmpl class");

			Pageable paging = PageRequest.of(pageNo, pageSize);

			Page<RevenueReport> pagedResultNotAggregate = null;
			Page<Object[]> pagedResultAggregate = null;
			Page<Object[]> pagedResultAggregateNotReqType = null;
			revenueReportVOLst = new ArrayList<>();

			Pages pages = new Pages();

			Date startDateInFormat = CommonUtility.stingDateConvertToSqlDate(startDate);
			Date endDateInFormat = CommonUtility.stingDateConvertToSqlDate(endDate);

			Timestamp startDateInTimSta = new Timestamp(startDateInFormat.getTime());

			Timestamp endDateInTimSta = new Timestamp(endDateInFormat.getTime());
			
			if (requestType == -1 && aggregateType.equalsIgnoreCase("-1")) {

				pagedResultNotAggregate = revenueRepository.findByRevenueReportIdsReportDateBetween(startDateInTimSta,
						endDateInTimSta, paging);

			}

			else if (requestType != -1) {

				if (!(aggregateType.equalsIgnoreCase("-1"))) {
					if (aggregateType.equalsIgnoreCase("D")) {
						pagedResultAggregate = revenueRepository.findByRevenueReportWithDaysDateAndRequestType(
								startDateInTimSta, endDateInTimSta, requestType, paging);

					} else if (aggregateType.equalsIgnoreCase("M")) {
						pagedResultAggregate = revenueRepository.findByRevenueReportWithMonthlyDateAndRequestType(
								startDateInTimSta, endDateInTimSta, requestType, paging);

					} else if (aggregateType.equalsIgnoreCase("Y")) {
						pagedResultAggregate = revenueRepository.findByRevenueReportWithYearlyDateAndRequestType(
								startDateInTimSta, endDateInTimSta, requestType, paging);

					}
					 else if (aggregateType.equalsIgnoreCase("H")) {
							pagedResultAggregate = revenueRepository.findByRevenueReportWithHourlyDateAndRequestType(
									startDateInTimSta, endDateInTimSta, requestType, paging);

						}
                             
				} else {
					pagedResultNotAggregate = revenueRepository.findByRevenueReportIdsRequestTypeAndRevenueReportIdsReportDateBetween(requestType,
							startDateInTimSta, endDateInTimSta, paging);
				}
			}

			else {

				if (aggregateType.equalsIgnoreCase("D")) {
					pagedResultAggregateNotReqType = revenueRepository
								.findByRevenueReportWithDaysDate(startDateInTimSta, endDateInTimSta, paging);

				} else if (aggregateType.equalsIgnoreCase("M")) {
					pagedResultAggregateNotReqType = revenueRepository
							.findByRevenueReportWithMonthlyDate(startDateInTimSta, endDateInTimSta, paging);

				} else if (aggregateType.equalsIgnoreCase("Y")) {
					pagedResultAggregateNotReqType = revenueRepository
							.findByRevenueReportWithYearlyDate(startDateInTimSta, endDateInTimSta, paging);

				}
				else if (aggregateType.equalsIgnoreCase("H")) {
					pagedResultAggregateNotReqType = revenueRepository
							.findByRevenueReportWithHourlyDate(startDateInTimSta, endDateInTimSta, paging);

				}

			}

			if (pagedResultNotAggregate != null && pagedResultNotAggregate.hasContent()) {

				logger.debug(pagedResultNotAggregate);

				pages.setTotalElements(pagedResultNotAggregate.getTotalElements());
				pages.setTotalPages(pagedResultNotAggregate.getTotalPages());

				List<RevenueReport> revenueReportLst = pagedResultNotAggregate.getContent();

				for (RevenueReport rp : revenueReportLst) {
					RevenueReportVO revenueReportVO = new RevenueReportVO();
					revenueReportVO
							.setChargeAmount(String.valueOf(rp.getChargeAmount() != null ? rp.getChargeAmount() : 1));
					revenueReportVO.setChargeCount((String.valueOf(rp.getChargeCount())));
					revenueReportVO.setRequestName(rp.getRevenueReportIds().getRequestName());
					revenueReportVO.setReportDate((String.valueOf(rp.getRevenueReportIds().getReportDate())));
					revenueReportVO.setRequestType(rp.getRevenueReportIds().getRequestType());
					revenueReportVO.setServiceCharge(String.valueOf(rp.getRevenueReportIds().getServiceCharge()));

					revenueReportVOLst.add(revenueReportVO);

				}
			}

			else if (pagedResultAggregate != null && pagedResultAggregate.hasContent()) {

				logger.debug(pagedResultAggregate);

				pages.setTotalElements(pagedResultAggregate.getTotalElements());
				pages.setTotalPages(pagedResultAggregate.getTotalPages());

				List<Object[]> revenueReportLst = pagedResultAggregate.getContent();

				for (Object[] revenueReport : revenueReportLst) {

					RevenueReportVO revenueReportVO = new RevenueReportVO();
					revenueReportVO.setRequestType(revenueReport[0] != null ? (int) revenueReport[0] : 1);
					revenueReportVO.setRequestName(revenueReport[1] != null ? String.valueOf(revenueReport[1]) : "");
					revenueReportVO.setChargeCount(revenueReport[2] != null ? String.valueOf(revenueReport[2]) : "");
					revenueReportVO.setChargeAmount(revenueReport[3] != null ? String.valueOf(revenueReport[3]) : "");
					revenueReportVO.setReportDate(revenueReport[4] != null ? String.valueOf(revenueReport[4]) : "");
					revenueReportVOLst.add(revenueReportVO);

				}
			}

			else if (pagedResultAggregateNotReqType != null && pagedResultAggregateNotReqType.hasContent()) {

				logger.debug(pagedResultAggregateNotReqType);

				pages.setTotalElements(pagedResultAggregateNotReqType.getTotalElements());
				pages.setTotalPages(pagedResultAggregateNotReqType.getTotalPages());
				revenueReportVOLst = new ArrayList<>();

				List<Object[]> revenueReportLst = pagedResultAggregateNotReqType.getContent();

				for (Object[] revenueReport : revenueReportLst) {
					RevenueReportVO revenueReportVO = new RevenueReportVO();
					revenueReportVO.setRequestType(revenueReport[0] != null ? (int) revenueReport[0] : 1);
					revenueReportVO.setRequestName(revenueReport[1] != null ? String.valueOf(revenueReport[1]) : "");
					revenueReportVO.setChargeCount(revenueReport[2] != null ? String.valueOf(revenueReport[2]) : "");
					revenueReportVO.setChargeAmount(revenueReport[3] != null ? String.valueOf(revenueReport[3]) : "");
					revenueReportVO.setReportDate(revenueReport[4] != null ? String.valueOf(revenueReport[4]) : "");
					revenueReportVOLst.add(revenueReportVO);

				}
			}

			pages.setContent(revenueReportVOLst);
			logger.info("Exit findRevenueByDateAndRequestType() method of ReportServicelmpl class");
			return pages;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		logger.info("Exit findRevenueByDateAndRequestType() method of ReportServicelmpl class");
		return new Pages();

	}

	@Override
	public List<RevenueReportVO> revenueCsvFiledateForDownload(String startDate, String endDate, Integer requestType,
			String aggregateType) {

		logger.info("Inside revenueCsvFiledateForDownload() method of ReportServicelmpl class");

		try {
			List<RevenueReport> revenueReportNotAggregate = null;
			List<Object[]> revenueReportAggregate = null;
			List<Object[]> revenueReportAggregateNotReqType = null;
			revenueReportVOLst = new ArrayList<>();

			Date startDateInFormat = CommonUtility.stingDateConvertToSqlDate(startDate);
			Date endDateInFormat = CommonUtility.stingDateConvertToSqlDate(endDate);
			
			Timestamp startDateInTimSta = new Timestamp(startDateInFormat.getTime());

			Timestamp endDateInTimSta = new Timestamp(endDateInFormat.getTime());
			
			if (requestType == -1 && aggregateType.equalsIgnoreCase("-1")) {

				revenueReportNotAggregate = revenueRepository.findByRevenueReportIdsReportDateBetween(startDateInTimSta,
						endDateInTimSta);

			}

			else if (requestType != -1) {

				if (!(aggregateType.equalsIgnoreCase("-1"))) {
					if (aggregateType.equalsIgnoreCase("D")) {
						revenueReportAggregate = revenueRepository
								.findByRevenueReportWithDaysDateAndRequestTypeWithOutPage(startDateInTimSta,
										endDateInTimSta, requestType);

					} else if (aggregateType.equalsIgnoreCase("M")) {
						revenueReportAggregate = revenueRepository
								.findByRevenueReportWithMonthlyDateAndRequestTypeWithOutPage(startDateInTimSta,
										endDateInTimSta, requestType);

					} else if (aggregateType.equalsIgnoreCase("Y")) {
						revenueReportAggregate = revenueRepository
								.findByRevenueReportWithYearlyDateAndRequestTypeWithOutPage(startDateInTimSta,
										endDateInTimSta, requestType);

					} else if (aggregateType.equalsIgnoreCase("H")) {
						revenueReportAggregate = revenueRepository
								.findByRevenueReportWithHourlyDateAndRequestTypeWithOutPage(startDateInTimSta,
										endDateInTimSta, requestType);

					}

				} else {
					revenueReportNotAggregate = revenueRepository
							.findByRevenueReportIdsRequestTypeAndRevenueReportIdsReportDateBetween(requestType,
									startDateInTimSta, endDateInTimSta);

				}

			}

			else {

				if (aggregateType.equalsIgnoreCase("D")) {
					revenueReportAggregateNotReqType = revenueRepository
							.findByRevenueReportWithDaysDateWithOutPage(startDateInTimSta, endDateInTimSta);

				} else if (aggregateType.equalsIgnoreCase("M")) {
					revenueReportAggregateNotReqType = revenueRepository
							.findByRevenueReportWithMonthlyDateWithOutPage(startDateInTimSta, endDateInTimSta);

				} else if (aggregateType.equalsIgnoreCase("Y")) {
					revenueReportAggregateNotReqType = revenueRepository
							.findByRevenueReportWithYearlyDateWithOutPage(startDateInTimSta, endDateInTimSta);
				}else if (aggregateType.equalsIgnoreCase("H")) {
					revenueReportAggregateNotReqType = revenueRepository
							.findByRevenueReportWithHourlyDateWithOutPage(startDateInTimSta, endDateInTimSta);
				}
			}

			if (revenueReportNotAggregate != null) {

				logger.debug(revenueReportNotAggregate);

				for (RevenueReport rp : revenueReportNotAggregate) {
					RevenueReportVO revenueReportVO = new RevenueReportVO();
					revenueReportVO
							.setChargeAmount(String.valueOf(rp.getChargeAmount() != null ? rp.getChargeAmount() : 1));
					revenueReportVO.setChargeCount((String.valueOf(rp.getChargeCount())));
					revenueReportVO.setReportDate((String.valueOf(rp.getRevenueReportIds().getReportDate())));
					revenueReportVO.setRequestType(rp.getRevenueReportIds().getRequestType());
					revenueReportVO.setServiceCharge(String.valueOf(rp.getRevenueReportIds().getServiceCharge()));

					revenueReportVOLst.add(revenueReportVO);

				}
			}

			else if (revenueReportAggregate != null) {

				logger.debug(revenueReportAggregate);

				for (Object[] revenueReport : revenueReportAggregate) {

					RevenueReportVO revenueReportVO = new RevenueReportVO();
					revenueReportVO.setRequestType(revenueReport[0] != null ? (int) revenueReport[0] : 1);
					revenueReportVO.setRequestName(revenueReport[1] != null ? String.valueOf(revenueReport[1]) : "");
					revenueReportVO.setChargeCount(revenueReport[2] != null ? String.valueOf(revenueReport[2]) : "");
					revenueReportVO.setChargeAmount(revenueReport[3] != null ? String.valueOf(revenueReport[3]) : "");
					revenueReportVO.setReportDate(revenueReport[4] != null ? String.valueOf(revenueReport[4]) : "");
					revenueReportVOLst.add(revenueReportVO);

				}
			}

			else if (revenueReportAggregateNotReqType != null) {

				logger.debug(revenueReportAggregateNotReqType);

				for (Object[] revenueReport : revenueReportAggregateNotReqType) {

					RevenueReportVO revenueReportVO = new RevenueReportVO();
					revenueReportVO.setRequestType(revenueReport[0] != null ? (int) revenueReport[0] : 1);
					revenueReportVO.setRequestName(revenueReport[1] != null ? String.valueOf(revenueReport[1]) : "");
					revenueReportVO.setChargeCount(revenueReport[2] != null ? String.valueOf(revenueReport[2]) : "");
					revenueReportVO.setChargeAmount(revenueReport[3] != null ? String.valueOf(revenueReport[3]) : "");
					revenueReportVO.setReportDate(revenueReport[4] != null ? String.valueOf(revenueReport[4]) : "");

					revenueReportVOLst.add(revenueReportVO);

				}
			}
			logger.info("Exit revenueCsvFiledateForDownload() method of ReportServicelmpl class");
			return revenueReportVOLst;

		} catch (

		Exception ex) {
			ex.printStackTrace();

		}
		logger.info("Exit revenueCsvFiledateForDownload() method of ReportServicelmpl class");
		return new ArrayList<>();
	}

	@Override
	public List<RevenueReportVO> findAllRequestType() {

		logger.info("Inside findAllRequestType() method of ReportServicelmpl class");

		try {
			List<Object[]> revenueReportlst = null;

			revenueReportVOLst = new ArrayList<>();

			revenueReportlst = revenueRepository.findDistinctRequestTypeAndRequestType();

			if (revenueReportlst != null) {

				for (Object[] rp : revenueReportlst) {
					RevenueReportVO revenueReportVO = new RevenueReportVO();

					revenueReportVO.setRequestType((int) rp[0]);
					revenueReportVO.setRequestName(String.valueOf(rp[1]));

					revenueReportVOLst.add(revenueReportVO);

				}
				logger.info("Exit findAllRequestType() method of ReportServicelmpl class");
				return revenueReportVOLst;
			}
		} catch (

		Exception ex) {
			ex.printStackTrace();
			logger.error(ex.toString());

		}
		logger.info("Exit findAllRequestType() method of ReportServicelmpl class");
		return new ArrayList<>();
	}

	@Override
	public Pages findPackAlertByDate(String startDate, String endDate, Integer pageNo, Integer pageSize, String sortBy,
			String query) throws ParseException {

		logger.info("Inside findPackAlertByDate() method of ReportServicelmpl class");
		Pageable paging = PageRequest.of(pageNo, pageSize);

		Page<PackAlertAnalytics> pagedResult = null;

		Pages pages = new Pages();

		Date startDateInFormat = CommonUtility.stingDateConvertToSqlDate(startDate);
		Date endDateInFormat = CommonUtility.stingDateConvertToSqlDate(endDate);

		pagedResult = packAlertAnalyticsRepository.findByPackAlertAnalyticsIdsAlertDateBetween(startDateInFormat,
				endDateInFormat, paging);

		if (pagedResult != null && pagedResult.hasContent()) {
			pages.setTotalElements(pagedResult.getTotalElements());
			pages.setTotalPages(pagedResult.getTotalPages());
			packAlertAnalyticsVOlst = new ArrayList<>();
			for (PackAlertAnalytics paa : pagedResult.getContent()) {

				PackAlertAnalyticsVO packAlertAnalyticsVO = new PackAlertAnalyticsVO();

				packAlertAnalyticsVO.setAlertDate(String.valueOf(paa.getPackAlertAnalyticsIds().getAlertDate()));
				packAlertAnalyticsVO.setAlertSent(paa.getAlertSent());
				packAlertAnalyticsVO.setPackPurchased(paa.getPackPurchased());

				packAlertAnalyticsVOlst.add(packAlertAnalyticsVO);

			}

			pages.setContent(packAlertAnalyticsVOlst);

			logger.info("Exit findPackAlertByDate() method of ReportServicelmpl class");

			return pages;

		}
		logger.info("Exit findPackAlertByDate() method of ReportServicelmpl class");
		return new Pages();

	}

	@Override
	public List<PackAlertAnalyticsVO> packAlertReprtCsv(String alertDate) {

		logger.info("Inside packAlertReprtCsv() method of ReportServicelmpl class");

		List<Object[]> packAlertAnalyticsdb = packAlertAnalyticsRepository.AlertDetail(alertDate);

		logger.debug(packAlertAnalyticsdb.toString());
		
		System.out.println("Here is the date"+alertDate);
		System.out.println("Here is the db"+packAlertAnalyticsdb);

		packAlertAnalyticsVOlst = new ArrayList<>();
		for (Object[] paa : packAlertAnalyticsdb) {	

			PackAlertAnalyticsVO packAlertAnalyticsVO = new PackAlertAnalyticsVO();

			packAlertAnalyticsVO.setMsisdn(String.valueOf(paa[0]));
			packAlertAnalyticsVO.setPackId(String.valueOf(paa[1]));
			packAlertAnalyticsVO.setAlertDate(String.valueOf(paa[2]));
			packAlertAnalyticsVO.setPackPurchasedDate(String.valueOf(paa[3]));

			packAlertAnalyticsVOlst.add(packAlertAnalyticsVO);
		}
		System.out.println("Here is the list"+packAlertAnalyticsVOlst.toString());
		logger.info("Exit packAlertReprtCsv() method of ReportServicelmpl class");
		return packAlertAnalyticsVOlst;

	}

	@Override
	public Pages findByCustCareCdrByDate(String startDate, String endDate, Integer pageNo, Integer pageSize,
			String sortBy, String query) throws ParseException {
		// TODO Auto-generated method stub

		logger.info("Inside findByCustCareCdrByDate() method of ReportServicelmpl class");
		Pageable paging = PageRequest.of(pageNo, pageSize);

		mplaceCustCareCdrReportlst = null;

		mplaceCustCareCdrReportlst = new ArrayList<>();

		Pages pages = new Pages();

		Page<MplaceCustCareCdrReport> pagedResult = null;

		Date startDateInFormat = CommonUtility.stingDateConvertToSqlDate(startDate);
		Date endDateInFormat = CommonUtility.stingDateConvertToSqlDate(endDate);

		Timestamp startDateInTimSta = new Timestamp(startDateInFormat.getTime());

		Timestamp endDateInTimSta = new Timestamp(endDateInFormat.getTime());

		pagedResult = mplaceCustCareCdrReportRepository
				.findByMplaceCustCareCdrReportIdsReportDateBetween(startDateInTimSta, endDateInTimSta, paging);

		logger.debug(pagedResult.toString());

		if (pagedResult != null && pagedResult.hasContent()) {
			pages.setTotalElements(pagedResult.getTotalElements());
			pages.setTotalPages(pagedResult.getTotalPages());

			for (MplaceCustCareCdrReport mcccr : pagedResult.getContent()) {

				MplaceCustCareCdrReportVO mcccrvo = new MplaceCustCareCdrReportVO();

				// mcccrvo.setCallDuration(mcccr.getCallDuration());
				mcccrvo.setMSISDN(mcccr.getMSISDN());
				/// mcccrvo.setReportDate(CommonUtity
				// .timestampConvertWithDateTime(mcccr.getMplaceCustCareCdrReportIds().getReportDate()));
				mplaceCustCareCdrReportlst.add(mcccrvo);

			}
			pages.setContent(mplaceCustCareCdrReportlst);
			logger.info("Exit findByCustCareCdrByDate() method of ReportServicelmpl class");
			return pages;

		}

		logger.info("Exit findByCustCareCdrByDate() method of ReportServicelmpl class");

		return new Pages();

	}

	@Override
	public List<MplaceCustCareCdrReportVO> mplaceCustCareCdrCsv(String startDate, String endDate)
			throws ParseException {
		// TODO Auto-generated metlhod stub

		logger.info("Inside mplaceCustCareCdrCsv() method of ReportServicelmpl class");

		mplaceCustCareCdrReportlst = null;

		mplaceCustCareCdrReportlst = new ArrayList<>();

		List<MplaceCustCareCdrReportVO> dblst;

		String query = "select date_format(REPORT_DATE,'%d-%m-%Y %H:%i:%s') as REPORT_DATE ,MSISDN,CALL_DURATION from mplace_custcare_cdr_report where REPORT_DATE between "
				+ "'" + startDate + " 00:00:00" + "'" + " and " + "'" + endDate + " 23:59:59" + "'";

		logger.info("Query ============================ " + query);

		dblst = jdbcTemplate.query(query,
				new BeanPropertyRowMapper<MplaceCustCareCdrReportVO>(MplaceCustCareCdrReportVO.class));

		logger.debug(dblst.toString());

		logger.info("Exit mplaceCustCareCdrCsv() method of ReportServicelmpl class");
		return dblst;

	}

	/*
	 * @Override public Pages findProductPurchaseReportByDate(String startDate,
	 * String endDate, Integer pageNo, Integer pageSize, String sortBy, String
	 * query, String aggregateType) throws ParseException { 
	 * // TODO Auto-generated
	 * method stub
	 * 
	 * Pageable paging = PageRequest.of(pageNo, pageSize);
	 * 
	 * Page<Object[]> pagedResult = null;
	 * 
	 * Pages pages = new Pages();
	 * 
	 * Date startDateInFromat = CommonUtity.stingDateConvertToSqlDate(startDate);
	 * Date endDate2InFromat = CommonUtity.stingDateConvertToSqlDate(endDate);
	 * 
	 * Timestamp startDateInTimSta = new Timestamp(startDateInFromat.getTime());
	 * 
	 * Timestamp endDateInTimSta = new Timestamp(endDate2InFromat.getTime());
	 * 
	 * if (aggregateType.equals("D")) {
	 * 
	 * pagedResult = mplaceCustCareProductPurchaseReportRepository
	 * .findByProductPurchaseReportDailyDate(startDateInTimSta, endDateInTimSta,
	 * paging);
	 * 
	 * }
	 * 
	 * else if (aggregateType.equals("M")) { pagedResult =
	 * mplaceCustCareProductPurchaseReportRepository
	 * .findByProductPurchaseReportMonthlyDate(startDateInTimSta, endDateInTimSta,
	 * paging);
	 * 
	 * }
	 * 
	 * else if (aggregateType.equals("Y")) { pagedResult =
	 * mplaceCustCareProductPurchaseReportRepository
	 * .findByProductPurchaseReportWithYearlyDate(startDateInTimSta,
	 * endDateInTimSta, paging); }
	 * 
	 * else pagedResult = mplaceCustCareProductPurchaseReportRepository
	 * .findByProductPurchaseReportWithoutAggregateTypes(startDateInTimSta,
	 * endDateInTimSta, paging);
	 * 
	 * if (pagedResult != null && pagedResult.hasContent()) {
	 * 
	 * pages.setTotalElements(pagedResult.getTotalElements());
	 * pages.setTotalPages(pagedResult.getTotalPages()); productPurchaseReportlst =
	 * new ArrayList<>();
	 * 
	 * MplaceCustCareProductPurchaseReportVO mpProductRepVO; for (Object[] ppr :
	 * pagedResult.getContent()) { mpProductRepVO = new
	 * MplaceCustCareProductPurchaseReportVO();
	 * mpProductRepVO.setProductCode(ppr[0].toString());
	 * mpProductRepVO.setProductName(ppr[1].toString());
	 * mpProductRepVO.setTotalCount(ppr[2].toString()); if
	 * (aggregateType.equals("D")) { Date dateInFromat =
	 * CommonUtity.stingDateConvertToSqlDate(ppr[3].toString()); Timestamp
	 * dateInTimSta = new Timestamp(dateInFromat.getTime());
	 * mpProductRepVO.setReportDate(CommonUtity.timestampConvertToDate(dateInTimSta)
	 * ); } else if (aggregateType.equals("M")) {
	 * mpProductRepVO.setReportDate(ppr[3].toString()); } else {
	 * mpProductRepVO.setReportDate(ppr[3].toString()); }
	 * 
	 * productPurchaseReportlst.add(mpProductRepVO);
	 * 
	 * } pages.setContent(productPurchaseReportlst);
	 * 
	 * return pages; }
	 * 
	 * return new Pages();
	 * 
	 * }
	 * 
	 * @Override public List<MplaceCustCareProductPurchaseReportVO>
	 * productPurchaseReportCsv(String startDate, String endDate, String
	 * aggregateType) throws ParseException {
	 * 
	 * List<Object[]> productPurchaseReportVOlst;
	 * 
	 * Date startDateInFromat = CommonUtity.stingDateConvertToSqlDate(startDate);
	 * Date endDate2InFromat = CommonUtity.stingDateConvertToSqlDate(endDate);
	 * 
	 * Timestamp startDateInTimSta = new Timestamp(startDateInFromat.getTime());
	 * 
	 * Timestamp endDateInTimSta = new Timestamp(endDate2InFromat.getTime());
	 * 
	 * if (aggregateType.equals("D")) {
	 * 
	 * productPurchaseReportVOlst = mplaceCustCareProductPurchaseReportRepository
	 * .findByProductPurchaseReportDailyDateWithOutPage(startDateInTimSta,
	 * endDateInTimSta);
	 * 
	 * }
	 * 
	 * else if (aggregateType.equals("M")) { productPurchaseReportVOlst =
	 * mplaceCustCareProductPurchaseReportRepository
	 * .findByProductPurchaseReportMonthlyDateWithOutPage(startDateInTimSta,
	 * endDateInTimSta);
	 * 
	 * }
	 * 
	 * else if (aggregateType.equals("Y")) { productPurchaseReportVOlst =
	 * mplaceCustCareProductPurchaseReportRepository
	 * .findByProductPurchaseReportWithYearlyDateWithOutPage(startDateInTimSta,
	 * endDateInTimSta); }
	 * 
	 * else productPurchaseReportVOlst =
	 * mplaceCustCareProductPurchaseReportRepository
	 * .findByProductPurchaseReportWithoutAggregateTypesAndPage(startDateInTimSta,
	 * endDateInTimSta);
	 * 
	 * if (productPurchaseReportVOlst != null) {
	 * 
	 * productPurchaseReportlst = new ArrayList<>();
	 * 
	 * MplaceCustCareProductPurchaseReportVO mpProductRepVO; for (Object[] ppr :
	 * productPurchaseReportVOlst) { mpProductRepVO = new
	 * MplaceCustCareProductPurchaseReportVO();
	 * mpProductRepVO.setProductCode(ppr[0].toString());
	 * mpProductRepVO.setProductName(ppr[1].toString());
	 * mpProductRepVO.setTotalCount(ppr[2].toString());
	 * 
	 * if (aggregateType.equals("D")) { Date dateInFromat =
	 * CommonUtity.stingDateConvertToSqlDate(ppr[3].toString()); Timestamp
	 * dateInTimSta = new Timestamp(dateInFromat.getTime());
	 * mpProductRepVO.setReportDate(CommonUtity.timestampConvertToDate(dateInTimSta)
	 * ); } else if (aggregateType.equals("M")) {
	 * mpProductRepVO.setReportDate(ppr[3].toString()); } else {
	 * mpProductRepVO.setReportDate(ppr[3].toString()); }
	 * 
	 * productPurchaseReportlst.add(mpProductRepVO); } }
	 * 
	 * return productPurchaseReportlst; }
	 * 
	 * 
	 * 
	 * 
	 */

	@Override
	public Pages findProductPurchaseReportByDate(String startDate, String endDate, Integer pageNo, Integer pageSize,
			String sortBy, String query, String aggregateType) throws ParseException {
		// TODO Auto-generated method stub

		logger.info("Inside findProductPurchaseReportByDate() method of ReportServicelmpl class");

		List<Object[]> pagedResult = null;

		List<Object[]> productPurchaseReportVOlst;

		Pages pages = new Pages();

		Date startDateInFormat = CommonUtility.stingDateConvertToSqlDate(startDate);
		Date endDateInFormat = CommonUtility.stingDateConvertToSqlDate(endDate);

		Timestamp startDateInTimSta = new Timestamp(startDateInFormat.getTime());

		Timestamp endDateInTimSta = new Timestamp(endDateInFormat.getTime());

		int endPage = pageSize;
		int startPage = 0;
		if (pageNo != 0) {
			++pageNo;
			endPage = (pageNo * pageSize);
			startPage = (endPage - 20);
		}
		System.out.println("end result :-- " + endPage);
		System.out.println("start result :-- " + startPage);
		pagedResult = mplaceCustCareProductPurchaseReportRepository.custcareProductPurchaseDash(startDateInTimSta,
				endDateInTimSta, startPage, endPage);

		System.out.println("Page result :--" + pagedResult);

		logger.debug(pagedResult.toString());

		List<Object[]> productPurchaseReportlst = new ArrayList<Object[]>();

		productPurchaseReportVOlst = mplaceCustCareProductPurchaseReportRepository
				.custcareProductPurchaseDash(startDateInTimSta, endDateInTimSta, 0, 100000);
		int totalElement = productPurchaseReportVOlst.size();
		int totalPage = totalElement / 20;
		pages.setTotalElements(totalElement);
		pages.setTotalPages(totalPage);
		for (int i = 0; i < pagedResult.size(); i++) {
			productPurchaseReportlst.add(pagedResult.get(i));
		}
		pages.setContent(productPurchaseReportlst);
		logger.info("Exit findProductPurchaseReportByDate() method of ReportServicelmpl class");
		return pages;

	}

	@Override
	public List<Object[]> productPurchaseReportCsv(String startDate, String endDate, String aggregateType)
			throws ParseException {

		logger.info("Inside productPurchaseReportCsv() method of ReportServicelmpl class");

		@SuppressWarnings("unused")
		List<Object[]> productPurchaseReportlst;

		Date startDateInFromat = CommonUtility.stingDateConvertToSqlDate(startDate);
		Date endDate2InFromat = CommonUtility.stingDateConvertToSqlDate(endDate);

		Timestamp startDateInTimSta = new Timestamp(startDateInFromat.getTime());

		Timestamp endDateInTimSta = new Timestamp(endDate2InFromat.getTime());

		int startDateLimit = 1;
		int endDateLimit = 10000;

		return productPurchaseReportlst = mplaceCustCareProductPurchaseReportRepository
				.custcareProductPurchaseDash(startDateInTimSta, endDateInTimSta, startDateLimit, endDateLimit);

	}

	@Override
	public List<String> productPurchaseProductName(String startDate, String endDate, String aggregateType)
			throws ParseException {

		logger.info("Inside productPurchaseProductName() method of ReportServicelmpl class");

		List<String> productPurchaseReportVOlst;

		Date startDateInFromat = CommonUtility.stingDateConvertToSqlDate(startDate);
		Date endDate2InFromat = CommonUtility.stingDateConvertToSqlDate(endDate);

		Timestamp startDateInTimSta = new Timestamp(startDateInFromat.getTime());

		Timestamp endDateInTimSta = new Timestamp(endDate2InFromat.getTime());

		productPurchaseReportVOlst = mplaceCustCareProductPurchaseReportRepository
				.findDistinctProductName(startDateInTimSta, endDateInTimSta);

		logger.debug(productPurchaseReportVOlst.toString());

		productPurchaseReportVOlst.add(0, "reportDate");
		logger.info("Exit productPurchaseProductName() method of ReportServicelmpl class");
		return productPurchaseReportVOlst;
	}

	@Override
	public Pages findMplaceCustCareTotalUsageReportByDate(String startDate, String endDate, Integer pageNo,
			Integer pageSize, String sortBy, String query, String aggregateType) throws ParseException {
		// TODO Auto-generated method stub

		logger.info("Inside findMplaceCustCareTotalUsageReportByDate() method of ReportServicelmpl class");

		Pageable paging = PageRequest.of(pageNo, pageSize);

		Page<Object[]> pagedResult = null;

		Pages pages = new Pages();

		Date startDateInFromat = CommonUtility.stingDateConvertToSqlDate(startDate);
		Date endDate2InFromat = CommonUtility.stingDateConvertToSqlDate(endDate);

		Timestamp startDateInTimSta = new Timestamp(startDateInFromat.getTime());

		Timestamp endDateInTimSta = new Timestamp(endDate2InFromat.getTime());

		if (aggregateType.equals("D")) {
			pagedResult = mplaceCustCareTotalUsageReportRepository
					.findByMplaceCustCareTotalUsageReportDailyDate(startDateInTimSta, endDateInTimSta, paging);

		}

		else if (aggregateType.equals("M")) {
			pagedResult = mplaceCustCareTotalUsageReportRepository
					.findByProductMplaceCustCareTotalUsageReportMonthlyDate(startDateInTimSta, endDateInTimSta, paging);

		} else if (aggregateType.equals("Y")) {

			pagedResult = mplaceCustCareTotalUsageReportRepository
					.findByMplaceCustCareTotalUsageReportWithYearlyDate(startDateInTimSta, endDateInTimSta, paging);

		} else {
			pagedResult = mplaceCustCareTotalUsageReportRepository
					.findByMplaceCustCareTotalUsageReportWithoutAggregateTypes(startDateInTimSta, endDateInTimSta,
							paging);

		}

		logger.debug(pagedResult.toString());

		if (pagedResult != null && pagedResult.hasContent()) {
			pages.setTotalElements(pagedResult.getTotalElements());
			pages.setTotalPages(pagedResult.getTotalPages());
			mplaceCustCareTotalUsageReportlst = new ArrayList<>();
			MplaceCustCareTotalUsageReportVO mcctur = null;
			for (Object[] omcctur : pagedResult.getContent()) {
				mcctur = new MplaceCustCareTotalUsageReportVO();
				mcctur.setTotalCallsCount(Integer.valueOf(omcctur[0].toString()));
				mcctur.setTotalCallDurationInMintes(Float.valueOf(omcctur[1].toString()));
				if (aggregateType.equals("D")) {
					mcctur.setReportDate(omcctur[2].toString());
				} else if (aggregateType.equals("M")) {
					mcctur.setReportDate(omcctur[2].toString());
				} else if (aggregateType.equals("Y")) {
					mcctur.setReportDate(omcctur[2].toString());
				} else {
					mcctur.setReportDate(omcctur[2].toString());

				}
				mplaceCustCareTotalUsageReportlst.add(mcctur);

			}
			pages.setContent(mplaceCustCareTotalUsageReportlst);
			logger.info("Exit findMplaceCustCareTotalUsageReportByDate() method of ReportServicelmpl class");
			return pages;

		}
		logger.info("Exit findMplaceCustCareTotalUsageReportByDate() method of ReportServicelmpl class");

		return new Pages();
	}

	@Override
	public List<MplaceCustCareTotalUsageReportVO> FindMplaceCustCareTotalUsageReportCsv(String startDate,
			String endDate, String aggregateType) throws ParseException {

		logger.info("Inside FindMplaceCustCareTotalUsageReportCsv() method of ReportServicelmpl class");

		Date startDateInFormat = CommonUtility.stingDateConvertToSqlDate(startDate);
		Date endDateInFormat = CommonUtility.stingDateConvertToSqlDate(endDate);

		Timestamp startDateInTimSta = new Timestamp(startDateInFormat.getTime());

		Timestamp endDateInTimSta = new Timestamp(endDateInFormat.getTime());

		List<Object[]> result = null;

		if (aggregateType.equals("D")) {

			result = mplaceCustCareTotalUsageReportRepository
					.findByMplaceCustCareTotalUsageReportDailyDateWithOutPage(startDateInTimSta, endDateInTimSta);

		} else if (aggregateType.equals("M")) {
			result = mplaceCustCareTotalUsageReportRepository
					.findByMplaceCustCareTotalUsageReportMonthlyDateWithOutPage(startDateInTimSta, endDateInTimSta);

		} else if (aggregateType.equals("Y")) {

			result = mplaceCustCareTotalUsageReportRepository
					.findByMplaceCustCareTotalUsageReportWithYearlyDateWithOutPage(startDateInTimSta, endDateInTimSta);

		} else {
			result = mplaceCustCareTotalUsageReportRepository
					.findByMplaceCustCareTotalUsageReportWithoutAggregateTypesAndPage(startDateInTimSta,
							endDateInTimSta);

		}
		logger.debug(result.toString());

		if (result != null) {

			mplaceCustCareTotalUsageReportlst = new ArrayList<>();
			MplaceCustCareTotalUsageReportVO mcctur = null;
			for (Object[] omcctur : result) {
				mcctur = new MplaceCustCareTotalUsageReportVO();
				mcctur.setTotalCallsCount(Integer.valueOf(omcctur[0].toString()));
				mcctur.setTotalCallDurationInMintes(Float.valueOf(omcctur[1].toString()));
				if (aggregateType.equals("D")) {
					mcctur.setReportDate(omcctur[2].toString());
				} else if (aggregateType.equals("M")) {
					mcctur.setReportDate(omcctur[2].toString());
				} else if (aggregateType.equals("Y")) {
					mcctur.setReportDate(omcctur[2].toString());
				} else {
					mcctur.setReportDate(omcctur[2].toString());

				}

				mplaceCustCareTotalUsageReportlst.add(mcctur);
				logger.info("Exit FindMplaceCustCareTotalUsageReportCsv() method of ReportServicelmpl class");
			}
		}
		logger.info("Exit FindMplaceCustCareTotalUsageReportCsv() method of ReportServicelmpl class");
		return mplaceCustCareTotalUsageReportlst;
	}

	@Override
	public Pages findRetentionReportByDate(String startDate, String endDate, Integer pageNo, Integer pageSize,
			String sortBy, String query) throws ParseException {

		logger.info("Inside findRetentionReportByDate() method of ReportServicelmpl class");

		Pageable paging = PageRequest.of(pageNo, pageSize);

		Page<MplaceCustcareRetentionReport> pagedResult = null;

		Pages pages = new Pages();

		Date startDateInFormat = CommonUtility.stingDateConvertToSqlDate(startDate);
		Date endDateInFormat = CommonUtility.stingDateConvertToSqlDate(endDate);

		Timestamp startDateInTimSta = new Timestamp(startDateInFormat.getTime());

		Timestamp endDateInTimSta = new Timestamp(endDateInFormat.getTime());

		pagedResult = mplaceCustcareRetentionReportRepository
				.findByMplaceCustCareRetentionReportIdsReportDateBetween(startDateInTimSta, endDateInTimSta, paging);

		logger.debug(pagedResult);

		if (pagedResult != null && pagedResult.hasContent()) {
			pages.setTotalElements(pagedResult.getTotalElements());
			pages.setTotalPages(pagedResult.getTotalPages());
			mplaceCustcareRetentionReportlst = new ArrayList<>();

			MplaceCustCareRetentionReportVO mre;
			for (MplaceCustcareRetentionReport mredb : pagedResult.getContent()) {
				mre = new MplaceCustCareRetentionReportVO();
				mre.setReportDate(CommonUtility
						.timestampConvertToDate(mredb.getMplaceCustCareRetentionReportIds().getReportDate()));
				mre.setCallBackCounts(mredb.getCallBackCounts());
				mre.setCallBackPercentage(mredb.getCallBackPercentage());
				mre.setTotalCallsCount(mredb.getTotalCallsCount());
				mre.setTotalUniqueCallCount(mredb.getTotalUniqueCallCount());

				mplaceCustcareRetentionReportlst.add(mre);

			}

			pages.setContent(mplaceCustcareRetentionReportlst);

			logger.info("Exit findRetentionReportByDate() method of ReportServicelmpl class");

			return pages;

		}

		logger.info("Exit findRetentionReportByDate() method of ReportServicelmpl class");
		return new Pages();

	}

	@Override
	public List<MplaceCustCareRetentionReportVO> FindMplaceCustcareRetentionReportReportCsv(String startDate,
			String endDate) throws ParseException {

		logger.info("Inside FindMplaceCustcareRetentionReportReportCsv() method of ReportServicelmpl class");

		Date startDateInFormat = CommonUtility.stingDateConvertToSqlDate(startDate);
		Date endDateInFormat = CommonUtility.stingDateConvertToSqlDate(endDate);

		Timestamp startDateInTimSta = new Timestamp(startDateInFormat.getTime());

		Timestamp endDateInTimSta = new Timestamp(endDateInFormat.getTime());

		List<MplaceCustcareRetentionReport> mccrrlst;

		mccrrlst = mplaceCustcareRetentionReportRepository
				.findByMplaceCustCareRetentionReportIdsReportDateBetween(startDateInTimSta, endDateInTimSta);

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
		logger.info("Exit FindMplaceCustcareRetentionReportReportCsv() method of ReportServicelmpl class");
		return mplaceCustcareRetentionReportlst;

	}

	@Override
	public Pages findTpsReportByDate(String startDate, String endDate, Integer pageNo, Integer pageSize, String sortBy,
			String query, String aggregateType) throws ParseException {

		logger.info("Inside findTpsReportByDate() method of ReportServicelmpl class");

		Pageable paging = PageRequest.of(pageNo, pageSize);

		Page<MplaceCustcareTpsReport> pagedResult = null;

		Pages pages = new Pages();

		Date startDateInFormat = CommonUtility.stingDateConvertToSqlDate(startDate);
		Date endDateInFormat = CommonUtility.stingDateConvertToSqlDate(endDate);

		Timestamp startDateInTimSta = new Timestamp(startDateInFormat.getTime());

		Timestamp endDateInTimSta = new Timestamp(endDateInFormat.getTime());

		pagedResult = mplaceCustcareTpsReportRepository
				.findByMplaceCustcareTpsReportIdsReportDateBetween(startDateInTimSta, endDateInTimSta, paging);
		logger.debug(pagedResult.toString());

		if (pagedResult != null && pagedResult.hasContent()) {
			pages.setTotalElements(pagedResult.getTotalElements());
			pages.setTotalPages(pagedResult.getTotalPages());
			mplaceCustcareTpsReportlst = new ArrayList<>();

			MplaceCustcareTpsReportVO mctrvo = null;
			for (MplaceCustcareTpsReport mctr : pagedResult.getContent()) {

				mctrvo = new MplaceCustcareTpsReportVO();
				mctrvo.setTotalCallsPerHour(mctr.getTotalCallsPerHour());
				mctrvo.setReportDate(

						CommonUtility
								.timestampConvertWithDateTime(mctr.getMplaceCustcareTpsReportIds().getReportDate()));

				mplaceCustcareTpsReportlst.add(mctrvo);
			}

			pages.setContent(mplaceCustcareTpsReportlst);

			logger.info("Exit findTpsReportByDate() method of ReportServicelmpl class");

			return pages;

		}

		logger.info("Exit findTpsReportByDate() method of ReportServicelmpl class");
		return new Pages();

	}

	@Override
	public List<MplaceCustcareTpsReportVO> FindTpsReportReportCsv(String startDate, String endDate,
			String aggregateType) throws ParseException {

		logger.info("Inside FindTpsReportReportCsv() method of ReportServicelmpl class");

		Date startDateInFormat = CommonUtility.stingDateConvertToSqlDate(startDate);
		Date endDateInFormat = CommonUtility.stingDateConvertToSqlDate(endDate);

		Timestamp startDateInTimSta = new Timestamp(startDateInFormat.getTime());

		Timestamp endDateInTimSta = new Timestamp(endDateInFormat.getTime());

		List<MplaceCustcareTpsReport> mpCustCareTpslLst;

		List<MplaceCustcareTpsReportVO> mpCustCareTpslLVOst = new ArrayList<MplaceCustcareTpsReportVO>();

		MplaceCustcareTpsReportVO mpctrVO = null;

		mpCustCareTpslLst = mplaceCustcareTpsReportRepository
				.findByMplaceCustcareTpsReportIdsReportDateBetween(startDateInTimSta, endDateInTimSta);

		logger.debug(mpCustCareTpslLst.toString());

		for (MplaceCustcareTpsReport mcctr : mpCustCareTpslLst) {
			mpctrVO = new MplaceCustcareTpsReportVO();
			mpctrVO.setReportDate(
					CommonUtility.timestampConvertWithDateTime(mcctr.getMplaceCustcareTpsReportIds().getReportDate()));
			mpctrVO.setTotalCallsPerHour(mcctr.getTotalCallsPerHour());
			mpCustCareTpslLVOst.add(mpctrVO);

		}

		logger.info("Exit FindTpsReportReportCsv() method of ReportServicelmpl class");
		return mpCustCareTpslLVOst;

	}

	@Override
	public Pages findUserSuccedTransaction(String msisdn, Integer pageNo, Integer pageSize) throws ParseException {
		// TODO Auto-generated method stub
		logger.info("Inside findUserSuccedTransaction() method of ReportServicelmpl class");

		Pageable paging = PageRequest.of(pageNo, pageSize);

		Page<TransactionCdr> pagedResult = null;

		Pages pages = new Pages();

		pagedResult = transactionCdrRepository.findByMsisdn(msisdn, paging);
		logger.debug(pagedResult.toString());

		if (pagedResult != null && pagedResult.hasContent()) {
			pages.setTotalElements(pagedResult.getTotalElements());
			pages.setTotalPages(pagedResult.getTotalPages());

			if (pagedResult.hasContent()) {

				pages.setContent(pagedResult.getContent());
			}

			logger.info("Exit findUserSuccedTransaction() method of ReportServicelmpl class");

			return pages;

		}

		logger.info("Exit findUserSuccedTransaction() method of ReportServicelmpl class");
		return new Pages();

	}
	
	@Override
	public List<TransactionCdr> FindUserSuccedTransactionCsv(String msisdn) {

		logger.info("Inside findUserSuccedTransaction() method of ReportServicelmpl class");

		List<TransactionCdr> transactionList = new ArrayList<TransactionCdr>();

		transactionList = transactionCdrRepository.findByMsisdn(msisdn);

		logger.debug("Here is the list" + transactionList.toString());

		logger.info("Exit findUserSuccedTransaction() method of ReportServicelmpl class");

		return transactionList;

	}

	@Override
	public Pages findUserAllTransaction(String msisdn, Integer pageNo, Integer pageSize) throws ParseException {
		// TODO Auto-generated method stub
		logger.info("Inside findUserAllTransaction() method of ReportServicelmpl class");

		Pageable paging = PageRequest.of(pageNo, pageSize);

		Page<ChargingLogs> pagedResult = null;

		Pages pages = new Pages();
		
		

		pagedResult = chargingLogsRepository.findByMsisdn(msisdn, paging);
		logger.debug(pagedResult.toString());

		if (pagedResult != null && pagedResult.hasContent()) {
			pages.setTotalElements(pagedResult.getTotalElements());
			pages.setTotalPages(pagedResult.getTotalPages());

			if (pagedResult.hasContent()) {

				pages.setContent(pagedResult.getContent());
			}

			logger.info("Exit findUserAllTransaction() method of ReportServicelmpl class");

			return pages;

		}

		logger.info("Exit findUserAllTransaction() method of ReportServicelmpl class");
		return new Pages();

	}

	@Override
	public List<ChargingLogs> FindUserAllTransactionCsv(String msisdn) {
		
			logger.info("Inside findUserAllTransaction() method of ReportServicelmpl class");

			List<ChargingLogs> chargingTransactionList = new ArrayList<ChargingLogs>();

			chargingTransactionList = chargingLogsRepository.findByMsisdn(msisdn);

			logger.debug("Here is the list" + chargingTransactionList.toString());

			logger.info("Exit findUserAllTransaction() method of ReportServicelmpl class");

			return chargingTransactionList;

		}

	}
		


