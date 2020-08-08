package dev.ashetm.wallet.processes.impl;

import dev.ashetm.wallet.entities.Card;
import dev.ashetm.wallet.entities.Client;
import dev.ashetm.wallet.exceptions.CardNotFoundException;
import dev.ashetm.wallet.exceptions.NotFoundException;
import dev.ashetm.wallet.exceptions.PasswordCardInvalidFormatException;
import dev.ashetm.wallet.processes.CardProcess;
import dev.ashetm.wallet.services.CardService;
import dev.ashetm.wallet.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CardProcessImpl implements CardProcess {

    @Autowired
    private CardService cardSerivce;

    @Autowired
    private ClientService clientService;

    @Override
    public Boolean authenticate(int idClient, int idCard, String password) throws CardNotFoundException {
        Card card = this.cardSerivce.getCard(idClient, idCard);

        return card.getPassword()
                .equals(password);
    }

    @Override
    public Card saveCard(int idClient, Card card)
            throws NotFoundException, PasswordCardInvalidFormatException {
        Card cardToSave = card;
        Client client = this.clientService.getClient(idClient);
        if(cardToSave == null)
            throw new CardNotFoundException();

        if(cardToSave.getPassword() == null) {
            String generatedPassword = this.generateRandomPassword();
            cardToSave.setPassword(generatedPassword);
        }

        if(cardToSave.getPassword().length() != 4)
            throw new PasswordCardInvalidFormatException();

        cardToSave.setClient(client);

        return this.cardSerivce.saveCard(card);
    }

    private String generateRandomPassword() {
        int generatedPassword = (int) Math.round(Math.random() * 1000 * 10);

        return String.valueOf(generatedPassword);
    }

}
