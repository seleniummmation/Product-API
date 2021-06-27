package com.systemc.utilities;

import com.systemc.constants.Path;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class RestUtil {

    public static String ENDPOINT;

    public static RequestSpecBuilder REQUEST_BUILDER;
    public static RequestSpecification REQUEST_SPEC;

    public static ResponseSpecBuilder RESPONSE_BUILDER;
    public static ResponseSpecification RESPONSE_SPEC;

    public static void setEndPoint(String e_point) {
        ENDPOINT = e_point;
    }

    public static RequestSpecification getRequestSpecification() {

        REQUEST_BUILDER = new RequestSpecBuilder();

        REQUEST_BUILDER.setBaseUri(Path.PRODUCT_BASE_URI);
        REQUEST_BUILDER.setContentType(ContentType.JSON);
        REQUEST_BUILDER.addHeader("Accept", "application/json");
        REQUEST_SPEC = REQUEST_BUILDER.build();

        return REQUEST_SPEC;
    }

    public static ResponseSpecification getResponseSpecification() {

        RESPONSE_BUILDER = new ResponseSpecBuilder();
        RESPONSE_BUILDER.expectStatusCode(200);
        RESPONSE_SPEC = RESPONSE_BUILDER.build();
        return RESPONSE_SPEC;
    }

    public static RequestSpecification createBody(RequestSpecification rSpec,Object value) {

        return (RequestSpecification) rSpec.body(value);
    }

    public static Response getResponse(RequestSpecification reqSpec, String type) {

        REQUEST_SPEC.spec(reqSpec);
        Response response = null;
        if (type.equalsIgnoreCase("get")) {
            response = given().spec(REQUEST_SPEC).get(ENDPOINT);
        } else if (type.equalsIgnoreCase("post")) {
            response = given().spec(REQUEST_SPEC).post(ENDPOINT);
        } else if (type.equalsIgnoreCase("put")) {
            response = given().spec(REQUEST_SPEC).put(ENDPOINT);
        } else if (type.equalsIgnoreCase("delete")) {
            response = given().spec(REQUEST_SPEC).delete(ENDPOINT);
        } else {
            System.out.println("This method does not exist");
        }
        response.then().log().all();
        //response.then().spec(RESPONSE_SPEC);
        return response;
    }

}
