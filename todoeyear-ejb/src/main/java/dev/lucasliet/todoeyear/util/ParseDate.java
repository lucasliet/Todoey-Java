package dev.lucasliet.todoeyear.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;

public class ParseDate {
	public static Calendar parseData(String data) {
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar;
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}
}
