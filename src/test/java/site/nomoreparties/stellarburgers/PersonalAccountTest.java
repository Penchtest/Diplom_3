package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import site.nomoreparties.stellarburgers.api_methods.UserRequest;
import site.nomoreparties.stellarburgers.generator.UserData;
import site.nomoreparties.stellarburgers.page_objects.LoginPage;
import site.nomoreparties.stellarburgers.page_objects.MainPage;
import site.nomoreparties.stellarburgers.page_objects.PersonalAccountPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertEquals;
import static site.nomoreparties.stellarburgers.Config.*;
import static site.nomoreparties.stellarburgers.generator.UserDataGenerator.getRandomUserData;

public class PersonalAccountTest extends BaseUITest {
    private static UserData userData;
    private static String accessToken;
    private static UserRequest userRequest;

    @BeforeClass
    public static void createUser() {
        userData = getRandomUserData();
        userRequest = new UserRequest();
        String accessTokenFull = userRequest.createUser(userData).extract().path("accessToken");
        if (accessTokenFull != null)
            accessToken = accessTokenFull.replace("Bearer ", "");
    }

    @Before
    public void login(){
        LoginPage loginPage = open(LOGIN_URI, LoginPage.class);
        loginPage.fillLoginForm(userData);
    }

    @AfterClass
    public static void deleteUser() {
        if (accessToken != null)
            userRequest.delete(accessToken);
    }

    @Test
    @DisplayName("Navigate to personal account should be successful")
    public void navigateToAccountShouldBeSuccessful() {
        MainPage mainPage = page(MainPage.class);
        mainPage.personalAccountClick();
        Selenide.sleep(500);
        assertEquals(ACCOUNT_URI, WebDriverRunner.getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Logo button click should move to main page")
    public void logoButtonClickShouldMoveToMainPage() {
        MainPage mainPage = page(MainPage.class);
        mainPage.personalAccountClick();
        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        personalAccountPage.logoButtonClick();
        assertEquals(BASE_URI + "/", WebDriverRunner.getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Constructor button click should move to main page")
    public void constructorButtonClickShouldMoveToMainPage() {
        MainPage mainPage = page(MainPage.class);
        mainPage.personalAccountClick();
        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        personalAccountPage.constructorButtonClick();
        assertEquals(BASE_URI + "/", WebDriverRunner.getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Logout should be successful")
    public void logoutShouldBeSuccessful() {
        MainPage mainPage = page(MainPage.class);
        mainPage.personalAccountClick();
        PersonalAccountPage personalAccount = page(PersonalAccountPage.class);
        personalAccount.logoutButtonClick();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.checkLogoutByLoginButton();
    }
}
