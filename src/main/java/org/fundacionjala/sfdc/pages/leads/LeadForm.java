package org.fundacionjala.sfdc.pages.leads;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.FormSteps;
import org.fundacionjala.sfdc.pages.base.FormBase;


/**
 * This class represent the Form to create a new LeadHome.
 */
public class LeadForm extends FormBase {

    @FindBy(id = "name_lastlea2")
    @CacheLookup
    private WebElement lastNameTextField;

    @FindBy(id = "lea13")
    @CacheLookup
    private WebElement leadStatustTextField;

    @FindBy(id = "lea3")
    @CacheLookup
    private WebElement companyTextField;

    @FindBy(id = "name_firstlea2")
    @CacheLookup
    private WebElement firstNameTextField;

    @FindBy(id = "lea16street")
    @CacheLookup
    private WebElement streetTextField;

    @FindBy(id = "lea16city")
    @CacheLookup
    private WebElement cityTextField;

    @FindBy(id = "lea20")
    @CacheLookup
    private WebElement campaingTextField;

    @FindBy(id = "name_salutationlea2")
    @CacheLookup
    private WebElement nameSalutationSelect;

    @FindBy(id = "lea4")
    @CacheLookup
    private WebElement titleField;

    @FindBy(id = "lea5")
    @CacheLookup
    private WebElement leadSourceSelect;

    @FindBy(id = "lea6")
    @CacheLookup
    private WebElement industrySelect;

    @FindBy(id = "lea7")
    @CacheLookup
    private WebElement annualRevenueTextField;

    @FindBy(id = "lea8")
    @CacheLookup
    private WebElement phoneTextField;

    @FindBy(id = "lea9")
    @CacheLookup
    private WebElement mobileTextField;

    @FindBy(id = "lea10")
    @CacheLookup
    private WebElement faxTextField;

    @FindBy(id = "lea11")
    @CacheLookup
    private WebElement emailTextField;

    @FindBy(id = "lea12")
    @CacheLookup
    private WebElement websiteTextField;

    @FindBy(id = "lea14")
    @CacheLookup
    private WebElement ratingTextField;

    @FindBy(id = "lea15")
    @CacheLookup
    private WebElement numEmployeesTextField;

    @FindBy(id = "lea16state")
    @CacheLookup
    private WebElement stateTextField;

    @FindBy(id = "lea16zip")
    @CacheLookup
    private WebElement zipCodeTextField;

    @FindBy(id = "lea16country")
    @CacheLookup
    private WebElement countryTextField;

    @FindBy(xpath = "//td[contains(.,'ProductFields Interest')]/following::span/select")
    @CacheLookup
    private WebElement productInterestSelect;

    @FindBy(xpath = "//td[contains(.,'SIC Code')]/following::input")
    @CacheLookup
    private WebElement sicCodeTextField;

    @FindBy(xpath = "//td[contains(.,'Number of Locations')]/following::input")
    @CacheLookup
    private WebElement numLocationsTextField;

    @FindBy(xpath = "//td[contains(.,'Current Generator')]/following::input")
    @CacheLookup
    private WebElement currentGeneratorsTextField;

    @FindBy(xpath = "//td[contains(.,'Primary')]/following::span/select")
    @CacheLookup
    private WebElement primarySelect;

    /*Others*/
    @FindBy(id = "lea17")
    @CacheLookup
    private WebElement descriptionTextArea;

    @FindBy(id = "lea21")
    @CacheLookup
    private WebElement assignRuleCheckBox;

    @FindBy(id = "lea20_lkwgt")
    private WebElement campaignIcon;

    private LeadBuilder leadBuilder;

    private Map<String, String> mapValues;

    /**
     * Constructor that call the parent constructor.
     */
    public LeadForm() {
        super();
    }

    /**
     * Constructor that initialize the values.
     *
     * @param leadBuilder the builder class.
     */
    private LeadForm(LeadBuilder leadBuilder) {
        mapValues = new HashMap<>();
        this.leadBuilder = leadBuilder;
    }

