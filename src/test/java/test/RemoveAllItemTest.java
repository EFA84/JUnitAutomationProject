package test;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


import pages.DashBoardPage;
import pages.ListCheckBoxPage;
import util.BrowserFactory;

public class RemoveAllItemTest {
	
	WebDriver driver;
	ListCheckBoxPage listCheckBoxPage;
	DashBoardPage dashboardPage;
	
	@Before
	public void removeAllItemTest() {
		
		driver = BrowserFactory.startBrowser();
		
		listCheckBoxPage = PageFactory.initElements(driver,ListCheckBoxPage.class);
	}
	
	@Test
	public void clickAllItemAndRemove() {
		
		listCheckBoxPage.clickToggleAllCheckBox();
		listCheckBoxPage.clickRemoveButton();
		
		Assert.assertTrue("No Items Found" , isListItemEmpty());
	}

	private boolean isListItemEmpty() {
		
		List<String> checkBoxList = listCheckBoxPage.getListOfCheckBox();
		
		for(int i=0; i<checkBoxList.size(); i++) {
			if(checkBoxList.get(i).isEmpty()) {
				
			}
		}
	
		return true;
	}
	
	@After
	public void teardown() {
//		driver.close();
		driver.quit();
	}

}
