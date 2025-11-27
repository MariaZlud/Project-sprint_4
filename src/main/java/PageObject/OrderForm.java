package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderForm {
    private WebDriver driver;

    //Локатор поля Имя
    private By nameField = By.xpath(".//input[@placeholder='* Имя']");
    //Локатор поля Фамилия
    private By lastNameField = By.xpath(".//input[@placeholder='* Фамилия']");
    //Локатор поля Адрес
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Локатор поля Станция метро
    private By metroStationField = By.xpath(".//input[@placeholder='* Станция метро']");
    //Локатор поля Телефон
    private By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Локатор кнопки Далее
    private By theNextButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']//button[text()='Далее']");

    //Конструктор класса
    public OrderForm(WebDriver driver) {

        this.driver = driver;
    }


    //Метод заполняет поле Имя
    public void setNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    //Метод заполняет поле Фамилия
    public void setLastNameField(String surname) {
        driver.findElement(lastNameField).sendKeys(surname);
    }

    //Метод заполняет поле Адрес
    public void setAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    //Метод заполняет поле Станция метро
    public void setMetroStationField(String station) {
        driver.findElement(metroStationField).click();
        driver.findElement(By.xpath(".//div[text()='"+ station +"']")).click();
    }
    //Метод заполняет поле Телефон
    public void setPhoneField(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    //Метод кликает по кнопке Далее
    public void clickTheNextButton() {
        driver.findElement(theNextButton).click();
    }

    //Метод заполняет все поля и кликает по кнопке
    public void fillInAllFieldsForWhom(String name, String surname, String address, String station, String phone) {
        setNameField(name);
        setLastNameField(surname);
        setAddressField(address);
        setMetroStationField(station);
        setPhoneField(phone);
        clickTheNextButton();
    }
}
