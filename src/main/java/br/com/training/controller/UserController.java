package br.com.training.controller;

import javax.validation.Valid;

import br.com.training.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import br.com.training.model.User;

@RestController
@RestControllerAdvice
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
        User objUser = userService.create(user);
        return new ResponseEntity<>(objUser, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{cpf}")
    public ResponseEntity<User> getUser(@PathVariable String cpf) {
        return ResponseEntity.ok(userService.get(cpf));
    }

@PutMapping(path = "/{id}")
    public ResponseEntity<User> updateUser(@RequestBody @Valid User user, @PathVariable Long id) {
        return ResponseEntity.ok(userService.update(user, id));
}

@DeleteMapping(path = "/{id}")
public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
}
}
