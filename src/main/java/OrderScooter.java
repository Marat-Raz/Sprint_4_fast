import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderScooter {
    private WebDriver driver;
    private static final By CookieButton = By.xpath("//*[@id=\"rcc-confirm-button\"]"); // Кнопка "да все привыкли"

    private static final By INPUT_NAME = By.xpath   //Поле ввода "Имя"
            ("//input[@class=\"Input_Input__1iN_Z Input_Responsible__1jDKN\"][@placeholder=\"* Имя\"]");
    private static final By INPUT_SURNAME = By.xpath    //Поле ввода "Фамилия"
            ("//input[@class=\"Input_Input__1iN_Z Input_Responsible__1jDKN\"][@placeholder=\"* Фамилия\"]");
    private static final By INPUT_ADDRESS = By.xpath    //Поле ввода "Адресс"
            ("//input[@class=\"Input_Input__1iN_Z Input_Responsible__1jDKN\"][@placeholder=\"* Адрес: куда привезти заказ\"]");
    private static final By INPUT_METRO = By.xpath    //Поле ввода-выбора "Станфия метро"
            ("//input[@class=\"select-search__input\"]");
    private static final By INPUT_PHONE = By.xpath    //Поле ввода "Телефон"
            ("//input[@class=\"Input_Input__1iN_Z Input_Responsible__1jDKN\"][@placeholder=\"* Телефон: на него позвонит курьер\"]");
    private static final By BELOW_BUTTON = By.xpath  //Кнопка "Далее"
            ("//button[text()=\"Далее\"]");
    private static final By INPUT_DATE = By.xpath   //Поле выбора даты доставки самоката
            ("//input[@class=\"Input_Input__1iN_Z Input_Responsible__1jDKN\"][@placeholder=\"* Когда привезти самокат\"]");
    private static final By INPUT_PERIOD = By.xpath    //Поле выбора "Срок аренды"
            ("//div[@class=\"Dropdown-control\"]");
    private static final By ORDER_BUTTON = By.xpath  //Кнопка "Заказать"
            ("//button[@class=\"Button_Button__ra12g Button_Middle__1CSJM\"]");

    private static final By YES_BUTTON = By.xpath  //Кнопка "Да"
            ("//button[text()=\"Да\"]");
    private static final By VIEW_STATUS_BUTTON = By.xpath  //Кнопка "Посмотреть статус"
            ("//button[text()=\"Посмотреть статус\"]");

    public OrderScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage_ClickOrderButton(By order_button) {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.findElement(CookieButton).click();
        WebElement element = driver.findElement(By.className("Home_FinishButton__1_cWm"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(order_button).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(BELOW_BUTTON));
    }

    private void inputText(By input, String variableText) {
        driver.findElement(input).clear();
        driver.findElement(input).sendKeys(variableText);
    }

    private void inputTextForSelect(By inputSelect, String variableTextForSelect) {
        driver.findElement(inputSelect).clear();
        driver.findElement(inputSelect).sendKeys(variableTextForSelect + Keys.ARROW_DOWN + Keys.ENTER);

    }

    public void InputAllTextScooterFor(String name, String surName, String address, String metroStation, String phoneNumber) {
        inputText(INPUT_NAME, name);
        inputText(INPUT_SURNAME, surName);
        inputText(INPUT_ADDRESS, address);
        inputTextForSelect(INPUT_METRO, metroStation);
        inputText(INPUT_PHONE, phoneNumber);
    }
    public void ClickBelowButton() {
        driver.findElement(BELOW_BUTTON).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("Order_Form__17u6u")));
    }
    public void waitOrderButton () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ORDER_BUTTON));
    }
    private void inputDate(By inputSelect, String variableDate) {
        driver.findElement(inputSelect).clear();
        driver.findElement(inputSelect).sendKeys(variableDate + Keys.ESCAPE);

    }
    private void selectText(By inputSelect, String variablePeriod) {
        driver.findElement(inputSelect).click();
        driver.findElement(By.xpath("//div[text()='" + variablePeriod + "']")).click();

    }
        public void InputAllTextOrderRent (String date, String rentalPeriod) {
        inputDate (INPUT_DATE, date);
        selectText (INPUT_PERIOD, rentalPeriod);

    }
        public void ClickOrderButton () {
        driver.findElement(ORDER_BUTTON).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("Order_Modal__YZ-d3")));
    }
    public void waitYesButton () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(YES_BUTTON));
    }
    public void ClickYesButton () {
        driver.findElement(YES_BUTTON).click();
     //   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
     //   wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[text()=\"Заказ оформлен\"]")));
    }

}