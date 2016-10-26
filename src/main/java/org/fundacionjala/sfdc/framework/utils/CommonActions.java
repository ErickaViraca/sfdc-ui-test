package org.fundacionjala.sfdc.framework.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import org.fundacionjala.sfdc.framework.browser.DriverManager;


/**
 * This class contains the common procedures to manage Add, and Delete elements from different components:
 * Leads, Campaign, Account, Contact, ContractHome, Products
 */
public final class CommonActions {

    private static final Logger LOGGER = LogManager.getLogger(CommonActions.class);

    /**
     * Constructor private.
     */
    private CommonActions() {
    }

    /**
     * This method waits and clickElement the element.
     *
     * @param element Element to wait and clickElement.
     */
    public static void clickElement(final WebElement element) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /**
     * This method waits and fill the element.
     *
     * @param element Element to wait and fill.
     * @param value    value to fill.
     */
    public static void sendKeys(final WebElement element, final String value) {
        if (value == null) {
            //throw new IllegalArgumentException("");
            //Logger.warn()
        }
        DriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(value);
    }

    /**
     * This method waits and clear the element.
     *
     * @param element Element to wait and clear.
     */
    public static void clearTextField(final WebElement element) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(element));
        element.clear();
    }

    /**
     * This method waits and select the item.
     *
     * @param element Element to wait.
     * @param item    Item to be selected.
     */
    public static void selectItem(final WebElement element, final String item) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(element));
        Select dropdown = new Select(element);
        dropdown.selectByValue(item);
    }

    /**
     * Selects the value by comboBox.
     *
     * @param webElement the webElement to be edited.
     * @param value      the value to select within the webElement.
     */
    public static void selectItemByVisibleText(final WebElement webElement, final String value) {
        try {
            DriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(webElement));
            Select comboBox = new Select(webElement);
            comboBox.selectByVisibleText(value);
        } catch (WebDriverException e) {
            LOGGER.warn("The value " + value + "couldn't be selected", e);
        }
    }

    /**
     * This method waits and check the element.
     *
     * @param element Element to wait and check.
     */
    public static void check(final WebElement element) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(element));
        if (!element.isSelected()) {
            element.click();
        }
    }

    /**
     * This method verify that element is selected.
     *
     * @param element WebElement with element.
     * @return Return true if element is selected.
     */
    public static boolean isSelected(final WebElement element) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(element));
        return element.isSelected();
    }

    /**
     * This method waits and clickElement the element.
     *
     * @param element Element to wait and clickElement.
     * @return text to element.
     */
    public static String getText(final WebElement element) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    /**
     * This method waits and delete the element.
     *
     * @param driver Driver to wait and deleted elements.
     */
    public static void deleteMe(final WebDriver driver) {
        WebElement deleteElementBtn;
        deleteElementBtn = driver.findElement(By.xpath("//input[@title='Delete']"));
        DriverManager.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(deleteElementBtn));
        deleteElementBtn.click();
        Alert deleteAlert = driver.switchTo().alert();
        deleteAlert.accept();
    }

    /**
     * Search an object within the initial list on the corresponding page.
     *
     * @param linkText the string value for search on the page object.
     * @return a boolean value, true or false.
     */
    public static Boolean existElementByLinkText(final String linkText) {
        Boolean result;
        try {
            DriverManager.getInstance().getDriver().findElement(By.linkText(linkText));
            result = true;
        } catch (WebDriverException e) {
            LOGGER.warn(e.getMessage(), e);
            result = false;
        }
        return result;
    }

    /**
     * This method verify that element is present.
     *
     * @param webElement WebElement with element.
     * @return Return true if element is present.
     */
    public static boolean isElementPresent(final WebElement webElement) {
        try {
            getText(webElement);
            return true;
        } catch (WebDriverException e) {
            LOGGER.warn(e.getMessage(), e);
            return false;
        }
    }

}
