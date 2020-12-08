
package acme.entities.items;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Section extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotNull
	@Positive
	@Column(unique = true)
	private Integer				indexer;

	@NotBlank
	private String				title;

	@NotBlank
	@Size(min = 1, max = 256)
	private String				description;

	@URL
	private String				photo;

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Item				item;

}
