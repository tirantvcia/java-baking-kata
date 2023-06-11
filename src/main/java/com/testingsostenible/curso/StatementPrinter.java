package com.testingsostenible.curso;

import java.util.List;

public class StatementPrinter {

	Console console = null;
	public StatementPrinter(Console console) {
		this.console = console;
	}

	public void print(List<Transaction> transactions) {
		console.log("Date | Amount | Balance");
		double runningBalance = 0.0;
		if(transactions.size() > 0) {
			
			Transaction transaction = transactions.get(0);
			runningBalance += transaction.getAmount();
			console.log(formatStatementLine(runningBalance, transaction));
		}
	}

	private String formatStatementLine(double runningBalance, Transaction transaction) {
		return String.format("%s | %.2f | %.2f", transaction.getToday(), transaction.getAmount(), runningBalance);
	}

}
