package dev.ashetm.wallet.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
public class Client implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String firstName;

	private String lastName;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	@Builder.Default
	private List<Card> cards = new ArrayList<>();
	
	public void setCard(Card card) {
		this.cards.add(card);
	}

}
