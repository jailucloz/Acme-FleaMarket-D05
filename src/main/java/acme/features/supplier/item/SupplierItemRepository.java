
package acme.features.supplier.item;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import acme.entities.items.Item;
import acme.framework.repositories.AbstractRepository;

public interface SupplierItemRepository extends AbstractRepository {

	@Query("select sh.item from Sheet sh where sh.item.supplier.id =?1")
	Collection<Item> findItems(int itemId);

	@Query("select i from Item i where i.id =?1")
	Item findOneItemById(int id);

	@Query("select i from Item i where i.supplier.id = ?1")
	Collection<Item> findManyBySupplierId(int supplierId);
}
