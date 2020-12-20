package pages;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwiggyPage {

	WebDriver driver;

	@FindBy(linkText = "Sign up")
	WebElement signUp;

	@FindBy(xpath = "//*[@class='_1Tg1D']")
	WebElement confirmTxt;

	@FindBy(id = "mobile")
	WebElement phel;

	@FindBy(id = "name")
	WebElement nael;

	@FindBy(id = "email")
	WebElement emel;

	@FindBy(id = "password")
	WebElement pael;

	@FindBy(xpath = "//*[@class='a-ayg']")
	WebElement continueTxt;

	/*
	 * phel.sendKeys(phone); nael.sendKeys(name); emel.sendKeys(email);
	 * pael.sendKeys(password);
	 */

	public SwiggyPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void SwiggyHomePage() {
		
		 driver.get("https://www.swiggy.com/");
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

	}
	
	public void SwiggySignUp() {
		
		signUp.click();

	}

	public void SwiggySignUpConfirmation() throws InterruptedException {
		
		Assert.assertTrue(confirmTxt.isDisplayed());
    	Thread.sleep(1000);

	}

	public void SwiggySignUpPage() {
		
		SwiggyHomePage();
		signUp.click();
		/*driver.get("https://www.swiggy.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        WebElement Search = driver.findElement(By.linkText("Sign up"));
          Search.click();*/

	}



	public void SwiggyCredentials(String phone, String name, String email, String password) throws InterruptedException {
		
		phel.sendKeys(phone);
    	nael.sendKeys(name);
    	emel.sendKeys(email);
    	pael.sendKeys(password);
    	
    	Thread.sleep(3000); 

	}

	public void SwiggyLogin() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		continueTxt.click();

	}

}
