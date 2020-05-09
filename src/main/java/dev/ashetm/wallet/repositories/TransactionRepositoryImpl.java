package dev.ashetm.wallet.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import dev.ashetm.wallet.entities.Account;
import dev.ashetm.wallet.entities.Client;
import dev.ashetm.wallet.entities.Transaction;
import dev.ashetm.wallet.exceptions.AccountNotFoundException;
import dev.ashetm.wallet.exceptions.ClientNotFoundException;
import dev.ashetm.wallet.exceptions.NotFoundException;
import dev.ashetm.wallet.exceptions.TransactionNotFoundException;

@Repository
public class TransactionRepositoryImpl extends WalletRepositoryImpl implements TransactionRepository {

	@Override
	public Transaction find(int idClient, int idAccount, int idTransaction) throws NotFoundException {
		List<Transaction> transactions = this.findAll(idClient, idAccount);
		return transactions.stream().filter(trs -> trs.getId() == idTransaction)
				.findFirst()
				.orElseThrow(() -> new TransactionNotFoundException());
	}

	@Override
	public List<Transaction> findAll(int idClient, int idAccount) throws NotFoundException {
		Client client = clients.stream().filter(clt -> clt.getId() == idClient)
				.findFirst()
				.orElseThrow(() -> new ClientNotFoundException());
		Account account = client.getAccounts().stream().filter(acc -> acc.getId() == idAccount)
				.findFirst()
				.orElseThrow(() -> new AccountNotFoundException());
		return account.getTransactions();
	}

}
