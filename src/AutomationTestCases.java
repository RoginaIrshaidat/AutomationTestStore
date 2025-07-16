import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class AutomationTestCases {
	
	WebDriver driver = new ChromeDriver();
	String theURL = "https://automationteststore.com/";
	String SignupPage = "https://automationteststore.com/index.php?rt=account/create";

	Random rand = new Random();

	String TheUserName;

	String ThePassword = "Test@1234";

	@BeforeTest
	public void mySetup() {
		driver.get(theURL);

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@Test(priority = 1, enabled = true)
	public void Signup() throws InterruptedException {
		
		String confirmationMessage = " Your Account Has Been Created!";

		driver.navigate().to(SignupPage);

		// elements
		WebElement firstnameInput = driver.findElement(By.xpath("//input[@name=\"firstname\"]"));
		WebElement lastNameInput = driver.findElement(By.id("AccountFrm_lastname"));
		WebElement emailInput = driver.findElement(By.id("AccountFrm_email"));
		WebElement teleInput = driver.findElement(By.id("AccountFrm_telephone"));
		WebElement faxInput = driver.findElement(By.id("AccountFrm_fax"));
		WebElement companyInput = driver.findElement(By.id("AccountFrm_company"));
		WebElement address1Input = driver.findElement(By.id("AccountFrm_address_1"));
		WebElement address2Input = driver.findElement(By.id("AccountFrm_address_2"));
		WebElement cityInput = driver.findElement(By.id("AccountFrm_city"));

		WebElement PostalCodeInput = driver.findElement(By.id("AccountFrm_postcode"));
		WebElement loginNameInput = driver.findElement(By.id("AccountFrm_loginname"));
		WebElement passwordInput = driver.findElement(By.id("AccountFrm_password"));
		WebElement passwordConfirmInput = driver.findElement(By.id("AccountFrm_confirm"));
		WebElement agreebox = driver.findElement(By.id("AccountFrm_agree"));
		WebElement ContinueButton = driver.findElement(By.cssSelector("button[title='Continue']"));
		WebElement CountrySelect = driver.findElement(By.id("AccountFrm_country_id"));
		WebElement StateSelect = driver.findElement(By.id("AccountFrm_zone_id"));
		// data

		String[] fristNames = { "amira", "rogina", "dana", "mais", "dareen" };
		int randomIndexForFirstName = rand.nextInt(fristNames.length);

		String randomFirstName = fristNames[randomIndexForFirstName];

		String[] lastNames = { "alaa", "saif", "abduallah", "hamzeh", "marwan", "abedalrahman", "omar" };
		int randomIndexForLastName = rand.nextInt(lastNames.length);
		String randomLastName = lastNames[randomIndexForLastName];

		int randomNumberForTheEmail = rand.nextInt(7000);
		String email = randomFirstName + randomLastName + randomNumberForTheEmail + "@gmail.com";
		String telephone = "9624545455";
		String fax = "9624545755";
		String company = "abc";
		String address1 = "Amman tlaaelAli";
		String address2 = "Amman ShafaBadran";
		String city = "Amman";
		String PostalCode = "3817";

		// actions

		TheUserName = randomFirstName + randomLastName + randomNumberForTheEmail;

		firstnameInput.sendKeys(randomFirstName);
		lastNameInput.sendKeys(randomLastName);
		emailInput.sendKeys(email);
		teleInput.sendKeys(telephone);
		faxInput.sendKeys(fax);
		companyInput.sendKeys(company);
		address1Input.sendKeys(address1);
		address2Input.sendKeys(address2);
		cityInput.sendKeys(city);

		Select mySelectForTheCountry = new Select(CountrySelect);

		int TotalCountries = CountrySelect.findElements(By.tagName("option")).size();

		int randomCountry = rand.nextInt(1, TotalCountries);

		mySelectForTheCountry.selectByIndex(randomCountry);

		Thread.sleep(2000);

		;

		int numberOfOptions = StateSelect.findElements(By.tagName("option")).size();

		System.out.println(numberOfOptions);

		Select mySelectForTheState = new Select(StateSelect);
		int randomStateIndex = rand.nextInt(1, numberOfOptions);
		mySelectForTheState.selectByIndex(randomStateIndex);

//		Select mySelectForTheState = new Select(StateSelect);
//		int randomStateIndex = rand.nextInt(1, numberOfOptions);
//		mySelectForTheState.selectByValue("1705");

		PostalCodeInput.sendKeys(PostalCode);
		loginNameInput.sendKeys(TheUserName);

		passwordInput.sendKeys(ThePassword);
		passwordConfirmInput.sendKeys(ThePassword);
		agreebox.click();

		ContinueButton.click();

		Thread.sleep(3000);
		

		boolean ActualResult = driver.getPageSource().contains(confirmationMessage);
		// boolean ActualResult =
		// driver.findElement(By.className("maintext")).isDisplayed();
		Assert.assertEquals(ActualResult, true, "this is to check if the account is created");


	}

	@Test(priority = 2, enabled = true)
	public void Logout() throws InterruptedException {
		
		String logoutConfirmationMessage = "You have been logged off your account. It is now safe to leave the computer.";

		WebElement LogoutButton = driver.findElement(By.linkText("Logoff"));

		LogoutButton.click();

		Thread.sleep(1000);

		WebElement continueButton = driver.findElement(By.linkText("Continue"));
		continueButton.click();
		
		boolean actualResults = driver.getPageSource().contains(logoutConfirmationMessage);
		
		//Assert.assertEquals(actualResults, true);
		Assert.assertEquals(actualResults, true,"this is to check that the user has been logged out");
	}

	@Test(priority = 3, enabled = true)
	public void Login() {
		
		String loginconfirmationMessage = "Welcome back "; 
		WebElement LoginAndRegisterButton = driver.findElement(By.partialLinkText("Login or register"));

		LoginAndRegisterButton.click();

		WebElement Loginname = driver.findElement(By.id("loginFrm_loginname"));
		WebElement passwordInput = driver.findElement(By.id("loginFrm_password"));
		Loginname.sendKeys(TheUserName);
		passwordInput.sendKeys(ThePassword);

		WebElement LoginButton = driver.findElement(By.xpath("//button[@title='Login']"));
		LoginButton.click();
		
		boolean actualResults = driver.getPageSource().contains(loginconfirmationMessage);
		//Assert.assertEquals(actualResults, true);
		Assert.assertEquals(actualResults, true,"this is to check that the user has been logged in");
	}

	

	@Test(priority = 4,enabled = true)

	public void AddtoCart() throws InterruptedException {
String CheckoutURL = "https://automationteststore.com/index.php?rt=checkout/cart";
		
		String HomePageInCaseItemNotInTheStock = "https://automationteststore.com/";
		driver.navigate().to("https://automationteststore.com/");
		String[] sectionsNames = { "featured", "latest", "bestseller", "special" };
		int randomSectionIndex = rand.nextInt(sectionsNames.length);
		WebElement TheCategory = driver.findElement(By.id(sectionsNames[randomSectionIndex]));
		List<WebElement> AllItems = TheCategory.findElements(By.className("prdocutname"));
		int randomProduct = rand.nextInt(AllItems.size());
		AllItems.get(randomProduct).click();
		Thread.sleep(2000);

		String ProductPage = driver.findElement(By.className("productpagecart")).getText();

		System.out.println(ProductPage);

		if (ProductPage.equals("Out of Stock")) {
			driver.navigate().back();
			System.out.println("sorry the item is not available");
			Thread.sleep(2000);

			driver.getCurrentUrl().equals(HomePageInCaseItemNotInTheStock);
		}
		else {
			System.out.println(driver.getCurrentUrl());
			if (driver.getCurrentUrl().contains("product_id=116")) {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//label[@for='option344747']")).click();

			}
			driver.findElement(By.partialLinkText("Add to Cart")).click();
			
			Thread.sleep(2000);
			boolean actualResult = 	driver.getCurrentUrl().equals(CheckoutURL); 
			
			Assert.assertEquals(actualResult, true);
			
			
		}
		
		}
		

	
}
