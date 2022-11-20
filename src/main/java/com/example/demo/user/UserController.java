package com.example.demo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")//http://localhost:8080/api/v1/user
public class UserController {


//API LAYER



        private final UserService userService;

        @Autowired
        public UserController(UserService userService) {
            this.userService = userService;
        }

        @GetMapping
        public List<User> getUsers() {
            return userService.getUsers();
        }

        @PostMapping
        public void registerUser(@RequestBody User user) {
            userService.addNewUser(user);
        }

        @DeleteMapping(path = "{userId}")
        public void deleteUser(@PathVariable("userId") Long userId) {
            userService.deleteUser(userId);
        }

        @PutMapping(path = "{userId}")
        public void updateUser(
                @PathVariable("userId") Long userId,
                @RequestParam(required = false) String name,
                @RequestParam(required = false) String email) {
            userService.updateUser(usertId,name,email);
        }

    }

