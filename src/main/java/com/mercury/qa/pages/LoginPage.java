package com.mercury.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mercury.qa.Base.TestBase;

public class LoginPage extends TestBase {
	@FindBy(name="userName")
	WebElement username;
	
    @FindBy(name="password")
    WebElement Password;
    
    @FindBy(name="login")
    WebElement loginBtn;
    
    @FindBy(xpath="//a[contains(text(),'SIGN-ON')]")
    WebElement SignUpbtn;
    
    @FindBy(css="img[src='/images/nav/logo.gif']")
    WebElement mercuryLogo;
    
    public LoginPage() {
    	PageFactory.initElements(driver, this);//initilizing the OR
    }
    public String LoginPageTitle() {
    	return driver.getTitle();
    }
    public boolean validateMercuryLogo() {
    	return mercuryLogo.isDisplayed();
    }
    public HomePage Login(String un,String pwd) {
    	username.sendKeys(un);
    	Password.sendKeys(pwd);
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();",loginBtn );
    	//loginBtn.click();
    	return new HomePage();
    }
    
}
