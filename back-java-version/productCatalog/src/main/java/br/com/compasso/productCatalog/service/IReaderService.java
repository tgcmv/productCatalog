package br.com.compasso.productCatalog.service;

import java.util.Collection;
import java.util.Optional;

public interface IReaderService<I, E> {

	Collection<E> findAll();

	Optional<E> findById(I id);

}
