package com.example.user_project.repository;


import com.example.user_project.model.Users;
import com.example.user_project.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Users save(Users user) {
        try {
            String sql = "INSERT INTO users(first_name , last_name , age , email , address  , joining_date) VALUES (? ,? , ? ,? ,? , ? )";
            jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(),user.getAge()  ,user.getEmail() , user.getAddress() , user.getJoiningDate());
            return getByEmailHelper(user.getEmail());
        } catch (Exception e) {
            System.out.println("Error saving user: " + e.getMessage());
            return null;
        }
    }




    public Users update(Users user) {
        try {
            String sql = "UPDATE users SET first_name = ? , last_name = ? , age = ? , email = ? , address = ? , joining_date = ?  WHERE id = ?";
            jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getAge() , user.getEmail(), user.getAddress(),user.getJoiningDate() , user.getUserId());
            return getById(user.getUserId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String deleteUser(int id){
        try {
            String sql = "DELETE FROM users WHERE id = ?";
            jdbcTemplate.update(sql, id);
            return "The user has been deleted Successfully , with his answers";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Users> getAll() {
        try {
            String sql = "SELECT * FROM users";
            List<Users> users = jdbcTemplate.query(sql, new UserMapper());
            return users;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Users getByEmailHelper(String email){
        try {
            String sql = "SELECT * FROM users WHERE email = ? ";
            return jdbcTemplate.queryForObject(sql, new UserMapper(), email);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Users getById(int id){
        try {
            String sql = "SELECT * FROM users WHERE id = ? ";
            return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
