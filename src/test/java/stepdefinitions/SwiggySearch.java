package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.junit.Cucumber;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

@RunWith(Cucumber.class)
public class SwiggySearch {

	WebDriver driver = Setproject.driver;
	ExtentTest logger;
	SwiggyPage swiggyPage = new SwiggyPage(driver);
	ExtentReports extent = new ExtentReports(System.getProperty("user.dir") + "/extent.html", false);

	@Given("^The user is on the Swiggy Home Page$")
	public void the_user_is_on_the_swiggy_home_page() throws Throwable {

		
		logger = extent.startTest("HomePage");
		swiggyPage.SwiggyHomePage();

	}

	@When("^User click on SignUp$")
	public void user_click_on_signup() throws Throwable {

		swiggyPage.SwiggySignUp();
		logger.log(LogStatus.INFO, "Swiggy Sign Up Clciked");

	}

	@Then("^User should be redirected to Signup Page$")
	public void user_should_be_redirected_to_signup_page() throws Throwable {

		swiggyPage.SwiggySignUpConfirmation();
		logger.log(LogStatus.PASS, "Swiggy Sign Up Page Display Confirmed");
		extent.endTest(logger);
		extent.flush();
		

	}

	@Given("^The user is alerady on the Signup page$")
	public void the_user_is_alerady_on_the_signup_page() throws Throwable {

		logger = extent.startTest("SignUpPage");
		swiggyPage.SwiggySignUpPage();

	}

	@When("^User enters \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_enters_something_something_something_and_something(String phone, String name, String email,
			String password) throws Throwable {

		swiggyPage.SwiggyCredentials(phone, name, email, password);
		logger.log(LogStatus.INFO, "Swiggy Credentials Entered");

	}

	@And("^User Click Continue button$")
	public void user_click_continue_button() throws Throwable {

		swiggyPage.SwiggyLogin();
		logger.log(LogStatus.PASS, "Swiggy Sign Up Succesfull");
		extent.endTest(logger);
		// WebElement contin = driver.findElement(By.linkText("CONTINUE"));
		// contin.click();

	}

	@Then("^User should be able to SignUp$")
	public void user_should_be_able_to_signup() throws Throwable {

		extent.flush();
		extent.close();
		System.out.println("user logged in");

	}

}
