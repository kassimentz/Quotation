package utils;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static String checkWorkingDays(String quotation) {
		String validDate = "";
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date date = formatter.parse(quotation);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			
			if(isWeekend(calendar)) {
				if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
					calendar.add(Calendar.DAY_OF_MONTH, -2);
				} else {
					calendar.add(Calendar.DAY_OF_MONTH, -1);
				}
				
				Date newDate = calendar.getTime();
				SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
				validDate = ft.format(newDate);
				
			} else  {
				validDate = quotation;
			}			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return validDate;

	}

	private static Boolean isWeekend(Calendar calendar) {
		if((calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) || (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

}
