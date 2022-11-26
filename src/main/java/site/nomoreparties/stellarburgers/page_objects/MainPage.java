package site.nomoreparties.stellarburgers.page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {
    String selectedTabIdentifier = "tab_tab_type_current__2BEPc";
    @FindBy(how = How.XPATH, using = ".//span[(@class = 'text text_type_main-default' and text()='Булки')]/parent::div")
    private SelenideElement bunsShifter;
    @FindBy(how = How.XPATH, using = ".//span[(@class = 'text text_type_main-default' and text()='Соусы')]/parent::div")
    private SelenideElement saucesShifter;
    @FindBy(how = How.XPATH, using = ".//span[(@class = 'text text_type_main-default' and text()='Начинки')]/parent::div")
    private SelenideElement mainsShifter;
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement enterAccountButton;
    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private SelenideElement personalAccountButton;
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement orderButton;

    @Step("Check \"Buns\" tab is selected")
    public boolean checkBunsSelected() {
        saucesShifter.click();
        bunsShifter.click();
        Selenide.sleep(500);
        return bunsShifter.getAttribute("class").contains(selectedTabIdentifier);
    }

    @Step("Check \"Sauces\" tab is selected")
    public boolean checkSaucesSelected() {
        saucesShifter.click();
        Selenide.sleep(500);
        return saucesShifter.getAttribute("class").contains(selectedTabIdentifier);
    }

    @Step("Check \"Mains\" tab is selected")
    public boolean checkMainsSelected() {
        mainsShifter.click();
        Selenide.sleep(500);
        return mainsShifter.getAttribute("class").contains(selectedTabIdentifier);
    }

    @Step("\"Enter account\" button click")
    public void enterAccountClick() {
        enterAccountButton.click();
    }

    @Step("\"Personal account\" button click")
    public void personalAccountClick() {
        personalAccountButton.click();
    }

    @Step("Check auth by \"Order\" button visibility")
    public void checkAuthByOrderButton() {
        orderButton.shouldBe(Condition.visible);
    }
}
