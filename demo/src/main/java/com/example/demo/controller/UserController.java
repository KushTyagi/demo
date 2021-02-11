package com.example.demo.controller;



import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Addressdto;
import com.example.demo.model.Userdto;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController<T> {
    
	@Autowired
	UserService<Userdto> usrserv;
	
	 @PostMapping() 
	 public ResponseEntity<Userdto> createUser(@Valid @RequestBody Userdto user){
			 Optional<Userdto> obj = usrserv.createUser(user);
				 if(!obj.isPresent()) {
			        	return new ResponseEntity<>(null, HttpStatus.CONFLICT);
			        }
			        Userdto userObj = obj.get();
			            return new ResponseEntity<>(userObj, HttpStatus.CREATED);       
       }
	 
	 @GetMapping("/users") 
	 public ResponseEntity<Object> fetchAll() {
	       Optional<List<Userdto>> userlist = usrserv.getUser();
	    	   if(!userlist.isPresent()) {
		    	   return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		       }
		           return new ResponseEntity<>(userlist.get(), HttpStatus.OK);   
	 }
	 
	@PutMapping("{user_id}")
	public ResponseEntity<Object> Update(@RequestBody Userdto user, @PathVariable long id) {
         Optional<Userdto> userobject = usrserv.Update(user, id);
         Userdto userObject = userobject.get();
         if(Objects.isNull(userObject)) {
        	 return new ResponseEntity<Object>(userObject, HttpStatus.INTERNAL_SERVER_ERROR); 
         }
             return new ResponseEntity<Object>(userObject, HttpStatus.OK);
	}
	
	 @PostMapping("/api/v1/users/{user_id}/addresses") 
	 public ResponseEntity<Object> userAddress(@Valid @RequestBody Addressdto address, @PathVariable long id){ 
	        Optional<Addressdto> addressobj = usrserv.createUser(address,id);
	        if(Objects.isNull(addressobj)) {
	        	return new ResponseEntity<>(addressobj, HttpStatus.CONFLICT);
	        }
	            return new ResponseEntity<>(addressobj, HttpStatus.CREATED);
	 }
	 
	 @GetMapping("/{user_id}/addresses") 
	 public ResponseEntity<Object> fetchAddress(@PathVariable long id) {
		 Optional<Addressdto> addressObj = (Optional<Addressdto>) usrserv.fetchById(id);
			if(Objects.isNull(addressObj)) {
				return new ResponseEntity<>(addressObj, HttpStatus.NO_CONTENT);
			}
	       return new ResponseEntity<>(addressObj, HttpStatus.OK);
	 }
}
