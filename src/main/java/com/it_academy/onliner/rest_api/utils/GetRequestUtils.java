package com.it_academy.onliner.rest_api.utils;

import io.restassured.response.ResponseBody;
import org.apache.commons.collections4.MapUtils;
import org.apache.hc.core5.http.HttpStatus;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequestUtils {

    private GetRequestUtils() {
    }

    public static ResponseBody makeGetRequestAndGetResponseBody(String endpoint, Map<String, Object> headers) {
        return given()
                .headers(MapUtils.emptyIfNull(headers))
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .getBody();
    }
}
