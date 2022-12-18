package com.waiyanhtet.jpa;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "T")
public class Teacher extends Account {

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "teacher")
	private List<Section> sections;

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

}
