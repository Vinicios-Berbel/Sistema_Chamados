package com.vinicios.sistema_chamados.controller;

import com.vinicios.sistema_chamados.dto.CreateUserDTO;
import com.vinicios.sistema_chamados.dto.UserResponseDTO;
import com.vinicios.sistema_chamados.model.User;
import com.vinicios.sistema_chamados.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    UserService userService = new UserService();

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> listAll(){
        return new ResponseEntity<>(userService.listUsers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@Valid @RequestBody CreateUserDTO user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/{identifier}")
    public ResponseEntity<UserResponseDTO> delete(@PathVariable Long identifier){
        return new ResponseEntity<>(userService.deleteUser(identifier), HttpStatus.NO_CONTENT);
    }
}
