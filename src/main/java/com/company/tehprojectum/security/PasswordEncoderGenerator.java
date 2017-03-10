package com.company.tehprojectum.security;

/**
 * Rename themain to main to Run and generate
 *
 * Created by kdiv on 3/9/17.
 */
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderGenerator {

    public static void themain(String[] args) {

        int i = 0;
        while (i < 10) {
            String password = "correct";
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(password);

            System.out.println(hashedPassword);
            i++;
        }

    }
}