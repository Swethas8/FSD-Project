package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.UserLogin;
import com.example.demo.Repo.UserLoginRepo;

@Service
public class UserLoginService {
    private final UserLoginRepo userRepository;

    @Autowired
    public UserLoginService(UserLoginRepo userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserLogin> getAllUsers() {
        return userRepository.findAll();
    }

    public UserLogin getUserById(Long id) {
        Optional<UserLogin> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    public UserLogin createUser(String name, String email, String password) {
    	UserLogin user = new UserLogin(name, email, password);
        return userRepository.save(user);
    }

    public UserLogin findUserByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public UserLogin updateUser(Long id, UserLogin user) {
        Optional<UserLogin> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
        	UserLogin existingUser = userOptional.get();
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            return userRepository.save(existingUser);
        } else {
            return null;
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
