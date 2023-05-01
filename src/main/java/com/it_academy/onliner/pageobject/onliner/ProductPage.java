package com.it_academy.onliner.pageobject.onliner;

import com.codeborne.selenide.ElementsCollection;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;

public class ProductPage extends BasePage {

    private final ElementsCollection schemaProductDescriptionCollection =
            $$x("//div[@class='schema-product']");

    private final ElementsCollection productTitleCollection =
            $$x("//span[contains(@data-bind, 'product.full_name')]");

    private final ElementsCollection productDescriptionCollection =
            $$x("//span[contains(@data-bind, 'description')]");

    private final ElementsCollection titlesSchemaFilter =
            $$x("//div[contains(@class, 'label')]");

    public List<Integer> getCatalogCategoriesProductFullDescriptionElements() {
        List<Integer> sizesElements = new ArrayList<>();
        sizesElements.add(schemaProductDescriptionCollection.size());
        sizesElements.add(productTitleCollection.size());
        sizesElements.add(productDescriptionCollection.size());
        return sizesElements;
    }

    public List<String> getCatalogSchemaFilterElements() {
        return titlesSchemaFilter.texts();
    }
}
