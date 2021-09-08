package com.solbegsoft.demoqa.automation.rest.restassured;

import com.solbegsoft.demoqa.automation.model.User;
import com.solbegsoft.demoqa.automation.model.UserResponse;
import com.solbegsoft.demoqa.automation.rest.Endpoints;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.extern.slf4j.Slf4j;

import static io.restassured.RestAssured.given;

@Slf4j
public class DemoQaService {
    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;

    public DemoQaService() {
        requestSpecification = SpecificationHandler.getRequestSpecification();
        responseSpecification = SpecificationHandler.getResponseSpecification();
    }

    public UserResponse registerUser(User user) {
        log.info("Registering user '{}'", user.getLogin());
        UserResponse userResponse = given()
                .spec(requestSpecification)
                .body(user)
                .post(Endpoints.USER)
                .then().spec(responseSpecification)
                .statusCode(201)
                .extract().body().as(UserResponse.class);
        log.info("User created '{}'", userResponse);
        return userResponse;
    }

    public String generateToken(User user) {
        log.info("Getting token for '{}'", user.getLogin());
        String token = given()
                .spec(requestSpecification)
                .body(user)
                .post(Endpoints.GENERATE_TOKEN)
                .then().spec(responseSpecification)
                .statusCode(200)
                .extract().path("token");
        log.info("Token is '{}'", token);
        return token;
    }

    public void deleteUser(String uuid, String token) {
        log.info("Deleting user '{}'", uuid);
        given()
                .spec(requestSpecification)
                .pathParam("uuid", uuid)
                .header("Authorization", "Bearer " + token)
                .delete(Endpoints.USER_ID)
                .then().spec(responseSpecification)
                .statusCode(204);
        log.info("User '{}' deleted", uuid);
    }

    public String isAuthorized(User user) {
        log.info("Is user '{}' authorized  ", user.getLogin());
        String message = given()
                .spec(requestSpecification)
                .body(user)
                .post(Endpoints.AUTHORIZED)
                .then().spec(responseSpecification)
                .statusCode(200)
                .extract().body().asPrettyString();
        log.info("User authorized is '{}'", message);
        return message;
    }

}

