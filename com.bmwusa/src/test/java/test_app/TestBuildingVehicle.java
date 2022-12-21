package test_app;

import base.BasePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_library.BuildVehicle;
import page_library.HomePage;
import page_library.ModelsSubPages;

public class TestBuildingVehicle extends BasePage {
    @Test(dataProviderClass = data_providers.DataProviderClass.class, dataProvider = "AllModelsDesign")
    public void testSelectingDesignFromAllModels(String model, String num, String vehicle, String section, String designIndex) {
        HomePage homePage = new HomePage();
        ModelsSubPages modelsPage = homePage.navigateToModelsPage();
        modelsPage.selectModel(model);
        modelsPage.selectVehicle(num, vehicle);
        BuildVehicle buildVehicle = modelsPage.navigateToBuildYourOwnPage();
        buildVehicle.customizeVehicle(section);
        String expText = buildVehicle.selectDesign(designIndex);
        buildVehicle.customizeVehicle("Summary");
        String actText = buildVehicle.verifyBuild(1);
        Assert.assertTrue(actText.contains(expText));
    }

    @Test(dataProviderClass = data_providers.DataProviderClass.class, dataProvider = "AllModelsExterior")
    public void testSelectingExteriorColorFromAllModels(String model, String num, String vehicle, String section, String colorIndex) {
        HomePage homePage = new HomePage();
        ModelsSubPages modelsPage = homePage.navigateToModelsPage();
        modelsPage.selectModel(model);
        modelsPage.selectVehicle(num, vehicle);
        BuildVehicle buildVehicle = modelsPage.navigateToBuildYourOwnPage();
        buildVehicle.customizeVehicle(section);
        String expText = buildVehicle.selectExteriorColor(colorIndex);
        buildVehicle.customizeVehicle("Summary");
        String actText = buildVehicle.verifyBuild(2);
        Assert.assertTrue(actText.contains(expText));
    }

    @Test(dataProviderClass = data_providers.DataProviderClass.class, dataProvider = "AllModelsExterior")
    public void testSelectingExteriorWheelsFromAllModels(String model, String num, String vehicle, String section, String wheelIndex){
        HomePage homePage = new HomePage();
        ModelsSubPages modelsPage = homePage.navigateToModelsPage();
        modelsPage.selectModel(model);
        modelsPage.selectVehicle(num, vehicle);
        BuildVehicle buildVehicle = modelsPage.navigateToBuildYourOwnPage();
        buildVehicle.customizeVehicle(section);
        String expText = buildVehicle.selectExteriorWheelsType(wheelIndex);
        buildVehicle.customizeVehicle("Summary");
        String actText = buildVehicle.verifyBuild(3);
        Assert.assertTrue(actText.contains(expText));
    }

    @Test(dataProviderClass = data_providers.DataProviderClass.class,dataProvider = "AllModelsInterior")
    public void testSelectInteriorUpholsteryFromAllModels(String model, String num, String vehicle, String section, String intColIndex){
        HomePage homePage = new HomePage();
        ModelsSubPages modelsPage = homePage.navigateToModelsPage();
        modelsPage.selectModel(model);
        modelsPage.selectVehicle(num, vehicle);
        BuildVehicle buildVehicle = modelsPage.navigateToBuildYourOwnPage();
        buildVehicle.customizeVehicle(section);
        String expText = buildVehicle.customizeInterior(intColIndex,false);
        buildVehicle.customizeVehicle("Summary");
        String actText = buildVehicle.verifyBuild(4);
        Assert.assertTrue(actText.contains(expText));
    }
    @Test(dataProviderClass = data_providers.DataProviderClass.class,dataProvider = "AllModelsInterior")
    public void testSelectInteriorTrimFromAllModels(String model, String num, String vehicle, String section, String intTrimIndex){
        HomePage homePage = new HomePage();
        ModelsSubPages modelsPage = homePage.navigateToModelsPage();
        modelsPage.selectModel(model);
        modelsPage.selectVehicle(num, vehicle);
        BuildVehicle buildVehicle = modelsPage.navigateToBuildYourOwnPage();
        buildVehicle.customizeVehicle(section);
        String expText = buildVehicle.customizeInterior(intTrimIndex,true);
        buildVehicle.customizeVehicle("Summary");
        String actText = buildVehicle.verifyBuild(5);
        Assert.assertTrue(actText.contains(expText));
    }

