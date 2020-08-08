package dev.ashetm.wallet.views.response;

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
public class CardResponseView implements IResponseView {

	@ApiModelProperty(
			name = "card", 
			dataType = "Card", 
			readOnly = false, 
			allowEmptyValue = true, 
			notes = "Card object to send to front", 
			position = 0, 
			hidden = false, 
			required = true)
	private Card card;
	
	public static CardResponseView from(Card card) {
		return new CardResponseView(card);
	}
}
