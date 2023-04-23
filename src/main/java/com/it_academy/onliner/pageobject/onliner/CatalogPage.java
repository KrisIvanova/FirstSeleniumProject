package com.it_academy.onliner.pageobject.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class CatalogPage extends BasePage {

    private static final String CATALOG_CLASSIFIER_LINK_XPATH_PATTERN =
            "//ul[@class='catalog-navigation-classifier ']/li//span[normalize-space(text())]";

    private static final String CATALOG_CLASSIFIER_LINK_TEXT_XPATH_PATTERN =
            "//ul[@class='catalog-navigation-classifier ']/li//span[normalize-space(text()) and contains(text(), '%s')]";

    private static final String CATALOG_CLASSIFIER__CATEGORY_XPATH_PATTERN =
            "//div[contains(@class, 'aside-list')]//div[contains(@class, 'aside-title')]";

    private static final String CATALOG_CLASSIFIER__CATEGORY_LINK_XPATH_PATTERN =
            "//div[contains(@class, 'aside-list')]//div[contains(@class, 'aside-title') and contains(text(), '%s')]";


    private static final String PRODUCT_XPATH_PATTERN =
            "//div[contains(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]"
                    + "/a[contains(@href, 'onliner')]//span[contains(@class, 'title')]";

    private static final String PRODUCT_DESCRIPTION_XPATH_PATTERN =
    "//*[@class='catalog-navigation-list__aside-title' and contains(text(),'Комплектующие')]" +
                            "//following-sibling::div[@class='catalog-navigation-list__dropdown']" +
                            "//a//span[contains(@class, 'list__dropdown-description') and contains(text(), 'товар')]";



    public CatalogPage clickOnCatalogClassifierLink(String link) {
        waitForElementVisible(By.xpath(format(CATALOG_CLASSIFIER_LINK_TEXT_XPATH_PATTERN, link)))
                .click();
        return this;
    }

    public CatalogPage clickOnCatalogClassifierCategoryLink(String link) {
        waitForElementVisible(By.xpath(format(CATALOG_CLASSIFIER__CATEGORY_LINK_XPATH_PATTERN, link)))
                .click();
        return this;
    }

    public ProductPage clickOnProductLink(String product) {
        waitForElementVisible(By.xpath(format(PRODUCT_XPATH_PATTERN, product)))
                .click();
        return new ProductPage();
    }

    public List<String> getListOfCatalogElements() {
        List<String> catalogElementsTitles = new ArrayList<>();
        List<WebElement> catalogElements = find(By.xpath(format(CATALOG_CLASSIFIER_LINK_XPATH_PATTERN)));
        catalogElements.stream().skip(1).toList().forEach((p) -> catalogElementsTitles.add(p.getText()));
        return catalogElementsTitles;
    }

    public List<String> getListOfCatalogCategoryElements() {
        List<String> titleCollection = new ArrayList<>();
        List<WebElement> elements = find(By.xpath(format(CATALOG_CLASSIFIER__CATEGORY_XPATH_PATTERN)));
        elements.stream().forEach((p) -> titleCollection.add(p.getText()));
        List<String> finalTitleCollection = titleCollection.stream().filter(p -> !Objects.equals(p, ""))
                .collect(Collectors.toList());
        return finalTitleCollection;
    }
    public List<String> getListOfCatalogCategoryProductElements() {
        List<String> titleCollection = new ArrayList<>();
        List<WebElement> elements = find(By.xpath(format(PRODUCT_XPATH_PATTERN)));
        elements.stream().forEach((p) -> titleCollection.add(p.getText()));
        return titleCollection;
    }


    public List<String> getListOfCatalogCategoryProductDescriptionElements() {
        List<String> titleCollection = new ArrayList<>();
        List<WebElement> elements = find(By.xpath(format(PRODUCT_DESCRIPTION_XPATH_PATTERN)));
        elements.stream().forEach((p) -> titleCollection.add(p.getText()));
        return titleCollection;
    }


}
