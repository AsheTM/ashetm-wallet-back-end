package dev.ashetm.wallet.account;

import dev.ashetm.wallet.common.configuration.GraphQLCommonConfiguration;
import graphql.GraphQL;
import graphql.schema.idl.RuntimeWiring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;

@Configuration
public class AccountConfiguration extends GraphQLCommonConfiguration {

    @Autowired
    private AccountDataFetcher.AccountQuery accountQuery;

    @Autowired
    private AccountDataFetcher.AccountsQuery accountsQuery;

    @Value("classpath:schema.graphql")
    private Resource resource;

    @Bean(name = "AccountGraphQL")
    public GraphQL graphQL() throws IOException {
        return super.graphQL(resource);
    }

    protected RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("query", typeRuntimeWiring ->
                    typeRuntimeWiring.dataFetcher("account", accountQuery)
                            .dataFetcher("accounts", accountsQuery)
                ).build();
    }

}
