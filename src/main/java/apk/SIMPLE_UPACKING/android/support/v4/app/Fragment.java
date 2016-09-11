package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.p002h.ab;
import android.support.v4.p014g.DebugUtils;
import android.support.v4.p014g.SimpleArrayMap;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.app.t */
public class Fragment implements ComponentCallbacks, OnCreateContextMenuListener {
    private static final SimpleArrayMap f700a;
    static final Object f701j;
    int f702A;
    af f703B;
    ac f704C;
    af f705D;
    Fragment f706E;
    int f707F;
    int f708G;
    String f709H;
    boolean f710I;
    boolean f711J;
    boolean f712K;
    boolean f713L;
    boolean f714M;
    boolean f715N;
    boolean f716O;
    int f717P;
    ViewGroup f718Q;
    View f719R;
    View f720S;
    boolean f721T;
    boolean f722U;
    az f723V;
    boolean f724W;
    boolean f725X;
    Object f726Y;
    Object f727Z;
    Object aa;
    Object ab;
    Object ac;
    Object ad;
    Boolean ae;
    Boolean af;
    db ag;
    db ah;
    int f728k;
    View f729l;
    int f730m;
    Bundle f731n;
    SparseArray f732o;
    int f733p;
    String f734q;
    Bundle f735r;
    Fragment f736s;
    int f737t;
    int f738u;
    boolean f739v;
    boolean f740w;
    boolean f741x;
    boolean f742y;
    boolean f743z;

    static {
        f700a = new SimpleArrayMap();
        f701j = new Object();
    }

    public Fragment() {
        this.f728k = 0;
        this.f733p = -1;
        this.f737t = -1;
        this.f715N = true;
        this.f722U = true;
        this.f726Y = null;
        this.f727Z = f701j;
        this.aa = null;
        this.ab = f701j;
        this.ac = null;
        this.ad = f701j;
        this.ag = null;
        this.ah = null;
    }

    public static Fragment m1123a(Context context, String str) {
        return Fragment.m1124a(context, str, null);
    }

