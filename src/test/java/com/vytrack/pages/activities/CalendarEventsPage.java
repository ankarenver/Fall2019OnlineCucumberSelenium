package com.vytrack.pages.activities;


import com.vytrack.pages.AbstractPageBase;
import com.vytrack.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CalendarEventsPage extends AbstractPageBase {

    @FindBy(css = "[title='Create Calendar event']")
    private WebElement createCalendarEvent;

    @FindBy(className = "select2-chosen")
    private WebElement owner;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    private WebElement startDate;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_start']")
    private WebElement startDateTime;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_end']")
    private WebElement endDateTime;

    @FindBy(className = "grid-header-cell__label")
    private List<WebElement> columnNames;

    @FindBy(css = "[id^='oro_calendar_event_form_title-uid']")
    private WebElement title;

    @FindBy(css = "iframe[id^='oro_calendar_event_form_description-uid']")
    private WebElement descriptionFrame;

    @FindBy(id = "tinymce")
    private WebElement descriptionTextArea;

    @FindBy(css = "[class='btn-group pull-right'] > button")
    private WebElement saveAndCloseBtn;

    @FindBy(xpath = "(//div[@class='control-label'])[1]")
    private WebElement generalInfoTitle;

    @FindBy(xpath = "//label[text()='Description']/following-sibling::div//div")
    private WebElement generalInfoDescription;



    public String getOwnerName(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("select2-chosen")));
        wait.until(ExpectedConditions.visibilityOf(owner));
        return owner.getText().trim();
    }

    public void clickToCreateCalendarEvent(){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[title='Create Calendar event']")));
        wait.until(ExpectedConditions.elementToBeClickable(createCalendarEvent)).click();
        BrowserUtilities.waitForPageToLoad(20);

    }

    public String getStartDate(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(startDate));
        return startDate.getAttribute("value");
    }

    public String getStartDateTime(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(startDateTime));
        return startDateTime.getAttribute("value").trim();
    }

    public String getEndDateTime(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(endDateTime));
        return endDateTime.getAttribute("value").trim();
    }

    public List<String> getColumnNames(){
        BrowserUtilities.waitForPageToLoad(20);
        return BrowserUtilities.getTextFromWebElement(columnNames);
    }

    public void enterTitle(String title){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(this.title)).sendKeys(title);
        BrowserUtilities.wait(2);
    }

    public void enterDescription(String description){
        // wait until frame is  available and switch to it
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(descriptionFrame));
        descriptionTextArea.sendKeys(description);
        driver.switchTo().defaultContent();  // exit from the frame

    }

    public void clickSaveAndClose(){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(saveAndCloseBtn)).click();
        BrowserUtilities.waitForPageToLoad(20);
//        BrowserUtilities.clickWithJS(saveAndCloseBtn);
        // or we can use
//        saveAndCloseBtn.click();
    }

    public String getGeneralInfoTitle(){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='control-label'])[1]")));
        return generalInfoTitle.getText();
    }
    public String getGeneralInfoDescription(){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Description']/following-sibling::div//div")));
        return generalInfoDescription.getText();
    }
}
