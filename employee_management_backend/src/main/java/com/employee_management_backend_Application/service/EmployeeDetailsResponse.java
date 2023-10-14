package com.employee_management_backend_Application.service;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDetailsResponse {
    private Integer employeeId;
    private String employeeFirstName;
    private String employeeLastName;
    private String employeeEmail;
    private String employeeCountry;
    private String employeeAddressZipCode;
    private String employeeAddressCity;
}
