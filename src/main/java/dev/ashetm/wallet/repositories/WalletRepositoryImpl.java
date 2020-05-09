package dev.ashetm.wallet.repositories;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import dev.ashetm.wallet.entities.Account;
import dev.ashetm.wallet.entities.Client;
import dev.ashetm.wallet.entities.Transaction;
import dev.ashetm.wallet.exceptions.ClientNotFoundException;
import dev.ashetm.wallet.exceptions.NotFoundException;

@SuppressWarnings("unused")
@Component
public class WalletRepositoryImpl implements WalletRepository {
	
	private final static int 
			nbrClients = 3, 
			nbrAccountsPerClient = 1, 
			nbrTransactionsPerAccount = 2;
	
	public static List<Client> clients = new ArrayList<>();
	
	/**
	 *  @author 	hdawoud
	 *  			Add clients
	 *  			Add accounts for each client
	 *  			Add transactions for each account
	 */
	static {
		
		FOREACH_CLIENT:
		for(int i = 0; i < nbrClients; i++) {
			Client client = Client.builder()
					.fullName("SampleFullName" + i)
					.build();
			List<Account> accounts = new ArrayList<>();

			System.out.println("Client id: " + client.getId());
			
			FOREACH_ACCOUNT:
			for(int j = 0; j < nbrAccountsPerClient; j++) {
				Account account = Account.builder()
						.build();
				List<Transaction> transactions = new ArrayList<>();

				System.out.println("Account id: " + account.getId());
				
				ADD_TRANSACTIONS:
				for(int k = 0; k < nbrTransactionsPerAccount; k++) {
					BigDecimal amount = BigDecimal.valueOf(100_000);
					Transaction transaction = Transaction.builder()
							.amount(amount)
							.build();

					System.out.println("Transaction id: " + transaction.getId() + ", of " + transaction.getAmount());
					
					transactions.add(transaction);
				}

				account.setTransactions(transactions);
				accounts.add(account);
//				System.out.println("T: " + transactions.size());
			}

			client.setAccounts(accounts);
			clients.add(client);
//			System.out.println("A: " + accounts.size());
		}

//		System.out.println("C: " + clients.size());
	}
	
}
