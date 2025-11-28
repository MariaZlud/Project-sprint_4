package tests;

import org.junit.Assert;
import pages.OrderForm;
import pages.OrderFormTwo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestOrderForm extends TestData {
    String name;
    String surname;
    String address;
    String station;
    String phone;
    String date;
    String rentalPeriod;
    String colorScooter;
    String comment;

    public TestOrderForm(String name, String surname, String address, String station,
                         String phone, String date, String rentalPeriod, String colorScooter,
                         String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.station = station;
        this.phone = phone;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.colorScooter = colorScooter;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getDataTest() {
        return new Object[][] {
                {"Василий", "Иванов", "ул. Союзная, 2", "Сокольники", "89998887766",
                        "30.11.2025", "трое суток", "black", "Предварительно позвонить"},
                {"Николай", "Николаев", "бульвар Мира, 5", "Черкизовская", "89995554433",
                        "29.11.2025", "сутки", "grey", "Оставить у двери"},
        };
    }

    @Test
    public void TestOrderAndTopButton() {
        OrderForm orderForm = new OrderForm(driver);
        OrderFormTwo orderFormTwo = new OrderFormTwo(driver);

        mainPage.clickButtonOrderInHeader();
        orderForm.fillInAllFieldsForWhom(name, surname, address, station, phone);
        orderFormTwo.fillInAllTheFieldsAboutRent(date, rentalPeriod, colorScooter, comment);
        Assert.assertTrue("Сообщение об успешном заказе не отобразилось", orderFormTwo.checkSuccessfulOrder());

    }

    @Test
    public void TestOrderAndBottomButton() {
        OrderForm orderForm = new OrderForm(driver);
        OrderFormTwo orderFormTwo = new OrderFormTwo(driver);

        mainPage.clickButtonOrderAtBottom();
        orderForm.fillInAllFieldsForWhom(name, surname, address, station, phone);
        orderFormTwo.fillInAllTheFieldsAboutRent(date, rentalPeriod, colorScooter, comment);
        Assert.assertTrue("Сообщение об успешном заказе не отобразилось", orderFormTwo.checkSuccessfulOrder());
    }
}
