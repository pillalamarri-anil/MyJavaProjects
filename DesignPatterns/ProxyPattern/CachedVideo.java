package DesignPatterns.ProxyPattern;

public class CachedVideo implements Video {

    private String name;
    private Video video;

    public CachedVideo(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        if (video == null) {
            video = new OriginalVideo(name);
        }
        System.out.println("Playing Cached video: " + video.getName());
    }

    @Override
    public String getName() {
        return name;
    }
}
