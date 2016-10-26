package org.fundacionjala.sfdc.tests.contract;

import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.products.ProductDetail;
import org.fundacionjala.sfdc.pages.products.ProductForm;
import org.fundacionjala.sfdc.pages.products.ProductHome;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * This class handle create a new contract.
 */
public class CreateContract {

    private static final String CONTRACT_DATA_PATH = "contract/CreateContractData.json";

    private static final String NAME_TEST = "nameTest";

    private static final String DESCRIPTION_TEST = "description test";

    private ProductForm productForm;

    private Map<String, String> valuesMapJson;

    private ProductDetail productDetail;

    /**
     * This method is Before setup.
     */
    @BeforeMethod
    public void setup() {
        valuesMapJson = JsonMapper.getMapJson(CONTRACT_DATA_PATH);
        final MainApp mainApp = new MainApp();
        final TabBar tabBar = mainApp.goToTabBar();
        final ProductHome productHome = tabBar.clickOnProductsHome();
        productForm = productHome.clickNewButton();
    }

    /**
     * This method that is created a new product with json.
     */
    @Test
    public void createProductWithJson() {
        productForm.fillTheForm(valuesMapJson);
        productDetail = productForm.clickSaveButton();
        AssertContract.assertDetailValues(productDetail, valuesMapJson);
    }

    /**
     * This method that is created a new product.
     */
    @Test
    public void createProduct() {
        productForm = new ProductForm.ProductBuilder(NAME_TEST)
                .setDescription(DESCRIPTION_TEST)
                .build();
        productDetail = productForm.saveProduct();
        AssertContract.assertDetailValues(productDetail, productForm.getValuesMap());
    }

    /**
     * This method is executed after scenario.
     */
    @AfterMethod
    public void tearDown() {
        productDetail.clickDeleteButton();
    }
}
