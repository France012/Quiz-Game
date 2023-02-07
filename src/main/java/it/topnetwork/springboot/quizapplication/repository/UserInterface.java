package it.topnetwork.springboot.quizapplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import it.topnetwork.springboot.quizapplication.entity.User;

public interface UserInterface extends JpaRepository<User, Integer> {
	
	
}
