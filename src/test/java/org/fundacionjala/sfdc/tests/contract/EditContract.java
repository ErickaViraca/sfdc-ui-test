package org.fundacionjala.sfdc.tests.contract;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.products.ProductDetail;
import org.fundacionjala.sfdc.pages.products.ProductForm;
import org.fundacionjala.sfdc.pages.products.ProductHome;

public class EditContract {

    private static final String PRODUCT_DATA_PATH = "product/CreateProductData.json";

    private static final String OPPORTUNITY_DATA_EDIT_PATH = "product/EditProductData.json";

    private static final String NAME_TEST = "nameTestUpdate";

    private static final String DESCRIPTION_TEST = "description test update";

    private ProductDetail productDetail;

    private ProductForm productForm;

    @BeforeMethod
    public void setup() {
        Map<String, String> valuesMapJson = JsonMapper.getMapJson(PRODUCT_DATA_PATH);
        MainApp mainApp = new MainApp();
        TabBar tabBar = mainApp.goToTabBar();
        ProductHome productHome = tabBar.clickOnProductsHome();
        productForm = productHome.clickNewButton();
        productForm.fillTheForm(valuesMapJson);
        productDetail = productForm.clickSaveButton();
        productForm = productDetail.clickEditButton();
    }

    @Test
    public void editProductWithJson() {
        Map<String, String> valuesMapEditJson = JsonMapper.getMapJson(OPPORTUNITY_DATA_EDIT_PATH);
        productForm.fillTheForm(valuesMapEditJson);
        productDetail = productForm.clickSaveButton();
        AssertContract.assertDetailValues(productDetail, valuesMapEditJson);
    }

    @Test
    public void editProduct() {
        productForm = new ProductForm.ProductBuilder(NAME_TEST)
                .setDescription(DESCRIPTION_TEST)
                .build();
        productDetail = productForm.saveProduct();
        AssertContract.assertDetailValues(productDetail, productForm.getValuesMap());
    }

    @AfterMethod
    public void afterTest() {
        productDetail.clickDeleteButton();
    }
}
