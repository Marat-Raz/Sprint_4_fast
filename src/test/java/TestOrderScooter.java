import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class TestOrderScooter {
    private WebDriver driver;
    private static final By BUTTON_1 = By.className("Button_Button__ra12g"); // Верхняя кнопка "Заказать";
    private static final By BUTTON_2 = By.xpath("//div[@class=\"Home_FinishButton__1_cWm\"]//button[text()=\"Заказать\"]"); // Нижняя кнопка "Заказать";
    private static By varButton;
  // private final boolean result;
        public TestOrderScooter(By varButton) {
        this.varButton = varButton;
     //   this.result = result;
    }
    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {BUTTON_1},
                {BUTTON_2},
        };
    }
        @Test
        public void testMainPageImportantQuestions() {   //  Тест первой строки раздела «Вопросы о важном
            OrderScooter tester = new OrderScooter(driver);
            tester.openPageAndClickOrderButton(varButton);
            tester.InputAllTextScooterFor("Андрей", "Авчинников", "Вишневского д.5","Бульвар Рокоссовского", "89274350870");
            tester.ClickBelowButton();
            tester.waitOrderButton();
            tester.InputAllTextOrderRent("20-Feb-2023", "сутки");
            tester.ClickOrderButton();
            tester.waitYesButton();
            tester.ClickYesButton();
            Assert.assertTrue(tester.orderPlacedIsDisplay());
        }
            public void teardown() {
            driver.quit();
        }
    }


