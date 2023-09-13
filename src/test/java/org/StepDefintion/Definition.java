package org.StepDefintion;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.Base.BaseClass;
import org.PomPage.CreateAccount;
import org.PomPage.ForgotPassword;
import org.PomPage.LoginPage;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Definition extends BaseClass{
	
LoginPage login;
CreateAccount CreateAccount;
ForgotPassword ForgotPassword;
String name;
@Given("Load Facebook Url")
public void load_facebook_url() throws IOException {
	loadUrl("https://www.facebook.com/");
	
}

@Given("user enter username and password")
public void user_enter_username_and_pass(io.cucumber.datatable.DataTable dataTable) {
	login =new LoginPage();
	List<Map<String,String>> asMaps = dataTable.asMaps();
	login.getuserName().sendKeys(asMaps.get(0).get("UserName"));
	
	login.getpassword().sendKeys(asMaps.get(0).get("Password"));
	login.getloginButton().click();
   }


@When("Clik LoginButton")
public void clik_login_button() {
	name="login";
  WebElement getloginButton = login.getloginButton();
  Click(getloginButton);
}

@Given("User click Create New Account")
public void user_click_create_new_account() {
	CreateAccount=new CreateAccount();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	WebElement getnewAccount = CreateAccount.getnewAccount();
	Click(getnewAccount);
  }

@Given("User enter FirstName and LastName")
public void user_enter_first_name_and_last_name(io.cucumber.datatable.DataTable dataTable) {
   List<Map<String,String>> asMaps = dataTable.asMaps();
   CreateAccount.getfirstName().sendKeys(asMaps.get(0).get("FirstName"));
   CreateAccount.getlastName().sendKeys(asMaps.get(0).get("LastName"));
}

@Given("User enter MobileNumber and Newpassword")
public void user_enter_mobile_number_and_newpassword(io.cucumber.datatable.DataTable dataTable) {
	Map<String, String> asMap = dataTable.asMap();
	CreateAccount.getmobileNum().sendKeys(asMap.get("MobileNum"));
	CreateAccount.getnewPassword().sendKeys(asMap.get("Newpass"));
 }

@Given("User enter Dob and Gender")
public void user_enter_dob_and_gender() {
   WebElement getgender = CreateAccount.getgender();
  Click(getgender);
}
@Given("User click ForgotPassword")
public void user_click_forgot_password() {
	ForgotPassword =new ForgotPassword();
   WebElement getforgotPassword = ForgotPassword.getforgotPassword();
   Click(getforgotPassword);
}

@Given("User enter MobileNumber")
public void user_enter_mobile_number() {
   WebElement getenterValue = ForgotPassword.getenterValue();
   passValue(getenterValue, "840809694580");
}




}
