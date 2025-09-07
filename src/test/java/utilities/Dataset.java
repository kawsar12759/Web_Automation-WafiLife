package utilities;

import org.testng.annotations.DataProvider;
import pages.LoginRegistrationPage;

import java.util.Arrays;

public class Dataset {



    @DataProvider(name="validLoginCredentials")
    public static Object[][] validLoginCredentials(){
        LoginRegistrationPage loginRegistrationPage = new LoginRegistrationPage();
        return new Object[][]{
                {loginRegistrationPage.user_name, loginRegistrationPage.password},
                {loginRegistrationPage.user_email,loginRegistrationPage.password}
        };
    }
    @DataProvider(name="invalidLoginCredentials")
    public static Object[][] invalidLoginCredentials(){
        LoginRegistrationPage loginRegistrationPage = new LoginRegistrationPage();
        return new Object[][]{
                {loginRegistrationPage.user_name, "password",loginRegistrationPage.invalid_password_for_username_errorText},
                {loginRegistrationPage.invalid_user_name,loginRegistrationPage.password, loginRegistrationPage.invalid_username_errorText},
                {loginRegistrationPage.user_email, "password",loginRegistrationPage.invalid_password_for_userEmail_errorText},
                {loginRegistrationPage.invalid_user_email,loginRegistrationPage.password,loginRegistrationPage.invalid_userEmail_errorText},
                {"",loginRegistrationPage.password,loginRegistrationPage.empty_username_field_errorText},
                {loginRegistrationPage.user_name,"",loginRegistrationPage.empty_password_field_errorText},
                {"","",loginRegistrationPage.empty_username_field_errorText}
        };
    }

    @DataProvider(name="invalidRegistrationCredentials")
    public static Object[][] invalidRegistrationCredentials(){
        LoginRegistrationPage loginRegistrationPage = new LoginRegistrationPage();
        return new Object[][]{
                {"","01528192901","testing1@gmail.com", "password","password",loginRegistrationPage.registration_empty_name_field_errorText},
                {"","","testing1@gmail.com", "password","password",loginRegistrationPage.registration_empty_name_field_errorText},
                {"","","", "password","password",loginRegistrationPage.registration_empty_or_invalid_email_field_errorText},
                {"","","", "","password",loginRegistrationPage.registration_empty_or_invalid_email_field_errorText},
                {"","","", "","",loginRegistrationPage.registration_empty_or_invalid_email_field_errorText},
                {"testing12345","","testing1@gmail.com", "password","password",loginRegistrationPage.registration_empty_phoneNumber_field_errorText},
                {"testing12345","01528192901","", "password","password",loginRegistrationPage.registration_empty_or_invalid_email_field_errorText},
                {"testing12345","01528192901","testing1@gmail.com", "","password",loginRegistrationPage.registration_empty_password_field_errorText},
                {"testing12345","01528192901","testing1@gmail.com", "password","",loginRegistrationPage.registration_empty_or_password_mismatch_errorText},

        };
    }
    @DataProvider(name = "validBooksAndAuthorName")
    public static Object[][] validBooksAndAuthorName(){
        return new Object[][]{
                {"Remember", Arrays.asList(
                        "Those Who Remember Allah Have Surpassed Others দারুস সালাম",
                        "এ প্রিন্সেস রিমেম্বার্স (A Prices Remembers) গায়ত্রী দেবী | ঐতিহ্য",
                        "Let Us Remember Allah and Praise Him আব্দুর রাহমান দিমাস্কী | আই আই পি এইচ"
                )},
                {"নিবিড়", Arrays.asList(
                        "নিবিড় গণিত (Nibir Gonit) চমক হাসান | আদর্শ",
                        "হাসান আজিজুল হক : নিবিড় অবলোকন (Hasan Azizul Haque Nibir Abolokon) কথাপ্রকাশ",
                        "অনুধ্যানে নিবিড় পাঠ ও অন্যান্য (Anodhyane Nibir Path O Anyanyo) নাহার আলম | অনুপ্রাণন প্রকাশন",
                        "শৈশব-কৈশোরে গণিতের মুখোমুখি (Shoishob Koishore Goniter Mukhomukhi) মোহাম্মদ শাহরিয়ার | অনিন্দ্য প্রকাশ",
                        "শৈশব-কৈশোরে গণিত ও পদার্থবিজ্ঞানের মুখোমুখি (Shoishob Koishore Gonit O Podarrthobigganer Mukhomukhi) মোহাম্মদ শাহরিয়ার | অনিন্দ্য প্রকাশ"
                )},

        };


    }

