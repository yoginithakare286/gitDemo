package com.yts.revaux.legacy.rfq.controller;

import com.yts.revaux.legacy.rfq.service.UserService;
import com.yts.revaux.legacy.rfq.vo.UserVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/legacy/rfq/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<UserVO> fetchAllUsers() {  // Updated to match the service method
        return userService.fetchAllUsers();
    }
}
