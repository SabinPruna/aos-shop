package com.sabinshop.UI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sabinshop.UI.model.User;

@Repository("UserRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}