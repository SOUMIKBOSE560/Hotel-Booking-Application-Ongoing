package net.hotelapplication.controllers;


import jakarta.ws.rs.Path;
import net.hotelapplication.models.UserCredential;
import net.hotelapplication.services.JwtService;
import net.hotelapplication.services.UserInfoUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserInfoUserDetailsService infoUserDetailsService;


    @PostMapping("/login")
    public String login(@RequestBody UserCredential userCredential) {
        System.out.println(userCredential);
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userCredential.getUsername(),
                        userCredential.getPassword()
                )
        );

        if (authentication.isAuthenticated()) {
            System.out.println("USER IS AUTHENTICATED");
            return jwtService.generateToken(userCredential.getUsername());
        }
        return "EXCEPTION_FAILED";
    }

    @PostMapping("/validate")
    public String validateToken(@RequestHeader("Authorization") String token) throws NoSuchAlgorithmException {
        String bearer = token.substring(7);
        String username = jwtService.extractUsername(bearer);
        UserDetails userDetails = infoUserDetailsService.loadUserByUsername(username);
        if(jwtService.validateToken(bearer,userDetails)){
            return "TOKEN IS VALID";
        }

        return "TOKEN IS NOT VALID";
    }


    @GetMapping("/validatefortest")
    public String validateForTest(@RequestParam String token) throws NoSuchAlgorithmException {
        if(token != null){
            return jwtService.extractUsername(token);
        }
        return null;
    }
}
