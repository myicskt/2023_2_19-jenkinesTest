package org;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DroupDownHandlemultiselect {

	WebDriver driver;

	@Test
	public void dropDown() {
		driver = new ChromeDriver();
		driver.get("https://hamropicture.w3spaces.com/drop-down.html");

		WebElement dropdownElement = driver.findElement(By.xpath("//*[@id=\"selectoption1\"]"));
		Select select = new Select(dropdownElement);
		select.selectByIndex(2);

		List<WebElement> list = select.getAllSelectedOptions();
		System.out.println(list.size());
		for (WebElement a : list) {
			System.out.println("list " + a.getText());

		}
		if(select.getAllSelectedOptions().size()<1){
			Assert.assertTrue(false);
		}else {
			Assert.assertTrue(true);
		}

		driver.quit();

	}

}
