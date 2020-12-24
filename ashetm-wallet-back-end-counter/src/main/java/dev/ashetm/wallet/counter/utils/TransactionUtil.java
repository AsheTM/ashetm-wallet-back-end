package dev.ashetm.wallet.counter.utils;

import java.util.List;
import java.util.Optional;

import dev.ashetm.wallet.counter.models.Client;
import dev.ashetm.wallet.counter.exceptions.NotFoundException;
import dev.ashetm.wallet.counter.models.Transaction;
import dev.ashetm.wallet.counter.exceptions.TransactionNotFoundException;

public class TransactionUtil implements IEntityUtil<Client> {

	public static Optional<Transaction> find(List<Transaction> transactions, int idC) {
		return IEntityUtil.getStream(transactions).filter((clt) -> clt.getId() == idC).findFirst();
	}

	public static Transaction get(List<Transaction> transactions, int idC) throws NotFoundException {
		return TransactionUtil.find(transactions, idC).orElseThrow(() -> new TransactionNotFoundException());
	}
	
}
