import org.junit.jupiter.api.Test;

import bsp.third_task.ProxyImage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProxyImageTest {

    @Test
    public void testProxyImageLazyLoading() {
        ProxyImage proxyImage = new ProxyImage("images.png");

        assertFalse(proxyImage.isRealImageCreated());

        proxyImage.display();
        assertTrue(proxyImage.isRealImageCreated());
    }
}
