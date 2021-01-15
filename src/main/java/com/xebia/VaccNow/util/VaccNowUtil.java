package com.xebia.VaccNow.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VaccNowUtil {

	
	private static final String format1 = "yyyy-mm-dd";
	private static final String format2 = "yyyy-mm-dd hh:mm:ss";

	
	
	public static final Date formatdate(String inputDate) throws ParseException {
		SimpleDateFormat sdfmt2= new SimpleDateFormat(format1);
		Date parseDate= sdfmt2.parse(inputDate);
		return parseDate;
	}
	
	public static final Date formatdate2(String inputDate) throws ParseException {
		SimpleDateFormat sdfmt2= new SimpleDateFormat(format2);
		Date parseDate= sdfmt2.parse(inputDate);
		return parseDate;
	}
	
}
