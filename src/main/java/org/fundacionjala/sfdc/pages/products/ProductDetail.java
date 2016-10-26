package org.fundacionjala.sfdc.pages.products;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.AssertsDetails;
import org.fundacionjala.sfdc.pages.base.DetailBase;

import static org.fundacionjala.sfdc.pages.products.ProductFields.*;

/**
 * This class handle the product details.
 */
public class ProductDetail extends DetailBase {

    private static final String CHECKED = "Checked";

    private static final String TITLE = "title";

    // product name
    @FindBy(id = "Name_ileinner")
    @CacheLookup
    private WebElement productNameLabel;

    // product code
    @FindBy(id = "ProductCode_ileinner")
    @CacheLookup
    private WebElement productCodeLabel;

    // product description
    @FindBy(id = "Description_ileinner")
    @CacheLookup
    private WebElement productDescriptionLabel;

    // active flag
    @FindBy(id = "IsActive_chkbox")
    @CacheLookup
    private WebElement activeFlagImg;

    // product family
    @FindBy(id = "Family_ileinner")
    @CacheLookup
    private WebElement productFamilyLabel;

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductHome clickDeleteButton() {
        CommonActions.clickElement(deleteBtn);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        return new ProductHome();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductForm clickEditButton() {
        CommonActions.clickElement(editBtn);
        return new ProductForm();
    }

    /**
     * Method that to permit gets texts.
     *
     * @return a Map with the values of opportunity edit.
     */
    public Map<String, AssertsDetails> getStrategyAssertMap() {
        final Map<String, AssertsDetails> strategyMap = new HashMap<>();
        strategyMap.put(NAME.toString(), this::getProductName);
        strategyMap.put(CODE.toString(), this::getProductCode);
        strategyMap.put(ACTIVE.toString(), () -> String.valueOf(isActiveFlag()));
        strategyMap.put(FAMILY.toString(), this::getProductFamily);
        strategyMap.put(DESCRIPTION.toString(), this::getDescription);
        return strategyMap;
    }

    /**
     * This method verify that product is displayed.
     *
     * @param product String with product.
     * @return returns <code>true<code/> if product is displayed.
     */
    public boolean isProductDisplayed(final String product) {
        return CommonActions.existElementByLinkText(product);
    }

    /**
     * This method verify that flag is active.
     *
     * @return Return true if is active.
     */
    public boolean isActiveFlag() {
        return CHECKED.equals(activeFlagImg.getAttribute(TITLE));
    }

    /**
     * This method obtains the product family.
     *
     * @return String with product family.
     */
    public String getProductFamily() {
        return CommonActions.getText(productFamilyLabel);
    }

    /**
     * This method obtains the product name.
     *
     * @return String with product name.
     */
    public String getProductName() {
        return CommonActions.getText(productNameLabel);
    }

    /**
     * This method obtains the product code.
     *
     * @return String with product code.
     */
    public String getProductCode() {
        return CommonActions.getText(productCodeLabel);
    }

    /**
     * This method obtains the product code.
     *
     * @return String with product code.
     */
    public String getDescription() {
        return CommonActions.getText(productDescriptionLabel);
    }

}
