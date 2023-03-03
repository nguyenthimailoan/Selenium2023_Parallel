package anhtester.com.pages.customers;

import anhtester.com.keywords.WebUI;
import static anhtester.com.keywords.WebUI.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AddNewCustomerPage extends CustomersPage {

    private String PAGE_URL = "https://crm.anhtester.com/admin/clients";
    private String PAGE_TEXT = "Customer Details";

    By tabCustomerDetail = By.xpath("//a[@aria-controls='contact_info']");
    public By company = By.xpath("//input[@id='company']");
    public By vat = By.xpath("//input[@id='vat']");
    public By phoneNumber = By.xpath("//input[@id='phonenumber']");
    private By website = By.xpath("//input[@id='website']");

    private By drodoawnGroups = By.xpath("//label[@for='groups_in[]']/following-sibling::div");
    private By inputGroup = By.xpath("//label[@for='groups_in[]']/following-sibling::div//input[@type='search']");



//    private By currency = By.xpath("//button[@data-id='default_currency']");
//    private By language = By.xpath("//button[@data-id='default_language']");
    private By address = By.xpath("//textarea[@id='address']");
    private By city = By.xpath("//input[@id='city']");
    private By state = By.xpath("//input[@id='state']");
    private By zipcode = By.xpath("//input[@id='zip']");
    private By dropdoawncountry = By.xpath("//button[@data-id='country']");
    private By inputcountry = By.xpath("//label[@for='country']/following-sibling::div//input[@type='search']");
    private By saveBtn = By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']");


    public void selectGroup(String groupName){
    //    driver.findElement(dropdoawncountry).click();
        clickElement(drodoawnGroups);
       getWebElement(inputGroup).sendKeys(groupName, Keys.ENTER);
    //    driver.findElement(dropdoawncountry).click();
        clickElement(drodoawnGroups);
    }

    public void AddDataNewCustomer(String CUSTOMER_NAME){
        waitForPageLoaded();
//        driver.findElement(company).sendKeys(CUSTOMER_NAME);
//        driver.findElement(vat).sendKeys("10");
//        driver.findElement(phoneNumber).sendKeys("0123456789");
//        driver.findElement(website).sendKeys("https://anhtester.com");
//        driver.findElement(drodoawnGroups).click();
//        driver.findElement(inputGroup).sendKeys("Gold",Keys.ENTER);
//        driver.findElement(drodoawnGroups).click();
//        driver.findElement(address).sendKeys("Viet Nam");
//        driver.findElement(city).sendKeys("Can Tho");
//        driver.findElement(state).sendKeys("Can Tho");
//        driver.findElement(zipcode).sendKeys("92000");
//        driver.findElement(dropdoawncountry).click();
//        driver.findElement(inputcountry).sendKeys("Vietnam", Keys.ENTER);
//        driver.findElement(dropdoawncountry).click();
//        driver.findElement(saveBtn).click();

        setText(company,CUSTOMER_NAME);
        setText(vat, "10");
        setText(phoneNumber, "0123456789");
        setText(website, "https://anhtester.com");
        selectGroup("Gold");
        setText(address, "Viet Nam");
        setText(city, "Can Tho");
        setText(state, "Can Tho");
        setText(zipcode, "92000");
        clickElement(dropdoawncountry);
        getWebElement(inputcountry).sendKeys("Vietnam", Keys.ENTER);
        clickElement(saveBtn);

       waitForPageLoaded();



    }

}
