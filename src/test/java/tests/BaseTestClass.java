package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import utils.ConfProperties;
import utils.GenerateRandomData;
import utils.Screenshots;

import java.time.Duration;

public class BaseTestClass {

    public static WebDriver driver;
    private static boolean isTestStarted;
    private static boolean takeScreenshot;
    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseTestClass.class);

    protected static String generatedFirstName = GenerateRandomData.generateFirstName();
    protected static String generatedLastName = GenerateRandomData.generateLastName();
    protected static String generatedNickName = GenerateRandomData.generateNickName();


    @BeforeClass
    public void setup() throws WebDriverException {
        if (!isTestStarted) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            new WebDriverWait(driver, Duration.ofSeconds(10));
            takeScreenshot = Boolean.parseBoolean(ConfProperties.getProperty("take_screenshot_on_fail"));
            isTestStarted = true;
        }
    }

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            driver.close();
            driver.quit();
        }));
    }

    @AfterMethod
    public void takeScreenshot(ITestResult result) {
        if (takeScreenshot) {
            if (ITestResult.FAILURE == result.getStatus()) {
                Screenshots.takeScreenshot(driver, result.getName());
            }
        }
    }

}
