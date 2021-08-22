package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {

    public static void main(String[] args) {

        //Task open chrome and navigate to http://practice.cybertekschool.com

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com");

        //getting title with selenium

        System.out.println(driver.getTitle());

        //shortcut for creatint Variable
        //Option or ALT + enter enter
        //getTitle() --> get you the titel of the page

        String title = driver.getTitle();

        System.out.println("title = "+ title);

        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);


        System.out.println("currentUrl = "+ currentUrl);

        //getPageSource() --> gets the source of the page

        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);

    }
}
