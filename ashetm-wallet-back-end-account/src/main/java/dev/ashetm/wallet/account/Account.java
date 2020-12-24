package dev.ashetm.wallet.account;

import dev.ashetm.wallet.payment.PaymentGateway;
import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

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

    private String firstname;
    private String lastname;

    @Builder.Default
    @OneToMany(mappedBy = "account")
    private List<PaymentGateway> paymentGatewayList = new ArrayList<>();

}
