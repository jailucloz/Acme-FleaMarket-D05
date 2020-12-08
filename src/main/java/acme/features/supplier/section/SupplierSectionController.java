
package acme.features.supplier.section;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.items.Section;
import acme.entities.roles.Supplier;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/supplier/section/")
public class SupplierSectionController extends AbstractController<Supplier, Section> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private SupplierSectionListService	listService;

	@Autowired
	private SupplierSectionShowService	showService;


	// Constructors -----------------------------------------------------------

	@PostConstruct
	private void initialise() {

		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.LIST, this.listService);

	}

}
