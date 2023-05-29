package com.testingsostenible.curso;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BakingKataApplicationTests {


	@Spy
	private Console consoleSpy;

	private Account account;

	@BeforeEach
	void setUp() {
		account = new Account();
	}

	@Test
	void printsAccountStatementWithTransactionsThroughoutConsole() {

		account.deposit(1000);
		account.withdraw(500);
		account.deposit(2000);

		account.printStatement();

		Mockito.verify(consoleSpy).log("Date | Amount | Balance");
		Mockito.verify(consoleSpy).log("14/01/2022 | 2000 | 2500");
		Mockito.verify(consoleSpy).log("13/01/2022 | -500 | 500");
		Mockito.verify(consoleSpy).log("10/01/2022 | 1000 | 1000");
	}


}
