package com.waiyanhtet.jpa;

import javax.persistence.Entity;

@Entity
public class Office extends Account {

	private static final long serialVersionUID = 1L;
	
	private boolean isAdmin;

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
	
}
