package framework;

import org.openqa.selenium.WebDriver;

public abstract class FrameworkBase implements FrameworkBaseInterface {

	@Override
	public WebDriver getDriver() {
		return initialize(StartUpClass.class).getDriver();
	}

	@Override
	public <T> T initialize(Class<T> clazz) {
		try {
			return clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new FrameworkException("All objects must include a default constructor.");
		}
	}

	@Override
	public Wait waitFor() {
		return new Wait(5, 50);
	}

}
