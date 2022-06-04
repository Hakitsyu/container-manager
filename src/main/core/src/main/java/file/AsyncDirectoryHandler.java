package file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class AsyncDirectoryHandler {
    private Path path;

    public AsyncDirectoryHandler(Path path) {
        this.path = path;
        this.validatePath();
    }

    public AsyncDirectoryHandler(String path) {
        this.path = Paths.get(path);
        this.validatePath();
    }

    private void validatePath() {
        try {
            if (!this.path.toFile().isDirectory())
                throw new Exception("The path need be a directory path");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // This function will create directory inside this directory
    public CompletableFuture mkdir(String path) {
        return CompletableFuture.supplyAsync(() -> new File(this.path.toString(), path).mkdir());
    }

    // This function will delete file inside this directory
    public CompletableFuture deleteFile(String path) {
        return CompletableFuture.supplyAsync(() -> new File(this.path.toString(), path).delete());
    }

    // This function will create file inside this directory
    protected CompletableFuture createFile(String path) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return new File(this.path.toString(), path).createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    // This function will get file inside this directory
    protected CompletableFuture<File> getFile(String path) {
        return CompletableFuture.supplyAsync(() -> new File(this.path.toString(), path));
    }

    // This function will get files inside this directory
    protected CompletableFuture<List<File>> getFiles() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return Files.walk(this.path)
                        .map(Path::toFile).collect(Collectors.toList());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    // This function will get files inside directory inside this directory
    protected CompletableFuture<List<File>> getFiles(String path) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return Files.walk(Paths.get(this.path.toString(), path))
                        .map(Path::toFile).collect(Collectors.toList());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
