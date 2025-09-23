import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadAndWriteDataFromPropertiesFile {

    public static void readDataFromPropertiesFile(FileInputStream fileInputStream) throws IOException {
        Properties properties = new Properties();
        properties.load(fileInputStream);

        System.out.println(properties.getProperty("username"));
        System.out.println(properties.getProperty("password"));
        System.out.println(properties.getProperty("url"));
    }

    public static void writeDataIntoPropertiesFile(FileInputStream fileInputStream) throws IOException {
        Properties properties = new Properties();
        properties.load(fileInputStream);

        properties.put("url","https://rahulshettyacademy.com/loginpagePractise/");

        FileOutputStream fileOutputStream = new FileOutputStream(System.getProperty("user.dir")+"\\src\\main\\testData\\testData.properties");
        properties.store(fileOutputStream, "added url");
    }

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\testData\\testData.properties");
        writeDataIntoPropertiesFile(fileInputStream);
        readDataFromPropertiesFile(fileInputStream);
    }
}
