package dev.ashetm.wallet.counter.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Getter
@Builder
@AllArgsConstructor
public class Client implements Serializable {
	
	private static int counter = 0;
	
	{ counter++; }
	
	private int id = -1;
	
	@Setter
	private String firstName;

	@Setter
	private String lastName;

	@Setter
	private List<Card> cards = new ArrayList<>();

	public Client() {
		this.id = counter;
	}

	public Client(String firstName, String lastName) {
		this.id = counter;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Client(String firstName, String lastName, List<Card> cards) {
		this.id = counter;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cards = cards;
	}
	
	public void setCard(Card card) {
		this.cards.add(card);
	}

}
