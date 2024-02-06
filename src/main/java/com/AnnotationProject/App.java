package com.AnnotationProject;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        System.out.println("Welcome to Annotation Hibernate Example");
        int flag=1;
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
        	System.out.println("1 : Create");
        	System.out.println("2 : Read");
        	System.out.println("3 : Update");
        	System.out.println("4 : Delete");
        	System.out.println("5 : Exit");
        	System.out.print("Enter your choice: ");
        	choice = sc.nextInt();
        	switch (choice) {
			case 1:
				createStudent(factory,sc);
				break;
				
            case 2:
				readStudent(factory,sc);
				break;
				
            case 3:
				updateStudent(factory,sc);
				break;
				
            case 4:
				deleteStudent(factory,sc);
				break;
				
            case 5:
            	factory.close();
            	System.out.println("EXITING>>>>>");
            	System.exit(0);
            	break;

			default:
				System.out.println("Invalid choice! Enter again");
				break;
			}
        	}while(flag==1);

    }

    private static void createStudent(SessionFactory sessionFactory, Scanner scanner) {
		System.out.println("Enter student details:");
		System.out.println("Regd No: ");
		int id = scanner.nextInt(); 
	    System.out.print("First Name: ");
	    String firstname = scanner.next();
	    System.out.println();
	    System.out.print("Last Name: ");
	    String lastname = scanner.next();
	    System.out.println();
	    System.out.print("Branch: ");
	    String branch = scanner.next();
	    System.out.println();
	    System.out.print("Phone: ");
	    String phone = scanner.next();
	    System.out.println();
	    System.out.print("Email: ");
	    String email = scanner.next();
	    System.out.println();
	    System.out.print("Address: ");
	    String address = scanner.next();
	    System.out.println();

	    try (Session session = sessionFactory.openSession()) {
	        session.beginTransaction();
	        Student student = new Student();
	        student.setFirstname(firstname);
	        student.setLastname(lastname);
	        student.setBranch(branch);
	        student.setPhone(phone);
	        student.setAddress(address);
	        student.setEmail(email);
	        student.setId(id);
	        session.persist(student);
	        session.getTransaction().commit();
	        System.out.println("Student created: " + student);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
    }


	private static void updateStudent(SessionFactory factory, Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Enter student id to update: ");
		int id = sc.nextInt();
		sc.nextLine();
		try (Session session = factory.openSession()) {
	        session.beginTransaction();
	        Student student = session.get(Student.class, id);

	        if (student != null) {
	            System.out.println("Current details: " + student);
	            System.out.print("Enter new first name: ");
	            String newFirstName = sc.nextLine();
	            
	            System.out.print("Enter new last name: ");
	            String newLastName = sc.nextLine();
	            
	            System.out.print("Enter new email: ");
	            String newEmail = sc.nextLine();
	            
	            System.out.print("Enter new address: ");
	            String newAddress = sc.nextLine();
	            
	            System.out.print("Enter new branch: ");
	            String newBranch = sc.nextLine();
	            
	            System.out.print("Enter new phone: ");
	            String newPhone = sc.nextLine();

	            student.setFirstname(newFirstName);
	            student.setLastname(newLastName);
	            student.setEmail(newEmail);
	            student.setAddress(newAddress);
	            student.setBranch(newBranch);
	            student.setPhone(newPhone);

	            session.getTransaction().commit();
	            System.out.println("Student updated: " + student);
	        } else {
	            System.out.println("Student not found with id: " + id);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
		
		
	}

	private static void readStudent(SessionFactory factory, Scanner sc) {
		// TODO Auto-generated method stub
		try(Session session = factory.openSession())
		{
			session.beginTransaction();
			List<Student> students = session.createQuery("from Student",Student.class).getResultList();
			for(Student student : students)
			{
				System.out.println(student);
			}
			session.getTransaction().commit();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	private static void deleteStudent(SessionFactory factory, Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print("Enter student id to delete: ");
	    int id = sc.nextInt();

	    try (Session session = factory.openSession()) {
	        session.beginTransaction();
	        Student student = session.get(Student.class, id);

	        if (student != null) {
	            session.remove(student);
	            session.getTransaction().commit();
	            System.out.println("Student deleted: " + student);
	        } else {
	            System.out.println("Student not found with id: " + id);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
	}
}
