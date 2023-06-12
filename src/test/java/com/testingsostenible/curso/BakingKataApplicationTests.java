package com.testingsostenible.curso;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BakingKataApplicationTests {


	private Console consoleSpy;
    private TransactionRepository addDepositSpy;
    private StatementPrinter printer;
	
	private Account account = null;
	private Clock clock;
	@Captor
	ArgumentCaptor<String> lineTransactionCaptor;

	@BeforeEach
	public void init () {
		clock = mock(Clock.class);
		consoleSpy = mock(Console.class);
		printer = new StatementPrinter(consoleSpy);
		
		addDepositSpy = new TransactionRepository(clock);
		account = new Account(addDepositSpy, printer);

	}

	@Test
	void printsAccountStatementWithTransactionsThroughoutConsole() {

		when(clock.todayAsString()).thenReturn("10/01/2022", "13/01/2022", "14/01/2022");
		account.deposit(1000);
		account.withdraw(500);
		account.deposit(2000);

		account.printStatement();

		verify(consoleSpy, times(4)).log(lineTransactionCaptor.capture());
		List<String> linesCaptured = lineTransactionCaptor.getAllValues();
		assertTrue("Date | Amount | Balance".equals(linesCaptured.get(0)));
		assertEquals("14/01/2022 | 2000.00 | 2500.00", linesCaptured.get(1));
		assertTrue("13/01/2022 | -500.00 | 500.00".equals(linesCaptured.get(2)));
		assertTrue("10/01/2022 | 1000.00 | 1000.00".equals(linesCaptured.get(3)));
	}


}
