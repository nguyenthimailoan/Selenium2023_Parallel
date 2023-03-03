package anhtester.com.common;

import anhtester.com.drivers.DriverManager;
import anhtester.com.helpers.PropertiesHelper;
import anhtester.com.keywords.WebUI;
//import com.beust.jcommander.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import java.time.Duration;
import org.testng.annotations.*;
public class BaseTest {

        @BeforeMethod
        @Parameters({"browser"})
        public static void createDriver(@Optional("chrome") String browser) {
          WebDriver driver =  setupDriver(browser);
            PropertiesHelper.loadAllFiles();
          //Set giá trị driver đã được khởi tạo vào ThreadLocal
            DriverManager.setDriver(driver);
            // Set luồng 1 giá trị 1
        }

        public static WebDriver setupDriver(String browserName) {
            WebDriver driver;
            switch (browserName.trim().toLowerCase()) {
                case "chrome":
                    driver = initChromeDriver();
                    break;
                case "firefox":
                    driver = initFirefoxDriver();
                    break;
                case "edge":
                    driver = initEdgeDriver();
                    break;
                default:
                    System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                    driver = initChromeDriver();
            }
            return driver;
        }

        private static WebDriver initChromeDriver() {
            System.out.println("Launching Chrome browser...");
            WebDriverManager.chromedriver().setup();
           WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            return driver;
        }

        private static WebDriver initEdgeDriver() {
            System.out.println("Launching Edge browser...");
            WebDriverManager.edgedriver().setup();
           WebDriver driver = new EdgeDriver();
            driver.manage().window().maximize();
            return driver;
        }

        private static WebDriver initFirefoxDriver() {
            System.out.println("Launching Firefox browser...");
            WebDriverManager.firefoxdriver().setup();
            WebDriver  driver = new FirefoxDriver();
            driver.manage().window().maximize();
            return driver;
        }

        @AfterMethod
        public static void closeDriver() {
            if(DriverManager.getDriver()!= null) {
                DriverManager.quit();
            }
        }


    @BeforeMethod
    public void createBrowser() {
        WebDriverManager.chromedriver().setup();
        System.out.println("Start Chrome browser from BaseTest...");
      WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Chờ đợi trang load xong (trong 40s)
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
    }

    @AfterMethod
    public void closeBrowser() {
        WebUI.sleep(2);
        System.out.println("Close browser from BaseTest...");
        DriverManager.quit();
    }
}
