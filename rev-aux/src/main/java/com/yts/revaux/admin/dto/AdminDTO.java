package com.yts.revaux.admin.dto;
// uploading code to the github
public class AdminDTO {
// changes by yogini
	// 2nd change
    private Long id;
    private String username;
    private String role;
    private String y_t;
    
    

    @Override
	public String toString() {
		return "AdminDTO [id=" + id + ", username=" + username + ", role=" + role + ", y_t=" + y_t + "]";
	}

	public String gety_t() {
		return y_t;
	}

	public void sety_t(String y_t) {
		this.y_t = y_t;
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
