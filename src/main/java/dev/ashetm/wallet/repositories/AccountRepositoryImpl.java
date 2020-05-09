package dev.ashetm.wallet.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import dev.ashetm.wallet.entities.Account;
import dev.ashetm.wallet.entities.Client;
import dev.ashetm.wallet.exceptions.ClientNotFoundException;
import dev.ashetm.wallet.exceptions.NotFoundException;
import dev.ashetm.wallet.utils.AccountUtil;
import dev.ashetm.wallet.utils.ClientUtil;

@Repository
public class AccountRepositoryImpl extends WalletRepositoryImpl implements AccountRepository {

	@Override
	public Account find(int idClient, int idAccount) throws NotFoundException {
		List<Account> accounts = this.findAll(idClient);
		return AccountUtil.get(accounts, idAccount);
	}

	@Override
	public List<Account> findAll(int idClient) throws ClientNotFoundException {
		Client client = ClientUtil.get(clients, idClient);
		return client.getAccounts();
	}
	
	@Override
	public Account save(int idClient, Account account) throws ClientNotFoundException {
		Client client = ClientUtil.get(clients, idClient);
		client.setAccount(account);
		
		return account;
	}

}
