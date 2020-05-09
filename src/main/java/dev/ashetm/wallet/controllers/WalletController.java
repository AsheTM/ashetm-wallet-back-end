package dev.ashetm.wallet.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.ashetm.wallet.entities.Account;
import dev.ashetm.wallet.entities.Client;
import dev.ashetm.wallet.entities.Transaction;
import dev.ashetm.wallet.exceptions.NotFoundException;
import dev.ashetm.wallet.views.AccountResponseView;
import dev.ashetm.wallet.views.AccountsResponseView;
import dev.ashetm.wallet.views.ClientResponseView;
import dev.ashetm.wallet.views.ClientsResponseView;
import dev.ashetm.wallet.views.TransactionResponseView;
import dev.ashetm.wallet.views.TransactionsResponseView;

@RequestMapping("/v1/api/client")
public interface WalletController {

	@RequestMapping("/")
	interface ClientController {

		@GetMapping("/")
		ClientsResponseView showClients() throws NotFoundException;
		
		@GetMapping("/{idC}")
		ClientResponseView showClient(@RequestParam("idC") int idClient) throws NotFoundException;
		
		@PostMapping("/")
		ClientResponseView addClient(@RequestBody Client client) throws NotFoundException;
		
	}

	@RequestMapping("/{idC}/account")
	interface AccountController {

		@GetMapping("/")
		AccountsResponseView showAccounts(@RequestParam("idC") int idClient) throws NotFoundException;

		@GetMapping("/{idA}")
		AccountResponseView showAccount(@RequestParam("idC") int idClient, @RequestParam("idA") int idAccount) throws NotFoundException;
		
		@PostMapping("/")
		AccountResponseView addAccount(@RequestParam("idC") int idClient, @RequestBody Account account) throws NotFoundException;

		@PostMapping("/{idA}/withdraw")
		AccountResponseView withdraw(@RequestParam("idC") int idClient, @RequestParam("idA") int idAccount, @RequestBody Transaction transaction) throws NotFoundException;

		@PostMapping("/{idA}/deposit")
		AccountResponseView deposit(@RequestParam("idC") int idClient, @RequestParam("idA") int idAccount, @RequestBody Transaction transaction) throws NotFoundException;
		
		@PatchMapping("/{idA}")
		AccountResponseView activateAccount(@RequestParam("idC") int idClient, @RequestParam("idA") int idAccount) throws NotFoundException;
		
		@DeleteMapping("/{idA}")
		AccountResponseView deactivateAccount(@RequestParam("idC") int idClient, @RequestParam("idA") int idAccount) throws NotFoundException;
		
	}

	@RequestMapping("/{idC}/account/{idA}/transaction")
	interface TransactionController {

		@GetMapping("/")
		TransactionsResponseView showTransactions(@RequestParam("idC") int idClient, @RequestParam("idA") int idAccount) throws NotFoundException;

		@GetMapping("/{idT}")
		TransactionResponseView showTransaction(@RequestParam("idC") int idClient, @RequestParam("idA") int idAccount, @RequestParam("idT") int idTransaction) throws NotFoundException;
		
	}

}
