package it.topnetwork.springboot.quizapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.topnetwork.springboot.quizapplication.entity.User;
import it.topnetwork.springboot.quizapplication.exception.UserNotFoundException;
import it.topnetwork.springboot.quizapplication.repository.UserInterface;

@Service
public class UserServiceImpl implements UserService {

	private UserInterface userServiceInterface;
	
	@Autowired
	public UserServiceImpl(UserInterface theUserServiceInterface) {
		userServiceInterface = theUserServiceInterface;
	}

	@Override
	public List<User> findAll() {
		
		return userServiceInterface.findAll();
	}

	@Override
	public User findById(int theId) {
		Optional<User> result = userServiceInterface.findById(theId);
		
		User theUser = null;
		
		if(result.isPresent()) {
			theUser = result.get();
		} else {
			throw new UserNotFoundException("Id utente non trovato - "+theId);
		}
		
		return theUser;
	}

	@Override
	public void save(User theUser) {
		
		userServiceInterface.save(theUser);

	}

	@Override
	public void delete(int TheId) {
		
		userServiceInterface.deleteById(TheId);

	}

}
