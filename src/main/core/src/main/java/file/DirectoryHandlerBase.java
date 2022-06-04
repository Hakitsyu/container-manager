package file;

import java.nio.file.Path;

public class DirectoryHandlerBase {
    protected Path path;

    public DirectoryHandlerBase(Path path) {
        this.path = path;
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
}
