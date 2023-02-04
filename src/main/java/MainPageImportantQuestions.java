import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageImportantQuestions {
    private final WebDriver driver;
    private static final By CookieButton = By.xpath("//*[@id=\"rcc-confirm-button\"]"); // Кнопка "да все привыкли"
    private static final By ImportantQuestions = By.xpath("//div[@class=\"Home_FAQ__3uVm4\"]"); // Раздел "Вопросы о важном"

    public MainPageImportantQuestions(WebDriver driver) {
        this.driver = driver;
    }

    public void openPageAndScrollToImportantQuestions() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.findElement(CookieButton).click();
        WebElement element = driver.findElement(ImportantQuestions);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public String clickAccordionHeadingAndGetText(By textLink) {
        driver.findElement(textLink).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"accordion__panel\"][not(@hidden)]")));
        return driver.findElement(By.xpath("//div[@class=\"accordion__panel\"][not(@hidden)]")).getText();
    }
    public void waitVisibilityImportantQuestions() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ImportantQuestions));
    }
}
// //div[@aria-expanded='true']/parent :: div/parent::div/div[@class='accordion__panel']/p     //div[@class="accordion__panel"][not(@hidden)]