    /**
     * Method that save the Lead Form.
     *
     * @return {@link LeadDetails}.
     */
    public LeadDetails saveLead() {
        mapValues = leadBuilder.getStrategyMap();
        fillTheForm(mapValues);
        return clickSaveButton();
    }

    /**
     * Method that return the built Map int the LeadBuilder class.
     *
     * @return the Map with the Form data Info.
     */
    public Map<String, String> getLeadValues() {
        return mapValues;
    }

    /**
     * This method selects the campaign where the LeadHome is take in account.
     *
     * @param campaignLookupText the campaign name.
     */
    private void selectCampaign(final String campaignLookupText) {
        wait.until(ExpectedConditions.elementToBeClickable(this.campaignIcon));
        campaignIcon.click();
        LeadCampaignLookup campaignLookup = new LeadCampaignLookup();
        campaignLookup.selectCampaignWithName(campaignLookupText);
    }

    /**
     * This method sets the Last name in the field.
     *
     * @param lastName the last name of the LeadHome.
     * @return {@link LeadForm}
     */
    public LeadForm setLastNameTextField(final String lastName) {
        CommonActions.sendKeys(lastNameTextField, lastName);
        return this;
    }

    /**
     * This method sets the Status of the LeadHome.
     *
     * @param status the status of the LeadHome.
     * @return {@link LeadForm}
     */
    public LeadForm setStatusField(final String status) {
        CommonActions.sendKeys(leadStatustTextField, status);
        return this;
    }

    /**
     * This method sets the company name of the LeadHome.
     *
     * @param company the company where the lead is working.
     * @return {@link LeadForm}
     */
    public LeadForm setCompanyTextField(final String company) {
        CommonActions.sendKeys(companyTextField, company);
        return this;
    }

    /**
     * This method sets the first name of the LeadHome.
     *
     * @param firstName the first name info.
     * @return {@link LeadForm}
     */
    public LeadForm setFirstNameTextField(final String firstName) {
        CommonActions.sendKeys(firstNameTextField, firstName);
        return this;
    }

    /**
     * This method set the Street of the LeadHome.
     *
     * @param street the street info of the LeadHome.
     * @return {@link LeadForm}
     */
    public LeadForm setStreetTextField(final String street) {
        CommonActions.sendKeys(streetTextField, street);
        return this;
    }

    /**
     * This method set the city of the LeadHome.
     *
     * @param city the city info of the LeadHome.
     * @return {@link LeadForm}
     */
    public LeadForm setCityTextField(final String city) {
        CommonActions.sendKeys(cityTextField, city);
        return this;
    }

    /**
     * Method that check the field "Assign Rule" if the sent data is "Yes".
     *
     * @param assignRule if this data is "yes" the field is checked
     */
    public void setAssignRule(final String assignRule) {
        if (assignRule.equals("yes")) {
            CommonActions.check(assignRuleCheckBox);
        }
    }

    /**
     * Method to fill the form given a Json file or the builder class.
     *
     * @param valuesMapCreate Map with the Json or builder map values.
     */
    public void fillTheForm(final Map<String, String> valuesMapCreate) {
        valuesMapCreate.keySet()
                .forEach(step -> getStrategyStepMap(valuesMapCreate).get(step).executeStep());
    }

