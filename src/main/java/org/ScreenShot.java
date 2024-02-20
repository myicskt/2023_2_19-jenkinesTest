package org;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Base {

	public void takeScreenShot(WebDriver driver, String pageName) {
		try {
			// generate file name based on time
			String fileName = DateTimeFormatter.ofPattern("MM-dd-yyyy_hh-mm-ss").format(LocalDateTime.now());
			TakesScreenshot sn = (TakesScreenshot) driver;
			File file = sn.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("screenshots/" + pageName + fileName + ".png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
