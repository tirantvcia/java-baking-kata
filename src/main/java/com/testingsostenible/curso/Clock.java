package com.testingsostenible.curso;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Clock {

	public String todayAsString() {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime date = today();
		return date.format(dateFormatter);
	}

	protected LocalDateTime today() {
		return LocalDateTime.now();
	}

}
