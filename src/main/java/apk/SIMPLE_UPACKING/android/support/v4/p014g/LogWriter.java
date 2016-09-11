package android.support.v4.p014g;

import android.util.Log;
import java.io.Writer;

/* renamed from: android.support.v4.g.e */
public class LogWriter extends Writer {
    private final String f853a;
    private StringBuilder f854b;

    public LogWriter(String str) {
        this.f854b = new StringBuilder(128);
        this.f853a = str;
    }

    public void close() {
        m1502a();
    }

    public void flush() {
        m1502a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m1502a();
            } else {
                this.f854b.append(c);
            }
        }
    }

    private void m1502a() {
        if (this.f854b.length() > 0) {
            Log.d(this.f853a, this.f854b.toString());
            this.f854b.delete(0, this.f854b.length());
        }
    }
}
