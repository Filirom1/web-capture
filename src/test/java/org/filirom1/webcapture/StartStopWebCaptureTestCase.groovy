package org.filirom1.webcapture

import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.junit.Test
import org.junit.Assert

@RunWith(JUnit4)
class StartStopWebCaptureTestCase extends AbstractTestCase {

  @Test
  public void testStartAutomatically() {
    //fixture
    webCapture.stop()

    //execute
    def wrap = webCapture.captureScreenShotAndHTML("http://localhost:$HTTP_PORT/hello-world");

    //check
    Assert.assertNotNull wrap.html
    Assert.assertNotNull wrap.screnShotBase64
  }

  @Test
  public void testStartStopStartStop() {
    //execute
    webCapture.start()
    webCapture.stop()
    webCapture.start()
    webCapture.stop()

    //no exception !!!!
  }
}
