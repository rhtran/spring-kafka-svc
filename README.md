###Goal
Convert number into words in English

**Example:**<br/>
Input: 
`
{
    “number”: “12345678” 
}
`

Output:
`
{
    “status”: “ok”,
    “num_in_english”: “twelve million three hundred forty five thousand six hundred seventy eight” 
}
`

### Frameworks

1. Java 11
2. Spring Boot 2.2.4.RELEASE
3. Spring Test
4. Junit 5.4.2
5. Gradle 6.1

###Endpoint
http://localhost:8080/

| Path              | Method | Description                         | Response                     |
|-------------------|--------|-------------------------------------|------------------------------|
| /number_in_english/{number}  | GET    | get request to convert number into English        |

Status is reserved for messaging back if the process succeeded or failed. Make sure to use that when handling errors.

Requirements:
1. Treat this as a production endpoint you would publish.
How would you organize it to be production ready? 
What are the things you would do to allow other engineers to use your endpoint?