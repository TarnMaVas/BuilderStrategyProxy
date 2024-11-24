import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import bsp.thirdtask.ProxyImage;

public class ProxyImageTest {

    @Test
    public void testProxyImageLazyLoading() {
        ProxyImage proxyImage = new ProxyImage("images.png");

        Assertions.assertFalse(proxyImage.isRealImageCreated());

        proxyImage.display();
        Assertions.assertTrue(proxyImage.isRealImageCreated());
    }
}
