package dev.ashetm.wallet.account;

import graphql.ExecutionResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/graphql/account")
public interface AccountResource {

    @PostMapping
    ResponseEntity<ExecutionResult> account(@RequestBody String query);

}
