package anhtester.com.testcases;

import anhtester.com.common.BaseTest;
import anhtester.com.pages.customers.AddNewCustomerPage;
import anhtester.com.pages.customers.CustomerDetailPage;
import anhtester.com.pages.customers.CustomersPage;
import anhtester.com.pages.DashboardPage;
import anhtester.com.pages.LoginPage;
import org.testng.annotations.Test;

public class CustomersTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomersPage customerPage;
    AddNewCustomerPage addcustomerPage;
    CustomerDetailPage customerdetailPage;


    @Test
        public void testAddNewCustomer(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.login("admin@example.com","123456");
        customerPage = dashboardPage.openCustomerPage();

        //Kiểm tra trang Customer Page load được hay chưa và đúng hay chưa
        customerPage.verifyCustomersPage();
     //   customerPage.clickNewCustomerButton();
        //click vào nút New Customer
        addcustomerPage = customerPage.clickNewCustomerButton();
        //Mai Loan, Addison, Joseph, Adorno, Theodor, Keido,
        String CUSTOMER_NAME = "Joseph";
        addcustomerPage.AddDataNewCustomer(CUSTOMER_NAME);

        // Mở lại trang customer
        dashboardPage.openCustomerPage();
        //Search giá trị Customer vừa add
        customerPage.SearchCustomer(CUSTOMER_NAME);
        //Click vào giá trị Customer Name dòng đầu tiên
        customerdetailPage = customerPage.ClickOnFirstRowCustomerName();
        // check customer Detail
        customerdetailPage.checkCustomerDetail(CUSTOMER_NAME);

    }
}
