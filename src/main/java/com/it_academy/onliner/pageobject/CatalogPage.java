package com.it_academy.onliner.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class CatalogPage extends BasePage {

    private final By CATALOG_CLASSIFIER_LINK_XPATH =
            By.xpath("//ul[@class='catalog-navigation-classifier ']/li//span[normalize-space(text())]");

    private static final String CATALOG_CLASSIFIER_LINK_TEXT_XPATH_PATTERN =
            "//ul[@class='catalog-navigation-classifier ']/li//span[normalize-space(text()) and contains(text(), '%s')]";

    private final By CATALOG_CLASSIFIER__CATEGORY_XPATH =
            By.xpath("//div[contains(@class, 'aside-list')]//div[contains(@class, 'aside-title')]");

    private static final String CATALOG_CLASSIFIER__CATEGORY_LINK_XPATH_PATTERN =
            "//div[contains(@class, 'aside-list')]//div[contains(@class, 'aside-title') and contains(text(), '%s')]";


    private static final String PRODUCT_XPATH_PATTERN =
            "//div[contains(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]"
                    + "/a[contains(@href, 'onliner')]//span[contains(@class, 'title') and contains(text(), '%s')]";

    private static final String PRODUCT_DESCRIPTION_XPATH_PATTERN =
            "//*[@class='catalog-navigation-list__aside-title' and contains(text(),'Комплектующие')]" +
                    "//following-sibling::div[@class='catalog-navigation-list__dropdown']" +
                    "//a//span[contains(@class, 'list__dropdown-description') and contains(text(), 'товар')]";

    private final By titlesCategoryProduct =
            By.xpath("//div[contains(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]/" +
                    "a[contains(@href, 'onliner')]//span[contains(@class, 'title')]");
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

    public List<String> getCatalogElements() {
        List<WebElement> catalogElements = find(CATALOG_CLASSIFIER_LINK_XPATH);
        return getTextsFromWebElements(catalogElements.stream().skip(1).toList());
    }

    public List<String> getCatalogCategoriesElements() {
        List<WebElement> elements = find(CATALOG_CLASSIFIER__CATEGORY_XPATH);
        return getTextsFromWebElements(elements)
                .stream().filter(p -> !Objects.equals(p, ""))
                .collect(Collectors.toList());
    }

    public List<String> getCatalogCategoriesProductElements() {
        List<WebElement> elements = find(titlesCategoryProduct);
        return getTextsFromWebElements(elements);
    }


    public List<String> getCatalogCategoriesProductDescriptionElements() {
        List<WebElement> elements = find(By.xpath(format(PRODUCT_DESCRIPTION_XPATH_PATTERN)));
        return getTextsFromWebElements(elements);
    }
}
