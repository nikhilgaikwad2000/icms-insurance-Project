package com.icms.insurance.service;

import com.icms.insurance.entity.User;
import com.icms.insurance.repository.UserRepository;
import com.icms.insurance.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;  // ✅ Inject PasswordEncoder

    @Autowired
    private JwtUtil jwtUtil; // ✅ Inject JwtUtil

    @Override
    public String saveUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return "User already registered with this mail";
        }

        // Encrypt the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered Successfully";
    }

    @Override
    public String login(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            // Compare encrypted password
            if (passwordEncoder.matches(password, user.getPassword())) {
                // Generate and return JWT token
                return jwtUtil.generateToken(user.getEmail());
            }
        }

        return "Invalid email or password";
    }

    @Override
    public User findByEmail(String email) {
        Optional<User> users = userRepository.findByEmail(email);
        if (users.isPresent()){
           return users.get();
        }
        else {
            throw new UsernameNotFoundException("User not found with email:"+email);
        }
    }
}
