
package acme.features.supplier.section;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.items.Section;
import acme.entities.roles.Supplier;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class SupplierSectionShowService implements AbstractShowService<Supplier, Section> {

	// Internal state -------------------------------------------------------------

	@Autowired
	SupplierSectionRepository repository;


	// AbstractShowService<Supplier, Section> interface -------------------------------

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

		request.unbind(entity, model, "indexer", "title", "description", "photo");
	}

	@Override
	public Section findOne(final Request<Section> request) {
		assert request != null;

		Section result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneSectionById(id);

		return result;
	}

}
