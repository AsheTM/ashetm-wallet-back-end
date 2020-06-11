package dev.ashetm.wallet.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dev.ashetm.wallet.enums.CardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Getter
@Builder
@AllArgsConstructor
public class Card implements Serializable {
	
	private static int counter = 0;
	
	{ counter++; }
	
	private int id = -1;
	
	@Setter
	private BigDecimal balance = BigDecimal.valueOf(0.0);
	
	@Setter
	private CardType type;
	
	@Setter
	private boolean isActivate = false;
	
	private List<Transaction> transactions = new ArrayList<>();
	
	private LocalDate date = LocalDate.now();

	public Card() {
		this.id = counter;
	}

	public Card(BigDecimal balance, CardType type) {
		this.id = counter;
		this.balance = balance;
		this.type = type;
	}

	public Card(BigDecimal balance, CardType type, List<Transaction> transactions) {
		this.id = counter;
		this.balance = balance;
		this.type = type;
		this.transactions = transactions;
	}

	public Card(BigDecimal balance, CardType type, boolean isActivate, List<Transaction> transactions) {
		this.id = counter;
		this.balance = balance;
		this.type = type;
		this.isActivate = isActivate;
		this.transactions = transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
		for(Transaction transaction: transactions) {
			this.balance.add(transaction.getAmount());
		}
	}

//	public void setTransactions(Transaction... transactions) {
//		for(Transaction transaction: transactions) {
//			this.transactions.add(transaction);
//			this.balance.add(transaction.getAmount());
//		}
//	}
	
	@Override
	public String toString() {
		if(this.equals(null)) {
			return "The Account does not exist";
		}
		return "- Id: " + this.getId() + "\n" + "- Balance: " + this.getBalance() + "\n" + "- Transactions: " + this.getTransactions().size() + " transactions";
	}

}
