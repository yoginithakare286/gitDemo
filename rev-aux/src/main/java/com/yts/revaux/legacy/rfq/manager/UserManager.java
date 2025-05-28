package com.yts.revaux.legacy.rfq.manager;

import com.yts.revaux.legacy.rfq.dao.UserDAO;
import com.yts.revaux.legacy.rfq.vo.UserVO;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UserManager {
    private final UserDAO userDAO;

    public UserManager(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<UserVO> fetchAllUsers() {  
        return userDAO.fetchAllUsers();
    }
}
