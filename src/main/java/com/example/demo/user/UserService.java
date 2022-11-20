package com.example.demo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service



public class UserService {



        private final UserRepository userRepository;

        @Autowired
        public UserService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        public List<User> getUsers() {
            return userRepository.findAll();

        }

        public void addNewUser(User user) {
            Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());

            if (userOptional.isPresent()) {
                throw new IllegalStateException("Email taken");
            }
            userRepository.save(user);
        }

        public void deleteUser(Long userId) {
            boolean exist = userRepository.existsById(userId);

            if (!exist) {
                throw new IllegalStateException("User does not exist (id:" + userId + ") you wanted to delete");
            }
            userRepository.deleteById(userId);
        }

        @Transactional
        public void updateUser(Long userId, String name, String email) {
            User user= userRepository.findById(userId).orElseThrow(() -> new IllegalStateException(
                    "User with id " + userId + " does not exist"));

            if (name != null && name.length() > 0 && !Objects.equals(user.getName(),name)){
                user.setName(name);
            }

            if(email != null && email.length() > 0 && !Objects.equals(user.getEmail(),email)){
                Optional<User> optionalUser = userRepository.findUserByEmail(email);

                if(optionalUser.isPresent()){
                    throw new IllegalStateException("E-mail is taken");
                }
                user.setEmail(email);
            }
        }
    }

