package org.filirom1.webcapture

import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4)
class ThreadSafetyTestCase extends AbstractTestCase{


  @Test
  public void testCapture4WebSitesAtTheSameTime() {
    //fixture

    def countDown = new CountDownLatch(4);

    //execute
    4.times {
      webCapture.captureScreenShotAndHTMLAsync("http://localhost:$HTTP_PORT/timeout", { ScreenShotAndHTMLWrapper wrap ->
        Assert.assertNotNull wrap.html
        Assert.assertNotNull wrap.screnShotBase64
        countDown.countDown();
      } as AfterCaptureCallback)
    }

    //check
    countDown.await(30, TimeUnit.SECONDS)

  }
}
