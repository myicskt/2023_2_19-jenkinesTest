package org;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
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
		try {
			// generate file name based on time
			String fileName = DateTimeFormatter.ofPattern("MM-dd-yyyy_hh-mm-ss").format(LocalDateTime.now());
			TakesScreenshot sn = (TakesScreenshot) driver;
			File file = sn.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("screenshots/"  + fileName + ".png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.quit();

	}

}
