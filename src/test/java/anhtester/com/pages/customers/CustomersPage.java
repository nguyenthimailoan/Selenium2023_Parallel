package anhtester.com.pages.customers;

import anhtester.com.common.BaseTest;
import anhtester.com.keywords.WebUI;
import static anhtester.com.keywords.WebUI.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CustomersPage extends BaseTest {
    //Các thuộc tính xác thực Customers Page
    private String PAGE_URL = "https://crm.anhtester.com/admin/clients";
    private String PAGE_TEXT = "Customers Summary";

    //Object thuộc Customers Page
    private By headerPageCustomers = By.xpath("//div[@class='panel-body']//h4[contains(.,'" + PAGE_TEXT + "')]");
    private By ButtonAddCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By buttonImportCustomer = By.xpath("//a[normalize-space()='Import Customers']");
    private By buttonContacts = By.xpath("//div[@class='_buttons']//a[normalize-space()='Contacts']");
    private By inputSearch = By.xpath("//div[@id='DataTables_Table_0_filter']//input");
    private By tdCustomerName = By.xpath("//tbody/tr[1]/td[3]/a[1]");


    // Hàm xử lý cho chức năng thuộc customers page
    public void verifyCustomersPage() {
        Assert.assertEquals(getCurrentURL(), PAGE_URL, "URL chưa đúng trang Customers.");
        Assert.assertTrue(checkElementExist(headerPageCustomers), "Header Page Customers not existing.");
        Assert.assertEquals(getTextElement(headerPageCustomers), PAGE_TEXT, "Header Page of Customers page not match.");

    }

    public AddNewCustomerPage clickNewCustomerButton(){
    //   waitForElementVisible(ButtonAddCustomer,10);
    //    driver.findElement(ButtonAddCustomer).click();
        clickElement(ButtonAddCustomer);
        return new AddNewCustomerPage();
    }

    public void SearchCustomer(String companyName){
       waitForPageLoaded();  // chờ đợi trang tải xong
    //    waitForElementVisible(inputSearch,10);   //chờ đợt input hiển thị
    //    driver.findElement(inputSearch).sendKeys(companyName);
        setText(inputSearch,companyName);
        sleep(2);

    }
    public CustomerDetailPage ClickOnFirstRowCustomerName(){
        waitForPageLoaded();  // chờ đợi trang tải xong
    //    waitForElementVisible(inputSearch,10);
    //    driver.findElement(tdCustomerName).click();
        clickElement(tdCustomerName);
        return new CustomerDetailPage();

    }


}
