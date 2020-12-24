package dev.ashetm.wallet.payment;

import dev.ashetm.wallet.account.Account;
import dev.ashetm.wallet.account.AccountRepository;
import dev.ashetm.wallet.common.annotation.DataFetcherService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DataFetcherService
public class PaymentDataFetcher {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PaymentGatewayRepository paymentGatewayRepository;

    @DataFetcherService
    public class PaymentGatewayQuery implements DataFetcher<List<PaymentGateway>> {

        @Override
        public List<PaymentGateway> get(DataFetchingEnvironment dataFetchingEnvironment) {
            String id = dataFetchingEnvironment.getArgument("id");
            Account account = accountRepository.getOne(id);

            return account.getPaymentGatewayList();
        }

    }

    @DataFetcherService
    public class PaymentGatewayMutation implements DataFetcher<PaymentGateway> {

        @Override
        public PaymentGateway get(DataFetchingEnvironment dataFetchingEnvironment) {
            PaymentGateway paymentGateway = dataFetchingEnvironment.getArgument("paymentGateway");
            String idAccount = dataFetchingEnvironment.getArgument("idAccount");
            Account account = accountRepository.getOne(idAccount);

            paymentGateway.setAccount(account);

            return paymentGatewayRepository.save(paymentGateway);
        }

    }

}
