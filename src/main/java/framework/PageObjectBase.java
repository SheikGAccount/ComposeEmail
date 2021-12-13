package framework;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;

public abstract class PageObjectBase extends FrameworkBase {

	public abstract List<ExpectedCondition<?>> getLoadedConditions();

	public <T extends PageObjectBase> T newPage(Class<T> pageClass, WebElement element) {
		element.click();
		T c = initialize(pageClass);
		waitFor().checkLoaded(c.getLoadedConditions());
		System.out.println(c.getClass().getSimpleName() + " is loaded successfully");
		return PageFactory.initElements(getDriver(), pageClass);
	}

	public <T extends PageObjectBase> T newPage(Class<T> pageClass) {
		T c = initialize(pageClass);
		waitFor().checkLoaded(c.getLoadedConditions());
		System.out.println(c.getClass().getSimpleName() + " is loaded successfully");
		return PageFactory.initElements(getDriver(), pageClass);
	}

	public Select getDropDown(WebElement element) {
		return new Select(element);
	}

}
