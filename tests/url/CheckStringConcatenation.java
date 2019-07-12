import org.checkerframework.checker.https.qual.*;

import java.net.URL;
import java.net.MalformedURLException;

class CheckStringConcatenation{

    void test() throws MalformedURLException {
        @HTTPS String s1 = "https";
        String s2 = "google.com";
        String s3 = "google.coms";
        good(s1, s2);
        bad(s1, s2);
        bad2(s2, s3);
    }
    void good(@HTTPS String s1, String s2) throws MalformedURLException {
        URL url = new URL(s1 + s2);
    }

    void bad(@HTTPS String s1, String s2) throws MalformedURLException {
        // :: error: argument.type.incompatible
        URL url = new URL(s2 + s1);
    }

    void bad2(String s2, String s3) throws MalformedURLException{
        // :: error: argument.type.incompatible
        URL url = new URL(s2 + s3);
    }
}