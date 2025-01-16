package com.test.basicmethods;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SpecFileReader {
    public Map<String, String> elementMap = new HashMap<>();

    public SpecFileReader(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String currentElementToken = null;
            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.contains("xpath:")) {
                    String xpath = line.split("xpath:")[1].trim();
                    if (currentElementToken != null) {
                        elementMap.put(currentElementToken, xpath);
                    }
                }

                if (line.contains(":")) {
                    currentElementToken = line.split(":")[0].trim();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getXPath(String elementToken) {
        return elementMap.get(elementToken);
    }
}
