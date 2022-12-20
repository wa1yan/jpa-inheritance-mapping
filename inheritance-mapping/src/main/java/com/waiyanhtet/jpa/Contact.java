package com.waiyanhtet.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Contact implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(length = 12)
	private String phone;

	@Column(length = 45)
	private String email;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
