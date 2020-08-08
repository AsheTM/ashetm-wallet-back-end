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
public class CardRequestView implements IRequestView {

    private String password;
    private CardTypeEnum type;

    public static Card to(CardRequestView cardRequestView) {
        return Card.builder()
                .balance(BigDecimal.ZERO)
                .password(cardRequestView.getPassword())
                .type(cardRequestView.getType())
                .date(LocalDate.now())
                .build();
    }

}
