package com.cybertek.tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorHWtc2 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.ebay.com/");

        WebElement search = driver.findElement(By.id("gh-ac"));

        search.sendKeys("Selenium");

        WebElement search2 = driver.findElement(By.id("gh-btn"));

        search2.click();

        String title = driver.getTitle();

        if(title.contains("selenium")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
    }
}
