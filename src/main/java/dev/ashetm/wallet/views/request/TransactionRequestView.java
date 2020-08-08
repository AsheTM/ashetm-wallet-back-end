package dev.ashetm.wallet.views.request;

import dev.ashetm.wallet.entities.Card;
import dev.ashetm.wallet.entities.Transaction;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequestView implements IRequestView {

    @NotNull
    private BigDecimal amount;
    private Card card;

    public static Transaction to(TransactionRequestView transactionRequestView) {
        return Transaction.builder()
                .amount(transactionRequestView.getAmount())
                .card(transactionRequestView.getCard())
                .date(LocalDate.now())
                .build();
    }

}
