package br.com.training.controller;

import javax.validation.Valid;

import br.com.training.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import br.com.training.model.User;
import br.com.training.repository.UserRepository;

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


}
