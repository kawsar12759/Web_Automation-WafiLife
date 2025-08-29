package pages;

import org.openqa.selenium.By;

public class NavBar extends BasePage{
    public String url = "https://www.wafilife.com/";


    public By logo = By.xpath("//div[@class='logo heading-title']//a//img");
    public String logo_url = "https://wafilife-media.wafilife.com/uploads/2022/03/logo-v22.png";

    public By wishlist = By.xpath("//a[contains(text(),'উইশ লিস্ট')]");
    public By login_or_register = By.xpath("//a[@title='আমার অ্যাকাউন্ট'][contains(text(),'লগইন / রেজিস্টার')]");
    public By wishlist_and_login_register = By.xpath("//div[@class='login-links']");
    public String wishlist_link = "https://www.wafilife.com/wishlist";

    public By search_input = By.xpath("//div[@class='header_search']//input[@id='freeSearchBoxWeb']");
    public String search_input_placeholder = "বইয়ের নাম ও লেখক দিয়ে অনুসন্ধান করুন";
    public By search_btn = By.xpath("//div[@class='header_search']//button[@type='submit']");
    public By search_results_ui = By.xpath("//ul[@id='ui-id-1']");
    public By search_result_container_div = By.xpath("//ul[@id='ui-id-1']//div[@class='solr-content']");

    public By getCategory(String category){
        return By.xpath("//ul[@id='menu-main-menu-1']//a[span[@class='menu-label-level-0' and normalize-space(text())='" + category + "']]");
    }
}
