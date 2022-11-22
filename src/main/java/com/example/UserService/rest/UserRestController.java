package com.example.UserService.rest;

import com.example.UserService.entity.User;
import com.example.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class UserRestController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable long id) {
        return userRepository.findById(id).get();
    }

    @PostMapping("/user/register")
    public User register(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable long id) {
        userRepository.deleteById(id);
        return "Deleted user id - " + id;
    }

    @PutMapping("/user")
    public User update(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/user/login")
    public User login(@RequestParam String username, @RequestParam String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
