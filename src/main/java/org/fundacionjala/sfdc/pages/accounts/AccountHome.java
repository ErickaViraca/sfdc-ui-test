package org.fundacionjala.sfdc.pages.accounts;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.HomeBase;

/**
 * It is the account base page, abstract class.
 *
 * {@link HomeBase}
 */
public class AccountHome  extends HomeBase {

    /**
     * Makes click on the "new" button.
     *
     * {@link HomeBase}
     * @return AccountForm
     */
    @Override
    public AccountForm clickNewButton() {
        CommonActions.clickElement(newButton);
        return new AccountForm();
    }

    /**
     * Makes click on the "create new view" link.
     *
     * {@link HomeBase}
     * @return AccountForm
     */
    @Override
    public AbstractBasePage clickCreateNewViewLink() {
        CommonActions.clickElement(createNewViewLink);
        return new AccountForm();
    }

    /**
     * Makes click on the "edit" link for a view.
     *
     * {@link HomeBase}
     * @return AccountForm
     */
    @Override
    public AbstractBasePage clickEditViewLink() {
        CommonActions.clickElement(editViewLink);
        return new AccountForm();
    }

    public AccountDetail clickOnAccount(String accountName) {
        return new AccountDetail();
    }
}
