## Helping You Master Cloud, Full Stack and Microservices 

> **30** Courses, **5** Learning Paths & **350K** Learners 

You do not learn to drive by watching Tom Cruise drive at 300 kmph! You have to **get your hands dirty**.

At in28minutes, **Our goal** is to help you learn and re-skill Spring Boot, Microservices, Full Stack, Cloud (AWS), Docker and Kubernetes with **hands-on, practical courses**.

We have build solutions to help you master Cloud, Full Stack and Microservices in **1-3 Months**.

You can check out all our courses here - [https://github.com/in28minutes/learn](https://github.com/in28minutes/learn)

## Learn from the Top 5 Best Selling Courses

- [Master DevOps with Docker, Kubernetes and Azure DevOps](https://links.in28minutes.com/DevOps-SBT)
- [Kubernetes for Java Developers on Google Cloud](https://links.in28minutes.com/SBT-Footer-Kubernetes)
- [Docker for Java Developers - with Spring Boot Microservices](https://links.in28minutes.com/SBT-Footer-Docker)
- [Learn AWS - Deploy Java Spring Boot to AWS Elastic Beanstalk](https://links.in28minutes.com/SBT-Footer-AWS-BeanStalk)
- [Master Microservices with Spring Boot and Spring Cloud](https://links.in28minutes.com/SBT-Footer-Microservices)
- [Learn Java Full Stack with Spring Boot and React](https://links.in28minutes.com/SBT-Footer-React)


## Reskill with the Amazing in28Minutes Learning Paths

- [Learning Path 01 - Spring and Spring Boot Web Applications and API Developer](https://links.in28minutes.com/in28minutes-LP-01)
- [Learning Path 02 - Full Stack Developer with Spring Boot, React & Angular](https://links.in28minutes.com/in28minutes-LP-02)
- [Learning Path 03 - Cloud Microservices Developer with Docker and Kubernetes](https://links.in28minutes.com/in28minutes-LP-03)
- [Learning Path 04 - Learn Cloud with Spring Boot, AWS, Azure and PCF](https://links.in28minutes.com/in28minutes-LP-04)
- [Learning Path 05 - Learn AWS with Microservices, Docker and Kubernetes](https://links.in28minutes.com/in28minutes-LP-05)



## Complete Code Example


### /pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.in28minutes.springboot.rest.example</groupId>
	<artifactId>spring-boot-2-rest-service-filtering</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>spring-boot-2-rest-service</name>
	<description>Spring Boot 2 and REST - Example Project</description>

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.0.0.RELEASE</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

	<repositories>
		<repository>
			<id>spring-snapshots</id>
			<name>Spring Snapshots</name>
			<url>https://repo.spring.io/snapshot</url>
			<snapshots>
				<enabled>true</enabled>
			</snapshots>
		</repository>
		<repository>
			<id>spring-milestones</id>
			<name>Spring Milestones</name>
			<url>https://repo.spring.io/milestone</url>
			<snapshots>
				<enabled>false</enabled>
			</snapshots>
		</repository>
	</repositories>

	<pluginRepositories>
		<pluginRepository>
			<id>spring-snapshots</id>
			<name>Spring Snapshots</name>
			<url>https://repo.spring.io/snapshot</url>
			<snapshots>
				<enabled>true</enabled>
			</snapshots>
		</pluginRepository>
		<pluginRepository>
			<id>spring-milestones</id>
			<name>Spring Milestones</name>
			<url>https://repo.spring.io/milestone</url>
			<snapshots>
				<enabled>false</enabled>
			</snapshots>
		</pluginRepository>
	</pluginRepositories>


</project>
```
---

### /src/main/java/com/in28minutes/springboot/rest/example/dynamicfiltering/FilteringController.java

```java
package com.in28minutes.springboot.rest.example.dynamicfiltering;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;import restServiceExceptionHandling.student.dynamicfiltering.SomeBean;

@RestController
public class FilteringController {

  // field1,field2
  @GetMapping("/filtering")
  public MappingJacksonValue retrieveSomeBean() {
    SomeBean someBean = new SomeBean("value1", "value2", "value3");

    SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");

    FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

    MappingJacksonValue mapping = new MappingJacksonValue(someBean);

    mapping.setFilters(filters);

    return mapping;
  }

  // field2, field3
  @GetMapping("/filtering-list")
  public MappingJacksonValue retrieveListOfSomeBeans() {
    List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"),
        new SomeBean("value12", "value22", "value32"));

    SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");

    FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

    MappingJacksonValue mapping = new MappingJacksonValue(list);

    mapping.setFilters(filters);

    return mapping;
  }

}
```
---

### /src/main/java/com/in28minutes/springboot/rest/example/dynamicfiltering/SomeBean.java

```java
package com.in28minutes.springboot.rest.example.dynamicfiltering;
import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("SomeBeanFilter")
public class SomeBean {
  
  private String field1;
  
  private String field2;
  
  private String field3;

  public SomeBean(String field1, String field2, String field3) {
    super();
    this.field1 = field1;
    this.field2 = field2;
    this.field3 = field3;
  }

  public String getField1() {
    return field1;
  }

  public void setField1(String field1) {
    this.field1 = field1;
  }

  public String getField2() {
    return field2;
  }

  public void setField2(String field2) {
    this.field2 = field2;
  }

  public String getField3() {
    return field3;
  }

  public void setField3(String field3) {
    this.field3 = field3;
  }

}
```
---

### /src/main/java/com/in28minutes/springboot/rest/example/SpringBoot2RestServiceApplication.java

```java
package com.in28minutes.springboot.rest.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot2RestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2RestServiceApplication.class, args);
	}
}
```
---

### /src/main/java/com/in28minutes/springboot/rest/example/student/Student.java

```java
package com.in28minutes.springboot.rest.example.student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value={"passportNumber"})
public class Student {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@JsonIgnore
	private String passportNumber;
	
	public Student() {
		super();
	}

	public Student(Long id, String name, String passportNumber) {
		super();
		this.id = id;
		this.name = name;
		this.passportNumber = passportNumber;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
		
}
```
---

### /src/main/java/com/in28minutes/springboot/rest/example/student/StudentNotFoundException.java

```java
package com.in28minutes.springboot.rest.example.student;

public class StudentNotFoundException extends RuntimeException {

	public StudentNotFoundException(String exception) {
		super(exception);
	}

}
```
---

### /src/main/java/com/in28minutes/springboot/rest/example/student/StudentRepository.java

```java
package com.in28minutes.springboot.rest.example.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;import restServiceExceptionHandling.student.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
```
---

### /src/main/java/com/in28minutes/springboot/rest/example/student/StudentResource.java

```java
package com.in28minutes.springboot.rest.example.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;import restServiceExceptionHandling.student.Student;import restServiceExceptionHandling.student.StudentNotFoundException;import restServiceExceptionHandling.student.StudentRepository;

@RestController
public class StudentResource {

	@Autowired
	private StudentRepository studentRepository;

	@GetMapping("/students")
	public List<Student> retrieveAllStudents() {
		return studentRepository.findAll();
	}

	@GetMapping("/students/{id}")
	public Student retrieveStudent(@PathVariable long id) {
		Optional<Student> student = studentRepository.findById(id);

		if (!student.isPresent())
			throw new StudentNotFoundException("id-" + id);

		return student.get();
	}
}
```
---

### /src/main/resources/application.properties

```properties
```
---

### /src/main/resources/data.sql

```
insert into student
values(10001,'Ranga', 'E1234567');

insert into student
values(10002,'Ravi', 'A1234568');
```
---

### /src/test/java/com/in28minutes/springboot/rest/example/SpringBoot2RestServiceApplicationTests.java

```java
package com.in28minutes.springboot.rest.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot2RestServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

}
```
---