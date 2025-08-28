package utilities;

import org.testng.annotations.DataProvider;
import pages.LoginRegistrationPage;

public class Dataset {



    @DataProvider(name="validLoginCredentials")
    public static Object validLoginCredentials(){
        LoginRegistrationPage loginRegistrationPage = new LoginRegistrationPage();
        return new Object[][]{
                {loginRegistrationPage.user_name, loginRegistrationPage.password},
                {loginRegistrationPage.user_email,loginRegistrationPage.password}
        };
    }
    @DataProvider(name="invalidLoginCredentials")
    public static Object invalidLoginCredentials(){
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
    public static Object invalidRegistrationCredentials(){
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
}
