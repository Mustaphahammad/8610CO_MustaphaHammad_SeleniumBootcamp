package page_library;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainNavigation extends BasePage {

    @FindBy(xpath = "//a[@href='/calendar']")
    public WebElement calendarNavButton;

    @FindBy(xpath = "//a[@href='/contacts']")
    public static WebElement contactsNavButton;

    @FindBy(xpath = "//div[@class = 'ui basic button floating item dropdown']")
    public WebElement settingDropDownButton;

    @FindBy(xpath = "//div[@class = 'menu transition visible']//a")
    public List<WebElement> dropDownList;


    public MainNavigation() {
        PageFactory.initElements(driver, this);
    }

    public CalendarPage navigateToCalendarPage() {
        isElementVisible(calendarNavButton);
        clickOnElement(calendarNavButton);
        return new CalendarPage();
    }

    public ContactsPage navigateToContactsPage() {
        isElementVisible(contactsNavButton);
        clickOnElement(contactsNavButton);
        return new ContactsPage();
    }

    private void clickSettingDropDown(){
        clickOnElement(settingDropDownButton);
    }

    private void selectFromDropDown(int index){
        index = index -1;
        if (index  < dropDownList.size()){
            clickOnElement(dropDownList.get(index));//list size is 05."logout at index 4"
        }else {
            System.out.println("Invalid index!!!");
        }
    }
    public void clickLogoutButton(int index){
        clickSettingDropDown();
        selectFromDropDown(index);
    }


}
