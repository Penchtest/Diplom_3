package site.nomoreparties.stellarburgers.api_methods;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import site.nomoreparties.stellarburgers.generator.UserData;

import static io.restassured.RestAssured.given;

public class UserRequest extends RestRequest {
    @Step("Create new user via API")
    public ValidatableResponse createUser(UserData userData) {
        return given()
                .spec(getDefaultRequestSpec())
                .body(userData)
                .post("auth/register")
                .then();
    }

    @Step("Login via API")
    public ValidatableResponse login(UserData userData) {
        String body = String.format("{\"email\": \"%s\", \"password\": \"%s\"}", userData.getEmail(), userData.getPassword());

        return given()
                .spec(getDefaultRequestSpec())
                .body(body)
                .post("auth/login")
                .then();
    }

    @Step("Delete user via API")
    public ValidatableResponse delete(String accessToken) {
        return given()
                .spec(getDefaultRequestSpec())
                .auth().oauth2(accessToken)
                .delete("auth/user")
                .then();
    }
}
