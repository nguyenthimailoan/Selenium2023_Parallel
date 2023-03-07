package anhtester.com.dataproviders;

import org.testng.annotations.DataProvider;

public class DataLogin {
    @DataProvider(name = "dataProviderLoginCRM", parallel = true)
    public Object[][] dataLoginCRM(){
        return new Object[][]{
                {"admin1@example.com","123456"},
                {"admin2@example.com","123456"},
                {"admin3@example.com","123456"}
        };
    }
    @DataProvider(name = "dataProviderLoginCMS")
    public Object[][] dataLoginCMS(){
        return new Object[][]{
                {"admin1@example.com","123456", 123456},
                {"admin2@example.com","123456", 123456},
        };
    }

    @DataProvider(name = "dataCustomerCRM", parallel = true)
    public Object[][] dataCustomerCRM(){
        return new Object[][]{
                {"admin1@example.com","123456"},
                {"admin2@example.com","123456"},
                {"admin3@example.com","123456"}
        };
    }

    @DataProvider(name = "dataProjectCMS", parallel = true)
    public Object[][] dataProjectCMS(){
        return new Object[][]{
                {"admin1@example.com","123456"},
                {"admin2@example.com","123456"},
                {"admin3@example.com","123456"}
        };
    }
}
