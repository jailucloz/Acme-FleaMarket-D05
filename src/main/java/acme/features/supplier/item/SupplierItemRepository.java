
package acme.features.supplier.item;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import acme.entities.customisations.Customisation;
import acme.entities.items.Item;
import acme.entities.items.Section;
import acme.entities.requests.RequestItem;
import acme.entities.roles.Supplier;
import acme.framework.repositories.AbstractRepository;

public interface SupplierItemRepository extends AbstractRepository {

	@Query("select s.item from Section s where s.item.supplier.id =?1")
	Collection<Item> findItems(int itemId);

	@Query("select i from Item i where i.id =?1")
	Item findOneItemById(int id);

	@Query("select i from Item i where i.supplier.id = ?1")
	Collection<Item> findManyBySupplierId(int supplierId);

	@Query("select i from Item i where i.ticker = ?1")
	Item findTickerOfItem(String ticker);

	@Query("select s from Supplier s where s.userAccount.id = ?1")
	Supplier findOneSupplierByUserAccount(int userAccountId);

	@Query("select s from Section s where s.item.id = ?1")
	Collection<Section> findSectionByItemId(int itemId);

	@Query("select r from RequestItem r where r.item.id = ?1")
	Collection<RequestItem> findRequestByItemId(int id);

	@Query("select c from Customisation c")
	Customisation findCustomisation();
}
