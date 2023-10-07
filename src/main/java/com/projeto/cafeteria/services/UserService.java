package com.projeto.cafeteria.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.cafeteria.models.User;
import com.projeto.cafeteria.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public User findById(Integer id) {
		Optional<User> user = userRepository.findById(id);
		
		return user.orElseThrow(() -> new RuntimeException(
			"Usuário não encpntrado! Id: " + id + ", Tipo: " + User.class.getName()
		));
	}
	
	@Transactional
	public User create(User obj) {
		obj.setId(null);
		obj = userRepository.save(obj);
		
		return obj;
	}
	
	@Transactional
	public User update(User obj) {
		User newObj = findById(obj.getId());
		newObj.setPassword(obj.getPassword());
		
		return userRepository.save(newObj);
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			userRepository.deleteById(id);
		} catch (Exception e) {
			throw new RuntimeException("Não é possível excluir pois há entidades relacionadas");
		}
	}
	
}
