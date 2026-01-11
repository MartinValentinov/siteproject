package com.example.mysite.controller;

import com.example.mysite.model.MyUserDetailService;
import com.example.mysite.webtoken.JwtService;
import com.example.mysite.webtoken.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContentController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private MyUserDetailService myUserDetailService;

    @GetMapping("/home")
    public String handleWelcome() {
        return "home";
    }

    @GetMapping("/admin/home")
    public String handleAdminHome() {
        return "home_admin";
    }

    @GetMapping("/user/home")
    public String handleUserHome() {
        return "home_user";
    }

    @GetMapping("/login")
    public String handleLogin() {
        return "custom_login";
    }

    @GetMapping("/register/user")
    public String handleRegister() { return "custom_register"; }

    @GetMapping("/error")
    public String handleError() { return "error/403"; }

    @GetMapping("/api/me")
    @ResponseBody
    public String me(Authentication authentication) {
        return authentication.getName();
    }

    @PostMapping("/authenticate")
    @ResponseBody
    public String authenticateAndGetToken(@RequestBody LoginForm loginForm) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginForm.username(), loginForm.password()
                )
        );

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(
                    myUserDetailService.loadUserByUsername(loginForm.username())
            );
        } else {
            throw new UsernameNotFoundException("Invalid credentials");
        }
    }

}