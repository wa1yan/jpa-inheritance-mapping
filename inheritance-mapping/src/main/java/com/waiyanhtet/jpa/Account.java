package com.waiyanhtet.jpa;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.InheritanceType.JOINED;

import java.awt.Color;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;

import com.waiyanhtet.jpa.converter.ColorConverter;

@Entity
@Inheritance(strategy = JOINED)
@DiscriminatorValue(value = "A")
@DiscriminatorColumn(name = "entity_type", columnDefinition = "char(1)")
public abstract class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	@Column(nullable = false, length = 45)
	private String name;

	@Column(nullable = false)
	@Enumerated(STRING)
	private Role role;

	@Column(nullable = false, name = "login_id", length = 10)
	private String loginId;

	@Column(nullable = false)
	private String password;

	@Convert(converter = ColorConverter.class)
	private Color color;

	public enum Role {
		Student, Teacher, Office
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Account() {
		super();
	}

	public Account(String name, String loginId, Role role, String password, Color color) {
		super();
		this.name = name;
		this.loginId = loginId;
		this.role = role;
		this.password = password;
		this.color = color;
	}

}
