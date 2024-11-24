package bsp.thirdtask;

public class ProxyImage implements MyImage {
    private RealImage realImage;
    private final String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }

    public boolean isRealImageCreated() {
        return realImage != null;
    }
}