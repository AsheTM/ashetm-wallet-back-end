package dev.ashetm.wallet.repositories;

import java.util.List;

import dev.ashetm.wallet.entities.Account;
import dev.ashetm.wallet.exceptions.NotFoundException;

public interface AccountRepository {
	
	Account find(int idClient, int idAccount) throws NotFoundException;
	
	List<Account> findAll(int idClient) throws NotFoundException;
	
	Account save(int idClient, Account account) throws NotFoundException;

}
