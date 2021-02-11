package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Addressdto;
import com.example.demo.model.Userdto;

public interface AddressService<Object> {

	public Optional<Addressdto> createAddress(Addressdto t, String email);
	public Optional<List<Addressdto>> getUser();
	public Optional<Addressdto> Update(Userdto u, long id);
	public Object fetchById(Object id);
	
}
