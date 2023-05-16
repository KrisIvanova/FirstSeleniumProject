package com.it_academy.onliner.pageobject;

import com.it_academy.onliner.framework.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public abstract class BasePage {
    private final WebDriver driver ;


    public BasePage() {
        driver = DriverManager.getWebDriver();
    }

    public WebElement waitForElementVisible(By by) {
        Wait<WebDriver> wait = new WebDriverWait(driver, ofSeconds(30));
        return wait.until(visibilityOfElementLocated(by));
    }

    public List<WebElement> find(By by) {
        return driver.findElements(by);
    }

    public List<String> getTextsFromWebElements(List<WebElement> webElements) {
        List<String> titlesElements = new ArrayList<>();
        webElements.stream().forEach((p) -> titlesElements.add(p.getText()));
        return titlesElements;
    }
}
