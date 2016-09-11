package com.google.android.gms.p051b;

import android.os.SystemClock;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.b.ms */
public class ms implements C0208k {
    private final Map f4070a;
    private long f4071b;
    private final File f4072c;
    private final int f4073d;

    public ms(File file) {
        this(file, 5242880);
    }

    public ms(File file, int i) {
        this.f4070a = new LinkedHashMap(16, 0.75f, true);
        this.f4071b = 0;
        this.f4072c = file;
        this.f4073d = i;
    }

    static int m7208a(InputStream inputStream) {
        return (((0 | (ms.m7220e(inputStream) << 0)) | (ms.m7220e(inputStream) << 8)) | (ms.m7220e(inputStream) << 16)) | (ms.m7220e(inputStream) << 24);
    }

    private void m7209a(int i) {
        if (this.f4071b + ((long) i) >= ((long) this.f4073d)) {
            int i2;
            if (me.f4033b) {
                me.m7096a("Pruning old cache entries.", new Object[0]);
            }
            long j = this.f4071b;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator it = this.f4070a.entrySet().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                mu muVar = (mu) ((Entry) it.next()).getValue();
                if (m7226c(muVar.f4075b).delete()) {
                    this.f4071b -= muVar.f4074a;
                } else {
                    me.m7098b("Could not delete cache entry for key=%s, filename=%s", muVar.f4075b, m7218d(muVar.f4075b));
                }
                it.remove();
                i2 = i3 + 1;
                if (((float) (this.f4071b + ((long) i))) < ((float) this.f4073d) * 0.9f) {
                    break;
                }
                i3 = i2;
            }
            i2 = i3;
            if (me.f4033b) {
                me.m7096a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.f4071b - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    static void m7210a(OutputStream outputStream, int i) {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static void m7211a(OutputStream outputStream, long j) {
        outputStream.write((byte) ((int) (j >>> null)));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static void m7212a(OutputStream outputStream, String str) {
        byte[] bytes = str.getBytes("UTF-8");
        ms.m7211a(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private void m7213a(String str, mu muVar) {
        if (this.f4070a.containsKey(str)) {
            mu muVar2 = (mu) this.f4070a.get(str);
            this.f4071b = (muVar.f4074a - muVar2.f4074a) + this.f4071b;
        } else {
            this.f4071b += muVar.f4074a;
        }
        this.f4070a.put(str, muVar);
    }

    static void m7214a(Map map, OutputStream outputStream) {
        if (map != null) {
            ms.m7210a(outputStream, map.size());
            for (Entry entry : map.entrySet()) {
                ms.m7212a(outputStream, (String) entry.getKey());
                ms.m7212a(outputStream, (String) entry.getValue());
            }
            return;
        }
        ms.m7210a(outputStream, 0);
    }

    private static byte[] m7215a(InputStream inputStream, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
    }

    static long m7216b(InputStream inputStream) {
        return (((((((0 | ((((long) ms.m7220e(inputStream)) & 255) << null)) | ((((long) ms.m7220e(inputStream)) & 255) << 8)) | ((((long) ms.m7220e(inputStream)) & 255) << 16)) | ((((long) ms.m7220e(inputStream)) & 255) << 24)) | ((((long) ms.m7220e(inputStream)) & 255) << 32)) | ((((long) ms.m7220e(inputStream)) & 255) << 40)) | ((((long) ms.m7220e(inputStream)) & 255) << 48)) | ((((long) ms.m7220e(inputStream)) & 255) << 56);
    }

    static String m7217c(InputStream inputStream) {
        return new String(ms.m7215a(inputStream, (int) ms.m7216b(inputStream)), "UTF-8");
    }

    private String m7218d(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    static Map m7219d(InputStream inputStream) {
        int a = ms.m7208a(inputStream);
        Map emptyMap = a == 0 ? Collections.emptyMap() : new HashMap(a);
        for (int i = 0; i < a; i++) {
            emptyMap.put(ms.m7217c(inputStream).intern(), ms.m7217c(inputStream).intern());
        }
        return emptyMap;
    }

    private static int m7220e(InputStream inputStream) {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    private void m7221e(String str) {
        mu muVar = (mu) this.f4070a.get(str);
        if (muVar != null) {
            this.f4071b -= muVar.f4074a;
            this.f4070a.remove(str);
        }
    }

    public synchronized C0209l m7222a(String str) {
        C0209l c0209l;
        mv mvVar;
        IOException e;
        Throwable th;
        mu muVar = (mu) this.f4070a.get(str);
        if (muVar == null) {
            c0209l = null;
        } else {
            File c = m7226c(str);
            try {
                mvVar = new mv(null);
                try {
                    mu.m7227a((InputStream) mvVar);
                    c0209l = muVar.m7228a(ms.m7215a((InputStream) mvVar, (int) (c.length() - ((long) mvVar.f4082a))));
                    if (mvVar != null) {
                        try {
                            mvVar.close();
                        } catch (IOException e2) {
                            c0209l = null;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        me.m7098b("%s: %s", c.getAbsolutePath(), e.toString());
                        m7225b(str);
                        if (mvVar != null) {
                            try {
                                mvVar.close();
                            } catch (IOException e4) {
                                c0209l = null;
                            }
                        }
                        c0209l = null;
                        return c0209l;
                    } catch (Throwable th2) {
                        th = th2;
                        if (mvVar != null) {
                            try {
                                mvVar.close();
                            } catch (IOException e5) {
                                c0209l = null;
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e6) {
                e = e6;
                mvVar = null;
                me.m7098b("%s: %s", c.getAbsolutePath(), e.toString());
                m7225b(str);
                if (mvVar != null) {
                    mvVar.close();
                }
                c0209l = null;
                return c0209l;
            } catch (Throwable th3) {
                th = th3;
                mvVar = null;
                if (mvVar != null) {
                    mvVar.close();
                }
                throw th;
            }
        }
        return c0209l;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m7223a() {
        /*
        r9 = this;
        r0 = 0;
        monitor-enter(r9);
        r1 = r9.f4072c;	 Catch:{ all -> 0x006c }
        r1 = r1.exists();	 Catch:{ all -> 0x006c }
        if (r1 != 0) goto L_0x0025;
    L_0x000a:
        r0 = r9.f4072c;	 Catch:{ all -> 0x006c }
        r0 = r0.mkdirs();	 Catch:{ all -> 0x006c }
        if (r0 != 0) goto L_0x0023;
    L_0x0012:
        r0 = "Unable to create cache dir %s";
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x006c }
        r2 = 0;
        r3 = r9.f4072c;	 Catch:{ all -> 0x006c }
        r3 = r3.getAbsolutePath();	 Catch:{ all -> 0x006c }
        r1[r2] = r3;	 Catch:{ all -> 0x006c }
        com.google.android.gms.p051b.me.m7099c(r0, r1);	 Catch:{ all -> 0x006c }
    L_0x0023:
        monitor-exit(r9);
        return;
    L_0x0025:
        r1 = r9.f4072c;	 Catch:{ all -> 0x006c }
        r3 = r1.listFiles();	 Catch:{ all -> 0x006c }
        if (r3 == 0) goto L_0x0023;
    L_0x002d:
        r4 = r3.length;	 Catch:{ all -> 0x006c }
        r2 = r0;
    L_0x002f:
        if (r2 >= r4) goto L_0x0023;
    L_0x0031:
        r5 = r3[r2];	 Catch:{ all -> 0x006c }
        r1 = 0;
        r0 = new java.io.BufferedInputStream;	 Catch:{ IOException -> 0x0056, all -> 0x0065 }
        r6 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x0056, all -> 0x0065 }
        r6.<init>(r5);	 Catch:{ IOException -> 0x0056, all -> 0x0065 }
        r0.<init>(r6);	 Catch:{ IOException -> 0x0056, all -> 0x0065 }
        r1 = com.google.android.gms.p051b.mu.m7227a(r0);	 Catch:{ IOException -> 0x0078 }
        r6 = r5.length();	 Catch:{ IOException -> 0x0078 }
        r1.f4074a = r6;	 Catch:{ IOException -> 0x0078 }
        r6 = r1.f4075b;	 Catch:{ IOException -> 0x0078 }
        r9.m7213a(r6, r1);	 Catch:{ IOException -> 0x0078 }
        if (r0 == 0) goto L_0x0052;
    L_0x004f:
        r0.close();	 Catch:{ IOException -> 0x006f }
    L_0x0052:
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x002f;
    L_0x0056:
        r0 = move-exception;
        r0 = r1;
    L_0x0058:
        if (r5 == 0) goto L_0x005d;
    L_0x005a:
        r5.delete();	 Catch:{ all -> 0x0073 }
    L_0x005d:
        if (r0 == 0) goto L_0x0052;
    L_0x005f:
        r0.close();	 Catch:{ IOException -> 0x0063 }
        goto L_0x0052;
    L_0x0063:
        r0 = move-exception;
        goto L_0x0052;
    L_0x0065:
        r0 = move-exception;
    L_0x0066:
        if (r1 == 0) goto L_0x006b;
    L_0x0068:
        r1.close();	 Catch:{ IOException -> 0x0071 }
    L_0x006b:
        throw r0;	 Catch:{ all -> 0x006c }
    L_0x006c:
        r0 = move-exception;
        monitor-exit(r9);
        throw r0;
    L_0x006f:
        r0 = move-exception;
        goto L_0x0052;
    L_0x0071:
        r1 = move-exception;
        goto L_0x006b;
    L_0x0073:
        r1 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x0066;
    L_0x0078:
        r1 = move-exception;
        goto L_0x0058;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.ms.a():void");
    }

    public synchronized void m7224a(String str, C0209l c0209l) {
        m7209a(c0209l.f3883a.length);
        File c = m7226c(str);
        try {
            OutputStream fileOutputStream = new FileOutputStream(c);
            mu muVar = new mu(str, c0209l);
            if (muVar.m7229a(fileOutputStream)) {
                fileOutputStream.write(c0209l.f3883a);
                fileOutputStream.close();
                m7213a(str, muVar);
            } else {
                fileOutputStream.close();
                me.m7098b("Failed to write header for %s", c.getAbsolutePath());
                throw new IOException();
            }
        } catch (IOException e) {
            if (!c.delete()) {
                me.m7098b("Could not clean up file %s", c.getAbsolutePath());
            }
        }
    }

    public synchronized void m7225b(String str) {
        boolean delete = m7226c(str).delete();
        m7221e(str);
        if (!delete) {
            me.m7098b("Could not delete cache entry for key=%s, filename=%s", str, m7218d(str));
        }
    }

    public File m7226c(String str) {
        return new File(this.f4072c, m7218d(str));
    }
}
