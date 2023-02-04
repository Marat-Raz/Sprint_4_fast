import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestMainPageImportantQuestions {
    private WebDriver driver;
    private static final By MAIN_QUESTIONS = By.xpath    //Раздел "Вопросы о важном"
            ("//div[@class=\"accordion\"]");

    String TXT_0 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой."; // Соответствующий текст 1-ой строки раздела "Вопросы о важном"
    /*
    String TXT_1 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с " + // Соответствующий текст 2-ой строки раздела «Вопросы о важном
            "друзьями, можете просто сделать несколько заказов — один за другим.";
    String TXT_2 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в " + // Соответствующий текст 3-ой строки раздела «Вопросы о важном
            "течение дня. Отсчёт времени аренды начинается с момента, когда вы " +
            "оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная " +
            "аренда закончится 9 мая в 20:30.";

    String TXT_3 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее."; // Соответствующий текст 4-ой строки раздела «Вопросы о важном
    String TXT_4 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."; // Соответствующий текст 5-ой строки раздела «Вопросы о важном
    String TXT_5 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."; // Соответствующий текст 6-ой строки раздела «Вопросы о важном
    String TXT_6 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."; // Соответствующий текст 7-ой строки раздела «Вопросы о важном
    String TXT_7 = "Да, обязательно. Всем самокатов! И Москве, и Московской области."; // Соответствующий текст 8-ой строки раздела «Вопросы о важном
*/
    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void testMainPageImportantQuestions() {   //  Тест первой строки раздела «Вопросы о важном
        MainPageImportantQuestions tester = new MainPageImportantQuestions(driver);
        tester.openPage_scrollToImportantQuestions();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(MAIN_QUESTIONS));
        String text0 = tester.clickAccordionHeading_getText(MAIN_QUESTIONS);
        Assert.assertEquals("Фактический текст не соответствует ожидаемому!", TXT_0, text0);
    }

    public void teardown() {
        driver.quit();
    }
}
