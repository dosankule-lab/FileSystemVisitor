public class FileSystemVisitorTest {

    public static void main(String[] args) {
        testSizeCalculatorVisitor();
        testSearchVisitor();
        testDirectoryImmutabilityAndEmptyCheck();
        System.out.println("All unit tests passed successfully");
    }

    public static void testSizeCalculatorVisitor() {
        DirectoryElement root = new DirectoryElement("root");
        root.addElement(new FileElement("A.java", 10));
        root.addElement(new FileElement("B.txt", 25));

        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);

        if (sizeVisitor.getTotalSizeInKb() != 35) {
            throw new AssertionError("Expected 35 KB, but got " + sizeVisitor.getTotalSizeInKb());
        }
    }

    public static void testSearchVisitor() {
        DirectoryElement root = new DirectoryElement("root");
        root.addElement(new FileElement("Main.java", 15));
        root.addElement(new FileElement("Notes.txt", 5));

        SearchVisitor searchVisitor = new SearchVisitor(".java");
        root.accept(searchVisitor);

        if (searchVisitor.getFoundFiles().size() != 1) {
            throw new AssertionError("Expected 1 matching file, but got " + searchVisitor.getFoundFiles().size());
        }
    }

    public static void testDirectoryImmutabilityAndEmptyCheck() {
        DirectoryElement dir = new DirectoryElement("emptyDir");
        if (!dir.isEmpty() || dir.size() != 0) {
            throw new AssertionError("New directory must be empty with size 0");
        }
        dir.addElement(new FileElement("Test.java", 10));
        if (dir.isEmpty() || dir.getElements().size() != 1) {
            throw new AssertionError("Directory should contain exactly 1 element");
        }
    }
}