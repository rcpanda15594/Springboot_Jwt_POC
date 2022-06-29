package com.security.test.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.test.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
