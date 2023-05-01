package com.it_academy.onliner.pageobject.onliner;

import com.codeborne.selenide.ElementsCollection;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class CatalogPage extends BasePage {

    private static final String CATALOG_CLASSIFIER_LINK_TEXT_XPATH_PATTERN =
            "//ul[@class='catalog-navigation-classifier ']/li//span[normalize-space(text()) and contains(text(), '%s')]";

    private static final String CATALOG_CLASSIFIER__CATEGORY_LINK_XPATH_PATTERN =
            "//div[contains(@class, 'aside-list')]//div[contains(@class, 'aside-title') and contains(text(), '%s')]";

    private static final String PRODUCT_XPATH_PATTERN =
            "//div[contains(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]"
                    + "/a[contains(@href, 'onliner')]//span[contains(@class, 'title') and contains(text(), '%s')]";

    private final ElementsCollection catalogElements =
            $$x("//ul[@class='catalog-navigation-classifier ']/li//span[normalize-space(text())]");
    private final ElementsCollection titles =
            $$x("//div[contains(@class, 'aside-list')]//div[contains(@class, 'aside-title')]");
    private final ElementsCollection titlesCategoryProduct =
            $$x("//div[contains(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]/" +
                    "a[contains(@href, 'onliner')]//span[contains(@class, 'title')]");

    private final ElementsCollection descriptionElements =
            $$x("//*[@class='catalog-navigation-list__aside-title' and contains(text(),'Комплектующие')]" +
                    "//following-sibling::div[@class='catalog-navigation-list__dropdown']" +
                    "//a//span[contains(@class, 'list__dropdown-description') and contains(text(), 'товар')]");

    public CatalogPage clickOnCatalogClassifierLink(String link) {
        $x(format(CATALOG_CLASSIFIER_LINK_TEXT_XPATH_PATTERN, link))
                .shouldBe(exist, ofSeconds(30))
                .shouldBe(visible, ofSeconds(10))
                .shouldBe(enabled, ofSeconds(10))
                .click();
        return this;
    }

    public CatalogPage clickOnCatalogClassifierCategoryLink(String link) {
        $x(format(CATALOG_CLASSIFIER__CATEGORY_LINK_XPATH_PATTERN, link))
                .shouldBe(exist, ofSeconds(30))
                .shouldBe(visible, ofSeconds(10))
                .shouldBe(enabled, ofSeconds(10))
                .click();
        return this;
    }

    public ProductPage clickOnProductLink(String product) {
        $x(format(PRODUCT_XPATH_PATTERN, product))
                .shouldBe(exist, ofSeconds(30))
                .shouldBe(visible, ofSeconds(10))
                .shouldBe(enabled, ofSeconds(10))
                .click();
        return new ProductPage();
    }

    public List<String> getCatalogElements() {
        return catalogElements.texts().stream().skip(1).toList();
    }

    public List<String> getCatalogCategoriesElements() {
        return titles.texts();
    }

    public List<String> getCatalogCategoriesProductElements() {
        return titlesCategoryProduct.texts();
    }

    public List<String> getCatalogCategoriesProductDescriptionElements() {
        return descriptionElements.texts();
    }
}
