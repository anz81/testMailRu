package com.acme.mailsend;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfProperties {
    private Properties properties;
    private FileInputStream fileInputStream;

    public ConfProperties() {
        try {
            fileInputStream = new FileInputStream("src/test/resources/conf.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
