package test;

import org.junit.After;
import org.junit.Before;
import pageobject.scooter.Scooter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class ParamScooterTest {

    private static final String URL = "https://qa-scooter.praktikum-services.ru/";
    private WebDriver driver;
    private static String name;
    private static String firstname;
    private static String address;
    private static String phoneNumber;
    private static String station;
    private static String date;
    private static String comment;
    private static String actionStatus;

    public ParamScooterTest(String name, String firstname, String address, String phoneNumber,
                            String station, String date, String comment, String actionStatus) {
        this.name = name;
        this.firstname = firstname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.station = station;
        this.date = date;
        this.comment = comment;
        this.actionStatus = actionStatus;
    }

    @Parameterized.Parameters
    public static Object[][] getFieldScooter() {
        return new Object[][]{
                {"Миша", "Чуриков", "Есенина 21", "11111111111", "Красносельская",
                        "1.05.2024", "Привезите во 2 половине дня!", "Посмотреть статус"},
                {"Виктория", "Ещенко", "Коммунаров 42б", "11111111111", "Комсомольская",
                        "15.05.2024", "Привезите в 1 половине дня!!", "Посмотреть статус"},
        };
    }

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @Test
    public void scooterTestInHeaderPage() {
        Scooter scooter = new Scooter(driver);
        scooter.clickButtonCookie();
        scooter.clickHeaderButtonScooter();
        scooter.clickAndFillingOutTheForm(name, firstname, address, phoneNumber, station);
        scooter.fillingOutTheFormRental(date, comment);
        String getText = scooter.getTextConfirmationScooter();
        Assert.assertEquals("Финальные значения должны совпадать!", actionStatus, getText);
    }

    @Test
    public void scooterTestInHomePage() {
        Scooter scooter = new Scooter(driver);
        scooter.clickButtonCookie();
        scooter.scrollAndClickToButtonScooter();
        scooter.clickAndFillingOutTheForm(name, firstname, address, phoneNumber, station);
        scooter.fillingOutTheFormRental(date, comment);
        String getText = scooter.getTextConfirmationScooter();
        Assert.assertEquals("Финальные значения должны совпадать!", actionStatus, getText);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
