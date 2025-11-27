package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    //Локатор для кнопки "Войти" вверху страницы
    private By buttonOrderInHeader = By.xpath(".//div[@class='Header_Nav__AGCXC']//button[text()='Заказать']");
    //Локатор для кнопки "Войти" внизу страницы
    private By buttonOrderAtBottom = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    //Локатор блока Вопросы о важном
    private By blockQuestions = By.className("accordion");
    //Локатор кнопки принять куки "да все привыкли"
    private By buttonAcceptCookies = By.id("rcc-confirm-button");

    //Конструктор класса
    public MainPage(WebDriver driver) {

        this.driver = driver;
    }

    //Метод кликает кнопку "да все привыкли"
    public void acceptCookies() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(buttonAcceptCookies));
        driver.findElement(buttonAcceptCookies).click();
    }

    //Метод кликает по кнопке Войти вверху стрвницы
    public void clickButtonOrderInHeader() {

        driver.findElement(buttonOrderInHeader).click();
    }

    //Метод кликает на кнопку Войти внизу страницы
    public void clickButtonOrderAtBottom() {
        WebElement buttonElement = driver.findElement(buttonOrderAtBottom);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", buttonElement);
        driver.findElement(buttonOrderAtBottom).click();
    }

    //Метод скроллит страницу до блока Вопросы о важном
    public void scrollToBlockQuestion() {
        WebElement questionElement = driver.findElement(blockQuestions);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", questionElement);
    }
}