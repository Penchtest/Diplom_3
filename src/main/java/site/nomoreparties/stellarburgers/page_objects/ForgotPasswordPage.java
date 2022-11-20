package site.nomoreparties.stellarburgers.page_objects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage {
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement enterLink;

    @Step("\"Enter account\" link click")
    public void enterAccountLinkClick() {
        enterLink.click();
    }
}
