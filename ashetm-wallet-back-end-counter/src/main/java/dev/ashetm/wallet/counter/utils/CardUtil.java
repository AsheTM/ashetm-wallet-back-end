package dev.ashetm.wallet.counter.utils;

import java.util.List;
import java.util.Optional;

import dev.ashetm.wallet.counter.models.Client;
import dev.ashetm.wallet.counter.models.Card;
import dev.ashetm.wallet.counter.exceptions.CardNotFoundException;
import dev.ashetm.wallet.counter.exceptions.NotFoundException;

public class CardUtil implements IEntityUtil<Client> {

	public static Optional<Card> find(List<Card> cards, int idC) {
		return IEntityUtil.getStream(cards).filter((clt) -> clt.getId() == idC).findFirst();
	}

	public static Card get(List<Card> cards, int idC) throws NotFoundException {
		return CardUtil.find(cards, idC).orElseThrow(() -> new CardNotFoundException());
	}

}
