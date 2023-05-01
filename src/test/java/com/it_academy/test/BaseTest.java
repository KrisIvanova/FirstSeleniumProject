package com.it_academy.test;

import com.it_academy.onliner.framework.DriverManager;
import org.testng.annotations.BeforeClass;


public class BaseTest {

    @BeforeClass
    public void init() {
        DriverManager.initDriver();
    }
}
