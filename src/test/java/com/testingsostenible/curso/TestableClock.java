package com.testingsostenible.curso;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestableClock extends Clock{

	String date;
	
	public TestableClock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestableClock(String date) {
		super();
		this.date = date;
	}

	@Override
	protected LocalDateTime today() {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate testDate = LocalDate.parse(date, dateFormatter);
		return testDate.atStartOfDay();
	}
	
}
