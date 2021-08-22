package com.cybertek.tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorHWtc3 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.wikipedia.org/");

        WebElement search = driver.findElement(By.id("searchInput"));

        search.sendKeys("selenium webdriver");

        WebElement search2 = driver.findElement(By.cssSelector("i.sprite.svg-search-icon"));

        search2.click();

        WebElement selSoft = driver.findElement(By.xpath("//*[contains(text(),' (software)')]"));

        selSoft.click();

        String url = driver.getCurrentUrl();
        if(url.endsWith("Selenium_(software)")){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAIL");
        }

        driver.quit();
    }
}
