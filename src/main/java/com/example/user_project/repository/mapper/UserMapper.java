package com.example.user_project.repository.mapper;

import com.example.user_project.model.Users;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<Users> {
    @Override
    public Users mapRow(ResultSet rs, int rowNum) throws SQLException {


        Users user = new Users();
        user.setUserId((rs.getInt("id")));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setEmail(rs.getString("email"));
        user.setAddress(rs.getString(("address")));
        user.setJoiningDate(rs.getString("joining_date"));
        return user;

    }
}
