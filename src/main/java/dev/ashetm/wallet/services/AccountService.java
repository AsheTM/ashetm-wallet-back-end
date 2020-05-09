package dev.ashetm.wallet.services;

import java.util.List;

import dev.ashetm.wallet.entities.Account;

public interface AccountService {
	
	Account getAccount(int idClient, int idAccount);
	
	List<Account> getAllAccount(int idClient);
	
	Account saveAccount(int idClient, Account account);

}
