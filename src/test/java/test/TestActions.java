package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.CreativePage;
import page.GooglePage;


public class TestActions {
    WebDriver webdriver;


    @Test(priority = 1, description = "Проверить url сайта")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Перейти на сайт и проверить корректность своего перехода на сайт")
    @Step("Поиск страницы креатив в гугл")
    public void checkIsCorrectWebsite() {
        Selenide.clearBrowserCookies();
        Configuration.headless = true;
        Configuration.clickViaJs = true;
        GooglePage googlePage = new GooglePage(webdriver);

        googlePage
                .openPage()
                .startSearchByKeyWords()
                .chooseItemFromSearchResults();
        String url = WebDriverRunner.getWebDriver().getCurrentUrl();

        Assert.assertEquals(url, "https://crtweb.ru/");

    }

    @Test(priority = 2, description = "Проверить наличия и корректности данных в разделе контакты")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Проверить наличия и корректности указания следующих контактных данных: +7 (499) 113-68-89 mail@crtweb.ru")
    public void checkForContentInWebSite() {
        GooglePage googlePage = new GooglePage(webdriver);
        CreativePage creativePage = new CreativePage(webdriver);
        googlePage
                .openPage()
                .startSearchByKeyWords()
                .chooseItemFromSearchResults();
        creativePage
                .clickOnMenu()
                .clickOnContactList();


        Assert.assertEquals(creativePage.getNumber(), "+7 (499) 113-68-89");
        Assert.assertEquals(creativePage.getMail(), "mail@crtweb.ru");


    }


}