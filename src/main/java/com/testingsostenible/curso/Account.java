package com.testingsostenible.curso;

public class Account {
	
	TransactionRepository repository;
	private StatementPrinter statementRepository;
	

	public Account(TransactionRepository repository, StatementPrinter statementRepository) {
		this.repository = repository;
		this.statementRepository = statementRepository;
	}

	public void deposit(int number) {
		this.repository.addDeposit(number);
    }

    public void withdraw(int number) {
    	this.repository.addWithdrawal(number);
    }

    public void printStatement() {
    	this.statementRepository.print(repository.allTransactions());
    }
}
