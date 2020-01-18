package com.JohnJasonFisher.gmaillistparser.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EmailController {

    @PostMapping("/emails")
    int countEmails(@RequestBody Map<String, List<String>> requestEmails) {
        return requestEmails.get("emails").size();
    }
}
