package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ad;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.C0268j;
import com.google.android.gms.common.C0273r;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0230r;
import com.google.android.gms.common.api.C0257n;
import com.google.android.gms.common.internal.bf;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class ax extends Fragment implements OnCancelListener {
    protected ap f4147a;
    private boolean f4148b;
    private boolean f4149c;
    private int f4150d;
    private ConnectionResult f4151e;
    private final Handler f4152f;
    private final SparseArray f4153g;

    public ax() {
        this.f4150d = -1;
        this.f4152f = new Handler(Looper.getMainLooper());
        this.f4153g = new SparseArray();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.common.api.internal.ax m7308a() {
        /*
        r1 = 0;
        r4 = 3;
        r0 = "com.google.android.gms.common.api.internal.SupportLifecycleFragmentImpl";
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0011, LinkageError -> 0x003b, SecurityException -> 0x003d }
    L_0x0008:
        if (r0 == 0) goto L_0x0033;
    L_0x000a:
        r0 = r0.newInstance();	 Catch:{ IllegalAccessException -> 0x0037, InstantiationException -> 0x0023, ExceptionInInitializerError -> 0x0039, RuntimeException -> 0x0035 }
        r0 = (com.google.android.gms.common.api.internal.ax) r0;	 Catch:{ IllegalAccessException -> 0x0037, InstantiationException -> 0x0023, ExceptionInInitializerError -> 0x0039, RuntimeException -> 0x0035 }
    L_0x0010:
        return r0;
    L_0x0011:
        r0 = move-exception;
    L_0x0012:
        r2 = "GmsSupportLifecycleFrag";
        r2 = android.util.Log.isLoggable(r2, r4);
        if (r2 == 0) goto L_0x0021;
    L_0x001a:
        r2 = "GmsSupportLifecycleFrag";
        r3 = "Unable to find SupportLifecycleFragmentImpl class";
        android.util.Log.d(r2, r3, r0);
    L_0x0021:
        r0 = r1;
        goto L_0x0008;
    L_0x0023:
        r0 = move-exception;
    L_0x0024:
        r2 = "GmsSupportLifecycleFrag";
        r2 = android.util.Log.isLoggable(r2, r4);
        if (r2 == 0) goto L_0x0033;
    L_0x002c:
        r2 = "GmsSupportLifecycleFrag";
        r3 = "Unable to instantiate SupportLifecycleFragmentImpl class";
        android.util.Log.d(r2, r3, r0);
    L_0x0033:
        r0 = r1;
        goto L_0x0010;
    L_0x0035:
        r0 = move-exception;
        goto L_0x0024;
    L_0x0037:
        r0 = move-exception;
        goto L_0x0024;
    L_0x0039:
        r0 = move-exception;
        goto L_0x0024;
    L_0x003b:
        r0 = move-exception;
        goto L_0x0012;
    L_0x003d:
        r0 = move-exception;
        goto L_0x0012;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.ax.a():com.google.android.gms.common.api.internal.ax");
    }

    public static ax m7309a(FragmentActivity fragmentActivity) {
        bf.m7880b("Must be called from main thread of process");
        try {
            ax axVar = (ax) fragmentActivity.m1226f().m811a("GmsSupportLifecycleFrag");
            return (axVar == null || axVar.m1182l()) ? null : axVar;
        } catch (Throwable e) {
            throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFrag is not a SupportLifecycleFragment", e);
        }
    }

    private static String m7310a(ConnectionResult connectionResult) {
        return connectionResult.m7283e() + " (" + connectionResult.m7281c() + ": " + C0273r.m7659b(connectionResult.m7281c()) + ')';
    }

    public static ax m7314b(FragmentActivity fragmentActivity) {
        ax a = m7309a(fragmentActivity);
        ad f = fragmentActivity.m1226f();
        if (a == null) {
            a = m7308a();
            if (a == null) {
                Log.w("GmsSupportLifecycleFrag", "Unable to find connection error message resources (Did you include play-services-base and the proper proguard rules?); error dialogs may be unavailable.");
                a = new ax();
            }
            f.m810a().m896a(a, "GmsSupportLifecycleFrag").m897b();
            f.m814b();
        }
        return a;
    }

    private void m7317c(int i, ConnectionResult connectionResult) {
        Log.w("GmsSupportLifecycleFrag", "Unresolved error while connecting client. Stopping auto-manage.");
        ay ayVar = (ay) this.f4153g.get(i);
        if (ayVar != null) {
            m7320a(i);
            C0230r c0230r = ayVar.f4196c;
            if (c0230r != null) {
                c0230r.m7346a(connectionResult);
            }
        }
        m7319L();
    }

    protected C0268j m7318K() {
        return C0268j.m7636b();
    }

    protected void m7319L() {
        this.f4149c = false;
        this.f4150d = -1;
        this.f4151e = null;
        if (this.f4147a != null) {
            this.f4147a.m7337b();
            this.f4147a = null;
        }
        for (int i = 0; i < this.f4153g.size(); i++) {
            ((ay) this.f4153g.valueAt(i)).f4195b.m7563e();
        }
    }

    public void m7320a(int i) {
        ay ayVar = (ay) this.f4153g.get(i);
        this.f4153g.remove(i);
        if (ayVar != null) {
            ayVar.m7404a();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m7321a(int r5, int r6, android.content.Intent r7) {
        /*
        r4 = this;
        r0 = 1;
        r1 = 0;
        switch(r5) {
            case 1: goto L_0x001b;
            case 2: goto L_0x000c;
            default: goto L_0x0005;
        };
    L_0x0005:
        r0 = r1;
    L_0x0006:
        if (r0 == 0) goto L_0x002b;
    L_0x0008:
        r4.m7319L();
    L_0x000b:
        return;
    L_0x000c:
        r2 = r4.m7318K();
        r3 = r4.m1173g();
        r2 = r2.m7638a(r3);
        if (r2 != 0) goto L_0x0005;
    L_0x001a:
        goto L_0x0006;
    L_0x001b:
        r2 = -1;
        if (r6 == r2) goto L_0x0006;
    L_0x001e:
        if (r6 != 0) goto L_0x0005;
    L_0x0020:
        r0 = new com.google.android.gms.common.ConnectionResult;
        r2 = 13;
        r3 = 0;
        r0.<init>(r2, r3);
        r4.f4151e = r0;
        goto L_0x0005;
    L_0x002b:
        r0 = r4.f4150d;
        r1 = r4.f4151e;
        r4.m7317c(r0, r1);
        goto L_0x000b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.ax.a(int, int, android.content.Intent):void");
    }

    protected void m7322a(int i, ConnectionResult connectionResult) {
        Log.w("GmsSupportLifecycleFrag", "Failed to connect due to user resolvable error " + m7310a(connectionResult));
        m7317c(i, connectionResult);
    }

    public void m7323a(int i, C0257n c0257n, C0230r c0230r) {
        bf.m7874a((Object) c0257n, (Object) "GoogleApiClient instance cannot be null");
        bf.m7878a(this.f4153g.indexOfKey(i) < 0, "Already managing a GoogleApiClient with id " + i);
        this.f4153g.put(i, new ay(this, i, c0257n, c0230r));
        if (this.f4148b && !this.f4149c) {
            c0257n.m7563e();
        }
    }

    public void m7324a(Bundle bundle) {
        super.m1149a(bundle);
        if (bundle != null) {
            this.f4149c = bundle.getBoolean("resolving_error", false);
            this.f4150d = bundle.getInt("failed_client_id", -1);
            if (this.f4150d >= 0) {
                this.f4151e = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution"));
            }
        }
    }

    public void m7325a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.m1153a(str, fileDescriptor, printWriter, strArr);
        for (int i = 0; i < this.f4153g.size(); i++) {
            ((ay) this.f4153g.valueAt(i)).m7406a(str, fileDescriptor, printWriter, strArr);
        }
    }

    protected void m7326b(int i, ConnectionResult connectionResult) {
        Log.w("GmsSupportLifecycleFrag", "Unable to connect, GooglePlayServices is updating.");
        m7317c(i, connectionResult);
    }

    public void m7327c() {
        super.m1161c();
        this.f4148b = true;
        if (!this.f4149c) {
            for (int i = 0; i < this.f4153g.size(); i++) {
                ((ay) this.f4153g.valueAt(i)).f4195b.m7563e();
            }
        }
    }

    public void m7328d() {
        super.m1165d();
        this.f4148b = false;
        for (int i = 0; i < this.f4153g.size(); i++) {
            ((ay) this.f4153g.valueAt(i)).f4195b.m7565g();
        }
    }

    public void m7329e(Bundle bundle) {
        super.m1170e(bundle);
        bundle.putBoolean("resolving_error", this.f4149c);
        if (this.f4150d >= 0) {
            bundle.putInt("failed_client_id", this.f4150d);
            bundle.putInt("failed_status", this.f4151e.m7281c());
            bundle.putParcelable("failed_resolution", this.f4151e.m7282d());
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        m7317c(this.f4150d, new ConnectionResult(13, null));
    }
}
