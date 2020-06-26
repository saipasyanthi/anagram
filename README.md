# Spring Boot "Anagram" Example Project
This is a sample Java / Spring Boot (version 2.3.1) application

Anagram: a word, phrase, or name formed by rearranging the letters of another, such as cinema, formed from iceman (an anagram does not need to be meaningful necessarily).

## How to Run

* Clone this repository
* Make sure you are using JDK 1.8
* You can build the project and run the tests by running ```mvn clean package```
* You can start the project in Boot Dashboard
* Once the application runs you should see something like this

```
2020-06-26 02:31:32.846  INFO 13848 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2020-06-26 02:31:32.870  INFO 13848 --- [           main] c.anagram.demo.AnagramDemo1Application   : Started AnagramDemo1Application in 5.528 seconds (JVM running for 7.135)
```
## There are two services Endpoints

* One is just a simple, two String arguments, and returns a Boolean corresponding to whether or not the two String arguments are anagrams of each other.
* Other is a just a String Retrives all possible anagrams of string

 Here are some endpoints you can call:

### Get information about endpoints etc.

```
http://localhost:8080/anagrams/{string1}/{string2}
http://localhost:8080/anagrams/{string1}
```
### Compare two strings are anagrams

```
Example1:

GET /anagrams/cinema/iceman
Accept: application/json
Content-Type: application/json

{
"areAnagrams": "true"
}

RESPONSE: HTTP 200 (OK)


Example2:
GET /anagrams/cinema/icemss
Accept: application/json
Content-Type: application/json

{
"areAnagrams": "false"
}

RESPONSE: HTTP 200 (OK)

```

### Retrieve all possible anagrams of string

```
Example1:

http://localhost:8080/keep
GET /anagrams/keep
Accept: application/json
Content-Type: application/json

{
    "anagrams": [
        "keep",
        "kepe",
        "kepe",
        "keep",
        "kpee",
        "kpee",
        "eepk",
        "eekp",
        "epke",
        "epek",
        "ekep",
        "ekpe",
        "epke",
        "epek",
        "ekep",
        "ekpe",
        "eepk",
        "eekp",
        "pkee",
        "pkee",
        "peek",
        "peke",
        "peke",
        "peek"
    ]
}

Response: HTTP 200


Example2:

http://localhost:8080/keep@3
GET /anagrams/keep
Accept: application/json
Content-Type: application/json

Response: HTTP 400 - Bad Request
```

### String is validated if it contains any non alpha-numerical characters.

```
Returns a 400 - Bad Request if string are not valid

```

### Sample Testcases for Strings Compare.

```
@Test
	public void testDoubleStrPositive()throws Exception {
		boolean check= anagramService.getAnagramforStrings("keep","peek");
		assertEquals(true,check);
	}
	
	@Test
	public void testDoubleStrNegative()throws Exception {
		boolean check= anagramService.getAnagramforStrings("test","peek");
		assertEquals(false,check);
	}
  
  ```
  
  ## About Spring Boot
  Spring Boot is an "opinionated" application bootstrapping framework that makes it easy to create new RESTful services (among other types of applications). It provides many of the usual Spring facilities that can be configured easily usually without any XML. In addition to easy set up of Spring Controllers, Spring Data, etc. 
  
  # Questions and Comments:saipasyanthi@gmail.com
