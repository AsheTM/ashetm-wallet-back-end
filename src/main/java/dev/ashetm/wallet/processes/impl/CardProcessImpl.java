package dev.ashetm.wallet.processes.impl;

import dev.ashetm.wallet.entities.Card;
import dev.ashetm.wallet.exceptions.CardNotFoundException;
import dev.ashetm.wallet.processes.CardProcess;
import dev.ashetm.wallet.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CardProcessImpl implements CardProcess {

    @Autowired
    private CardService cardSerivce;

    @Override
    public Boolean authenticate(int idClient, int idCard, String password) throws CardNotFoundException {
        Card card = this.cardSerivce.getCard(idClient, idCard);

        return card.getPassword()
                .equals(password);
    }

}
