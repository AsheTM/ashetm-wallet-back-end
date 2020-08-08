package dev.ashetm.wallet.views.response;

import java.util.List;

import dev.ashetm.wallet.entities.Card;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardsResponseView implements IResponseView {

	@ApiModelProperty(
			name = "cards", 
			dataType = "Card[]", 
			readOnly = false, 
			allowEmptyValue = true, 
			notes = "List of Card object to send to front", 
			position = 0, 
			hidden = false, 
			required = false)
	private List<Card> cards;
	
	public static CardsResponseView from(List<Card> cards) {
		return new CardsResponseView(cards);
	}

}
