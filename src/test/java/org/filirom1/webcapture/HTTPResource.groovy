package org.filirom1.webcapture

import javax.ws.rs.Path
import javax.ws.rs.GET
import javax.ws.rs.Produces
import javax.ws.rs.core.Response

@Path("/")
class HTTPResource {
  @Path("/hello-world")
  @GET
  @Produces("text/html")
  public Response helloWorld() {
    def html = """
      <html>
        <head><title>Mon Titre</title></head>
        <body>
          <h1>Hello World</h1>
        </body>
      </html>
      """
    return Response.ok(html).build();
  }

  @Path("/timeout")
  @GET
  @Produces("text/html")
  public Response timeout() {
    Thread.sleep(1000)
    def html = """
      <html>
        <head><title>Mon Titre</title></head>
        <body>
          <h1>This page appear after 60 seconds</h1>
        </body>
      </html>
      """
    return Response.ok(html).build();
  }

  @Path("/domJS")
  @GET
  @Produces("text/html")
  public Response domJS() {
    def html = """
      <html>
        <body>
          <h1 id="title"></h1>
          <script>
            document.getElementById("title").innerHTML = "Hello JS"
          </script>
        </body>
      </html>
      """
    return Response.ok(html).build();
  }

  @Path("/domAJAX")
  @GET
  @Produces("text/html")
  public Response domAJAX() {
    def html = """
        <html>
          <body>
            <h1 id="title"></h1>
            <script>
              var xhr = new XMLHttpRequest();
              xhr.onreadystatechange = function(){
                if(xhr.readyState ==4 && xhr.status==200){
                  document.getElementById("title").innerHTML = xhr.responseText;
                }
              }
              xhr.open('GET', '/ajax', true)
              xhr.send(null)
            </script>
          </body>
        </html>
      """
    return Response.ok(html).build();
  }

  @Path("/ajax")
  @GET
  @Produces("text/html")
  public Response ajax() {
    def html = """Hello AJAX"""
    return Response.ok(html).build();
  }
}
