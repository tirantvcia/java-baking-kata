package com.testingsostenible.curso;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class AccountTest {
	
    private TransactionRepository addDepositSpy;
	private Account account;
	
	@BeforeEach
	public void init () {
		addDepositSpy = mock(TransactionRepository.class);
		account = new Account(addDepositSpy);
	}

	@Test
    void storesDepositTransactionThroughoutRepository() {
		account.deposit(100);
    	verify(addDepositSpy).addDeposit(100);
    }
	
	@Test
    void storesWithdrawalTransactionThroughoutRepository() {
		account.withdraw(100);
    	verify(addDepositSpy).addWithdrawal(100);
    }
}
