package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.entities.UserRole;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.http.HttpStatus;



	@CrossOrigin("*")
	@RestController
	@RequestMapping("/user")

	public class UserController {
		@Autowired
		private UserService us;
		@Autowired
	    private UserRepository userRepository;
		
		@GetMapping("/getAll")
		public List<User> getAllusers() {
			return us.getAllusers();
	}
		@GetMapping("/get/{id}")
		public User finduserById(@PathVariable Long id) {
			return us.getUser(id);
		}
		
		@PostMapping("/add")
		public User adduser(@RequestBody User u) {
			return us.saveUser(u);
		}
	
		 @PutMapping("/{id}")
		    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
		        User user = us.getUser(id);
		        if (user != null) {
		            user.setRole(updatedUser.getRole());
		            user.setNom(updatedUser.getNom());
		            user.setPrenom(updatedUser.getPrenom());
		            user.setEmail(updatedUser.getEmail());
		            user.setNumtel(updatedUser.getNumtel());
		            user.setAdresse(updatedUser.getAdresse());
		            user.setPassword(updatedUser.getPassword());
		            user.setCodepostal(updatedUser.getCodepostal());
		            user.setVille(updatedUser.getVille());

		            // Enregistrez l'offre mise à jour dans la base de données
		            User userupdate = userRepository.save(user);

		            return ResponseEntity.ok(userupdate);
		        } else {
		            // L'offre n'existe pas, renvoyez une réponse 404 (Not Found)
		            return ResponseEntity.notFound().build();
		        }
		    }
		@DeleteMapping("/delete/{id}")
		public void deleteuser(@PathVariable Long id) {
			 us.deleteUserById(id);
		}
		
		@PostMapping("/login")
		public ResponseEntity<Map<String, String>> logincliente(@RequestBody Map<String,String> requestParams) {
		   
		    
		    String email=requestParams.get("email");
		    String password=requestParams.get("password");
		    
            User cliente=us.authenticateCliente(email,password);
            
		    if (cliente != null && cliente.getRole() == UserRole.Cliente) {
		        // Authentification réussie, renvoyez un message "Vous êtes connecté"
		        Map<String, String> response = new HashMap<>();
		        response.put("message", "Vous êtes connecté");
		        return ResponseEntity.ok(response);
		    } else {
		        // Authentification échouée, renvoyez un message "Essayez encore"
		        Map<String, String> response = new HashMap<>();
		        response.put("message", "Essayez encore");
		        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
		    }
		}

		
		
	}


