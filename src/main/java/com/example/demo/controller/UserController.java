package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    // CREATE
    @PostMapping
    public User create(@RequestBody User user) {
        return repo.save(user);
    }

    // READ ALL
    @GetMapping
    public List<User> getAll() {
        return repo.findAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    // UPDATE
    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return repo.save(user);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
