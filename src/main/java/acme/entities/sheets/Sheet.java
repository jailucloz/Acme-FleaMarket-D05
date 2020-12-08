
package acme.entities.sheets;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import acme.entities.items.Section;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Sheet extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	/*
	 * The specification sheet consists of one or more sections,
	 * each of which has an indexer (a positive integer), a title,
	 * a description, and an optional photo. Note that the indexers
	 * need not be consecutive, but they must be unique within each
	 * specification sheet. Note too, that an item requires at least a
	 * section in its specification sheet.
	 */

	/*
	 * @NotNull
	 *
	 * @Positive
	 *
	 * @Column(unique = true)
	 * private Integer indexer;
	 *
	 * @NotBlank
	 * private String title;
	 *
	 * @NotBlank
	 *
	 * @Size(min = 1, max = 256)
	 * private String description;
	 *
	 * @URL
	 * private String photo;
	 *
	 * @NotNull
	 *
	 * @Valid
	 *
	 * @ManyToOne(optional = false)
	 * private Item item;
	 */

	@NotNull
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Valid
	public Collection<Section>	sections;

}
