package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfProperties {

    private static final Logger LOGGER = LogManager.getLogger(ConfProperties.class.getName());

    protected static Properties properties = new Properties();

    private ConfProperties() {
    }

    static {
        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            LOGGER.error("Error reading configuration file");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}



