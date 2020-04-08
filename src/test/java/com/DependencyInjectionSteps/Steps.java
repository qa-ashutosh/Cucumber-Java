package com.DependencyInjectionSteps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Base.BaseUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps extends BaseUtil{
	
	private BaseUtil baseUtil;
	
	public Steps(BaseUtil util) {
		this.baseUtil = util;
	}
	
	private WebDriver driver;
	
	@Before()
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/ashu/Tools/chromedriver");
		driver = new ChromeDriver();
	}
	
	@Given("I am in the login page of MyStore Application")
	public void i_am_in_the_login_page_of_MyStore_Application() {	 
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	
	@When("I enter valid {string} and {string} with {string}")
	public void i_enter_valid_credentials(String email, String password, String fullName) {
		
		baseUtil.userFullName = fullName;
		
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("passwd")).sendKeys(password);
		driver.findElement(By.id("SubmitLogin")).click();
	}


	@Then("I should be taken to the My Account page")
	public void i_should_be_taken_to_the_My_Account_page() throws InterruptedException {		
		Thread.sleep(5000);
		
		String actualuserFullName = driver.findElement(By.cssSelector(".header_user_info a span")).getText().toString();
		System.out.println(baseUtil.userFullName.toString());
		assertTrue(actualuserFullName, actualuserFullName.contains(baseUtil.userFullName));
		
		driver.findElement(By.id("center_column")).isDisplayed();
		driver.findElement(By.linkText("Sign out")).click();	
	}

	@After()
	public void tearDown() {
		driver.quit();
	}
}
