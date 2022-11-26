package site.nomoreparties.stellarburgers.page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import site.nomoreparties.stellarburgers.generator.UserData;

public class LoginPage {
    @FindBy(how = How.XPATH, using = ".//label[text()='Email']/parent::div/input")
    private SelenideElement emailField;
    @FindBy(how = How.XPATH, using = ".//label[text()='Пароль']//parent::div/input")
    private SelenideElement passwordField;
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement loginButton;

    @Step("Fill login form")
    public void fillLoginForm(UserData userData) {
        emailField.setValue(userData.getEmail());
        passwordField.setValue(userData.getPassword());
        loginButton.click();
    }

    @Step("Check logout by \"Login\" button visibility")
    public void checkLogoutByLoginButton() {
        loginButton.shouldBe(Condition.visible);
    }
}
