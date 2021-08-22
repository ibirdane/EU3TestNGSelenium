package com.cybertek.tests.day8_types_of_elemets_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void test1(){

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //save our web elements inside the list
        List<WebElement> button = driver.findElements(By.tagName("button"));

        System.out.println("buttons.size() = "+ button.size());
        //verify button size
        Assert.assertEquals(button.size(), 6, "verify buttons size");

        //iter + enter to get each loop with shortcut
        for (WebElement webElement : button) {
            System.out.println(webElement.getText());
            Assert.assertTrue(webElement.isDisplayed(), "verify buttons are displayed");
        }

        //click second button
        button.get(1).click();
    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        driver.findElements(By.tagName("buttonaiysdgausda"));
        List<WebElement> buttons = driver.findElements(By.tagName("buttonaiysdgausda"));
        buttons.size();

    }
}
