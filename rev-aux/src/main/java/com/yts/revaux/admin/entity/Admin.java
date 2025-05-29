// changes by yogini
// 3rd change
package com.yts.revaux.admin.entity;

import jakarta.persistence.*;

@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String user_name;
    private String role;  // Example role: "ADMIN", "USER"
    private String yt;
    
    
    
    @Override
	public String toString() {
		return "Admin [id=" + id + ", user_name=" + user_name + ", role=" + role + ", yt=" + yt + "]";
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

    public String getuser_name() {
        return user_name;
    }

    public void setuser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
