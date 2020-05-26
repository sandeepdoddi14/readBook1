package com.testvagrant.goodreads;

import com.sample.framework.uiautomation.DataProvider.TestDataProvider;
import com.sample.framework.uiautomation.base.TestBase;
import com.sample.framework.uiautomation.helper.genericHelper.GenericHelper;
import com.testvagrant.goodreads.pageObjects.GoogleHelper;
import com.testvagrant.goodreads.pageObjects.LoginPage;
import com.testvagrant.goodreads.pageObjects.SearchPage;
import com.testvagrant.goodreads.pageObjects.SignInModal;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

public class WhatsTheBookName extends TestBase {
    LoginPage loginPage;
    SignInModal signInModal;
    SearchPage searchPage;
    GoogleHelper googleHelper;
    GenericHelper genericHelper;
    String bookName;

    @BeforeClass
    public void setup() {
        ms.getDataFromMasterSheet(this.getClass().getName());
    }

    @BeforeMethod
    public void initializeObjects() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        signInModal = PageFactory.initElements(driver, SignInModal.class);
        searchPage = PageFactory.initElements(driver, SearchPage.class);
        googleHelper = PageFactory.initElements(driver, GoogleHelper.class);
    }


    @Test(dataProvider = "TestRuns", dataProviderClass = TestDataProvider.class)
    public void whatsTheBookName(HashMap<String, String> searchParam) throws Exception {
        String dsata = "the therapist";
        loginPage.loginAsGuestOrUser();
        signInModal.closeIfModalIsPresent();

        genericHelper.openNewTab();

        googleHelper.goToGoogle();
        googleHelper.searchGoogle(dsata);
        bookName = googleHelper.getFirstRecommendation();

        genericHelper.closeTab();

        searchPage.navigateToSearchPage();
        searchPage.searchBook(bookName);
        System.out.println(searchPage.getFirstBookName());
        System.out.println(searchPage.getFirstBookLink());


    }


}
