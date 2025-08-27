package utilities;

import org.testng.annotations.DataProvider;
import pages.LoginRegistrationPage;

public class Dataset {



    @DataProvider(name="validLoginCredentials")
    public static Object validCredentials(){
        LoginRegistrationPage loginRegistrationPage = new LoginRegistrationPage();
        return new Object[][]{
                {loginRegistrationPage.user_name, loginRegistrationPage.password},
                {loginRegistrationPage.user_email,loginRegistrationPage.password}
        };
    }
    @DataProvider(name="invalidLoginCredentials")
    public static Object invalidCredentials(){
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
}
