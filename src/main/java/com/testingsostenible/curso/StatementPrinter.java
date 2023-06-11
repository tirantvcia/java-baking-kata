package com.testingsostenible.curso;

import java.util.List;

public class StatementPrinter {

	Console console = null;
	public StatementPrinter(Console console) {
		this.console = console;
	}

	public void print(List<Transaction> list) {
		console.log("Date | Amount | Balance");
	}

}
