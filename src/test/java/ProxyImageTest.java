import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import bsp.thirdtask.ProxyImage;

public class ProxyImageTest {

    @Test
    public void testProxyImageLazyLoading() {
        URL resource = getClass().getClassLoader().getResource("images.png");

        String imagePath = null;
        try {
            imagePath = Paths.get(resource.toURI()).toString();
        } catch (URISyntaxException e) {
            Assertions.fail("Failed to convert resource URL to URI", e);
        }

        ProxyImage proxyImage = new ProxyImage(imagePath);

        Assertions.assertFalse(proxyImage.isRealImageCreated());

        proxyImage.display();
        Assertions.assertTrue(proxyImage.isRealImageCreated());
    }
}
