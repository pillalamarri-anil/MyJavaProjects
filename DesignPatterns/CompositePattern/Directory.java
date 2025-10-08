package DesignPatterns.CompositePattern;

import java.util.List;

public class Directory implements FileSystem
{
    private List<FileSystem> children;
    private String name;

    public Directory(String name) {
        this.name = name;
    }

    public void add(FileSystem child) {
        children.add(child);
    }

    public void remove(FileSystem child) {
        children.remove(child);
    }

    @Override
    public int getSize() {

        int totalSize = 0;
        for (FileSystem child : children)
        {
            totalSize += child.getSize();
        }
        return totalSize;
    }

    @Override
    public void showDetails(String indent) {

        System.out.println(indent + "Directory: " + name + " (Size: " + getSize() + " bytes)");

        for (FileSystem child : children)
        {
            child.showDetails(indent);
        }
    }
}
