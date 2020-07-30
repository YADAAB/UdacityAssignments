package com.udacity.jwdnd.whisperdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
    @FindBy(id = "inputUsername")
    private WebElement username;

    @FindBy(id = "inputPassword")
    private WebElement password;

    @FindBy(id = "inputFirstName")
    private WebElement firstname;

    @FindBy(id = "inputLastName")
    private WebElement lastname;

    @FindBy(id = "submit-button")
    private WebElement submitbutton;

    public void postUserDetails(String username, String password, String firstname, String lastname)
    {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.firstname.sendKeys(firstname);
        this.lastname.sendKeys(lastname);
        this.submitbutton.click();
    }

    public SignupPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
