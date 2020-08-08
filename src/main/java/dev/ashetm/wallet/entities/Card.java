package dev.ashetm.wallet.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import dev.ashetm.wallet.enums.CardTypeEnum;
import lombok.*;
import springfox.documentation.annotations.ApiIgnore;

@Table
@Entity
@ApiIgnore
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Card implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Builder.Default
	private BigDecimal balance = BigDecimal.valueOf(0.0);

	@Builder.Default
	private CardTypeEnum type = CardTypeEnum.UNKNOWN;

	private String password;

	@Builder.Default
	private LocalDate date = LocalDate.now();

	@OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
	@Builder.Default
	private List<Transaction> transactions = new ArrayList<>();

	@ManyToOne
	@JsonBackReference
	private Client client;

//	public void setTransactions(List<Transaction> transactions) {
//		this.transactions = transactions;
//		for(Transaction transaction: transactions) {
//			this.balance.add(transaction.getAmount());
//		}
//	}

//	public void setTransactions(Transaction... transactions) {
//		for(Transaction transaction: transactions) {
//			this.transactions.add(transaction);
//			this.balance.add(transaction.getAmount());
//		}
//	}
	
	@Override
	public String toString() {
		if(this.equals(null)) {
			return "The Account does not exist";
		}
		return "- Id: " + this.getId() + "\n" + "- Balance: " + this.getBalance() + "\n" + "- Transactions: " + this.getTransactions().size() + " transactions";
	}

}
