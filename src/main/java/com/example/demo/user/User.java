package com.example.demo.user;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class User {

    @Id //primary key allocation
    @SequenceGenerator(
            name = "student_sequence", //naming for hibernate
            sequenceName = "student_sequence", //naming for db
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "student_sequence",
            strategy = GenerationType.SEQUENCE
    )

    private Long id;
    private String name;
    @Transient
    private Integer age;
    private LocalDate dob;
    private String email;

    public User(Long id, String name, String email,LocalDate dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    public User() {
    }

    public User(String name, LocalDate dob, String email) {
        this.name = name;
        this.dob = dob;
        this.email = email;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                '}';
    }
}

