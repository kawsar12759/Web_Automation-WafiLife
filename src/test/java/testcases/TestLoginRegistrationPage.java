package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginRegistrationPage;
import utilities.Dataset;
import utilities.DriverSetup;

public class TestLoginRegistrationPage extends DriverSetup {
    LoginRegistrationPage loginRegistrationPage = new LoginRegistrationPage();

    @Test
    public void testFieldsNameAndSpelling(){
        loginRegistrationPage.loadPage(loginRegistrationPage.url);

        Assert.assertEquals(loginRegistrationPage.getElementText(loginRegistrationPage.page_heading),"আমার অ্যাকাউন্ট");
        Assert.assertEquals(loginRegistrationPage.getElementText(loginRegistrationPage.login_heading),"লগইন");
        Assert.assertEquals(loginRegistrationPage.getElementText(loginRegistrationPage.login_username_label),"ইউজার নাম অথবা ইমেইল *");
        Assert.assertEquals(loginRegistrationPage.getElementText(loginRegistrationPage.login_password_label),"পাসওয়ার্ড *");
        Assert.assertEquals(loginRegistrationPage.getAttributeValue(loginRegistrationPage.login_btn,"value"),"লগইন");
        Assert.assertEquals(loginRegistrationPage.getCSSValue(loginRegistrationPage.login_btn,"background-color"),"rgba(242, 53, 52, 1)");
        Assert.assertEquals(loginRegistrationPage.getCSSValue(loginRegistrationPage.registration_btn,"color"),"rgba(102, 102, 102, 1)");


        Assert.assertEquals(loginRegistrationPage.getElementText(loginRegistrationPage.registration_heading),"রেজিস্টার");
        Assert.assertEquals(loginRegistrationPage.getElementText(loginRegistrationPage.registration_username_label),"নাম *");
        Assert.assertEquals(loginRegistrationPage.getElementText(loginRegistrationPage.registration_userPhone_label),"ফোন নাম্বার *");
        Assert.assertEquals(loginRegistrationPage.getElementText(loginRegistrationPage.registration_userEmail_label),"ইমেইল *");
        Assert.assertEquals(loginRegistrationPage.getElementText(loginRegistrationPage.registration_password_label),"পাসওয়ার্ড *");
        Assert.assertEquals(loginRegistrationPage.getElementText(loginRegistrationPage.registration_confirmPassword_label),"পাসওয়ার্ড নিশ্চিত করুন *");
        Assert.assertEquals(loginRegistrationPage.getAttributeValue(loginRegistrationPage.registration_btn,"value"),"রেজিস্টার");
        Assert.assertEquals(loginRegistrationPage.getCSSValue(loginRegistrationPage.registration_btn,"color"),"rgba(102, 102, 102, 1)");
        Assert.assertEquals(loginRegistrationPage.getCSSValue(loginRegistrationPage.registration_btn,"background-color"),"rgba(255, 255, 255, 1)");
    }


    @Test(dataProvider = "validLoginCredentials", dataProviderClass = Dataset.class)
    public void testUserCanLoginWithValidUsername(String user_name_or_email, String password){
        loginRegistrationPage.loadPage(loginRegistrationPage.url);
        loginRegistrationPage.writeOnElement(loginRegistrationPage.login_username_or_userEmail_input,user_name_or_email);
        loginRegistrationPage.writeOnElement(loginRegistrationPage.login_password_input,password);
        loginRegistrationPage.clickOnElement(loginRegistrationPage.login_btn);
        Assert.assertEquals(loginRegistrationPage.getElementText(loginRegistrationPage.login_success_display),loginRegistrationPage.login_success_message);
    }

    @Test(dataProvider = "invalidLoginCredentials", dataProviderClass = Dataset.class)
    public void testUserCannotLoginWithInvalidCredentials(String user_name_or_email, String password,String errorText){
        loginRegistrationPage.loadPage(loginRegistrationPage.url);
        loginRegistrationPage.writeOnElement(loginRegistrationPage.login_username_or_userEmail_input,user_name_or_email);
        loginRegistrationPage.writeOnElement(loginRegistrationPage.login_password_input,password);
        loginRegistrationPage.clickOnElement(loginRegistrationPage.login_btn);
        Assert.assertEquals(loginRegistrationPage.getElementText(loginRegistrationPage.errorText_area),errorText);

    }
}
