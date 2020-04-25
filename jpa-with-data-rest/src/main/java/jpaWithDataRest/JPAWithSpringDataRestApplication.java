package jpaWithDataRest;

import jpaWithDataRest.student.Student;
import jpaWithDataRest.student.StudentDataRestRepository;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.IntStream;

@SpringBootApplication
@Log4j2
public class JPAWithSpringDataRestApplication implements CommandLineRunner{

	@Autowired
    StudentDataRestRepository studentRespository;

	public static void main(String[] args) {
		SpringApplication.run(JPAWithSpringDataRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		IntStream.range(1, 5).forEach(number -> {
			Student student = Student.builder().id((long)number).name("Name " + number).passportNumber("Passport " + number).build();
			studentRespository.save(student);
		});

		studentRespository.findAll().forEach(System.out::println);
	}
}