    @DataProvider(name = "categoryNames")
    public static Object[][] categoryNames(){
        return new Object[][]{
                {"হোম","https://www.wafilife.com/"},
                {"জেনারেল বই","https://www.wafilife.com/general-books"},
                {"একাডেমিক","https://www.wafilife.com/academic-books"},
                {"আরবি বই","https://www.wafilife.com/arabic-books"},
                {"বিষয়","https://www.wafilife.com/cat/books/subject"},
                {"লেখক","https://www.wafilife.com/cat/books/author"},
                {"প্রকাশক","https://www.wafilife.com/cat/books/publisher"},
                {"বইমেলা ২০২৫","https://www.wafilife.com/online-book-fair"},
                {"প্রি-অর্ডার","https://www.wafilife.com/preorder"},
                {"লাইফস্টাইল","https://www.wafilife.com/lifestyle-products"},
                {"স্টেশনারী","https://www.wafilife.com/cat/products/stationary-item"}
        };
    }
    @DataProvider(name="homePageCategories")
    public static Object[][] homePageCategories(){
        return new Object[][]{
                {1,"নতুন প্রকাশিত বই","সকল নতুন প্রকাশিত বই","নতুন প্রকাশিত বই","https://www.wafilife.com/cat/home-product/%E0%A6%A8%E0%A6%A4%E0%A7%81%E0%A6%A8-%E0%A6%AA%E0%A7%8D%E0%A6%B0%E0%A6%95%E0%A6%BE%E0%A6%B6%E0%A6%BF%E0%A6%A4-%E0%A6%AC%E0%A6%87"},
                {2,"ট্রেন্ডিং বইসমূহ","সকল ট্রেন্ডিং বই","ট্রেন্ডিং বইসমূহ","https://www.wafilife.com/cat/home-product/trending-books"},
                {3,"সিয়ান যুগপূর্তি অফার","সকল বই","সিয়ান পাবলিকেশন","https://www.wafilife.com/cat/books/publisher/sean-publication"},
                {4,"রবিউল আউয়াল সীরাত গ্রন্থমালা","সকল বই","সীরাতে রাসূল (সা.)","https://www.wafilife.com/cat/books/subject/serate-rasullullah"},
//                {6,"তরজমাতুল কুরআন","সকল বই","তরজমা ও তাফসীর","https://www.wafilife.com/cat/books/subject/al-quaraner-tarjama-o-tafseer"},
                {7,"কুরআন বিষয়ক আলোচনা","সকল বই","কুরআন বিষয়ক আলোচনা","https://www.wafilife.com/cat/books/subject/quran-bishoyok-alochona"},
                {8,"আল হাদিস","সকল বই","আল হাদিস","https://www.wafilife.com/cat/books/subject/al-hadith"},
                {9,"সীরাতে রাসূল (সা.)","সকল বই","সীরাতে রাসূল (সা.)","https://www.wafilife.com/cat/books/subject/serate-rasullullah"},
                {10,"ইতিহাস ও ঐতিহ্য","সকল বই","ইতিহাস ও ঐতিহ্য","https://www.wafilife.com/cat/books/subject/history-and-traditions"},
                {11,"সাহাবীদের জীবনী","সকল বই","সাহাবীদের জীবনী","https://www.wafilife.com/cat/books/subject/%E0%A6%B8%E0%A6%BE%E0%A6%B9%E0%A6%BE%E0%A6%AC%E0%A6%BE"},
                {13,"Food","সকল পণ্য","FOOD PRODUCTS","https://www.wafilife.com/cat/products/food-products"},
                {15,"গ্রাহকদের পছন্দের আতর ও সুগন্ধি পণ্য","সকল আতর ও সুগন্ধি পণ্য","আতর","https://www.wafilife.com/cat/products/cosmetics/attar?wpsolr_sort=sort_by_relevancy_desc"},
                {16,"প্যাকেজ সমূহ","সকল প্যাকেজ","প্যাকেজসমূহ","https://www.wafilife.com/cat/home-product/packages"},
                {18,"ইবাদত, আত্মশুদ্ধি ও অনুপ্রেরণা","এই বিষয়ে সকল বই","আত্মশুদ্ধি ও অনুপ্রেরণা","https://www.wafilife.com/cat/books/subject/ibadat-attoshuddhi-o-onuprerona"},
                //{19,"ঈমান আক্বিদা ও বিশ্বাস","এই বিষয়ে সকল বই","ঈমান ও আকীদা","https://www.wafilife.com/cat/books/subject/faith-and-aqeedah-o-bisshash"},
        };
    }
}
