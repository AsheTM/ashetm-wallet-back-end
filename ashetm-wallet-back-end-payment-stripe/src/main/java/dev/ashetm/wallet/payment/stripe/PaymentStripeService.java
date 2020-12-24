package dev.ashetm.wallet.payment.stripe;

import com.stripe.exception.StripeException;
import com.stripe.model.Transfer;
import org.springframework.stereotype.Service;

@Service
public interface PaymentStripeService {

    Transfer transferCurrencyTo(String destination, Long amount, String currency, String description)
            throws StripeException;

}
