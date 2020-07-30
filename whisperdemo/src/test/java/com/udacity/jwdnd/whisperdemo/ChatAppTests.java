package com.udacity.jwdnd.whisperdemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ChatAppTests {

    @LocalServerPort
    private Integer port;

    private static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }

    @Test
    public void testUserSignupLoginAndSubmitMessage() {
        String username = "ab";
        String password = "ab";
        String messageText = "Hello!";
        String baseURL = "http://localhost:8080";
        driver.get(baseURL+"/signup");

        SignupPage signupPage = new SignupPage(driver);
        signupPage.postUserDetails("Peter", "Zastoupil", username, password);

        driver.get(baseURL + "/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.postUserCreds(username, password);
        System.out.println("Login Done..");

        driver.get(baseURL + "/chat");

        ChatPage chatpage = new ChatPage(driver);
        chatpage.postChat("Barry Allen", "say");
        assertEquals("Barry Allen", chatpage.getFirstMessage());



    }
}
