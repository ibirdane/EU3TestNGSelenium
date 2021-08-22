package com.cybertek.tests.day8_types_of_elemets_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropdownTest {
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
    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/dropdown");
        //1. locate your dropdown just like any other webelement with unique locator
        WebElement dropdownElement = driver.findElement(By.id("state"));

        //2.create Select object by passing that element as a constructor
        Select stateDropdown = new Select(dropdownElement);

        //Verify that first selection is a Select a state
        String expectedOption = "Select a State";
        String actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"verify first selection");

        //How to select options from dropdown ?
        //1. Select using visible text
        Thread.sleep(2000);
        stateDropdown.selectByVisibleText("Virginia");

        expectedOption ="Virginia";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption, "verify first selection");

        //2. Select Using Index
        Thread.sleep(2000);
        stateDropdown.selectByIndex(51);

        expectedOption = "Wyoming";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption,actualOption, "verify first selection" );

        //3.Select By Value
        Thread.sleep(2000);
        stateDropdown.selectByValue("TX");

        expectedOption="Texas";
        actualOption=stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"Verify first selection");






        //getOptions --> returns all the available options from the dropdown
        List<WebElement> options = stateDropdown.getOptions();
        //print size of the options
        System.out.println(options.size());

        //print options one by one
        for (WebElement option : options) {
            System.out.println(option.getText());
        }






    }
}
