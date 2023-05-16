package com.it_academy.onliner.rest_api.service;

import com.it_academy.onliner.rest_api.model.SushiveslaProducts;

import java.util.List;
import java.util.Map;

import static com.it_academy.onliner.rest_api.endpoints.OnlinerEndpoints.getCatalogSushiveslaEndpoint;
import static com.it_academy.onliner.rest_api.endpoints.OnlinerEndpoints.getCatalogSushiveslaRoolsEndpoint;
import static com.it_academy.onliner.rest_api.utils.GetRequestUtils.makeGetRequestAndGetResponseBody;

public class SushiveslaService {

    private Map<String, Object> configureHeaders() {
        return Map.of("Host", "Catalog.onliner.by");
    }

    public List<SushiveslaProducts> getSushiveslaProducts() {
        return makeGetRequestAndGetResponseBody(getCatalogSushiveslaEndpoint(), configureHeaders())
                .jsonPath()
                .getList("products", SushiveslaProducts.class);
    }

    public List<SushiveslaProducts> getSushiveslaProductsFilterRolls() {
        return makeGetRequestAndGetResponseBody(getCatalogSushiveslaRoolsEndpoint(), configureHeaders())
                .jsonPath()
                .getList("products", SushiveslaProducts.class);
    }
}
