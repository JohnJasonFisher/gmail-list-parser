package com.JohnJasonFisher.gmaillistparser.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.constraints.AssertFalse;
import java.util.ArrayList;
import java.util.List;

public class EmailServiceTest {

    @Autowired
    EmailService emailService;

    List<String> testEmails = new ArrayList<>();

    @Test
    void given_0_emails_return_0() {

        testEmails.add("john@gmail.com");


        emailService.parseUniqueEmails(testEmails) == 0;
    }
}
