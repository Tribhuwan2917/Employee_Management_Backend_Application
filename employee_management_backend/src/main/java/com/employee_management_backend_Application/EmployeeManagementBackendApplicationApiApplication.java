package com.employee_management_backend_Application;

import com.employee_management_backend_Application.entity.CurrentProject;
import com.employee_management_backend_Application.entity.EmployeeDetails;
import com.employee_management_backend_Application.entity.PriviousProject;
import com.employee_management_backend_Application.entity.Registration;
import com.employee_management_backend_Application.repository.CurrentProjectRepository;
import com.employee_management_backend_Application.repository.EmployeeDetailsRepository;
import com.employee_management_backend_Application.repository.PriviousProjectRepository;
import com.employee_management_backend_Application.repository.RegistrationRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.reactive.context.ConfigurableReactiveWebApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class
EmployeeManagementBackendApplicationApiApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(EmployeeManagementBackendApplicationApiApplication.class, args);
		RegistrationRepository registrationRepository = ctx.getBean(RegistrationRepository.class);
		EmployeeDetailsRepository employeeDetailsRepository = ctx.getBean(EmployeeDetailsRepository.class);
		PriviousProjectRepository priviousProjectRepository = ctx.getBean(PriviousProjectRepository.class);
		CurrentProjectRepository currentProjectRepository=ctx.getBean(CurrentProjectRepository.class);
//		for(int i=1;i<=10;i++)
//		{
//			CurrentProject  currentProject=new CurrentProject(i,"MypostFolio webite","https://tribhuwan2917.github.io/My_Portfolio_Website_Frontend/","This is Something new Project","Employee Management",i*2);
//			currentProjectRepository.save(currentProject);
//		}
//		currentProjectRepository.deleteAll();
//		for(int i=1;i<=10;i++)
//		{
//			EmployeeDetails employeeDetails=new EmployeeDetails(i,"Tribhuwan","Pal","electronics8449@gmail.com"+i+i,"India","222175","Jaunpur",30000,"Male");
//			employeeDetailsRepository.save(employeeDetails);
//		}
//		employeeDetailsRepository.deleteAll();
//		employeeDetailsRepository.deleteAll();
//		for (int i = 21; i <= 25; i++) {
//			PriviousProject priviousProject = new PriviousProject(i, "Banking project", "banking project link", "Account details", "To serve the bank", 2);
//			priviousProjectRepository.save(priviousProject);"Male
//		}
//		CurrentProject currentProject=new CurrentProject(31,"Banking current project", "banking currentproject link", "Account current details", "To serve the bank", 8);
//		currentProjectRepository.save(currentProject);


	}
}