package br.com.compasso.productCatalog.controller;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.productCatalog.model.Product;
import br.com.compasso.productCatalog.model.dto.ProductDTO;
import br.com.compasso.productCatalog.service.IProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import javassist.NotFoundException;

@RestController
@RequestMapping("/products")
@Tag(name = "Product API")
public class ProductController {

	@Autowired
	private IProductService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProductDTO create(@RequestBody @Valid final ProductDTO productDTO) {
		Product product = service.insert(ProductDTO.toEntity(productDTO));
		return new ProductDTO(product);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductDTO> update(@PathVariable(required = true) final Long id,
			@RequestBody @Valid final ProductDTO productDTO) {
		Product product;
		try {
			product = service.update(id, ProductDTO.toEntity(productDTO));
			return ResponseEntity.ok(new ProductDTO(product));
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<ProductDTO> get(@PathVariable(required = true) final Long id) {
		Optional<Product> product = service.findById(id);
		return product.isPresent() ? ResponseEntity.ok(new ProductDTO(product.get())) :  ResponseEntity.notFound().build();
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Collection<ProductDTO> get() {
		return service.findAll().stream().map(ProductDTO::new).collect(Collectors.toList());
	}

	@GetMapping("/search")
	@ResponseStatus(HttpStatus.OK)
	public Collection<ProductDTO> search(@RequestParam(value="q", required = false) Optional<String> description, 
			@RequestParam(value="min_price", required = false) Optional<BigDecimal> minPrice,
			@RequestParam(value="max_price", required = false) Optional<BigDecimal> maxPrice) {
		return service.filter(description, minPrice, maxPrice).stream().map(ProductDTO::new).collect(Collectors.toList());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(required = true) final Long id) {
		try {
			service.delete(id);
			return ResponseEntity.ok().build();
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
