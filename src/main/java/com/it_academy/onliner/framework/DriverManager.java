package com.it_academy.onliner.framework;

import com.it_academy.onliner.framework.driver_creator.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static ThreadLocal<RemoteWebDriver> driver =
            new ThreadLocal<>();

    public static synchronized void setWebDriver(String browser) {
        if(driver.get() == null) {
            System.out.println("set driver: " + Thread.currentThread().getId());
            driver.set(Driver.getByDriverType(browser)
                    .getWebDriverCreator()
                    .create());
            driver.get().manage().window().maximize();
            driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.get().manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        } else {
            System.out.println("driver was set: " + Thread.currentThread().getId());
        }
    }

    public static WebDriver getWebDriver() {
        return driver.get();
    }

    public static void closeBrowser() {
        driver.get().quit();
        driver.remove();
    }
}
