package projectUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//Here we are using singleton class which will allow only one instance of the object
//to be created no matter how many times you try that instance is returned everytime.
// used when you want to manage shared resources like configReader
public class ConfigReader {

        // singleton class holds single private instance of class
        private static ConfigReader instance;
        private Properties properties;

        // private constructor for singleton pattern prevents external clases from creating new objects
        private ConfigReader(){
            loadProperties();
        }

        // singleton getInstance static method
        public static ConfigReader getInstance(){
            if(instance == null){
                instance = new ConfigReader();
            }
            return instance;
        }

        // load properties from file
        private void loadProperties(){
            properties = new Properties();
            try{
                FileInputStream file = new FileInputStream(".idea/src/test/resources/config.properties");
                properties.load(file);
            }
            catch(IOException e){
                throw new RuntimeException("Config file not found: " + e.getMessage());
            }
        }

        public String getAppUrl(){
            return properties.getProperty("app.url");
        }

        public String getApiBaseUrl(){
            return properties.getProperty("app.base.url");
        }

        public String getBrowser(){
            return properties.getProperty("browser");
        }

        public String getManagerUserId(){
            return properties.getProperty("manager.userId");
        }

        public String getManagerPassword(){
            return properties.getProperty("manager.password");
        }

        public int getTimeout(){
            return Integer.parseInt(properties.getProperty("timeout"));
        }

        public boolean isHeadless(){
            return Boolean.parseBoolean(properties.getProperty("headless"));
        }

        public String getReportPath(){
            return properties.getProperty("report.path");
        }

}
