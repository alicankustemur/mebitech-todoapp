package com.mebitech.todoapp.service.base;

import java.util.List;

import com.mebitech.todoapp.domain.base.AbstractEntity;

public interface BaseService<T extends AbstractEntity, ID> {

	public void saveOrUpdate(T entity);

	public List<T> getAll();

	public T get(ID id);

	public void remove(ID id);

}
