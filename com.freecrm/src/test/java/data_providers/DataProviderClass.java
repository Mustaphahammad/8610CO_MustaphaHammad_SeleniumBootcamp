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
    @DataProvider(name = "contactsInfo")
    public static Object[][] getInfo(){
       return excel.readStringArrays("MyInfo");
    }
    //NewContact
    @DataProvider(name = "EventInfo")
    public static Object[][] getNewEventInfo(){
        return excel.readStringArrays("EventInfo");
    }

    @DataProvider(name = "NewContact")
    public static Object[][] getNewContactInfo(){
        return excel.readStringArrays("NewContact");
    }

    @DataProvider(name = "Time")
    public static Object[][] getEventTime(){return excel.readStringArrays("Time");}

    @DataProvider(name = "NewEvent")
    public static Object[][] getEventInfo2(){return excel.readStringArrays("NewEvent");}

}
