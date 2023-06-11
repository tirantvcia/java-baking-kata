package com.testingsostenible.curso;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.junit.jupiter.api.Test;


class StatementPrinterTest {
	private static final String HEADER = "Date | Amount | Balance";
	Console console = mock(Console.class);
	
	@Test
	void allwaysPrintsHeaderThroughoutConsole() {
		StatementPrinter statementPrinter = new StatementPrinter(console);
		statementPrinter.print(new ArrayList<>());
		verify(console).log(HEADER);
	}
	@Test
	void printsStatmentAccountIncludingGivenTransactionThroughoutConsole() {
		StatementPrinter statementPrinter = new StatementPrinter(console);
		List<Transaction> transactions = Arrays.asList(new Transaction("25/02/2022", 500.00));
		statementPrinter.print(transactions);
		verify(console).log(HEADER);
		verify(console).log("25/02/2022 | 500.00 | 500.00");
		
	}
}
