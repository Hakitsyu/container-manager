package configuration.interfaces;

import configuration.contexts.json.exceptions.NotValidJsonException;

import java.io.File;

public interface IConfigurationPrepareContext {
    File prepare(File file);
}
