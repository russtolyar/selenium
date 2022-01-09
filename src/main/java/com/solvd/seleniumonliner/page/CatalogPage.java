package com.solvd.seleniumonliner.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.seleniumonliner.page.components.CatalogBarLink;
import com.solvd.seleniumonliner.page.components.CurrencyWidget;
import com.solvd.seleniumonliner.page.components.WeatherWidget;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CatalogPage extends AbstractPage {

    @FindBy(xpath = "//*[contains(@class, 'top-informer-weather')]")
    private WeatherWidget weatherWidget;

    @FindBy(xpath = "//*[contains(@class,'top-informer-currency ')]")
    private CurrencyWidget currencyWidget;

    @FindBy(xpath = "//*[contains(@class,'fast-search__input')]")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = "//*[contains(@class,'catalog-bar__item')]")
    private List<CatalogBarLink> catalogBarLinks;

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public WeatherWidget getWeatherWidget() {
        return weatherWidget;
    }

    public CurrencyWidget getCurrencyWidget() {
        return currencyWidget;
    }

    public ExtendedWebElement getSearchInput(){
        return searchInput;
    }

    public List<CatalogBarLink> getCatalogBarLink(){ return catalogBarLinks;}

}
