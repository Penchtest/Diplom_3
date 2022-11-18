package site.nomoreparties.stellarburgers.page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import site.nomoreparties.stellarburgers.generator.UserData;

public class RegistrationPage {

    @FindBy(how = How.XPATH, using = ".//label[text()='Имя']/parent::div/input")

    private SelenideElement nameField;

    @FindBy(how = How.XPATH, using = ".//label[text()='Email']/parent::div/input")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = ".//label[text()='Пароль']/parent::div/input")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement registrationButton;

    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement enterLink;

    @FindBy(how = How.XPATH, using = ".//p[text()='Некорректный пароль']")
    private SelenideElement inValidPasswordMessage;

    public void fillRegistrationForm(UserData userData) {
        nameField.setValue(userData.getName());
        emailField.setValue(userData.getEmail());
        passwordField.setValue(userData.getPassword());
        registrationButton.click();
    }

    public void enterAccountClick() {
        enterLink.click();
    }

    public void checkInvalidPasswordMessage() {
        inValidPasswordMessage.shouldBe(Condition.visible);
    }

}






