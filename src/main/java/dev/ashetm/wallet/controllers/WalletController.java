package dev.ashetm.wallet.controllers;

import dev.ashetm.wallet.views.request.CardRequestView;
import dev.ashetm.wallet.views.request.ClientRequestView;
import dev.ashetm.wallet.views.request.TransactionRequestView;
import dev.ashetm.wallet.views.response.*;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.ashetm.wallet.views.request.AuthenticateCardRequestView;

public interface WalletController {

	@Api(
			position = 0,
			hidden = false,
			description = "All endpoints that concern client")
	@RequestMapping("/api/v1/client")
	interface ClientController {

		@ApiOperation(
				value = "Get one client")
		@ApiImplicitParams({
				@ApiImplicitParam(name = "idClient", type = "int", required = true)
		})
		@ApiResponses({
				@ApiResponse(code = 200, message = "Successfully retrieved Client data")
		})
		@GetMapping("/{idClient}")
		ResponseEntity<ClientResponseView> showClient(
				@PathVariable("idClient") int idClient);

		@ApiOperation(
				value = "Get all clients")
		@ApiImplicitParams({ })
		@ApiResponses({
				@ApiResponse(code = 200, message = "Successfully retrieved Client data list"),
				@ApiResponse(code = 204, message = "The Client data you searching for does not exist")
		})
		@GetMapping("")
		ResponseEntity<ClientsResponseView> showClients();

		@ApiOperation(
				value = "Save a client")
		@ApiImplicitParams({
				@ApiImplicitParam(name = "clientRequestView", type = "ClientRequestView", required = true)
		})
		@ApiResponses({
				@ApiResponse(code = 200, message = "Successfully add new Client")
		})
		@PostMapping("")
		ResponseEntity<ClientResponseView> addClient(
				@RequestBody ClientRequestView clientRequestView);
		
	}


	@Api(
			position = 1, 
			hidden = false, 
			description = "All endpoints that concern card")
	@RequestMapping("/api/v1/client/{idClient}/card")
	interface CardController {

		@ApiOperation(
				value = "Get one card from a client")
		@ApiImplicitParams({
				@ApiImplicitParam(name = "idClient", type = "int", required = true),
				@ApiImplicitParam(name = "idCard", type = "int", required = true)
		})
		@ApiResponses({
				@ApiResponse(code = 200, message = "Successfully retrieved Card list"),
				@ApiResponse(code = 204, message = "The Card data you searching for is not found")
		})
		@GetMapping("/{idCard}")
		ResponseEntity<CardResponseView> showCard(
				@PathVariable("idClient") int idClient,
				@PathVariable("idCard") int idCard);

		@ApiOperation(
				value = "Get all cards from a client")
		@ApiImplicitParams({
				@ApiImplicitParam(name = "idClient", type = "int", required = true)
		})
		@ApiResponses({
				@ApiResponse(code = 200, message = "Successfully retrieved Card list")
		})
		@GetMapping()
		ResponseEntity<CardsResponseView> showCards(@PathVariable("idClient") int idClient);

		@ApiOperation(
				value = "Save a card to a client")
		@ApiImplicitParams({
				@ApiImplicitParam(name = "idClient", type = "int", required = true),
				@ApiImplicitParam(name = "cardRequestView", type = "CardRequestView", required = true)
		})
		@ApiResponses({
				@ApiResponse(code = 200, message = "Successfully retrieved Card list"),
				@ApiResponse(code = 204, message = "The Card data you searching for is not found"),
				@ApiResponse(code = 406, message = "Invalid password format for Card")
		})
		@PostMapping()
		ResponseEntity<CardResponseView> addCard(
				@PathVariable("idClient") int idClient, 
				@RequestBody CardRequestView cardRequestView);

		@ApiOperation(
				value = "Authenticate to a card of a client")
		@ApiImplicitParams({
				@ApiImplicitParam(name = "idClient", type = "int", required = true),
				@ApiImplicitParam(name = "idCard", type = "int", required = true),
				@ApiImplicitParam(name = "authenticateCardRequestView",
						type = "AuthenticateCardRequestView", required = true)
		})
		@ApiResponses({
				@ApiResponse(code = 200, message = "Successfully authenticated Card"),
				@ApiResponse(code = 204, message = "The Card data you searching for is not found")
		})
		@PostMapping("/{idCard}/authenticate")
		ResponseEntity<AuthenticateCardResponseView> authenticate(
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
		@ApiImplicitParams({
				@ApiImplicitParam(name = "idClient", type = "int", required = true),
				@ApiImplicitParam(name = "idCard", type = "int", required = true),
				@ApiImplicitParam(name = "idTransaction", type = "int", required = true)
		})
		@ApiResponses({
				@ApiResponse(code = 200, message = "Successfully retrieved Transaction data"),
				@ApiResponse(code = 204, message = "The Transaction data you searching for is not found")
		})
		@GetMapping("/{idTransaction}")
		ResponseEntity<TransactionResponseView> showTransaction(
				@PathVariable("idClient") int idClient,
				@PathVariable("idCard") int idCard,
				@PathVariable("idTransaction") int idTransaction);

		@ApiOperation(
				value = "Get all transactions of a card of a client")
		@ApiImplicitParams({
				@ApiImplicitParam(name = "idClient", type = "int", required = true),
				@ApiImplicitParam(name = "idCard", type = "int", required = true)
		})
		@ApiResponses({
				@ApiResponse(code = 200, message = "Successfully retrieved Transaction data list of Card of Client")
		})
		@GetMapping()
		ResponseEntity<TransactionsResponseView> showTransactions(
				@PathVariable("idClient") int idClient,
				@PathVariable("idCard") int idCard);

		@ApiOperation(
				value = "Make a withdraw/deposit transaction in a card for a client")
		@ApiImplicitParams({
				@ApiImplicitParam(name = "idClient", type = "int", required = true),
				@ApiImplicitParam(name = "idCard", type = "int", required = true),
				@ApiImplicitParam(name = "transactionRequestView", type = "TransactionRequestView", required = true)
		})
		@ApiResponses({
				@ApiResponse(code = 200, message = "Successfully saved Transaction"),
				@ApiResponse(code = 204, message = "The Transaction data you searching for is not found"),
				@ApiResponse(code = 428, message = "Insufficient balance of Card of Client")
		})
		@PostMapping()
		ResponseEntity<BalanceCardResponseView> makeTransaction(
				@PathVariable("idClient") int idClient,
				@PathVariable("idCard") int idCard,
				@RequestBody TransactionRequestView transactionRequestView);
		
	}

}
