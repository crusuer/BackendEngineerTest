# Backend Engineer Test
Spring Boot project to create/list Github gists and manage Score Boards. This project is part of DevGrid candidate evaluation.

# Application Setup (Local)

## Prerequisites
Before running the application you must ensure that the following dependencies are correctly installed:

```
Java 11
Maven 3.2.2
```
You also need to provide the following environment properties:
 - github.username
 - github.password
 
## Installation
Access the project:
```
cd [projectPath]
```
It's necessary to compile the code and download the project dependencies:
```
mvn clean package
```
After this step, let's run the application:
```
mvn spring-boot:run
```
# API endpoints
Consider `HOST` as *http://localhost:8080*. These are the endpoints available: 
## GET
`HOST` [/gist/{gist_id}/comments](#get-gist-gist_id-comments) <br/>
`HOST` [/scoreboard/retrieve/latest](#get-scoreboard-retrieve-latest) <br/>

## POST
`HOST` [/gist/create](#get-gist-create) <br/>
`HOST` [/scoreboard/submit](#get-scoreboard-submit) <br/>

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/81220dd5f6aeda3815c9)
___
To check API Documentation, go to `HOST`[/swagger-ui.html](#get-swagger-ui.html)