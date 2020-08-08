package dev.ashetm.wallet.views.response;

import java.util.List;

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
public class TransactionsResponseView implements IResponseView {

	@ApiModelProperty(
			name = "transactions", 
			dataType = "Transaction[]", 
			readOnly = false, 
			allowEmptyValue = true, 
			notes = "List of Transaction object to send to front", 
			position = 0, 
			hidden = false, 
			required = true)
	private List<Transaction> transactions;
	
	public static TransactionsResponseView from(List<Transaction> transaction) {
		return new TransactionsResponseView(transaction);
	}

}
