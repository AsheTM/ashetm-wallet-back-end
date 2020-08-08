package dev.ashetm.wallet.processes;

import dev.ashetm.wallet.exceptions.CardNotFoundException;
import org.springframework.stereotype.Component;

@Component
public interface CardProcess {

    Boolean authenticate(int idClient, int idCard, String password) throws CardNotFoundException;

}
