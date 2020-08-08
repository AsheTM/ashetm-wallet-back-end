package dev.ashetm.wallet.views.request;

import dev.ashetm.wallet.entities.Card;
import dev.ashetm.wallet.entities.Transaction;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor // (onConstructor_ = { @Valid })
public class TransactionRequestView implements IRequestView {

    @NotNull
    private BigDecimal amount;

    public static Transaction to(TransactionRequestView transactionRequestView) {
        return Transaction.builder()
                .amount(transactionRequestView.getAmount())
                .date(LocalDateTime.now())
                .build();
    }

}
