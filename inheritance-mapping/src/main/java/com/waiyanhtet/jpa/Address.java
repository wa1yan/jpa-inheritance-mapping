package com.waiyanhtet.jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;

@Entity
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String address;

	@Embedded
	private Contact contact1;

	@Embedded
	@AttributeOverrides({
			
		@AttributeOverride(name = "phone", column = @Column(name = "secondary_phone", table = "Address", length = 12)),
			
		@AttributeOverride(name = "email", column = @Column(name = "secondary_email", table = "Address")) 
	})
	private Contact contact2;

	@OneToOne
	@MapsId
	@PrimaryKeyJoinColumn
	private Student student;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Contact getContact1() {
		return contact1;
	}

	public void setContact1(Contact contact1) {
		this.contact1 = contact1;
	}

	public Contact getContact2() {
		return contact2;
	}

	public void setContact2(Contact contact2) {
		this.contact2 = contact2;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
