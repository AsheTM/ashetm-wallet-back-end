package dev.ashetm.wallet.views;

import java.time.LocalDate;
import java.util.List;

import dev.ashetm.wallet.entities.Account;

public class AccountsResponseView {
	
	private List<Account> accounts;
	
	private LocalDate now = LocalDate.now();

	public AccountsResponseView() {
	}

	public AccountsResponseView(List<Account> accounts) {
		super();
		this.accounts = accounts;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public static List<Account> to(AccountsResponseView accountsResponseView) {
		return accountsResponseView.getAccounts();
	}
	
	public static AccountsResponseView from(List<Account> accounts) {
		return new AccountsResponseView(accounts);
	}

}
