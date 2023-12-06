package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.dao.StudentDAOImpl;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@SpringBootApplication
@Configuration
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	// make it a command line app, Execute after the spring bean is loaded
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO thestudent ){
		return runner->{
        createMultipleStudent(thestudent);
		 //readStudent(thestudent);
		// findAllStudents(thestudent);
		// queryForStudentByLastName(thestudent);
		//updateAllstudents(thestudent);
        //deleteStdById(thestudent);
		//deletAllStudents(thestudent);
		};

	}

	private void deletAllStudents(StudentDAO thestudent) {
		int numberofRows= thestudent.deleteAllStudents();
		System.out.println("The number of deleted students "+ numberofRows);
	}

	private void deleteStdById(StudentDAO thestudent) {
	 	// retrieve a std based on his primary key
		int Id=3000;
		// get the std with that id
		//Student stdnew = thestudent.findStudent(Id);
		//delete the std using its id
		thestudent.delete(Id);

	}
	private void updateAllstudents(StudentDAO thestudent) {
		// retrieve std based on the primary key
		int stdId = 1;
		// get the std with the given id
		Student myStudent= thestudent.findStudent(stdId);
		//update the std Id
		myStudent.setEmail("emailnew@gmail");
		thestudent.update(myStudent);
		// dispaly the updated std
		System.out.println(myStudent);
	}

	private void queryForStudentByLastName(StudentDAO thestudent) {
		// get a lit of a students
		List<Student> student_list = thestudent.findByLastName("merko");
		// display student based on their last name
		for (Student stdtemp: student_list
			 ) {
			System.out.println(stdtemp);

		}
	}

	private void findAllStudents(StudentDAO student_find) {
		// get a list of students
		List<Student> lisStudents = student_find.findAll();
		//display the list of student using a for cycle
		for (Student tempStudent:lisStudents)
		{
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO thestudent) {

		// create a student object
		Student student1 = new Student("john","canady","john@fti");
		//save the new student
		thestudent.save(student1);

		// get the id of the new std
		System.out.println(thestudent.findStudent(student1.getId()));
	}

	private void createMultipleStudent(StudentDAO thestudent) {
		// create students objects
		Student std1= new Student("adela","merko","adela@fti");
		Student std2 = new Student("sk","ssh","sk@fti");
		Student std3 = new Student("as","assh","assh@fti");
		// save students objects

		thestudent.save(std1);
		thestudent.save(std2);
		thestudent.save(std3);

		// dispaly new std
		//System.out.println(std1.getId());
		///System.out.println(std2.getId());
		//System.out.println(std3.getId());
	}

	private void createStudent(StudentDAO thestudent) {

		// craate the student
		System.out.println("creating new student ");
		Student newStudent = new Student("adela", "merko" , "merkoadela27@gmail");

		//save the student
		System.out.println("saving the new student");
		thestudent.save(newStudent);

		//display the id of the saved student
		System.out.println("display the saved student");
		System.out.println(newStudent.getId());
	}
}
