package com.testvagrant.goodreads.pageObjects;

import com.sample.framework.uiautomation.Utility.UtilityHelper;
import com.sample.framework.uiautomation.base.TestBase;
import com.sample.framework.uiautomation.helper.Wait.WaitHelper;
import com.sample.framework.uiautomation.helper.genericHelper.GenericHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends TestBase {
    private GenericHelper genericHelper;
    private WebDriver driver;
    @FindBy(xpath = "//*[@id='search_query_main']")
    WebElement searchBox;
    @FindBy(xpath = "/html/body/div[2]/div[3]/div[1]/div[1]/div[2]/form/div[1]/input[3]")
    WebElement submitSearchButton;
    @FindBy(xpath = "/html/body/div[2]/div[3]/div[1]/div[2]/div[2]/table/tbody/tr")
    List<WebElement> books;

    public SearchPage(WebDriver driver) {
        this.driver=driver;
        genericHelper = new GenericHelper(driver);
    }

    public void searchBook(String bookName) {

        genericHelper.setElementText(searchBox, bookName, "Search Book");
        genericHelper.setElementText(searchBox, bookName, "Search Book");
        genericHelper.elementClick(submitSearchButton, "Search Book Button");
    }

    public String getFirstBookLink() {
        return books.get(0).findElement(By.tagName("a")).getAttribute("href");
    }


    public String getFirstBookName() {
        return books.get(0).getText();
    }


    public void navigateToSearchPage() {
        String url = new UtilityHelper().getProperty("urls", "searchPage");
        genericHelper.navigateTo(url);
    }

    public searchParams checkType(String string) {
        if(string.equals(searchParams.valueOf("YEAR")))
            return  searchParams.YEAR;

        if(string.equals(searchParams.valueOf("AUTHOR")))
            return  searchParams.AUTHOR;

        if(string.equals(searchParams.valueOf("PLOT")))
            return  searchParams.PLOT;

        if(string.equals(searchParams.valueOf("TRIVIA")))
            return  searchParams.TRIVIA;

        if(string.equals(searchParams.valueOf("QUOTE")))
            return  searchParams.QUOTE;


        return null;
    }


    public enum searchParams {
        YEAR("year"),
        PLOT("plot"),
        AUTHOR("author"),
        TRIVIA("trivia"),
        QUOTE("quote");

        public final String s;
        searchParams(String s) {
            this.s = s;

        }

    }

}





