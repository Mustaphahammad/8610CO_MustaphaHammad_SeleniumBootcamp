package page_library;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainNavigation extends BasePage {

    @FindBy(xpath = "//a[@href='/calendar']")
    public WebElement calendarNavButton;


    public MainNavigation() {
        PageFactory.initElements(driver, this);
    }

    public CalendarPage navigateToCalendarPage() {
        isElementVisible(calendarNavButton);
        clickOnElement(calendarNavButton);
        return new CalendarPage();
    }


}
