package ObjectIds;

import org.openqa.selenium.By;

public interface xpaths {
//---login--
By Username = By.id("ctl00_MainContent_username");
By Password = By.id("ctl00_MainContent_password");
By LoginButton = By.id("ctl00_MainContent_login_button");

//---Place Order---
By Order = By.linkText("Order");
By Quantity = By.id("ctl00_MainContent_fmwOrder_txtQuantity");
By CustomerName = By.id("ctl00_MainContent_fmwOrder_txtName");
By Street = By.id("ctl00_MainContent_fmwOrder_TextBox2");
By City = By.id("ctl00_MainContent_fmwOrder_TextBox3");
By State = By.id("ctl00_MainContent_fmwOrder_TextBox4");
By Zip = By.id("ctl00_MainContent_fmwOrder_TextBox5");
By CardRadioBtn = By.id("ctl00_MainContent_fmwOrder_cardList_0");
By CardNo = By.id("ctl00_MainContent_fmwOrder_TextBox6");
By Expiry = By.id("ctl00_MainContent_fmwOrder_TextBox1");
By ProcessButton = By.linkText("Process");

//---Update Order---
By ViewAllOrders = By.linkText("View all orders");
By OrderSelector = By.id("ctl00_MainContent_orderGrid_ctl02_OrderSelector");
By EditOrder = By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[2]/td[13]/input");
By UpdateOrder = By.linkText("Update");

//---Delete Order---
By DeleteOrder = By.id("ctl00_MainContent_btnDelete");

//---Logout---
By Logout = By.id("ctl00_logout");
}
