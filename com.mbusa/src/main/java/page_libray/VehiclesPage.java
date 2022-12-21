package page_libray;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehiclesPage extends BasePage {

    @FindBy(xpath = "//li[@class ='global-header__vehicles-link-list-item']/a[@href='/en/special-offers']")
    public WebElement specialOffersButton;

    public VehiclesPage() {
        PageFactory.initElements(driver, this);
    }

    public SpecialOffersPage navigateToSpecialOffers() {
        clickOnElement(specialOffersButton);
        return new SpecialOffersPage();
    }

}
