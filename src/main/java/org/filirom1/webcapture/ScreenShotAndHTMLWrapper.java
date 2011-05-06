package org.filirom1.webcapture;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Just a wrapper around html and screnShotBase64
 */
public class ScreenShotAndHTMLWrapper {
    private String html;
    private String screnShotBase64;

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getScrenShotBase64() {
        return screnShotBase64;
    }

    public void setScrenShotBase64(String screnShotBase64) {
        this.screnShotBase64 = screnShotBase64;
    }

    public void storeHtml(File destFile) throws IOException {
        FileUtils.writeStringToFile(destFile, html);
    }

    public void storeScreenShot(File destFile) throws IOException {
        byte[] image = Base64.decodeBase64(screnShotBase64);
        FileUtils.writeByteArrayToFile(destFile, image);
    }
}
