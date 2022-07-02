package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ListCheckBoxPage {
	
	WebDriver driver;
	
	public ListCheckBoxPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.NAME, using = "allbox") WebElement ToggleAllCheckBox;
	@FindBy(how = How.XPATH, using = "//form[@name='todo']/descendant::input[@type='checkbox']") WebElement ListCheckBoxElements;
	@FindBy(how = How.XPATH, using = "//input[@value='Remove']") WebElement RemoveButton;
	
	public void clickOneBox() {
		
		ListCheckBoxElements.click();
	}
	
	public void clickToggleAllCheckBox() {
		
		ToggleAllCheckBox.click();
	}
	
	public void clickRemoveButton() {
		
		RemoveButton.click();
	}

	public List<String> getListOfCheckBox() {
		
		List<String> list = new ArrayList<String>();
		List<WebElement> columDataElement = driver.findElements(By.xpath("//form[@name='todo']/descendant::input[@type='checkbox']"));
		
		for (int i = 0; i<columDataElement.size(); i++) {
			list.add(i,columDataElement.get(i).getText());
		}
		
		return list;
		
	}
	
	
}
