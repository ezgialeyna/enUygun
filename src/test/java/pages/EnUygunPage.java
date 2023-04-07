package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import javax.xml.xpath.XPath;

/**
 * Created By Ezgi Bektas
 * Date :6.04.2023
 */
public class EnUygunPage {
	public EnUygunPage(){
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//*[@id=\"ctx-RegisterBtn\"]")
	public WebElement signUpButton;

	@FindBy(xpath = "//input[@name='_email']")
	public WebElement emailButton;

	@FindBy(className = "katalon__modal-password")
	public WebElement passwordButton;

	@FindBy(xpath = "//span[text()='Üye Ol']")
	public WebElement signUpSecondButton;

	@FindBy(xpath = "/html/body/div[17]/div[2]/div/div/div[2]/div[2]/div[1]")
	public WebElement facebookSignUpButton;

	@FindBy(xpath = "//*[@id=\"loginbutton\"]")
	public WebElement facebookLoginButton;

	@FindBy(css = "#email")
	public WebElement facebookEmailButton;

	@FindBy(css = "#pass")
	public WebElement facebookPasswordButton;
	@FindBy(xpath = "/html/body/div/div/div/div/div/div/div/div/div[1]/div/div/div[2]/div[2]/div[1]/div/div")
	public WebElement permissionToLogin;

	@FindBy(xpath = "//span[text()='Google ile üye ol']")
	public WebElement googleSignUpButton;

	@FindBy(css = "#identifierId")
	public WebElement googleEmailButton;


	@FindBy(css = ".VfPpkd-LgbsSe-OWXEXe-k8QpJ > span:nth-child(4)")
	public WebElement googlePasswordButton;

	@FindBy(xpath = "//*[@id=\"passwordNext\"]/div/button/div[3]")
	public WebElement googlePasswordNextButton;

	@FindBy(xpath = "//*[@id=\"next\"]" )
	public WebElement googleEmailNextButton;

	@FindBy(xpath = "/html/body/div[17]/div[2]/div/div/div[2]/form/div[2]/div/p")
	public WebElement wrongPasswordText;

	@FindBy(xpath = "/html/body/div[17]/div[2]/div/div/div[2]/form/div[1]/div/p")
	public WebElement wrongEmailText;

	@FindBy(xpath = "/html/body/div[1]/header/nav[1]/div/div[10]/a/span[1]")
	public WebElement loginVerification;

	@FindBy(xpath = "/html/body/div[1]/header/nav[1]/div/div[10]/a/span[2]/span")
	public WebElement facebookLoginVerification;

	@FindBy(xpath = "//*[@id=\"mount_0_0_Li\"]/div/div/div/div/div/div/div/div[1]/div/div/div[1]/div[2]/div[2]/div/div/div/div/div/span/div/span")
	public WebElement face;

	@FindBy(xpath = "/html/body/div/div/div/div/div/div/div/div/div[1]/div/div/div[2]/div[2]/div[1]/div/div")
	public WebElement erisim;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div[3]/div/div/div")
	public WebElement facebookAlert;

	@FindBy(xpath = "//*[@id=\"globalContainer\"]/div[3]/div/div/div")
	public WebElement facebookPasswordAlert;



}
