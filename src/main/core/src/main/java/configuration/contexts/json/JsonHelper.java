package configuration.contexts.json;

import java.io.File;

public class JsonHelper {
    public static String FILE_EXTENSION = "json";

    public static boolean validate(File file) {
        return !file.isDirectory()
                && file.getName().contains(".")
                && file.getName().split("\\.")[1].toLowerCase().equals(JsonHelper.FILE_EXTENSION);
    }
}
