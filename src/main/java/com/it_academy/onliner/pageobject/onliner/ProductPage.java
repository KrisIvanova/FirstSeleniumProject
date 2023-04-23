package com.it_academy.onliner.pageobject.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductPage extends BasePage {

    private static final String SCHEMA_PRODUCT_DESCRIPTION_XPATH_PATTERN =
            "//div[@class='schema-product']";

    private static final String PRODUCT_TITLE_XPATH_PATTERN =
            "//span[contains(@data-bind, 'product.full_name')]";

    private static final String PRODUCT_DESCRIPTION_XPATH_PATTERN =
            "//span[contains(@data-bind, 'description')]";


    public Map<By, List<WebElement>> getListOfCatalogCategoryProductFullDescriptionElements() {
        Map<By, List<WebElement>> titleCollection = new HashMap<>();
        titleCollection.put(By.xpath(SCHEMA_PRODUCT_DESCRIPTION_XPATH_PATTERN), find(By.xpath(SCHEMA_PRODUCT_DESCRIPTION_XPATH_PATTERN)));
        titleCollection.put(By.xpath(PRODUCT_TITLE_XPATH_PATTERN), find(By.xpath(PRODUCT_TITLE_XPATH_PATTERN)));
        titleCollection.put(By.xpath(PRODUCT_DESCRIPTION_XPATH_PATTERN), find(By.xpath(PRODUCT_DESCRIPTION_XPATH_PATTERN)));
        return titleCollection;
    }
}
