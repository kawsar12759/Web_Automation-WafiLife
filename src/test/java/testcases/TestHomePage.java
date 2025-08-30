package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.DriverSetup;

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
}
