package framework;

import org.openqa.selenium.WebDriver;

public interface FrameworkBaseInterface {

	WebDriver getDriver();
	
	<T> T initialize(Class<T> clazz);
	
	Wait waitFor();
	
}
