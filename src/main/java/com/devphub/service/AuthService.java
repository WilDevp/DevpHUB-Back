package com.devphub.service;

import com.devphub.dto.RegisterRequest;
import com.devphub.model.NotificationEmail;
import com.devphub.model.User;
import com.devphub.model.VerificationToken;
import com.devphub.repository.UserRepository;
import com.devphub.repository.VerificationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthService {

    @Autowired
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final VerificationTokenRepository verificationTokenRepository;
    private final MailService mailService;
    public void signup(RegisterRequest registerRequest){
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setCreated(Instant.now());
        user.setEnabled(false);

        userRepository.save(user);

        String token = generateVerifcationToken(user);
        mailService.sendEmail(new NotificationEmail("Pleace Activate your account",
                user.getEmail(),"Thank you for signing up to DevpHub, " +
                "pleace click on the below url to activate your account: "+
                "http://localhost:8080/api/auth/accountVerfication/"+token));
    }

    private String generateVerifcationToken(User user){
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);

        verificationTokenRepository.save(verificationToken);
        return token;
    }
}
