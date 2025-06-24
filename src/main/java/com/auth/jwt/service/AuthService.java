package com.auth.jwt.service;

import com.auth.jwt.dto.NewUserDto;
import com.auth.jwt.dto.RequestDto;
import com.auth.jwt.dto.TokenDto;
import com.auth.jwt.model.AuthUser;
import com.auth.jwt.repository.AuthUserRepository;
import com.auth.jwt.security.JwtProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private AuthUserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    public String register(NewUserDto dto) {
        // Se reemplaza builder() por un constructor manual
        AuthUser user = new AuthUser(0, dto.getUsername(), passwordEncoder.encode(dto.getPassword()), dto.getRole());
        repo.save(user);
        return "Usuario registrado correctamente";
    }

    public TokenDto login(RequestDto dto) {

        Optional<AuthUser> optionalUser = repo.findByUsername(dto.getUsername());
        
        if (optionalUser.isEmpty()) {
            System.out.println(">>> Usuario no encontrado: " + dto.getUsername());
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario no registrado");
        }

        AuthUser user = optionalUser.get();

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales inválidas");
        }

        String token = jwtProvider.createToken(user);
        return new TokenDto(user.getUsername(), token);
    }

    public boolean validateToken(RequestDto dto, String token) {
        return jwtProvider.validate(token, dto);
    }
}
