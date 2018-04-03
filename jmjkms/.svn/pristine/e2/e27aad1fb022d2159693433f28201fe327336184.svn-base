package com.jmjk.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	private static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private static final String DEFAULT_FORMAT1 = "yyyy-MM-dd HH:mm:ss.SSS";
	private static final String DEFAULT_FORMAT2 = "yyyy-MM-dd HH:mm";

	private DateUtil() {
	}

	public static Date str2Date(String str, String format) {
		if (null != str && !"".equals(str)) {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Date date = null;
			try {
				date = sdf.parse(str);
				return date;
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static String date2Str(Date date, String format) {
		if (null != date && !"".equals(date)) {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		}
		return null;
	}

	public static String timestamp2Str(Timestamp time) {
		if (null != time && !"".equals(time)) {
			Date date = new Date(time.getTime());
			return date2Str(date, DEFAULT_FORMAT);
		}
		return null;
	}

	public static Timestamp str2Timestamp(String str) {
		if (null != str && !"".equals(str)) {
			Date date = str2Date(str, DEFAULT_FORMAT);
			return new Timestamp(date.getTime());
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		String tm = "2011-01-01 10:03:40";
		Timestamp tstamp = str2Timestamp(tm);
		
		//System.out.println(tstamp);
		//System.out.println(timestamp2Str(tstamp));
		//System.out.println(timestamp2Str(null));
		System.out.println(str2Timestamp(tm));
		
		System.out.println(timestamp2Str(tstamp));
	}
}
