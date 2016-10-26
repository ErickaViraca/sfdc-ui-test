package org.fundacionjala.sfdc.pages.accounts;

import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.DetailBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.Select;

public class AccountViewDetails extends DetailBase {

    @SuppressWarnings("finally")
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

    @SuppressWarnings("finally")
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

    @Override
    public AbstractBasePage clickEditButton() {
        return null;
    }

    @Override
    public AbstractBasePage clickDeleteButton() {
        return null;
    }
}
