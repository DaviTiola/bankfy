package dev.davitiola.bankfy.service;

import dev.davitiola.bankfy.model.User;
import dev.davitiola.bankfy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.processing.Find;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser (User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }


        if (userRepository.findByCpf(user.getCpf()).isPresent()) {
            throw new RuntimeException("Cpf already registered");
        }

        return userRepository.save(user);

    }



}
