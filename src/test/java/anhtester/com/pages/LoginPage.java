package anhtester.com.pages;

import anhtester.com.helpers.PropertiesHelper;
import anhtester.com.keywords.WebUI;
import static anhtester.com.keywords.WebUI.*;
import static anhtester.com.keywords.WebUI.getTextElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;
import org.testng.Assert;

public class LoginPage {

    private String URL = "https://crm.anhtester.com/admin/authentication";
    private String PAGETEXT = "Login";

    //Lưu Object của trang Login
    //Dùng đối tượng By trong Selenium để khai báo tên Object cùng giá trị Locator tương ứng
    By headerPage = By.xpath("//h1");
    By inputEmail = By.xpath("//input[@id='email']");
    By inputPassword = By.xpath("//input[@id='password']");
    By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    By messageErrorEmail = By.xpath("//div[@class='text-center alert alert-danger']");



    //Viết các hàm xử lý cho trang Login
    public void verifyHeaderPage(){
        Assert.assertEquals(getTextElement(headerPage), "Login", "FAIL. Header not match.");
    }

    public void verifyErrorMessageDisplay(){
        Assert.assertTrue(getWebElement(messageErrorEmail).isDisplayed(), "FAIL. Error message no displays.");
        Assert.assertEquals(getTextElement(messageErrorEmail), "Invalid email or password", "FAIL. Content of the Error message not match.");

    }

    public void enterEmail(String email){
     //   driver.findElement(inputEmail).sendKeys(email);
        setText(inputEmail,email);
    }

    public void enterPassword(String password){
    //    driver.findElement(inputPassword).sendKeys(password);
        setText(inputPassword,password);
    }

    public void clickOnLoginButton(){
    //    driver.findElement(buttonLogin).click();
        clickElement(buttonLogin);
    }

    public DashboardPage login(String email, String password){
    //    driver.get(URL);
        openURL(PropertiesHelper.getValue("url"));
        verifyHeaderPage();
        enterEmail(email);
    //    setText(inputEmail,email);
        enterPassword(password);
    //    setText(inputPassword,password);
        clickOnLoginButton();
    //    clickElement(buttonLogin);

        return new DashboardPage();
    }

    public void loginInvalidEmail(String email, String password){
    //    driver.get(URL);
        openURL(PropertiesHelper.getValue("url"));
        verifyHeaderPage();
        enterEmail(email);
        enterPassword(password);
        clickOnLoginButton();
        //Kểm tra message thông báo lỗi khi sai email
        verifyErrorMessageDisplay();
    }

}
