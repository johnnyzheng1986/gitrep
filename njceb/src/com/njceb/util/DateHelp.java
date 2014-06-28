package com.njceb.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelp {
	
	public static String getNextDay(String currentDate, String format){
		try {
			SimpleDateFormat sdf =  new SimpleDateFormat(format);
			Date d = sdf.parse(currentDate);
	        Calendar c = Calendar.getInstance();
	        c.setTime(d);
	        c.add(Calendar.DATE, 1);
	        Date date = c.getTime();
	        return sdf.format(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
