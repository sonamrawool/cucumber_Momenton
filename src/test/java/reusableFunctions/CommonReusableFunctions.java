package reusableFunctions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


public class CommonReusableFunctions{

	public static WebDriver driver = new ChromeDriver();
	public static ArrayList<String> TestStep = new ArrayList<String>();
	public static String TestcaseName = "";
	
	public WebElement findObject(final By by) {
		try {
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(100, TimeUnit.SECONDS)
					.pollingEvery(2, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			WebElement pageDisplayed = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(by)));
			return pageDisplayed;
		} catch (Throwable t) {
			// Terminate the test case in case exception is thrown
			System.out.println("element not found : "+by);
		}	
		return null;
	}


	public void setValueInTextField(final By by, String value) {

		findObject(by).click();
		findObject(by).clear();
		findObject(by).sendKeys(value);
		System.out.println("Text Field: '" + by.toString() + "'. Value '" + value + "' entered");
	}

	public void clickLink(final By by) {
		WebElement abj = findObject(by);
		abj.click();
		System.out.println("Link: '" + by.toString() + "' clicked");

	}
	
	
	 public  void takeScreenshot(String desc)
	 {
		 File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);        
		 try {
			 FileUtils.copyFile(scrFile, new File("target\\screenshot\\"+TestcaseName+"\\"+System.currentTimeMillis()+".jpg"));
			 TestStep.add(desc);
			
			
		 } catch (IOException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }
	 }



	 public void ScreenshotToPDf() {

		String Testcase =  TestcaseName;
		 Document document = new Document();


		 String path = "target\\screenshot\\"+Testcase+"\\";

		 int count = FilesCount(path);
		 System.out.println("count" + count);
		 try {
			 PdfWriter.getInstance(document, new FileOutputStream(path + Testcase + ".pdf"));
		 } catch (FileNotFoundException e1) {
			 // TODO Auto-generated catch block
			 System.out.println("No Screenshot present to Convert into Pdf");

		 } catch (DocumentException e1) {
			 // TODO Auto-generated catch block
			 e1.printStackTrace();
		 }
		 document.open();
		 String[] fileNames = new File(path).list();
		 Font font1 = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
		 for (int i = 1; i <= count; i++)
		 {
			 String namefile = path + fileNames[i-1];//Testcase + "_" + i + ".jpg";
			 System.out.println("namefile" + namefile);
			 try {
				 if ((i % 2 == 1) && (i > 1)) {
					 document.newPage();
				 }
				 //  document.add(new Paragraph(Testcase + "_" + i, font1));

				 document.add(Chunk.NEWLINE);


				 /* if(i<=(count-1))
		            {*/
				 String s = (String) TestStep.get(i-1);


				 document.add(new Paragraph(s, font1)); 
				 //  }
				 //document.add(new Paragraph(Testcase+"_"+i+".jpg"));
				 document.add(Chunk.NEWLINE);
				 //document.add(Chunk.NEWLINE );
				 Image image1 = Image.getInstance(namefile);
				 image1.scaleAbsolute(500f, 300f);
				 document.add(image1);
				 document.add(Chunk.NEWLINE);
				 new File(namefile).delete();

			 } catch (Exception e) {
				 e.printStackTrace();
			 }
		 }

		 document.close();
		 TestStep.clear();


	 }

	 public int FilesCount(String folderPath) {
		 //String namefile=path+Testcase+"_"+i+".jpg";
		 System.out.println("folderPath" + folderPath);
		 String[] fileNames = new File(folderPath).list();
		 System.out.println("nitish ====="+fileNames[0]);
		 System.out.println("fileNames"+fileNames.length);
		 //System.out.println("fileNames.length"+fileNames.length);
		 int total = 0;
		 for (int i = 0; i < fileNames.length; i++) {
			 String suffix = ".jpg";
			 if (fileNames[i].toLowerCase().endsWith(suffix)) {
				 total++;
			 }

		 }
		 //System.out.println("total"+total);
		 return total;
	 }
}
