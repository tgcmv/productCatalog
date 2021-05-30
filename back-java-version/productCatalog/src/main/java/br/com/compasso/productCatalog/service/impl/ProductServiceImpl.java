package br.com.compasso.productCatalog.service.impl;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.compasso.productCatalog.model.Product;
import br.com.compasso.productCatalog.repository.ProductRepository;
import br.com.compasso.productCatalog.service.IProductService;
import javassist.NotFoundException;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepository repository;

	@Override
	public Collection<Product> findAll() {
		return repository.findAll();
	}

	@Override
	public Collection<Product> filter(Optional<String> description, Optional<BigDecimal> minPrice,
			Optional<BigDecimal> maxPrice) {
		
		Specification<Product> productSpecification = Specification
				.where(minPrice.isPresent() ? (Specification<Product>)(root, query, builder) -> builder.greaterThanOrEqualTo(root.get("price"), minPrice.get()) : null)
				.and(maxPrice.isPresent() ? (Specification<Product>)(root, query, builder) -> builder.greaterThanOrEqualTo(root.get("price"), maxPrice.get()) : null)
				.and(description.isPresent() ? this.like("name", description.get()).or(this.like("description", description.get())) : null);
		return repository.findAll(productSpecification);
	}

	@Override
	public Optional<Product> findById(String id) {
		return repository.findById(id);
	}

	@Override
	public Product insert(Product product) {
		return repository.save(product);
	}

	@Override
	public Product update(String id, Product product) throws NotFoundException {
		repository.findById(id).orElseThrow(() -> new NotFoundException("product not found"));
		product.setId(id);
		return repository.save(product);
	}

	@Override
	public void delete(String id) throws NotFoundException {
		repository.findById(id).orElseThrow(() -> new NotFoundException("product not found"));
		repository.deleteById(id);
	}

	private Specification<Product> like(String column, String value) {
		return (root, query, builder) -> builder.like(builder.upper(root.get(column)), "%" + value.toUpperCase() + "%");
	}

}
