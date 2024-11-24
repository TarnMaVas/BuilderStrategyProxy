import org.junit.jupiter.api.Test;

import bsp.task3.ProxyImage;

import static org.junit.jupiter.api.Assertions.*;

public class ProxyImageTest {

    @Test
    public void testProxyImageLazyLoading() {
        ProxyImage proxyImage = new ProxyImage("images.png");

        assertFalse(proxyImage.isRealImageCreated());

        proxyImage.display();
        assertTrue(proxyImage.isRealImageCreated());
    }
}
