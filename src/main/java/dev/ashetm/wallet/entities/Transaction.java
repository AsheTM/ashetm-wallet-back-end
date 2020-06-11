package dev.ashetm.wallet.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Getter
@Builder
@AllArgsConstructor
public class Transaction implements Serializable {
	
	private static int counter = 0;
	
	{ counter++; }
	
	private int id = -1;
	
	@Setter
	private BigDecimal amount = BigDecimal.ZERO;
	
	private LocalDate date = LocalDate.now();

	public Transaction() {
		this.id = counter;
	}

	public Transaction(BigDecimal amount) {
		this.id = counter;
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "- Id " + this.getId() + ": " + this.getAmount() + " at " + this.getDate();
	}

}
