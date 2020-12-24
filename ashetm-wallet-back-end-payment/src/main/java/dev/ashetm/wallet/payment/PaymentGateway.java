package dev.ashetm.wallet.payment;

import dev.ashetm.wallet.account.Account;
import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentGateway {

    @Builder.Default
    @Id
    @Column(
            length = 36,
            unique = true,
            nullable = false,
            updatable = false,
            columnDefinition = "VARCHAR(36)"
    )
    private String id = UUID.randomUUID().toString();

    private PaymentGatewayEnum paymentGateway;
    private String username;

    @ManyToOne
    private Account account;

}
