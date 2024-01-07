package com.employee_management_backend_Application.service;

import com.employee_management_backend_Application.exception.ForgotPasswordOtpSendException;
import com.employee_management_backend_Application.repository.RegistrationRepository;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.apache.tomcat.util.http.fileupload.impl.FileUploadIOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
@Service
public class ForgotPasswordServicesImpl implements ForgotPassordService{
    @Autowired
    private RegistrationRepository registrationRepository;
   private Random random=new Random(1000);
    @Value("${server.email.Id}")
   private String from;
    @Override
    public ForgotPasswordResponse forgotPosswordOtpVerification(ForgotPasswordRequest forgotPasswordRequest)throws IOException {
        if (registrationRepository.existsById(forgotPasswordRequest.getRegistrationEmail())) {
            Integer otpData = random.nextInt(99999);
            String subject = "OTP from Employee_Management_System";
            String message = "OTO: " + otpData;
            String to = forgotPasswordRequest.getRegistrationEmail();
            boolean flage = this.sendEmail(subject, message, to, from);
            if (flage) {
                ForgotPasswordResponse forgotPasswordResponse = new ForgotPasswordResponse();
                forgotPasswordResponse.setOtpFromServer(otpData);
                return forgotPasswordResponse;
            } else {
                throw new ForgotPasswordOtpSendException("Otp unable to send deu to Server Error");
            }
        } else {
            throw new ForgotPasswordOtpSendException("This Email Does not Exists in Database");

        }
    }



    public boolean sendEmail(String subject,String message,String to,String from) throws IOException
    {
        Properties propertiesGeneralData=new Properties();
        FileInputStream fileInputStream=new FileInputStream("C://Users//tribhuvan pal//Desktop//Employee_Management_Inerview//Employee_Management_Backend_Application//employee_management_backend//src//main//resources//utilites_data.txt");
        propertiesGeneralData.load(fileInputStream);
        boolean flage=false;
        Properties properties=System.getProperties();
        properties.put("mail.smtp.auth",true);
        properties.put("mail.smtp.starttls.enable",true);
        properties.put("mail.smtp.host",propertiesGeneralData.getProperty("host"));
        properties.put("mail.smtp.port",propertiesGeneralData.getProperty("port"));
        Session session=Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(propertiesGeneralData.getProperty("userName"),propertiesGeneralData.getProperty("password"));
            }
        });
        Message mimeMessage=new MimeMessage(session);
        try
        {
            mimeMessage.setFrom(new InternetAddress(from));
            mimeMessage.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            mimeMessage.setSubject(subject);
            mimeMessage.setText(message);
            Transport.send(mimeMessage);
            flage=true;

        }catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return flage;

    }
}
