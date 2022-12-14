package page_libray;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePage {


    @FindBy(xpath = "//button[@class ='nav-profile__login nav-profile__button button button_primary button--wide ']")
    public WebElement loginButton;


    public MyAccountPage() {
        PageFactory.initElements(driver, this);
    }

    public LoginPage navigateToLoginPage() {
        clickOnElement(loginButton);
        return new LoginPage();
    }

}
