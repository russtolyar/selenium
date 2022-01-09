package com.solvd.seleniumonliner.page.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ResultSearchBlock extends AbstractUIObject {

    @FindBy(xpath = "//a[contains(@class,'product__title-link')]")
    private ExtendedWebElement titleT;

    public ResultSearchBlock(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getTitleT() {
        return titleT;
    }
}
