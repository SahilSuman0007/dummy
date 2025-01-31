package practice;

import java.util.Date;

public class ToSystemDateAndTime {

	public static void main(String[] args) {

		Date d = new Date();
		System.out.println(d);
		
		
		String Date[] = d.toString().split(" ");
		String day = Date[0];
		String month = Date[1];
		String date1 = Date[2];
		String time = Date[3].replace(":", "-");
		String year = Date[5];
		String actualDate = day + " " + month + " " + date1 + " " + time + " " + year;
		System.out.println(actualDate);

	}

}
