package com.testingsostenible.curso;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

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

}
