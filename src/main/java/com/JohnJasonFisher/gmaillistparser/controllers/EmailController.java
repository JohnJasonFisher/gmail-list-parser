package com.JohnJasonFisher.gmaillistparser.controllers;

import com.JohnJasonFisher.gmaillistparser.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;


@RestController
public class EmailController {

    @Autowired
    private
    EmailService emailService;

    @PostMapping("/emails")
    Set<String> countEmails(@RequestBody Map<String, List<String>> requestEmails) {
//        if (requestEmails.get("emails") != null) {
            return emailService.parseUniqueEmails(requestEmails.get("emails"));
//        } else {
//            return 0;
//        }
    }
}
