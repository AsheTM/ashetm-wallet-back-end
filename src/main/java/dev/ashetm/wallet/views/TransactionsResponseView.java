package dev.ashetm.wallet.views;

import java.time.LocalDate;
import java.util.List;

import dev.ashetm.wallet.entities.Transaction;

public class TransactionsResponseView implements ResponseView {
	
	private List<Transaction> transactions;
	
	private LocalDate now = LocalDate.now();

	public TransactionsResponseView() {
	}

	public TransactionsResponseView(List<Transaction> transactions) {
		super();
		this.transactions = transactions;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	public static List<Transaction> to(TransactionsResponseView transactionsResponseView) {
		return transactionsResponseView.getTransactions();
	}
	
	public static TransactionsResponseView from(List<Transaction> transaction) {
		return new TransactionsResponseView(transaction);
	}

}
