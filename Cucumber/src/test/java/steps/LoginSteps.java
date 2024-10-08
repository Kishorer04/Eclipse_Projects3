package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	WebDriver driver;

	
	  @Given("User should navigate to the application login") 	
	  public void userShouldNavigateToTheApplicationLogin() { 
	  driver = new ChromeDriver();
	  driver.get("https://bookcart.azurewebsites.net/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); }
	
	  
	@Given("User clicks on the login link")
	public void userClicksOnTheLoginLink() {

		driver.findElement(By.xpath("//span[normalize-space()='Login']")).click();

	}

	/*
	 * @Given("User enter the username as ortoni") public void
	 * userEnterTheUsernameAsOrtoni() {
	 * driver.findElement(By.xpath("(//input[@id='mat-input-0'])[1]")).sendKeys(
	 * "ortoni"); }
	 * 
	 * @Given("User enter the password as pass1234") public void
	 * userEnterThePasswordAsPass1234() {
	 * driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys
	 * ("pass1234"); }
	 */

	@When("User click the login button")
	public void userClickTheLoginButton() {
		driver.findElement(By.xpath("//span[text()='Login']")).click();

	}

	@Then("login should be success")
	public void loginShouldBeSuccess() {

		String text = driver.findElement(By.xpath("(//span[@class='mdc-button__label'])[1]")).getText();
		System.out.println(text);
		driver.quit();

	}
	
	/*
	 * @Given("User enter the username as kishore") public void
	 * userEnterTheUsernameAsKishore() {
	 * driver.findElement(By.xpath("(//input[@id='mat-input-0'])[1]")).sendKeys(
	 * "kishore"); }
	 * 
	 * @Given("User enter the password as passkishore") public void
	 * userEnterThePasswordAsPasskishore() {
	 * driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys
	 * ("passkishore"); }
	 */
	
	@But("login should be fail")
	public void loginShouldBeFail() {
		
		String text =driver.findElement(By.xpath("//mat-error[@id='mat-mdc-error-0']")).getText();
	    Assert.assertEquals(text, "Username or Password is incorrect.");
	    driver.quit();
	}
	
	
	@Given("User enter the username as {string}")
	public void userEnterTheUsernameAs(String username) {
	driver.findElement(By.xpath("(//input[@id='mat-input-0'])[1]")).sendKeys(username);
				
	}
	@Given("User enter the password as {string}")
	public void userEnterThePasswordAs(String password) {
	driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
		  
	}

}
