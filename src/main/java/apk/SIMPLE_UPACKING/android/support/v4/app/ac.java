package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.p014g.SimpleArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: FragmentHostCallback */
public abstract class ac extends aa {
    private final Activity f481a;
    final Context f482b;
    final int f483c;
    final af f484d;
    private final Handler f485e;
    private SimpleArrayMap f486f;
    private boolean f487g;
    private az f488h;
    private boolean f489i;
    private boolean f490j;

    ac(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.f754a, 0);
    }

    ac(Activity activity, Context context, Handler handler, int i) {
        this.f484d = new af();
        this.f481a = activity;
        this.f482b = context;
        this.f485e = handler;
        this.f483c = i;
    }

    public void m790a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public boolean m793a(Fragment fragment) {
        return true;
    }

    public LayoutInflater m794b() {
        return (LayoutInflater) this.f482b.getSystemService("layout_inflater");
    }

    public void m797c() {
    }

    public void m787a(Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.f482b.startActivity(intent);
    }

    public boolean m798d() {
        return true;
    }

    public int m799e() {
        return this.f483c;
    }

    public View m786a(int i) {
        return null;
    }

    public boolean m792a() {
        return true;
    }

    Activity m800f() {
        return this.f481a;
    }

    Context m801g() {
        return this.f482b;
    }

    Handler m802h() {
        return this.f485e;
    }

    af m803i() {
        return this.f484d;
    }

    az m804j() {
        if (this.f488h != null) {
            return this.f488h;
        }
        this.f489i = true;
        this.f488h = m785a("(root)", this.f490j, true);
        return this.f488h;
    }

    void m789a(String str) {
        if (this.f486f != null) {
            az azVar = (az) this.f486f.get(str);
            if (azVar != null && !azVar.f560f) {
                azVar.m941h();
                this.f486f.remove(str);
            }
        }
    }

    void m795b(Fragment fragment) {
    }

    boolean m805k() {
        return this.f487g;
    }

    void m806l() {
        if (!this.f490j) {
            this.f490j = true;
            if (this.f488h != null) {
                this.f488h.m935b();
            } else if (!this.f489i) {
                this.f488h = m785a("(root)", this.f490j, false);
                if (!(this.f488h == null || this.f488h.f559e)) {
                    this.f488h.m935b();
                }
            }
            this.f489i = true;
        }
    }

    void m791a(boolean z) {
        this.f487g = z;
        if (this.f488h != null && this.f490j) {
            this.f490j = false;
            if (z) {
                this.f488h.m937d();
            } else {
                this.f488h.m936c();
            }
        }
    }

    void m807m() {
        if (this.f488h != null) {
            this.f488h.m941h();
        }
    }

    void m808n() {
        if (this.f486f != null) {
            int size = this.f486f.size();
            az[] azVarArr = new az[size];
            for (int i = size - 1; i >= 0; i--) {
                azVarArr[i] = (az) this.f486f.m1464c(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                az azVar = azVarArr[i2];
                azVar.m938e();
                azVar.m940g();
            }
        }
    }

    az m785a(String str, boolean z, boolean z2) {
        if (this.f486f == null) {
            this.f486f = new SimpleArrayMap();
        }
        az azVar = (az) this.f486f.get(str);
        if (azVar != null) {
            azVar.m931a(this);
            return azVar;
        } else if (!z2) {
            return azVar;
        } else {
            azVar = new az(str, this, z);
            this.f486f.put(str, azVar);
            return azVar;
        }
    }

    SimpleArrayMap m809o() {
        int i;
        int i2 = 0;
        if (this.f486f != null) {
            int size = this.f486f.size();
            az[] azVarArr = new az[size];
            for (int i3 = size - 1; i3 >= 0; i3--) {
                azVarArr[i3] = (az) this.f486f.m1464c(i3);
            }
            i = 0;
            while (i2 < size) {
                az azVar = azVarArr[i2];
                if (azVar.f560f) {
                    i = 1;
                } else {
                    azVar.m941h();
                    this.f486f.remove(azVar.f558d);
                }
                i2++;
            }
        } else {
            i = 0;
        }
        if (i != 0) {
            return this.f486f;
        }
        return null;
    }

    void m788a(SimpleArrayMap simpleArrayMap) {
        this.f486f = simpleArrayMap;
    }

    void m796b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.f490j);
        if (this.f488h != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.f488h)));
            printWriter.println(":");
            this.f488h.m933a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }
}
