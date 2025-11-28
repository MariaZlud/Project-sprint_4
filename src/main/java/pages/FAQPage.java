package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FAQPage {
    private WebDriver driver;

    public FAQPage(WebDriver driver) {

        this.driver = driver;
    }

    //Нажатие на вопрос выпадающего списка Вопросы о важном
    public void clickQuestion(int questionId) {
        By locatorQuestion = By.id("accordion__heading-" + questionId);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(locatorQuestion));
        driver.findElement(locatorQuestion).click();
    }

    //Метод возвращает ответ в Выпадающем списке
    public String getAnswer(int questionId) {
        By locatorAnswer = By.id("accordion__panel-" + questionId);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(locatorAnswer));
        return driver.findElement(locatorAnswer).getText();
    }
}
