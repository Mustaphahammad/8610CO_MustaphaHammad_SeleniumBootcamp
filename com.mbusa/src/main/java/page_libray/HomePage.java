package page_libray;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@aria-label = 'primary-menu']/li[1]/button")
    public WebElement vehiclesButton;

    @FindBy(xpath = "//*[@aria-label = 'primary-menu']/li[2]/button")
    public WebElement shoppingButton;

    @FindBy(xpath = "//*[@aria-label = 'secondary-menu']/li[1]/button")
    public WebElement myAccountButton;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public VehiclesPage navigateToVehicles() {
        clickOnElement(vehiclesButton);
        return new VehiclesPage();
    }

    public ShoppingPage navigateToShopping(){
        clickOnElement(shoppingButton);
        return new ShoppingPage();
    }

    public MyAccountPage clickMyAccountButton(){
        clickOnElement(myAccountButton);
        return new MyAccountPage();
    }

}
