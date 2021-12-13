package framework;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;

public class Wait extends FrameworkBase {

	private final int timeout;
	private final int pollingInterval;

	public Wait(int pollTime, int timeOut) {
		timeout = timeOut;
		pollingInterval = pollTime;
	}

	public FluentWait<WebDriver> baseWaiter() {
		FluentWait<WebDriver> waiter = new FluentWait<WebDriver>(getDriver()).pollingEvery(pollingInterval, TimeUnit.SECONDS).withTimeout(timeout, TimeUnit.SECONDS);
		return waiter;
	}
	
	public void checkLoaded(List<ExpectedCondition<?>> loadedConditions) {
		for (ExpectedCondition<?> ec : loadedConditions) {
			waitFor().baseWaiter().until(ec);
		}
	}
}
