package dev.ashetm.wallet.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentGatewayEnum {

    STRIPE(0), PAYPAL(2), HEDERA(3);

    private int type;

}
