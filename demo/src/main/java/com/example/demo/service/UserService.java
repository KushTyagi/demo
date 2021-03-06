package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Addressdto;
import com.example.demo.model.Userdto;

public interface UserService<Userdto> {
	
	public Optional<Userdto> createUser(Userdto email);
	public Optional<Addressdto> createUser(Addressdto address, long id);
	public Optional getUser();
	public Optional<Userdto> Update(Userdto u, long id);
	public Object fetchById(Object id);
}
