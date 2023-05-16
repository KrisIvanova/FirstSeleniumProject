package com.it_academy.onliner.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class Header extends BasePage {

    private static final String MAIN_NAVIGATION_LINK_XPATH_PATTER =
            "//*[contains(@class, 'main-navigation__text') and contains(text(), '%s')]";

    private final By footerElements = By.xpath("//li[contains(@class, 'footer')]");
    public CatalogPage clickOnMainNavigationLink(String link) {
        waitForElementVisible(By.xpath(format(MAIN_NAVIGATION_LINK_XPATH_PATTER, link))).click();
        return new CatalogPage();
    }

    public List<String> getTitlesOfFooterElements() {
        List<String> titlesElements = new ArrayList<>();
        List<WebElement> elements = find(footerElements);
        elements.stream().forEach((p) -> titlesElements.add(p.getText()));
        return titlesElements;
    }
}
