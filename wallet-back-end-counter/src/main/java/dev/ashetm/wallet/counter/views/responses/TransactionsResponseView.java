package dev.ashetm.wallet.counter.views.responses;

import java.util.List;

import dev.ashetm.wallet.counter.models.Transaction;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
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
	@Setter
	private List<Transaction> transactions;

	public TransactionsResponseView(List<Transaction> transactions) {
		super();
		this.transactions = transactions;
	}
	
	public static List<Transaction> to(TransactionsResponseView transactionsResponseView) {
		return transactionsResponseView.getTransactions();
	}
	
	public static TransactionsResponseView from(List<Transaction> transaction) {
		return new TransactionsResponseView(transaction);
	}

}
