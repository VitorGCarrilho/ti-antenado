package br.com.tiantenado.services.impl;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tiantenado.services.PersistenceService;

public abstract class BasicPersistenceServiceImpl<T, PK extends Serializable> implements PersistenceService<T,PK>{
	
	/**
	 * HookMethod to get A {@link Repository}
	 * @return
	 */
	public abstract JpaRepository<T, PK> getRepository();

	@Override
	public T getById(PK id) {
		return getRepository().findOne(id);
	}

	@Override
	public T saveOrUpdate(T entity) {
		return getRepository().save(entity);
	}

	@Override
	public void deleteById(PK id) {
		getRepository().delete(id);;
	}

	@Override
	public Page<T> findAllPaginated(int page, int pageSize, Sort sort) {
		return getRepository().findAll(new PageRequest((page -1), pageSize, sort));
	}
	
}
