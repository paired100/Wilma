package net.lightbody.bmp.proxy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class ProxyServerTest {

    private final ProxyServer server = new ProxyServer(0);

    @Before
    public void startServer() throws Exception {
        server.start(ProxyManager.PROXY_TIMEOUT);
    }

    @After
    public void stopServer() throws Exception {
        server.stop();
    }

    @Test
    public void portAllocation() throws Exception {
        assertThat(server.getPort(), not(equalTo(0)));
    }
}