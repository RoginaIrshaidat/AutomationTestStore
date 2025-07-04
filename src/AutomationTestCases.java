import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutomationTestCases {
	
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
	public void Signup() {
		
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
		
		//LogIn Elements 
		WebElement loginNameInput = driver.findElement(By.id("AccountFrm_loginname"));
		WebElement passwordInput = driver.findElement(By.id("AccountFrm_password"));
		WebElement passwordConfirmInput = driver.findElement(By.id("AccountFrm_confirm"));
		
		//Personal Details Data
		
		String[] fristNames = { "amira", "rogina", "dana", "mais", "dareen"};
		int randomIndexForFirstName = rand.nextInt(fristNames.length);		
		String randomFirstName = fristNames[randomIndexForFirstName];
		
		String[] lastNames = {"alaa","saif","abduallah","hamzeh", "marwan", "abedalrahman","omar"};
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
		zipCodeInput.sendKeys(zipCode);
		
		//LogIn Actions 
		loginNameInput.sendKeys(randomFirstName+randomLastName+randomNumberForTheEmail);		
		passwordInput.sendKeys(password);
		passwordConfirmInput.sendKeys(password);
	}
}
