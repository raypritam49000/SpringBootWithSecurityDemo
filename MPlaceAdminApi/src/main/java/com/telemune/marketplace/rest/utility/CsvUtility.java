package com.telemune.marketplace.rest.utility;

import java.io.PrintWriter;
import java.util.List;

import com.telemune.marketplace.rest.entity.ChargingLogs;
import com.telemune.marketplace.rest.entity.TransactionCdr;
import com.telemune.marketplace.rest.entity.vo.MplaceCustCareCdrReportVO;
import com.telemune.marketplace.rest.entity.vo.MplaceCustCareRetentionReportVO;
import com.telemune.marketplace.rest.entity.vo.MplaceCustCareTotalUsageReportVO;
import com.telemune.marketplace.rest.entity.vo.MplaceCustcareTpsReportVO;
import com.telemune.marketplace.rest.entity.vo.PackAlertAnalyticsVO;
import com.telemune.marketplace.rest.entity.vo.PackagesPurchaseReportVO;
import com.telemune.marketplace.rest.entity.vo.PromoServiceMapVO;
import com.telemune.marketplace.rest.entity.vo.RevenueReportVO;
import com.telemune.marketplace.rest.entity.vo.WhiteBlackVO;

public class CsvUtility {

	public static void downloadPackagesPurchaseReportCsv(PrintWriter writer,
			List<PackagesPurchaseReportVO> packagesPurchaseReportlst) {
		writer.write("Report Date,Short Code, Product Code , Product Name, Total Count, Total Amount\n");
		for (PackagesPurchaseReportVO pprVo : packagesPurchaseReportlst) {
			writer.write(pprVo.getReportDate() + "," + pprVo.getShortCode() + "," + pprVo.getProductCode() + ","
					+ pprVo.getProductName() + "," + pprVo.getTotalCount() + "," + pprVo.getTotalAmount() + "," + "\n");
		}

	}

	public static void downloadRevenueReportCsv(PrintWriter writer, List<RevenueReportVO> pprlst) {
		// TODO Auto-generated method stub

		writer.write("Report Date,Request Type , Service Charge , Charge Count, ChargeAmount,\n");
		for (RevenueReportVO pprVo : pprlst) {
			writer.write(pprVo.getReportDate() + "," + pprVo.getRequestType() + "," + pprVo.getServiceCharge() + ","
					+ pprVo.getChargeCount() + "," + pprVo.getChargeAmount() + "," + "\n");
		}

	}

	public static void downloadPackAlertReprtCsv(PrintWriter writer,
			List<PackAlertAnalyticsVO> packAlertAnalyticsVOlst) {

		// TODO Auto-generated method stub

		writer.write("msisdn , packId ,alertDate, packPurchasedDate\n");
		for (PackAlertAnalyticsVO pprVo : packAlertAnalyticsVOlst) {
			writer.write(pprVo.getMsisdn() + "," + pprVo.getPackId() + "," + pprVo.getAlertDate() + ","
					+ pprVo.getPackPurchasedDate() + "," + "\n");
		}

	}

	public static void downloadMplaceCustCareCdrReportCsv(PrintWriter writer,
			List<MplaceCustCareCdrReportVO> mplaceCustCareCdrReportlst) {
		// TODO Auto-generated method stub
		writer.write("reportDate , msisdn ,callDuration\n");
		for (MplaceCustCareCdrReportVO mcccr : mplaceCustCareCdrReportlst) {
			writer.write(mcccr.getReport_date() + "," + mcccr.getMSISDN() + "," + mcccr.getCall_duration() + "\n");
		}

	}

	public static void downloadProductPurchaseReportCsv(PrintWriter writer, List<Object[]> productPurchaseReportlst,
			List<String> productNamelst) {
		// TODO Auto-generated method stub

		for (String s1 : productNamelst) {
			writer.write(s1 + ",");
		}

		for (Object[] ppr : productPurchaseReportlst) {
			writer.write("\n");
			for (int i = 0; i < ppr.length; i++) {
				writer.write(ppr[i] + ",");
			}

		}
	}

	public static void downloadMplaceCustCareTotalUsageReportCsv(PrintWriter writer,
			List<MplaceCustCareTotalUsageReportVO> productPurchaseReportlst) {
		// TODO Auto-generated method stub

		writer.write("report_date , TOTAL_CALLS_COUNT ,TOTAL_CALL_DURATION_IN_MINUTES \n");
		for (MplaceCustCareTotalUsageReportVO mcctur : productPurchaseReportlst) {
			writer.write(mcctur.getReportDate() + "," + mcctur.getTotalCallDurationInMintes() + ","
					+ mcctur.getTotalCallsCount() + "," + "\n");
		}

	}

