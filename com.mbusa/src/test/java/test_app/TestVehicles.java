package test_app;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_libray.*;

import java.lang.reflect.Array;

public class TestVehicles extends BasePage {
    @Test
    public void testSpecialOffersVehicleShowFilters() {
        HomePage homePage = new HomePage();
        homePage.navigateToVehicles()
                .navigateToSpecialOffers()
                .clickFilterButton();
        String expText = "Hide Filters";
        scrollByVisibleElement(SpecialOffersPage.filterButton);
        String actText = SpecialOffersPage.filterButton.getText();
        Assert.assertEquals(actText, expText);
    }

    @Test
    public void testSpecialOffersVehicleHideFilters() {
        HomePage homePage = new HomePage();
        VehiclesPage vP = homePage.navigateToVehicles();
        SpecialOffersPage sP = vP.navigateToSpecialOffers();
        sP.clickFilterButton();
        sP.clickFilterButton();
        String expText = "Show Filters";
        String actText = SpecialOffersPage.filterButton.getText();
        Assert.assertEquals(actText, expText);
    }

    @Test
    public void testSelectingVehicleBodyStyle() {
        HomePage homePage = new HomePage();
        VehiclesPage vP = homePage.navigateToVehicles();
        SpecialOffersPage sP = vP.navigateToSpecialOffers();
        scrollByVisibleElement(SpecialOffersPage.filterButton);
        sP.clickFilterButton();
        sP.chooseBodyStyle(0);
        Assert.assertTrue(isElementVisible(sP.theSelectedOptions.get(0)));
    }

    @Test
    public void testSelectingVehicleModel() {
        HomePage homePage = new HomePage();
        VehiclesPage vehiclesPage = homePage.navigateToVehicles();
        SpecialOffersPage sP = vehiclesPage.navigateToSpecialOffers();
        scrollByVisibleElement(SpecialOffersPage.filterButton);
        sP.clickFilterButton();
        sP.chooseModel(0);
        Assert.assertTrue(isElementVisible(sP.theSelectedOptions.get(0)));
    }

    @Test
    public void testSelectingVehicleYear() {
        HomePage homePage = new HomePage();
        VehiclesPage vehiclesPage = homePage.navigateToVehicles();
        SpecialOffersPage sP = vehiclesPage.navigateToSpecialOffers();
        scrollByVisibleElement(SpecialOffersPage.filterButton);
        sP.clickFilterButton();
        sP.chooseYear(0);
        Assert.assertTrue(isElementVisible(sP.theSelectedOptions.get(0)));
    }

    @Test
    public void testSelectingVehicleBodyStyleModelYear() {
        HomePage homePage = new HomePage();
        VehiclesPage vehiclesPage = homePage.navigateToVehicles();
        SpecialOffersPage sP = vehiclesPage.navigateToSpecialOffers();
        scrollByVisibleElement(SpecialOffersPage.filterButton);
        sP.clickFilterButton();
        sP.chooseBodyStyle(0);
        sP.chooseModel(0);
        sP.chooseYear(0);
        int expOptionsSelected = 3;
        int selectedOptionsNum = sP.theSelectedOptions.size();
        Assert.assertEquals(selectedOptionsNum, expOptionsSelected);
    }

    @Test
    public void testClearAllSelectedOptions() {
        HomePage homePage = new HomePage();
        VehiclesPage vehiclesPage = homePage.navigateToVehicles();
        SpecialOffersPage sP = vehiclesPage.navigateToSpecialOffers();
        scrollByVisibleElement(SpecialOffersPage.filterButton);
        sP.clickFilterButton();
        sP.chooseBodyStyle(0);
        sP.chooseModel(0);
        sP.chooseYear(0);
        sP.clearOptionsSelected();
        int expNumOptionsSelected = 0;
        int actNumOptionsSelected = sP.theSelectedOptions.size();
        Assert.assertEquals(actNumOptionsSelected, expNumOptionsSelected);
    }

