package com.automation.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class base {
	public static String base_apk_path="C:\\Users\\Public\\Automation\\workspace\\appium\\src\\main\\resources\\apk\\";
	public static String app_name="ApiDemos-debug";
	public static DesiredCapabilities cap=new DesiredCapabilities();
	public static String connectionToServerLink="http://127.0.0.1:4723/wd/hub";
	
	public static AndroidDriver<AndroidElement> device() throws MalformedURLException {
		File f=new File(base_apk_path);
		File fs=new File(f,app_name);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "pixel");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath()+".apk");
		AndroidDriver<AndroidElement> ad=new AndroidDriver<>(new URL(connectionToServerLink), cap);
		return ad;
	}
}
