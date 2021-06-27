package com.systemc;

import com.systemc.constants.EndPoint;
import com.systemc.pojo.Product;
import com.systemc.utilities.RestUtil;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ProductTest {

    private static RequestSpecification reqSpec;

    private static ResponseSpecification resSpec;

    int length = 16;
    boolean useLetters = true;
    boolean useNumbers = false;
    String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

    @Before
    public void setup() {

        reqSpec = RestUtil.getRequestSpecification();
        resSpec = RestUtil.getResponseSpecification();
    }

    @Test
    public void addNewProductToCatalogue(){

        Product addProduct = new Product();
        addProduct.setId("");
        addProduct.setName(generatedString);
        addProduct.setDescription("Lorem Ipsum");
        addProduct.setPrice(11.95);
        addProduct.setItemCount(8);
        addProduct.setIsActive(true);
        addProduct.setCreatedDateTime("2021-06-27T16:04:24.4442033Z");
        addProduct.setModifiedDateTime("2021-06-27T16:04:24.4442033Z");
        RestUtil.setEndPoint(EndPoint.ADD_NEW_PRODUCT);

        Response res = RestUtil.getResponse(RestUtil.createBody(reqSpec, addProduct), "post");
        String description = res.path("description");
        assertTrue(description.contains("Lorem Ipsum"));
    }
}


