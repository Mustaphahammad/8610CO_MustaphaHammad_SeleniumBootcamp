package page_library;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;

public class CalendarPage extends BasePage {

    @FindBy(xpath = "//a[@href='/calendar/new']")
    public WebElement createButton;

    @FindBy(xpath = "//div[@class='rbc-month-row']//div[@class='rbc-day-bg' or @class ='rbc-day-bg rbc-today']")
    public List<WebElement> calendarDays;

    @FindBy(xpath = "//*[@id='main-content']/div/div[2]/div/div[2]/div/div[1]/span[2]")
    public WebElement calendarToolBarLabel;

    @FindBy(xpath = "//div[@class = 'rbc-toolbar']//span [@class = 'rbc-btn-group']//button[2]/i")
    public WebElement calendarLeftButton;

    @FindBy(xpath = "//div[@class = 'rbc-toolbar']//span [@class = 'rbc-btn-group']//button[3]/i")
    public WebElement calendarRightButton;

    @FindBy(xpath = "//i[@class ='calendar icon']")
    public WebElement calendarIcon;



    public CalendarPage() {
        PageFactory.initElements(driver, this);
    }

    /* Enter number:
     1 for month
     2 for week
     3 for day
     4 for agenda*/
    private void clickCalendarMonthWeekdayButton(int number) {
        WebElement element = driver.findElement(By.xpath("//*[@id='main-content']/div/div[2]/div/div[2]/div/div[1]/span[3]/button[" + number + "]"));
        clickOnElement(element);
    }

    public EventsPage selectDateFromMonthCalendar(String month, String year, String day) {
        String desiredMonth = month + " " + year;
        while (true) {
            webDriverWait.until(ExpectedConditions.visibilityOf(calendarToolBarLabel));
            String actText = calendarToolBarLabel.getText();
            if (desiredMonth.equals(actText)) {
                break;
            } else {
                LocalDate date = LocalDate.of(Integer.parseInt(year), Month.valueOf(month.toUpperCase()), Integer.parseInt(day));
                LocalDate todayDate = LocalDate.now();
                if (date.isBefore(todayDate)) {
                    clickOnElement(calendarLeftButton);
                } else {
                    clickOnElement(calendarRightButton);
                }
            }
        }
        chooseDateFromMonthCalendar(day);
        return new EventsPage();
    }

    private void chooseDateFromMonthCalendar(String date) {
        int day = Integer.parseInt(date);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(calendarDays));
        day = day - 1;
        if (day < calendarDays.size()) {
            clickOnElement(calendarDays.get(day));
        } else {
            System.out.println("Invalid date!!!");
        }
    }

    public EventsPage clickCreateEventButton() {
        clickOnElement(createButton);
        return new EventsPage();
    }


}
