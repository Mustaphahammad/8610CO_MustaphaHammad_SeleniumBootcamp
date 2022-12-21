package data_providers;

import base.BasePage;
import org.testng.annotations.DataProvider;

import java.util.Iterator;

public class DataProviderClass extends BasePage {

    @DataProvider(name = "LoginCredentials")
    public static Object[][] getLoginCredentials() {
        return excel.readStringArrays("LoginCredentials");
    }

    @DataProvider(name = "vehiclesType")
    public static Object[][] getVehicleType() {
        return excel.readStringArrays("vehiclesType");
    }

    @DataProvider(name = "SUVsModel")
    public static Object[][] getSUVsOptions() {
        return excel.readStringArrays("SUVsModel");
    }

    @DataProvider(name = "Sedans&WagonsModel")
    public static Object[][] getSedansOptions() {
        return excel.readStringArrays("Sedans&WagonsModel");
    }

    @DataProvider(name = "CoupesModel")
    public static Object[][] getCoupesOptions() {
        return excel.readStringArrays("CoupesModel");
    }

    @DataProvider(name = "ConvertiblesModel")
    public static Object[][] getConvertiblesOptions() {
        return excel.readStringArrays("ConvertiblesModel");
    }

    @DataProvider(name = "ElectricModel")
    public static Object[][] getElectricOptions() {
        return excel.readStringArrays("ElectricModel");
    }
}
