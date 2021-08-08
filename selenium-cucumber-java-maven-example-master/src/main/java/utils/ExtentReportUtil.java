package utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


public class ExtentReportUtil {

    static ExtentReports extentReports;
    static ExtentTest extentTest;
    static String currentPath = System.getProperty("user.dir");
    public static WebDriver driver = DriverUtil.getDriver();

    public void initializeReport(String scenario){
        try{
            extentReports = new ExtentReports(currentPath + "/target/" + scenario.toLowerCase()
                    .replace(" ", "-") + ".html",
                    false);

            extentReports.loadConfig(new File(currentPath + "/configs/extent-config.xml"));
            extentReports.addSystemInfo("Encore Application", "1.01");
            extentReports.addSystemInfo("Environment", "SIT");

            extentTest = extentReports.startTest(scenario.toString(), "Description: " + scenario);
            extentTest.assignAuthor("QE-Practices-SG");
            extentTest.assignAuthor("Gaurav Misra", "SANKAG4");
            extentTest.assignCategory("QE - US Mobile Regression Suite");
        }catch(Exception e){
            System.out.println("Error initializing extent report!");
        }
    }


    public void logStep( Scenario scenario, String status, String stepDescription) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        scenario.write(stepDescription);
        scenario.embed(Files.readAllBytes(screenshot.toPath()), "image/png");

        if(status.equalsIgnoreCase("info")){
            assertTrue(stepDescription, true);
            extentTest.log(LogStatus.INFO, stepDescription);
        }
        else if(status.equalsIgnoreCase("pass")){
            assertTrue(stepDescription, true);
            extentTest.log(LogStatus.PASS, stepDescription);
        }
        else if(status.equalsIgnoreCase("fail")){
            extentTest.log(LogStatus.FAIL, stepDescription);
            fail(stepDescription);
        }
        else if(status.equalsIgnoreCase("skip")){
            extentTest.log(LogStatus.SKIP, stepDescription);
        }
    }


    public void flushReport(){
        try{
            extentReports.endTest(extentTest);
            extentReports.flush();
            extentReports.close();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
    }
}
