package com.example.readjsonfilelistview.com;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpConnector {
    public HttpConnector(){

    }

    public String method(String reqURL) throws IOException {

        String res = "";
        URL url = new URL(reqURL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        try {

            con.setRequestMethod("GET");
            InputStream is = new BufferedInputStream(con.getInputStream());
            while (is!=null){
                res.concat(is.toString());
            }
        } finally {
            con.disconnect();
        }
        return res;
    }
}
