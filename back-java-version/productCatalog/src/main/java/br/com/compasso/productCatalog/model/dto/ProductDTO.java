package br.com.compasso.productCatalog.model.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.compasso.productCatalog.model.Product;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class ProductDTO {
	
	@Min(0)
	private Long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String description;
	
	@NotNull @Min(0)
	private BigDecimal price;
	
	public ProductDTO(Product p) {
		this.id = p.getId();
		this.name = p.getName();
		this.description = p.getDescription();
		this.price = p.getPrice();
	}
	
	public static Product toEntity(ProductDTO dto) {
		return Product.builder()
				.id(dto.id)
				.name(dto.name)
				.description(dto.description)
				.price(dto.price).build();
	}
}