	public static void downloadFindMplaceCustcareRetentionReportReportCsv(PrintWriter writer,
			List<MplaceCustCareRetentionReportVO> mplaceCustcareRetentionReportlst) {
		// TODO Auto-generated method stub
		writer.write(
				"REPORT_DATE , TOTAL_CALLS_COUNT ,TOTAL_UNIQUE_CALL_COUNT,CALL_BACK_COUNTS,CALL_BACK_PERCENTAGE \n");
		for (MplaceCustCareRetentionReportVO mccrr : mplaceCustcareRetentionReportlst) {
			writer.write(
					mccrr.getReportDate() + "," + mccrr.getTotalCallsCount() + "," + mccrr.getTotalUniqueCallCount()
							+ "," + mccrr.getCallBackCounts() + "," + mccrr.getCallBackPercentage() + "," + "\n");
		}

	}

	public static void downloadTpsReportReportCsv(PrintWriter writer,
			List<MplaceCustcareTpsReportVO> mplaceCustcareTpsReportlst) {
		// TODO Auto-generated method stub
		writer.write("report_date ,TOTAL_CALL_DURATION_IN_HOUR \n");
		for (MplaceCustcareTpsReportVO mcctr : mplaceCustcareTpsReportlst) {
			writer.write(mcctr.getReportDate() + "," + mcctr.getTotalCallsPerHour() + "," + "\n");
		}

	}

	public static void downloadUserSuccedTransactionCsv(PrintWriter writer,
			List<TransactionCdr> transactionCdrSuccedlst) {
		// TODO Auto-generated method stub
		
		writer.write("transactionId,msisdn,createDate,productCode,serviceCharge,volume,validityDays,status,"
				+ " subType,packId,volumeType"
				+ ",validityType,shortCode ,languageId,Interface \n");
		for (TransactionCdr mcctr : transactionCdrSuccedlst) {
			writer.write(mcctr.getTransactionId()+ "," + mcctr.getMsisdn()  + "," +mcctr.getCreateDate()+ "," + mcctr.getProductCode() 
			+ "," +mcctr.getServiceCharge()+ "," + mcctr.getVolume()  + "," +mcctr.getValidityDays()+ "," 
					+ mcctr.getStatus() + "," +mcctr.getSubType()+ "," + mcctr.getPackId() + "," + mcctr.getVolumeType()+ ","
					+ mcctr.getValidityType() + "," + mcctr.getShortCode() + "," + mcctr.getLanguageId() + "," + mcctr.getInterface() + "," + "\n");
		}
		
		
		
	}

	public static void downloadUserAllTransactionCsv(PrintWriter writer,
			List<ChargingLogs> chargingLogAlllst) {
		// TODO Auto-generated method stub
		
		writer.write("msisdn,FMSISDN,createDate,type,productCode,serviceCharge,validityDays,status,"
				+ " subType,responseStatus,transactionId,packId,volumeType"
				+ ",validityType,shortCode ,languageId,userInterface\n");
		for (ChargingLogs mccl : chargingLogAlllst) {
			writer.write( mccl.getMsisdn()  + "," + mccl.getFMSISDN()+ "," +mccl.getCreateDate()+ "," + mccl.getType()+ "," + mccl.getProductCode() 
			+ "," +mccl.getServiceCharge()+ "," +mccl.getValidityDays()+ "," + mccl.getStatus() + "," +mccl.getSubType()+ "," + mccl.getReponseStatus() + ","
					+mccl.getTransactionId()+ "," + mccl.getPackId() + "," + mccl.getVolumeType()+ ","
					+ mccl.getValidityType() + "," + mccl.getShortCode() +  "," + mccl.getLanguageId() + "," + mccl.getUserInterface() + "," + "\n");
		}
		
		
		
	}

	public static void downloadWhiteBlackCsv(PrintWriter writer, List<WhiteBlackVO> wbVOlst) {
		// TODO Auto-generated method stub
			writer.write("Msisdn, Type ,CreateDate, Total Amount\n");
			for (WhiteBlackVO wblVo : wbVOlst) {
				writer.write(wblVo.getMsisdn()+ "," + wblVo.getType() + "," + wblVo.getCreateDate()  + "\n");
			}	
	}

	public static void downloadPromoServiceReportCsv(PrintWriter writer, List<PromoServiceMapVO> promoServiceMapVOlst) {
		// TODO Auto-generated method stub
		writer.write("msisdn ,scope\n");
		for (PromoServiceMapVO pprVo : promoServiceMapVOlst) {
			writer.write(pprVo.getMsisdn() + "," + pprVo.getScope() + "," + "\n");
		}
	
	
	
	
	}}