    @Test(dataProviderClass = data_providers.DataProviderClass.class,dataProvider = "AllModelsOptions")
    public void testSelectFeaturedPackagesFromAllModels(String model, String num, String vehicle, String section) {
        HomePage homePage = new HomePage();
        ModelsSubPages modelsPage = homePage.navigateToModelsPage();
        modelsPage.selectModel(model);
        modelsPage.selectVehicle(num, vehicle);
        BuildVehicle buildVehicle = modelsPage.navigateToBuildYourOwnPage();
        buildVehicle.customizeVehicle(section);
        buildVehicle.selectFeaturedPackageToBuild();
        String expText = "Remove from build";
        fluentWait.until(ExpectedConditions.visibilityOf(buildVehicle.premiumRemoveFromBuildButton));
        String actText = buildVehicle.premiumRemoveFromBuildButton.getText().trim();
        Assert.assertEquals(actText, expText);
    }

    @Test(dataProviderClass = data_providers.DataProviderClass.class,dataProvider = "AllModelsOptions")
    public void testRemoveFeaturedPackagesFromAllModels(String model, String num, String vehicle, String section){
        HomePage homePage = new HomePage();
        ModelsSubPages modelsPage = homePage.navigateToModelsPage();
        modelsPage.selectModel(model);
        modelsPage.selectVehicle(num, vehicle);
        BuildVehicle buildVehicle = modelsPage.navigateToBuildYourOwnPage();
        buildVehicle.customizeVehicle(section);
        buildVehicle.selectFeaturedPackageToBuild();
        buildVehicle.removeFeaturedPackageFromBuild();
        clickOnElement(buildVehicle.premiumSeeALlFeaturesButton);
        String actText = buildVehicle.premiumAddToBuildButton.getText().trim();
        Assert.assertEquals(actText,"Add to build");
    }

    @Test(dataProviderClass = data_providers.DataProviderClass.class,dataProvider = "SAVsDesign")
    public void testSelectingDesignFromSAVs(String model, String num, String vehicle, String section, String designIndex) {
        HomePage homePage = new HomePage();
        ModelsSubPages modelsPage = homePage.navigateToModelsPage();
        modelsPage.selectModel(model);
        modelsPage.selectVehicle(num, vehicle);
        BuildVehicle buildVehicle = modelsPage.navigateToBuildYourOwnPage();
        buildVehicle.customizeVehicle(section);
        String expText = buildVehicle.selectDesign(designIndex);
        buildVehicle.customizeVehicle("Summary");
        String actText = buildVehicle.verifyBuild(1);
        Assert.assertTrue(actText.contains(expText));
    }

    @Test(dataProviderClass = data_providers.DataProviderClass.class, dataProvider = "SAVsExterior")
    public void testSelectingExteriorColorFromSAVs(String model, String num, String vehicle, String section, String colorIndex) {
        HomePage homePage = new HomePage();
        ModelsSubPages modelsPage = homePage.navigateToModelsPage();
        modelsPage.selectModel(model);
        modelsPage.selectVehicle(num, vehicle);
        BuildVehicle buildVehicle = modelsPage.navigateToBuildYourOwnPage();
        buildVehicle.customizeVehicle(section);
        String expText = buildVehicle.selectExteriorColor(colorIndex);
        buildVehicle.customizeVehicle("Summary");
        String actText = buildVehicle.verifyBuild(2);
        Assert.assertTrue(actText.contains(expText));
    }

    @Test(dataProviderClass = data_providers.DataProviderClass.class, dataProvider = "SAVsExterior")
    public void testSelectingExteriorWheelsFromSAVs(String model, String num, String vehicle, String section, String wheelIndex){
        HomePage homePage = new HomePage();
        ModelsSubPages modelsPage = homePage.navigateToModelsPage();
        modelsPage.selectModel(model);
        modelsPage.selectVehicle(num, vehicle);
        BuildVehicle buildVehicle = modelsPage.navigateToBuildYourOwnPage();
        buildVehicle.customizeVehicle(section);
        String expText = buildVehicle.selectExteriorWheelsType(wheelIndex);
        buildVehicle.customizeVehicle("Summary");
        String actText = buildVehicle.verifyBuild(3);
        Assert.assertTrue(actText.contains(expText));
    }

