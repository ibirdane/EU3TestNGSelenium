package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class amazonTest {

    /*Task
    * go to amazon.com
    * search for selenium
    * click search button
    * verify 1-48 of 304 results for "selenium" */

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://amazon.com");

        WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        search.sendKeys("selenium");

       driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

       WebElement result = driver.findElement(By.xpath("//span[contains(text(),'results for')]"));

       String resultText = result.getText();

        System.out.println("resultText = " +resultText);




    }
}
