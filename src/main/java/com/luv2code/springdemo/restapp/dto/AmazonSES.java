package com.luv2code.springdemo.restapp.dto;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.*;
import com.luv2code.springdemo.restapp.auth.User;

public class AmazonSES {
    final String FROM = "kenannan005@gmail.com";

    //Subject Line
    final String SUBJECT = "One more step to verify your email";
    //HTML body for the email
    final String BODY = "<h1>Please verify your email</h1>"
            + "Click on the link"
            + "<a href='http://localhost:8080/verifys/verification.html?token=$tokenValue'";
    //Non-HTML body for email
    final String TEXTBOBY = "Please verify your email</h1>"
            + "Click on the link"
            + "<a href='http://localhost:8080/verifys/verification.html?token=$tokenValue";


    //Subject Line
    final String SUBJECT_REST = "One more step to reset your password";
    //HTML body for the email
    final String BODY_REST = "<h1>CLICK ON THE PASSWORD RESET LINK</h1>"
            + "Click on the link"
            + "<a href='http://localhost:8080/verifys/passworsd-reset-reset.html?token=$tokenValue'";
    //Non-HTML body for email
    final String TEXTBOBY_RESET = "CLICK ON THE PASSWORD RESET LINK"
            + "Click on the link"
            + "<a href='http://localhost:8080/verifys/password-reset-reset.html?token=$tokenValue";


    public void verifyEmail(UserDto userDto){
    String ACCESS_ID="AKIASDIIOT3HJPIOLCLW";
    String SECRET_KEY="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";
    AWSStaticCredentialsProvider cp= new AWSStaticCredentialsProvider(new BasicAWSCredentials(ACCESS_ID, SECRET_KEY));
    AmazonSimpleEmailService client= AmazonSimpleEmailServiceClientBuilder.standard().withCredentials(cp).withRegion(Regions.US_EAST_2).build();
    String htmlBodyWithToken=BODY.replace("$tokenValue",userDto.getEmailVerificationToken());
    String textBodyWithToken=TEXTBOBY.replace("$tokenValue",userDto.getEmailVerificationToken());
    SendEmailRequest request=new SendEmailRequest()
            .withDestination(new Destination().withToAddresses(userDto.getEmail()))
            .withMessage(new Message()
                    .withBody(new Body().withHtml(new Content().withCharset("UTF-8").withData(htmlBodyWithToken))
            .withText(new Content().withCharset("UTF-8").withData(textBodyWithToken)))
                    .withSubject(new Content().withCharset("UTF-8").withData(SUBJECT)))
            .withSource(FROM);

    client.sendEmail(request);
    System.out.println("EMAIL SENT");

}

    public boolean passwordReset(String token, User storedEmail) {
boolean returnValue=false;
        String ACCESS_ID="AKIASDIIOT3HJPIOLCLW";
        String SECRET_KEY="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";
        AWSStaticCredentialsProvider cp= new AWSStaticCredentialsProvider(new BasicAWSCredentials(ACCESS_ID, SECRET_KEY));
        AmazonSimpleEmailService client= AmazonSimpleEmailServiceClientBuilder.standard().withCredentials(cp).withRegion(Regions.US_EAST_2).build();
        String htmlBodyWithToken=BODY_REST.replace("$tokenValue",token);
        String textBodyWithToken=TEXTBOBY_RESET.replace("$tokenValue",token);
        SendEmailRequest request=new SendEmailRequest()
                .withDestination(new Destination().withToAddresses(storedEmail.getEmail()))
                .withMessage(new Message()
                        .withBody(new Body().withHtml(new Content().withCharset("UTF-8").withData(htmlBodyWithToken))
                                .withText(new Content().withCharset("UTF-8").withData(textBodyWithToken)))
                        .withSubject(new Content().withCharset("UTF-8").withData(SUBJECT_REST)))
                .withSource(FROM);

     SendEmailResult sendEmail= client.sendEmail(request);
     if(sendEmail!=null){
         return returnValue=true;
     }
        System.out.println("EMAIL SENT");
        return  returnValue;

    }
}
