package dev.ashetm.wallet.counter.controllers;

import dev.ashetm.wallet.counter.models.Client;
import dev.ashetm.wallet.counter.models.Card;
import dev.ashetm.wallet.counter.exceptions.NotFoundException;
import dev.ashetm.wallet.counter.models.Transaction;
import dev.ashetm.wallet.counter.views.requests.AuthenticateCardRequestView;
import dev.ashetm.wallet.counter.views.responses.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
				value = "Get all clients")
		@GetMapping("/")
		ClientsResponseView showClients() throws NotFoundException;

		@ApiOperation(
				value = "Get one client")
		@GetMapping("/{idClient}")
		ClientResponseView showClient(
				@PathVariable("idClient") int idClient) throws NotFoundException;

		@ApiOperation(
				value = "Save a client")
		@PostMapping("/")
		ClientResponseView addClient(
				@RequestBody Client client) throws NotFoundException;
		
	}


	@Api(
			position = 1, 
			hidden = false, 
			description = "All endpoints that concern card")
	@RequestMapping("/api/v1/client/{idClient}/card")
	interface CardController {

		@ApiOperation(
				value = "Get all cards from a client")
		@GetMapping("/")
		CardsResponseView showCards(
				@PathVariable("idClient") int idClient) throws NotFoundException;

		@ApiOperation(
				value = "Get one card from a client")
		@GetMapping("/{idCard}")
		CardResponseView showCard(
				@PathVariable("idClient") int idClient, 
				@PathVariable("idCard") int idCard) throws NotFoundException;

		@ApiOperation(
				value = "Save a card to a client")
		@PostMapping("/")
		CardResponseView addCard(
				@PathVariable("idClient") int idClient, 
				@RequestBody Card card) throws NotFoundException;
		
		@PostMapping("/{idCard}/authenticate")
		AuthenticateCardResponseView authenticate(
				@PathVariable("idClient") int idClient, 
				@PathVariable("idCard") int idCard, 
				@RequestBody AuthenticateCardRequestView authenticateCardRequestView) throws NotFoundException;

		@ApiOperation(
				value = "Make a withdraw transaction in a card for a client")
		@PostMapping("/{idCard}/withdraw")
		CardResponseView withdraw(
				@PathVariable("idClient") int idClient, 
				@PathVariable("idCard") int idCard, 
				@RequestBody Transaction transaction) throws NotFoundException;

		@ApiOperation(
				value = "Make a deposit transaction in a card for a client")
		@PostMapping("/{idCard}/deposit")
		CardResponseView deposit(
				@PathVariable("idClient") int idClient, 
				@PathVariable("idCard") int idCard, 
				@RequestBody Transaction transaction) throws NotFoundException;

		@ApiOperation(
				value = "Activate a card of a client")
		@PatchMapping("/{idCard}")
		ActivateCardResponseView activateCard(
				@PathVariable("idClient") int idClient, 
				@PathVariable("idCard") int idCard) throws NotFoundException;

		@ApiOperation(
				value = "Deactivate a card of a client")
		@DeleteMapping("/{idCard}")
		ActivateCardResponseView deactivateCard(
				@PathVariable("idClient") int idClient, 
				@PathVariable("idCard") int idCard) throws NotFoundException;
		
	}


	@Api(
			position = 2, 
			hidden = false, 
			description = "All endpoints that concern transaction")
	@RequestMapping("/api/v1/client/{idClient}/card/{idCard}/transaction")
	interface TransactionController {

		@ApiOperation(
				value = "Get all transactions of a card of a client")
		@GetMapping("/")
		TransactionsResponseView showTransactions(
				@PathVariable("idClient") int idClient, 
				@PathVariable("idCard") int idCard) throws NotFoundException;

		@ApiOperation(
				value = "Get one transaction of a card of a client")
		@GetMapping("/{idTransaction}")
		TransactionResponseView showTransaction(
				@PathVariable("idClient") int idClient, 
				@PathVariable("idCard") int idCard, 
				@PathVariable("idTransaction") int idTransaction) throws NotFoundException;
		
	}

}
