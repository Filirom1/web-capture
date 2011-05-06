package org.filirom1.webcapture

import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.junit.Test
import org.junit.Assert

@RunWith(JUnit4)
class WrapperTestCase {

  @Test
  public void testStoreHtml() {
    //fixture
    def html = "<html><body><h1>Hello you !</h1></body></html>"
    def wrapper = new ScreenShotAndHTMLWrapper(html: html)
    def file = File.createTempFile("html", "test")

    //execute
    wrapper.storeHtml(file)

    //check
    Assert.assertTrue(file.exists())
    Assert.assertEquals(file.text, html);

    //clean
    file.delete()
  }

  @Test
  public void testStoreScreenShot() {
    //fixture
    String imageb64 = new File(this.getClass().getClassLoader().getResource("image.png").file).bytes.encodeBase64()
    def wrapper = new ScreenShotAndHTMLWrapper(screnShotBase64: imageb64)
    def file = File.createTempFile("screenshot", "test")

    //execute
    wrapper.storeScreenShot(file)

    //check
    Assert.assertTrue(file.exists())
    String fileB64 = file.bytes.encodeBase64()
    Assert.assertEquals(imageb64, fileB64);
  }
}
