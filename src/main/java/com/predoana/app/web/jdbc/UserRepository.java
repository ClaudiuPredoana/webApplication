package com.predoana.app.web.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplateAutoConfiguration jdbcTemplate;

 @Transactional(readOnly=true)
    public List<User> findAll() {
        return jdbcTemplate.query("select * from users", new UserRowMapper());
    }

    @Transactional(readOnly=true)
    public User findUserById(int id) {
    return jdbcTemplate.queryForObject("select * from users where id=?",                                        new Object[]{id}, new UserRowMapper());
}
    public User create(final User user) {
     final String sql = "insert into users(name,email) values(?,?)";
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection connection)                        throws SQLException {                    PreparedStatement ps = connection                            .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);                    ps.setString(1, user.getName());                    ps.setString(2, user.getEmail());                    return ps;                }            }, holder);
        int newUserId = holder.getKey().intValue();
        user.setId(newUserId);
        return user;
 } }

