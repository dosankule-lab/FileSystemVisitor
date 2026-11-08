import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private final String keyword;
    private final List<String> foundFiles = new ArrayList<>();

    public SearchVisitor(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void visitFile(FileElement file) {
        if (file.getName().contains(keyword)) {
            foundFiles.add(file.getName() + " (" + file.getSizeInKb() + " KB)");
        }
    }

    @Override
    public void visitDirectory(DirectoryElement directory) {
        if (!directory.isEmpty()) {
            System.out.println("Searching in directory: /" + directory.getName()
                    + " (" + directory.getElements().size() + " items)");
        }
    }

    public List<String> getFoundFiles() {
        return List.copyOf(foundFiles);
    }
}