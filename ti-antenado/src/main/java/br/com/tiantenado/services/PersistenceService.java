package br.com.tiantenado.services;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface PersistenceService<T, PK extends Serializable> {

	public T getById(PK id);
	public T saveOrUpdate(T entity);
	public void deleteById(PK id);
	public Page<T> findAllPaginated(int page, int pageSize, Sort sort);
	
}
