package Tests;

import PageObject.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
/*import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;*/

public class TestData {
    protected WebDriver driver;
    protected MainPage mainPage;

    protected static final String YANDEX_SCOOTER_URL = "https://qa-scooter.praktikum-services.ru/";

    @Before
    //Создать браузер Chrome
    public void SelectBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get(YANDEX_SCOOTER_URL);
        mainPage = new MainPage(driver);
        mainPage.acceptCookies();
    }

    /*//Создать браузер Firefox
    public void SelectBrowser1() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
        driver.get(YANDEX_SCOOTER_URL);
        mainPage = new MainPage(driver);
        mainPage.acceptCookies();
    }*/

    @After
    public void tearDown() {
        driver.quit();
    }
}
