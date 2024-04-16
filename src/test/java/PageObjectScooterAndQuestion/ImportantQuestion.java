package PageObjectScooterAndQuestion;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImportantQuestion {

    private WebDriver driver;

    //кнопка cookie
    private final By locatorByButtonCookie = By.id("rcc-confirm-button");

    //поле с 1 вопроса в списке "Вопросы о важном"
    private final By locatorByTextQuestionZero = By.id("accordion__heading-0");

    //поле со 2 вопроса в списке "Вопросы о важном"
    private final By locatorByTextQuestionOne = By.id("accordion__heading-1");

    //поле с 3 вопроса в списке "Вопросы о важном"
    private final By locatorByTextQuestionTwo = By.id("accordion__heading-2");

    //поле с 4 вопроса в списке "Вопросы о важном"
    private final By locatorByTextQuestionThree = By.id("accordion__heading-3");

    //поле с 5 вопроса в списке "Вопросы о важном"
    private final By locatorByTextQuestionFour = By.id("accordion__heading-4");

    //поле с 6 вопроса в списке "Вопросы о важном"
    private final By locatorByTextQuestionFive = By.id("accordion__heading-5");

    //поле с 7 вопроса в списке "Вопросы о важном"
    private final By locatorByTextQuestionSix = By.id("accordion__heading-6");

    //поле с 8 вопроса в списке "Вопросы о важном"
    private final By locatorByTextQuestionSeven = By.id("accordion__heading-7");

    //поле с 1 ответом в списке "Вопросы о важном"
    private final By locatorByTextAnswerToQuestionZero = By.id("accordion__panel-0");

    //поле со 2 ответом в списке "Вопросы о важном"
    private final By locatorByTextAnswerToQuestionOne = By.id("accordion__panel-1");

    //поле с 3 ответом в списке "Вопросы о важном"
    private final By locatorByTextAnswerToQuestionTwo = By.id("accordion__panel-2");

    //поле с 4 ответом в списке "Вопросы о важном"
    private final By locatorByTextAnswerToQuestionThree = By.id("accordion__panel-3");

    //поле с 5 ответом в списке "Вопросы о важном"
    private final By locatorByTextAnswerToQuestionFour = By.id("accordion__panel-4");

    //поле с 6 ответом в списке "Вопросы о важном"
    private final By locatorByTextAnswerToQuestionFive = By.id("accordion__panel-5");

    //поле с 7 ответом в списке "Вопросы о важном"
    private final By locatorByTextAnswerToQuestionSix = By.id("accordion__panel-6");

    //поле с 8 ответом в списке "Вопросы о важном"
    private final By locatorByTextAnswerToQuestionSeven = By.id("accordion__panel-7");

    public ImportantQuestion(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonCookie() {
        driver.findElement(locatorByButtonCookie).click();
    }

    public void scrollToQuestion() {
        WebElement element = driver.findElement(locatorByTextQuestionSeven);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickWaitAndIsEnabledQuestionZero(String text) {
        driver.findElement(locatorByTextQuestionZero).isEnabled();
        driver.findElement(locatorByTextQuestionZero).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(locatorByTextQuestionZero));
        Assert.assertEquals("Вопрос должен сопадать по тексту",
                text,
                driver.findElement(locatorByTextAnswerToQuestionZero).getText());
    }

    public void clickWaitAndIsEnabledQuestionOne(String text) {
        driver.findElement(locatorByTextQuestionOne).isEnabled();
        driver.findElement(locatorByTextQuestionOne).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(locatorByTextQuestionOne));
        Assert.assertEquals("Вопрос должен сопадать по тексту",
                text,
                driver.findElement(locatorByTextAnswerToQuestionOne).getText());
    }

    public void clickWaitAndIsEnabledQuestionTwo(String text) {
        driver.findElement(locatorByTextQuestionTwo).isEnabled();
        driver.findElement(locatorByTextQuestionTwo).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(locatorByTextQuestionTwo));
        Assert.assertEquals("Вопрос должен сопадать по тексту",
                text,
                driver.findElement(locatorByTextAnswerToQuestionTwo).getText());
    }

    public void clickWaitAndIsEnabledQuestionThree(String text) {
        driver.findElement(locatorByTextQuestionThree).isEnabled();
        driver.findElement(locatorByTextQuestionThree).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(locatorByTextQuestionThree));
        Assert.assertEquals("Вопрос должен сопадать по тексту",
                text,
                driver.findElement(locatorByTextAnswerToQuestionThree).getText());
    }

    public void clickWaitAndIsEnabledQuestionFour(String text) {
        driver.findElement(locatorByTextQuestionFour).isEnabled();
        driver.findElement(locatorByTextQuestionFour).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(locatorByTextQuestionFour));
        Assert.assertEquals("Вопрос должен сопадать по тексту",
                text,
                driver.findElement(locatorByTextAnswerToQuestionFour).getText());
    }

    public void clickWaitAndIsEnabledQuestionFive(String text) {
        driver.findElement(locatorByTextQuestionFive).isEnabled();
        driver.findElement(locatorByTextQuestionFive).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(locatorByTextQuestionFive));
        Assert.assertEquals("Вопрос должен сопадать по тексту",
                text,
                driver.findElement(locatorByTextAnswerToQuestionFive).getText());
    }

    public void clickWaitAndIsEnabledQuestionSix(String text) {
        driver.findElement(locatorByTextQuestionSix).isEnabled();
        driver.findElement(locatorByTextQuestionSix).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(locatorByTextQuestionSix));
        Assert.assertEquals("Вопрос должен сопадать по тексту",
                text,
                driver.findElement(locatorByTextAnswerToQuestionSix).getText());
    }

    public void clickWaitAndIsEnabledQuestionSeven(String text) {
        driver.findElement(locatorByTextQuestionSeven).isEnabled();
        driver.findElement(locatorByTextQuestionSeven).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(locatorByTextQuestionSeven));
        Assert.assertEquals("Вопрос должен сопадать по тексту",
                text,
                driver.findElement(locatorByTextAnswerToQuestionSeven).getText());
    }

}