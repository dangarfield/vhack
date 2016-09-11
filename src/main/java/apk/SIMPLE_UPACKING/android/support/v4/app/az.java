package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.p007b.Loader;
import android.support.v4.p014g.DebugUtils;
import android.support.v4.p014g.SparseArrayCompat;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: LoaderManager */
class az extends ax {
    static boolean f555a;
    final SparseArrayCompat f556b;
    final SparseArrayCompat f557c;
    final String f558d;
    boolean f559e;
    boolean f560f;
    boolean f561g;
    private ac f562h;

    static {
        f555a = false;
    }

    az(String str, ac acVar, boolean z) {
        this.f556b = new SparseArrayCompat();
        this.f557c = new SparseArrayCompat();
        this.f558d = str;
        this.f562h = acVar;
        this.f559e = z;
    }

    void m931a(ac acVar) {
        this.f562h = acVar;
    }

    private ba m928b(int i, Bundle bundle, ay ayVar) {
        ba baVar = new ba(this, i, bundle, ayVar);
        baVar.f566d = ayVar.m924a(i, bundle);
        return baVar;
    }

    private ba m929c(int i, Bundle bundle, ay ayVar) {
        try {
            this.f561g = true;
            ba b = m928b(i, bundle, ayVar);
            m932a(b);
            return b;
        } finally {
            this.f561g = false;
        }
    }

    void m932a(ba baVar) {
        this.f556b.m1534b(baVar.f563a, baVar);
        if (this.f559e) {
            baVar.m945a();
        }
    }

    public Loader m930a(int i, Bundle bundle, ay ayVar) {
        if (this.f561g) {
            throw new IllegalStateException("Called while creating a loader");
        }
        ba baVar = (ba) this.f556b.m1530a(i);
        if (f555a) {
            Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
        }
        if (baVar == null) {
            baVar = m929c(i, bundle, ayVar);
            if (f555a) {
                Log.v("LoaderManager", "  Created new loader " + baVar);
            }
        } else {
            if (f555a) {
                Log.v("LoaderManager", "  Re-using existing loader " + baVar);
            }
            baVar.f565c = ayVar;
        }
        if (baVar.f567e && this.f559e) {
            baVar.m950b(baVar.f566d, baVar.f569g);
        }
        return baVar.f566d;
    }

    void m935b() {
        if (f555a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.f559e) {
            Throwable runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.f559e = true;
        for (int b = this.f556b.m1532b() - 1; b >= 0; b--) {
            ((ba) this.f556b.m1538e(b)).m945a();
        }
    }

    void m936c() {
        if (f555a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (this.f559e) {
            for (int b = this.f556b.m1532b() - 1; b >= 0; b--) {
                ((ba) this.f556b.m1538e(b)).m953e();
            }
            this.f559e = false;
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
    }

    void m937d() {
        if (f555a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (this.f559e) {
            this.f560f = true;
            this.f559e = false;
            for (int b = this.f556b.m1532b() - 1; b >= 0; b--) {
                ((ba) this.f556b.m1538e(b)).m949b();
            }
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
    }

    void m938e() {
        if (this.f560f) {
            if (f555a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.f560f = false;
            for (int b = this.f556b.m1532b() - 1; b >= 0; b--) {
                ((ba) this.f556b.m1538e(b)).m951c();
            }
        }
    }

    void m939f() {
        for (int b = this.f556b.m1532b() - 1; b >= 0; b--) {
            ((ba) this.f556b.m1538e(b)).f573k = true;
        }
    }

    void m940g() {
        for (int b = this.f556b.m1532b() - 1; b >= 0; b--) {
            ((ba) this.f556b.m1538e(b)).m952d();
        }
    }

    void m941h() {
        int b;
        if (!this.f560f) {
            if (f555a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (b = this.f556b.m1532b() - 1; b >= 0; b--) {
                ((ba) this.f556b.m1538e(b)).m954f();
            }
            this.f556b.m1535c();
        }
        if (f555a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (b = this.f557c.m1532b() - 1; b >= 0; b--) {
            ((ba) this.f557c.m1538e(b)).m954f();
        }
        this.f557c.m1535c();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        DebugUtils.m1501a(this.f562h, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void m933a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = 0;
        if (this.f556b.m1532b() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.f556b.m1532b(); i2++) {
                ba baVar = (ba) this.f556b.m1538e(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f556b.m1537d(i2));
                printWriter.print(": ");
                printWriter.println(baVar.toString());
                baVar.m948a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.f557c.m1532b() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            while (i < this.f557c.m1532b()) {
                baVar = (ba) this.f557c.m1538e(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f557c.m1537d(i));
                printWriter.print(": ");
                printWriter.println(baVar.toString());
                baVar.m948a(str3, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public boolean m934a() {
        int b = this.f556b.m1532b();
        boolean z = false;
        for (int i = 0; i < b; i++) {
            int i2;
            ba baVar = (ba) this.f556b.m1538e(i);
            if (!baVar.f570h || baVar.f568f) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            z |= i2;
        }
        return z;
    }
}
