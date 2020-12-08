
package acme.features.supplier.section;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.items.Section;
import acme.entities.roles.Supplier;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractDeleteService;

@Service
public class SupplierSectionDeleteService implements AbstractDeleteService<Supplier, Section> {

	@Autowired
	private SupplierSectionRepository repository;


	@Override
	public boolean authorise(final Request<Section> request) {
		assert request != null;

		Section section = this.repository.findOneSectionById(request.getModel().getInteger("id"));
		Principal principal = request.getPrincipal();

		return principal.getAccountId() == section.getItem().getSupplier().getUserAccount().getId() && !section.getItem().getFinalMode();
	}

	@Override
	public void bind(final Request<Section> request, final Section entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Section> request, final Section entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "indexer", "title", "description", "photo", "item");
	}

	@Override
	public Section findOne(final Request<Section> request) {
		Section result;

		result = this.repository.findOneSectionById(request.getModel().getInteger("id"));

		return result;
	}

	@Override
	public void validate(final Request<Section> request, final Section entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void delete(final Request<Section> request, final Section entity) {
		assert request != null;
		assert entity != null;

		this.repository.delete(entity);

	}

}
