package com.waiyanhtet.jpa;

import java.awt.Color;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue(value = "S")
public class Student extends Account {

	private static final long serialVersionUID = 1L;

	@OneToOne(mappedBy = "student")
	private Address address;
	
	@ManyToMany
	private List<Section> sections;

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
	
	public Student() {
	
	}
	public Student(String name, String loginId, String password, Color color) {
		super(name, loginId, Role.Student, password, color);
	}
	
	
	
	
	

}
