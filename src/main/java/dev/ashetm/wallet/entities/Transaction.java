package dev.ashetm.wallet.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
	private LocalDateTime date = LocalDateTime.now();

	@ManyToOne
	@JsonBackReference
	private Card card;
	
	@Override
	public String toString() {
		return "- Id " + this.getId() + ": " + this.getAmount() + " at " + this.getDate();
	}

}
