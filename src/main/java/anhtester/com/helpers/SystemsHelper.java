package anhtester.com.helpers;

import java.io.File;

public class SystemsHelper {

    // Hàm lấy đường dẫn tuyệt đối của project
    public static String getCurrentDir() {
        //D:\\Loantester\\SeleniumJava\\Course_092023\\SeleniumTestNG +"/";
        String current = System.getProperty("user.dir") + File.separator;
        return current;

    }
}
