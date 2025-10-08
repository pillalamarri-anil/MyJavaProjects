package DesignPatterns.CompositePattern;

public class File implements FileSystem{

    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void showDetails(String indent) {
        System.out.println(indent + "File: " + name + " (Size: " + size + " bytes)");
    }
}
