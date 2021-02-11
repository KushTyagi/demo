package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.Addressdto;
import com.example.demo.model.Userdto;
import com.example.demo.repo.AddressRepository;
import com.example.demo.service.AddressService;


public class AddressServiceimpl implements AddressService<Object>{

	@Autowired
	AddressRepository addrepo;
	
	@Override
	public Optional<Addressdto> createAddress(Addressdto address, String email) {
		//User user = addrepo.findByemail(email);
		//user.setAddress(address);
		Addressdto addressobj = addrepo.save(address);
		Optional<Addressdto> optionalAddress = Optional.of(addressobj);
		return optionalAddress;
	}

	@Override
	public Optional<List<Addressdto>> getUser() { 
		List<Addressdto> list = (List<Addressdto>) addrepo.findAll();
		Optional<List<Addressdto>> optionalAddress = Optional.of(list);
		return optionalAddress;
	}

	@Override
	public Optional<Addressdto> Update(Userdto u, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object fetchById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}	
}
