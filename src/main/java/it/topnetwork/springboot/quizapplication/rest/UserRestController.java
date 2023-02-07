package it.topnetwork.springboot.quizapplication.rest;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.topnetwork.springboot.quizapplication.entity.User;
import it.topnetwork.springboot.quizapplication.exception.UserNotFoundException;
import it.topnetwork.springboot.quizapplication.service.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {

	private UserService userService;

	public UserRestController(UserService theUserService) {
		userService = theUserService;
	}
	
	// expose "/Users" and return list of Users
		@GetMapping("/users")
		public List<User> findAll() {
			return userService.findAll();
		}
	
		@GetMapping("/users/{userId}")
		public User findById(@PathVariable int userId) {
			
			 User theUser = userService.findById(userId);
			 
			 if(theUser == null) {
				 throw new RuntimeException("Id utente non trovato - " + userId);
			 }
			 
			 return theUser;
		}
		
		@PostMapping("/users")
		public User addUser(@Valid @RequestBody User theUser) {
			
			theUser.setId(0);
			
//			if(theUser.getUsername().length() < 3) {
//				throw new RuntimeException("Username troppo breve");
//			}
//			
			theUser.setData(new Date());
			
			userService.save(theUser);
			
			return theUser;
		}
	
		
		@PatchMapping("/users")
		public User updateUser(@RequestBody User theUser) {
			
			theUser.setData(new Date());
			userService.save(theUser);
		
		return theUser;
			
		}
		
		@DeleteMapping("/users/{userId}")
		public String deleteUser(@PathVariable int userId) {
			
			 User theUser = userService.findById(userId);
			 
			 if(theUser == null) {
				 throw new UserNotFoundException("Id utente non trovato - " + userId);
			 }
			 
			 userService.delete(userId);
			 
			 return "id utente eliminato - " + userId;
		}
		
		
		
}
