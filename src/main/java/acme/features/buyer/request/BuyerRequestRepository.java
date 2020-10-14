
package acme.features.buyer.request;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.requests.RequestItem;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface BuyerRequestRepository extends AbstractRepository {

	//@Query("select sh.item from Sheet sh where sh.item.supplier.id =?1")
	//Collection<RequestItem> findRequestItems(int requestId);

	@Query("select r from RequestItem r where r.id =?1")
	RequestItem findOneRequestById(int requestId);

	@Query("select r from RequestItem r where r.buyer.id = ?1")
	Collection<RequestItem> findManyByBuyerId(int buyerId);
}
