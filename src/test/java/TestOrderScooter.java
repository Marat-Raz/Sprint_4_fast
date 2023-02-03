import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestOrderScooter {
    private WebDriver driver;
    private static final By BUTTON_1 = By.className("Button_Button__ra12g"); // Верхняя кнопка "Заказать";
  //  private static final By BUTTON_2 = By.className("Button_Button__ra12g Button_UltraBig__UU3Lp"); // Верхняя кнопка "Заказать";

        @Before
        public void setUp() {
            driver = new ChromeDriver();
        }

        @Test
        public void test_1_MainPageImportantQuestions() {   //  Тест первой строки раздела «Вопросы о важном
            OrderScooter tester = new OrderScooter(driver);
            tester.openPage_ClickOrderButton(BUTTON_1);
            tester.InputAllTextScooterFor("Андрей", "Авчинников", "Вишневского д.5","Бульвар Рокоссовского", "89274350870");
            tester.ClickBelowButton();
            tester.waitOrderButton();
            tester.InputAllTextOrderRent("20-Feb-2023", "сутки");
            tester.ClickOrderButton();
            tester.waitYesButton();
            tester.ClickYesButton();
            boolean isDisplayed = driver.findElement(By.xpath("//div[text()=\"Заказ оформлен\"]")).isDisplayed();
            Assert.assertTrue(isDisplayed);
        }

        public void teardown() {
            driver.quit();
        }
    }


/*
                    {BUTTON_1, "Андрей", "Авчинников", "Вишневского", "Бульвар Рокоссовского", "89274350870", "14.02.2023", "сутки", true},
                    {BUTTON_2, "Андрей", "Авчинников", "Вишневского", "Бульвар Рокоссовского", "89274350870", "14.02.2023", "сутки", true},
 */