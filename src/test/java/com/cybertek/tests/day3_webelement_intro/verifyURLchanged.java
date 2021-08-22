package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLchanged {

    public static void main(String[] args) throws InterruptedException {
         /*
     Verify URL  changed

	-open chrome browser
	-go to http://practice.cybertekschool.com/forgot_password links to an external site
	-enter any email
	-click on Retrieve password
	-verify that url changed to http://practice.cybertekschool.com/email_sent
         */

        //open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //navigate to the targeted page
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //enter any email
        WebElement emailInputBox = driver.findElement(By.name("email"));

        //sendKeys() --> send keyboard action to the webElement
        emailInputBox.sendKeys("mike@smith.com");

        //click on Retrieve password

        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();
        Thread.sleep(3000);


        //verify that url changed to http://practice.cybertekschool.com/email_sent

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl="http://practice.cybertekschool.com/email_sent";
        if(actualUrl.equals(expectedUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedUrl = "+expectedUrl);
            System.out.println("actualUrl = "+actualUrl);
        }

        //close browser
        driver.quit();



    }
}
