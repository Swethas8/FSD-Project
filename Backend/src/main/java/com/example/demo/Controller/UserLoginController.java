package com.example.demo.Controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.UserLogin;
import com.example.demo.Service.UserLoginService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/users")
public class UserLoginController {
    private final UserLoginService userService;

    @Autowired
    public UserLoginController(UserLoginService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserLogin>> getAllUsers() {
        List<UserLogin> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserLogin> getUserById(@PathVariable Long id) {
    	UserLogin user = userService.getUserById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<UserLogin> registerUser(@RequestBody UserLogin user) {
    	UserLogin createdUser = userService.createUser(user.getName(), user.getEmail(), user.getPassword());
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserLogin> loginUser(@RequestBody UserLogin user) {
    	UserLogin loggedInUser = userService.findUserByEmailAndPassword(user.getEmail(), user.getPassword());
        if (loggedInUser != null) {
            return new ResponseEntity<>(loggedInUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserLogin> updateUser(@PathVariable Long id, @RequestBody UserLogin user) {
    	UserLogin updatedUser = userService.updateUser(id, user);
        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
