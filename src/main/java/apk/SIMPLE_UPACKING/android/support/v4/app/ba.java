package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.p007b.Loader;
import android.support.v4.p014g.DebugUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* compiled from: LoaderManager */
final class ba implements Loader, Loader {
    final int f563a;
    final Bundle f564b;
    ay f565c;
    Loader f566d;
    boolean f567e;
    boolean f568f;
    Object f569g;
    boolean f570h;
    boolean f571i;
    boolean f572j;
    boolean f573k;
    boolean f574l;
    boolean f575m;
    ba f576n;
    final /* synthetic */ az f577o;

    public ba(az azVar, int i, Bundle bundle, ay ayVar) {
        this.f577o = azVar;
        this.f563a = i;
        this.f564b = bundle;
        this.f565c = ayVar;
    }

    void m945a() {
        if (this.f571i && this.f572j) {
            this.f570h = true;
        } else if (!this.f570h) {
            this.f570h = true;
            if (az.f555a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            if (this.f566d == null && this.f565c != null) {
                this.f566d = this.f565c.m924a(this.f563a, this.f564b);
            }
            if (this.f566d == null) {
                return;
            }
            if (!this.f566d.getClass().isMemberClass() || Modifier.isStatic(this.f566d.getClass().getModifiers())) {
                if (!this.f575m) {
                    this.f566d.m1241a(this.f563a, this);
                    this.f566d.m1242a((Loader) this);
                    this.f575m = true;
                }
                this.f566d.m1251i();
                return;
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f566d);
        }
    }

    void m949b() {
        if (az.f555a) {
            Log.v("LoaderManager", "  Retaining: " + this);
        }
        this.f571i = true;
        this.f572j = this.f570h;
        this.f570h = false;
        this.f565c = null;
    }

    void m951c() {
        if (this.f571i) {
            if (az.f555a) {
                Log.v("LoaderManager", "  Finished Retaining: " + this);
            }
            this.f571i = false;
            if (!(this.f570h == this.f572j || this.f570h)) {
                m953e();
            }
        }
        if (this.f570h && this.f567e && !this.f573k) {
            m950b(this.f566d, this.f569g);
        }
    }

    void m952d() {
        if (this.f570h && this.f573k) {
            this.f573k = false;
            if (this.f567e) {
                m950b(this.f566d, this.f569g);
            }
        }
    }

    void m953e() {
        if (az.f555a) {
            Log.v("LoaderManager", "  Stopping: " + this);
        }
        this.f570h = false;
        if (!this.f571i && this.f566d != null && this.f575m) {
            this.f575m = false;
            this.f566d.m1243a((Loader) this);
            this.f566d.m1245b((Loader) this);
            this.f566d.m1255m();
        }
    }

    void m954f() {
        String str;
        ay ayVar = null;
        if (az.f555a) {
            Log.v("LoaderManager", "  Destroying: " + this);
        }
        this.f574l = true;
        boolean z = this.f568f;
        this.f568f = false;
        if (this.f565c != null && this.f566d != null && this.f567e && z) {
            if (az.f555a) {
                Log.v("LoaderManager", "  Reseting: " + this);
            }
            if (this.f577o.f562h != null) {
                String str2 = this.f577o.f562h.f484d.f516v;
                this.f577o.f562h.f484d.f516v = "onLoaderReset";
                str = str2;
            } else {
                str = null;
            }
            try {
                this.f565c.m925a(this.f566d);
            } finally {
                ayVar = this.f577o.f562h;
                if (ayVar != null) {
                    ayVar = this.f577o.f562h.f484d;
                    ayVar.f516v = str;
                }
            }
        }
        this.f565c = ayVar;
        this.f569g = ayVar;
        this.f567e = false;
        if (this.f566d != null) {
            if (this.f575m) {
                this.f575m = false;
                this.f566d.m1243a((Loader) this);
                this.f566d.m1245b((Loader) this);
            }
            this.f566d.m1257o();
        }
        if (this.f576n != null) {
            this.f576n.m954f();
        }
    }

    public void m946a(Loader loader) {
        if (az.f555a) {
            Log.v("LoaderManager", "onLoadCanceled: " + this);
        }
        if (this.f574l) {
            if (az.f555a) {
                Log.v("LoaderManager", "  Ignoring load canceled -- destroyed");
            }
        } else if (this.f577o.f556b.m1530a(this.f563a) == this) {
            ba baVar = this.f576n;
            if (baVar != null) {
                if (az.f555a) {
                    Log.v("LoaderManager", "  Switching to pending loader: " + baVar);
                }
                this.f576n = null;
                this.f577o.f556b.m1534b(this.f563a, null);
                m954f();
                this.f577o.m932a(baVar);
            }
        } else if (az.f555a) {
            Log.v("LoaderManager", "  Ignoring load canceled -- not active");
        }
    }

    public void m947a(Loader loader, Object obj) {
        if (az.f555a) {
            Log.v("LoaderManager", "onLoadComplete: " + this);
        }
        if (this.f574l) {
            if (az.f555a) {
                Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
            }
        } else if (this.f577o.f556b.m1530a(this.f563a) == this) {
            ba baVar = this.f576n;
            if (baVar != null) {
                if (az.f555a) {
                    Log.v("LoaderManager", "  Switching to pending loader: " + baVar);
                }
                this.f576n = null;
                this.f577o.f556b.m1534b(this.f563a, null);
                m954f();
                this.f577o.m932a(baVar);
                return;
            }
            if (!(this.f569g == obj && this.f567e)) {
                this.f569g = obj;
                this.f567e = true;
                if (this.f570h) {
                    m950b(loader, obj);
                }
            }
            baVar = (ba) this.f577o.f557c.m1530a(this.f563a);
            if (!(baVar == null || baVar == this)) {
                baVar.f568f = false;
                baVar.m954f();
                this.f577o.f557c.m1536c(this.f563a);
            }
            if (this.f577o.f562h != null && !this.f577o.m934a()) {
                this.f577o.f562h.f484d.m872f();
            }
        } else if (az.f555a) {
            Log.v("LoaderManager", "  Ignoring load complete -- not active");
        }
    }

    void m950b(Loader loader, Object obj) {
        String str;
        if (this.f565c != null) {
            if (this.f577o.f562h != null) {
                String str2 = this.f577o.f562h.f484d.f516v;
                this.f577o.f562h.f484d.f516v = "onLoadFinished";
                str = str2;
            } else {
                str = null;
            }
            try {
                if (az.f555a) {
                    Log.v("LoaderManager", "  onLoadFinished in " + loader + ": " + loader.m1248c(obj));
                }
                this.f565c.m926a(loader, obj);
                this.f568f = true;
            } finally {
                if (this.f577o.f562h != null) {
                    this.f577o.f562h.f484d.f516v = str;
                }
            }
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("LoaderInfo{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" #");
        stringBuilder.append(this.f563a);
        stringBuilder.append(" : ");
        DebugUtils.m1501a(this.f566d, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void m948a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f563a);
        printWriter.print(" mArgs=");
        printWriter.println(this.f564b);
        printWriter.print(str);
        printWriter.print("mCallbacks=");
        printWriter.println(this.f565c);
        printWriter.print(str);
        printWriter.print("mLoader=");
        printWriter.println(this.f566d);
        if (this.f566d != null) {
            this.f566d.m1244a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.f567e || this.f568f) {
            printWriter.print(str);
            printWriter.print("mHaveData=");
            printWriter.print(this.f567e);
            printWriter.print("  mDeliveredData=");
            printWriter.println(this.f568f);
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(this.f569g);
        }
        printWriter.print(str);
        printWriter.print("mStarted=");
        printWriter.print(this.f570h);
        printWriter.print(" mReportNextStart=");
        printWriter.print(this.f573k);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f574l);
        printWriter.print(str);
        printWriter.print("mRetaining=");
        printWriter.print(this.f571i);
        printWriter.print(" mRetainingStarted=");
        printWriter.print(this.f572j);
        printWriter.print(" mListenerRegistered=");
        printWriter.println(this.f575m);
        if (this.f576n != null) {
            printWriter.print(str);
            printWriter.println("Pending Loader ");
            printWriter.print(this.f576n);
            printWriter.println(":");
            this.f576n.m948a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }
}
