package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.p002h.al;
import android.support.v4.p002h.bu;
import android.support.v4.p014g.DebugUtils;
import android.support.v4.p014g.LogWriter;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: FragmentManager */
final class af extends ad implements al {
    static final Interpolator f491A;
    static final Interpolator f492B;
    static final Interpolator f493C;
    static final Interpolator f494D;
    static boolean f495a;
    static final boolean f496b;
    static Field f497r;
    ArrayList f498c;
    Runnable[] f499d;
    boolean f500e;
    ArrayList f501f;
    ArrayList f502g;
    ArrayList f503h;
    ArrayList f504i;
    ArrayList f505j;
    ArrayList f506k;
    ArrayList f507l;
    ArrayList f508m;
    int f509n;
    ac f510o;
    aa f511p;
    Fragment f512q;
    boolean f513s;
    boolean f514t;
    boolean f515u;
    String f516v;
    boolean f517w;
    Bundle f518x;
    SparseArray f519y;
    Runnable f520z;

    af() {
        this.f509n = 0;
        this.f518x = null;
        this.f519y = null;
        this.f520z = new ag(this);
    }

    static {
        boolean z = false;
        f495a = false;
        if (VERSION.SDK_INT >= 11) {
            z = true;
        }
        f496b = z;
        f497r = null;
        f491A = new DecelerateInterpolator(2.5f);
        f492B = new DecelerateInterpolator(1.5f);
        f493C = new AccelerateInterpolator(2.5f);
        f494D = new AccelerateInterpolator(1.5f);
    }

    static boolean m824a(Animation animation) {
        if (animation instanceof AlphaAnimation) {
            return true;
        }
        if (!(animation instanceof AnimationSet)) {
            return false;
        }
        List animations = ((AnimationSet) animation).getAnimations();
        for (int i = 0; i < animations.size(); i++) {
            if (animations.get(i) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    static boolean m823a(View view, Animation animation) {
        return VERSION.SDK_INT >= 19 && bu.m1950g(view) == 0 && bu.m1965v(view) && m824a(animation);
    }

    private void m822a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
        if (this.f510o != null) {
            try {
                this.f510o.m790a("  ", null, printWriter, new String[0]);
            } catch (Throwable e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                m849a("  ", null, printWriter, new String[0]);
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    public ap m830a() {
        return new BackStackRecord(this);
    }

    public boolean m860b() {
        return m873g();
    }

    public boolean m864c() {
        m828w();
        m860b();
        return m850a(this.f510o.m802h(), null, -1, 0);
    }

    public void m836a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        m848a(new ah(this, i, i2), false);
    }

    public void m841a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.f733p < 0) {
            m822a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.f733p);
    }

    public Fragment m832a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.f501f.size()) {
            m822a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        }
        Fragment fragment = (Fragment) this.f501f.get(i);
        if (fragment != null) {
            return fragment;
        }
        m822a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        return fragment;
    }

    public List m865d() {
        return this.f501f;
    }

