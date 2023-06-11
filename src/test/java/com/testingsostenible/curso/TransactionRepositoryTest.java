package com.testingsostenible.curso;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TransactionRepositoryTest {

	String today;
	Clock clock;
	TransactionRepository repository;
	
	@BeforeEach
	public void init() {
		today = "25/03/2022";
		clock = mock(Clock.class);
		repository = new TransactionRepository(clock);
	}
	@Test
	void storesDepositTransactionForGivenAmout() {
		
		double amount = 100.00;
		when(clock.todayAsString()).thenReturn(today);
		
		repository.addDeposit(amount);
		List<Transaction> transactions = repository.allTransactions();
		assertTrue(new Transaction(today, amount).equals(transactions.get(0)));
	}
	@Test
	void storesWhitdrawTransactionForGivenAmout() {
		
		double amount = 100.00;
		when(clock.todayAsString()).thenReturn(today);
		repository.addWithdrawal(amount);
		List<Transaction> transactions = repository.allTransactions();
		assertTrue(new Transaction(today, -amount).equals(transactions.get(0)));
	}
}
