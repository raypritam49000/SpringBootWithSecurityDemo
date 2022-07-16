package com.telemune.marketplace.rest.service;

import java.text.ParseException;
import java.util.List;

import com.telemune.marketplace.rest.common.Pages;
import com.telemune.marketplace.rest.entity.ChargingLogs;
import com.telemune.marketplace.rest.entity.TransactionCdr;
import com.telemune.marketplace.rest.entity.vo.MplaceCustCareCdrReportVO;
import com.telemune.marketplace.rest.entity.vo.MplaceCustCareRetentionReportVO;
import com.telemune.marketplace.rest.entity.vo.MplaceCustCareTotalUsageReportVO;
import com.telemune.marketplace.rest.entity.vo.MplaceCustcareTpsReportVO;
import com.telemune.marketplace.rest.entity.vo.PackAlertAnalyticsVO;
import com.telemune.marketplace.rest.entity.vo.PackagesPurchaseReportVO;
import com.telemune.marketplace.rest.entity.vo.RevenueReportVO;

public interface IReportService {

	public Pages findPackPurhaseByDateAndShortCode(String startDate, String endDate, List<Integer> packList,
			String shortCode, Integer pageNo, Integer pageSize, String sortBy, String query) throws ParseException;

	public List<PackagesPurchaseReportVO> csvFiledateForDownload(String startDate, String endDate,
			List<Integer> packList, String shortCode);

	public Pages findRevenueByDateAndRequestType(String startDate, String endDate, Integer requestType, Integer pageNo,
			Integer pageSize, String sortBy, String query, String aggregateType) throws ParseException;

	public List<RevenueReportVO> revenueCsvFiledateForDownload(String startDate, String endDate, Integer requestType,
			String aggregateType);

	List<RevenueReportVO> findAllRequestType();

	public Pages findPackAlertByDate(String startDate, String endDate, Integer pageNo, Integer pageSize, String sortBy,
			String query) throws ParseException;

	public List<PackAlertAnalyticsVO> packAlertReprtCsv(String alerDate);

	public Pages findByCustCareCdrByDate(String startDate, String endDate, Integer pageNo, Integer pageSize,
			String sortBy, String query) throws ParseException;

	public List<MplaceCustCareCdrReportVO> mplaceCustCareCdrCsv(String startDate, String endDate) throws ParseException;

	public Pages findProductPurchaseReportByDate(String startDate, String endDate, Integer pageNo, Integer pageSize,
			String sortBy, String query,String aggregateType) throws ParseException;

	public List<Object[]> productPurchaseReportCsv(String startDate, String endDate,String aggregateType) throws ParseException;

	public Pages findMplaceCustCareTotalUsageReportByDate(String startDate, String endDate, Integer pageNo,
			Integer pageSize, String sortBy, String query,String aggregateType) throws ParseException;

	public List<MplaceCustCareTotalUsageReportVO> FindMplaceCustCareTotalUsageReportCsv(String startDate, String endDate,String aggregateType) throws ParseException;

	public Pages findRetentionReportByDate(String startDate, String endDate, Integer pageNo, Integer pageSize,
			String sortBy, String query) throws ParseException;

	public List<MplaceCustCareRetentionReportVO> FindMplaceCustcareRetentionReportReportCsv(String startDate,
			String endDate) throws ParseException;

	public Pages findTpsReportByDate(String startDate, String endDate, Integer pageNo, Integer pageSize, String sortBy,
			String query,String aggregateType) throws ParseException;

	public List<MplaceCustcareTpsReportVO> FindTpsReportReportCsv(String startDate, String endDate,String aggregateType) throws ParseException;

	List<String> productPurchaseProductName(String startDate, String endDate, String aggregateType)
			throws ParseException;
	
	public Pages findUserSuccedTransaction(String msisdn,Integer pageNo, Integer pageSize) throws ParseException;

	public List<TransactionCdr> FindUserSuccedTransactionCsv(String msisdn);
	
	public Pages findUserAllTransaction(String msisdn,Integer pageNo, Integer pageSize) throws ParseException;

	public List<ChargingLogs> FindUserAllTransactionCsv(String msisdn);

}
