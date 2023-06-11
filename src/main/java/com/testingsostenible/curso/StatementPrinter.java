package com.testingsostenible.curso;

import java.util.Comparator;
import java.util.List;

public class StatementPrinter {

	Console console = null;
	Double runningBalance;
	public StatementPrinter(Console console) {
		this.console = console;
	}

	public void print(List<Transaction> transactions) {
		console.log("Date | Amount | Balance");
		printStatements(transactions);
		
	}

	private void printStatements(List<Transaction> transactions) {
		runningBalance = Double.valueOf(0);
		transactions.stream()
		.map(transaction -> {
			runningBalance += transaction.getAmount();
			return String.valueOf(transaction.getTodayLong()).concat("::").concat(formatStatementLine(runningBalance, transaction));
		}).sorted(Comparator.reverseOrder()).forEach(
				s -> {
					String[] splitTransactionInfo = s.split("::");
					console.log(splitTransactionInfo[1]);
				});
	}

	private String formatStatementLine(double runningBalance, Transaction transaction) {
		return String.format("%s | %.2f | %.2f", transaction.getToday(), transaction.getAmount(), runningBalance);
	}

}
