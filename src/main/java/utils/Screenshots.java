package utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Screenshots {

    private static final Logger LOGGER = LogManager.getLogger(Screenshots.class.getName());

    public static void takeScreenshot(WebDriver driver, String screenshotName) {
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.simple())
                .takeScreenshot(driver);

        createDirectoryIfNotExists();

        try {
            ImageIO.write(screenshot.getImage(), "png", new File("./Screenshots/" + screenshotName + ".png"));
            LOGGER.info("Screenshot created successfully");
        } catch (IOException e) {
            LOGGER.error("Error creating screenshot {}", e.getMessage());
        }
    }

    private static void createDirectoryIfNotExists() {
        File directory = new File("Screenshots");
        try {
            if (!directory.exists()) {
                directory.mkdir();
                LOGGER.info("Screenshots directory created successfully");
            }
        } catch (Exception e) {
            LOGGER.error("Error creating screenshots directory {}", e.getMessage());
        }


    }

}
