package com.javatodev.api.service;

import com.javatodev.api.model.request.Auth;
import com.javatodev.api.model.response.Response;
import com.javatodev.api.repository.AuthRepository;
import com.javatodev.api.util.JwtGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import java.util.List;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    public String createAuth(Auth auth) {
        Auth authByEmail = authRepository.findByEmail(auth.getEmail());
        if(authByEmail!=null){
            return "Email already registered !!";
        }else {
            auth.setRole(Auth.UserRole.PATIENT.name());
            authRepository.save(auth);
            return "Successfully Patient Created !!";
        }
    }

    public Auth getLogin(Auth auth) {
        if (auth.getEmail()!=null && auth.getPassword()!=null) {
            Auth authByEmail = authRepository.findByEmail(auth.getEmail());
            if(authByEmail.getPassword().equals(auth.getPassword())){
                return authByEmail;
            }else {
               return null;
            }
        } else {
            return null;
        }
    }
    public Auth getAuthById(String id) {
        return authRepository.findById(id).orElse(null);
    }

    public Auth updateAuth(String id, Auth auth) {
        if (authRepository.existsById(id)) {
            auth.setId(id);
            return authRepository.save(auth);
        } else {
            return null;
        }
    }

    public Auth findByEmail(String email) {
        return authRepository.findByEmail(email);
    }

    public Auth saveAuth(Auth auth) {
        return authRepository.save(auth);
    }

    public Optional<Auth> findById(String id) {
        return authRepository.findById(id);
    }

    public void deleteAuth(String id) {
        authRepository.deleteById(id);
    }

    public String contact(Auth auth) {
        return "Successfully Email Send !!";
    }
}

