package com.cybertek.tests.day7_testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeAfterMethod {

    @Test

    public void test1(){

        System.out.println("First Test Case");

    }

    @Test
    public void test2(){
        System.out.println("Second Test Case");
    }

    @Test
    public void test3(){
        System.out.println("Third Test Case");
    }
    @BeforeMethod

    public void setUp(){
        System.out.println("WebDriver, Opening Browser");
    }

    @AfterMethod

    public void tearDown(){
        System.out.println("Closing Browser, Quit");
    }
}
