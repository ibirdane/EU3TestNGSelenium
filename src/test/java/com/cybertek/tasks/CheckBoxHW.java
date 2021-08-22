package com.cybertek.tasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBoxHW {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
       driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void test1(){

        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        WebElement cb = driver.findElement(By.xpath("//div[@id='txtAge']"));
        System.out.println("cb.isDisplayed() = "+cb.isDisplayed());
        Assert.assertFalse(cb.isDisplayed(),"verify that the checkbox is not displayed");

        WebElement checkb = driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkb.click();
        Assert.assertTrue(cb.isDisplayed(),"verify that the checkbox is displayed");
        System.out.println("cb.isDisplayed() = "+ cb.isDisplayed());

    }

    @Test
    public void test2(){
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        WebElement call = driver.findElement(By.xpath("//input[@id='check1']"));
        String expected = "Check All";
        String actual = call.getText();
        //Assert.assertEquals(actual,expected,"verify that checkboxes are same");

        //call.click();
        WebElement ch1= driver.findElement(By.xpath("//*[text()='Option 1']"));
        ch1.click();
        WebElement ch2 = driver.findElement(By.xpath("//*[text()='Option 2']"));
        WebElement ch3 = driver.findElement(By.xpath("//*[text()='Option 3']"));
        WebElement ch4 = driver.findElement(By.xpath("//*[text()='Option 4']"));

       Assert.assertTrue(ch1.isSelected(),"verify that ch1 is selected");
        Assert.assertTrue(ch2.isSelected(),"verify that ch2 is selected");
        Assert.assertTrue(ch3.isSelected(),"verify that ch3 is selected");
        Assert.assertTrue(ch4.isSelected(),"verify that ch4 is selected");



        WebElement unchecked = driver.findElement(By.id("check1"));
        String actual1 = unchecked.getText();
        String exp = "Uncheck All";
        Assert.assertEquals(actual, exp, "verify that checkboxes are same");

    }



}