    @Test
    public void testResultAfterFiltering() {
        HomePage homePage = new HomePage();
        VehiclesPage vehiclesPage = homePage.navigateToVehicles();
        SpecialOffersPage sP = vehiclesPage.navigateToSpecialOffers();
        scrollByVisibleElement(SpecialOffersPage.filterButton);
        sP.clickFilterButton();
        sP.chooseBodyStyle(0);
        sP.chooseModel(0);
        sP.chooseYear(0);
        sP.clickApplyFiltersButton();
        scrollPageUp();
        String expText = "2022 GLA 250 SUV";
        String actText = sP.resultList.get(0).getText();
        Assert.assertTrue(actText.contains(expText));
    }

    @Test(dataProviderClass = data_providers.DataProviderClass.class, dataProvider = "vehiclesType")
    public void testSelectVehicleType(String typeOfVehicle) {
        HomePage homePage = new HomePage();
        ShoppingPage shoppingPage = homePage.navigateToShopping();
        BuildVehicle buildVehicle = shoppingPage.navigateToBuildVehicle();
        switch (typeOfVehicle) {
            case "SUVs":
                buildVehicle.selectVehicleType(typeOfVehicle);
                int expListOfSUVs = 11;
                int actListOfSUVs = buildVehicle.listOfSUVs.size();
                Assert.assertEquals(actListOfSUVs, expListOfSUVs);
                break;
            case "Sedans":
                buildVehicle.selectVehicleType(typeOfVehicle);
                int expListOfSedans = 8;
                int actListOfSedans = buildVehicle.listOfSedansWagons.size();
                Assert.assertEquals(actListOfSedans, expListOfSedans);
                break;
            case "Coupes":
                buildVehicle.selectVehicleType(typeOfVehicle);
                int expListOfCoupes = 6;
                int actListOfCoupes = buildVehicle.listOfCoupes.size();
                Assert.assertEquals(actListOfCoupes, expListOfCoupes);
                break;
            case "Convertibles":
                buildVehicle.selectVehicleType(typeOfVehicle);
                int expListOfConv = 3;
                int actListOfConv = buildVehicle.listOfConvertibles.size();
                Assert.assertEquals(actListOfConv, expListOfConv);
            case "Electric":
                buildVehicle.selectVehicleType(typeOfVehicle);
                int expListOfEle = 4;
                int actListOfEle = buildVehicle.listOfElectric.size();
                Assert.assertEquals(actListOfEle, expListOfEle);
            default:
                System.out.println("Invalid type!!!");
        }
    }

    @Test(dataProviderClass = data_providers.DataProviderClass.class, dataProvider = "SUVsModel")
    public void testSelectSUVsModels(String vehicleIndex, String vehicleModelOption, String vehicleType) {
        HomePage homePage = new HomePage();
        ShoppingPage shoppingPage = homePage.navigateToShopping();
        BuildVehicle buildVehicle = shoppingPage.navigateToBuildVehicle();
        String modelNamePrice = buildVehicle
                .chooseSUVsModel(vehicleIndex, vehicleModelOption, vehicleType);
        String[] expArr = modelNamePrice.split(" ");
        String expText = expArr[0] + expArr[1] + expArr[2];
        if (isElementVisible(buildVehicle.contMyBuildButton)) {
            buildVehicle.clickContinueMyBuildButton();
            buildVehicle.clickSummaryButton();
            String actModelText = buildVehicle.summaryModelName.getText();
            String[] arrText = actModelText.split(" ");
            String actText = arrText[0] + arrText[1] + arrText[2];
            Assert.assertEquals(actText, expText);
        } else if (isElementVisible(buildVehicle.headVehicleNameSelected)) {
            String actModelText = buildVehicle.headVehicleNameSelected.getText();
            String[] arrText = actModelText.split(" ");
            String actText = arrText[1] + arrText[2] + arrText[3];
            Assert.assertTrue(expText.contains(actText));
        }

    }

