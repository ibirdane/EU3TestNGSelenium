package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTests extends TestBase {

    /*
    Verify radio buttons
    Open Browser
    Login as driver
    Go to Activities - Calendar events
    Click on create calendar events
    Click on repeat
    Verify that repeat every days is checked
    Verify that repeat weekday is not checked
     */

    @Test
    public void test1(){

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        createCalendarEventsPage.navigateToModule("Activities","Calendar Events");
        BrowserUtils.waitFor(3);
        calendarEventsPage.createCalendarEvent.click();
        BrowserUtils.waitFor(3);
        createCalendarEventsPage.repeat.click();
        BrowserUtils.waitFor(3);

        Assert.assertTrue(createCalendarEventsPage.days.isSelected());
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected());

    }
    /*
    * Verify Repeat Options
    * Open Browser
    * Login as driver
    * Go to Activities -> Calendar Events
    * Click on create calendat events button
    * Click on repeat checkbox
    * Verify that repeat options are Daily, Weekly,Monthly, Yearly (in this order)
    */
    @Test
    public void test2(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        BrowserUtils.waitFor(3);

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.createCalendarEvent.click();
        BrowserUtils.waitFor(3);

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();
        BrowserUtils.waitFor(3);

        /*Way 1
        Select repeats = new Select(createCalendarEventsPage.repeatOptions);

        List<WebElement> options = repeats.getOptions();

        Assert.assertEquals(options.get(0).getText(),"Daily");
        Assert.assertEquals(options.get(1).getText(),"Weekly");
        Assert.assertEquals(options.get(2).getText(),"Monthly");
        Assert.assertEquals(options.get(3).getText(),"Yearly");
        */

       //Way2
        Select repeatsDropdown = createCalendarEventsPage.repeatOptionsList();

        //Verify that repeat options are Daily, Weekly, Monthly, Yearly(in this order)
        List<String> expectedList = Arrays.asList("Daily","Weekly","Monthly","Yearly");

        List<String> actualList = new ArrayList<>();
        List<WebElement>actualOptions = repeatsDropdown.getOptions();
        for(WebElement option : actualOptions){
            //get text of each element and add to actual List
            actualList.add(option.getText());
        }

        Assert.assertEquals(actualList,expectedList,"Verify Daily, Weekly, Monthly, Yearly");

    }

}
