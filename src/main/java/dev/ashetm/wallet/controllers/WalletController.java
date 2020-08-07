package dev.ashetm.wallet.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.ashetm.wallet.entities.Card;
import dev.ashetm.wallet.entities.Client;
import dev.ashetm.wallet.entities.Transaction;
import dev.ashetm.wallet.exceptions.NotFoundException;
import dev.ashetm.wallet.views.request.AuthenticateCardRequestView;
import dev.ashetm.wallet.views.response.ActivateCardResponseView;
import dev.ashetm.wallet.views.response.AuthenticateCardResponseView;
import dev.ashetm.wallet.views.response.CardResponseView;
import dev.ashetm.wallet.views.response.CardsResponseView;
import dev.ashetm.wallet.views.response.ClientResponseView;
import dev.ashetm.wallet.views.response.ClientsResponseView;
import dev.ashetm.wallet.views.response.TransactionResponseView;
import dev.ashetm.wallet.views.response.TransactionsResponseView;
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
