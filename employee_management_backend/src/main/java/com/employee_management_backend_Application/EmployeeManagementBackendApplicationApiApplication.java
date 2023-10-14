package com.employee_management_backend_Application;

import com.employee_management_backend_Application.entity.Registration;
import com.employee_management_backend_Application.repository.RegistrationRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.reactive.context.ConfigurableReactiveWebApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class
EmployeeManagementBackendApplicationApiApplication {
	public static void main(String[] args) {
	ConfigurableApplicationContext ctx= SpringApplication.run(EmployeeManagementBackendApplicationApiApplication.class, args);
		RegistrationRepository registrationRepository=ctx.getBean(RegistrationRepository.class);
		for(int i=1;i<=10;i++)
		{
			Registration registration=new Registration();
			registration.setRegistrationEmail("electronics8499@gmail.com"+i+"tt");
			registration.setRegistraionPassword("MyPassword"+i);
			registrationRepository.save(registration);
		}
	}

}
