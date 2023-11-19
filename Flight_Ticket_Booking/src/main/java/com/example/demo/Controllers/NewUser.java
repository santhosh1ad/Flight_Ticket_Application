package com.example.demo.Controllers;

import com.example.demo.Tables.UserTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.UserRepo;

@RestController
@RequestMapping("/NewUser")
public class NewUser {
	
	@Autowired 
	private UserRepo repo;
	
	@Autowired
	private PasswordEncoder pass;
	
	@GetMapping("/add")
	public String AddUser(@RequestParam String Name,@RequestParam String Pass,@RequestParam String Gender, @RequestParam String Role) {
		
		UserTable user = new UserTable(Name, pass.encode(Pass), Gender, Role);
//		user.setGender(Gender);
//		user.setName(Name);
//		user.setPassword(pass.encode(Pass));
//		user.setRole(Role);
		repo.save(user);
		return "Successfully Added";
	}

}
