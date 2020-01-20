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

                List<String> splitEmail = Arrays.asList(email.split("@"));

                String username;
                String address;
                if (splitEmail.size() >= 2) {
                    username = String.join("", splitEmail.subList(0, splitEmail.size() - 1));
                    address = splitEmail.get(splitEmail.size() - 1);
                } else {
                    // not a valid email if there is no @ char
                    break;
                }

                String usernameNoDot = parseOutDotFromString(username);
                String usernameNoDotPlus = parseOutPlusFromString(usernameNoDot);

                uniqueEmails.add(String.format("%s@%s", usernameNoDotPlus, address));
            }
        }

        return uniqueEmails;
    }

    String parseOutDotFromString(String string) {
        return string.replace("." , "");
    }

    String parseOutPlusFromString(String string) {
        return string.split("\\+.+")[0];
    }
}
