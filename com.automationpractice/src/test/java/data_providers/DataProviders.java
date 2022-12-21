package data_providers;

import base.BasePage;
import org.testng.annotations.DataProvider;

public class DataProviders extends BasePage {
    @DataProvider(name = "loginCredentials")
    public static Object[][] getLoginCredentials() {
        return excel.readStringArrays("LoginCredentials");
    }

}
