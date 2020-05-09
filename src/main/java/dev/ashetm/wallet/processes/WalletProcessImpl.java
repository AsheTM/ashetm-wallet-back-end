package dev.ashetm.wallet.processes;

import java.math.BigDecimal;

import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import dev.ashetm.wallet.entities.Account;
import dev.ashetm.wallet.entities.Transaction;

@Component
public class WalletProcessImpl implements WalletProcess {

	@Before("execution(public * *(..)")
	@Override
	public Account withdraw(Account account, Transaction transaction) {
		BigDecimal amount = transaction.getAmount();
		BigDecimal result = amount.abs().multiply(BigDecimal.valueOf(-1));
		transaction.setAmount(result);
		account.getTransactions().add(transaction);
		
		BigDecimal money = account.getBalance();
		money.add(result);
		account.setBalance(money);
		
		return account;
	}

	@Override
	public Account deposit(Account account, Transaction transaction) {
		BigDecimal amount = transaction.getAmount();
		BigDecimal result = amount.abs().multiply(BigDecimal.valueOf(1));
		transaction.setAmount(result.abs());
		account.getTransactions().add(transaction);
		
		BigDecimal money = account.getBalance();
		money.add(result);
		account.setBalance(money);
		
		return account;
	}

}
