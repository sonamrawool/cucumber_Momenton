package runner;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import reusableFunctions.reusableFunctions;

import static reusableFunctions.reusableFunctions.*;

public class testcase {
	
reusableFunctions ReusableFunctions = new reusableFunctions();	

@Test
public void functionname() throws InterruptedException {
	ReusableFunctions.homePage("");
	ReusableFunctions.login("Tester", "test");
	ReusableFunctions.placeOrder();
	ReusableFunctions.updateOrder();
	ReusableFunctions.deleteOrder();
	ReusableFunctions.logOut();
	
	 
}
}
