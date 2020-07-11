package com.predoana.app.web.jdbc;

import javax.swing.tree.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
    }        user.setId(rs.getInt("id"));
 user.setName(rs.getString("name"));
 user.setEmail(rs.getString("email"));
        return user;
} }


