package dev.ashetm.wallet.account;

import dev.ashetm.wallet.common.annotation.DataFetcherService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DataFetcherService
public class AccountDataFetcher {

    @Autowired
    private AccountRepository accountRepository;

    @DataFetcherService
    public class AccountQuery implements DataFetcher<Account> {

        @Override
        public Account get(DataFetchingEnvironment dataFetchingEnvironment) {
            String id = dataFetchingEnvironment.getArgument("id");

            return accountRepository.getOne(id);
        }

    }

    @DataFetcherService
    public class AccountsQuery implements DataFetcher<List<Account>> {

        @Override
        public List<Account> get(DataFetchingEnvironment dataFetchingEnvironment) {
            return accountRepository.findAll();
        }

    }

}
