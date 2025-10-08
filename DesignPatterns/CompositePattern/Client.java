package DesignPatterns.CompositePattern;

public class Client {

    public static void main(String[] args) {
        FileSystem file1 = new File("file1.txt", 100);
        FileSystem file2 = new File("file2.txt", 200);
        FileSystem file3 = new File("file3.txt", 300);

        Directory dir1 = new Directory("dir1");
        dir1.add(file1);
        dir1.add(file2);

        Directory dir2 = new Directory("dir2");
        dir2.add(file3);
        dir2.add(dir1);

        System.out.println("Total size of dir2: " + dir2.getSize() + " bytes");
        System.out.println("Details of dir2:");
        dir2.showDetails("");
    }
}
