package com.solvd.seleniumonliner;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.seleniumonliner.page.CatalogPage;
import com.solvd.seleniumonliner.page.ResultSearchPage;
import com.solvd.seleniumonliner.page.components.CatalogBarLink;
import com.solvd.seleniumonliner.page.components.ResultSearchBlock;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.IntStream;

public class CatalogOnlinerWebTest implements IAbstractTest {

    private static final Logger LOGGER = LogManager.getLogger(CatalogOnlinerWebTest.class);

    @Test
    public void weatherWidgetTest() {

        CatalogPage catalogPage = new CatalogPage(getDriver());
        catalogPage.open();
        String temperature = catalogPage.getWeatherWidget().getWeatherTemp();
        int temperatureInt = Integer.parseInt(temperature);
        Assert.assertTrue(-35 < temperatureInt && temperatureInt < 45);
    }

    @Test
    public void currencyWidgetTest() {

        CatalogPage catalogPage = new CatalogPage(getDriver());
        catalogPage.open();
        String currencyScore = catalogPage.getCurrencyWidget().getCurrencyScore();

        String regex = "[^0-9,]";

        currencyScore = currencyScore.replaceAll(regex, "");
        currencyScore = currencyScore.replaceAll("[,]",".");
        double currencyDouble = Double.parseDouble(currencyScore);
        Assert.assertTrue(1 < currencyDouble && currencyDouble < 10);
    }

    @Test
    public void searchInputTest() {
        CatalogPage catalogPage = new CatalogPage(getDriver());
        catalogPage.open();
        catalogPage.getSearchInput().type("Cannondale");
        ResultSearchPage resultSearchPage = new ResultSearchPage(getDriver());
        resultSearchPage.getResultSearchBlocks()
                .forEach(resultSearchBlock -> LOGGER.debug(resultSearchBlock.getTitleT().getText()));

        List<String> titleList = List.of(
                "Велосипед Cannondale Trail 29 6 (2014)","Велосипед Cannondale Trail 5 29 (черный/желтый, 2017)",
                "Гравел Cannondale Topstone Sora XL 2020", "Велосипед Cannondale Trail 5 29 (красный, 2019)"
        );

        List<ResultSearchBlock> res = resultSearchPage.getResultSearchBlocks();

        IntStream.range(0,res.size()).forEach(index ->
                Assert.assertEquals(
                        res.get(index).getTitleT(), titleList.get(index)));
    }

    @Test
    public void catalogBarLinkTest() {
        CatalogPage catalogPage = new CatalogPage(getDriver());
        catalogPage.open();
        List<CatalogBarLink> catalogBarLinks = catalogPage.getCatalogBarLink();
        catalogBarLinks.forEach(catalogBarLink -> LOGGER.debug(catalogBarLink.getName().length()));
        Assert.assertEquals(catalogBarLinks.size(), 10);
        Assert.assertFalse(catalogBarLinks.isEmpty());
    }

}
