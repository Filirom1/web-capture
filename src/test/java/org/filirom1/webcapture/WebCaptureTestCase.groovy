package org.filirom1.webcapture

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4)
class WebCaptureTestCase extends AbstractTestCase{

  @Test
  void testCaptureScreenShotAndHTML() {
    //execute
    def wrapper = webCapture.captureScreenShotAndHTML("http://localhost:$HTTP_PORT/hello-world")

    //check
    Assert.assertNotNull wrapper.html
    Assert.assertTrue wrapper.html.contains("<h1>Hello World</h1>")
    Assert.assertNotNull wrapper.screnShotBase64
  }

  @Test
  void testCaptureScreenShotAndHTMLWithASlowWebSite() {
    //fixture
    webCapture.timeout = 500

    //execute
    def wrapper = webCapture.captureScreenShotAndHTML("http://localhost:$HTTP_PORT/timeout")

    //check
    Assert.assertNull wrapper.html
    Assert.assertNull wrapper.screnShotBase64
  }

  @Test
  void testCaptureScreenShotAndHTMLWithAJavascriptWebSite() {
    //execute
    def wrapper = webCapture.captureScreenShotAndHTML("http://localhost:$HTTP_PORT/domJS")

    //check
    Assert.assertTrue wrapper.html.contains('<h1 id="title">Hello JS</h1>')
  }

  @Test
  void testCaptureScreenShotAndHTMLWithAnAJAXWebSite() {
    //execute
    def wrapper = webCapture.captureScreenShotAndHTML("http://localhost:$HTTP_PORT/domAJAX")

    //check
    Assert.assertNotNull wrapper.html
    Assert.assertTrue wrapper.html?.contains('<h1 id="title">Hello AJAX</h1>')
  }
}


