package core.factory;

public class ContainerFactoryOptions {
    public static final Integer DEFAULT_DIRECTORY_NAME_SIZE =  8;

    private Integer directoryNameSize;

    public int getDirectoryNameSize() {
        return directoryNameSize != null ? directoryNameSize : DEFAULT_DIRECTORY_NAME_SIZE;
    }

    public ContainerFactoryOptions setDirectoryNameSize(int directoryNameSize) {
        this.directoryNameSize = directoryNameSize;
        return this;
    }
}
