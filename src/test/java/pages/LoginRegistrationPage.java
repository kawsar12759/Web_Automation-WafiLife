package pages;

import org.openqa.selenium.By;

public class LoginRegistrationPage extends BasePage{
    public String url = "https://www.wafilife.com/my-account";

    public String user_email = "xodik69891@kimdyn.com";
    public String password = "testcase1";
    public String user_name = "xodik69891";

    public String invalid_user_email = "testmail@gmail.com";
    public String invalid_user_name = "testuser12";

    public String invalid_username_errorText = "Error: The username "+invalid_user_name+" is not registered on this site. If you are unsure of your username, try your email address instead.";
    public String invalid_userEmail_errorText = "Unknown email address. Check again or try your username.";
    public String invalid_password_for_username_errorText = "Error: The password you entered for the username " +user_name+" is incorrect. Lost your password?";
    public String invalid_password_for_userEmail_errorText = "Error: The password you entered for the email address "+user_email+" is incorrect. Lost your password?";
    public String empty_username_field_errorText  = "Error: ইউজার নাম প্রয়োজন";
    public String empty_password_field_errorText = "Error: The password field is empty.";

    public String registration_empty_or_invalid_email_field_errorText = "Error: অনুগ্রহ করে সঠিক ইমেইল প্রদান করুন";
    public String registration_empty_password_field_errorText = "Error: অনুগ্রহ করে আপনার পাসওয়ার্ড প্রদান করুন";
    public String registration_empty_or_password_mismatch_errorText = "Error: পাসওয়ার্ড মিলতেছে না";
    public String registration_empty_name_field_errorText = "Error: নাম প্রয়োজন!";
    public String registration_empty_phoneNumber_field_errorText = "Error: ফোন নাম্বার প্রয়োজন!.";

    public By page_heading = By.xpath("//h1[@class='heading-title']");

    public By login_heading = By.cssSelector("div[class='col-1'] h2");
    public By login_username_label =By.cssSelector("label[for='username']");
    public By login_password_label = By.cssSelector("label[for='password']");

    public By login_username_or_userEmail_input = By.xpath("//input[@id='username']");
    public By login_password_input = By.xpath("//input[@id='password']");
    public By login_btn = By.xpath("//input[@name='login']");


    public By registration_heading = By.cssSelector("div[class='col-2'] h2");
    public By registration_username_label = By.cssSelector("label[for='reg_billing_first_name']");
    public By registration_userPhone_label = By.cssSelector("label[for='reg_billing_phone']");
    public By registration_userEmail_label = By.cssSelector("label[for='reg_email']");
    public By registration_password_label = By.cssSelector("label[for='reg_password']");
    public By registration_confirmPassword_label = By.cssSelector("label[for='reg_confirm_password']");


    public By registration_username_input = By.xpath("//input[@id='reg_billing_first_name']");
    public By registration_userPhone_input = By.xpath("//input[@id='reg_billing_phone']");
    public By registration_userEmail_input = By.xpath("//input[@id='reg_email']");
    public By registration_password_input = By.xpath("//input[@id='reg_password']");
    public By registration_confirmPassword_input = By.xpath("//input[@id='reg_confirm_password']");
    public By registration_btn = By.xpath("//input[@name='register']");
    
    public By errorText_area = By.cssSelector("ul[class='woocommerce-error'] li");

    public By login_success_display = By.xpath("//div[@id='template-wrapper']//p[1]");
    public String login_success_message = "আসসালামু আলাইকুম " +user_name+ " (যদি আপনি "+user_name+" না হয়ে থাকেন তাহলে লগ অউট করুন)";


}
