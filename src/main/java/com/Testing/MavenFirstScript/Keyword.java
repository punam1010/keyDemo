package com.Testing.MavenFirstScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keyword {
	public static void LaunchBrowser(String BrowserName) {
	      switch(BrowserName) {
	      case "Chrome":
	    	  WebDriverManager.chromedriver().setup();
	    	  Constant.driver=new ChromeDriver();
	    	  break;
	      case "IE":
	    	  WebDriverManager.iedriver().setup();
	    	  Constant.driver=new InternetExplorerDriver();
	    	  break;
	      case "FireFox":
	    	  WebDriverManager.firefoxdriver().setup();
	    	  Constant.driver=new FirefoxDriver();
	    	  break;
	    	  default:
	    		  System.out.println("Invalid Browser "  +BrowserName);
	      }
		}
		/**
		 * It opens URL in Specified Browser
		 * @param url{@code: String} URL to open
		 * @return void
		 * @author Punam
		 */
		public static void OpenUrl(String url) {
			Constant.driver.get(url);

		}
		public static void maximize_Window() {
			Constant.driver.manage().window().maximize();

		}
		public static WebElement getWebElement(String locatortype,String locatorValue) {
			WebElement element=null;
			
			switch(locatortype) {
			case "XPATH":
				element=Constant.driver.findElement(By.xpath(locatorValue));
				break;
			case "CSS":
				element=Constant.driver.findElement(By.cssSelector(locatorValue));
				break;
			case "ID":
				element=Constant.driver.findElement(By.id(locatorValue));
				break;
			case "CLASS_NAME":
				element=Constant.driver.findElement(By.className(locatorValue));
				break;
			case "LINK_TEXT":
				element=Constant.driver.findElement(By.linkText(locatorValue));
				break;
			case "PARTIAL_LINK_TEXT":
				element=Constant.driver.findElement(By.partialLinkText(locatorValue));
				break;
				default:
					System.out.println("Invalid Locator Type");
					break;
					
			}
			return element;
			

		}
		public static void clickOnElement(String locatortype, String locatorValue) {
			getWebElement(locatortype,locatorValue).click();
			
			
			
		}
		public static void enterText(String locatortype, String locatorValue, String text) {
			getWebElement(locatortype,locatorValue).sendKeys(text);

		}
		public static void handleDrop_Down(String locatortype, String locatorValue, String selectText) {

			WebElement element=getWebElement(locatortype,locatorValue);
			Select select=new Select(element);
			select.selectByVisibleText(selectText);

		}
		public static void search_Text(String locatortype, String locatorValue, String serachText) {
			getWebElement(locatortype,locatorValue).sendKeys(serachText);

		}

}
