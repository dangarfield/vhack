package android.support.v4.p007b;

import android.content.Context;
import android.support.v4.p014g.DebugUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.b.m */
public class Loader {
    int f770f;
    Loader f771g;
    Loader f772h;
    Context f773i;
    boolean f774j;
    boolean f775k;
    boolean f776l;
    boolean f777m;
    boolean f778n;

    public Loader(Context context) {
        this.f774j = false;
        this.f775k = false;
        this.f776l = true;
        this.f777m = false;
        this.f778n = false;
        this.f773i = context.getApplicationContext();
    }

    public void m1246b(Object obj) {
        if (this.f771g != null) {
            this.f771g.m944a(this, obj);
        }
    }

    public void m1249g() {
        if (this.f772h != null) {
            this.f772h.m943a(this);
        }
    }

    public void m1241a(int i, Loader loader) {
        if (this.f771g != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f771g = loader;
        this.f770f = i;
    }

    public void m1243a(Loader loader) {
        if (this.f771g == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f771g != loader) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f771g = null;
        }
    }

    public void m1242a(Loader loader) {
        if (this.f772h != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f772h = loader;
    }

    public void m1245b(Loader loader) {
        if (this.f772h == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f772h != loader) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f772h = null;
        }
    }

    public boolean m1250h() {
        return this.f775k;
    }

    public final void m1251i() {
        this.f774j = true;
        this.f776l = false;
        this.f775k = false;
        m1252j();
    }

    protected void m1252j() {
    }

    public boolean m1253k() {
        return m1247b();
    }

    protected boolean m1247b() {
        return false;
    }

    public void m1254l() {
        m1240a();
    }

    protected void m1240a() {
    }

    public void m1255m() {
        this.f774j = false;
        m1256n();
    }

    protected void m1256n() {
    }

    public void m1257o() {
        m1258p();
        this.f776l = true;
        this.f774j = false;
        this.f775k = false;
        this.f777m = false;
        this.f778n = false;
    }

    protected void m1258p() {
    }

    public void m1259q() {
        this.f778n = false;
    }

    public void m1260r() {
        if (this.f778n) {
            this.f777m = true;
        }
    }

    public String m1248c(Object obj) {
        StringBuilder stringBuilder = new StringBuilder(64);
        DebugUtils.m1501a(obj, stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        DebugUtils.m1501a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.f770f);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void m1244a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f770f);
        printWriter.print(" mListener=");
        printWriter.println(this.f771g);
        if (this.f774j || this.f777m || this.f778n) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f774j);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f777m);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f778n);
        }
        if (this.f775k || this.f776l) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f775k);
            printWriter.print(" mReset=");
            printWriter.println(this.f776l);
        }
    }
}