    /**
     * Method to sets the values to create a new Lead.
     *
     * @param values Map with the information to be mapped.
     * @return a Map with the corresponding values.
     */
    private Map<String, FormSteps> getStrategyStepMap(final Map<String, String> values) {
        final Map<String, FormSteps> strategyMap = new HashMap<>();

        strategyMap.put("nameSalutation", () -> CommonActions.selectItem(nameSalutationSelect,
                values.get("nameSalutation")));
        strategyMap.put("firstName", () -> setFirstNameTextField(values.get("firstName")));
        strategyMap.put("lastName", () -> setLastNameTextField(values.get("lastName")));
        strategyMap.put("company", () -> setCompanyTextField(values.get("company")));
        strategyMap.put("title", () -> CommonActions.sendKeys(titleField, values.get("title")));
        strategyMap.put("leadSource", () -> CommonActions.selectItem(leadSourceSelect, values.get("leadSource")));
        strategyMap.put("campaignLookup", () -> selectCampaign(values.get("campaignLookup")));
        strategyMap.put("industry", () -> CommonActions.selectItem(industrySelect, values.get("industry")));
        strategyMap.put("annualRevenue", () -> CommonActions.sendKeys(annualRevenueTextField,
                values.get("annualRevenue")));
        strategyMap.put("phone", () -> CommonActions.sendKeys(phoneTextField, values.get("phone")));
        strategyMap.put("mobile", () -> CommonActions.sendKeys(mobileTextField, values.get("mobile")));
        strategyMap.put("fax", () -> CommonActions.sendKeys(faxTextField, values.get("fax")));

        strategyMap.put("email", () -> CommonActions.sendKeys(emailTextField, values.get("email")));
        strategyMap.put("website", () -> CommonActions.sendKeys(websiteTextField, values.get("website")));
        strategyMap.put("leadStatus", () -> CommonActions.selectItem(leadStatustTextField, values.get("leadStatus")));
        strategyMap.put("rating", () -> CommonActions.selectItem(ratingTextField, values.get("rating")));
        strategyMap.put("numEmployees", () -> CommonActions.sendKeys(numEmployeesTextField,
                values.get("numEmployees")));
        strategyMap.put("street", () -> CommonActions.sendKeys(streetTextField, values.get("street")));
        strategyMap.put("city", () -> CommonActions.sendKeys(cityTextField, values.get("city")));
        strategyMap.put("stateProvince", () -> CommonActions.sendKeys(stateTextField, values.get("stateProvince")));
        strategyMap.put("zipCode", () -> CommonActions.sendKeys(zipCodeTextField, values.get("zipCode")));
        strategyMap.put("country", () -> CommonActions.sendKeys(countryTextField, values.get("country")));

        strategyMap.put("productInterest", () -> CommonActions.selectItem(productInterestSelect,
                values.get("productInterest")));
        strategyMap.put("SICCode", () -> CommonActions.sendKeys(sicCodeTextField, values.get("SICCode")));
        strategyMap.put("numberLocations", () -> CommonActions.sendKeys(numLocationsTextField,
                values.get("numberLocations")));
        strategyMap.put("currentGenerators", () -> CommonActions.sendKeys(currentGeneratorsTextField,
                values.get("currentGenerators")));
        strategyMap.put("primary", () -> CommonActions.selectItem(primarySelect, values.get("primary")));

        strategyMap.put("description", () -> CommonActions.sendKeys(descriptionTextArea, values.get("description")));
        strategyMap.put("assignRule", () -> setAssignRule(values.get("assignRule")));

        return strategyMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LeadForm clickSaveNewButton() {
        CommonActions.clickElement(saveNewBtn);
        return new LeadForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LeadDetails clickSaveButton() {
        CommonActions.clickElement(saveButton);
        return new LeadDetails();
    }

    /**
     * Inner class that manage the values to be built.
     */
    public static class LeadBuilder {
        /*LeadHome Information*/
        private String nameSalutation;
        private String firstName;
        private String lastName;
        private String company;
        private String title;
        private String leadSource;
        private String campaign;
        private String campaignLookup;
        private String industry;
        private String annualRevenue;
        private String phone;
        private String mobile;
        private String fax;
        private String email;
        private String website;
        private String leadStatus;
        private String rating;
        private String numEmployees;

        /*Address Information*/
        private String street;
        private String city;
        private String stateProvince;
        private String zipCode;
        private String country;

        /*additional information*/
        private String productInterest;
        private String SICCode;
        private String numberLocations;
        private String currentGenerators;
        private String primary;

        /*Others*/
        private String description;
        private String assignRule;

        private Map<String, String> strategyMap;

        /**
         * Constructor that set the required values for the Lead Form.
         *
         * @param lastName Last Name required value.
         * @param company  company data.
         */
        public LeadBuilder(final String lastName, final String company) {
            strategyMap = new HashMap<>();
            this.lastName = lastName;
            this.company = company;
            strategyMap.put("lastName", lastName);
            strategyMap.put("company", company);
        }

        /**
         * Method that set the Salutation for the Lead.
         *
         * @param nameSalutation Salutation info.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setNameSalutation(final String nameSalutation) {
            this.nameSalutation = nameSalutation;
            strategyMap.put("nameSalutation", nameSalutation);
            return this;
        }

        /**
         * Method that set the first name data.
         *
         * @param firstName String with the first name info.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setFirstName(final String firstName) {
            this.firstName = firstName;
            strategyMap.put("firstName", firstName);
            return this;
        }

        /**
         * Method that set the Last name data.
         *
         * @param lastName String with the Last Name info.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setLastName(final String lastName) {
            this.lastName = lastName;
            strategyMap.put("lastName", lastName);
            return this;
        }

        /**
         * Method that set the Lead company.
         *
         * @param company String with the company info.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setCompany(final String company) {
            this.company = company;
            strategyMap.put("company", company);
            return this;
        }

        /**
         * Method that sets the Lead title data.
         *
         * @param title String with the title info.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setTitle(final String title) {
            this.title = title;
            strategyMap.put("title", title);
            return this;
        }

        /**
         * Method that sets the Lead source info.
         *
         * @param leadSource String with the source info.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setLeadSource(final String leadSource) {
            this.leadSource = leadSource;
            strategyMap.put("leadSource", leadSource);
            return this;
        }

       /* public LeadBuilder setCampaign(String campaign) {
            this.campaign = campaign;
            strategyMap.put("campaign",campaign);
            return this;
        }*/

        /**
         * Method that sets the Lead campaign.
         *
         * @param campaignLookup String with the Campaign name.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setCampaignLookup(final String campaignLookup) {
            this.campaignLookup = campaignLookup;
            strategyMap.put("campaignLookup", campaignLookup);
            return this;
        }

        /**
         * Method that sets the Lead industry.
         *
         * @param industry String with the industry data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setIndustry(final String industry) {
            this.industry = industry;
            strategyMap.put("industry", industry);
            return this;
        }

        /**
         * Method that sets the Lead Annual Revenue info.
         *
         * @param annualRevenue String with the annual revenue data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setAnnualRevenue(final String annualRevenue) {
            this.annualRevenue = annualRevenue;
            strategyMap.put("annualRevenue", annualRevenue);
            return this;
        }

        /**
         * Method that sets the Lead phone number.
         *
         * @param phone String with the phone data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setPhone(final String phone) {
            this.phone = phone;
            strategyMap.put("phone", phone);
            return this;
        }

        /**
         * Method that sets the Lead mobile number.
         *
         * @param mobile String with the phone data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setMobile(final String mobile) {
            this.mobile = mobile;
            strategyMap.put("mobile", mobile);
            return this;
        }

        /**
         * Method that sets the Lead Fax number.
         *
         * @param fax String with the fax data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setFax(final String fax) {
            this.fax = fax;
            strategyMap.put("fax", fax);
            return this;
        }

        /**
         * Method that sets the Lead Email info.
         *
         * @param email String with the email data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setEmail(final String email) {
            this.email = email;
            strategyMap.put("email", email);
            return this;
        }

        /**
         * Method that sets the Lead website.
         *
         * @param website String with the website data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setWebsite(final String website) {
            this.website = website;
            strategyMap.put("website", website);
            return this;
        }

        /**
         * Method that sets the Lead status.
         *
         * @param leadStatus String with the status data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setLeadStatus(final String leadStatus) {
            this.leadStatus = leadStatus;
            strategyMap.put("leadStatus", leadStatus);
            return this;
        }

        /**
         * Method that sets the Lead rating.
         *
         * @param rating String with the Rating data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setRating(final String rating) {
            this.rating = rating;
            strategyMap.put("rating", rating);
            return this;
        }

        /**
         * Method that sets the Lead employee number.
         *
         * @param numEmployees String with the employee data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setNumEmployees(final String numEmployees) {
            this.numEmployees = numEmployees;
            strategyMap.put("numEmployees", numEmployees);
            return this;
        }

        /**
         * Method that sets the Lead street.
         *
         * @param street String with the street data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setStreet(final String street) {
            this.street = street;
            strategyMap.put("street", street);
            return this;
        }

        /**
         * Method that sets the Lead city.
         *
         * @param city String with the city data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setCity(final String city) {
            this.city = city;
            strategyMap.put("city", city);
            return this;
        }

        /**
         * Method that sets the Lead State or Province.
         *
         * @param stateProvince String with the state/province data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setStateProvince(final String stateProvince) {
            this.stateProvince = stateProvince;
            strategyMap.put("stateProvince", stateProvince);
            return this;
        }

        /**
         * Method that sets the Lead Zip code.
         *
         * @param zipCode String with the zip code data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setZipCode(final String zipCode) {
            this.zipCode = zipCode;
            strategyMap.put("zipCode", zipCode);
            return this;
        }

        /**
         * Method that sets the Lead country.
         *
         * @param country String with the country data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setCountry(final String country) {
            this.country = country;
            strategyMap.put("country", country);
            return this;
        }

        /**
         * Method that sets the Lead product interest.
         *
         * @param productInterest String with the product interest data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setProductInterest(final String productInterest) {
            this.productInterest = productInterest;
            strategyMap.put("productInterest", productInterest);
            return this;
        }

        /**
         * Method that sets the Lead sic code.
         *
         * @param sicCode String with the sic code data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setSICCode(final String sicCode) {
            this.SICCode = sicCode;
            strategyMap.put("sicCode", sicCode);
            return this;
        }

        /**
         * Method that sets the Lead number locations.
         *
         * @param numberLocations String with the number locations data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setNumberLocations(final String numberLocations) {
            this.numberLocations = numberLocations;
            strategyMap.put("numberLocations", numberLocations);
            return this;
        }

        /**
         * Method that sets the current generators.
         *
         * @param currentGenerators String with the current generator data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setCurrentGenerators(final String currentGenerators) {
            this.currentGenerators = currentGenerators;
            strategyMap.put("currentGenerators", currentGenerators);
            return this;
        }

        /**
         * Method that sets the Lead primary.
         *
         * @param primary String with the primary data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setPrimary(final String primary) {
            this.primary = primary;
            strategyMap.put("primary", primary);
            return this;
        }

        /**
         * Method that sets the Lead description.
         *
         * @param description String with the description data.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setDescription(final String description) {
            this.description = description;
            strategyMap.put("description", description);
            return this;
        }

        /**
         * Method that sets the assign rule.
         *
         * @param assignRule String with the assign rule info.
         * @return {@link LeadBuilder}
         */
        public LeadBuilder setAssignRule(final String assignRule) {
            this.assignRule = assignRule;
            strategyMap.put("assignRule", assignRule);
            return this;
        }

        /**
         * Method that return the map with the values sent to fill the lead form.
         *
         * @return the Map with the saved values.
         */
        public Map<String, String> getStrategyMap() {
            return strategyMap;
        }

        /**
         * Method that build the Lead.
         *
         * @return {@link LeadForm}
         */
        public LeadForm build() {
            return new LeadForm(this);
        }
    }
}
