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

    ['http://www.google.fr', 'http://www.yahoo.fr', 'http://www.youtube.fr'].each { url ->
      new WebCapture().captureScreenShotAndHTMLAsync(url, { ScreenShotAndHTMLWrapper wrap ->
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

