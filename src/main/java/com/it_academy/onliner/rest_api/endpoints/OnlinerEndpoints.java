package com.it_academy.onliner.rest_api.endpoints;

import com.it_academy.onliner.framework.PropertiesReader;

public class OnlinerEndpoints {

    public static String getCatalogSushiveslaEndpoint() {
        return PropertiesReader.getEndpointsProperty("catalog.sushivesla");
    }

    public static String getCatalogSushiveslaRoolsEndpoint() {
        return PropertiesReader.getEndpointsProperty("catalog.sushivesla.rolls");
    }
}
