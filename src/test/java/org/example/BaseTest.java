package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException
    {
        service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//Abs209//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel4");
        options.setAvd("Pixel4");
        options.setChromedriverExecutable("C://Users//Abs209//AppData//Roaming//npm//node_modules//appium-chromedriver//chromedriver//win//chromedriver.exe");
        options.setApp("C://Users//Abs209//Documents//testAppium//appium//src//test//java//resources//General-Store.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @AfterClass
    public void tearDown()
    {
        driver.quit();
        service.stop();
    }
}
