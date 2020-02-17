### Goal
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

### Endpoint

http://localhost:8080/

| Path                     | Method | Description                                | Response                     |
|--------------------------|--------|--------------------------------------------|------------------------------|
| /num_in_english/{number} | GET    | get request to convert number into English | {"message": "processing request"}


### Local Tests:
<br/>bin/zookeeper-server-start.sh config/zookeeper.properties &
<br/>bin/kafka-server-start.sh config/server.properties &

At project root, `gradle bootRun` to start the app


**Deployment:**
1. create dockerfile to dockerize the app
2. create helm chart for kubernetes
3. config kafka topic and partition

**Utilizing endpoint**
1. curl localhost:8080/num_in_english/any-given-number
2. publish the result to kafka topic `num-in-english`