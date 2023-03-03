package anhtester.com.pages.customers;

import anhtester.com.keywords.WebUI;
import static anhtester.com.keywords.WebUI.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CustomerDetailPage extends AddNewCustomerPage {

    //Object in customer Detail Page
    // không phải khai báo lại
    // không bị duplicate
    // Tiết kiệm thời gian
    // lỡ có thay đổi thì chỉ cần sửa ở 1 nơi =>AddNewCustomerPage

    public void checkCustomerDetail(String customerName) {
        System.out.println(getAttributeElement(company,"value"));
        System.out.println(getAttributeElement(vat,"value"));
        System.out.println(getAttributeElement(phoneNumber,"value"));
        //Kiểm tra thì phải dùng Assert
        //Phải dùng Equals chứ không dùng Contains
        Assert.assertEquals(getAttributeElement(company,"value"),customerName,"Company name not match.");
        Assert.assertEquals(getAttributeElement(vat,"value"),"10","Vat not match");
        Assert.assertEquals(getAttributeElement(phoneNumber,"value"),"0123456789","PhoneNumber not match");


    }

}
