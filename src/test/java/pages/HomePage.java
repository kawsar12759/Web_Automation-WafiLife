package pages;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePage extends BasePage {
    public String url = "https://www.wafilife.com/";

    public By getBannerDiv(int num) {
        return By.xpath("//div[@class=\"owl-item\"][" + num + "]//a//img");
    }

    public By getBannerNavigationDot(int num) {
        return By.xpath("//div[@class=\"owl-dot\"][" + num + "]");
    }

    public List<String> exectedBannerImage = new ArrayList<>(Arrays.asList("https://wafilife-media.wafilife.com/uploads/2025/08/Desktop-1.jpg",
            "https://wafilife-media.wafilife.com/uploads/2025/08/Desktop_24.jpg",
            "https://wafilife-media.wafilife.com/uploads/2025/08/Desktop_old.jpg",
            "https://wafilife-media.wafilife.com/uploads/2025/07/313_desk.jpg",
            "https://wafilife-media.wafilife.com/uploads/2025/06/survey_Desktop.jpg",
            "https://wafilife-media.wafilife.com/uploads/2025/06/%E0%A6%9A%E0%A6%B2%E0%A6%AE%E0%A6%BE%E0%A6%A8-%E0%A6%AC%E0%A6%BF%E0%A6%B6%E0%A7%8D%E0%A6%AC-%E0%A6%AC%E0%A7%8D%E0%A6%AF%E0%A6%AC%E0%A6%B8%E0%A7%8D%E0%A6%A5%E0%A6%BE%E0%A6%B0-%E0%A6%B2%E0%A6%A1%E0%A6%BC%E0%A6%BE%E0%A6%87%E0%A6%AF%E0%A6%BC%E0%A7%87-%E0%A6%B6%E0%A6%BE%E0%A6%87%E0%A6%96-%E0%A6%B9%E0%A6%BE%E0%A6%B0%E0%A7%81%E0%A6%A8-%E0%A6%87%E0%A6%9C%E0%A6%B9%E0%A6%BE%E0%A6%B0-%E0%A6%B9%E0%A6%BE%E0%A6%AB%E0%A6%BF.jpg",
            "https://wafilife-media.wafilife.com/uploads/2025/03/Ek-nojore-Quran_Desktop.jpg",
            "https://wafilife-media.wafilife.com/uploads/2025/03/sokher-khata-_notebook_Desktop.jpg",
            "https://wafilife-media.wafilife.com/uploads/2025/02/umra-dua-card_Desktop.jpg"));

    public Object[][] bannerImageAndLink = {
            {"https://wafilife-media.wafilife.com/uploads/2025/08/Desktop-1.jpg","https://www.wafilife.com/cat/books/publisher/sean-publication"},
            {"https://wafilife-media.wafilife.com/uploads/2025/08/Desktop_24.jpg","https://www.wafilife.com/cat/books/publisher/muhammod-publication"},
            {"https://wafilife-media.wafilife.com/uploads/2025/08/Desktop_old.jpg","https://www.wafilife.com/cat/brands/rongdhonu?wpsolr_sort=discount_desc"},
            {"https://wafilife-media.wafilife.com/uploads/2025/07/313_desk.jpg","https://www.wafilife.com/313-mashayekhe-bangladesh-2-part/dp/1325219"},
            {"https://wafilife-media.wafilife.com/uploads/2025/06/survey_Desktop.jpg","https://docs.google.com/forms/d/e/1FAIpQLSe2rjO6bnYm7Z42Am13d4J-xObxwLe8W4RiMZxgkUJjLP_CaA/viewform"},
            {"https://wafilife-media.wafilife.com/uploads/2025/06/%E0%A6%9A%E0%A6%B2%E0%A6%AE%E0%A6%BE%E0%A6%A8-%E0%A6%AC%E0%A6%BF%E0%A6%B6%E0%A7%8D%E0%A6%AC-%E0%A6%AC%E0%A7%8D%E0%A6%AF%E0%A6%AC%E0%A6%B8%E0%A7%8D%E0%A6%A5%E0%A6%BE%E0%A6%B0-%E0%A6%B2%E0%A6%A1%E0%A6%BC%E0%A6%BE%E0%A6%87%E0%A6%AF%E0%A6%BC%E0%A7%87-%E0%A6%B6%E0%A6%BE%E0%A6%87%E0%A6%96-%E0%A6%B9%E0%A6%BE%E0%A6%B0%E0%A7%81%E0%A6%A8-%E0%A6%87%E0%A6%9C%E0%A6%B9%E0%A6%BE%E0%A6%B0-%E0%A6%B9%E0%A6%BE%E0%A6%AB%E0%A6%BF.jpg","https://www.wafilife.com/cat/books/subject/choloman-bishwo-bebosthar-loraiye-shykh-harun-izhar-hafi-er-moulik-boiyer-syllebus"
            },
            {"https://wafilife-media.wafilife.com/uploads/2025/03/Ek-nojore-Quran_Desktop.jpg","https://www.wafilife.com/ek-nojore-quran/dp/1215094"},
            {"https://wafilife-media.wafilife.com/uploads/2025/03/sokher-khata-_notebook_Desktop.jpg","https://www.wafilife.com/cat/books/subject/sokher-khata"},
            {"https://wafilife-media.wafilife.com/uploads/2025/02/umra-dua-card_Desktop.jpg","https://www.wafilife.com/umrah-dua-card/dp/1232961"}
    };

    public By bannerNavigators = By.xpath("//div[@class=\"owl-dots\"]/*");
    public By activeBannerImageDiv = By.xpath("//div[@class=\"owl-item active\"]//a//img");

}
