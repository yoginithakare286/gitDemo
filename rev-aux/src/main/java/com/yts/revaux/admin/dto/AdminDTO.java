package com.yts.revaux.admin.dto;
// uploading code to the github
public class AdminDTO {
// changes by yogini
	// 2nd change
    private Long id;
    private String username;
    private String role;
    private String yt;
    
    

    @Override
	public String toString() {
		return "AdminDTO [id=" + id + ", username=" + username + ", role=" + role + ", yt=" + yt + "]";
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