    @Test(dataProviderClass = data_providers.DataProviderClass.class,dataProvider = "SAVsInterior")
    public void testSelectInteriorUpholsteryFromSAVs(String model, String num, String vehicle, String section, String intColIndex){
        HomePage homePage = new HomePage();
        ModelsSubPages modelsPage = homePage.navigateToModelsPage();
        modelsPage.selectModel(model);
        modelsPage.selectVehicle(num, vehicle);
        BuildVehicle buildVehicle = modelsPage.navigateToBuildYourOwnPage();
        buildVehicle.customizeVehicle(section);
        String expText = buildVehicle.customizeInterior(intColIndex,false);
        buildVehicle.customizeVehicle("Summary");
        String actText = buildVehicle.verifyBuild(4);
        Assert.assertTrue(actText.contains(expText));
    }

    @Test(dataProviderClass = data_providers.DataProviderClass.class,dataProvider = "SAVsInterior")
    public void testSelectInteriorTrimFromSAVs(String model, String num, String vehicle, String section, String intTrimIndex){
        HomePage homePage = new HomePage();
        ModelsSubPages modelsPage = homePage.navigateToModelsPage();
        modelsPage.selectModel(model);
        modelsPage.selectVehicle(num, vehicle);
        BuildVehicle buildVehicle = modelsPage.navigateToBuildYourOwnPage();
        buildVehicle.customizeVehicle(section);
        String expText = buildVehicle.customizeInterior(intTrimIndex,true);
        buildVehicle.customizeVehicle("Summary");
        String actText = buildVehicle.verifyBuild(5);
        Assert.assertTrue(actText.contains(expText));
    }

    @Test(dataProviderClass = data_providers.DataProviderClass.class,dataProvider = "SAVsOptions")
    public void testSelectFeaturedPackagesFromSAVs(String model, String num, String vehicle, String section) {
        HomePage homePage = new HomePage();
        ModelsSubPages modelsPage = homePage.navigateToModelsPage();
        modelsPage.selectModel(model);
        modelsPage.selectVehicle(num, vehicle);
        BuildVehicle buildVehicle = modelsPage.navigateToBuildYourOwnPage();
        buildVehicle.customizeVehicle(section);
        buildVehicle.selectFeaturedPackageToBuild();
        String expText = "Remove from build";
        fluentWait.until(ExpectedConditions.visibilityOf(buildVehicle.premiumRemoveFromBuildButton));
        String actText = buildVehicle.premiumRemoveFromBuildButton.getText().trim();
        Assert.assertEquals(actText, expText);
    }

    @Test(dataProviderClass = data_providers.DataProviderClass.class,dataProvider = "SAVsOptions")
    public void testRemoveFeaturedPackagesFromSAVs(String model, String num, String vehicle, String section){
        HomePage homePage = new HomePage();
        ModelsSubPages modelsPage = homePage.navigateToModelsPage();
        modelsPage.selectModel(model);
        modelsPage.selectVehicle(num, vehicle);
        BuildVehicle buildVehicle = modelsPage.navigateToBuildYourOwnPage();
        buildVehicle.customizeVehicle(section);
        buildVehicle.selectFeaturedPackageToBuild();
        clickOnElement(buildVehicle.premiumRemoveFromBuildButton);
        fluentWait.until(ExpectedConditions.visibilityOf(buildVehicle.premiumAddToBuildButton));
        String expText = "Add to build";
        String actText = buildVehicle.premiumAddToBuildButton.getText().trim();
        Assert.assertEquals(actText,expText);
    }

    @Test(dataProviderClass = data_providers.DataProviderClass.class,dataProvider = "SedansDesign")
    public void testSelectingDesignFromSedans(String model, String num, String vehicle, String section, String designIndex) {
        HomePage homePage = new HomePage();
        ModelsSubPages modelsPage = homePage.navigateToModelsPage();
        modelsPage.selectModel(model);
        modelsPage.selectVehicle(num, vehicle);
        BuildVehicle buildVehicle = modelsPage.navigateToBuildYourOwnPage();
        buildVehicle.customizeVehicle(section);
        String expText = buildVehicle.selectDesign(designIndex);
        buildVehicle.customizeVehicle("Summary");
        String actText = buildVehicle.verifyBuild(1);
        Assert.assertTrue(actText.contains(expText));
    }

