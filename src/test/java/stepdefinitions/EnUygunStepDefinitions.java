package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.EnUygunPage;
import utilities.ConfigReader;
import utilities.Driver;

/**
 * Created By Ezgi Bektas
 * Date :7.04.2023
 */
public class EnUygunStepDefinitions {
	EnUygunPage enUygunPage = new EnUygunPage();

	//1.Scenario
	@Given("the user is on the {string} homepage")
	public void the_user_is_on_the_homepage(String string) {
		Driver.getDriver().get(ConfigReader.getProperty("enUygunUrl"));
	}
	@When("user clicks the sign up button")
	public void user_clicks_the_sign_up_button() {
		enUygunPage.signUpButton.click();
	}
	@Then("enters valid e-mail address")
	public void enters_valid_e_mail_address() {
		enUygunPage.emailButton.sendKeys("testenuygun2@gmail.com");
	}
	@Then("enters valid password")
	public void enters_valid_password() {
		enUygunPage.passwordButton.sendKeys("123456en");
	}

	@And("user clicks the second sign up button")
	public void userClicksTheSecondSignUpButton() {
		enUygunPage.signUpSecondButton.click();
	}
	@Then("tests that its logged into the site correctly")
	public void tests_that_its_logged_into_the_site_correctly() throws InterruptedException {
		Thread.sleep(5000);
		String expectedHeader= "T";
		String actualHeader= enUygunPage.loginVerification.getText();
		Assert.assertTrue(actualHeader.contains(expectedHeader));
		Thread.sleep(5000);
	}
	@Then("ends the page")
	public void ends_the_page() {
		Driver.getDriver().close();

	}

	//2.Scenario

	@Then("user clicks facebook sign up button")
	public void user_clicks_facebook_sign_up_button() {
		enUygunPage.facebookSignUpButton.click();

	}
	@Then("enters facebook valid e-mail address")
	public void enters_facebook_valid_e_mail_address() {
		enUygunPage.facebookEmailButton.sendKeys("testenuygun0@gmail.com");

	}
	@Then("enters facebook valid password")
	public void enters_facebook_valid_password() {
		enUygunPage.facebookPasswordButton.sendKeys("123456en");

	}
	@Then("clicks facebook login button")
	public void clicks_facebook_login_button() {

		enUygunPage.facebookLoginButton.click();
	}
	@Then("tests that its logged into facebook correctly")
	public void tests_that_its_logged_into_facebook_correctly() throws InterruptedException {
		Thread.sleep(5000);
		String expectedHeader= "T";
		String actualHeader= enUygunPage.facebookLoginVerification.getText();
		Assert.assertTrue(actualHeader.contains(expectedHeader));
		Thread.sleep(5000);
	}

	//1.Negative Scenario

	@Then("enters missing password")
	public void enters_missing_password() {
		enUygunPage.passwordButton.sendKeys("12345");
	}
	@Then("tests that it can't login to the website with the missing password")
	public void tests_that_it_can_t_login_to_the_website_with_the_missing_password() throws InterruptedException {
		Assert.assertTrue(enUygunPage.wrongPasswordText.isDisplayed());
		Thread.sleep(5000);
	}

	//2.Negative Scenario
	@Then("enters an invalid email address")
	public void enters_an_invalid_email_address() {
		enUygunPage.emailButton.sendKeys("sdjlksfjkhfsjkhf");
	}
	@Then("Tests that it can't login to the site with the wrong email")
	public void tests_that_it_can_t_login_to_the_site_with_the_wrong_email() throws InterruptedException {
		Assert.assertTrue(enUygunPage.wrongEmailText.isDisplayed());
		Thread.sleep(5000);
	}

	//3.Negative Scenario
	@Then("enters invalid facebook email address")
	public void enters_invalid_facebook_email_address() {
		enUygunPage.facebookEmailButton.sendKeys("djsfkhfhfskdjffh@gmail.com");
	}
	@Then("Tests that it can't login to the site with the wrong facebook email")
	public void tests_that_it_can_t_login_to_the_site_with_the_wrong_facebook_email() throws InterruptedException {
		Assert.assertTrue(enUygunPage.facebookAlert.isDisplayed());
		Thread.sleep(5000);
	}

	//4.Negative Scenario
	@Then("enters invalid facebook password")
	public void enters_invalid_facebook_password() {
		enUygunPage.facebookPasswordButton.sendKeys("sdjfadlskfhfsffaflhgff");
	}
	@Then("Tests that it can't login to the site with the wrong facebook password")
	public void tests_that_it_can_t_login_to_the_site_with_the_wrong_facebook_password() throws InterruptedException {
		Assert.assertTrue(enUygunPage.facebookPasswordAlert.isDisplayed());
		Thread.sleep(5000);
	}






}