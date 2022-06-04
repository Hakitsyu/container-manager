package file.interfaces;

import java.io.File;
import java.util.List;

public interface IDirectoryHandler {
    void mkdir(String path);
    void deleteFile(String path);
    void createFile(String path);
    File getFile(String path);
    List<File> getFiles();
    List<File> getFiles(String path);
}
