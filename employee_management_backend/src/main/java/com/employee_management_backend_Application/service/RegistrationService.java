package com.employee_management_backend_Application.service;

public interface RegistrationService {
    public RegisterResponse getRegisterResponse(String registerEmail);
    public String postRegisterResponse(RegisterResponse registerResponse);
    public String updateRegisterResponse(RegisterResponse registerResponse);
    public String deleteRegisterResponse(String registerEmail);
}
