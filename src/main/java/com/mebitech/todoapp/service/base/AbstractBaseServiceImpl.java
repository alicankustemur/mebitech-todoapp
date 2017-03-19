package com.mebitech.todoapp.service.base;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mebitech.todoapp.domain.base.AbstractEntity;
import com.mebitech.todoapp.repository.base.BaseRepository;

@Service
public abstract class AbstractBaseServiceImpl<T extends AbstractEntity, ID extends Serializable> implements BaseService<T, ID> {

	@Autowired
	private BaseRepository<T, ID> baseRepository;
	
	public AbstractBaseServiceImpl(BaseRepository<T, ID> baseRepository) {
		super();
		this.baseRepository = baseRepository;
	}

	@Override
	public void saveOrUpdate(T entity) {
		baseRepository.save(entity);
	}

	@Override
	public List<T> getAll() {
		return baseRepository.findAll();
	}

	@Override
	public T get(ID id) {
		return baseRepository.findOne(id);
	}

	@Override
	public void remove(ID id) {
		baseRepository.delete(id);
	}

}
