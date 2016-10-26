package org.fundacionjala.sfdc.pages.accounts;

import org.fundacionjala.sfdc.pages.MainApp;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.Select;

import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.DetailBase;

public class AccountViewDetail extends DetailBase {

    /**
     * Verify if a column exist.
     *
     * @param value String with the column value to search
     * @return returns <code>true<code/> if account is displayed or <code>false<code/> if it's not.
     */
    public Boolean existColumnName(String value) {
        Boolean result = false;
        try {
            driver.findElement(By.cssSelector("[title='" + value + "']"));
            result = true;
        } catch (WebDriverException e) {
            result = false;
        } finally {
            return result;
        }
    }

    /**
     * Verify if a view name exist.
     *
     * @param value String with the name value to search
     * @return returns <code>true<code/> if account is displayed or <code>false<code/> if it's not.
     */
    public Boolean existViewName(String value) {
        Boolean result = false;
        try {
            Select select = new Select(driver.findElement(By.className("title")));
            select.selectByVisibleText(value);
            result = true;
        } catch (WebDriverException e) {
            result = false;
        } finally {
            return result;
        }
    }

    /**
     * @return {@link AccountForm}
     */
    @Override
    public AbstractBasePage clickEditButton() {
        return new AccountForm();
    }

    @Override
    public AbstractBasePage clickDeleteButton() {
        deleteBtn.click();
        Alert javascriptAlert = driver.switchTo().alert();
        javascriptAlert.accept();
        return new MainApp();
    }
}
