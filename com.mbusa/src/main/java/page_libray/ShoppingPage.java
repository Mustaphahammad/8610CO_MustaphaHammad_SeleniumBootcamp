package page_libray;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingPage extends BasePage {

    @FindBy(xpath = "//ul/li[@class ='nav-link-group__link']/a[contains(text(),'Build Your Own')]")
    public WebElement buildYourOwnButton;


    public ShoppingPage() {
        PageFactory.initElements(driver, this);
    }

    public BuildVehicle navigateToBuildVehicle() {
        clickOnElement(buildYourOwnButton);
        return new BuildVehicle();
    }
}
