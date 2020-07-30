package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumTest{

    public static void main(String[] args) throws InterruptedException {
        //start the driver, open chrome to our target url
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/animal");

        //find the fields we want by id and fill them in
        //the fields don’t clear on submit for our simple app, so just submit it 5 times
        for(int i = 0; i < 5; i++) {
            WebElement inputField = driver.findElement(By.id("animalText"));
            inputField.sendKeys("Manatee");

            WebElement inputField2 = driver.findElement(By.id("adjective"));
            inputField2.sendKeys("Whirling");

            inputField.submit();
        }

        // then get the element by the class conclusionMessage and print it
        WebElement conclusionResult = driver.findElement(By.className("conclusionMessage"));
        System.out.println("conclusionResult.getText() = " + conclusionResult.getText());

        Thread.sleep(5000);
        driver.quit();
    }
}

/*public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/animal");
        WebElement animalname = driver.findElement(By.id("animalText"));
        animalname.sendKeys("cat");
        animalname = driver.findElement(By.id("adjective"));
        animalname.sendKeys("meow");
        for (int i=0;i<=3;i++){
            animalname.submit();
            //driver.findElement(By.xpath("//input[@name='adjective']")).submit();
            System.out.println("submitted "+i);
        }
        List<WebElement> results = driver.findElements(By.className("conclusionMessage"));
        System.out.println("results "+results);
        for (WebElement element : results) {
            String link = element.getText();
            System.out.println(link);
        }
        Thread.sleep(5000);
        driver.quit();
    }
}
*/

/*
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        WebElement inputField = driver.findElement(By.name("q"));
        inputField.sendKeys("selenium");
        inputField.submit();
        List<WebElement> results = driver.findElements(By.cssSelector("div.g a"));
        for (WebElement element : results) {
            String link = element.getAttribute("href");
            System.out.println(link);
        }
        Thread.sleep(5000);
        driver.quit();
* */