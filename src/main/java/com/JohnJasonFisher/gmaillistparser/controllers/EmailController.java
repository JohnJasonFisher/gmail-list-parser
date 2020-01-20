package com.JohnJasonFisher.gmaillistparser.controllers;

import com.JohnJasonFisher.gmaillistparser.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


@RestController
public class EmailController {

    @Autowired
    private
    EmailService emailService;

    @PostMapping("/emails")
    Map<String, Integer> countEmails(@RequestBody Map<String, List<String>> requestEmails) {
        Map<String, Integer> reponse = new HashMap<>();
        if (requestEmails.get("emails") != null) {
            reponse.put("count", emailService.getUniqueEmailCount(requestEmails.get("emails")));
        } else {
            reponse.put("count", 0);
        }
        return reponse;
    }
}
