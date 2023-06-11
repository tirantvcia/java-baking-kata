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
		Double amount = Double.valueOf(500);
		List<Transaction> transactions = Arrays.asList(new Transaction("25/02/2022", amount));
		statementPrinter.print(transactions);
		verify(console).log(HEADER);
		verify(console).log("25/02/2022 | 500.00 | 500.00");
		
	}
	@Test
	void printsStatmentAccountIncludingMultipleTransactionsThroughoutConsole() {
		StatementPrinter statementPrinter = new StatementPrinter(console);
		
		List<Transaction> transactions = Arrays.asList(
				new Transaction("25/02/2022", Double.valueOf(500)), 
				new Transaction("26/02/2022", Double.valueOf(500)),
				new Transaction("27/02/2022", Double.valueOf(-200)));
		statementPrinter.print(transactions);
		verify(console).log(HEADER);
		verify(console).log("27/02/2022 | -200.00 | 800.00");
		verify(console).log("26/02/2022 | 500.00 | 1000.00");
		verify(console).log("25/02/2022 | 500.00 | 500.00");
		
	}
}
