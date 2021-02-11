package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Addressdto;
import com.example.demo.model.Userdto;

@Repository
public interface AddressRepository extends JpaRepository<Addressdto, Object>{

}
