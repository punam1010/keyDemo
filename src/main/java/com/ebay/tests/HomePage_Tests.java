package com.ebay.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Testing.MavenFirstScript.Constant;
import com.Testing.MavenFirstScript.Keyword;

public class HomePage_Tests {
      @Test(priority=0)
	public static void Verify_Menu() {
    	  
      Keyword.LaunchBrowser("Chrome");
      Keyword.OpenUrl("https://www.ebay.com/");
      String expected_Menu[]= {"Home", "Saved", "Electronics", "Fashion", "Health & Beauty", "Motors", "Collectibles", "Sports", "Home & Garden", "Deals", "Under $10"};
      List<WebElement> sub_menu=Constant.driver.findElements(By.cssSelector(".hl-cat-nav__container>li"));
      ArrayList<String> Actual_Menu=new ArrayList<String>();
      Iterator<WebElement> itr=sub_menu.iterator();
      while(itr.hasNext()) {
    	  Actual_Menu.add(itr.next().getText());
      }
     boolean isEqual=Actual_Menu.containsAll(Arrays.asList(expected_Menu));
     Assert.assertTrue(isEqual);
	}
      @Test(priority=1)
      public static void maximize() {
    	  Keyword.maximize_Window();
      }
      @Test(priority=2)
  	public static void verifyLogo() {
  		boolean logo=Constant.driver.findElement(By.xpath("//img[@alt='eBay Logo']")).isDisplayed();
  		Assert.assertTrue(logo);
  	}
     
      @Test(priority=3)
      public static void verifyTitle() {
  		String title=Constant.driver.getTitle();
  		System.out.println("Page title is " +title);
  		Assert.assertEquals(title, "Electronics, Cars, Fashion, Collectibles & More | eBay");
  		/*if(title.equals("Electronics, Cars, Fashion, Collectibles &amp; More | eBay")) {
  			System.out.println("Pass: Correct Title");
  		}
  		else {
  			System.out.println("Fail: Incorrect Title");
  		}*/
  	} 
      @Test(priority=4)
      public static void click_register() {
    	  Keyword.clickOnElement("XPATH", "//a[contains(text(),'register')]");
    	  
      }
      @Test(priority=5)
      public static void enter_Text() {
    	  Keyword.enterText("XPATH", "//input[@name='firstname']", "Punam");
    	  Keyword.enterText("XPATH", "//input[@name='lastname']", "Shirsath");
    	  Keyword.enterText("XPATH", "//input[@name='email']", "punammatade10@gmail.com");
      }
}
  