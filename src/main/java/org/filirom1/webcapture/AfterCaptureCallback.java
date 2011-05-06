package org.filirom1.webcapture;

public interface AfterCaptureCallback {
    /**
     * Execute something after HTML and screenshot captured.
     *
     * @param wrapper contains streenshot and html
     */
    public abstract void run(ScreenShotAndHTMLWrapper wrapper);
}
