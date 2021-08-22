package com.cybertek.tests.day15_review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyCOntactInfoTest extends TestBase {

    /*Test Case
    open the chrome
    go to qa1.vytrack
    login as a sales manager
    navigate to customers ->contacts
    click on email mbrackstone9@example.com
    verify that full name is Mariam Brackstone
    verify that email is mbrackstone9@example.com
    verify that phone number is +18982323434
    */

    @Test
    public void contactDetailsTest(){

        extentLogger = report.createTest("Contact Info Verification");

        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");

        extentLogger.info("username : "+username);
        extentLogger.info("password : "+password);
        loginPage.login(username,password);
        BrowserUtils.waitFor(3);

        extentLogger.info("Navigate to --> Customers > Contacts");
        DashboardPage dashboardPage= new DashboardPage();
        dashboardPage.navigateToModule("Customers","Contacts");
        BrowserUtils.waitFor(3);

        ContactsPage contactsPage = new ContactsPage();

        extentLogger.info("Click on mbrackstone9@example.com");
        contactsPage.waitUntilLoaderScreenDisappear();
        contactsPage.getContactEmail("mbrackstone9@example.com").click();
        ContactInfoPage contactInfoPage = new ContactInfoPage();

        String expectedFullName = "Mariam Brackstone";
        String actualFullName = contactInfoPage.fullName.getText();

        extentLogger.info("Verify full name is "+expectedFullName);
        Assert.assertEquals(actualFullName,expectedFullName,"verify fullname");
        extentLogger.info("Verify email is mbrackstone9@example.com");
        Assert.assertEquals(contactInfoPage.email.getText(),"mbrackstone9@example.com","Verify email");
        extentLogger.info("Verify phone number is +18982323434 ");
        Assert.assertEquals(contactInfoPage.phone.getText(),"+18982323434","Verify phone number");

        extentLogger.pass("PASSED");




    }


}
