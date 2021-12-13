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

public class ComposeEmailPage extends PageObjectBase {

	@FindBy(xpath = "//div[@class='T-I T-I-KE L3']")
	private WebElement composeButton;

	@FindBy(xpath = "//textarea[@name='to']")
	private WebElement emailTo;

	@FindBy(xpath = "//input[@name='subjectbox']")
	private WebElement subject;

	@FindBy(xpath = "//div[@class='Am Al editable LW-avf tS-tW']")
	private WebElement emailBody;

	@FindBy(xpath = "//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']")
	private WebElement sendButton;

	@Override
	public List<ExpectedCondition<?>> getLoadedConditions() {
		return Arrays.<ExpectedCondition<?>> asList(ExpectedConditions.titleContains("seltestmail1@gmail.com"),
				ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@class='Am Al editable LW-avf tS-tW']")));
	}

	public void clickCompose() {
		composeButton.click();
		getDriver().switchTo().frame(0);
		waitFor().baseWaiter().until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Send']")));
	}
	
	public WebElement getEmailTo() {
		return emailTo;
	}

	public void setEmailTo(String emailTo) {
		getEmailTo().sendKeys(emailTo);
	}

	public WebElement getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		getSubject().sendKeys(subject);
	}

	public WebElement getEmailBody() {
		return emailBody;
	}

	public void setEmailBody(String emailBody) {
		getEmailBody().sendKeys(emailBody);
	}
	
	public void clickSend() {
		sendButton.click();
		waitFor().baseWaiter().until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[@class='bAq']")));
	}

	public void verifyEmailSent() {
		waitFor().baseWaiter().until(ExpectedConditions
		.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Message sent')]")));
		WebElement element = getDriver()
				.findElement(By.xpath("//span[@class='bAq']"));
		Assert.assertEquals("Message has been sent Successfully!", element.getText().trim(), "Message sent");
		
	}
}
