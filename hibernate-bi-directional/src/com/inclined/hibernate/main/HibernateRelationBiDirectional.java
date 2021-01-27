package com.inclined.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.inclined.hibernate.table.relations.Instructor;
import com.inclined.hibernate.table.relations.InstructorDetail;

public class HibernateRelationBiDirectional {
	
	static SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Instructor.class)
			.addAnnotatedClass(InstructorDetail.class)
			.buildSessionFactory();

	static Session session = factory.getCurrentSession();
	
	public static void main(String[] args) {
			
		// Session Start
		session.beginTransaction();
		
		InstructorDetail instructorDetail = session.get(InstructorDetail.class, 3);
		
		if(instructorDetail !=null) 
			System.out.println(instructorDetail.getInstructor());
		
		//commit Transaction
		session.getTransaction().commit();
	}

}
