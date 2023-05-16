package com.it_academy.onliner.test;

import com.it_academy.onliner.framework.DriverManager;
import org.testng.annotations.*;


public class BaseTest {

    @BeforeClass
    @Parameters(value = {"browser"})
    public void setUp(@Optional String browser) {
        if(browser != null) {
            DriverManager.setWebDriver(browser);
        } else {
            System.out.println("browser type from command line");
            DriverManager.setWebDriver(System.getProperty("driverType"));
            //DriverManager.setWebDriver("remote");
        }
    }

    @AfterClass
    public void closeBrowser() {
        DriverManager.closeBrowser();
    }
}
