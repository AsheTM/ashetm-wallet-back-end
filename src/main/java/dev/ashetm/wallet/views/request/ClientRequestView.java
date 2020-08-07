package dev.ashetm.wallet.views.request;

import dev.ashetm.wallet.entities.Client;
import dev.ashetm.wallet.entities.Transaction;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequestView {

    private String firstName;
    private String lastName;

    public static Client to(ClientRequestView clientRequestView) {
        return Client.builder()
                .cards(new ArrayList<>())
                .firstName(clientRequestView.getFirstName())
                .lastName(clientRequestView.getLastName())
                .build();
    }

}