    @Test(dataProviderClass = data_providers.DataProviderClass.class, dataProvider = "SedansExterior")
    public void testSelectingExteriorColorFromSedans(String model, String num, String vehicle, String section, String colorIndex) {
        HomePage homePage = new HomePage();
        ModelsSubPages modelsPage = homePage.navigateToModelsPage();
        modelsPage.selectModel(model);
        modelsPage.selectVehicle(num, vehicle);
        BuildVehicle buildVehicle = modelsPage.navigateToBuildYourOwnPage();
        buildVehicle.customizeVehicle(section);
        String expText = buildVehicle.selectExteriorColor(colorIndex);
        buildVehicle.customizeVehicle("Summary");
        String actText = buildVehicle.verifyBuild(2);
        Assert.assertTrue(actText.contains(expText));
    }

    @Test(dataProviderClass = data_providers.DataProviderClass.class, dataProvider = "SedansExterior")
    public void testSelectingExteriorWheelsFromSedans(String model, String num, String vehicle, String section, String wheelIndex){
        HomePage homePage = new HomePage();
        ModelsSubPages modelsPage = homePage.navigateToModelsPage();
        modelsPage.selectModel(model);
        modelsPage.selectVehicle(num, vehicle);
        BuildVehicle buildVehicle = modelsPage.navigateToBuildYourOwnPage();
        buildVehicle.customizeVehicle(section);
        String expText = buildVehicle.selectExteriorWheelsType(wheelIndex);
        buildVehicle.customizeVehicle("Summary");
        String actText = buildVehicle.verifyBuild(3);
        Assert.assertTrue(actText.contains(expText));
    }

    @Test(dataProviderClass = data_providers.DataProviderClass.class,dataProvider = "SedansInterior")
    public void testSelectInteriorUpholsteryFromSedans(String model, String num, String vehicle, String section, String intColIndex){
        HomePage homePage = new HomePage();
        ModelsSubPages modelsPage = homePage.navigateToModelsPage();
        modelsPage.selectModel(model);
        modelsPage.selectVehicle(num, vehicle);
        BuildVehicle buildVehicle = modelsPage.navigateToBuildYourOwnPage();
        buildVehicle.customizeVehicle(section);
        String expText = buildVehicle.customizeInterior(intColIndex,false);
        buildVehicle.customizeVehicle("Summary");
        String actText = buildVehicle.verifyBuild(4);
        Assert.assertTrue(actText.contains(expText));
    }

    @Test(dataProviderClass = data_providers.DataProviderClass.class,dataProvider = "SedansInterior")
    public void testSelectInteriorTrimFromSedans(String model, String num, String vehicle, String section, String intTrimIndex){
        HomePage homePage = new HomePage();
        ModelsSubPages modelsPage = homePage.navigateToModelsPage();
        modelsPage.selectModel(model);
        modelsPage.selectVehicle(num, vehicle);
        BuildVehicle buildVehicle = modelsPage.navigateToBuildYourOwnPage();
        buildVehicle.customizeVehicle(section);
        String expText = buildVehicle.customizeInterior(intTrimIndex,true);
        buildVehicle.customizeVehicle("Summary");
        String actText = buildVehicle.verifyBuild(5);
        Assert.assertTrue(actText.contains(expText));
    }

    @Test(dataProviderClass = data_providers.DataProviderClass.class,dataProvider = "SedansOptions")
    public void testSelectFeaturedPackagesFromSedans(String model, String num, String vehicle, String section) {
        HomePage homePage = new HomePage();
        ModelsSubPages modelsPage = homePage.navigateToModelsPage();
        modelsPage.selectModel(model);
        modelsPage.selectVehicle(num, vehicle);
        BuildVehicle buildVehicle = modelsPage.navigateToBuildYourOwnPage();
        buildVehicle.customizeVehicle(section);
        clickOnElement(buildVehicle.sedansFeaturedPackageButton);
        fluentWait.until(ExpectedConditions.visibilityOf(buildVehicle.premiumAddToBuildButton));
        clickOnElement(buildVehicle.premiumAddToBuildButton);
        clickOnElement(buildVehicle.confirmChangesButton);
        String expText= buildVehicle.sedansFeaturedPackageSelectedButton.getText().trim();
        buildVehicle.customizeVehicle("Summary");
        String actText = buildVehicle.verifyBuild(7);
        Assert.assertTrue(actText.contains(expText));
    }


}
