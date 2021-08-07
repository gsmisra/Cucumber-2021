package utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.File;

public class ExtentReportUtil {

    static ExtentReports extentReports;
    static ExtentTest extentTest;
    static String currentPath = System.getProperty("user.dir");

    public void initializeReport(String scenario){
        try{
            extentReports = new ExtentReports(currentPath + "/target/" + scenario.toLowerCase()
                    .replace(" ", "-") + ".html",
                    true);

            extentReports.loadConfig(new File(currentPath + "/configs/extent-config.xml"));
            extentReports.addSystemInfo("Encore Application", "1.01");
            extentReports.addSystemInfo("Environment", "SIT");

            extentTest = extentReports.startTest(scenario, "Description: " + scenario);
            extentTest.assignAuthor("QE-Practices-SG");
            extentTest.assignAuthor("Gaurav Misra", "SANKAG4");
            extentTest.assignCategory("QE - US Mobile Regression Suite");
        }catch(Exception e){
            System.out.println("Error initializing extent report!");
        }
    }


    public void logStep(String status, String stepDescription){
        if(status.equalsIgnoreCase("info")){
            extentTest.log(LogStatus.INFO, stepDescription);
        }
        else if(status.equalsIgnoreCase("pass")){
            extentTest.log(LogStatus.PASS, stepDescription);
        }
        else if(status.equalsIgnoreCase("fail")){
            extentTest.log(LogStatus.FAIL, stepDescription);
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
