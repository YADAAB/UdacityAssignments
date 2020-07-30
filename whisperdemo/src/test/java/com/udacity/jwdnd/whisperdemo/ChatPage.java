package com.udacity.jwdnd.whisperdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatPage {
    @FindBy(id = "messageText")
    private WebElement messagetext;

    @FindBy(id = "messageType")
    private WebElement messagetype;

    @FindBy(id = "submit-button")
    private WebElement submitbutton;

    @FindBy(id="chatMessage")
    private WebElement chatmessage;

    public void postChat(String message, String mtype)
    {
        this.messagetext.sendKeys(message);
        this.messagetype.sendKeys(mtype);
        this.submitbutton.click();
    }

    public ChatPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getFirstMessage(){
        System.out.println("chatmessage "+ this.chatmessage.getText());
        return this.chatmessage.getText();
    }

}
