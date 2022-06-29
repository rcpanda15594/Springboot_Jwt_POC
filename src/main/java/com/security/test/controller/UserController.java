package com.security.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.test.model.User;
import com.security.test.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService service;
	
	//1.Save User data in Database
	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody User user){
		Integer id = service.saveUser(user);
		String body = "User "+id+" Saved";
		//return new ResponseEntity<>(body,HttpStatus.OK);
		return ResponseEntity.ok(body);
	}
}
