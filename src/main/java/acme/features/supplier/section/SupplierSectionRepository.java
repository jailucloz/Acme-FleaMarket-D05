
package acme.features.supplier.section;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.items.Item;
import acme.entities.items.Section;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface SupplierSectionRepository extends AbstractRepository {

	@Query("select s from Section s where s.id = ?1")
	Section findOneSectionById(int id);

	@Query("select s from Section s where s.item.id = ?1")
	Collection<Section> findManyByItemId(int id);

	@Query("select i from Item i where i.id = ?1")
	Item findItemForThisSection(int id);

	@Query("select s.item from Section s where s.id = ?1")
	Item findItem(int id);

	@Query("select s from Section s")
	Collection<Section> findManyAll();

	@Query("select i from Item i where i.id=?1")
	Item findOneItemById(int id);

}
