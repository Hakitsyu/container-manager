package configuration.contexts;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import configuration.ConfigurationWriterContext;
import configuration.interfaces.IConfiguration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class JsonConfigurationWriter<T extends IConfiguration> extends ConfigurationWriterContext<T> {
    @Override
    public File execute(String path, T obj) {
        try {
            File file = new File(path);
            Writer writer = new FileWriter(file);
            Gson gson = new GsonBuilder().create();
            gson.toJson(obj, writer);
            writer.flush();
            writer.close();
            return file;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
