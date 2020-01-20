package com.JohnJasonFisher.gmaillistparser.services;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmailService {
    public Set<String> parseUniqueEmails(List<String> emails) {

        Set<String> uniqueEmails = new HashSet<>(0);
        if (!emails.isEmpty()) {

            for (String email : emails) {

                // parse out "\\+.+@" from emailString
                List<String> splitEmail = Arrays.asList(email.split("\\+.+@"));

                splitEmail.set(0, parseOutDotFromString(splitEmail.get(0)));
                System.out.println(splitEmail);

                if (splitEmail.size() == 1) {
                    email = splitEmail.get(0);
                } else {
                    email = splitEmail.get(0) + "@" + splitEmail.get(splitEmail.size() - 1);
                }

                System.out.println(email);
                uniqueEmails.add(email);
            }
        }

        return uniqueEmails;
    }

    protected String parseOutDotFromString(String string) {
        return string.replace("." , "");
    }
}
