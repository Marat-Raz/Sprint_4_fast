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
    private static final By ACCORDION_HEADING_0 = By.xpath
            ("//*[text()=\"Сколько это стоит? И как оплатить?\"]");
    String TXT_0 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой."; // Соответствующий текст 1-ой строки раздела «Вопросы о важном

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void test_1_MainPageImportantQuestions() {   //  Тест первой строки раздела «Вопросы о важном
        MainPageImportantQuestions tester = new MainPageImportantQuestions(driver);
        tester.openPage_scrollToImportantQuestions();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ACCORDION_HEADING_0));
        String text0 = tester.clickAccordionHeading_getText(ACCORDION_HEADING_0);
        Assert.assertEquals("Фактический текст не соответствует ожидаемому!", TXT_0, text0);
    }

    public void teardown() {
        driver.quit();
    }
}
