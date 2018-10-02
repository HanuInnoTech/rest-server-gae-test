package com.sanjeevaniehr.user.registration.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate {
	public static void main(String[] args) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		try {
			Date today = df.parse("10/12/2008");
			System.out.println("Today = " + df.format(today));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
