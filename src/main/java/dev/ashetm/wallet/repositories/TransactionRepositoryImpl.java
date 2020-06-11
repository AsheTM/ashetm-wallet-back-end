package dev.ashetm.wallet.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import dev.ashetm.wallet.entities.Card;
import dev.ashetm.wallet.entities.Client;
import dev.ashetm.wallet.entities.Transaction;
import dev.ashetm.wallet.exceptions.CardNotFoundException;
import dev.ashetm.wallet.exceptions.ClientNotFoundException;
import dev.ashetm.wallet.exceptions.NotFoundException;
import dev.ashetm.wallet.exceptions.TransactionNotFoundException;

@Repository
public class TransactionRepositoryImpl extends WalletRepositoryImpl implements TransactionRepository {

	@Override
	public Transaction find(int idClient, int idCard, int idTransaction) throws NotFoundException {
		List<Transaction> transactions = this.findAll(idClient, idCard);
		return transactions.stream().filter(trs -> trs.getId() == idTransaction)
				.findFirst()
				.orElseThrow(() -> new TransactionNotFoundException());
	}

	@Override
	public List<Transaction> findAll(int idClient, int idCard) throws NotFoundException {
		Client client = clients.stream().filter(clt -> clt.getId() == idClient)
				.findFirst()
				.orElseThrow(() -> new ClientNotFoundException());
		Card card = client.getCards().stream().filter(cd -> cd.getId() == idCard)
				.findFirst()
				.orElseThrow(() -> new CardNotFoundException());
		return card.getTransactions();
	}

}
