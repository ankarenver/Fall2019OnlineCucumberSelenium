package com.vytrack.pages;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPageBase {

    @FindBy(id = "prependedInput")
    private WebElement username;

    @FindBy(id = "prependedInput2")
    private WebElement password;

    @FindBy(id = "_submit")
    private WebElement login;

    @FindBy(linkText = "Forgot your password?")
    private WebElement forgetPassword;

    @FindBy(css = "[class='alert alert-error']")
    private WebElement warningMessage;


    /**
     * method to login, version #1
     * login as a specific user
     * @param username
     * @param password
     */
    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password, Keys.ENTER);
    }

    /**
     * method to login version #2
     * login as a default user
     * Credentials will be retrieved from configuration.properties file
     */
    public void login(){
        this.username.sendKeys(ConfigurationReader.getProperty("store_manager"));
        this.password.sendKeys(ConfigurationReader.getProperty("password"),Keys.ENTER);
    }

    /**
     * this method stands for login based on user type
     * For example: if parameter is equals to driver, user will login as a driver
     * If role parameter is not correct, method will throw exception
     * @param userType  driver, sales manager or store manager
     */
    public void login(String userType){
        String userName="";
        if (userType.equalsIgnoreCase("driver")){
            userName="user15";
        }else if (userType.equalsIgnoreCase("sales manager")){
            userName="salesmanager110";
        }else if (userType.equalsIgnoreCase("store manager")){
            userName="storemanager85";
        }else {
            throw new RuntimeException("invalid user type");
        }
        System.out.println("Login as " + userType);
        login(userName,"UserUser123");
    }

    public String getWarningMessageText(){
        return warningMessage.getText();
    }








}
