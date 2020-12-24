package dev.ashetm.wallet.counter.repositories;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import dev.ashetm.wallet.counter.models.Client;
import dev.ashetm.wallet.counter.models.Card;
import dev.ashetm.wallet.counter.enums.CardType;
import dev.ashetm.wallet.counter.models.Transaction;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Component
@Profile({ "Dev" })
public class WalletRepositoryImpl implements WalletRepository {
	
	private final static int 
			nbrClients = 2, 
			nbrCardPerClient = 2, 
			nbrTransactionsPerCard = 2;
	
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
					.id(i + 1)
					.firstName("FirstName " + i)
					.lastName("LastName " + i)
					.build();
			List<Card> cards = new ArrayList<>();

			System.out.println("Client id: " + client.getId());
			
			FOREACH_CARD:
			for(int j = 0; j < nbrCardPerClient; j++) {
				Card card = Card.builder()
						.id(j + 1)
						.balance(BigDecimal.ZERO)
						.password("1234")
						.type(j % 2 == 0 ? CardType.VISA : CardType.MASTERCARD)
						.build();
				List<Transaction> transactions = new ArrayList<>();

				System.out.println("Card id: " + card.getId());
				
				ADD_TRANSACTIONS:
				for(int k = 0; k < nbrTransactionsPerCard; k++) {
					BigDecimal amount = BigDecimal.valueOf(100_000);
					Transaction transaction = Transaction.builder()
							.id(k + 1)
							.amount(amount)
							.build();

					System.out.println("Transaction id: " + transaction.getId() + ", of " + transaction.getAmount());
					
					transactions.add(transaction);
				}

				card.setTransactions(transactions);
				cards.add(card);
//				System.out.println("T: " + transactions.size());
			}

			client.setCards(cards);
			clients.add(client);
//			System.out.println("A: " + accounts.size());
		}

//		System.out.println("C: " + clients.size());
	}
	
}
