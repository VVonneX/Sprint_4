package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import page.object.question.ImportantQuestion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class ParamQuestionTest {

    private static final String URL = "https://qa-scooter.praktikum-services.ru/";
    private WebDriver driver;
    private int index;
    private String answer;

    public ParamQuestionTest(int index, String answer) {
        this.index = index;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Object[][] getFieldQuestions() {
        return new Object[][]{
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Before
    public void setup(){
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @Test
    public void TestQuestion(){

        ImportantQuestion importantQuestion = new ImportantQuestion(driver);
        importantQuestion.clickButtonCookie();
        importantQuestion.scrollAndWaitToQuestion(index);
        boolean answerIsDisplayed = importantQuestion.answerIsDisplayed(answer);
        Assert.assertTrue(answerIsDisplayed);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
