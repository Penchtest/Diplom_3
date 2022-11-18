package site.nomoreparties.stellarburgers.api_methods;

import io.restassured.response.ValidatableResponse;
import site.nomoreparties.stellarburgers.generator.UserData;

import static io.restassured.RestAssured.given;

public class UserRequest extends RestRequest {
    public ValidatableResponse createUser(UserData userData) {
        return given()
                .spec(getDefaultRequestSpec())
                .body(userData)
                .post("auth/register")
                .then();
    }

    public ValidatableResponse login(UserData userData) {
        String body = String.format("{\"email\": \"%s\", \"password\": \"%s\"}", userData.getEmail(), userData.getPassword());

        return given()
                .spec(getDefaultRequestSpec())
                .body(body)
                .post("auth/login")
                .then();
    }

    public ValidatableResponse delete(String accessToken) {
        return given()
                .spec(getDefaultRequestSpec())
                .auth().oauth2(accessToken)
                .delete("auth/user")
                .then();
    }

}
