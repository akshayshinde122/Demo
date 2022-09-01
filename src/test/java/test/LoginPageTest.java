package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
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
import pom.ZerodhaLoginPage;
import utility.Parametrization;
import utility.Reports;
import utility.BaseTest;

@Listeners(utility.Listeners.class)
public class LoginPageTest extends BaseTest {
	ExtentReports reports;
	ExtentTest test;
	@BeforeTest
	public void addReports() {
		 reports = Reports.generateReports();
		
	}
	
	@BeforeMethod
	public void launchBrowser()  {
		driver = LaunchBrowser.chromeBrowser();
	}
	
	@Test
	
	public void ZerodhaLoginTest() throws EncryptedDocumentException, IOException, InterruptedException {
		test = reports.createTest("ZerodhaLoginTest");
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
	public void validateZerodhaForgotLink() {
		test = reports.createTest("validateZerodhaForgotLink");
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		zerodhaLoginPage.clickOnForgot();
	}	
	
	@AfterMethod
	public void postTest(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName());
		
	} else if(result.getStatus()== ITestResult.SUCCESS) {
		test.log(Status.PASS, result.getName());
	} else {
		test.log(Status.SKIP, result.getName());
	}
	
	}
	
	@AfterTest
	public void flushReport() {
		reports.flush();
		
	}
	
}
