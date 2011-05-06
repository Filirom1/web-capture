Capture HTML and Screen Shot of an URL
======================================

A Java library based on Selenium that captures HTML and screenshot of an URL.

Usage : 
-------

    WebCapture wc = new WebCapture();
    ScreenShotAndHTMLWrapper wrapper = wc.captureScreenShotAndHTML("http://google.fr");
    String html = wrapper.getHtml(); 
    wrapper.storeScreenShot(new File("/tmp/myImage.png"));


Asynchronous :
--------------

You can also also capture HTML and ScreenShot asynchronously with a callback. Here is an exemple in Groovy : 

    def webCapture = new WebCapture()
    ['http://www.google.fr', 'http://www.yahoo.fr', 'http://www.youtube.fr'].each { url ->
      webCapture.captureScreenShotAndHTMLAsync(url, { ScreenShotAndHTMLWrapper wrap ->
        println wrap.html;  
      } as AfterCaptureCallback)
    } 


Maven : 
-------

Add in your pom : 

    <dependencies>
    ...
        <dependency>
            <groupId>org.filirom1</groupId>
            <artifactId>web-capture</artifactId>
            <version>0.1</version>
            <type>jar</type>
        </dependency>
    ...
    </dependencies>

    <repositories>
        <repository>
            <id>filirom1-repo</id>
            <url>https://Filirom1@github.com/Filirom1/filirom1-mvn-repo/raw/master/releases</url>
        </repository>
        <repository>
            <id>maven-restlet</id>
            <url>http://maven.restlet.org</url>
        </repository>
    </repositories>


And with Groovy Grape
---------------------

    /*
     * Capture screenshots of 3 URLs
     */
    import org.filirom1.webcapture.*
    import java.util.concurrent.CountDownLatch

    @GrabResolver(name = 'filirom1', root = 'https://Filirom1@github.com/Filirom1/filirom1-mvn-repo/raw/master/releases')
    @Grab(group = 'org.filirom1', module = 'web-capture', version = '0.1')

    def webCapture = new WebCapture(concurrentBrowser: 4)
    def urls = ['http://www.google.fr', 'http://www.yahoo.fr', 'http://www.youtube.fr']
    def countDown = new CountDownLatch(urls.size());

    urls.each { url ->
      webCapture.captureScreenShotAndHTMLAsync(url, { ScreenShotAndHTMLWrapper wrap ->
        def file = new File("${url}.png")
        wrap.storeScreenShot(file);
        println "Screenshot saved in : ${file.absolutePath}"
        countDown.countDown()
      } as AfterCaptureCallback)
    }

    countDown.await()
    println "Is stopping..."
    webCapture.stop()
