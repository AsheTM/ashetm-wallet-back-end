package dev.ashetm.wallet.utils;

import java.util.List;
import java.util.Optional;

import dev.ashetm.wallet.entities.Account;
import dev.ashetm.wallet.entities.Client;
import dev.ashetm.wallet.exceptions.AccountNotFoundException;
import dev.ashetm.wallet.exceptions.NotFoundException;

public class AccountUtil implements IEntityUtil<Client> {

	public static Optional<Account> find(List<Account> accounts, int idC) {
		return IEntityUtil.getStream(accounts).filter((clt) -> clt.getId() == idC).findFirst();
	}

	public static Account get(List<Account> accounts, int idC) throws NotFoundException {
		return AccountUtil.find(accounts, idC).orElseThrow(() -> new AccountNotFoundException());
	}

}
