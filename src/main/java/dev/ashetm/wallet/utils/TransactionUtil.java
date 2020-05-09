package dev.ashetm.wallet.utils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import dev.ashetm.wallet.entities.Client;
import dev.ashetm.wallet.entities.Transaction;
import dev.ashetm.wallet.exceptions.NotFoundException;
import dev.ashetm.wallet.exceptions.TransactionNotFoundException;

public class TransactionUtil implements IEntityUtil<Client> {

	public static Optional<Transaction> find(List<Transaction> transactions, int idC) {
		return IEntityUtil.getStream(transactions).filter((clt) -> clt.getId() == idC).findFirst();
	}

	public static Transaction get(List<Transaction> transactions, int idC) throws NotFoundException {
		return TransactionUtil.find(transactions, idC).orElseThrow(() -> new TransactionNotFoundException());
	}
	
}
