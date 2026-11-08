public class SizeCalculatorVisitor implements FileSystemVisitor {
    private int totalSizeInKb = 0;

    @Override
    public void visitFile(FileElement file) {
        totalSizeInKb += file.getSizeInKb();
    }

    @Override
    public void visitDirectory(DirectoryElement directory) {
        // Directory metadata size is 0 KB; child elements are visited during traversal
    }

    public int getTotalSizeInKb() {
        return totalSizeInKb;
    }
}