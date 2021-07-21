package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreativePage {
    protected WebDriver webdriver;
    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement menuHamburger;

    @FindBy(xpath = "//a[contains(text(),'контакты')]")
    private WebElement contactsList;


    public CreativePage(WebDriver driver) {
        this.webdriver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Нажать на меню сайта креатив")
    public CreativePage clickOnMenu() {
        menuHamburger.click();
        return this;
    }

    @Step("Выбрать раздел контакты")
    public CreativePage clickOnContactList() {
        new WebDriverWait(webdriver, 4).until(ExpectedConditions.visibilityOf(contactsList));
        contactsList.click();
        return this;
    }

}
