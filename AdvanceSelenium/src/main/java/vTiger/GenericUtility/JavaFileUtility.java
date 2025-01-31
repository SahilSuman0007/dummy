package vTiger.GenericUtility;

import java.util.Date;
import java.util.Random;

/**
 * This class consist of method related to java
 */

public class JavaFileUtility {

	/**
	 * This method is used to generate random number
	 * 
	 * @return
	 */
	public int toGetRandomNumber() {

		Random r = new Random();
		int random = r.nextInt(1000);
		return random;

	}

	public String togetSystemDateandTime() {
		Date d = new Date();
		System.out.println(d);

		String Date[] = d.toString().split(" ");
		String day = Date[0];
		String month = Date[1];
		String date1 = Date[2];
		String time = Date[3].replace(":", "-");
		String year = Date[5];
		String actualDate = day + " " + month + " " + date1 + " " + time + " " + year;
		return actualDate;

	}

}
