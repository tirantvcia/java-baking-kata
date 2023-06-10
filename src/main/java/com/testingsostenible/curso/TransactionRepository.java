package com.testingsostenible.curso;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository  {
	
	private Clock clock;
	List<Transaction> transactions;

	public TransactionRepository(Clock clock) {
		this.clock = clock;
		this.transactions = new ArrayList<>();
	}

	public void addDeposit(int amount) {
		Transaction transaction = new Transaction(clock.todayAsString(), amount);
		transactions.add(transaction);
	}

	public void addWithdrawal(int amount) {
		Transaction transaction = new Transaction(clock.todayAsString(), -amount);
		transactions.add(transaction);
	}

	public List<Transaction> allTransactions() {
		return transactions;
		
	}

}
