package com.automation.login;

import com.automation.utils.CommonMethod;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginTest {

    Login login = new Login();

    @Given("User load the login page.")
    public void user_load_the_login_page() {
        login.loadLoginPage();
    }
    @Then("User enter the correct username and password.")
    public void user_enter_the_correct_username_and_password() {
        login.loginUser();
    }
    @Then("User click on the {string} button.")
    public void user_click_on_the_login_button(String btn) {
        login.clickSubmitBtn(btn);
    }

    @Then("Verify the home page.")
    public void verify_the_home_page() {
       login.verifyHomePage();
    }

}
