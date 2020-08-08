package dev.ashetm.wallet.processes;

import dev.ashetm.wallet.entities.Card;
import dev.ashetm.wallet.exceptions.CardNotFoundException;
import dev.ashetm.wallet.exceptions.NotFoundException;
import dev.ashetm.wallet.exceptions.PasswordCardInvalidFormatException;
import org.springframework.stereotype.Component;

@Component
public interface CardProcess {

    Boolean authenticate(int idClient, int idCard, String password) throws CardNotFoundException;
    Card saveCard(int idClient, Card card) throws NotFoundException, PasswordCardInvalidFormatException;

}
