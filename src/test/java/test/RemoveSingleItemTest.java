package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


import pages.DashBoardPage;
import pages.ListCheckBoxPage;
import util.BrowserFactory;

public class RemoveSingleItemTest {
	
	WebDriver driver;
	ListCheckBoxPage listCheckBoxPage;
	DashBoardPage dashboardPage;
	
	@FindBy(how = How.XPATH, using = "//form[@name='todo']/descendant::input[@type='checkbox']") WebElement ListCheckBoxElements;
	
	@Before
	public void removeSingleItemTest() {
		
		driver = BrowserFactory.startBrowser();
		
		listCheckBoxPage = PageFactory.initElements(driver,ListCheckBoxPage.class);
	}
	
	@Test
	public void clickOneBoxToRemove() throws InterruptedException {
		
		listCheckBoxPage.clickOneBox();
		Thread.sleep(3000);
		listCheckBoxPage.clickRemoveButton();

		Assert.assertNull("Cannot Remove Item" , ListCheckBoxElements);
		Thread.sleep(3000);
		
	}
	
	@After
	public void teardown() {
		driver.close();
		driver.quit();
	}

}
