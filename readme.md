curl

```
curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '{"emails": []}' http://localhost:8080/emails
```

```
curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '{"emails": ["test.email@gmail.com", "test.email+spam@gmail.com", "testemail@gmail.com"]}' http://localhost:8080/emails
```


write a web service that takes in a list of email addresses and returns an integer indicating the number of unique email addresses. Where "unique" email addresses means they will be delivered to the same account using Gmail account matching. Specifically:
 Gmail will ignore the placement of "." in the username. And it will ignore any portion of the username after a "+".

Examples:

test.email@gmail.com,
test.email+spam@gmail.com
 and testemail@gmail.com
 will all go to the same address, and thus the result should be 1.