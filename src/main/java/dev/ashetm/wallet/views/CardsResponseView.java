package dev.ashetm.wallet.views;

import java.util.List;

import dev.ashetm.wallet.entities.Card;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class CardsResponseView implements ResponseView {

	@ApiModelProperty(
			name = "cards", 
			dataType = "Card[]", 
			readOnly = false, 
			allowEmptyValue = true, 
			notes = "List of Card object to send to front", 
			position = 0, 
			hidden = false, 
			required = false)
	@Setter
	private List<Card> cards;

	public CardsResponseView(List<Card> cards) {
		super();
		this.cards = cards;
	}
	
	public static List<Card> to(CardsResponseView cardsResponseView) {
		return cardsResponseView.getCards();
	}
	
	public static CardsResponseView from(List<Card> cards) {
		return new CardsResponseView(cards);
	}

}
