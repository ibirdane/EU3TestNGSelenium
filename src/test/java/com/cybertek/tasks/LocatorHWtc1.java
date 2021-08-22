package com.cybertek.tasks;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorHWtc1 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.ebay.com/");

        WebElement si = driver.findElement(By.name("_nkw"));
        si.sendKeys("iPhone");

        WebElement SB = driver.findElement(By.id("gh-btn"));
        SB.click();

        WebElement result = driver.findElement(By.xpath("//*[contains(text(),'results for')]"));

        String resultString= result.getText();

        System.out.println(resultString.substring(0, resultString.indexOf(" results")));

        driver.quit();





    }




}
