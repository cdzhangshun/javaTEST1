import java.io.*;
import java.net.*;
import java.util.Date;

public class URLConnectionTest {
    public static void main(String[] args) throws IOException {
       URL url=new URL("http://jwc.yangtzeu.edu.cn/jwgl/jwgl.htm");
       URLConnection conn = url.openConnection();
        System.out.println("Date:"+new Date(conn.getDate()));
        System.out.println("Content-type:"+conn.getContentType());
        System.out.println("ContentEncoding:"+conn.getContentEncoding());
        System.out.println("Expires:"+conn.getExpiration());
        System.out.println("Last Modified:"+conn.getLastModified());
        System.out.println("Content-Length:"+conn.getContentLength());
        InputStream in =conn.getInputStream();
        String ss;
        BufferedReader bufIn=new BufferedReader(new InputStreamReader(in,"UTF-8"));
        while ((ss=bufIn.readLine()) !=null ){
            System.out.println(ss);

        }
        bufIn.close();
        in.close();

    }

}
