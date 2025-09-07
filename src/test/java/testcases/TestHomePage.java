package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.Dataset;
import utilities.DriverSetup;

import java.time.Duration;
import java.util.List;

public class TestHomePage extends DriverSetup {
    HomePage homePage = new HomePage();
    @Test
    public void testBanner(){
        homePage.loadPage(homePage.url);
        List<WebElement> navigators = homePage.getMultipleElements(homePage.bannerNavigators);
        int dot_index=1;
        int count=0;
        for(WebElement navigator : navigators){
            if(dot_index==navigators.size()){
                homePage.clickOnElement(By.xpath("//div[@class=\"owl-dot\"][last()]"));
            }
            else{homePage.clickOnElement(homePage.getBannerNavigationDot(dot_index));}

            String currentImg = homePage.getAttributeValue(homePage.activeBannerImageDiv,"src");
            Assert.assertEquals(currentImg,homePage.exectedBannerImage.get(count));
            count++;
            dot_index++;
        }

    }

    @Test(dataProvider = "homePageCategories", dataProviderClass = Dataset.class)
    public void testCategorySection(int categoryNum, String categoryName,String buttonText, String categorySubPageTitle,  String categoryAllProductsPageLink) throws InterruptedException {
        homePage.loadPage(homePage.url);
        new Actions(getDriver()).scrollToElement(homePage.getElement(homePage.getCategorySection(categoryNum))).build().perform();
        Assert.assertEquals(homePage.getElementText(homePage.getCategorySectionHeading(categoryNum)),categoryName);
        Assert.assertEquals(homePage.getElementText(homePage.getCategorySectionButton(categoryNum)),buttonText);
        homePage.clickOnElement(homePage.getCategorySectionButton(categoryNum));
        Assert.assertEquals(homePage.getURL(),categoryAllProductsPageLink);
        Assert.assertEquals(homePage.getElementText(homePage.categorySubPageTitle),categorySubPageTitle);
        getDriver().navigate().back();
        new Actions(getDriver()).scrollToElement(homePage.getElement(homePage.getCategorySection(categoryNum))).build().perform();
        String productName = homePage.getElementText(homePage.getCategoryActiveFirstProductTitle(categoryNum));
        String productAuthor = homePage.getElementText(homePage.getCategoryActiveFirstProductAuthor(categoryNum));
        homePage.clickOnElement(homePage.getCategorySectionNextButton(categoryNum));
        Thread.sleep(1000);
        Assert.assertNotEquals(homePage.getCategoryActiveFirstProductTitle(categoryNum),productName);
        homePage.clickOnElement(homePage.getCategorySectionPrevButton(categoryNum));
        Thread.sleep(1000);
        Assert.assertEquals(homePage.getElementText(homePage.getCategoryActiveFirstProductTitle(categoryNum)),productName);
        Assert.assertEquals(homePage.getElementText(homePage.getCategoryActiveFirstProductAuthor(categoryNum)),productAuthor);
        homePage.clickOnElement(homePage.getCategoryActiveFirstProduct(categoryNum));
        Assert.assertEquals(homePage.getElementText(homePage.firstProductDetailsTitle),productName);
        Assert.assertEquals(homePage.getElementText(homePage.firstProductDetailsAuthor),productAuthor);


    }


}


