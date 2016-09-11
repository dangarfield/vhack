package com.fyber.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* renamed from: com.fyber.utils.t */
public final class HttpConnection extends AbstractHttpConnection {
    public static HttpConnection m5308b(String str) {
        return new HttpConnection(str);
    }

    private HttpConnection(String str) {
        super(str);
    }

    protected final /* synthetic */ Object m5309a(HttpURLConnection httpURLConnection) {
        InputStream c = m5272c(httpURLConnection);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = c.read(bArr);
            if (read > 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.close();
                return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
            }
        }
    }
}
