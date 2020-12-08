
package acme.features.supplier.section;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.items.Item;
import acme.entities.items.Section;
import acme.entities.roles.Supplier;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class SupplierSectionCreateService implements AbstractCreateService<Supplier, Section> {

	@Autowired
	private SupplierSectionRepository repository;


	@Override
	public boolean authorise(final Request<Section> request) {
		assert request != null;

		Item item = this.repository.findOneItemById(request.getModel().getInteger("itemId"));
		Principal principal = request.getPrincipal();

		return principal.getAccountId() == item.getSupplier().getUserAccount().getId();
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

		model.setAttribute("itemId", request.getModel().getInteger("itemId"));

		request.unbind(entity, model, "indexer", "title", "description", "photo", "item");
	}

	@Override
	public Section instantiate(final Request<Section> request) {
		Section result;
		Item item = this.repository.findOneItemById(request.getModel().getInteger("itemId"));

		result = new Section();

		result.setItem(item);

		return result;
	}

	@Override
	public void validate(final Request<Section> request, final Section entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<Section> request, final Section entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
