package com.yts.revaux.legacy.rfq.rowmapper;

import com.yts.revaux.legacy.rfq.vo.UserVO;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<UserVO> {
    @Override
    public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserVO user = new UserVO();
        user.setId(rs.getLong("id"));
        user.setUsername(rs.getString("username"));
        user.setRole(rs.getString("role"));
        return user;
    }
}
