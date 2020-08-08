package dev.ashetm.wallet.exceptions;

import dev.ashetm.wallet.entities.Card;

public class BalanceCardNotSufficientException extends Exception {

    public BalanceCardNotSufficientException() {
        super("Balance of this card not sufficient");
    }

    public BalanceCardNotSufficientException(Card card) {
        super("Balance of card '" + card.getId() + "' not sufficient");
    }

}
