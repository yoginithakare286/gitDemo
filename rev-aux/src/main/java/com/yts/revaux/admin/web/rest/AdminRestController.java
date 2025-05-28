package com.yts.revaux.admin.web.rest;

import com.yts.revaux.admin.dto.AdminDTO;
import com.yts.revaux.admin.service.AdminService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {
	
    private static final Logger logger = LoggerFactory.getLogger(AdminRestController.class);


    private final AdminService adminService;

    // Constructor-based injection
    public AdminRestController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/create")
    public AdminDTO createAdmin(@RequestBody AdminDTO adminDTO) {
        logger.info("Received request to create admin: {}", adminDTO.getUsername());
    	System.out.println("in create ===");
        return adminService.createAdmin(adminDTO);  // Call service to create admin and return DTO
    }
}
