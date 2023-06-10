package com.testingsostenible.curso;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class TransactionRepositoryTest {

	@Test
	void storesDepositTransactionForGivenAmout() {
		
		String today = "25/03/2022";
		int amount = 100;
		Clock clock = mock(Clock.class);
		
		when(clock.todayAsString()).thenReturn(today);
		TransactionRepository repository = new TransactionRepository(clock);
		repository.addDeposit(amount);
		List<Transaction> transactions = repository.allTransactions();
		
		assertTrue(new Transaction(today, amount).equals(transactions.get(0)));
	}

}
