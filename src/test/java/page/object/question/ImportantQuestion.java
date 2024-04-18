package page.object.question;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImportantQuestion {

    private final WebDriver driver;

    //кнопка cookie
    private By ButtonCookieLocator = By.id("rcc-confirm-button");

    //поле с вопросами в списке "Вопросы о важном"
    private final String questionLocator = "accordion__heading-%s";

    //поле с ответами в списке "Вопросы о важном"
    private final String answerLocator = "//div[contains(@id, 'accordion__panel')][.='%s']";

    public ImportantQuestion(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonCookie() {
        driver.findElement(ButtonCookieLocator).click();
    }

    public void scrollAndWaitToQuestion(int index) {
        WebElement element = driver.findElement(By.id(String.format(questionLocator, index)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public boolean answerIsDisplayed(String ExpectedAnswer) {
        WebElement element = driver.findElement(By.xpath(String.format(answerLocator, ExpectedAnswer)));
        return element.isDisplayed();
    }
}