package dev.ashetm.wallet.repositories;

import java.util.List;
import java.util.Optional;

import dev.ashetm.wallet.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	@Query("SELECT trs FROM Transaction as trs WHERE trs.id = :idTransaction and " +
			"trs.card = (SELECT card FROM Card as card WHERE card.id = :idCard and " +
			"card.client = (SELECT client FROM Client as client WHERE client.id = :idClient))")
	Optional<Transaction> findTransaction(@Param("idClient") int idClient,
										  @Param("idCard") int idCard,
										  @Param("idTransaction") int idTransaction);

	@Query("SELECT trs FROM Transaction as trs WHERE " +
			"trs.card = (SELECT card FROM Card as card WHERE card.id = :idCard and " +
			"card.client = (SELECT client FROM Client as client WHERE client.id = :idClient))")
	List<Transaction> findAllTransactions(@Param("idClient") int idClient,
											@Param("idCard") int idCard);

}
