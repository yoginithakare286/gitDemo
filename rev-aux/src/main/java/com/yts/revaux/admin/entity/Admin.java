// changes by yogini
// 3rd change
package com.yts.revaux.admin.entity;

import jakarta.persistence.*;

@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String role;  // Example role: "ADMIN", "USER"
    private String yt;
    
    
    
    @Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", role=" + role + ", yt=" + yt + "]";
	}

	public String getYt() {
		return yt;
	}

	public void setYt(String yt) {
		this.yt = yt;
	}

	// Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
