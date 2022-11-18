package site.nomoreparties.stellarburgers.page_objects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PersonalAccountPage {
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement logoutButton;

    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement stellarBurgerLogo;

    @FindBy(how = How.XPATH, using = ".//a[@class ='AppHeader_header__link__3D_hX' and @href = '/']")
    private SelenideElement constructorButton;

    public void logoutButtonClick() {
        logoutButton.click();
    }

    public void logoButtonClick() {
        stellarBurgerLogo.click();
    }

    public void constructorButtonClick() {
        constructorButton.click();

    }
}
