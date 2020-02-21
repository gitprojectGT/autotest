package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;



public class PropertyLoader {

    private final static Logger log = Logger.getLogger(PropertyLoader.class.getName());
    public static final String CONFIG_PROPERTIES = "src/main/java/resources/config.properties";

    public static String loadProperty(String name) {
        return loadProperty(name, CONFIG_PROPERTIES);
    }

    public static String loadProperty(String name, String fromResource) {
        Properties props = new Properties();
        InputStream input;
        try {
            input = new FileInputStream(fromResource);
            props.load(input);
            input.close();
            return props.getProperty(name);
        } catch ( IOException e ) {
            log.info("Unable to load property for file: " + fromResource);
            e.printStackTrace();
            return e.getMessage();
        }
    }

}
