package com.apps.app1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestFile {
	WebDriver dr ;
	
	@BeforeMethod
	public void t1() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe") ;		
		dr = new ChromeDriver() ;
		dr.manage().window().maximize();
		dr.get("http://demo.automationtesting.in/Register.html");	
		dr.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void test1() {
		String xpath = "//*[contains(text(),'Automation Demo Site')]" ;
		String ele = dr.findElement(By.xpath(xpath)).getText() ;
		System.out.println("Actual Value - "+ele);
		Assert.assertEquals(ele, "Automation Demo Sitee");		
	}
	
	@AfterMethod
	public void tearOut() {
		dr.quit();
	}

}
