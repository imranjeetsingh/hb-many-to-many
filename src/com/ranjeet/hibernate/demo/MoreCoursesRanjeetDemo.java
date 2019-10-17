package com.ranjeet.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ranjeet.hibernate.entity.Course;
import com.ranjeet.hibernate.entity.Instructor;
import com.ranjeet.hibernate.entity.InstructorDetail;
import com.ranjeet.hibernate.entity.Review;
import com.ranjeet.hibernate.entity.Student;

public class MoreCoursesRanjeetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Adding more courses ...");
			
			session.beginTransaction();
			
			int id = 2;
			Student ranjeet = session.get(Student.class, id);
			
			System.out.println(ranjeet.getCourses());
			
			Course course = new Course("Python");
			Course course2 = new Course("cpp");
			
			course.addStudent(ranjeet);
			course2.addStudent(ranjeet);
			
			session.save(course);
			session.save(course2);
			
			
			
			session.getTransaction().commit();
			
			System.out.println("Done!!!!!!");
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
