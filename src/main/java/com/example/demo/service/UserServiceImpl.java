package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.UserService;
import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	 @Autowired
	    UserRepository ur;
	 
	 @Override
	 public User saveUser(User u) {
		return ur.save(u);
	}

	@Override
	public User updateUser(User u) {
		return ur.save(u);
	}

	@Override
	public void deleteUser(User u) {
		ur.delete(u);
		
	}

	@Override
	public void deleteUserById(Long id) {
		ur.deleteById(id);
		
	}

	@Override
	public User getUser(Long id) {
		return ur.findById(id).get();
	
	}

	@Override
	public List<User> getAllusers() {
		return ur.findAll();
	}
	
    public User authenticateCliente(String email, String password) {
        // Recherchez l'utilisateur par son adresse e-mail
        User cliente = ur.findByEmail(email);

        if (cliente != null) {
            // Vérifiez si le mot de passe correspond
            if (cliente.getPassword().equals(password)) {
                return cliente; // Authentification réussie
            }
        }
        return null; // Authentification échouée
    }


}
