package com.testingsostenible.curso;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClockTest {

	@Test
	void getsTodayInCorrectSpanishDateFormat() {
		TestableClock clock = new TestableClock("25/03/2022");
		String date = clock.todayAsString();
		assertTrue("25/03/2022".equals(date));
	}

}
