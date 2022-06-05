package configuration.contexts.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import configuration.ConfigurationWriterContext;
import configuration.contexts.json.exceptions.NotValidJsonException;
import configuration.interfaces.IConfiguration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class JsonConfigurationWriter<T extends IConfiguration> extends ConfigurationWriterContext<T> {
    @Override
    public File execute(File file, T obj) {
        try {
            Writer writer = new FileWriter(file);
            Gson gson = new GsonBuilder().create();
            gson.toJson(obj, writer);
            writer.flush();
            writer.close();
            return file;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public File prepare(File file) {
        try {
            if (!JsonHelper.validate(file))
                throw new NotValidJsonException();
            return file;
        } catch (NotValidJsonException ex) {
            throw new RuntimeException(ex);
        }
    }
}
