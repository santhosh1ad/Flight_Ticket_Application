package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Tables.UserTable;

public interface UserRepo extends JpaRepository<UserTable, Long>{
	
	 Optional<UserTable> findByName(String Name);

}
