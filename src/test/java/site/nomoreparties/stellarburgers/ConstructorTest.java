package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.page_objects.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static site.nomoreparties.stellarburgers.Config.BASE_URI;

public class ConstructorTest extends BaseUITest{
    MainPage mainPage;

    @Before
    public void openMainPage() {
        mainPage = open(BASE_URI, MainPage.class);
    }

    @Test
    @DisplayName("Move to buns should be successful")
    public void moveToBunsShouldBeSuccessful() {
        Assert.assertTrue("Переход к разделу 'Булки' не произошел", mainPage.checkBunsSelected());
    }

    @Test
    @DisplayName("Move to sauces should be successful")
    public void moveToSaucesShouldBeSuccessful() {
        Assert.assertTrue("Переход к разделу Соусы не произошел", mainPage.checkSaucesSelected());
    }

    @Test
    @DisplayName("Move to mains should be successful")
    public void moveToMainsShouldBeSuccessful() {
        Assert.assertTrue("Переход к разделу Начинки не произошел", mainPage.checkMainsSelected());
    }
}
