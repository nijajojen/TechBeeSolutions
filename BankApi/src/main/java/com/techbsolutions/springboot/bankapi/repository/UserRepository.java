package com.techbsolutions.springboot.bankapi.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techbsolutions.springboot.bankapi.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel ,String>{

	
}
