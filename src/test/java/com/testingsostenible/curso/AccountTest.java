package com.testingsostenible.curso;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class AccountTest {
	
    private TransactionRepository addDepositSpy;
	private Account account;
	private StatementPrinter statementPrinter;
	
	@BeforeEach
	public void init () {
		statementPrinter = mock(StatementPrinter.class);
		addDepositSpy = mock(TransactionRepository.class);
		account = new Account(addDepositSpy, statementPrinter);
	}

	@Test
    void storesDepositTransactionThroughoutRepository() {
		account.deposit(100);
    	verify(addDepositSpy).addDeposit(100.00);
    }
	
	@Test
    void storesWithdrawalTransactionThroughoutRepository() {
		account.withdraw(100);
    	verify(addDepositSpy).addWithdrawal(100.00);
    }
	
	@Test
    void printsStamentThroughoutStamentPrinter() {
		List<Transaction> transactions = Arrays.asList(new Transaction(), new Transaction());
		when(addDepositSpy.allTransactions()).thenReturn(transactions);
		account.printStatement();
    	verify(statementPrinter).print(transactions);
    }	
}
