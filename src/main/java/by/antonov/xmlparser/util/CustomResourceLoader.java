package by.antonov.xmlparser.util;

import java.io.File;

public class CustomResourceLoader {
    private CustomResourceLoader() {}

    public static File getResourceFile(String filepath) {
        return new File(ClassLoader.getSystemResource(filepath).getPath());
    }
}
