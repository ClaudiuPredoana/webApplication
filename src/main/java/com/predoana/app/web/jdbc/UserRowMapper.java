import com.predoana.app.web.jdbc.User;

import javax.swing.tree.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        return user;    } }
