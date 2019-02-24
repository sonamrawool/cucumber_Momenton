package reusableFunctions;

import static ObjectIds.xpaths.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class reusableFunctions extends CommonReusableFunctions{

		
	public void homePage(String url) {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\framework\\cucumber-sonam\\cucumber_sonam\\chromedriver.exe");
		driver.get(url);
		driver.manage().window().maximize();
	}

	public void login(String userName, String password) {
		setValueInTextField(Username, userName);
		setValueInTextField(Password, password);
		takeScreenshot("user is able to set username and password");
		clickLink(LoginButton);		
		
		takeScreenshot("user is able to login");
	}

	public void placeOrder() {
		clickLink(Order);
		Select dropdown = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
		dropdown.selectByVisibleText("MyMoney");
		setValueInTextField(Quantity, "2");
		setValueInTextField(CustomerName, "Sonam Rawool");
		setValueInTextField(Street, "Collins");
		setValueInTextField(City, "Melbourne");
		setValueInTextField(State, "Victory");
		setValueInTextField(Zip, "3000");
		clickLink(CardRadioBtn);
		setValueInTextField(CardNo, "1234567890");
		setValueInTextField(Expiry, "11/19");
		takeScreenshot("user has added all the details for Order.");
		clickLink(ProcessButton);
		takeScreenshot("user is able to place order");
	}

	public void updateOrder() throws InterruptedException {
		clickLink(ViewAllOrders);
		clickLink(OrderSelector);
		clickLink(EditOrder);
		setValueInTextField(City, "Sydney");
		setValueInTextField(State, "NSW");
		takeScreenshot("user is able to update order");
		clickLink(UpdateOrder);
		takeScreenshot("user is able to update the order");
	}

	public void deleteOrder() {
		clickLink(OrderSelector);
		takeScreenshot("user has selected the order to Delete");
		clickLink(DeleteOrder);
takeScreenshot("user is able to delete the order");
	}

	public void logOut() {
		clickLink(Logout);
		takeScreenshot("user is able to Logout.");
		driver.quit();
	}
}




