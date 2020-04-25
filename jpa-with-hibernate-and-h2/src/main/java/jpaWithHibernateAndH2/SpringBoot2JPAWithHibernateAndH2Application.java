package jpaWithHibernateAndH2;

import jpaWithHibernateAndH2.student.Student;
import jpaWithHibernateAndH2.student.StudentRepository;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j2
public class SpringBoot2JPAWithHibernateAndH2Application implements CommandLineRunner {

	@Autowired
    StudentRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2JPAWithHibernateAndH2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		log.info("Student id 10001 -> {}", repository.findById(10001L));

		log.info("Inserting -> {}", repository.save(Student.builder().name("John").passportNumber("A1234657").build()));
		log.info("Inserting -> {}", repository.save(Student.builder().id(10001L).name("Name-Updated").passportNumber("New-Passport").build()));

		repository.deleteById(10002L);

		log.info("All users -> {}", repository.findAll());
	}
}
