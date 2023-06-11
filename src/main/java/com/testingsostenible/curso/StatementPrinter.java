package com.testingsostenible.curso;

import java.util.List;

public class StatementPrinter {

	Console console = null;
	public StatementPrinter(Console console) {
		this.console = console;
	}

	public void print(List<Transaction> transactions) {
		console.log("Date | Amount | Balance");
		if(transactions.size() > 0) {
			Transaction transaction = transactions.get(0);
			console.log(String.format("%s | %.2f | %.2f", transaction.getToday(), transaction.getAmount(), transaction.getAmount()));
		}
	}

}
