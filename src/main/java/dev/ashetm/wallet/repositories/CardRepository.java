package dev.ashetm.wallet.repositories;

import java.util.List;
import java.util.Optional;

import dev.ashetm.wallet.entities.Card;
import dev.ashetm.wallet.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CardRepository extends JpaRepository<Card, Integer> {

	@Query("SELECT card FROM Card as card WHERE card.id = :idCard and " +
			"card.client = (SELECT client FROM Client client WHERE client.id = :idClient)")
	Optional<Card> findCard(@Param("idClient") int idClient, @Param("idCard") int idCard);

	@Query("SELECT card FROM Card as card WHERE card.id = :idCard and card.client = :client")
	Optional<Card> findCard(@Param("client") Client client, @Param("idCard") int idCard);

	@Query("SELECT card FROM Card as card WHERE card.client = (SELECT client FROM Client client WHERE client.id = :idClient)")
	List<Card> findAllCards(@Param("idClient") int idClient);

	@Query("SELECT card FROM Card as card WHERE card.client = :client")
	List<Card> findAllCards(@Param("client") Client client);

}
