import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Parameterized.class)
public class TestMainPageImportantQuestions {
    private WebDriver driver;
    private static final By MAIN_QUESTIONS = By.xpath    //Раздел "Вопросы о важном"
            ("//div[@class=\"accordion\"]");
    private static String TXT_0 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой."; // Соответствующий текст 1-ой строки раздела "Вопросы о важном"
    private static String TXT_1 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с " + // Соответствующий текст 2-ой строки раздела «Вопросы о важном
            "друзьями, можете просто сделать несколько заказов — один за другим.";
    private static String TXT_2 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в " + // Соответствующий текст 3-ой строки раздела «Вопросы о важном
            "течение дня. Отсчёт времени аренды начинается с момента, когда вы " +
            "оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная " +
            "аренда закончится 9 мая в 20:30.";
    private static String TXT_3 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее."; // Соответствующий текст 4-ой строки раздела «Вопросы о важном
    private static String TXT_4 = "Пока что нет! Но если что-то срочное — всегда можно позвонить " +
            "в поддержку по красивому номеру 1010."; // Соответствующий текст 5-ой строки раздела «Вопросы о важном
    private static String TXT_5 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на " +
            "восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."; // Соответствующий текст 6-ой строки раздела «Вопросы о важном
    private static String TXT_6 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной " +
            "записки тоже не попросим. Все же свои."; // Соответствующий текст 7-ой строки раздела «Вопросы о важном
    private static String TXT_7 = "Да, обязательно. Всем самокатов! И Москве, и Московской области."; // Соответствующий текст 8-ой строки раздела «Вопросы о важном
    private static final By ACCORDION_HEADING_0 = By.xpath
            ("//*[text()=\"Сколько это стоит? И как оплатить?\"]");
    private static final By ACCORDION_HEADING_1 = By.xpath
            ("//*[text()=\"Хочу сразу несколько самокатов! Так можно?\"]"); // 2-я строка раздела «Вопросы о важном
    private static final By ACCORDION_HEADING_2 = By.xpath
            ("//*[text()=\"Как рассчитывается время аренды?\"]"); // 3-я строка раздела «Вопросы о важном
    private static final By ACCORDION_HEADING_3 = By.xpath
            ("//*[text()=\"Можно ли заказать самокат прямо на сегодня?\"]"); // 4-я строка раздела «Вопросы о важном
    private static final By ACCORDION_HEADING_4 = By.xpath
            ("//*[text()=\"Можно ли продлить заказ или вернуть самокат раньше?\"]"); // 5-я строка раздела «Вопросы о важном
    private static final By ACCORDION_HEADING_5 = By.xpath
            ("//*[text()=\"Вы привозите зарядку вместе с самокатом?\"]"); // 6-я строка раздела «Вопросы о важном
    private static final By ACCORDION_HEADING_6 = By.xpath
            ("//*[text()=\"Можно ли отменить заказ?\"]"); // 7-я строка раздела «Вопросы о важном
    private static final By ACCORDION_HEADING_7 = By.xpath
            ("//*[text()=\"Я живу за МКАДом, привезёте?\"]"); // 8-я строка раздела «Вопросы о важном
    private static String expectedText;
    private By accordionHeading;
    // private  ;
    public TestMainPageImportantQuestions (By accordionHeading, String expectedText){
        this.accordionHeading = accordionHeading;
        this.expectedText = expectedText;
    }
    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {ACCORDION_HEADING_0, TXT_0},
                {ACCORDION_HEADING_1, TXT_1},
                {ACCORDION_HEADING_2, TXT_2},
                {ACCORDION_HEADING_3, TXT_3},
                {ACCORDION_HEADING_4, TXT_4},
                {ACCORDION_HEADING_5, TXT_5},
                {ACCORDION_HEADING_6, TXT_6},
                {ACCORDION_HEADING_7, TXT_7},
        };
    }
    @Test
    public void testMainPageImportantQuestions() {   //  Тест первой строки раздела «Вопросы о важном
        MainPageImportantQuestions tester = new MainPageImportantQuestions(driver);
        tester.openPage_scrollToImportantQuestions();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(MAIN_QUESTIONS));
        String foundText = tester.clickAccordionHeading_getText(accordionHeading);
        Assert.assertEquals("Фактический текст не соответствует ожидаемому!", expectedText, foundText);
    }

    public void teardown() {
        driver.quit();
    }
}
