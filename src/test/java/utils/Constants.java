package utils;

public class Constants {
   // to provide the path
    public static final String CONFIGURATION_FILEPATH =     // for final methods we write the method name letters in uppercase
            System.getProperty("user.dir") + "/src/test/resources/confiq/confiq.properties";

    public static final int EXPLICIT_WAIT = 20;
    public static final int IMPLICIT_WAIT = 10;

    public static final String TESTDATA_FILEPATH =
            System.getProperty("user.dir") + "/src/test/resources/testdata/batch14excel.xlsx";

    public static final String SCREENSHOT_FILEPATH =   System.getProperty("user.dir") + "/screenshots/";

}
