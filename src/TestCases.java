import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases {
	WebDriver driver = new ChromeDriver(); 
	String theURL = "https://automationteststore.com/";
	String SignupPage = "https://automationteststore.com/index.php?rt=account/create"; 
	
	
	Random rand = new Random();
	
	
	@BeforeTest
	public void mySetup() {
		driver.get(theURL);
		
		driver.manage().window().maximize();
		
	}
	
	
	@Test(priority = 1)
	public void Signup() throws InterruptedException {
		
		driver.navigate().to(SignupPage);
		
		//Personal Details Elements
		WebElement firstNameInput = driver.findElement(By.xpath("//input[@id='AccountFrm_firstname']"));
		WebElement lastNameInput = driver.findElement(By.xpath("//input[@id='AccountFrm_lastname']"));
		WebElement emailInput = driver.findElement(By.xpath("//input[@id='AccountFrm_email']"));
		WebElement teleInput = driver.findElement(By.xpath("//input[@id='AccountFrm_telephone']"));
		WebElement faxInput = driver.findElement(By.xpath("//input[@id='AccountFrm_fax']"));
		
		//Address Elements
		WebElement companyInput = driver.findElement(By.xpath("//input[@id='AccountFrm_company']"));
		WebElement add1Input = driver.findElement(By.xpath("//input[@id='AccountFrm_address_1']"));
		WebElement add2Input = driver.findElement(By.xpath("//input[@id='AccountFrm_address_2']"));
		WebElement cityInput = driver.findElement(By.xpath("//input[@id='AccountFrm_city']"));
		WebElement zipCodeInput = driver.findElement(By.xpath("//input[@id='AccountFrm_postcode']"));
		WebElement CountrySelect = driver.findElement(By.id("AccountFrm_country_id"));
		WebElement StateSelect = driver.findElement(By.id("AccountFrm_zone_id"));
		
		//LogIn Elements 
		WebElement loginNameInput = driver.findElement(By.id("AccountFrm_loginname"));
		WebElement passwordInput = driver.findElement(By.id("AccountFrm_password"));
		WebElement passwordConfirmInput = driver.findElement(By.id("AccountFrm_confirm"));
		WebElement agreeBox = driver.findElement(By.id("AccountFrm_agree"));
		WebElement ContinueButton = driver.findElement(By.cssSelector("button[title='Continue']"));
		
		//Personal Details Data
		
		String[] fristNames = { "Rand", "Rogina", "Dania", "Lama", "Razan"};
		int randomIndexForFirstName = rand.nextInt(fristNames.length);		
		String randomFirstName = fristNames[randomIndexForFirstName];
		
		String[] lastNames = {"Mohammed","Rami","Moath","Khaled", "Ameer", "AbedAL-Rahman","Omar"};
		int randomIndexForLastName = rand.nextInt(lastNames.length);
		String randomLastName = lastNames[randomIndexForLastName]; 
		
		int randomNumberForTheEmail = rand.nextInt(7000);
		String email = randomFirstName+randomLastName+randomNumberForTheEmail+"@gmail.com";
		
		String telephone ="798564321";
		String fax ="698745";		
		
		//Address Data 
		String company ="PustIT" ;
		String add1 = "Irbed - CityCenter Street";
		String add2 ="Irbed - Al-Yarmouk Street";
		String city ="Irbed";
		String zipCode ="13658";
		
		//LogIn Data
		String password = "Test@1234";

		
		
		//Personal Details Actions
		firstNameInput.sendKeys(randomFirstName);
		lastNameInput.sendKeys(randomLastName);
		emailInput.sendKeys(email);
		teleInput.sendKeys(telephone);
		faxInput.sendKeys(fax);
				
		//Address Actions
		companyInput.sendKeys(company);
		add1Input.sendKeys(add1);
		add2Input.sendKeys(add2);
		cityInput.sendKeys(city);
		
		Select mySelectForTheCountry = new Select(CountrySelect);
		mySelectForTheCountry.selectByVisibleText("Jordan");

		Thread.sleep(1000);
		
		int numberOfOptions = StateSelect.findElements(By.tagName("option")).size();

		//System.out.println(numberOfOptions);
		
		Select mySelectForTheState = new Select(StateSelect);
		int randomStateIndex = rand.nextInt(1, numberOfOptions);
		
		mySelectForTheState.selectByValue("1705");
		
		
		zipCodeInput.sendKeys(zipCode);
		
		//LogIn Actions 
		loginNameInput.sendKeys(randomFirstName+randomLastName+randomNumberForTheEmail);		
		passwordInput.sendKeys(password);
		passwordConfirmInput.sendKeys(password);
		
		agreeBox.click();
		ContinueButton.click();
	}

}
