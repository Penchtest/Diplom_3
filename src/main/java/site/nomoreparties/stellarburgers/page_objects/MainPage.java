package site.nomoreparties.stellarburgers.page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class MainPage {
    String selectedTabIdentifier = "tab_tab_type_current__2BEPc";
    //булки
    @FindBy(how = How.XPATH, using = ".//span[(@class = 'text text_type_main-default' and text()='Булки')]/parent::div")
    private SelenideElement bunsShifter;
    //соусы
    @FindBy(how = How.XPATH, using = ".//span[(@class = 'text text_type_main-default' and text()='Соусы')]/parent::div")
    private SelenideElement saucesShifter;
    //начинки
    @FindBy(how = How.XPATH, using = ".//span[(@class = 'text text_type_main-default' and text()='Начинки')]/parent::div")
    private SelenideElement mainsShifter;
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement enterAccountButton;
    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private SelenideElement personalAccountButton;
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement orderButton;

    public boolean checkBunsSelected() {
        saucesShifter.click();
        bunsShifter.click();
        Selenide.sleep(500);
        return bunsShifter.getAttribute("class").contains(selectedTabIdentifier);
    }

    public boolean checkSaucesSelected() {
        saucesShifter.click();
        Selenide.sleep(500);
        return saucesShifter.getAttribute("class").contains(selectedTabIdentifier);
    }

    public boolean checkMainsSelected() {
        mainsShifter.click();
        Selenide.sleep(500);
        return mainsShifter.getAttribute("class").contains(selectedTabIdentifier);
    }

    public LoginPage enterAccountClick() {
        enterAccountButton.click();
        return page(LoginPage.class);
    }

    public LoginPage personalAccountClick() {
        enterAccountButton.click();
        return page(LoginPage.class);
    }

    public void goToPersonalAccount() {
        personalAccountButton.click();
    }

    public void checkAuthByOrderButton() {
        orderButton.shouldBe(Condition.visible);
    }

}
