package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import support.DriverFactory;

public class QuoteForm extends Page {


    //constructor
//    public QuoteForm() {
//
//    }

    WebDriver driver = DriverFactory.getDriver();
    Actions action = new Actions(driver);

    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;
    //fill out name dialog
    @FindBy(xpath = "//input[@id='name']")
    private WebElement name;
    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@id='middleName']")
    private WebElement middleName;
    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastName;

    //password
    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;
    @FindBy(xpath = "//input[@name='confirmPassword']")
    private WebElement confirmPassword;

    @FindBy(xpath = "//button/span[text()='Save']")
    private WebElement saveButton;

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phone;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement email;

    @FindBy(xpath = "//button[@id='formSubmit']")
    private WebElement submitButton;

    @FindBy(xpath = "//input[@name='agreedToPrivacyPolicy']")
    private WebElement agreePrivacyPolicy;

    @FindBy(xpath = "//input[@id='dateOfBirth']")
    private WebElement dateOfBirthField;

    @FindBy(xpath = "//select[@class='ui-datepicker-year']")
    private WebElement selectYear;

    @FindBy(xpath = "//select[@class='ui-datepicker-month']")
    private WebElement selectMonth;

    @FindBy(xpath = "//select[@name='carMake']")
    private WebElement selectCar;

    @FindBy(xpath = "//button[@id='thirdPartyButton']")
    private WebElement thirdPartyAgreement;

    @FindBy(xpath = "//select[@name='countryOfOrigin']")
    private WebElement countryOfOrigin;

    @FindBy (xpath = "//iframe[@name='additionalInfo']")
    private WebElement additionalInfoFrame;

    @FindBy (xpath = "//input[@id='contactPersonName']")
    private WebElement contactPersonName;

    @FindBy (xpath = "//input[@id='contactPersonPhone']")
    private WebElement contactPersonPhone;

    private WebElement selectDay(String day) {

        return driver.findElement(By.xpath("(//td[@data-handler='selectDay']/a[contains(text(),'" + day + "')])[1]"));
    }

    private WebElement gender(String day) {
        return driver.findElement(By.xpath("(//td[@data-handler='selectDay']/a[contains(text(),'" + day + "')])[1]"));
    }


    public void fillName(String firstNameValue, String middleNameValue, String lastNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
        middleName.sendKeys(middleNameValue);
        lastName.sendKeys(lastNameValue);
        saveButton.click();
    }

    public void fillUsername(String usernameValue) {
        username.sendKeys(usernameValue);
    }

    public void fillPassword(String passwordValue) {
        password.sendKeys(passwordValue);
        confirmPassword.sendKeys(passwordValue);
    }

    public void checkPrivacyPolicy() {
        if (!agreePrivacyPolicy.isSelected()) {
            agreePrivacyPolicy.click();
        }
    }

    public void submit() {
        submitButton.click();
    }

    public void selectDateOfBirth(String year, String month, String day) {
        dateOfBirthField.click();
        selectByVisibleText(selectYear, year);
        selectByVisibleText(selectMonth, month);
        // selectByVisibleText(selectDay, day);
        selectDay(day).click();
    }


    public void fillEmail(String emailText) {
        email.sendKeys(emailText);
    }
    public void fillphone(String phoneText) {
        phone.sendKeys(phoneText);
    }
    public WebElement checkGender(String yourGender) {
        String gender = String.format("//input[@value='%s']", yourGender);
        return getByXpath(gender);
    }
    public void selectTwoCarMakers(String car1, String car2) {
        action.keyDown(Keys.COMMAND)
                .click(getByXpath("//option[@value='" + car1 + "']"))
                .click(getByXpath("//option[@value='" + car2 + "']"))
                .keyUp(Keys.COMMAND)             // Release the Command key
                .build().perform();
    }
    public void acceptAgreement() {
        thirdPartyAgreement.click();
        driver.switchTo().alert().accept();
    }
    public void selectCountryOfOrigin(String country) {
        selectByVisibleText(countryOfOrigin, country);
    }
    public void fillAdditionalInform(String name, String phone){
        switchToIframe(additionalInfoFrame);
        contactPersonName.sendKeys(name);
        contactPersonPhone.sendKeys(phone);
        switchToDefaultContent();
    }



}
