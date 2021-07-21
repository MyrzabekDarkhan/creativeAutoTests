package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaiterUtil {

    public void waitUntilBePresence(WebDriver driver, int timeout, String xpath) {
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

}