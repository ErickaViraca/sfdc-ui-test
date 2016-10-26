package org.fundacionjala.sfdc.tests.product;

import java.util.Map;

import org.testng.Assert;

import org.fundacionjala.sfdc.pages.products.ProductDetail;

/**
 * This class handle the assert product.
 */
final class AssertProduct {
    /**
     * Constructor private.
     */
    private AssertProduct() {
    }

    /**
     * This method doing the assertion.
     *
     * @param productDetail {@inheritDoc}
     * @param valuesMapJson Map the fields with values.
     */
    static void assertDetailValues(ProductDetail productDetail, Map<String, String> valuesMapJson) {
        valuesMapJson.keySet()
                .forEach(value -> Assert.assertEquals(productDetail.getStrategyAssertMap().get(value.toUpperCase()).getText(),
                        valuesMapJson.get(value.toUpperCase())));
    }
}
