package utility;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertyReader {
    private static Properties properties = null;

    public static String getProperty(String propertyName) {
        String value = System.getProperty(propertyName);
        if (value != null) return value;
        if (properties == null) readProperties();
        value = properties.getProperty(propertyName);
        return value;
    }

    private static void readProperties() {
        try (InputStream input = Files.newInputStream(Paths.get("config.properties"))) {
            Properties prop = new Properties();
            prop.load(input);

            properties = prop;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
