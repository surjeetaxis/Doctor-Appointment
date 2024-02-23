package com.javatodev.api.controller;
import com.javatodev.api.model.request.Auth;
import com.javatodev.api.model.response.Response;
import com.javatodev.api.service.AuthService;
import com.javatodev.api.util.JwtGenerator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:3000")
    public Response login(@RequestBody Auth requestBody, HttpServletResponse response) {
        try {
            Auth authByEmail = authService.getLogin(requestBody);
            if(authByEmail!=null) {
                String accessToken = JwtGenerator.generateJwtToken(authByEmail.getEmail(),authByEmail.getPassword());
                Cookie cookie = new Cookie("accessToken", accessToken);
                cookie.setSecure(true); // You may need to adjust this based on your environment
                cookie.setHttpOnly(true);
                response.addCookie(cookie);
                authByEmail.setAccessToken(accessToken);
                return new Response(200, "Successfully Logged !!", true, authByEmail);
            }else {
                return new Response(400, "Login failed !!", true, null);
            }
        } catch (Exception e) {
            // Handle exceptions appropriately
            return new Response(500, "Internal Server Error", false, null);
        }
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody Auth request) {
        return ResponseEntity.ok("User verified successfully!");
    }

    @PostMapping("/reset-password/confirm")
    public ResponseEntity<String> resetPasswordConfirm(@RequestBody Auth request) {
        return ResponseEntity.ok("User verified successfully!");
    }

    @GetMapping("/user/verify/{userId}/{uniqueString}")
    public ResponseEntity<String> verifyUser(@PathVariable String userId, @PathVariable String uniqueString) {
        return ResponseEntity.ok("User verified successfully!");
    }

    @GetMapping("/verified")
    public ResponseEntity<String> verified() {
        return ResponseEntity.ok("User verified successfully!");
    }

    @GetMapping("/expired/link")
    public ResponseEntity<String> verificationExpired() {
        return ResponseEntity.ok("User verified successfully!");
    }

    // Other methods if needed
}