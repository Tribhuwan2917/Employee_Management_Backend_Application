package com.employee_management_backend_Application.service;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ForgotEmailRequest {
    private  String registrationEmail;
}
