package com.security.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.test.model.User;
import com.security.test.service.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;

	@Override
	public Integer saveUser(User user) {

		//TODO : Encoding Password
		return repo.save(user).getId();
	}

}
