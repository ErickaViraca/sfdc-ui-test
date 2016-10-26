package org.fundacionjala.sfdc.tests.contract;

import org.fundacionjala.sfdc.pages.contracts.ContractDetail;
import org.fundacionjala.sfdc.pages.products.ProductDetail;
import org.testng.Assert;

import java.util.Map;

/**
 * This class handle the assert contract.
 */
final class AssertContract {
    /**
     * Constructor private.
     */
    private AssertContract() {
    }

    /**
     * This method doing the assertion.
     *
     * @param contractDetail {@link ContractDetail}
     * @param valuesMapJson Map the fields with values.
     */
    static void assertDetailValues(ContractDetail contractDetail, Map<String, String> valuesMapJson) {
        valuesMapJson.keySet()
                .forEach(value -> Assert.assertEquals(contractDetail.getStrategyAssertMap().get(value.toUpperCase()).getText(),
                        valuesMapJson.get(value.toUpperCase())));
    }
}
