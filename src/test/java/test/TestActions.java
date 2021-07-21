package test;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.CreativePage;
import page.GooglePage;




public class TestActions{
    WebDriver webdriver;




    @BeforeMethod
    public void profileSetup() {

       System.setProperty("webdriver.chrome.driver" , "X:/webdrivers/chromedriver.exe");
        webdriver = new ChromeDriver();
        GooglePage googlePage = new GooglePage(webdriver);
        googlePage
                .openPage();
        webdriver.manage().window().maximize();


    }

    @Test(priority = 1,description = "Проверить url сайта")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Перейти на сайт и проверить корректность своего перехода на сайт")
    @Step("Поиск страницы креатив в гугл")
    public void checkIsCorrectWebsite() {
        GooglePage googlePage = new GooglePage(webdriver);

        googlePage
                .startSearchByKeyWords()
                .chooseItemFromSearchResults();
        String url = webdriver.getCurrentUrl();

        Assert.assertEquals(url, "https://crtweb.ru/");

    }

    @Test(priority = 2,description = "Проверить наличия и корректности данных в разделе контакты")
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

        Assert.assertEquals(webdriver.findElement(By.xpath("//a[normalize-space()='+7 (499) 113-68-89']")).getText(), "+7 (499) 113-68-89");
        Assert.assertEquals(webdriver.findElement(By.xpath("//a[@class='tn-atom'][normalize-space()='mail@crtweb.ru']")).getText(), "mail@crtweb.ru");


    }


    @AfterMethod
    public void reportReady(){
        webdriver.quit();
    }

}