package dev.ashetm.wallet.controllers;

import dev.ashetm.wallet.views.request.TransactionRequestView;
import dev.ashetm.wallet.views.response.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.ashetm.wallet.entities.Card;
import dev.ashetm.wallet.entities.Client;
import dev.ashetm.wallet.exceptions.NotFoundException;
import dev.ashetm.wallet.views.request.AuthenticateCardRequestView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

public interface WalletController {

	@Api(
			position = 0,
			hidden = false,
			description = "All endpoints that concern client")
	@RequestMapping("/api/v1/client")
	interface ClientController {

		@ApiOperation(
				value = "Get one client")
		@GetMapping("/{idClient}")
		ClientResponseView showClient(@PathVariable("idClient") int idClient);

		@ApiOperation(
				value = "Get all clients")
		@GetMapping("")
		ClientsResponseView showClients();

		@ApiOperation(
				value = "Save a client")
		@PostMapping("")
		ClientResponseView addClient(@RequestBody Client client);
		
	}


	@Api(
			position = 1, 
			hidden = false, 
			description = "All endpoints that concern card")
	@RequestMapping("/api/v1/client/{idClient}/card")
	interface CardController {

		@ApiOperation(
				value = "Get one card from a client")
		@GetMapping("/{idCard}")
		CardResponseView showCard(
				@PathVariable("idClient") int idClient,
				@PathVariable("idCard") int idCard);

		@ApiOperation(
				value = "Get all cards from a client")
		@GetMapping()
		CardsResponseView showCards(@PathVariable("idClient") int idClient);

		@ApiOperation(
				value = "Save a card to a client")
		@PostMapping()
		CardResponseView addCard(
				@PathVariable("idClient") int idClient, 
				@RequestBody Card card);
		
		@PostMapping("/{idCard}/authenticate")
		AuthenticateCardResponseView authenticate(
				@PathVariable("idClient") int idClient, 
				@PathVariable("idCard") int idCard, 
				@RequestBody AuthenticateCardRequestView authenticateCardRequestView);

	}


	@Api(
			position = 2,
			hidden = false,
			description = "All endpoints that concern transaction")
	@RequestMapping("/api/v1/client/{idClient}/card/{idCard}/transaction")
	interface TransactionController {

		@ApiOperation(
				value = "Get one transaction of a card of a client")
		@GetMapping("/{idTransaction}")
		TransactionResponseView showTransaction(
				@PathVariable("idClient") int idClient,
				@PathVariable("idCard") int idCard,
				@PathVariable("idTransaction") int idTransaction);

		@ApiOperation(
				value = "Get all transactions of a card of a client")
		@GetMapping()
		TransactionsResponseView showTransactions(
				@PathVariable("idClient") int idClient, 
				@PathVariable("idCard") int idCard);

		@ApiOperation(
				value = "Make a withdraw/deposit transaction in a card for a client")
		@PostMapping("/{idCard}")
		BalanceCardResponseView makeTransaction(
				@PathVariable("idClient") int idClient,
				@PathVariable("idCard") int idCard,
				@RequestBody TransactionRequestView transactionRequestView);
		
	}

}
