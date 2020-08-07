package dev.ashetm.wallet.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;

@Table
@Entity
@ApiIgnore
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Builder.Default
	private BigDecimal amount = BigDecimal.ZERO;

	@Builder.Default
	private LocalDate date = LocalDate.now();

	@JsonBackReference
	private Card card;
	
	@Override
	public String toString() {
		return "- Id " + this.getId() + ": " + this.getAmount() + " at " + this.getDate();
	}

}
