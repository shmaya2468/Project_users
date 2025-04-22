package com.example.user_project.service;

import com.example.user_project.answersAPI.AnswersAPIClient;
import com.example.user_project.model.Users;
import com.example.user_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private AnswersAPIClient answersAPIClient;

    public Users save(Users user) {
        return userRepository.save(user);
    }

    public Users update(Users user) {
        return userRepository.update(user);
    }


    public String deleteUserWithHisAnswersByUserId(int userId) {
        try {
            if (userRepository.getById(userId) != null) {
                answersAPIClient.deleteUserWithHisAnswersByUserId(userId);
                userRepository.deleteUser(userId);
                return "The user has been deleted Successfully";
            } else {
                return "User not found";
            }
        } catch (Exception e) {
            return "Error while deleting: " + e.getMessage();
        }
    }

    public List<Users> getAll() {
        return userRepository.getAll();
    }

    public Users getById(int id) {
        return userRepository.getById(id);
    }
}


