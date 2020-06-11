package dev.ashetm.wallet.processes;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import dev.ashetm.wallet.entities.Card;
import dev.ashetm.wallet.entities.Transaction;

@Component
public class WalletProcessImpl implements WalletProcess {

	@Override
	public Card withdraw(Card card, Transaction transaction) {
		BigDecimal amount = transaction.getAmount();
		BigDecimal result = amount.abs().multiply(BigDecimal.valueOf(-1));
		transaction.setAmount(result);
		card.getTransactions().add(transaction);
		
		BigDecimal money = card.getBalance();
		money.add(result);
		card.setBalance(money);
		
		return card;
	}

	@Override
	public Card deposit(Card card, Transaction transaction) {
		BigDecimal amount = transaction.getAmount();
		BigDecimal result = amount.abs().multiply(BigDecimal.valueOf(1));
		transaction.setAmount(result.abs());
		card.getTransactions().add(transaction);
		
		BigDecimal money = card.getBalance();
		money.add(result);
		card.setBalance(money);
		
		return card;
	}

}
