package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderFormTwo {
    private WebDriver driver;

    //Локатор поля Когда привезти самокат
    private By whenToBringTheScooter = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Локатор поля Срок аренды
    private By theRentalPeriodField = By.xpath(".//div[@class='Dropdown-placeholder']");
    //Локатор выпадающего списка Срок аренды
    private By listOfRentalPeriod(String rentalPeriod) {
        return By.xpath(".//div[contains(@class, 'Dropdown-option') and text()='"+ rentalPeriod +"']");
    }
    //Локатор поля Комментарий для курьера
    private By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Локатор кнопки Заказать
    private By orderButton = By.xpath(".//button[text()='Заказать' and contains(@class, 'Button_Middle__1CSJM')]");

    //Локатор окна подтверждения заказа
    private By orderConfirmationWindow =By.xpath(".//div[contains(@class, 'Order_Modal__YZ-d3')]//div[contains(text(), 'Хотите оформить заказ')]");
    //Локатор кнопки Да
    private By buttonYesOrder = By.xpath(".//div[@class='Order_Modal__YZ-d3']//button[text()='Да']");
    //Локатор окна об успешном заказе
    private By successfulOrder =By.xpath(".//div[contains(@class, 'Order_ModalHeader__3FDaJ') and contains (text(), 'Заказ оформлен')]");

    //Конструктор класса
    public OrderFormTwo(WebDriver driver) {
        this.driver = driver;
    }

    //Метод заполняет поле Когда привезти заказ
    public void setWhenToBringTheScooter(String date) {
        driver.findElement(whenToBringTheScooter).sendKeys(date);
        driver.findElement(whenToBringTheScooter).sendKeys(Keys.ENTER);
    }

    //Метод выбирает срок аренды
    public void choosingTheRentalPeriod(String rentalPeriod) {
        driver.findElement(theRentalPeriodField).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(listOfRentalPeriod(rentalPeriod)));
        driver.findElement(listOfRentalPeriod(rentalPeriod)).click();
    }

    //Метод выбирает цвет самоката
    public void scooterColorSelection(String colorScooter) {
        driver.findElement(By.id(colorScooter)).click();
    }
    //Метод заполняет поле Комментарий для курьера
    public void setCommentField(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    //Метод кликает по кнопке Заказать
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    //Метод кликает по кнопке Да
    public void clickButtonYesOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(orderConfirmationWindow));
        driver.findElement(buttonYesOrder).click();
    }

    //Метод заполняет все поля и кликает по кнопкам
    public void fillInAllTheFieldsAboutRent(String date, String rentalPeriod, String colorScooter, String comment) {
        setWhenToBringTheScooter(date);
        choosingTheRentalPeriod(rentalPeriod);
        scooterColorSelection(colorScooter);
        setCommentField(comment);
        clickOrderButton();
        clickButtonYesOrder();
    }

    //Метод проверяет, что заказ оформлен
    public boolean checkSuccessfulOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(successfulOrder));
        return driver.findElement(successfulOrder).isDisplayed();
    }
}