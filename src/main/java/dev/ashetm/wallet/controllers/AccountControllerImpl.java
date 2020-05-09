package dev.ashetm.wallet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import dev.ashetm.wallet.entities.Account;
import dev.ashetm.wallet.entities.Transaction;
import dev.ashetm.wallet.exceptions.NotFoundException;
import dev.ashetm.wallet.processes.AccountProcess;
import dev.ashetm.wallet.processes.WalletProcess;
import dev.ashetm.wallet.services.AccountService;
import dev.ashetm.wallet.views.AccountResponseView;
import dev.ashetm.wallet.views.AccountsResponseView;

@RestController
public class AccountControllerImpl implements WalletController.AccountController {
	
	private AccountService accountService;
	private AccountProcess accountProcess;
	private WalletProcess walletProcess;
	
	@Autowired
	public AccountControllerImpl(AccountService accountService, 
			AccountProcess accountProcess, 
			WalletProcess walletProcess) {
		this.accountService = accountService;
		this.accountProcess = accountProcess;
		this.walletProcess = walletProcess;
	}

	@Override
	public AccountsResponseView showAccounts(int idClient) throws NotFoundException {
		List<Account> accounts = this.accountService.getAllAccount(idClient);
		
		return AccountsResponseView.from(accounts);
	}

	@Override
	public AccountResponseView showAccount(int idClient, int idAccount) throws NotFoundException {
		Account account = this.accountService.getAccount(idClient, idAccount);
		
		return AccountResponseView.from(account);
	}

	@Override
	public AccountResponseView withdraw(int idClient, int idAccount, Transaction transaction) 
			throws NotFoundException {
		Account account = this.accountService.getAccount(idClient, idAccount);
		account = this.walletProcess.withdraw(account, transaction);
		
		return AccountResponseView.from(account);
	}

	@Override
	public AccountResponseView deposit(int idClient, int idAccount, Transaction transaction) 
			throws NotFoundException {
		Account account = this.accountService.getAccount(idClient, idAccount);
		account = this.walletProcess.deposit(account, transaction);
		
		return AccountResponseView.from(account);
	}

	@Override
	public AccountResponseView addAccount(int idClient, Account account) throws NotFoundException {
		account = this.accountService.saveAccount(idClient, account);
		
		return AccountResponseView.from(account);
	}

	@Override
	public AccountResponseView activateAccount(int idClient, int idAccount) throws NotFoundException {
		Account account = this.accountService.getAccount(idClient, idAccount);
		if(account != null)
			account = this.accountProcess.activateAccount(account);
		
		return AccountResponseView.from(account);
	}

	@Override
	public AccountResponseView deactivateAccount(int idClient, int idAccount) throws NotFoundException {
		Account account = this.accountService.getAccount(idClient, idAccount);
		if(account != null)
			account = this.accountProcess.deactivateAccount(account);
		
		return AccountResponseView.from(account);
	}

}
