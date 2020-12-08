
package acme.features.supplier.section;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.items.Section;
import acme.entities.roles.Supplier;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class SupplierSectionListService implements AbstractListService<Supplier, Section> {

	// Internal state ---------------------------------------------------------------

	@Autowired
	SupplierSectionRepository repository;


	// AbstractListService<Supplier, Section> interface ---------------------------------

	@Override
	public boolean authorise(final Request<Section> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Section> request, final Section entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "indexer", "description", "photo", "item");
	}

	@Override
	public Collection<Section> findMany(final Request<Section> request) {
		assert request != null;

		Collection<Section> result;

		int itemId;

		itemId = request.getModel().getInteger("id");

		result = this.repository.findManyByItemId(itemId);

		return result;
	}

}
