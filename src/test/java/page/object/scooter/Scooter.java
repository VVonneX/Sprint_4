package page.object.scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Scooter {

    private WebDriver driver;

    //поле ввода для станции метро
    private final By selectSearchInput = By.className("select-search__input");

    //поля ввода для имени
    private final By locatorByInputNameInFillingOutTheForm = By.xpath("//input[@placeholder='* Имя']");

    //поля ввода для фамилии
    private final By locatorByInputFirstnameInFillingOutTheForm = By.xpath("//input[@placeholder='* Фамилия']");

    //поля ввода для адреса
    private final By locatorByInputAddressInFillingOutTheForm = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");

    //поля ввода для телефона
    private final By locatorByInputPhoneNumberInFillingOutTheForm = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    //кнока для перехода на следующую страницу
    private final By locatorByButtonInFillingOutTheForm = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']");

    //поля для выбора даты привоза самоката
    private final By locatorByOpenCalendarOfDeliveryScooter = By.xpath("//input[@placeholder='* Когда привезти самокат']");

    //поля ввода для выборка срока аренды
    private final By locatorByOpenFieldPeriodRenalScooter = By.xpath("//div[@class='Dropdown-placeholder' and text()='* Срок аренды']");

    //поля ввода для выбора времени аренды
    private final By locatorByDurationRentalScooter = By.xpath("//div[@class='Dropdown-option' and text()='сутки']");

    //поля ввода для выбора цвета
    private final By locatorByColorScooter = By.id("black");

    //поля ввода для ввода коментария курьеру
    private final By locatorByCommentCourierScooter = By.xpath("//input[@placeholder='Комментарий для курьера']");

    //кнопка для оформления заказа на центре главной страницы и при вводе всех данных на странице "Про аренду"
    private final By locatorByClickButtonOrderScooter = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");

    //кнопка для подтверждения заказа
    private final By locatorByClickButtonOrderConfirmationScooter = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    //кнопка для просмотра статуса заказа
    private final By locatorByGetTextButtonConfirmation = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Посмотреть статус']");

    //кнопка "Заказать" в шапке страницы
    private final By locatorByHeaderButton = By.className("Button_Button__ra12g");

    //кнопка cookie
    private final By locatorByButtonCookie = By.id("rcc-confirm-button");

    public Scooter(WebDriver driver){
        this.driver = driver;
    }

    public void clickButtonCookie() {
        driver.findElement(locatorByButtonCookie).click();
    }

    public void clickHeaderButtonScooter() {
        driver.findElement(locatorByHeaderButton).click();
    }

    public void scrollAndClickToButtonScooter() {
        WebElement element = driver.findElement(locatorByClickButtonOrderScooter);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public void findSubway(String sendText) {
        driver.findElement(selectSearchInput).click();
        driver.findElement(selectSearchInput).sendKeys(sendText);
        WebElement element = driver.findElement(By.xpath("//div[@class='Order_Text__2broi' and text()='"+sendText+"']"));
        element.click();
    }

    public void clickAndFillingOutTheForm(String name, String firstname, String address, String phoneNumber, String station){
        driver.findElement(locatorByInputNameInFillingOutTheForm).sendKeys(name);
        driver.findElement(locatorByInputFirstnameInFillingOutTheForm).sendKeys(firstname);
        driver.findElement(locatorByInputAddressInFillingOutTheForm).sendKeys(address);
        findSubway(station);
        driver.findElement(locatorByInputPhoneNumberInFillingOutTheForm).sendKeys(phoneNumber);
        driver.findElement(locatorByButtonInFillingOutTheForm).click();
    }

    public void clickCalendarBlueBackgroundRental() {
        String blueColorRGBA = "rgba(33, 107, 165, 1)";
        List<WebElement> elements = driver.findElements(By.cssSelector("*"));
        for (WebElement element: elements) {
            String color = element.getCssValue("background-color");
            if (color.equals(blueColorRGBA)) {
                element.click();
                break;
            }
        }
    }

    public String getTextConfirmationScooter(){
        WebElement element = driver.findElement(locatorByGetTextButtonConfirmation);
        return element.getText();
    }

    public void fillingOutTheFormRental(String date, String comment){
        driver.findElement(locatorByOpenCalendarOfDeliveryScooter).sendKeys(date);
        clickCalendarBlueBackgroundRental();
        driver.findElement(locatorByOpenFieldPeriodRenalScooter).click();
        driver.findElement(locatorByDurationRentalScooter).click();
        driver.findElement(locatorByColorScooter).click();
        driver.findElement(locatorByCommentCourierScooter).sendKeys(comment);
        driver.findElement(locatorByClickButtonOrderScooter).click();
        driver.findElement(locatorByClickButtonOrderConfirmationScooter).click();
    }

}