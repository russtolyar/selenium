package com.solvd.seleniumonliner.page.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CatalogBarLink extends AbstractUIObject {

    @FindBy(xpath = ".//*[contains(@class,'bar__link ')]")
    private ExtendedWebElement element;

    public CatalogBarLink(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getElement() {
        return element.getText();
    }
}
