package dev.ashetm.wallet.repositories;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import dev.ashetm.wallet.entities.Card;
import dev.ashetm.wallet.entities.Client;
import dev.ashetm.wallet.entities.Transaction;
import dev.ashetm.wallet.enums.CardTypeEnum;

@SuppressWarnings("unused")
@Component
public class WalletRepositoryImpl {
	
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
						.type(j % 2 == 0 ? CardTypeEnum.VISA : CardTypeEnum.MASTERCARD)
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
