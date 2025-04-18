package com.example.user_project.service;

import com.example.user_project.model.Users;
import com.example.user_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Users save(Users user) {
        return userRepository.save(user);
    }

    public Users update(Users user) {
        return userRepository.update(user);
    }

    public String deleteById(int id) {
        return userRepository.deleteById(id);
    }

    public List<Users> getAll() {
        return userRepository.getAll();
    }

    public Users getById(int id) {
        return userRepository.getById(id);
    }
}
