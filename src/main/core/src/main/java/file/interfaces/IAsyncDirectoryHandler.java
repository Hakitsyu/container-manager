package file.interfaces;

import java.io.File;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface IAsyncDirectoryHandler {
    CompletableFuture mkdir(String path);
    CompletableFuture deleteFile(String path);
    CompletableFuture createFile(String path);
    CompletableFuture<File> getFile(String path);
    CompletableFuture<List<File>> getFiles();
    CompletableFuture<List<File>> getFiles(String path);
}