    public boolean m870e() {
        return this.f515u;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.f512q != null) {
            DebugUtils.m1501a(this.f512q, stringBuilder);
        } else {
            DebugUtils.m1501a(this.f510o, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void m849a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        Fragment fragment;
        int i2 = 0;
        String str2 = str + "    ";
        if (this.f501f != null) {
            size = this.f501f.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f501f.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment);
                    if (fragment != null) {
                        fragment.m1153a(str2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        if (this.f502g != null) {
            size = this.f502g.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f502g.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.f505j != null) {
            size = this.f505j.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f505j.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.f504i != null) {
            size = this.f504i.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    BackStackRecord backStackRecord = (BackStackRecord) this.f504i.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(backStackRecord.toString());
                    backStackRecord.m1115a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        synchronized (this) {
            if (this.f506k != null) {
                int size2 = this.f506k.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (i = 0; i < size2; i++) {
                        backStackRecord = (BackStackRecord) this.f506k.get(i);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(backStackRecord);
                    }
                }
            }
            if (this.f507l != null && this.f507l.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f507l.toArray()));
            }
        }
        if (this.f498c != null) {
            i = this.f498c.size();
            if (i > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < i) {
                    Runnable runnable = (Runnable) this.f498c.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(runnable);
                    i2++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f510o);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f511p);
        if (this.f512q != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f512q);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f509n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f514t);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f515u);
        if (this.f513s) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f513s);
        }
        if (this.f516v != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.f516v);
        }
        if (this.f503h != null && this.f503h.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.f503h.toArray()));
        }
    }

    static Animation m821a(Context context, float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f491A);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        scaleAnimation = new AlphaAnimation(f3, f4);
        scaleAnimation.setInterpolator(f492B);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    static Animation m820a(Context context, float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(f492B);
        alphaAnimation.setDuration(220);
        return alphaAnimation;
    }

    Animation m835a(Fragment fragment, int i, boolean z, int i2) {
        Animation a = fragment.m1138a(i, z, fragment.f717P);
        if (a != null) {
            return a;
        }
        if (fragment.f717P != 0) {
            a = AnimationUtils.loadAnimation(this.f510o.m801g(), fragment.f717P);
            if (a != null) {
                return a;
            }
        }
        if (i == 0) {
            return null;
        }
        int b = m825b(i, z);
        if (b < 0) {
            return null;
        }
        switch (b) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                return m821a(this.f510o.m801g(), 1.125f, 1.0f, 0.0f, 1.0f);
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                return m821a(this.f510o.m801g(), 1.0f, 0.975f, 1.0f, 0.0f);
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                return m821a(this.f510o.m801g(), 0.975f, 1.0f, 0.0f, 1.0f);
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                return m821a(this.f510o.m801g(), 1.0f, 1.075f, 1.0f, 0.0f);
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                return m820a(this.f510o.m801g(), 0.0f, 1.0f);
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                return m820a(this.f510o.m801g(), 1.0f, 0.0f);
            default:
                if (i2 == 0 && this.f510o.m798d()) {
                    i2 = this.f510o.m799e();
                }
                if (i2 == 0) {
                    return null;
                }
                return null;
        }
    }

    public void m844a(Fragment fragment) {
        if (!fragment.f721T) {
            return;
        }
        if (this.f500e) {
            this.f517w = true;
            return;
        }
        fragment.f721T = false;
        m846a(fragment, this.f509n, 0, 0, false);
    }

    private void m826b(View view, Animation animation) {
        if (view != null && animation != null && m823a(view, animation)) {
            AnimationListener animationListener;
            try {
                if (f497r == null) {
                    f497r = Animation.class.getDeclaredField("mListener");
                    f497r.setAccessible(true);
                }
                animationListener = (AnimationListener) f497r.get(animation);
            } catch (Throwable e) {
                Log.e("FragmentManager", "No field with the name mListener is found in Animation class", e);
                animationListener = null;
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Cannot access Animation's mListener field", e2);
                animationListener = null;
            }
            animation.setAnimationListener(new aj(view, animation, animationListener));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m846a(android.support.v4.app.Fragment r11, int r12, int r13, int r14, boolean r15) {
        /*
        r10 = this;
        r9 = 4;
        r6 = 3;
        r5 = 1;
        r3 = 0;
        r7 = 0;
        r0 = r11.f739v;
        if (r0 == 0) goto L_0x000d;
    L_0x0009:
        r0 = r11.f711J;
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        if (r12 <= r5) goto L_0x0010;
    L_0x000f:
        r12 = r5;
    L_0x0010:
        r0 = r11.f740w;
        if (r0 == 0) goto L_0x001a;
    L_0x0014:
        r0 = r11.f728k;
        if (r12 <= r0) goto L_0x001a;
    L_0x0018:
        r12 = r11.f728k;
    L_0x001a:
        r0 = r11.f721T;
        if (r0 == 0) goto L_0x0025;
    L_0x001e:
        r0 = r11.f728k;
        if (r0 >= r9) goto L_0x0025;
    L_0x0022:
        if (r12 <= r6) goto L_0x0025;
    L_0x0024:
        r12 = r6;
    L_0x0025:
        r0 = r11.f728k;
        if (r0 >= r12) goto L_0x02aa;
    L_0x0029:
        r0 = r11.f741x;
        if (r0 == 0) goto L_0x0032;
    L_0x002d:
        r0 = r11.f742y;
        if (r0 != 0) goto L_0x0032;
    L_0x0031:
        return;
    L_0x0032:
        r0 = r11.f729l;
        if (r0 == 0) goto L_0x0040;
    L_0x0036:
        r11.f729l = r7;
        r2 = r11.f730m;
        r0 = r10;
        r1 = r11;
        r4 = r3;
        r0.m846a(r1, r2, r3, r4, r5);
    L_0x0040:
        r0 = r11.f728k;
        switch(r0) {
            case 0: goto L_0x0080;
            case 1: goto L_0x0176;
            case 2: goto L_0x0247;
            case 3: goto L_0x0247;
            case 4: goto L_0x0268;
            default: goto L_0x0045;
        };
    L_0x0045:
        r0 = r11.f728k;
        if (r0 == r12) goto L_0x0031;
    L_0x0049:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveToState: Fragment state for ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " not updated inline; ";
        r1 = r1.append(r2);
        r2 = "expected state ";
        r1 = r1.append(r2);
        r1 = r1.append(r12);
        r2 = " found ";
        r1 = r1.append(r2);
        r2 = r11.f728k;
        r1 = r1.append(r2);
        r1 = r1.toString();
        android.util.Log.w(r0, r1);
        r11.f728k = r12;
        goto L_0x0031;
    L_0x0080:
        r0 = f495a;
        if (r0 == 0) goto L_0x009c;
    L_0x0084:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x009c:
        r0 = r11.f731n;
        if (r0 == 0) goto L_0x00e4;
    L_0x00a0:
        r0 = r11.f731n;
        r1 = r10.f510o;
        r1 = r1.m801g();
        r1 = r1.getClassLoader();
        r0.setClassLoader(r1);
        r0 = r11.f731n;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r11.f732o = r0;
        r0 = r11.f731n;
        r1 = "android:target_state";
        r0 = r10.m832a(r0, r1);
        r11.f736s = r0;
        r0 = r11.f736s;
        if (r0 == 0) goto L_0x00d1;
    L_0x00c7:
        r0 = r11.f731n;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r3);
        r11.f738u = r0;
    L_0x00d1:
        r0 = r11.f731n;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r5);
        r11.f722U = r0;
        r0 = r11.f722U;
        if (r0 != 0) goto L_0x00e4;
    L_0x00df:
        r11.f721T = r5;
        if (r12 <= r6) goto L_0x00e4;
    L_0x00e3:
        r12 = r6;
    L_0x00e4:
        r0 = r10.f510o;
        r11.f704C = r0;
        r0 = r10.f512q;
        r11.f706E = r0;
        r0 = r10.f512q;
        if (r0 == 0) goto L_0x0124;
    L_0x00f0:
        r0 = r10.f512q;
        r0 = r0.f705D;
    L_0x00f4:
        r11.f703B = r0;
        r11.f716O = r3;
        r0 = r10.f510o;
        r0 = r0.m801g();
        r11.m1144a(r0);
        r0 = r11.f716O;
        if (r0 != 0) goto L_0x012b;
    L_0x0105:
        r0 = new android.support.v4.app.dc;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onAttach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0124:
        r0 = r10.f510o;
        r0 = r0.m803i();
        goto L_0x00f4;
    L_0x012b:
        r0 = r11.f706E;
        if (r0 != 0) goto L_0x0134;
    L_0x012f:
        r0 = r10.f510o;
        r0.m795b(r11);
    L_0x0134:
        r0 = r11.f713L;
        if (r0 != 0) goto L_0x013d;
    L_0x0138:
        r0 = r11.f731n;
        r11.m1176h(r0);
    L_0x013d:
        r11.f713L = r3;
        r0 = r11.f741x;
        if (r0 == 0) goto L_0x0176;
    L_0x0143:
        r0 = r11.f731n;
        r0 = r11.m1155b(r0);
        r1 = r11.f731n;
        r0 = r11.m1156b(r0, r7, r1);
        r11.f719R = r0;
        r0 = r11.f719R;
        if (r0 == 0) goto L_0x0299;
    L_0x0155:
        r0 = r11.f719R;
        r11.f720S = r0;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 11;
        if (r0 < r1) goto L_0x028f;
    L_0x015f:
        r0 = r11.f719R;
        android.support.v4.p002h.bu.m1936b(r0, r3);
    L_0x0164:
        r0 = r11.f710I;
        if (r0 == 0) goto L_0x016f;
    L_0x0168:
        r0 = r11.f719R;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x016f:
        r0 = r11.f719R;
        r1 = r11.f731n;
        r11.m1152a(r0, r1);
    L_0x0176:
        if (r12 <= r5) goto L_0x0247;
    L_0x0178:
        r0 = f495a;
        if (r0 == 0) goto L_0x0194;
    L_0x017c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0194:
        r0 = r11.f741x;
        if (r0 != 0) goto L_0x0237;
    L_0x0198:
        r0 = r11.f708G;
        if (r0 == 0) goto L_0x0408;
    L_0x019c:
        r0 = r10.f511p;
        r1 = r11.f708G;
        r0 = r0.m748a(r1);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x01eb;
    L_0x01a8:
        r1 = r11.f743z;
        if (r1 != 0) goto L_0x01eb;
    L_0x01ac:
        r1 = new java.lang.IllegalArgumentException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r4 = "No view found for id 0x";
        r2 = r2.append(r4);
        r4 = r11.f708G;
        r4 = java.lang.Integer.toHexString(r4);
        r2 = r2.append(r4);
        r4 = " (";
        r2 = r2.append(r4);
        r4 = r11.m1175h();
        r8 = r11.f708G;
        r4 = r4.getResourceName(r8);
        r2 = r2.append(r4);
        r4 = ") for fragment ";
        r2 = r2.append(r4);
        r2 = r2.append(r11);
        r2 = r2.toString();
        r1.<init>(r2);
        r10.m822a(r1);
    L_0x01eb:
        r11.f718Q = r0;
        r1 = r11.f731n;
        r1 = r11.m1155b(r1);
        r2 = r11.f731n;
        r1 = r11.m1156b(r1, r0, r2);
        r11.f719R = r1;
        r1 = r11.f719R;
        if (r1 == 0) goto L_0x02a7;
    L_0x01ff:
        r1 = r11.f719R;
        r11.f720S = r1;
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 11;
        if (r1 < r2) goto L_0x029d;
    L_0x0209:
        r1 = r11.f719R;
        android.support.v4.p002h.bu.m1936b(r1, r3);
    L_0x020e:
        if (r0 == 0) goto L_0x0225;
    L_0x0210:
        r1 = r10.m835a(r11, r13, r5, r14);
        if (r1 == 0) goto L_0x0220;
    L_0x0216:
        r2 = r11.f719R;
        r10.m826b(r2, r1);
        r2 = r11.f719R;
        r2.startAnimation(r1);
    L_0x0220:
        r1 = r11.f719R;
        r0.addView(r1);
    L_0x0225:
        r0 = r11.f710I;
        if (r0 == 0) goto L_0x0230;
    L_0x0229:
        r0 = r11.f719R;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x0230:
        r0 = r11.f719R;
        r1 = r11.f731n;
        r11.m1152a(r0, r1);
    L_0x0237:
        r0 = r11.f731n;
        r11.m1178i(r0);
        r0 = r11.f719R;
        if (r0 == 0) goto L_0x0245;
    L_0x0240:
        r0 = r11.f731n;
        r11.m1171f(r0);
    L_0x0245:
        r11.f731n = r7;
    L_0x0247:
        if (r12 <= r6) goto L_0x0268;
    L_0x0249:
        r0 = f495a;
        if (r0 == 0) goto L_0x0265;
    L_0x024d:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0265:
        r11.m1128C();
    L_0x0268:
        if (r12 <= r9) goto L_0x0045;
    L_0x026a:
        r0 = f495a;
        if (r0 == 0) goto L_0x0286;
    L_0x026e:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0286:
        r11.m1129D();
        r11.f731n = r7;
        r11.f732o = r7;
        goto L_0x0045;
    L_0x028f:
        r0 = r11.f719R;
        r0 = android.support.v4.app.bg.m978a(r0);
        r11.f719R = r0;
        goto L_0x0164;
    L_0x0299:
        r11.f720S = r7;
        goto L_0x0176;
    L_0x029d:
        r1 = r11.f719R;
        r1 = android.support.v4.app.bg.m978a(r1);
        r11.f719R = r1;
        goto L_0x020e;
    L_0x02a7:
        r11.f720S = r7;
        goto L_0x0237;
    L_0x02aa:
        r0 = r11.f728k;
        if (r0 <= r12) goto L_0x0045;
    L_0x02ae:
        r0 = r11.f728k;
        switch(r0) {
            case 1: goto L_0x02b5;
            case 2: goto L_0x0333;
            case 3: goto L_0x0312;
            case 4: goto L_0x02f1;
            case 5: goto L_0x02cf;
            default: goto L_0x02b3;
        };
    L_0x02b3:
        goto L_0x0045;
    L_0x02b5:
        if (r12 >= r5) goto L_0x0045;
    L_0x02b7:
        r0 = r10.f515u;
        if (r0 == 0) goto L_0x02c6;
    L_0x02bb:
        r0 = r11.f729l;
        if (r0 == 0) goto L_0x02c6;
    L_0x02bf:
        r0 = r11.f729l;
        r11.f729l = r7;
        r0.clearAnimation();
    L_0x02c6:
        r0 = r11.f729l;
        if (r0 == 0) goto L_0x03a2;
    L_0x02ca:
        r11.f730m = r12;
        r12 = r5;
        goto L_0x0045;
    L_0x02cf:
        r0 = 5;
        if (r12 >= r0) goto L_0x02f1;
    L_0x02d2:
        r0 = f495a;
        if (r0 == 0) goto L_0x02ee;
    L_0x02d6:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02ee:
        r11.m1131F();
    L_0x02f1:
        if (r12 >= r9) goto L_0x0312;
    L_0x02f3:
        r0 = f495a;
        if (r0 == 0) goto L_0x030f;
    L_0x02f7:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x030f:
        r11.m1132G();
    L_0x0312:
        if (r12 >= r6) goto L_0x0333;
    L_0x0314:
        r0 = f495a;
        if (r0 == 0) goto L_0x0330;
    L_0x0318:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STOPPED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0330:
        r11.m1133H();
    L_0x0333:
        r0 = 2;
        if (r12 >= r0) goto L_0x02b5;
    L_0x0336:
        r0 = f495a;
        if (r0 == 0) goto L_0x0352;
    L_0x033a:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0352:
        r0 = r11.f719R;
        if (r0 == 0) goto L_0x0365;
    L_0x0356:
        r0 = r10.f510o;
        r0 = r0.m793a(r11);
        if (r0 == 0) goto L_0x0365;
    L_0x035e:
        r0 = r11.f732o;
        if (r0 != 0) goto L_0x0365;
    L_0x0362:
        r10.m868e(r11);
    L_0x0365:
        r11.m1134I();
        r0 = r11.f719R;
        if (r0 == 0) goto L_0x039a;
    L_0x036c:
        r0 = r11.f718Q;
        if (r0 == 0) goto L_0x039a;
    L_0x0370:
        r0 = r10.f509n;
        if (r0 <= 0) goto L_0x0405;
    L_0x0374:
        r0 = r10.f515u;
        if (r0 != 0) goto L_0x0405;
    L_0x0378:
        r0 = r10.m835a(r11, r13, r3, r14);
    L_0x037c:
        if (r0 == 0) goto L_0x0393;
    L_0x037e:
        r1 = r11.f719R;
        r11.f729l = r1;
        r11.f730m = r12;
        r1 = r11.f719R;
        r2 = new android.support.v4.app.ai;
        r2.<init>(r10, r1, r0, r11);
        r0.setAnimationListener(r2);
        r1 = r11.f719R;
        r1.startAnimation(r0);
    L_0x0393:
        r0 = r11.f718Q;
        r1 = r11.f719R;
        r0.removeView(r1);
    L_0x039a:
        r11.f718Q = r7;
        r11.f719R = r7;
        r11.f720S = r7;
        goto L_0x02b5;
    L_0x03a2:
        r0 = f495a;
        if (r0 == 0) goto L_0x03be;
    L_0x03a6:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x03be:
        r0 = r11.f713L;
        if (r0 != 0) goto L_0x03ed;
    L_0x03c2:
        r11.m1135J();
    L_0x03c5:
        r11.f716O = r3;
        r11.m1157b();
        r0 = r11.f716O;
        if (r0 != 0) goto L_0x03f0;
    L_0x03ce:
        r0 = new android.support.v4.app.dc;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onDetach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x03ed:
        r11.f728k = r3;
        goto L_0x03c5;
    L_0x03f0:
        if (r15 != 0) goto L_0x0045;
    L_0x03f2:
        r0 = r11.f713L;
        if (r0 != 0) goto L_0x03fb;
    L_0x03f6:
        r10.m866d(r11);
        goto L_0x0045;
    L_0x03fb:
        r11.f704C = r7;
        r11.f706E = r7;
        r11.f703B = r7;
        r11.f705D = r7;
        goto L_0x0045;
    L_0x0405:
        r0 = r7;
        goto L_0x037c;
    L_0x0408:
        r0 = r7;
        goto L_0x01eb;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.af.a(android.support.v4.app.t, int, int, int, boolean):void");
    }

    void m857b(Fragment fragment) {
        m846a(fragment, this.f509n, 0, 0, false);
    }

    void m839a(int i, boolean z) {
        m837a(i, 0, 0, z);
    }

    void m837a(int i, int i2, int i3, boolean z) {
        if (this.f510o == null && i != 0) {
            throw new IllegalStateException("No host");
        } else if (z || this.f509n != i) {
            this.f509n = i;
            if (this.f501f != null) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < this.f501f.size()) {
                    int a;
                    Fragment fragment = (Fragment) this.f501f.get(i4);
                    if (fragment != null) {
                        m846a(fragment, i, i2, i3, false);
                        if (fragment.f723V != null) {
                            a = i5 | fragment.f723V.m934a();
                            i4++;
                            i5 = a;
                        }
                    }
                    a = i5;
                    i4++;
                    i5 = a;
                }
                if (i5 == 0) {
                    m872f();
                }
                if (this.f513s && this.f510o != null && this.f509n == 5) {
                    this.f510o.m797c();
                    this.f513s = false;
                }
            }
        }
    }

    void m872f() {
        if (this.f501f != null) {
            for (int i = 0; i < this.f501f.size(); i++) {
                Fragment fragment = (Fragment) this.f501f.get(i);
                if (fragment != null) {
                    m844a(fragment);
                }
            }
        }
    }

    void m862c(Fragment fragment) {
        if (fragment.f733p < 0) {
            if (this.f503h == null || this.f503h.size() <= 0) {
                if (this.f501f == null) {
                    this.f501f = new ArrayList();
                }
                fragment.m1140a(this.f501f.size(), this.f512q);
                this.f501f.add(fragment);
            } else {
                fragment.m1140a(((Integer) this.f503h.remove(this.f503h.size() - 1)).intValue(), this.f512q);
                this.f501f.set(fragment.f733p, fragment);
            }
            if (f495a) {
                Log.v("FragmentManager", "Allocated fragment index " + fragment);
            }
        }
    }

    void m866d(Fragment fragment) {
        if (fragment.f733p >= 0) {
            if (f495a) {
                Log.v("FragmentManager", "Freeing fragment index " + fragment);
            }
            this.f501f.set(fragment.f733p, null);
            if (this.f503h == null) {
                this.f503h = new ArrayList();
            }
            this.f503h.add(Integer.valueOf(fragment.f733p));
            this.f510o.m789a(fragment.f734q);
            fragment.m1188r();
        }
    }

    public void m847a(Fragment fragment, boolean z) {
        if (this.f502g == null) {
            this.f502g = new ArrayList();
        }
        if (f495a) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        m862c(fragment);
        if (!fragment.f711J) {
            if (this.f502g.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            this.f502g.add(fragment);
            fragment.f739v = true;
            fragment.f740w = false;
            if (fragment.f714M && fragment.f715N) {
                this.f513s = true;
            }
            if (z) {
                m857b(fragment);
            }
        }
    }

    public void m845a(Fragment fragment, int i, int i2) {
        if (f495a) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.f702A);
        }
        boolean z = !fragment.m1172f();
        if (!fragment.f711J || z) {
            int i3;
            if (this.f502g != null) {
                this.f502g.remove(fragment);
            }
            if (fragment.f714M && fragment.f715N) {
                this.f513s = true;
            }
            fragment.f739v = false;
            fragment.f740w = true;
            if (z) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            m846a(fragment, i3, i, i2, false);
        }
    }

    public void m858b(Fragment fragment, int i, int i2) {
        if (f495a) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.f710I) {
            fragment.f710I = true;
            if (fragment.f719R != null) {
                Animation a = m835a(fragment, i, false, i2);
                if (a != null) {
                    m826b(fragment.f719R, a);
                    fragment.f719R.startAnimation(a);
                }
                fragment.f719R.setVisibility(8);
            }
            if (fragment.f739v && fragment.f714M && fragment.f715N) {
                this.f513s = true;
            }
            fragment.m1162c(true);
        }
    }

    public void m863c(Fragment fragment, int i, int i2) {
        if (f495a) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.f710I) {
            fragment.f710I = false;
            if (fragment.f719R != null) {
                Animation a = m835a(fragment, i, true, i2);
                if (a != null) {
                    m826b(fragment.f719R, a);
                    fragment.f719R.startAnimation(a);
                }
                fragment.f719R.setVisibility(0);
            }
            if (fragment.f739v && fragment.f714M && fragment.f715N) {
                this.f513s = true;
            }
            fragment.m1162c(false);
        }
    }

    public void m867d(Fragment fragment, int i, int i2) {
        if (f495a) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.f711J) {
            fragment.f711J = true;
            if (fragment.f739v) {
                if (this.f502g != null) {
                    if (f495a) {
                        Log.v("FragmentManager", "remove from detach: " + fragment);
                    }
                    this.f502g.remove(fragment);
                }
                if (fragment.f714M && fragment.f715N) {
                    this.f513s = true;
                }
                fragment.f739v = false;
                m846a(fragment, 1, i, i2, false);
            }
        }
    }

    public void m869e(Fragment fragment, int i, int i2) {
        if (f495a) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.f711J) {
            fragment.f711J = false;
            if (!fragment.f739v) {
                if (this.f502g == null) {
                    this.f502g = new ArrayList();
                }
                if (this.f502g.contains(fragment)) {
                    throw new IllegalStateException("Fragment already added: " + fragment);
                }
                if (f495a) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                this.f502g.add(fragment);
                fragment.f739v = true;
                if (fragment.f714M && fragment.f715N) {
                    this.f513s = true;
                }
                m846a(fragment, this.f509n, i, i2, false);
            }
        }
    }

    public Fragment m831a(int i) {
        int size;
        Fragment fragment;
        if (this.f502g != null) {
            for (size = this.f502g.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f502g.get(size);
                if (fragment != null && fragment.f707F == i) {
                    return fragment;
                }
            }
        }
        if (this.f501f != null) {
            for (size = this.f501f.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f501f.get(size);
                if (fragment != null && fragment.f707F == i) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public Fragment m833a(String str) {
        int size;
        Fragment fragment;
        if (!(this.f502g == null || str == null)) {
            for (size = this.f502g.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f502g.get(size);
                if (fragment != null && str.equals(fragment.f709H)) {
                    return fragment;
                }
            }
        }
        if (!(this.f501f == null || str == null)) {
            for (size = this.f501f.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f501f.get(size);
                if (fragment != null && str.equals(fragment.f709H)) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public Fragment m854b(String str) {
        if (!(this.f501f == null || str == null)) {
            for (int size = this.f501f.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.f501f.get(size);
                if (fragment != null) {
                    fragment = fragment.m1136a(str);
                    if (fragment != null) {
                        return fragment;
                    }
                }
            }
        }
        return null;
    }

    private void m828w() {
        if (this.f514t) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.f516v != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.f516v);
        }
    }

    public void m848a(Runnable runnable, boolean z) {
        if (!z) {
            m828w();
        }
        synchronized (this) {
            if (this.f515u || this.f510o == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.f498c == null) {
                this.f498c = new ArrayList();
            }
            this.f498c.add(runnable);
            if (this.f498c.size() == 1) {
                this.f510o.m802h().removeCallbacks(this.f520z);
                this.f510o.m802h().post(this.f520z);
            }
        }
    }

    public int m829a(BackStackRecord backStackRecord) {
        int size;
        synchronized (this) {
            if (this.f507l == null || this.f507l.size() <= 0) {
                if (this.f506k == null) {
                    this.f506k = new ArrayList();
                }
                size = this.f506k.size();
                if (f495a) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + backStackRecord);
                }
                this.f506k.add(backStackRecord);
            } else {
                size = ((Integer) this.f507l.remove(this.f507l.size() - 1)).intValue();
                if (f495a) {
                    Log.v("FragmentManager", "Adding back stack index " + size + " with " + backStackRecord);
                }
                this.f506k.set(size, backStackRecord);
            }
        }
        return size;
    }

    public void m838a(int i, BackStackRecord backStackRecord) {
        synchronized (this) {
            if (this.f506k == null) {
                this.f506k = new ArrayList();
            }
            int size = this.f506k.size();
            if (i < size) {
                if (f495a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + backStackRecord);
                }
                this.f506k.set(i, backStackRecord);
            } else {
                while (size < i) {
                    this.f506k.add(null);
                    if (this.f507l == null) {
                        this.f507l = new ArrayList();
                    }
                    if (f495a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f507l.add(Integer.valueOf(size));
                    size++;
                }
                if (f495a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + backStackRecord);
                }
                this.f506k.add(backStackRecord);
            }
        }
    }

    public void m855b(int i) {
        synchronized (this) {
            this.f506k.set(i, null);
            if (this.f507l == null) {
                this.f507l = new ArrayList();
            }
            if (f495a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.f507l.add(Integer.valueOf(i));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m873g() {
        /*
        r6 = this;
        r0 = 1;
        r2 = 0;
        r1 = r6.f500e;
        if (r1 == 0) goto L_0x000e;
    L_0x0006:
        r0 = new java.lang.IllegalStateException;
        r1 = "Recursive entry to executePendingTransactions";
        r0.<init>(r1);
        throw r0;
    L_0x000e:
        r1 = android.os.Looper.myLooper();
        r3 = r6.f510o;
        r3 = r3.m802h();
        r3 = r3.getLooper();
        if (r1 == r3) goto L_0x0026;
    L_0x001e:
        r0 = new java.lang.IllegalStateException;
        r1 = "Must be called from main thread of process";
        r0.<init>(r1);
        throw r0;
    L_0x0026:
        r1 = r2;
    L_0x0027:
        monitor-enter(r6);
        r3 = r6.f498c;	 Catch:{ all -> 0x009b }
        if (r3 == 0) goto L_0x0034;
    L_0x002c:
        r3 = r6.f498c;	 Catch:{ all -> 0x009b }
        r3 = r3.size();	 Catch:{ all -> 0x009b }
        if (r3 != 0) goto L_0x005c;
    L_0x0034:
        monitor-exit(r6);	 Catch:{ all -> 0x009b }
        r0 = r6.f517w;
        if (r0 == 0) goto L_0x00a9;
    L_0x0039:
        r3 = r2;
        r4 = r2;
    L_0x003b:
        r0 = r6.f501f;
        r0 = r0.size();
        if (r3 >= r0) goto L_0x00a2;
    L_0x0043:
        r0 = r6.f501f;
        r0 = r0.get(r3);
        r0 = (android.support.v4.app.Fragment) r0;
        if (r0 == 0) goto L_0x0058;
    L_0x004d:
        r5 = r0.f723V;
        if (r5 == 0) goto L_0x0058;
    L_0x0051:
        r0 = r0.f723V;
        r0 = r0.m934a();
        r4 = r4 | r0;
    L_0x0058:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x003b;
    L_0x005c:
        r1 = r6.f498c;	 Catch:{ all -> 0x009b }
        r3 = r1.size();	 Catch:{ all -> 0x009b }
        r1 = r6.f499d;	 Catch:{ all -> 0x009b }
        if (r1 == 0) goto L_0x006b;
    L_0x0066:
        r1 = r6.f499d;	 Catch:{ all -> 0x009b }
        r1 = r1.length;	 Catch:{ all -> 0x009b }
        if (r1 >= r3) goto L_0x006f;
    L_0x006b:
        r1 = new java.lang.Runnable[r3];	 Catch:{ all -> 0x009b }
        r6.f499d = r1;	 Catch:{ all -> 0x009b }
    L_0x006f:
        r1 = r6.f498c;	 Catch:{ all -> 0x009b }
        r4 = r6.f499d;	 Catch:{ all -> 0x009b }
        r1.toArray(r4);	 Catch:{ all -> 0x009b }
        r1 = r6.f498c;	 Catch:{ all -> 0x009b }
        r1.clear();	 Catch:{ all -> 0x009b }
        r1 = r6.f510o;	 Catch:{ all -> 0x009b }
        r1 = r1.m802h();	 Catch:{ all -> 0x009b }
        r4 = r6.f520z;	 Catch:{ all -> 0x009b }
        r1.removeCallbacks(r4);	 Catch:{ all -> 0x009b }
        monitor-exit(r6);	 Catch:{ all -> 0x009b }
        r6.f500e = r0;
        r1 = r2;
    L_0x008a:
        if (r1 >= r3) goto L_0x009e;
    L_0x008c:
        r4 = r6.f499d;
        r4 = r4[r1];
        r4.run();
        r4 = r6.f499d;
        r5 = 0;
        r4[r1] = r5;
        r1 = r1 + 1;
        goto L_0x008a;
    L_0x009b:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x009b }
        throw r0;
    L_0x009e:
        r6.f500e = r2;
        r1 = r0;
        goto L_0x0027;
    L_0x00a2:
        if (r4 != 0) goto L_0x00a9;
    L_0x00a4:
        r6.f517w = r2;
        r6.m872f();
    L_0x00a9:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.af.g():boolean");
    }

    void m874h() {
        if (this.f508m != null) {
            for (int i = 0; i < this.f508m.size(); i++) {
                ((ae) this.f508m.get(i)).m818a();
            }
        }
    }

    void m856b(BackStackRecord backStackRecord) {
        if (this.f504i == null) {
            this.f504i = new ArrayList();
        }
        this.f504i.add(backStackRecord);
        m874h();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    boolean m850a(android.os.Handler r12, java.lang.String r13, int r14, int r15) {
        /*
        r11 = this;
        r4 = 0;
        r2 = 1;
        r3 = 0;
        r0 = r11.f504i;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r3;
    L_0x0008:
        if (r13 != 0) goto L_0x0037;
    L_0x000a:
        if (r14 >= 0) goto L_0x0037;
    L_0x000c:
        r0 = r15 & 1;
        if (r0 != 0) goto L_0x0037;
    L_0x0010:
        r0 = r11.f504i;
        r0 = r0.size();
        r0 = r0 + -1;
        if (r0 < 0) goto L_0x0007;
    L_0x001a:
        r1 = r11.f504i;
        r0 = r1.remove(r0);
        r0 = (android.support.v4.app.BackStackRecord) r0;
        r1 = new android.util.SparseArray;
        r1.<init>();
        r3 = new android.util.SparseArray;
        r3.<init>();
        r0.m1114a(r1, r3);
        r0.m1111a(r2, r4, r1, r3);
        r11.m874h();
    L_0x0035:
        r3 = r2;
        goto L_0x0007;
    L_0x0037:
        r0 = -1;
        if (r13 != 0) goto L_0x003c;
    L_0x003a:
        if (r14 < 0) goto L_0x008b;
    L_0x003c:
        r0 = r11.f504i;
        r0 = r0.size();
        r1 = r0 + -1;
    L_0x0044:
        if (r1 < 0) goto L_0x005a;
    L_0x0046:
        r0 = r11.f504i;
        r0 = r0.get(r1);
        r0 = (android.support.v4.app.BackStackRecord) r0;
        if (r13 == 0) goto L_0x0081;
    L_0x0050:
        r5 = r0.m1118c();
        r5 = r13.equals(r5);
        if (r5 == 0) goto L_0x0081;
    L_0x005a:
        if (r1 < 0) goto L_0x0007;
    L_0x005c:
        r0 = r15 & 1;
        if (r0 == 0) goto L_0x008a;
    L_0x0060:
        r1 = r1 + -1;
    L_0x0062:
        if (r1 < 0) goto L_0x008a;
    L_0x0064:
        r0 = r11.f504i;
        r0 = r0.get(r1);
        r0 = (android.support.v4.app.BackStackRecord) r0;
        if (r13 == 0) goto L_0x0078;
    L_0x006e:
        r5 = r0.m1118c();
        r5 = r13.equals(r5);
        if (r5 != 0) goto L_0x007e;
    L_0x0078:
        if (r14 < 0) goto L_0x008a;
    L_0x007a:
        r0 = r0.f664p;
        if (r14 != r0) goto L_0x008a;
    L_0x007e:
        r1 = r1 + -1;
        goto L_0x0062;
    L_0x0081:
        if (r14 < 0) goto L_0x0087;
    L_0x0083:
        r0 = r0.f664p;
        if (r14 == r0) goto L_0x005a;
    L_0x0087:
        r1 = r1 + -1;
        goto L_0x0044;
    L_0x008a:
        r0 = r1;
    L_0x008b:
        r1 = r11.f504i;
        r1 = r1.size();
        r1 = r1 + -1;
        if (r0 == r1) goto L_0x0007;
    L_0x0095:
        r6 = new java.util.ArrayList;
        r6.<init>();
        r1 = r11.f504i;
        r1 = r1.size();
        r1 = r1 + -1;
    L_0x00a2:
        if (r1 <= r0) goto L_0x00b0;
    L_0x00a4:
        r5 = r11.f504i;
        r5 = r5.remove(r1);
        r6.add(r5);
        r1 = r1 + -1;
        goto L_0x00a2;
    L_0x00b0:
        r0 = r6.size();
        r7 = r0 + -1;
        r8 = new android.util.SparseArray;
        r8.<init>();
        r9 = new android.util.SparseArray;
        r9.<init>();
        r1 = r3;
    L_0x00c1:
        if (r1 > r7) goto L_0x00d0;
    L_0x00c3:
        r0 = r6.get(r1);
        r0 = (android.support.v4.app.BackStackRecord) r0;
        r0.m1114a(r8, r9);
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00c1;
    L_0x00d0:
        r5 = r4;
        r4 = r3;
    L_0x00d2:
        if (r4 > r7) goto L_0x0108;
    L_0x00d4:
        r0 = f495a;
        if (r0 == 0) goto L_0x00f4;
    L_0x00d8:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r10 = "Popping back stack state: ";
        r1 = r1.append(r10);
        r10 = r6.get(r4);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x00f4:
        r0 = r6.get(r4);
        r0 = (android.support.v4.app.BackStackRecord) r0;
        if (r4 != r7) goto L_0x0106;
    L_0x00fc:
        r1 = r2;
    L_0x00fd:
        r1 = r0.m1111a(r1, r5, r8, r9);
        r0 = r4 + 1;
        r4 = r0;
        r5 = r1;
        goto L_0x00d2;
    L_0x0106:
        r1 = r3;
        goto L_0x00fd;
    L_0x0108:
        r11.m874h();
        goto L_0x0035;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.af.a(android.os.Handler, java.lang.String, int, int):boolean");
    }

    ArrayList m875i() {
        ArrayList arrayList = null;
        if (this.f501f != null) {
            for (int i = 0; i < this.f501f.size(); i++) {
                Fragment fragment = (Fragment) this.f501f.get(i);
                if (fragment != null && fragment.f712K) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                    fragment.f713L = true;
                    fragment.f737t = fragment.f736s != null ? fragment.f736s.f733p : -1;
                    if (f495a) {
                        Log.v("FragmentManager", "retainNonConfig: keeping retained " + fragment);
                    }
                }
            }
        }
        return arrayList;
    }

    void m868e(Fragment fragment) {
        if (fragment.f720S != null) {
            if (this.f519y == null) {
                this.f519y = new SparseArray();
            } else {
                this.f519y.clear();
            }
            fragment.f720S.saveHierarchyState(this.f519y);
            if (this.f519y.size() > 0) {
                fragment.f732o = this.f519y;
                this.f519y = null;
            }
        }
    }

    Bundle m871f(Fragment fragment) {
        Bundle bundle;
        if (this.f518x == null) {
            this.f518x = new Bundle();
        }
        fragment.m1180j(this.f518x);
        if (this.f518x.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.f518x;
            this.f518x = null;
        }
        if (fragment.f719R != null) {
            m868e(fragment);
        }
        if (fragment.f732o != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.f732o);
        }
        if (!fragment.f722U) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.f722U);
        }
        return bundle;
    }

    Parcelable m876j() {
        BackStackState[] backStackStateArr = null;
        m873g();
        if (f496b) {
            this.f514t = true;
        }
        if (this.f501f == null || this.f501f.size() <= 0) {
            return null;
        }
        int size = this.f501f.size();
        FragmentState[] fragmentStateArr = new FragmentState[size];
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            Fragment fragment = (Fragment) this.f501f.get(i);
            if (fragment != null) {
                if (fragment.f733p < 0) {
                    m822a(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.f733p));
                }
                FragmentState fragmentState = new FragmentState(fragment);
                fragmentStateArr[i] = fragmentState;
                if (fragment.f728k <= 0 || fragmentState.f478j != null) {
                    fragmentState.f478j = fragment.f731n;
                } else {
                    fragmentState.f478j = m871f(fragment);
                    if (fragment.f736s != null) {
                        if (fragment.f736s.f733p < 0) {
                            m822a(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.f736s));
                        }
                        if (fragmentState.f478j == null) {
                            fragmentState.f478j = new Bundle();
                        }
                        m841a(fragmentState.f478j, "android:target_state", fragment.f736s);
                        if (fragment.f738u != 0) {
                            fragmentState.f478j.putInt("android:target_req_state", fragment.f738u);
                        }
                    }
                }
                if (f495a) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragmentState.f478j);
                }
                z2 = true;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        if (z) {
            int[] iArr;
            int i2;
            FragmentManagerState fragmentManagerState;
            if (this.f502g != null) {
                i = this.f502g.size();
                if (i > 0) {
                    iArr = new int[i];
                    for (i2 = 0; i2 < i; i2++) {
                        iArr[i2] = ((Fragment) this.f502g.get(i2)).f733p;
                        if (iArr[i2] < 0) {
                            m822a(new IllegalStateException("Failure saving state: active " + this.f502g.get(i2) + " has cleared index: " + iArr[i2]));
                        }
                        if (f495a) {
                            Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.f502g.get(i2));
                        }
                    }
                    if (this.f504i != null) {
                        i = this.f504i.size();
                        if (i > 0) {
                            backStackStateArr = new BackStackState[i];
                            for (i2 = 0; i2 < i; i2++) {
                                backStackStateArr[i2] = new BackStackState((BackStackRecord) this.f504i.get(i2));
                                if (f495a) {
                                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f504i.get(i2));
                                }
                            }
                        }
                    }
                    fragmentManagerState = new FragmentManagerState();
                    fragmentManagerState.f466a = fragmentStateArr;
                    fragmentManagerState.f467b = iArr;
                    fragmentManagerState.f468c = backStackStateArr;
                    return fragmentManagerState;
                }
            }
            iArr = null;
            if (this.f504i != null) {
                i = this.f504i.size();
                if (i > 0) {
                    backStackStateArr = new BackStackState[i];
                    for (i2 = 0; i2 < i; i2++) {
                        backStackStateArr[i2] = new BackStackState((BackStackRecord) this.f504i.get(i2));
                        if (f495a) {
                            Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f504i.get(i2));
                        }
                    }
                }
            }
            fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.f466a = fragmentStateArr;
            fragmentManagerState.f467b = iArr;
            fragmentManagerState.f468c = backStackStateArr;
            return fragmentManagerState;
        } else if (!f495a) {
            return null;
        } else {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
    }

    void m842a(Parcelable parcelable, List list) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.f466a != null) {
                int i;
                Fragment fragment;
                int i2;
                if (list != null) {
                    for (i = 0; i < list.size(); i++) {
                        fragment = (Fragment) list.get(i);
                        if (f495a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                        }
                        FragmentState fragmentState = fragmentManagerState.f466a[fragment.f733p];
                        fragmentState.f479k = fragment;
                        fragment.f732o = null;
                        fragment.f702A = 0;
                        fragment.f742y = false;
                        fragment.f739v = false;
                        fragment.f736s = null;
                        if (fragmentState.f478j != null) {
                            fragmentState.f478j.setClassLoader(this.f510o.m801g().getClassLoader());
                            fragment.f732o = fragmentState.f478j.getSparseParcelableArray("android:view_state");
                            fragment.f731n = fragmentState.f478j;
                        }
                    }
                }
                this.f501f = new ArrayList(fragmentManagerState.f466a.length);
                if (this.f503h != null) {
                    this.f503h.clear();
                }
                for (i2 = 0; i2 < fragmentManagerState.f466a.length; i2++) {
                    FragmentState fragmentState2 = fragmentManagerState.f466a[i2];
                    if (fragmentState2 != null) {
                        Fragment a = fragmentState2.m740a(this.f510o, this.f512q);
                        if (f495a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i2 + ": " + a);
                        }
                        this.f501f.add(a);
                        fragmentState2.f479k = null;
                    } else {
                        this.f501f.add(null);
                        if (this.f503h == null) {
                            this.f503h = new ArrayList();
                        }
                        if (f495a) {
                            Log.v("FragmentManager", "restoreAllState: avail #" + i2);
                        }
                        this.f503h.add(Integer.valueOf(i2));
                    }
                }
                if (list != null) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        fragment = (Fragment) list.get(i3);
                        if (fragment.f737t >= 0) {
                            if (fragment.f737t < this.f501f.size()) {
                                fragment.f736s = (Fragment) this.f501f.get(fragment.f737t);
                            } else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + fragment + " target no longer exists: " + fragment.f737t);
                                fragment.f736s = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.f467b != null) {
                    this.f502g = new ArrayList(fragmentManagerState.f467b.length);
                    for (i = 0; i < fragmentManagerState.f467b.length; i++) {
                        fragment = (Fragment) this.f501f.get(fragmentManagerState.f467b[i]);
                        if (fragment == null) {
                            m822a(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.f467b[i]));
                        }
                        fragment.f739v = true;
                        if (f495a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + i + ": " + fragment);
                        }
                        if (this.f502g.contains(fragment)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.f502g.add(fragment);
                    }
                } else {
                    this.f502g = null;
                }
                if (fragmentManagerState.f468c != null) {
                    this.f504i = new ArrayList(fragmentManagerState.f468c.length);
                    for (i2 = 0; i2 < fragmentManagerState.f468c.length; i2++) {
                        BackStackRecord a2 = fragmentManagerState.f468c[i2].m739a(this);
                        if (f495a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + a2.f664p + "): " + a2);
                            a2.m1116a("  ", new PrintWriter(new LogWriter("FragmentManager")), false);
                        }
                        this.f504i.add(a2);
                        if (a2.f664p >= 0) {
                            m838a(a2.f664p, a2);
                        }
                    }
                    return;
                }
                this.f504i = null;
            }
        }
    }

    public void m843a(ac acVar, aa aaVar, Fragment fragment) {
        if (this.f510o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f510o = acVar;
        this.f511p = aaVar;
        this.f512q = fragment;
    }

    public void m877k() {
        this.f514t = false;
    }

    public void m878l() {
        this.f514t = false;
        m839a(1, false);
    }

    public void m879m() {
        this.f514t = false;
        m839a(2, false);
    }

    public void m880n() {
        this.f514t = false;
        m839a(4, false);
    }

    public void m881o() {
        this.f514t = false;
        m839a(5, false);
    }

    public void m882p() {
        m839a(4, false);
    }

    public void m883q() {
        this.f514t = true;
        m839a(3, false);
    }

    public void m884r() {
        m839a(2, false);
    }

    public void m885s() {
        m839a(1, false);
    }

    public void m886t() {
        this.f515u = true;
        m873g();
        m839a(0, false);
        this.f510o = null;
        this.f511p = null;
        this.f512q = null;
    }

    public void m840a(Configuration configuration) {
        if (this.f502g != null) {
            for (int i = 0; i < this.f502g.size(); i++) {
                Fragment fragment = (Fragment) this.f502g.get(i);
                if (fragment != null) {
                    fragment.m1148a(configuration);
                }
            }
        }
    }

    public void m887u() {
        if (this.f502g != null) {
            for (int i = 0; i < this.f502g.size(); i++) {
                Fragment fragment = (Fragment) this.f502g.get(i);
                if (fragment != null) {
                    fragment.m1130E();
                }
            }
        }
    }

    public boolean m852a(Menu menu, MenuInflater menuInflater) {
        boolean z;
        Fragment fragment;
        int i = 0;
        ArrayList arrayList = null;
        if (this.f502g != null) {
            int i2 = 0;
            z = false;
            while (i2 < this.f502g.size()) {
                fragment = (Fragment) this.f502g.get(i2);
                if (fragment != null && fragment.m1159b(menu, menuInflater)) {
                    z = true;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                }
                i2++;
                z = z;
            }
        } else {
            z = false;
        }
        if (this.f505j != null) {
            while (i < this.f505j.size()) {
                fragment = (Fragment) this.f505j.get(i);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    fragment.m1189s();
                }
                i++;
            }
        }
        this.f505j = arrayList;
        return z;
    }

    public boolean m851a(Menu menu) {
        if (this.f502g == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.f502g.size(); i++) {
            Fragment fragment = (Fragment) this.f502g.get(i);
            if (fragment != null && fragment.m1163c(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean m853a(MenuItem menuItem) {
        if (this.f502g == null) {
            return false;
        }
        for (int i = 0; i < this.f502g.size(); i++) {
            Fragment fragment = (Fragment) this.f502g.get(i);
            if (fragment != null && fragment.m1164c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean m861b(MenuItem menuItem) {
        if (this.f502g == null) {
            return false;
        }
        for (int i = 0; i < this.f502g.size(); i++) {
            Fragment fragment = (Fragment) this.f502g.get(i);
            if (fragment != null && fragment.m1168d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void m859b(Menu menu) {
        if (this.f502g != null) {
            for (int i = 0; i < this.f502g.size(); i++) {
                Fragment fragment = (Fragment) this.f502g.get(i);
                if (fragment != null) {
                    fragment.m1167d(menu);
                }
            }
        }
    }

    public static int m827c(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    public static int m825b(int i, boolean z) {
        switch (i) {
            case 4097:
                return z ? 1 : 2;
            case 4099:
                return z ? 5 : 6;
            case 8194:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }

    public View m834a(View view, String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String string;
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, am.f532a);
        if (attributeValue == null) {
            string = obtainStyledAttributes.getString(0);
        } else {
            string = attributeValue;
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string2 = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!Fragment.m1125b(this.f510o.m801g(), string)) {
            return null;
        }
        int id;
        if (view != null) {
            id = view.getId();
        } else {
            id = 0;
        }
        if (id == -1 && resourceId == -1 && string2 == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
        }
        Fragment fragment;
        Fragment a = resourceId != -1 ? m831a(resourceId) : null;
        if (a == null && string2 != null) {
            a = m833a(string2);
        }
        if (a == null && id != -1) {
            a = m831a(id);
        }
        if (f495a) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + string + " existing=" + a);
        }
        if (a == null) {
            Fragment a2 = Fragment.m1123a(context, string);
            a2.f741x = true;
            a2.f707F = resourceId != 0 ? resourceId : id;
            a2.f708G = id;
            a2.f709H = string2;
            a2.f742y = true;
            a2.f703B = this;
            a2.f704C = this.f510o;
            a2.m1145a(this.f510o.m801g(), attributeSet, a2.f731n);
            m847a(a2, true);
            fragment = a2;
        } else if (a.f742y) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
        } else {
            a.f742y = true;
            a.f704C = this.f510o;
            if (!a.f713L) {
                a.m1145a(this.f510o.m801g(), attributeSet, a.f731n);
            }
            fragment = a;
        }
        if (this.f509n >= 1 || !fragment.f741x) {
            m857b(fragment);
        } else {
            m846a(fragment, 1, 0, 0, false);
        }
        if (fragment.f719R == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            fragment.f719R.setId(resourceId);
        }
        if (fragment.f719R.getTag() == null) {
            fragment.f719R.setTag(string2);
        }
        return fragment.f719R;
    }

    al m888v() {
        return this;
    }
}
