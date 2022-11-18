package site.nomoreparties.stellarburgers.page_objects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage {
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement enterLink;

    public void enterAccountClick() {
        enterLink.click();
    }


}
