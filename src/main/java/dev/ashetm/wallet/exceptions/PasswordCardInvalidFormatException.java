package dev.ashetm.wallet.exceptions;

import dev.ashetm.wallet.entities.Card;

public class PasswordCardInvalidFormatException extends Exception {

    public PasswordCardInvalidFormatException() {
        super("Password format invalid");
    }

    public PasswordCardInvalidFormatException(String password) {
        super("Password '" + password + "' format invalid");
    }

    public PasswordCardInvalidFormatException(Card card) {
        super("Password '" + card.getPassword() + "' format invalid");
    }

}