    public static Fragment m1124a(Context context, String str, Bundle bundle) {
        try {
            Class cls = (Class) f700a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f700a.put(str, cls);
            }
            Fragment fragment = (Fragment) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.f735r = bundle;
            }
            return fragment;
        } catch (Exception e) {
            throw new Fragment("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e);
        } catch (Exception e2) {
            throw new Fragment("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e2);
        } catch (Exception e22) {
            throw new Fragment("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e22);
        }
    }

    static boolean m1125b(Context context, String str) {
        try {
            Class cls = (Class) f700a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f700a.put(str, cls);
            }
            return Fragment.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    final void m1171f(Bundle bundle) {
        if (this.f732o != null) {
            this.f720S.restoreHierarchyState(this.f732o);
            this.f732o = null;
        }
        this.f716O = false;
        m1174g(bundle);
        if (!this.f716O) {
            throw new dc("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    final void m1140a(int i, Fragment fragment) {
        this.f733p = i;
        if (fragment != null) {
            this.f734q = fragment.f734q + ":" + this.f733p;
        } else {
            this.f734q = "android:fragment:" + this.f733p;
        }
    }

    final boolean m1172f() {
        return this.f702A > 0;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        DebugUtils.m1501a(this, stringBuilder);
        if (this.f733p >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f733p);
        }
        if (this.f707F != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.f707F));
        }
        if (this.f709H != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f709H);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final FragmentActivity m1173g() {
        return this.f704C == null ? null : (FragmentActivity) this.f704C.m800f();
    }

    public final Resources m1175h() {
        if (this.f704C != null) {
            return this.f704C.m801g().getResources();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final ad m1177i() {
        return this.f703B;
    }

    public final ad m1179j() {
        if (this.f705D == null) {
            m1127B();
            if (this.f728k >= 5) {
                this.f705D.m881o();
            } else if (this.f728k >= 4) {
                this.f705D.m880n();
            } else if (this.f728k >= 2) {
                this.f705D.m879m();
            } else if (this.f728k >= 1) {
                this.f705D.m878l();
            }
        }
        return this.f705D;
    }

    public final boolean m1181k() {
        return this.f704C != null && this.f739v;
    }

    public final boolean m1182l() {
        return this.f740w;
    }

    public final boolean m1183m() {
        return this.f710I;
    }

    public void m1162c(boolean z) {
    }

    public void m1146a(Intent intent, int i) {
        m1147a(intent, i, null);
    }

    public void m1147a(Intent intent, int i, Bundle bundle) {
        if (this.f704C == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.f704C.m787a(this, intent, i, bundle);
    }

    public void m1139a(int i, int i2, Intent intent) {
    }

    public void m1141a(int i, String[] strArr, int[] iArr) {
    }

    public LayoutInflater m1155b(Bundle bundle) {
        LayoutInflater b = this.f704C.m794b();
        m1179j();
        ab.m1768a(b, this.f705D.m888v());
        return b;
    }

    public void m1145a(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.f716O = true;
        Activity f = this.f704C == null ? null : this.f704C.m800f();
        if (f != null) {
            this.f716O = false;
            m1143a(f, attributeSet, bundle);
        }
    }

    @Deprecated
    public void m1143a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.f716O = true;
    }

    public void m1144a(Context context) {
        this.f716O = true;
        Activity f = this.f704C == null ? null : this.f704C.m800f();
        if (f != null) {
            this.f716O = false;
            m1142a(f);
        }
    }

    @Deprecated
    public void m1142a(Activity activity) {
        this.f716O = true;
    }

    public Animation m1138a(int i, boolean z, int i2) {
        return null;
    }

    public void m1149a(Bundle bundle) {
        this.f716O = true;
    }

    public View m1137a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public void m1152a(View view, Bundle bundle) {
    }

    public View m1184n() {
        return this.f719R;
    }

    public void m1166d(Bundle bundle) {
        this.f716O = true;
    }

    public void m1174g(Bundle bundle) {
        this.f716O = true;
    }

    public void m1161c() {
        this.f716O = true;
        if (!this.f724W) {
            this.f724W = true;
            if (!this.f725X) {
                this.f725X = true;
                this.f723V = this.f704C.m785a(this.f734q, this.f724W, false);
            }
            if (this.f723V != null) {
                this.f723V.m935b();
            }
        }
    }

    public void m1185o() {
        this.f716O = true;
    }

    public void m1170e(Bundle bundle) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.f716O = true;
    }

    public void m1186p() {
        this.f716O = true;
    }

    public void m1165d() {
        this.f716O = true;
    }

    public void onLowMemory() {
        this.f716O = true;
    }

    public void m1169e() {
        this.f716O = true;
    }

    public void m1187q() {
        this.f716O = true;
        if (!this.f725X) {
            this.f725X = true;
            this.f723V = this.f704C.m785a(this.f734q, this.f724W, false);
        }
        if (this.f723V != null) {
            this.f723V.m941h();
        }
    }

    void m1188r() {
        this.f733p = -1;
        this.f734q = null;
        this.f739v = false;
        this.f740w = false;
        this.f741x = false;
        this.f742y = false;
        this.f743z = false;
        this.f702A = 0;
        this.f703B = null;
        this.f705D = null;
        this.f704C = null;
        this.f707F = 0;
        this.f708G = 0;
        this.f709H = null;
        this.f710I = false;
        this.f711J = false;
        this.f713L = false;
        this.f723V = null;
        this.f724W = false;
        this.f725X = false;
    }

    public void m1157b() {
        this.f716O = true;
    }

    public void m1151a(Menu menu, MenuInflater menuInflater) {
    }

    public void m1150a(Menu menu) {
    }

    public void m1189s() {
    }

    public boolean m1154a(MenuItem menuItem) {
        return false;
    }

    public void m1158b(Menu menu) {
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        m1173g().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public boolean m1160b(MenuItem menuItem) {
        return false;
    }

    public Object m1190t() {
        return this.f726Y;
    }

    public Object m1191u() {
        return this.f727Z == f701j ? m1190t() : this.f727Z;
    }

    public Object m1192v() {
        return this.aa;
    }

    public Object m1193w() {
        return this.ab == f701j ? m1192v() : this.ab;
    }

    public Object m1194x() {
        return this.ac;
    }

    public Object m1195y() {
        return this.ad == f701j ? m1194x() : this.ad;
    }

    public boolean m1196z() {
        return this.af == null ? true : this.af.booleanValue();
    }

    public boolean m1126A() {
        return this.ae == null ? true : this.ae.booleanValue();
    }

    public void m1153a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f707F));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f708G));
        printWriter.print(" mTag=");
        printWriter.println(this.f709H);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f728k);
        printWriter.print(" mIndex=");
        printWriter.print(this.f733p);
        printWriter.print(" mWho=");
        printWriter.print(this.f734q);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f702A);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f739v);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f740w);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f741x);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f742y);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f710I);
        printWriter.print(" mDetached=");
        printWriter.print(this.f711J);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.f715N);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.f714M);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.f712K);
        printWriter.print(" mRetaining=");
        printWriter.print(this.f713L);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.f722U);
        if (this.f703B != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f703B);
        }
        if (this.f704C != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f704C);
        }
        if (this.f706E != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f706E);
        }
        if (this.f735r != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f735r);
        }
        if (this.f731n != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f731n);
        }
        if (this.f732o != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f732o);
        }
        if (this.f736s != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.f736s);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f738u);
        }
        if (this.f717P != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(this.f717P);
        }
        if (this.f718Q != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.f718Q);
        }
        if (this.f719R != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.f719R);
        }
        if (this.f720S != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.f719R);
        }
        if (this.f729l != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.f729l);
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.f730m);
        }
        if (this.f723V != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            this.f723V.m933a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.f705D != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.f705D + ":");
            this.f705D.m849a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    Fragment m1136a(String str) {
        if (str.equals(this.f734q)) {
            return this;
        }
        if (this.f705D != null) {
            return this.f705D.m854b(str);
        }
        return null;
    }

    void m1127B() {
        this.f705D = new af();
        this.f705D.m843a(this.f704C, new Fragment(this), this);
    }

    void m1176h(Bundle bundle) {
        if (this.f705D != null) {
            this.f705D.m877k();
        }
        this.f728k = 1;
        this.f716O = false;
        m1149a(bundle);
        if (!this.f716O) {
            throw new dc("Fragment " + this + " did not call through to super.onCreate()");
        } else if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            if (parcelable != null) {
                if (this.f705D == null) {
                    m1127B();
                }
                this.f705D.m842a(parcelable, null);
                this.f705D.m878l();
            }
        }
    }

    View m1156b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f705D != null) {
            this.f705D.m877k();
        }
        return m1137a(layoutInflater, viewGroup, bundle);
    }

    void m1178i(Bundle bundle) {
        if (this.f705D != null) {
            this.f705D.m877k();
        }
        this.f728k = 2;
        this.f716O = false;
        m1166d(bundle);
        if (!this.f716O) {
            throw new dc("Fragment " + this + " did not call through to super.onActivityCreated()");
        } else if (this.f705D != null) {
            this.f705D.m879m();
        }
    }

    void m1128C() {
        if (this.f705D != null) {
            this.f705D.m877k();
            this.f705D.m873g();
        }
        this.f728k = 4;
        this.f716O = false;
        m1161c();
        if (this.f716O) {
            if (this.f705D != null) {
                this.f705D.m880n();
            }
            if (this.f723V != null) {
                this.f723V.m940g();
                return;
            }
            return;
        }
        throw new dc("Fragment " + this + " did not call through to super.onStart()");
    }

    void m1129D() {
        if (this.f705D != null) {
            this.f705D.m877k();
            this.f705D.m873g();
        }
        this.f728k = 5;
        this.f716O = false;
        m1185o();
        if (!this.f716O) {
            throw new dc("Fragment " + this + " did not call through to super.onResume()");
        } else if (this.f705D != null) {
            this.f705D.m881o();
            this.f705D.m873g();
        }
    }

    void m1148a(Configuration configuration) {
        onConfigurationChanged(configuration);
        if (this.f705D != null) {
            this.f705D.m840a(configuration);
        }
    }

    void m1130E() {
        onLowMemory();
        if (this.f705D != null) {
            this.f705D.m887u();
        }
    }

    boolean m1159b(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.f710I) {
            return false;
        }
        if (this.f714M && this.f715N) {
            z = true;
            m1151a(menu, menuInflater);
        }
        if (this.f705D != null) {
            return z | this.f705D.m852a(menu, menuInflater);
        }
        return z;
    }

    boolean m1163c(Menu menu) {
        boolean z = false;
        if (this.f710I) {
            return false;
        }
        if (this.f714M && this.f715N) {
            z = true;
            m1150a(menu);
        }
        if (this.f705D != null) {
            return z | this.f705D.m851a(menu);
        }
        return z;
    }

    boolean m1164c(MenuItem menuItem) {
        if (!this.f710I) {
            if (this.f714M && this.f715N && m1154a(menuItem)) {
                return true;
            }
            if (this.f705D != null && this.f705D.m853a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    boolean m1168d(MenuItem menuItem) {
        if (!this.f710I) {
            if (m1160b(menuItem)) {
                return true;
            }
            if (this.f705D != null && this.f705D.m861b(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void m1167d(Menu menu) {
        if (!this.f710I) {
            if (this.f714M && this.f715N) {
                m1158b(menu);
            }
            if (this.f705D != null) {
                this.f705D.m859b(menu);
            }
        }
    }

    void m1180j(Bundle bundle) {
        m1170e(bundle);
        if (this.f705D != null) {
            Parcelable j = this.f705D.m876j();
            if (j != null) {
                bundle.putParcelable("android:support:fragments", j);
            }
        }
    }

    void m1131F() {
        if (this.f705D != null) {
            this.f705D.m882p();
        }
        this.f728k = 4;
        this.f716O = false;
        m1186p();
        if (!this.f716O) {
            throw new dc("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    void m1132G() {
        if (this.f705D != null) {
            this.f705D.m883q();
        }
        this.f728k = 3;
        this.f716O = false;
        m1165d();
        if (!this.f716O) {
            throw new dc("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    void m1133H() {
        if (this.f705D != null) {
            this.f705D.m884r();
        }
        this.f728k = 2;
        if (this.f724W) {
            this.f724W = false;
            if (!this.f725X) {
                this.f725X = true;
                this.f723V = this.f704C.m785a(this.f734q, this.f724W, false);
            }
            if (this.f723V == null) {
                return;
            }
            if (this.f704C.m805k()) {
                this.f723V.m937d();
            } else {
                this.f723V.m936c();
            }
        }
    }

    void m1134I() {
        if (this.f705D != null) {
            this.f705D.m885s();
        }
        this.f728k = 1;
        this.f716O = false;
        m1169e();
        if (!this.f716O) {
            throw new dc("Fragment " + this + " did not call through to super.onDestroyView()");
        } else if (this.f723V != null) {
            this.f723V.m939f();
        }
    }

    void m1135J() {
        if (this.f705D != null) {
            this.f705D.m886t();
        }
        this.f728k = 0;
        this.f716O = false;
        m1187q();
        if (!this.f716O) {
            throw new dc("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }
}
