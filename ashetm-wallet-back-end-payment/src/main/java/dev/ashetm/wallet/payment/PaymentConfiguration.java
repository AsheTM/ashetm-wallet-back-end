package dev.ashetm.wallet.payment;

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
public class PaymentConfiguration extends GraphQLCommonConfiguration {

    @Autowired
    private PaymentDataFetcher.PaymentGatewayQuery paymentGatewayQuery;

    @Autowired
    private PaymentDataFetcher.PaymentGatewayMutation paymentGatewayMutation;

    @Value("classpath:schema.graphql")
    private Resource resource;

    @Bean(name = "PaymentGatewayGraphQL")
    public GraphQL graphQL() throws IOException {
        return super.graphQL(resource);
    }

    protected RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeRuntimeWiring ->
                        typeRuntimeWiring.dataFetcher("paymentGateways", paymentGatewayQuery)
                ).type("Mutation", typeRuntimeWiring ->
                        typeRuntimeWiring.dataFetcher("addPaymentGateway", paymentGatewayMutation)
                ).build();
    }

}
