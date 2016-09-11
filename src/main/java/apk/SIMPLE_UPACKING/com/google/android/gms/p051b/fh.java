package com.google.android.gms.p051b;

import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.C0056g;
import com.google.android.gms.ads.internal.util.client.C0099b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@fi
/* renamed from: com.google.android.gms.b.fh */
public class fh implements UncaughtExceptionHandler {
    private UncaughtExceptionHandler f3628a;
    private UncaughtExceptionHandler f3629b;
    private Context f3630c;
    private VersionInfoParcel f3631d;

    public fh(Context context, VersionInfoParcel versionInfoParcel, UncaughtExceptionHandler uncaughtExceptionHandler, UncaughtExceptionHandler uncaughtExceptionHandler2) {
        this.f3628a = uncaughtExceptionHandler;
        this.f3629b = uncaughtExceptionHandler2;
        this.f3630c = context;
        this.f3631d = versionInfoParcel;
    }

    private static boolean m6490a(Context context) {
        return ((Boolean) an.f3431g.m6093c()).booleanValue();
    }

    private Throwable m6491b(Throwable th) {
        if (((Boolean) an.f3432h.m6093c()).booleanValue()) {
            return th;
        }
        LinkedList linkedList = new LinkedList();
        while (th != null) {
            linkedList.push(th);
            th = th.getCause();
        }
        Throwable th2 = null;
        while (!linkedList.isEmpty()) {
            Throwable th3;
            Throwable th4 = (Throwable) linkedList.pop();
            StackTraceElement[] stackTrace = th4.getStackTrace();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new StackTraceElement(th4.getClass().getName(), "<filtered>", "<filtered>", 1));
            int i = 0;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (m6494a(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                    i = 1;
                } else if (m6496b(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                } else {
                    arrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
                }
            }
            if (i != 0) {
                th3 = th2 == null ? new Throwable(th4.getMessage()) : new Throwable(th4.getMessage(), th2);
                th3.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
            } else {
                th3 = th2;
            }
            th2 = th3;
        }
        return th2;
    }

    String m6492a(Class cls, Throwable th, boolean z) {
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return new Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", VERSION.RELEASE).appendQueryParameter("api", String.valueOf(VERSION.SDK_INT)).appendQueryParameter("device", C0056g.m5439c().m6551c()).appendQueryParameter("js", this.f3631d.f3092b).appendQueryParameter("appid", this.f3630c.getApplicationContext().getPackageName()).appendQueryParameter("exceptiontype", cls.getName()).appendQueryParameter("stacktrace", stringWriter.toString()).appendQueryParameter("eids", TextUtils.join(",", an.m6108a())).appendQueryParameter("trapped", String.valueOf(z)).toString();
    }

    public void m6493a(Throwable th, boolean z) {
        if (fh.m6490a(this.f3630c)) {
            Throwable b = m6491b(th);
            if (b != null) {
                Class cls = th.getClass();
                List arrayList = new ArrayList();
                arrayList.add(m6492a(cls, b, z));
                C0056g.m5439c().m6538a(this.f3630c, this.f3631d.f3092b, arrayList, C0056g.m5442f().m6501b());
            }
        }
    }

    protected boolean m6494a(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return z;
        }
        if (str.startsWith("com.google.android.gms.ads")) {
            return true;
        }
        if (str.startsWith("com.google.ads")) {
            return true;
        }
        try {
            return Class.forName(str).isAnnotationPresent(fi.class);
        } catch (Throwable e) {
            C0099b.m5637a("Fail to check class type for class " + str, e);
            return z;
        }
    }

    protected boolean m6495a(Throwable th) {
        boolean z = true;
        if (th == null) {
            return false;
        }
        boolean z2 = false;
        boolean z3 = false;
        while (th != null) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (m6494a(stackTraceElement.getClassName())) {
                    z3 = true;
                }
                if (getClass().getName().equals(stackTraceElement.getClassName())) {
                    z2 = true;
                }
            }
            th = th.getCause();
        }
        if (!z3 || r2) {
            z = false;
        }
        return z;
    }

    protected boolean m6496b(String str) {
        return TextUtils.isEmpty(str) ? false : str.startsWith("android.") || str.startsWith("java.");
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (m6495a(th)) {
            if (Looper.getMainLooper().getThread() != thread) {
                m6493a(th, true);
                return;
            }
            m6493a(th, false);
        }
        if (this.f3628a != null) {
            this.f3628a.uncaughtException(thread, th);
        } else if (this.f3629b != null) {
            this.f3629b.uncaughtException(thread, th);
        }
    }
}
