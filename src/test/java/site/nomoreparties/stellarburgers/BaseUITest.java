package site.nomoreparties.stellarburgers;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.html5.WebStorage;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseUITest {
    protected static WebDriver driver;

    @BeforeClass
    public static void startUp() {
        //Выбор браузера
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pench\\Webdriver\\bin\\yandexdriver.exe");
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pench\\Webdriver\\bin\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        setWebDriver(driver);
    }

    @After
    public void clearData() {
        driver.manage().deleteAllCookies();
        ((WebStorage) driver).getSessionStorage().clear();
        ((WebStorage) driver).getLocalStorage().clear();
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}
