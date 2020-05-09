package dev.ashetm.wallet.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {
	
	private static int counter = 0;
	
	{ counter++; }
	
	private int id = -1;
	
	private BigDecimal balance = BigDecimal.valueOf(0.0);
	
	private boolean isActivate = false;
	
	private List<Transaction> transactions = new ArrayList<>();

	public Account() {
		this.id = counter;
	}

	public Account(BigDecimal balance) {
		this.id = counter;
		this.balance = balance;
	}

	public Account(BigDecimal balance, List<Transaction> transactions) {
		this.id = counter;
		this.balance = balance;
		this.transactions = transactions;
	}

	public Account(BigDecimal balance, boolean isActivate, List<Transaction> transactions) {
		this.id = counter;
		this.balance = balance;
		this.isActivate = isActivate;
		this.transactions = transactions;
	}

	public int getId() {
		return id;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public boolean isActivate() {
		return this.isActivate;
	}

	public void setActivate(boolean isActivate) {
		this.isActivate = isActivate;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
		for(Transaction transaction: transactions) {
			this.balance.add(transaction.getAmount());
		}
	}

	public void setTransactions(Transaction... transactions) {
		for(Transaction transaction: transactions) {
			this.transactions.add(transaction);
			this.balance.add(transaction.getAmount());
		}
	}
	
	public static AccountBuilder builder() {
		return new AccountBuilder();
	}
	
	public static class AccountBuilder {
		
		private Account account = new Account();
		
		public AccountBuilder() { }
		
		public AccountBuilder(Account wallet) {
			this.account = wallet;
		}
		
		public AccountBuilder balance(BigDecimal balance) {
			this.account.setBalance(balance);
			return this;
		}
		
		public AccountBuilder activate(boolean isActivate) {
			this.account.setActivate(isActivate);
			return this;
		}
		
		public AccountBuilder transactions(List<Transaction> transactions) {
			this.account.setTransactions(transactions);
			return this;
		}
		
		public AccountBuilder transactions(Transaction... transactions) {
			this.account.setTransactions(transactions);
			return this;
		}
		
		public Account build() {
			return this.account;
		}
		
	}
	
	@Override
	public String toString() {
		if(this.equals(null)) {
			return "The Account does not exist";
		}
		return "- Id: " + this.getId() + "\n" + "- Balance: " + this.getBalance() + "\n" + "- Transactions: " + this.getTransactions().size() + " transactions";
	}

}
