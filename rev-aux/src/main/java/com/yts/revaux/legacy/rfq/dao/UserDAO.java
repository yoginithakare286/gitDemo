package com.yts.revaux.legacy.rfq.dao;

import com.yts.revaux.legacy.rfq.idao.UserIDAO;
import com.yts.revaux.legacy.rfq.rowmapper.UserRowMapper;
import com.yts.revaux.legacy.rfq.vo.UserVO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDAO implements UserIDAO {
    private final JdbcTemplate jdbcTemplate;

    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<UserVO> fetchAllUsers() {
        String sql = "SELECT id, username, role FROM admin";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }
}
