package page_libray;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SpecialOffersPage extends BasePage {

    @FindBy(xpath = "//button[@class='button button_call-out vehicle-advanced-filters__toggle-cta vehicle-advanced-filters__header-cta-button']")
    public static WebElement filterButton;

    @FindBy(xpath = "//div[@class = 'tab-drawer__tabs' ]/button[1]")
    public WebElement bodyStyleClassButton;

    @FindBy(xpath = "//div[@class = 'tab-drawer__tabs' ]/button[2]")
    public WebElement modelButton;

    @FindBy(xpath = "//div[@class = 'tab-drawer__tabs' ]/button[3]")
    public WebElement yearButton;

    @FindBy(xpath = "//legend//div[@class = 'form__input filter-checkbox-control filter-checkbox-control--inline ']")
    public List<WebElement> bodyStyleList;//size = 4;

    @FindBy(xpath = "//*[@class ='vehicle-advanced-filters-tags__tag-cta']")
    public List<WebElement> theSelectedOptions;

    @FindBy(xpath = "//fieldset[1]//div[@class ='model-filter__section-content']//div[contains(@class,'form__input')]")
    public List<WebElement> modelGLASUVList;//size = 4;

    @FindBy(xpath = "//div[@class ='year-price-filter__year']//div[@class ='form__input filter-checkbox-control filter-checkbox-control--inline ']")
    public List<WebElement> yearList;//size = 2;

    @FindBy(xpath = "//button[@class = 'vehicle-advanced-filters__clear-all vehicle-advanced-filters__header-cta-button']")
    public WebElement clearAllOptionsButton;

    @FindBy(xpath = "//div[@class = 'vehicle-advanced-filters__header-ctas-wrapper']/button[1]")
    public WebElement applyFiltersButton;

    @FindBy(xpath = "//div[@class = 'offer__general']")
    public List<WebElement> resultList;


    public SpecialOffersPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickFilterButton() {
        clickOnElement(filterButton);
    }

    public void chooseBodyStyle(int index) {
        clickOnElement(bodyStyleClassButton);
        clickOnElement(bodyStyleList.get(index));
    }

    public void chooseModel(int index) {
        clickOnElement(modelButton);
        clickOnElement(modelGLASUVList.get(index));
    }

    public void chooseYear(int index) {
        clickOnElement(yearButton);
        clickOnElement(yearList.get(index));
    }

    public void clearOptionsSelected() {
        clickOnElement(clearAllOptionsButton);
    }

    public void clickApplyFiltersButton() {
        clickOnElement(applyFiltersButton);
    }


}
