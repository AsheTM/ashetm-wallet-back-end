package dev.ashetm.wallet.views.request;

import dev.ashetm.wallet.entities.Card;
import dev.ashetm.wallet.entities.Client;
import dev.ashetm.wallet.enums.CardTypeEnum;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CardRequestView {

    @NotEmpty
    @Size(
            min = 4,
            max = 4,
            message = "Password must be 4 digits")
    @NotNull
    private String password;
    private Client client;

    public static Card to(CardRequestView cardRequestView) {
        return Card.builder()
                .balance(BigDecimal.ZERO)
                .client(cardRequestView.getClient())
                .password(cardRequestView.getPassword())
                .type(CardTypeEnum.UNKNOWN)
                .date(LocalDate.now())
                .build();
    }

}
