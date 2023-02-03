import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
public class MainPageImportantQuestions {
    private final WebDriver driver;
    private static final By CookieButton = By.xpath("//*[@id=\"rcc-confirm-button\"]"); // Кнопка "да все привыкли"
    private static final By ImportantQuestions = By.xpath("//div[@class=\"Home_FAQ__3uVm4\"]"); // Раздел "Вопросы о важном"

    public MainPageImportantQuestions (WebDriver driver) {
        this.driver = driver;
    }

    public void openPage_scrollToImportantQuestions () {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.findElement(CookieButton).click();
        WebElement element = driver.findElement(ImportantQuestions);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);    }
    public String clickAccordionHeading_getText (By textLink) {
        driver.findElement(textLink).click();
        return driver.findElement(By.xpath("//div[@class=\"accordion__panel\"][not(@hidden)]")).getText();}
}
