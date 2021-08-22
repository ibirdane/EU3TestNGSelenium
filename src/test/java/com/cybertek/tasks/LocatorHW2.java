package com.cybertek.tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorHW2 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement home = driver.findElement(By.xpath("//a[@class='nav-link']"));
        String hm = home.getText();
        System.out.println(hm);

        WebElement fP = driver.findElement(By.xpath("//h2[contains(text(),'Forgot Password')]"));
        String forPas = fP.getText();
        System.out.println(forPas);

        WebElement eMail = driver.findElement(By.xpath("//label[@for='email']"));
        String mail = eMail.getText();
        System.out.println(mail);

        WebElement mailInput = driver.findElement(By.xpath("//input[@name='email']"));
        mailInput.sendKeys("cybertek@gmail.com");

        WebElement reP = driver.findElement(By.xpath("//button[@id='form_submit']"));
        String rp = reP.getText();
        System.out.println(rp);
    }
}
