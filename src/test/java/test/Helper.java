//package test;
//
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//
//public class Helper {
//    protected WebDriver driver;
//    public static String remote_url_chrome = "http://localhost:4445/wd/hub";
//
//
//    @BeforeTest
//    public void setUp() throws MalformedURLException {
//
//        DesiredCapabilities dc = DesiredCapabilities.chrome();
//
//
//        //String host = System.getProperty("seleniumHubHost");
//
//        driver = new RemoteWebDriver(new URL(remote_url_chrome), dc);
//    }
//
//
//
//    public void tearDownDriver()
//    {
//        driver.quit();
//        System.out.println("Report is ready to be shared, with screenshots of tests");
//    }
//}