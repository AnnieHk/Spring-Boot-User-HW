package com.example.demo.user;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration

public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            User Alper = new User(
                    "Alper",
                    LocalDate.of(1998, Month.MAY, 5),
                    "aednmz@gmail.com");

            User Ahmet = new User(
                    "Ahmet",
                    LocalDate.of(1999, Month.APRIL, 15),
                    "nemokayipolmus@gmail.com");

            User Alex = new User(
                    "Alex",
                    LocalDate.of(1992, Month.AUGUST, 25),
                    "nemokayipolmus123@gmail.com");

            repository.saveAll(
                    List.of(Alper,Ahmet,Alex)
            );


        };
    }

}


