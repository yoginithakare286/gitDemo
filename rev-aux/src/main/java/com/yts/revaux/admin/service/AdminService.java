package com.yts.revaux.admin.service;

import com.yts.revaux.admin.dto.AdminDTO;
import com.yts.revaux.admin.entity.Admin;
import com.yts.revaux.admin.mapper.AdminMapper;
import com.yts.revaux.admin.repository.AdminRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminService {

    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;

    // Constructor-based injection
    public AdminService(AdminRepository adminRepository, AdminMapper adminMapper) {
        this.adminRepository = adminRepository;
        this.adminMapper = adminMapper;
    }

	
    public AdminDTO createAdmin(AdminDTO adminDTO) {
        // ✅ Use MapStruct to convert DTO to Entity
        Admin admin = adminMapper.toEntity(adminDTO);

        // ✅ Save to DB
        Admin savedAdmin = adminRepository.save(admin);

        // ✅ Convert back to DTO using MapStruct
        return adminMapper.toDto(savedAdmin);
    }
}
