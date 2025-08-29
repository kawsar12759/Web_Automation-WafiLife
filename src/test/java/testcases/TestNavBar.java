package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginRegistrationPage;
import pages.NavBar;
import utilities.Dataset;
import utilities.DriverSetup;

import java.util.ArrayList;
import java.util.List;

public class TestNavBar extends DriverSetup {
    NavBar navbar = new NavBar();
    @Test
    public void testNavBarLogo(){
        navbar.loadPage(navbar.url);
        String logo_url=navbar.getAttributeValue(navbar.logo,"src");
        Assert.assertEquals(logo_url,navbar.logo_url);
    }
    @Test
    public void testSearchbarAndButtonBasicFunctionality(){
        navbar.loadPage(navbar.url);
        Assert.assertTrue(navbar.displayState(navbar.search_input));
        Assert.assertEquals(navbar.getAttributeValue(navbar.search_input,"placeholder"),navbar.search_input_placeholder);
        Assert.assertTrue(navbar.displayState(navbar.search_btn));
        Assert.assertEquals(navbar.getCSSValue(navbar.search_btn,"background-color"),"rgba(242, 148, 52, 1)");
        navbar.writeOnElement(navbar.search_input,"Around the world");
        Assert.assertTrue(navbar.elementDisplayState(navbar.waitForElementVisible(navbar.search_results_ui)));
    }
    @Test(dataProvider = "validBooksAndAuthorName" , dataProviderClass = Dataset.class)
    public void testSearchWithValidKeywords(String keyword, List<String> expectedBooks){
        navbar.loadPage(navbar.url);
        navbar.writeOnElement(navbar.search_input,keyword);
        Assert.assertTrue(navbar.elementDisplayState(navbar.waitForElementVisible(navbar.search_results_ui)));
        List<WebElement> searchedBooksElements = navbar.getMultipleElements(navbar.search_result_container_div);
        List<String> actualBooks = new ArrayList<>();
        for(WebElement searchedBookElement : searchedBooksElements){
            String text = navbar.getElementTextUsingElement(searchedBookElement);
            text = text.replace("\n", " ").trim();
            actualBooks.add(text);
        }
        Assert.assertEquals(expectedBooks, actualBooks);

    }


    @Test
    public void testSearchWithInvalidKeywords(){
        navbar.loadPage(navbar.url);
        navbar.writeOnElement(navbar.search_input,"Xyz");
        Assert.assertFalse(navbar.elementDisplayState(navbar.waitForElementVisible(navbar.search_results_ui)));
    }

    @Test
    public void testLoginAndWishlistLink(){
        navbar.loadPage(navbar.url);
        navbar.waitForElementVisible(navbar.login_or_register);
        Assert.assertEquals(navbar.getElementText(navbar.wishlist_and_login_register),"উইশ লিস্ট | লগইন / রেজিস্টার");
        navbar.clickOnElement(navbar.login_or_register);
        String currentURL = navbar.getURL();
        LoginRegistrationPage loginRegistrationPage = new LoginRegistrationPage();
        Assert.assertEquals(currentURL,loginRegistrationPage.url);
        loginRegistrationPage.writeOnElement(loginRegistrationPage.login_username_or_userEmail_input,loginRegistrationPage.user_name);
        loginRegistrationPage.writeOnElement(loginRegistrationPage.login_password_input,loginRegistrationPage.password);
        loginRegistrationPage.clickOnElement(loginRegistrationPage.login_btn);
        Assert.assertEquals(loginRegistrationPage.getElementText(loginRegistrationPage.login_success_display),loginRegistrationPage.login_success_message);
        navbar.clickOnElement(navbar.wishlist);
        currentURL = navbar.getURL();
        Assert.assertEquals(currentURL,navbar.wishlist_link);
    }

    @Test
    public void testLoggedOutUserCannotAccessWishlist(){
        navbar.loadPage(navbar.url);
        navbar.clickOnElement(navbar.wishlist);
        String currentURL = navbar.getURL();
        Assert.assertEquals(currentURL,"https://www.wafilife.com/my-account?tinvwl_redirect=https%3A%2F%2Fwww.wafilife.com%2Fwishlist");
    }

    @Test(dataProvider = "categoryNames", dataProviderClass = Dataset.class)
    public void testCategories(String expectedCategoryName, String expectedURL){
        navbar.loadPage(navbar.url);
        Assert.assertEquals(navbar.getElementText(navbar.getCategory(expectedCategoryName)),expectedCategoryName);
        navbar.clickOnElement(navbar.getCategory(expectedCategoryName));
        String url = navbar.getURL();
        Assert.assertEquals(url,expectedURL);
    }

}
