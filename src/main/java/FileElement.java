public class FileElement implements FileSystemElement {
    private final String name;
    private final int sizeInKb;

    public FileElement(String name, int sizeInKb) {
        this.name = name;
        this.sizeInKb = sizeInKb;
    }

    public String getName() {
        return name;
    }

    public int getSizeInKb() {
        return sizeInKb;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visitFile(this);
    }
}