package pageobject;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import framework.PageObjectBase;

public class LoginPage extends PageObjectBase {

	@FindBy(xpath = "//input[@id='identifierId']")
	private WebElement email;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;

	@FindBy(xpath = "//div[@id='identifierNext']")
	private WebElement emailnext;
	
	@FindBy(xpath = "//div[@id='passwordNext']")
	private WebElement pswdnext;

	@FindBy(xpath = "//div[@class='T-I T-I-KE L3']")
	private WebElement composeButton;	

	@Override
	public List<ExpectedCondition<?>> getLoadedConditions() {
		return Arrays.<ExpectedCondition<?>> asList(ExpectedConditions.titleIs("Gmail"),
				ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@class='xkfVF']")));
	}
	

	public WebElement getEmail() {
		return email;
	}

	public void setEmail(String email) {
		getEmail().sendKeys(email);
	}

	public WebElement getPassword() {
		return password;
	}

	public void setPassword(String password) {
		getPassword().sendKeys(password);
	}

	public WebElement getemailNext() {
		return emailnext;
	}
	
	public void clickemailNext() {
		getemailNext().click();
	}
	
	public WebElement getpswdNext() {
		return pswdnext;
	}

	public void clickpswdNext() {
		getpswdNext().click();
	}

	public void verifyLoginSuccessful() {
		waitFor().baseWaiter().until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//img[@class='gb_Ca gbii']")));
		WebElement element = getDriver()
				.findElement(By.xpath("//a[contains(text(),'Inbox')]"));
		Assert.assertEquals("User Logged In Successfully", element.getText().trim(),"Inbox");

		}

	public ComposeEmailPage goToComposeEmailPage() {
		return newPage(ComposeEmailPage.class, composeButton);
	}
	
}
