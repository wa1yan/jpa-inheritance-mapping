package com.waiyanhtet.jpa;

import java.awt.Color;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class InheritanceTest {

private static EntityManagerFactory emf;
	
	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("inheritance-mapping");
	}
	
	@AfterAll
	static void close() {
		if(null != emf && emf.isOpen()) {
			emf.close();
		}
	}
	
	@Test
	void test() {
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		
		var account = new Student("William", "william", "william", Color.RED);
		em.persist(account);
		
		em.getTransaction().commit();
	}
}
