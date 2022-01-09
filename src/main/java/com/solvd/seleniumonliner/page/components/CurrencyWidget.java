package com.solvd.seleniumonliner.page.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CurrencyWidget extends AbstractUIObject {

    @FindBy(xpath = ".//span")
    private ExtendedWebElement currencyScore;

    public CurrencyWidget(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    public String getCurrencyScore(){
        return currencyScore.getText();
    }
}
