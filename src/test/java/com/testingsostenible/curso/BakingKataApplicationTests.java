package com.testingsostenible.curso;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BakingKataApplicationTests {


	private Console consoleSpy;
    private TransactionRepository addDepositSpy;
    private StatementPrinter printer;
	
	private Account account = null;
	private Clock clock;

	@BeforeEach
	public void init () {
		clock = new Clock();
		consoleSpy = mock(Console.class);
		printer = new StatementPrinter(consoleSpy);
		
		addDepositSpy = new TransactionRepository(clock);
		account = new Account(addDepositSpy, printer);

	}

	@Test
	void printsAccountStatementWithTransactionsThroughoutConsole() {

		account.deposit(1000);
		account.withdraw(500);
		account.deposit(2000);

		account.printStatement();

		verify(consoleSpy).log("Date | Amount | Balance");
		verify(consoleSpy).log("14/01/2022 | 2000 | 2500");
		verify(consoleSpy).log("13/01/2022 | -500 | 500");
		verify(consoleSpy).log("10/01/2022 | 1000 | 1000");
	}


}
