package com.ranjeet.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ranjeet.hibernate.entity.Course;
import com.ranjeet.hibernate.entity.Instructor;
import com.ranjeet.hibernate.entity.InstructorDetail;
import com.ranjeet.hibernate.entity.Review;
import com.ranjeet.hibernate.entity.Student;

public class CreateCoursesStudentDemo {

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
			System.out.println("Creating a new course and student object ...");
			
			session.beginTransaction();
			
			Course tempCourse = new Course("Java");
//			Course temCourse1 = new Course("Python");
			
//			session.save(temCourse1);
			session.save(tempCourse);
			
			Student temStudent = new Student("Ranjeet","Singh","ranjee970@gmail.com");
			Student temStudent1 = new Student("Hello","World","123@gmail.com");
			
			tempCourse.addStudent(temStudent);
			tempCourse.addStudent(temStudent1);
			
			session.save(temStudent1);
			session.save(temStudent);
			
			session.getTransaction().commit();
			
			System.out.println("Done!!!!!!");
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
