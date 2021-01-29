package com.inclined.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.inclined.hibernate.table.relations.Instructor;
import com.inclined.hibernate.table.relations.InstructorDetail;

public class HibernateRelationBiDirectionalDelete {

	
	public static void main(String[] args) {
			
		// Session Start
		// Session, SessionFactory implements AutoClosable()
		// try with resources
		try(SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
				Session session = factory.getCurrentSession();)
		{
			session.beginTransaction();
			
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 3);
			
			System.out.println(instructorDetail.getInstructor());
			
			session.delete(instructorDetail);
			
			// commit Transaction
			session.getTransaction().commit();	
		}
		// Always close the session (session.close), factory.close() won't close the session ( if finally is used )
		// , As to prevent leaks. And keep application running ! 
		
	}

}
