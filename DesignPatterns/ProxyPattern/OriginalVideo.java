package DesignPatterns.ProxyPattern;

public class OriginalVideo implements Video {

    private String name;

    public OriginalVideo(String name) {
        this.name = name;
        System.out.println("Loading original video: " + name);
    }

    @Override
    public void play() {
        System.out.println("Playing original video: " + name);
    }

    @Override
    public String getName() {
        return name;
    }
}
