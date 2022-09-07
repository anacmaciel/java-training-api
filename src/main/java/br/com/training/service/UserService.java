package br.com.training.service;

import br.com.training.model.User;
import br.com.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
@Autowired
    private UserRepository userRepository;

public User create(User user) {
    return userRepository.save(user);
}

public User get(String cpf) {
    return userRepository.findByCpf(cpf);
}


}
