package dev.ashetm.wallet.counter.repositories;

import java.util.List;

import dev.ashetm.wallet.counter.models.Client;
import dev.ashetm.wallet.counter.exceptions.ClientNotFoundException;
import dev.ashetm.wallet.counter.models.Card;
import dev.ashetm.wallet.counter.exceptions.CardNotFoundException;
import dev.ashetm.wallet.counter.exceptions.NotFoundException;
import dev.ashetm.wallet.counter.models.Transaction;
import dev.ashetm.wallet.counter.exceptions.TransactionNotFoundException;
import org.springframework.stereotype.Repository;

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
		Client client = WalletRepositoryImpl.clients.stream().filter(clt -> clt.getId() == idClient)
				.findFirst()
				.orElseThrow(() -> new ClientNotFoundException());
		Card card = client.getCards().stream().filter(cd -> cd.getId() == idCard)
				.findFirst()
				.orElseThrow(() -> new CardNotFoundException());
		return card.getTransactions();
	}

}
