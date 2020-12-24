package dev.ashetm.wallet.payment.stripe;

import com.stripe.exception.StripeException;
import com.stripe.model.Transfer;
import com.stripe.param.TransferCreateParams;

public class PaymentStripeServiceImpl implements PaymentStripeService {

    public Transfer transferCurrencyTo(String destination, Long amount, String currency, String description)
            throws StripeException {
        TransferCreateParams transferCreateParams = TransferCreateParams.builder()
                .setAmount(amount)
                .setCurrency(currency)
                .setDescription(description)
                .setDestination(destination)
                .build();
        Transfer transfer = Transfer.create(transferCreateParams);

        return transfer;
    }

}
