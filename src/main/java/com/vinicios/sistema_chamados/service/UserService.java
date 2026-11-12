package com.vinicios.sistema_chamados.service;

import com.vinicios.sistema_chamados.config.ValidationConfig;
import com.vinicios.sistema_chamados.dto.CreateUserDTO;
import com.vinicios.sistema_chamados.dto.UserResponseDTO;
import com.vinicios.sistema_chamados.model.User;
import com.vinicios.sistema_chamados.model.UserRole;
import com.vinicios.sistema_chamados.repository.UserRepository;
import jakarta.validation.Validator;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final List<Long> LISTIDENTIFIER = new ArrayList<>();

    public UserResponseDTO createUser(CreateUserDTO createUserDTO){
        Validator validator = ValidationConfig.getValidator();
        var validations = validator.validate(createUserDTO);
        if(!validations.isEmpty()){
            validations.forEach(error -> System.out.println(error.getMessage()));
            return null;
        }
        try{
            User user = new User.Builder().identifier(generateIdentifier()).name(createUserDTO.name()).email(createUserDTO.email()).password(createUserDTO.password()).department(null).userRole(UserRole.valueOf(createUserDTO.userRole().toUpperCase())).build();
            UserRepository.save(user);
            return new UserResponseDTO(user.getIdentifier(), user.getName(), user.getEmail(), user.getDepartment().getName(), user.getUserRole());
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return null;
        }
    }

    public List<UserResponseDTO> listUsers(){
        List<UserResponseDTO> userResponseDTO = new ArrayList<>();
        for(User user : UserRepository.findAll()){
            UserResponseDTO userDTO = new UserResponseDTO(user.getIdentifier(), user.getName(), user.getEmail(), null, user.getUserRole());
            userResponseDTO.add(userDTO);
        }
        return userResponseDTO;
    }

    public UserResponseDTO deleteUser(long identifier){
        User user = UserRepository.findByIdentifier(identifier);
        UserRepository.delete(user.getId());
        return new UserResponseDTO(user.getIdentifier(), user.getName(), user.getEmail(), user.getDepartment().getName(), user.getUserRole());
    }

    public Long generateIdentifier(){
        while(true){
            Long identifier = LISTIDENTIFIER.stream().mapToLong(Long::longValue).max().orElse(0L) + 1L;
            if(UserRepository.findByIdentifier(identifier) == null){
                return identifier;
            }
            LISTIDENTIFIER.add(identifier);
        }
    }



}
