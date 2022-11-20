package com.example.demo.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //Data Access Layer
public interface UserRepository extends JpaRepository<User,Long> {


    @Query("SELECT s FROM User s WHERE s.email = ?1") //User as aEntity as we write in User class
    Optional<User> findUserByEmail(String email);
}