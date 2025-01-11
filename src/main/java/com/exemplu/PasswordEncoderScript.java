package com.exemplu;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderScript {
    public static void main(String[] args) {
        // Parola originală
        String rawPassword = "secret123";

        // Instanță BCryptPasswordEncoder
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // Criptarea parolei
        String encodedPassword = encoder.encode(rawPassword);

        // Afișarea parolei criptate
        System.out.println("Parola originală: " + rawPassword);
        System.out.println("Parola criptată: " + encodedPassword);
    }
}
