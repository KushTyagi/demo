package com.example.demo.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GenericRepo<T> /* extends CrudRepository<T, ID> */ {

	public T create(T u);
	public List<T> getUser();
	public T update(T t, long id);
	public T getById(Object id);
}
