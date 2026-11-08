public class Main {
    public static void main(String[] args) {
        DirectoryElement root = new DirectoryElement("root");
        DirectoryElement srcDir = new DirectoryElement("src");
        DirectoryElement docsDir = new DirectoryElement("docs");

        srcDir.addElement(new FileElement("Main.java", 15));
        srcDir.addElement(new FileElement("FileSystemVisitor.java", 8));
        docsDir.addElement(new FileElement("Report.docx", 120));
        docsDir.addElement(new FileElement("Diagram.png", 45));

        root.addElement(srcDir);
        root.addElement(docsDir);
        root.addElement(new FileElement("README.md", 5));

        // Run SizeCalculatorVisitor
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total size of file system: " + sizeVisitor.getTotalSizeInKb() + " KB");
        System.out.println(" ");

        // Run SearchVisitor
        SearchVisitor searchVisitor = new SearchVisitor(".java");
        root.accept(searchVisitor);
        System.out.println("Found files matching '.java': " + searchVisitor.getFoundFiles());
    }
}