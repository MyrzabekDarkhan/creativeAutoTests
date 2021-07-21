package page;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.WaiterUtil;


public class GooglePage extends WaiterUtil {
    private final String HOMEPAGE_URL = "https://www.google.kz/";
    public static WebDriver webDriver;

    public GooglePage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type='text']")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']")
    private WebElement searchClickBtn;

    @FindBy(xpath = "//h3[normalize-space()='Creative']")
    private WebElement foundResult;

    @Step("Открытие браузер")
    public GooglePage openPage() {
        webDriver.get(HOMEPAGE_URL);

        return this;
    }

    @Step("Поиск страницы креатив в гугл")
    public GooglePage startSearchByKeyWords() {
        waitUntilBePresence(webDriver, 5, "//input[@type='text']");
        searchInput.click();
        searchInput.sendKeys("crtweb.ru");
        searchClickBtn.click();
        return this;
    }

    @Step("Выбрать найденную ссылку")
    public GooglePage chooseItemFromSearchResults() {
        waitUntilBePresence(webDriver, 5, "//h3[normalize-space()='Creative']");
        foundResult.click();
        return this;
    }



}