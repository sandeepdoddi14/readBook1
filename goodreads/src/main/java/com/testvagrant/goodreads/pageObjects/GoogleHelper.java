package com.testvagrant.goodreads.pageObjects;

import com.sample.framework.uiautomation.Utility.UtilityHelper;
import com.sample.framework.uiautomation.helper.Action.ActionHelper;
import com.sample.framework.uiautomation.helper.genericHelper.GenericHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHelper {
    private GenericHelper genericHelper;
    private WebDriver driver;
    private ActionHelper actionHelper;


    @FindBy(className = "gLFyf gsfi")
    WebElement searchBox;
    @FindBy(xpath = "/*[@id='rso']/div[1]/div[1]/div/div[1]/div/div[2]/div/div[1]/a/div/cite/span")
    WebElement recommendation1;
    @FindBy(xpath = "//*[@id='rso']/div[2]/div/div[1]/a/div/cite/span")
    WebElement recommendation2;

    public GoogleHelper(WebDriver driver) {
        this.driver=driver;
        genericHelper = PageFactory.initElements(driver, GenericHelper.class);
        actionHelper = PageFactory.initElements(driver, ActionHelper.class);
    }

    public void goToGoogle()
    {
        String url= UtilityHelper.getProperty("urls.properties","google");
        driver.get(url);
    }

    public void searchGoogle(String searchGoogle) {
        genericHelper.setElementText(searchBox, searchGoogle, "Search Google");
        actionHelper.pressEnterKey(driver);
    }




    public String getFirstRecommendation() {
        return genericHelper.getTextFromElement(recommendation1,"First Google Recommendation");

    }


}
