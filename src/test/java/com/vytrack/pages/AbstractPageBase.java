package com.vytrack.pages;


import com.vytrack.utilities.BrowserUtilities;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * this class will be extended page classes
 * any common WebElement/locators can be stored here
 * since navigation menu does not belong to particular page
 * we can not really create a dedicated page class to store
 * elements from that menu
 */
public abstract class AbstractPageBase {
    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver,15);

    @FindBy(css = "#user-menu > a")
    protected WebElement currentUser;

    @FindBy(css = "[class='btn-group pull-right'] > button")
    private WebElement saveAndCloseBtn;


    public AbstractPageBase(){
        PageFactory.initElements(driver,this);
    }

    public void clickSaveAndClose(){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(saveAndCloseBtn)).click();
        BrowserUtilities.waitForPageToLoad(20);
//        BrowserUtilities.clickWithJS(saveAndCloseBtn);
        // or we can use
//        saveAndCloseBtn.click();
    }

    public String getCurrentUserName(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(currentUser));
        return currentUser.getText().trim();
    }

    /**
     * Method for vytrack navigation. Provide tab name and module name to navigate
     * @param tabName like Dashboards, Fleet or Customers
     * @param moduleName like Vehicles, Vehicles Odometer and Vehicle Costs
     */
    public void navigateTo(String tabName, String moduleName){
        String tabNameXpath = "//span[@class='title title-level-1' and contains(text(),'"+tabName+"')]";
        String moduleNameXpath ="//span[@class='title title-level-2' and text() = '"+moduleName+"']";
        WebElement tabElements = driver.findElement(By.xpath(tabNameXpath));
        WebElement moduleElement = driver.findElement(By.xpath(moduleNameXpath));
        Actions actions = new Actions(driver);
        BrowserUtilities.wait(3);
        actions.moveToElement(tabElements).pause(2000).click(moduleElement).build().perform();
        BrowserUtilities.wait(4);


    }


}
