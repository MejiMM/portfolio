package com.portfolio.controller;

import com.portfolio.DTO.LoginDTO;
import com.portfolio.security.JwtAuthResponseDto;
import com.portfolio.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthController {
    
    @Autowired
    private AuthenticationManager authManager;
    
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
        
    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponseDto> authenticateUser(@RequestBody LoginDTO loginDto) {
        
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String token = jwtTokenProvider.generarToken(authentication);
        
        return ResponseEntity.ok(new JwtAuthResponseDto(token));
    }
}
