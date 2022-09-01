package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.LaunchBrowser;
import pom.ZerodhaHomePage;
import pom.ZerodhaLoginPage;
import utility.BaseTest;
import utility.Parametrization;
import utility.Reports;


@Listeners(utility.Listeners.class)
public class HomePageTest extends BaseTest {
	

	
	@BeforeMethod
	public void launchBrowser() throws InterruptedException, EncryptedDocumentException, IOException  {
		driver = LaunchBrowser.chromeBrowser();
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		String user = Parametrization.getdata("Credentials", 0, 1);
		String pass = Parametrization.getdata("Credentials", 1, 1);
		String pin = Parametrization.getdata("Credentials", 2, 1);
		zerodhaLoginPage.enterUserName(user);
		zerodhaLoginPage.enterPassword(pass);
		zerodhaLoginPage.clickOnSubmit();
	
		zerodhaLoginPage.enterPin(pin, driver);
		zerodhaLoginPage.clickOnContinue();
}
	
	@Test
	public void SearchStockTest() throws InterruptedException, IOException {
		ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver) ;
		Thread.sleep(1000);
		zerodhaHomePage.searchStock("Reliance", driver);
		int number = zerodhaHomePage.getSearchResultNumber();
		Assert.assertTrue(number > 0);
		Thread.sleep(1000);
		
		
	}
	
	@Test
	public void SearchStockAndClickBuy() throws IOException, InterruptedException {
		ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
		zerodhaHomePage.searchStock("Tata", driver);
		zerodhaHomePage.searchAndSelectDesiredStock(driver, "TATAPOWER");
		zerodhaHomePage.clickOnSearchresultBuy();
		Thread.sleep(1000);
	
	}
	
	
	@Test
	public void SearchStockAndClickSell() throws IOException, InterruptedException {
		ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
		zerodhaHomePage.searchStock("Infy", driver);
		zerodhaHomePage.searchAndSelectDesiredStock(driver, "INFY");
		Thread.sleep(1000);
		zerodhaHomePage.clickOnSearchresultSell();
		Thread.sleep(1000);
		
	}
	

	@Test
	public void SearchStockAndClickMarketDepth() throws IOException, InterruptedException {
		ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
		zerodhaHomePage.searchStock("Hdfc", driver);
		zerodhaHomePage.searchAndSelectDesiredStock(driver, "HDFCBANK");
		zerodhaHomePage.clickOnSearchresultMarketDepth();
		Thread.sleep(1000);
		
	}
	
	@Test
	public void SearchStockAndClickChart() throws IOException, InterruptedException {
		ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
		zerodhaHomePage.searchStock("Hinda", driver);
		zerodhaHomePage.searchAndSelectDesiredStock(driver, "HINDALCO");
		zerodhaHomePage.clickOnSearchresultChart();
		Thread.sleep(1000);
		
	}
	
	@Test
	public void SearchStockAndClickAddToWatchlist() throws IOException, InterruptedException {
		ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
		zerodhaHomePage.searchStock("TITA", driver);
		zerodhaHomePage.searchAndSelectDesiredStock(driver, "TITAN");
		Thread.sleep(1000);
		zerodhaHomePage.clickOnSearchresultAddToWatchlist();
		Thread.sleep(1000);
		
	}
	
	
		
}
