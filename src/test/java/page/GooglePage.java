package page;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import static com.codeborne.selenide.Selenide.$;


public class GooglePage {
    private final String HOMEPAGE_URL = "https://www.google.kz/";
    public static WebDriver webDriver;

    public GooglePage(WebDriver driver) {
        this.webDriver = driver;
    }

    @Step("Открытие браузер")
    public GooglePage openPage() {
        Selenide.open(HOMEPAGE_URL);
        return this;
    }

    @Step("Поиск страницы креатив в гугл")
    public GooglePage startSearchByKeyWords() {
        $(By.xpath("//input[@type='text']")).should(Condition.visible).sendKeys("crtweb.ru");
        $(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']")).click();
        return this;
    }

    @Step("Выбрать найденную ссылку")
    public GooglePage chooseItemFromSearchResults() {
        $(By.xpath("//h3[normalize-space()='Creative']")).should(Condition.visible).click();
        return this;
    }


}