package com.it_academy.onliner.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

import java.util.List;


public class ProductPage extends BasePage {

    private final By schemaProductDescriptionCollection = By.xpath("//div[@class='schema-product']");
    private final By productTitleCollection = By.xpath("//span[contains(@data-bind, 'product.full_name')]");
    private final By productDescriptionCollection = By.xpath("//span[contains(@data-bind, 'description')]");

    private final By titlesSchemaFilter = By.xpath("//div[contains(@class, 'label')]");
    public List<Integer> getCatalogCategoriesProductFullDescriptionSizes() {
        List<Integer> sizesElements = new ArrayList<>();
        sizesElements.add(find(schemaProductDescriptionCollection).size());
        sizesElements.add(find(productTitleCollection).size());
        sizesElements.add(find(productDescriptionCollection).size());
        return sizesElements;
    }

    public List<String> getCatalogSchemaFilterElements() {
        List<WebElement> elements = find(titlesSchemaFilter);
        return getTextsFromWebElements(elements);
    }
}
