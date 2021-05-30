package br.com.compasso.productCatalog.service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;

import br.com.compasso.productCatalog.model.Product;

public interface IProductService extends IReaderService<String, Product>, IWriterService<String, Product>{

	public Collection<Product> filter(Optional<String> description, Optional<BigDecimal> minPrice, Optional<BigDecimal> maxPrice);
}
