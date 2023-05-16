package com.it_academy.onliner.test.api;

import com.it_academy.onliner.rest_api.model.SushiveslaProducts;
import com.it_academy.onliner.rest_api.service.SushiveslaService;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class RestAssuredTest {

    @Test
    public void verifySushiveslaServiceValues() {
        List<SushiveslaProducts> itemProducts = new SushiveslaService().getSushiveslaProducts();
        assertThat(itemProducts)
                .as("Sushivesla product names are empty")
                .noneMatch(element -> element.getName().isEmpty());
    }

    @Test
    public void testSushiveslaServiceHaveFilterRolls() {
        List<SushiveslaProducts> itemProducts = new  SushiveslaService().getSushiveslaProductsFilterRolls();
        assertThat(itemProducts)
                .as("Sushivesla products do not contain filter 'Роллы'")
                .allMatch(element -> element.getName_prefix().equals("Роллы"));
    }
}
