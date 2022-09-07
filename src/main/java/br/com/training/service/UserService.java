package br.com.training.service;

import br.com.training.model.User;
import br.com.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

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

    public User update(User user, Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {

            User userEncontrado = optionalUser.get();
            String nomeInformado = user.getName();
            userEncontrado.setName(nomeInformado);
            String cpfInformado = user.getCpf();
            userEncontrado.setCpf(cpfInformado);
            String emailInformado = user.getEmail();
            userEncontrado.setEmail(emailInformado);
            LocalDate dataNascimentoInformada = user.getBirthDate();
            userEncontrado.setBirthDate(dataNascimentoInformada);
        }
        return userRepository.save(userEncontrado);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
