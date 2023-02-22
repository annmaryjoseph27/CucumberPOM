package com.cucumberpom.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.cucumberpom.utils.Constants;
import com.cucumberpom.utils.DateUtils;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class BasePage {
	
	public static WebDriver driver;
	public static Properties prop;
	public Actions act;
	public static XWPFDocument document;
	public static XWPFParagraph paragraph;
	public static XWPFRun run;
	public static FileOutputStream fout;
	
	public BasePage() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\cucumberpom\\config\\config.properties");
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void initBrowser() {
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		}else {
			System.out.println("Chrome is not defined in config file");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_TIMEOUT));
		
		
	}
	public static void initFile() throws FileNotFoundException {
		document = new XWPFDocument();
		paragraph = document.createParagraph();
        run = paragraph.createRun();
		fout = new FileOutputStream(new File(System.getProperty("user.dir")+"\\results\\WordFile.docx"));
	}
	
	public static void closeFile() throws IOException {
   		document.write(fout);
		 fout.close();
	     document.close();
	}
	public static String getTitle() {
		return driver.getTitle();
		
	}
	
	public static void takeScreenshot() throws IOException, InvalidFormatException {
			String date = DateUtils.getTimeStamp();
//			Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
//			ImageIO.write(screenshot.getImage(), "png", new File(System.getProperty("user.dir")+"//Screenshots//Screenshots"+date+".png"));
//			saveResults(date);
			
		
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir")+"//Screenshots//Screenshots"+date+".png");
		
		try {
			FileUtils.copyFile(sourceFile, destFile);
			saveResults(date);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}		
	
		
	
	public static void saveResults(String date) throws IOException, InvalidFormatException {
	
		
        File image = new File(System.getProperty("user.dir")+"//Screenshots//Screenshots"+date+".png");
        FileInputStream imageData = new FileInputStream(image);
		
        int imageType = XWPFDocument.PICTURE_TYPE_JPEG;
        String imageFileName = image.getName();
        int width = 450;
        int height = 400;
        run.addBreak();
        run.addPicture(imageData, imageType, imageFileName,Units.toEMU(width),Units.toEMU(height));
        image.delete();
 
        	    
	}

}
