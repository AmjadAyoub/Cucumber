package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfiqReader {
    static Properties prop;

    public static Properties readProperties(String filePath){
        try {
            FileInputStream fis = new FileInputStream(filePath);  // to locate the file
            prop = new Properties();
            prop.load(fis);
        } catch (FileNotFoundException e) {   // to handle if file is not found
            e.printStackTrace();
        } catch (IOException e) {    // to handle input/output exceptions
           e.printStackTrace();
        }
        return prop;

    }
    public static String getPropertyValue(String key){
        // get property is the method which will read the value as per the key provided
        return prop.getProperty(key);
    }

}
