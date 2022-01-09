package com.solvd.seleniumonliner.page;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.seleniumonliner.page.components.ResultSearchBlock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultSearchPage extends AbstractPage {

    @FindBy(xpath = "//*[contains(@class,'search__content-wrapper')]")
    private List<ResultSearchBlock> resultSearchBlocks;

    public ResultSearchPage(WebDriver driver) {
        super(driver);
    }

    public List<ResultSearchBlock> getResultSearchBlocks() {
        return resultSearchBlocks;
    }
}
