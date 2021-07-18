package com.example.demo;

import com.example.demo.entity.Gender;
import com.example.demo.entity.User;
import com.example.demo.entity.UserProfile;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.Month;

@SpringBootApplication
public class Demo2Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Demo2Application.class, args);
    }
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public void run(String... args) throws Exception {


        User user=new User();
        user.setName("Doston");
        user.setEmail("azimov1316@gmail.com");


        UserProfile userProfile=new UserProfile();
        userProfile.setAddress("Uzbekistan");
        userProfile.setBirthOfDate(LocalDate.of(1998, Month.FEBRUARY,23));
        userProfile.setGender(Gender.MALE);
        userProfile.setPhoneNumber("900061316");


        user.setUserProfile(userProfile);
        userProfile.setUser(user);

        userRepository.save(user);








    }
}
