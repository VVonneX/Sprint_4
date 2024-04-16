package test;

import PageObjectScooterAndQuestion.ImportantQuestion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class ParamQuestionTest {

    private static String  zeroQuestion;
    private static String  firstQuestion;
    private static String  secondQuestion;
    private static String  thirdQuestion;
    private static String  fourthQuestion;
    private static String  fifthQuestion;
    private static String  sixthQuestion;
    private static String  seventhQuestion;

    public ParamQuestionTest(String  zeroQuestion, String firstQuestion, String  secondQuestion, String  thirdQuestion, String  fourthQuestion,
                             String  fifthQuestion, String  sixthQuestion, String  seventhQuestion) {
        this.zeroQuestion = zeroQuestion;
        this.firstQuestion = firstQuestion;
        this.secondQuestion = secondQuestion;
        this.thirdQuestion = thirdQuestion;
        this.fourthQuestion = fourthQuestion;
        this.fifthQuestion = fifthQuestion;
        this.sixthQuestion = sixthQuestion;
        this.seventhQuestion = seventhQuestion;
    }

    @Parameterized.Parameters
    public static Object[][] getFieldScooter() {
        return new Object[][]{
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                 "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                 "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                 "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                 "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                 "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                 "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                 "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Test
    public void TestQuestion(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        ImportantQuestion importantQuestion = new ImportantQuestion(driver);
        importantQuestion.clickButtonCookie();
        importantQuestion.scrollToQuestion();
        importantQuestion.clickWaitAndIsEnabledQuestionZero(zeroQuestion);
        importantQuestion.clickWaitAndIsEnabledQuestionOne(firstQuestion);
        importantQuestion.clickWaitAndIsEnabledQuestionTwo(secondQuestion);
        importantQuestion.clickWaitAndIsEnabledQuestionThree(thirdQuestion);
        importantQuestion.clickWaitAndIsEnabledQuestionFour(fourthQuestion);
        importantQuestion.clickWaitAndIsEnabledQuestionFive(fifthQuestion);
        importantQuestion.clickWaitAndIsEnabledQuestionSix(sixthQuestion);
        importantQuestion.clickWaitAndIsEnabledQuestionSeven(seventhQuestion);

        driver.quit();
    }
}
