package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


import pageobject.LoginPage;

public class StartUpClass extends FrameworkBase {

	public static WebDriver driver;
	public LoginPage loginPage;

	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Override
	public WebDriver getDriver() {
		return driver;
	}

	public <T extends PageObjectBase> T goToWebsite(String url, Class<T> clazz) {
		getDriver().get(url);
		T c = initialize(clazz);
		waitFor().checkLoaded(c.getLoadedConditions());
		System.out.println(c.getClass().getSimpleName() + " is loaded successfully");
		return PageFactory.initElements(getDriver(), clazz);

	}

}
