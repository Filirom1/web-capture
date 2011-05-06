package org.filirom1.webcapture

import org.filirom1.jaxrs.JAXRSServer
import org.junit.After
import org.junit.Before

class AbstractTestCase {

  protected static final int HTTP_PORT = 8469
  protected WebCapture webCapture
  private JAXRSServer httpServer

  @Before
  void setUp() {
    webCapture = new WebCapture(port: 8953, concurrentBrowser: 4)
    httpServer = new JAXRSServer([HTTPResource.class], HTTP_PORT);
    httpServer.start()
  }

  @After
  void tearDown() {
    webCapture.stop()
    httpServer.stop()
  }
}
