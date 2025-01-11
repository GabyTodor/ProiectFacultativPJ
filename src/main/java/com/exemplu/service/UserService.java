package com.exemplu.service;

import com.exemplu.entity.User;
import com.exemplu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    public Optional<User> findUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        System.out.println("Căutare utilizator: " + username + " -> " + (user.isPresent() ? "Găsit" : "Nu găsit"));
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Găsim utilizatorul în baza de date
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Userul " + username + " nu a fost gasit"));

        // Debugging
        System.out.println("Utilizator găsit: " + user.getUsername());
        System.out.println("Parola: " + user.getPassword());
        System.out.println("Rol: " + user.getRol());

        // Construim un UserDetails valid
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRol()) // Utilizăm metoda roles() pentru a seta rolurile utilizatorului
                .build();
    }


    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Criptare parolă
        user.setRol("USER"); // Setare rol implicit
        userRepository.save(user); // Salvare în baza de date
    }
}
