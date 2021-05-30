package br.com.compasso.productCatalog.service;

import javassist.NotFoundException;

public interface IWriterService<I, E> {

	E insert(E entity);

	E update(I id, E entity) throws NotFoundException;
	
	void delete(I id) throws NotFoundException;
}
