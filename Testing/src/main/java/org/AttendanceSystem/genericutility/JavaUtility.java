package org.AttendanceSystem.genericutility;

import java.util.Random;

public class JavaUtility {
	/**
	 * this method is used to get the randomnumber
	 * @return
	 */
	public int randomnumber() {
		Random randomnumber = new Random();
		return randomnumber.nextInt(1000);
	}

}
