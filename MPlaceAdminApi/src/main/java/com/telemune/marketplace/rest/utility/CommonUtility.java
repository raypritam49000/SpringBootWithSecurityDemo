package com.telemune.marketplace.rest.utility;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CommonUtility {

	public static Date stingDateConvertToSqlDate(String convertdate) throws ParseException {

		SimpleDateFormat pattern = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = pattern.parse(convertdate);
		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
		return sqlStartDate;
	}

	public static String timestampConvertWithDateTime(Timestamp convertdate) throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy HH:mm:ss");

		Date date = new Date(convertdate.getTime());

		return dateFormat.format(date);

	}

	public static String timestampConvertWithDateTimeHours(Timestamp convertdate) throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy HH");

		Date date = new Date(convertdate.getTime());

		return dateFormat.format(date);

	}

	public static String timestampConvertToDate(Timestamp convertdate) throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy");

		Date date = new Date(convertdate.getTime());

		return dateFormat.format(date);

	}

	public static Date stingDateConvertToSqlDateTime(String convertdate) throws ParseException {

		SimpleDateFormat pattern = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		java.util.Date date = pattern.parse(convertdate);
		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
		return sqlStartDate;
	}

}
