package com.JohnJasonFisher.gmaillistparser.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class EmailServiceTest {

    @Autowired
    EmailService emailService;

    List<String> testEmails;

    @BeforeEach
    void setup() {
        testEmails = new ArrayList<>();
    }

    @Test
    void given_0_emails_return_0() {
        Assertions.assertEquals(0, emailService.parseUniqueEmails(testEmails).size());
    }

    @Test
    void given_1_emails_return_1() {
        testEmails.add("john@gmail.com");

        Assertions.assertEquals(1, emailService.parseUniqueEmails(testEmails).size());
    }

    @Test
    void given_2_dup_emails_return_1() {
        testEmails.add("john@gmail.com");
        testEmails.add("john@gmail.com");

        Assertions.assertEquals(1, emailService.parseUniqueEmails(testEmails).size());
    }

    @Test
    void given_dup_dot_emails_return_1() {
        testEmails.add("johnfisher@gmail.com");
        testEmails.add("john.fisher@gmail.com");

        Assertions.assertEquals(1, emailService.parseUniqueEmails(testEmails).size());
    }

    @Test
    void given_dup_plus_emails_return_1() {
        testEmails.add("john@gmail.com");
        testEmails.add("john+fisher@gmail.com");

        Assertions.assertEquals(1, emailService.parseUniqueEmails(testEmails).size());
    }

    @Test
    void given_two_pluses_in_one_email_return_1() {
        testEmails.add("john@gmail.com");
        testEmails.add("john+fisher+meyer@gmail.com");

        Assertions.assertEquals(1, emailService.parseUniqueEmails(testEmails).size());
    }

    @Test
    void given_all_email_types_return_1() {
        testEmails.add("test.email@gmail.com");
        testEmails.add("test.email+spam@gmail.com");
        testEmails.add("testemail@gmail.com");

        Assertions.assertEquals(1, emailService.parseUniqueEmails(testEmails).size());
    }


    @Test
    void test_parseOutDotFromString() {
        Assertions.assertEquals(
            "wordthingtwo", emailService.parseOutDotFromString("word.thing.two")
        );
    }
}
