package com.example.demo.serviceimpl;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.demo.model.Userdto;
import com.example.demo.repo.UsersRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
	UsersRepository usersrepository;
    
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	 // Optional<Userdto> user = usersrepository.findByemail(email);
	  //Userdto userDb = user.get();
	  //if(userDb == null) {
		//  throw new UsernameNotFoundException(email);
	  //}
		//return new org.springframework.security.core.userdetails.User(userDb.getEmail(), userDb.getPassword(),new ArrayList<>());
		return null;
	}

}
