package com.it_academy.onliner.test.web;

import com.it_academy.onliner.framework.DriverManager;
import com.it_academy.onliner.pageobject.Header;

import com.it_academy.onliner.test.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ProductPagesTest extends BaseTest {

    protected static final Logger LOG = LoggerFactory.getLogger(ProductPagesTest.class);

    private Header header;

    @Test
    public void voidTestLogs(){
        LOG.info("this is an info message");
        LOG.debug("this is an debug message");
    }

    @BeforeClass
    public void navigationToHomePage() {
        header = new Header();
        DriverManager.getWebDriver().get("https://www.onliner.by");
    }

    @Test
    public void testIsSectionsTitlesExists() {
        List<String> catalogElementsExpected = (Arrays.asList("Электроника", "Компьютеры и сети",
                "Бытовая техника", "На каждый день", "Стройка и ремонт", "Дом и сад", "Авто и мото", "Красота и спорт",
                "Детям и мамам"));
        List<String> catalogElements = header
                .clickOnMainNavigationLink("Каталог")
                .getCatalogElements();
        assertThat(catalogElements)
                .as("Catalog page sections titles is not displayed")
                .containsExactlyElementsOf(catalogElementsExpected);
    }

    @Test
    public void testIsVerticalListOfSpecifiedSectionsExists() {
        List<String> titlesExpectedValues = (Arrays.asList("Ноутбуки, компьютеры, мониторы",
                "Комплектующие"));
        List<String> catalogClassifierElements = header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("Компьютеры и\u00a0сети")
                .getCatalogCategoriesElements();
        assertThat(catalogClassifierElements)
                .as("Catalog page vertical list of specified sections is not displayed")
                .containsAll(titlesExpectedValues);
    }

    @Test
    public void testIsElementsDescriptionPresentUnderEachElementsTitle() {
        List<String> catalogElements = header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("Компьютеры и\u00a0сети")
                .clickOnCatalogClassifierCategoryLink("Комплектующие")
                .getCatalogCategoriesProductElements();
        assertThat(catalogElements.iterator())
                .as("Catalog elements are not presented")
                .isNotNull()
                .hasNext();
        catalogElements = header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("Компьютеры и\u00a0сети")
                .clickOnCatalogClassifierCategoryLink("Комплектующие")
                .getCatalogCategoriesProductDescriptionElements();
        assertThat(catalogElements)
                .as("Each description of elements in section Accessories should contain p.")
                .anyMatch(element -> element.contains("р."));
    }

    @Test
    public void testIsFullDescriptionOfEachProductExists() {
        List<Integer> quantityElementsPage = header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("Электроника")
                .clickOnCatalogClassifierCategoryLink("Аудиотехника")
                .clickOnProductLink("Наушники")
                .getCatalogCategoriesProductFullDescriptionSizes();
        assertThat(quantityElementsPage)
                .as("A full description of each product item is not provided")
                .allMatch(element -> element.equals(quantityElementsPage.get(0)));
    }

    @Test
    public void testIsElementsPresentInAccessoriesSection() {
        List<String> catalogElements = header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("Компьютеры и\u00a0сети")
                .clickOnCatalogClassifierCategoryLink("Аксессуары к ноутбукам и\u00a0компьютерам")
                .getCatalogCategoriesProductElements();
        assertThat(catalogElements.iterator())
                .as("Catalog elements are not presented")
                .isNotNull()
                .hasNext();
    }

    @Test
    public void testIsSchemaFilterExist() {
        List<String> titleExpectedValues = new ArrayList<>(Arrays.asList("Производитель",
                "Цена"));
        List<String> catalogElements = header
                .clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierLink("Дом и\u00a0сад")
                .clickOnCatalogClassifierCategoryLink("Садовая техника и\u00a0инструменты")
                .clickOnProductLink("Триммеры")
                .getCatalogSchemaFilterElements();
        assertThat(catalogElements)
                .as("Product page filter of  section is not displayed")
                .containsAll(titleExpectedValues);
    }

    @Test
    public void testIsTitlesOfFooterExist() {
        List<String> titlesOfFooterExpectedValues = new ArrayList<>(Arrays.asList("О компании", "Контакты редакции", "Реклама",
                "Тарифы", "Вакансии", "Манифест", "Пользовательское соглашение", "Публичные договоры",
                "Политика обработки персональных данных", "Поддержка пользователей", "Правила возврата"));
        List<String> catalogElements = header
                .getTitlesOfFooterElements();
        assertThat(catalogElements)
                .as("Product page titles of footer is not displayed")
                .containsExactlyElementsOf(titlesOfFooterExpectedValues);
    }
}
