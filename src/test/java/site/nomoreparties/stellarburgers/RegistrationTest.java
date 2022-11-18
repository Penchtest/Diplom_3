package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.api_methods.UserRequest;
import site.nomoreparties.stellarburgers.generator.UserData;
import site.nomoreparties.stellarburgers.page_objects.LoginPage;
import site.nomoreparties.stellarburgers.page_objects.MainPage;
import site.nomoreparties.stellarburgers.page_objects.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static site.nomoreparties.stellarburgers.Config.REGISTER_URI;
import static site.nomoreparties.stellarburgers.generator.UserDataGenerator.getRandomUserData;
import static site.nomoreparties.stellarburgers.generator.UserDataGenerator.getRandomUserDataWithInvalidPassword;

public class RegistrationTest extends BaseUITest {
    private UserData userData;
    private UserRequest userRequest;
    private String accessToken;

    @Before
    public void setUp() {
        userData = new UserData();
    }


    @Test
    @DisplayName("Registration with correct data should be successful")
    public void registrationWithCorrectDataShouldBeSuccessful() {
        RegistrationPage registrationPage = open(REGISTER_URI, RegistrationPage.class);
        userData = getRandomUserData();
        registrationPage.fillRegistrationForm(userData);
        Selenide.sleep(500);
        LoginPage loginPage = page(LoginPage.class);
        loginPage.fillLoginForm(userData);
        MainPage mainPage = page(MainPage.class);
        mainPage.checkAuthByOrderButton();
    }

    @Test
    @DisplayName("Registration with invalid password should not " +
            "be successful")
    public void registrationWithInvalidPasswordShouldNotBeSuccessful() {
        RegistrationPage registrationPage = open(REGISTER_URI, RegistrationPage.class);
        userData = getRandomUserDataWithInvalidPassword();
        registrationPage.fillRegistrationForm(userData);
        registrationPage.checkInvalidPasswordMessage();
    }

    @After
    public void deleteUser() {
        userRequest = new UserRequest();
        String accessTokenFull = userRequest.login(userData)
                .extract()
                .path("accessToken");
        if (accessTokenFull != null) {
            accessToken = accessTokenFull.replace("Bearer ", "");
            userRequest.delete(accessToken);
        }
    }

}