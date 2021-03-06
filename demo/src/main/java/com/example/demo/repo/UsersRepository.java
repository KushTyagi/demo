package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.User;
import com.example.demo.model.Userdto;
@Repository
public interface UsersRepository extends JpaRepository<User, Long>{

	public Optional<User> findByemail(String email);
}
