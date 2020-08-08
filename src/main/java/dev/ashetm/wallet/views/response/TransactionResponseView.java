package dev.ashetm.wallet.views.response;

import dev.ashetm.wallet.entities.Transaction;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponseView implements IResponseView {

	@ApiModelProperty(
			name = "transaction", 
			dataType = "Transaction", 
			readOnly = false, 
			allowEmptyValue = true, 
			notes = "Transaction object to send to front", 
			position = 0, 
			hidden = false, 
			required = true)
	private Transaction transaction;
	
	public static TransactionResponseView from(Transaction transaction) {
		return new TransactionResponseView(transaction);
	}

}
