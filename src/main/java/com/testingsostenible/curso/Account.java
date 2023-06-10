package com.testingsostenible.curso;

public class Account {
	
	TransactionRepository repository;
	

	public Account(TransactionRepository repository) {
		super();
		this.repository = repository;
	}

	public void deposit(int number) {
		this.repository.addDeposit(number);
    }

    public void withdraw(int number) {
    	this.repository.addWithdrawal(number);
    }

    public void printStatement() {
    }
}
