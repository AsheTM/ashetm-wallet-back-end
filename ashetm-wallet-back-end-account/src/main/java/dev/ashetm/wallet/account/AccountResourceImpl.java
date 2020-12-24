package dev.ashetm.wallet.account;

import graphql.ExecutionResult;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public class AccountResourceImpl implements AccountResource {

    @Autowired
    @Qualifier("AccountGraphQL")
    private GraphQL graphQL;

    public ResponseEntity<ExecutionResult> account(@RequestBody String query) {
        return ResponseEntity.ok(graphQL.execute(query));
    }

}
