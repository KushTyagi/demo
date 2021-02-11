package com.example.demo.serviceimpl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Address;
import com.example.demo.dao.User;
import com.example.demo.model.Addressdto;
import com.example.demo.model.Userdto;
import com.example.demo.repo.AddressRepository;
import com.example.demo.repo.GenericRepo;
import com.example.demo.repo.UsersRepository;
import com.example.demo.service.UserService;
import com.example.demo.util.DynamicObjectMapper;

@Service
public class UserServiceImpl implements UserService<Userdto>{
	
	@Autowired
	UsersRepository repo;
	
	@Autowired
	AddressRepository addrepo;
	
     public Optional<Userdto> createUser(Userdto user){ 
    	 User userdao = new User();
    	 User saveuser = (User)DynamicObjectMapper.convertObjectToDao(user, userdao);
    	    Optional<User> userDb = repo.findByemail(user.getEmail());
			if(userDb.isPresent()) { 
				System.out.println("Value is present");
				return Optional.ofNullable(null); 
			}
			System.out.println("Value is not present");
			Userdto usrretndto = (Userdto)DynamicObjectMapper.convertObjectToDto(user, userdao);	
		    repo.save(saveuser);
		    return Optional.of(usrretndto); 
		
	 }
     
     @Override
     public Optional<Addressdto> createUser(Addressdto address, long id){ 
    	 Address userdao = new Address();
    	 Address saveaddress = (Address)DynamicObjectMapper.convertObjectToDao(address, userdao);
    	    Optional<User> userdbObj = repo.findById(id);
			if(userdbObj.isPresent()) { 
				User userObjfromOptnal = userdbObj.get();
				userObjfromOptnal.setAddress(saveaddress);
				User user1 = repo.save(userObjfromOptnal);
				Optional<Address> optionalUser = Optional.of(user1.getAddress());
				Addressdto addreretndto = (Addressdto)DynamicObjectMapper.convertObjectToDto(address, saveaddress);	
			    return Optional.of(addreretndto);
			}
		    return Optional.of(null); 
	 }

	public Optional<List<Userdto>> getUser() {
			List<User> list = repo.findAll();
			if(list.isEmpty()) {
				return Optional.ofNullable(null); 
			}
			Userdto d = new Userdto();
			d.setList(list); 
			Optional<List<Userdto>> NotEmptyList = Optional.of(d.getList());
			return NotEmptyList; 
	}
	
	@Override
	public Optional<Userdto> Update(Userdto u, long id){
		 Optional<User> usrobj = repo.findById(id);
		 Predicate<Long> ids = s ->(s!=null);
		 User usr =  usrobj.get();
		 if(ids.test(usr.getUserid())) {
			 usr.setEmail(u.getEmail());
			 usr.setName(u.getName());
			 usr.setPhoneno(u.getPhoneno());
			 repo.save(usr);
			 Userdto usrretndto = (Userdto)DynamicObjectMapper.convertObjectToDto(u, usr);
			 Optional<Userdto> optionalUser = Optional.of(usrretndto);
			 return optionalUser;
		 }
		  return null;
	}
	
	public Optional<Addressdto> findAddress(long id){
		Optional<User> userdb = repo.findById(id);
		if(userdb.isPresent()) {
			Addressdto dtoadder = new Addressdto();
			Address adress = userdb.get().getAddress();
			Addressdto addreretndto = (Addressdto)DynamicObjectMapper.convertObjectToDto(dtoadder, adress);	
			return Optional.of(addreretndto);
		}
		    return Optional.of(null);
	}
	
	public Userdto fetchById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}
}