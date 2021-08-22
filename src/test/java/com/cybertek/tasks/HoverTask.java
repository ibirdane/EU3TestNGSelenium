package com.cybertek.tasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HoverTask {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();

    }
    @Test
    public void test1() throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.get("http://practice.cybertekschool.com/hovers");
        WebElement img1 = driver.findElement(By.tagName("img"));
        Thread.sleep(2000);
        actions.moveToElement(img1).perform();
        WebElement s1 = driver.findElement(By.tagName("h5"));

        Assert.assertTrue(s1.isDisplayed());
    }
    /*
    * hover over each image in the website
    * verify each name : user text is displayed*/

    @Test
    public void test2() throws InterruptedException {


        driver.get("http://practice.cybertekschool.com/hovers");
        Actions action = new Actions(driver);

        for (int i = 1; i <= 3; i++) {
            String xpathImg = "(//img)["+i+"]";
             WebElement img = driver.findElement(By.xpath(xpathImg));
            System.out.println(xpathImg);

             Thread.sleep(2000);
             action.moveToElement(img).perform();

             String textXpath = "//h5[.='name: user"+i+"']";
             WebElement text1 = driver.findElement(By.xpath(textXpath));
            System.out.println(textXpath);
            Assert.assertTrue(text1.isDisplayed());



        }

    }
}
