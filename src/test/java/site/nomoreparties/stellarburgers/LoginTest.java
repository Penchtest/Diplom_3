package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import site.nomoreparties.stellarburgers.api_methods.UserRequest;
import site.nomoreparties.stellarburgers.generator.UserData;
import site.nomoreparties.stellarburgers.page_objects.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static site.nomoreparties.stellarburgers.Config.*;
import static site.nomoreparties.stellarburgers.generator.UserDataGenerator.getRandomUserData;

public class LoginTest extends BaseUITest {
    private static UserData userData;
    private static String accessToken;
    private static UserRequest userRequest;

    @BeforeClass
    public static void createUser() {
        userData = getRandomUserData();
        userRequest = new UserRequest();
        String accessTokenFull = userRequest.createUser(userData)
                .extract()
                .path("accessToken");
        if (accessTokenFull != null)
            accessToken = accessTokenFull.replace("Bearer ", "");
    }

    @After
    public void logout() {
        MainPage mainPage = page(MainPage.class);
        mainPage.goToPersonalAccount();
        PersonalAccountPage personalAccount = page(PersonalAccountPage.class);
        personalAccount.logoutButtonClick();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.checkLogoutByLoginButton();
    }

    @AfterClass
    public static void deleteUser() {
        if (accessToken != null)
            userRequest.delete(accessToken);
    }

    @Test
    @DisplayName("Login via \"Enter account\" should be successful")
    public void loginViaEnterAccountShouldBeSuccessful() {
        MainPage mainPage = open(BASE_URI, MainPage.class);
        LoginPage loginPage = mainPage.enterAccountClick();
        loginPage.fillLoginForm(userData);
        mainPage.checkAuthByOrderButton();
    }

    @Test
    @DisplayName("Login via \"Personal account\" should be successful")
    public void loginViaPersonalAccountShouldBeSuccessful() {
        MainPage mainPage = open(BASE_URI, MainPage.class);
        LoginPage loginPage = mainPage.personalAccountClick();
        loginPage.fillLoginForm(userData);
        mainPage.checkAuthByOrderButton();
    }

    @Test
    @DisplayName("Login via registration form should be successful")
    public void loginViaRegistrationFormShouldBeSuccessful() {
        RegistrationPage registrationPage = open(REGISTER_URI, RegistrationPage.class);
        registrationPage.enterAccountClick();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.fillLoginForm(userData);
        MainPage mainPage = page(MainPage.class);
        mainPage.checkAuthByOrderButton();
    }

    @Test
    @DisplayName("Login via \"Forgot Password\" should be successful")
    public void loginViaForgotPasswordShouldBeSuccessful() {
        ForgotPasswordPage forgotPasswordPage = open(FORGOT_PASSWORD_URI, ForgotPasswordPage.class);
        forgotPasswordPage.enterAccountClick();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.fillLoginForm(userData);
        MainPage mainPage = page(MainPage.class);
        mainPage.checkAuthByOrderButton();
    }


}