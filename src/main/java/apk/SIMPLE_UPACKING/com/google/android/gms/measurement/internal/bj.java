package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.bf;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

class bj implements Runnable {
    final /* synthetic */ bf f4773a;
    private final URL f4774b;
    private final byte[] f4775c;
    private final bh f4776d;
    private final String f4777e;
    private final Map f4778f;

    public bj(bf bfVar, String str, URL url, byte[] bArr, Map map, bh bhVar) {
        this.f4773a = bfVar;
        bf.m7875a(str);
        bf.m7873a((Object) url);
        bf.m7873a((Object) bhVar);
        this.f4774b = url;
        this.f4775c = bArr;
        this.f4776d = bhVar;
        this.f4777e = str;
        this.f4778f = map;
    }

    public void run() {
        OutputStream outputStream;
        Throwable e;
        int i;
        HttpURLConnection httpURLConnection;
        Throwable th;
        this.f4773a.m8619e();
        int i2 = 0;
        HttpURLConnection a;
        try {
            a = this.f4773a.m8613a(this.f4774b);
            try {
                if (this.f4778f != null) {
                    for (Entry entry : this.f4778f.entrySet()) {
                        a.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                if (this.f4775c != null) {
                    byte[] a2 = this.f4773a.m8629o().m8282a(this.f4775c);
                    this.f4773a.m8633s().m8606z().m8608a("Uploading data. size", Integer.valueOf(a2.length));
                    a.setDoOutput(true);
                    a.addRequestProperty("Content-Encoding", "gzip");
                    a.setFixedLengthStreamingMode(a2.length);
                    a.connect();
                    outputStream = a.getOutputStream();
                    try {
                        outputStream.write(a2);
                        outputStream.close();
                        outputStream = null;
                    } catch (IOException e2) {
                        e = e2;
                        i = 0;
                        httpURLConnection = a;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e3) {
                                this.f4773a.m8633s().m8582b().m8608a("Error closing HTTP compressed POST connection output stream", e3);
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        this.f4773a.m8632r().m8709a(new bi(this.f4776d, i, e, null, null));
                    } catch (Throwable th2) {
                        th = th2;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e32) {
                                this.f4773a.m8633s().m8582b().m8608a("Error closing HTTP compressed POST connection output stream", e32);
                            }
                        }
                        if (a != null) {
                            a.disconnect();
                        }
                        this.f4773a.m8632r().m8709a(new bi(this.f4776d, i2, null, null, null));
                        throw th;
                    }
                }
                outputStream = null;
                i2 = a.getResponseCode();
                byte[] a3 = this.f4773a.m8612a(a);
                if (null != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e322) {
                        this.f4773a.m8633s().m8582b().m8608a("Error closing HTTP compressed POST connection output stream", e322);
                    }
                }
                if (a != null) {
                    a.disconnect();
                }
                this.f4773a.m8632r().m8709a(new bi(this.f4776d, i2, null, a3, null));
            } catch (IOException e4) {
                e = e4;
                i = i2;
                outputStream = null;
                httpURLConnection = a;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                this.f4773a.m8632r().m8709a(new bi(this.f4776d, i, e, null, null));
            } catch (Throwable th3) {
                th = th3;
                outputStream = null;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (a != null) {
                    a.disconnect();
                }
                this.f4773a.m8632r().m8709a(new bi(this.f4776d, i2, null, null, null));
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            i = 0;
            outputStream = null;
            httpURLConnection = null;
            if (outputStream != null) {
                outputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            this.f4773a.m8632r().m8709a(new bi(this.f4776d, i, e, null, null));
        } catch (Throwable th32) {
            th = th32;
            a = null;
            outputStream = null;
            if (outputStream != null) {
                outputStream.close();
            }
            if (a != null) {
                a.disconnect();
            }
            this.f4773a.m8632r().m8709a(new bi(this.f4776d, i2, null, null, null));
            throw th;
        }
    }
}
