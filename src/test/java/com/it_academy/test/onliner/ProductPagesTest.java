package com.it_academy.test.onliner;

import com.it_academy.onliner.framework.DriverManager;
import com.it_academy.onliner.pageobject.onliner.Header;

import com.it_academy.test.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ProductPagesTest extends BaseTest {

    private final Header header = new Header();


    @BeforeClass
    public void navigationToHomePage() {
        DriverManager.getWebDriver().get("https://www.onliner.by/");
    }

    @Test
    public void testIsSectionsTitlesExists() {
        List<String> catalogElementsExpected = new ArrayList<>(Arrays.asList("Электроника", "Компьютеры и сети",
                "Бытовая техника", "На каждый день", "Стройка и ремонт", "Дом и сад", "Авто и мото", "Красота и спорт",
                "Детям и мамам"));
        List<String> catalogElements = header
                .clickOnMainNavigationLink("Каталог")
                .getListOfCatalogElements();
        assertThat(catalogElements)
                .as("Catalog page sections titles is not displayed")
                .containsExactlyElementsOf(catalogElementsExpected);
    }

    @Test
    public void testIsVerticalListOfSpecifiedSectionsExists() {
        List<String> titleCollectionExpectedValues = new ArrayList<>(Arrays.asList("Ноутбуки, компьютеры, мониторы",
                "Комплектующие"));
        List<String> catalogClassifierElements = header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("Компьютеры и\u00a0сети")
                .getListOfCatalogCategoryElements();
        assertThat(catalogClassifierElements)
                .as("Catalog page vertical list of specified sections is not displayed")
                .containsAll(titleCollectionExpectedValues);
    }

    @Test
    public void testIsElementsDescriptionPresentUnderEachElementsTitle() {
        List<String> catalogElements = header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("Компьютеры и\u00a0сети")
                .clickOnCatalogClassifierCategoryLink("Комплектующие")
                .getListOfCatalogCategoryProductElements();
        assertThat(catalogElements.iterator())
                .as("Catalog elements are not presented")
                .isNotNull()
                .hasNext();
        catalogElements = header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("Компьютеры и\u00a0сети")
                .clickOnCatalogClassifierCategoryLink("Комплектующие")
                .getListOfCatalogCategoryProductDescriptionElements();
        assertThat(catalogElements)
                .as("Each description of elements in section Accessories should contain p.")
                .anyMatch(element -> element.contains("р."));
    }

    @Test
    public void testIsFullDescriptionOfEachProductExists() {
        Map<By, List<WebElement>> pageElements = header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("Электроника")
                .clickOnCatalogClassifierCategoryLink("Аудиотехника")
                .clickOnProductLink("Наушники")
                .getListOfCatalogCategoryProductFullDescriptionElements();
        assertThat(pageElements.entrySet().iterator())
                .as("A full description of each product item is not provided")
                .isNotNull()
                .hasNext();
    }
}
