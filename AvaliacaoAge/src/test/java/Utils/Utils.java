package Utils;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import Teste.TesteCucumber;
public class Utils {
	//Tira um print e grava com o nome do passo
	private static void efetuarPrintTela(String strLog) {
		File scrFile = ((TakesScreenshot) TesteCucumber.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile,
					new File(System.getProperty("user.dir") + "\\src\\test\\resources\\" + strLog + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//Junta o print e o nome do passo como um log
	public static void logPrint(Status status,String strLog) {
		strLog = strLog.replace(' ', '_');
		ExtentTest extentTest = TesteCucumber.getExtentTest();
		try {
			efetuarPrintTela(strLog);
			extentTest.log(status, strLog.replace('_', ' '),
					MediaEntityBuilder
							.createScreenCaptureFromPath(
								"file:\\"+ System.getProperty("user.dir") + "\\src\\test\\resources\\" + strLog + ".png")
							.build());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//Realiza o log do passo sinalizando o campo que esta sendo executado a devida a��o
	public static void log(Status status, WebElement element, String strLog) {
		JavascriptExecutor js = (JavascriptExecutor) TesteCucumber.getDriver();
		try {
			js.executeScript("arguments[0].scrollIntoView(false);", element);
			js.executeScript("arguments[0].setAttribute('style', 'border: solid 2px red');", element);
			Thread.sleep(500);
			logPrint(status, strLog);
			js.executeScript("arguments[0].setAttribute('style', 'border: none');", element);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}  
	}
}