    @Test(dataProviderClass = data_providers.DataProviderClass.class, dataProvider = "Sedans&WagonsModel")
    public void testSelectSedansModels(String vehicleIndex, String vehicleModelOption, String vehicleType) {
        HomePage homePage = new HomePage();
        ShoppingPage shoppingPage = homePage.navigateToShopping();
        BuildVehicle buildVehicle = shoppingPage.navigateToBuildVehicle();
        String modelNamePrice = buildVehicle
                .chooseSUVsModel(vehicleIndex, vehicleModelOption, vehicleType);
        String[] expArr = modelNamePrice.split(" ");
        String expText = expArr[0] + expArr[1] + expArr[2];
        if (isElementVisible(buildVehicle.contMyBuildButton)) {
            buildVehicle.clickContinueMyBuildButton();
            buildVehicle.clickSummaryButton();
            String actModelText = buildVehicle.summaryModelName.getText();
            String[] arrText = actModelText.split(" ");
            String actText = arrText[0] + arrText[1] + arrText[2];
            Assert.assertEquals(actText, expText);
            // Assert.assertEquals(actText, expText);
        } else if (isElementVisible(buildVehicle.headVehicleNameSelected)) {
            String actModelText = buildVehicle.headVehicleNameSelected.getText();
            String[] arrText = actModelText.split(" ");
            String actText = arrText[1] + arrText[2] + arrText[3];
            Assert.assertTrue(expText.contains(actText));
        }
    }

    @Test(dataProviderClass = data_providers.DataProviderClass.class, dataProvider = "CoupesModel")
    public void testSelectCoupesModel(String vehicleIndex, String vehicleModelOption, String vehicleType) {
        HomePage homePage = new HomePage();
        ShoppingPage shoppingPage = homePage.navigateToShopping();
        BuildVehicle buildVehicle = shoppingPage.navigateToBuildVehicle();
        String modelNamePrice = buildVehicle
                .chooseSUVsModel(vehicleIndex, vehicleModelOption, vehicleType);
        String[] expArr = modelNamePrice.split(" ");
        String expText = expArr[0] + expArr[1] + expArr[2];
        buildVehicle.clickContinueMyBuildButton();
        buildVehicle.clickSummaryButton();
        String actModelText = buildVehicle.summaryModelName.getText();
        String[] arrText = actModelText.split(" ");
        String actText = arrText[2] + arrText[3] + arrText[4];
        Assert.assertEquals(actText, expText);
    }

    @Test(priority = 2, dataProviderClass = data_providers.DataProviderClass.class, dataProvider = "ConvertiblesModel")
    public void testSelectConvertiblesModel(String vehicleIndex, String vehicleModelOption, String vehicleType) {
        HomePage homePage = new HomePage();
        ShoppingPage shoppingPage = homePage.navigateToShopping();
        BuildVehicle buildVehicle = shoppingPage.navigateToBuildVehicle();
        String modelNamePrice = buildVehicle
                .chooseSUVsModel(vehicleIndex, vehicleModelOption, vehicleType);
        String[] expArr = modelNamePrice.split(" ");
        String expText = expArr[0] + expArr[1] + expArr[2];
        if (isElementVisible(buildVehicle.contMyBuildButton)) {
            buildVehicle.clickContinueMyBuildButton();
            buildVehicle.clickSummaryButton();
            String actModelText = buildVehicle.summaryModelName.getText();
            String[] arrText = actModelText.split(" ");
            String actText = arrText[2] + arrText[3] + arrText[4];
            Assert.assertEquals(actText, expText);
        } else if (isElementVisible(buildVehicle.headVehicleNameSelected)) {
            String actModelText = buildVehicle.headVehicleNameSelected.getText();
            String[] arrText = actModelText.split(" ");
            String actText = arrText[1] + arrText[2] + arrText[3];
            Assert.assertTrue(expText.contains(actText));
        }
    }

    @Test(priority = 2,dataProviderClass = data_providers.DataProviderClass.class,dataProvider = "ElectricModel")
    public void testSelectElectricModels(String vehicleIndex, String vehicleModelOption, String vehicleType){
        HomePage homePage = new HomePage();
        ShoppingPage shoppingPage = homePage.navigateToShopping();
        BuildVehicle buildVehicle = shoppingPage.navigateToBuildVehicle();
        String modelNamePrice = buildVehicle
                .chooseSUVsModel(vehicleIndex, vehicleModelOption, vehicleType);
        String[] expArr = modelNamePrice.split(" ");
        String expText = expArr[0] + expArr[1] + expArr[2];
        String actModelText = buildVehicle.headVehicleNameSelected.getText();
        String[] arrText = actModelText.split(" ");
        String actText = arrText[1] + arrText[2] + arrText[3];
        Assert.assertTrue(expText.contains(actText));
    }


}
