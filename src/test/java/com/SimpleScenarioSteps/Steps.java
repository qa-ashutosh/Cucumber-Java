package com.SimpleScenarioSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps{
	
	private WebDriver driver;
	
	@Given("I am in the login page of MyStore Application")
	public void i_am_in_the_login_page_of_MyStore_Application() {	 
		System.setProperty("webdriver.chrome.driver", "/Users/ashu/Tools/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	
	@When("I enter valid credentials")
	public void i_enter_valid_credentials() {		
		driver.findElement(By.id("email")).sendKeys("ash01@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("qwerty123");
		driver.findElement(By.id("SubmitLogin")).click();
	}


	@Then("I should be taken to the My Account page")
	public void i_should_be_taken_to_the_My_Account_page() throws InterruptedException {		
		Thread.sleep(5000);
		driver.findElement(By.id("center_column")).isDisplayed();
		driver.findElement(By.linkText("Sign out")).click();			
		driver.quit();
	}

	
}
