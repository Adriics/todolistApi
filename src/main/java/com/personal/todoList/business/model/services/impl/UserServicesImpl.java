package com.personal.todoList.business.model.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.personal.todoList.business.model.User;
import com.personal.todoList.business.model.dtos.UserDTO;
import com.personal.todoList.business.model.services.UserServices;
import com.personal.todoList.integration.model.UserPL;
import com.personal.todoList.integration.repositories.UserPLRepository;

@Service
public class UserServicesImpl implements UserServices {
	

    private final UserPLRepository userPLRepository;
    private final ModelMapper mapper;

    public UserServicesImpl(UserPLRepository userPLRepository, ModelMapper mapper) {
        this.userPLRepository = userPLRepository;
        this.mapper = mapper;
    }

    @Override
    public Long createUser(User user) {
        if (user.getId() != null) {
            throw new IllegalStateException("Para crear un usuario, el id tiene que ser null");
        }
        return userPLRepository.save(mapper.map(user, UserPL.class)).getId();
    }

    @Override
    public Optional<User> read(Long id) {
        Optional<UserPL> optionalPL = userPLRepository.findById(id);
        if (optionalPL.isEmpty()) {
            throw new IllegalArgumentException("Usuario con id " + id + " no encontrado");
        }
        return Optional.ofNullable(mapper.map(optionalPL.get(), User.class));
    }

    @Override
    public void update(User user) {
        if (!userPLRepository.existsById(user.getId())) {
            throw new IllegalStateException("Usuario no existente");
        }
        userPLRepository.save(mapper.map(user, UserPL.class));
    }

    @Override
    public void delete(Long id) {
        if (!userPLRepository.existsById(id)) {
            throw new IllegalStateException("Usuario no existente");
        }
        userPLRepository.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        List<UserPL> usersPL = userPLRepository.findAll();
        return usersPL.stream()
                .map(userPL -> mapper.map(userPL, User.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> getAllDTO() {
        List<UserPL> usersPL = userPLRepository.findAll();
        return usersPL.stream()
                .map(userPL -> mapper.map(userPL, UserDTO.class))
                .collect(Collectors.toList());
    }

}
