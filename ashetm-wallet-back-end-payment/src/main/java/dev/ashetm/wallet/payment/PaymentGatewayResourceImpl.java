package dev.ashetm.wallet.payment;

import graphql.ExecutionResult;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public class PaymentGatewayResourceImpl implements PaymentGatewayResource {

    @Autowired
    @Qualifier("PaymentGatewayGraphQL")
    private GraphQL graphQL;

    public ResponseEntity<ExecutionResult> paymentGateway(@RequestBody String query) {
        return ResponseEntity.ok(graphQL.execute(query));
    }

}
