package dev.ashetm.wallet.views;

import java.time.LocalDate;

import dev.ashetm.wallet.entities.Account;

public class AccountResponseView implements ResponseView {
	
	private Account account;
	
	private LocalDate now = LocalDate.now();

	public AccountResponseView() {
	}

	public AccountResponseView(Account account) {
		super();
		this.account = account;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	public static Account to(AccountResponseView accountResponseView) {
		return accountResponseView.getAccount();
	}
	
	public static AccountResponseView from(Account account) {
		return new AccountResponseView(account);
	}
}
