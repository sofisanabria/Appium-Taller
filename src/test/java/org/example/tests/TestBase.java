package org.example.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static java.time.Duration.ofSeconds;

public class TestBase {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException {

        // Obtiene la ruta del directorio de inicio de usuario
        String path = System.getProperty("user.home");

        // Crea una instancia de AppiumDriverLocalService y la configura con el archivo main.js de Appium
        // Además setea la dirección IP y el número de puerto para el servidor de Appium.
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File(path + "\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        // Inicia el servicio de Appium
        service.start();

        // Crea una instancia de UiAutomator2Options y la configura con el nombre del dispositivo y el archivo APK para la aplicación que se va a probar.
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel4");
        // Levanta el emulador donde se ejecutaran las pruebas
        options.setAvd("Pixel4");
        options.setApp(path + "\\Downloads\\Appium-Taller\\src\\test\\java\\resources\\General-Store.apk");

        // Crea una instancia de AndroidDriver e inicialíza con la URL del servidor de Appium y la instancia de UiAutomator2Options.
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        // Establece el tiempo de espera implícito para el controlador.
        driver.manage().timeouts().implicitlyWait(ofSeconds(50));
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();
    }

}
