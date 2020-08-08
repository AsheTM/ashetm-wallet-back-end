package dev.ashetm.wallet.exceptions;

import dev.ashetm.wallet.entities.Card;

public class CardBalanceNotSufficientException extends Exception {

    public CardBalanceNotSufficientException() {
        super("Balance of this card not sufficient");
    }

    public CardBalanceNotSufficientException(Card card) {
        super("Balance of card '" + card.getId() + "' not sufficient");
    }

}
