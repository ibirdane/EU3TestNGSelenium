package com.cybertek.tests.day11_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExample {


    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }
    @Test
    public void printTable(){
        WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));

        System.out.println(table.getText());

        Assert.assertTrue(table.getText().contains("jdoe@hotmail.com"));

    }
    @Test
    public void getAllHeaders(){
        //how many columns we have ?
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = "+headers.size());
        for (WebElement header : headers) {
            System.out.println(header.getText());

        }
    }
    @Test
    public void test2(){
        //how many columns we have ?
        List<WebElement>headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = "+headers.size());

        //how many rows do we have ?
        List<WebElement>allRowsWithHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println(allRowsWithHeader.size());

        //number of rows without header(we prefer this)
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println(allRowsWithoutHeader.size());
    }

    @Test
    public void getRow(){
        //print the second row information
        List<WebElement> secondRow = driver.findElements(By.xpath("(//table[@id='table1']/tbody/tr)[2]"));
        for (WebElement webElement : secondRow) {
            System.out.println(webElement.getText());
        }
        
        //get all rows dynamically
        //1.find numbers of rows
        List<WebElement>numRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        //2.iterate one by one
        for (int i = 1; i < numRows.size(); i++) {
            WebElement row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]"));
            System.out.println(i+"-"+row.getText());
            
        }
    }

    @Test
    public void getAllCellInOneRow(){
        List<WebElement> allcellsInOneRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));
        for (WebElement element : allcellsInOneRow) {
            System.out.println(element.getText());


        }
    }
    @Test
    public void getAsingleCellByIndex(){
        WebElement element1 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]/td[3]"));
        System.out.println(element1.getText());
    }
    @Test
    public void printAllCellsByIndex(){
        int rowNumber = getNumberOfRows();
        int colNumber = getNumberOfColumns();

        System.out.println("colNumber = " + colNumber);
        System.out.println("rowNumber = " + rowNumber);

        //iterate through each row on the table
        for (int i = 1; i <= rowNumber; i++) {
            //iterate through each cell on the table
            for (int j = 1; j <= colNumber; j++) {
                System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]")).getText());

            }
        }

    }

    @Test
    public void getCellInRelationToAnotherCellInSameRow(){

        String firstName = "Jason";

        String xpath="//table[@id='table1']//td[.='John']/../td[3]";
        WebElement email = driver.findElement(By.xpath(xpath));
        System.out.println(email.getText());
    }

    private int getNumberOfColumns() {
        List<WebElement>headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        return headers.size();
    };

    private int getNumberOfRows() {
        List<WebElement>allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return allRowsWithoutHeader.size();
    }

}

