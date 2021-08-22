package com.cybertek.liveSessions;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class xPathCss_6_12_21 {
    @Test
    public void test1(){
        //write a locator for etst.com based on the text vaeiable,
        //locator will dynamically change.
        String text ="Clothing & Shoes";

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.etsy.com");

        String xPathText = "//ul[@data-ui='top-nav-category-list']//span[contains(text(),"+text+"')]";
        System.out.println(xPathText);
        WebElement homeLivingLink = driver.findElement(By.xpath(xPathText));

    }
}
