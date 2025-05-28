package com.yts.revaux.legacy.rfq.service;

import com.yts.revaux.legacy.rfq.manager.UserManager;
import com.yts.revaux.legacy.rfq.vo.UserVO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserManager userManager;

    public UserService(UserManager userManager) {
        this.userManager = userManager;
    }

    public List<UserVO> fetchAllUsers() {  
        return userManager.fetchAllUsers();
    }
}
