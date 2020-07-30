package com.udacity.jwdnd.whisperdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id = "inputUsername")
    private WebElement username;

    @FindBy(id = "inputPassword")
    private WebElement password;

    @FindBy(id = "submit-button")
    private WebElement submitbutton;

    public void postUserCreds(String username, String password)
    {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.submitbutton.click();
        System.out.println("Login Creds Posted..");
    }

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
