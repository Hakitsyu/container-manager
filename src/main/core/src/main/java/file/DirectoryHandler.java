package file;

import file.interfaces.IDirectoryHandler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class DirectoryHandler extends DirectoryHandlerBase implements IDirectoryHandler {

    public DirectoryHandler(Path path) {
        super(path);
    }

    public DirectoryHandler(String path) {
        super(Paths.get(path));
    }

    // This function will create directory inside this directory
    public void mkdir(String path) {
        new File(this.path.toString(), path).mkdir();
    }

    // This function will delete file inside this directory
    public void deleteFile(String path) {
        new File(this.path.toString(), path).delete();
    }

    // This function will create file inside this directory
    public void createFile(String path) {
        try {
            new File(this.path.toString(), path).createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // This function will get file inside this directory
    public File getFile(String path) {
        return new File(this.path.toString(), path);
    }

    // This function will get files inside this directory
    public List<File> getFiles() {
        try {
            return Files.walk(this.path)
                    .map(Path::toFile).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // This function will get files inside directory inside this director
    public List<File> getFiles(String path) {
        try {
            return Files.walk(Paths.get(this.path.toString(), path))
                    .map(Path::toFile).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
