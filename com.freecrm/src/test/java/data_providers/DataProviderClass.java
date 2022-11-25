package data_providers;

import base.BasePage;
import org.testng.annotations.DataProvider;
import utils.ExcelData;

import java.util.Iterator;

public class DataProviderClass extends BasePage {

   @DataProvider (name = "loginCredentials")
    public static Object[][] getLoginCredentials (){
        return excel.readStringArrays("LoginCredentials");
    }

    @DataProvider(name = "DatesData")
    public static Object[][] getDates(){
       return excel.readStringArrays("RandomDatesData");
    }


}
