package android.support.v4.app;

import android.os.Build.VERSION;
import android.support.v4.p014g.ArrayMap;
import android.support.v4.p014g.LogWriter;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

/* renamed from: android.support.v4.app.j */
final class BackStackRecord extends ap implements Runnable {
    static final boolean f649a;
    final af f650b;
    BackStackRecord f651c;
    BackStackRecord f652d;
    int f653e;
    int f654f;
    int f655g;
    int f656h;
    int f657i;
    int f658j;
    int f659k;
    boolean f660l;
    boolean f661m;
    String f662n;
    boolean f663o;
    int f664p;
    int f665q;
    CharSequence f666r;
    int f667s;
    CharSequence f668t;
    ArrayList f669u;
    ArrayList f670v;

    static {
        f649a = VERSION.SDK_INT >= 21;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f664p >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f664p);
        }
        if (this.f662n != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f662n);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void m1115a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        m1116a(str, printWriter, true);
    }

    public void m1116a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f662n);
            printWriter.print(" mIndex=");
            printWriter.print(this.f664p);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f663o);
            if (this.f658j != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f658j));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f659k));
            }
            if (!(this.f654f == 0 && this.f655g == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f654f));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f655g));
            }
            if (!(this.f656h == 0 && this.f657i == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f656h));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f657i));
            }
            if (!(this.f665q == 0 && this.f666r == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f665q));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f666r);
            }
            if (!(this.f667s == 0 && this.f668t == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f667s));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f668t);
            }
        }
        if (this.f651c != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str2 = str + "    ";
            int i = 0;
            BackStackRecord backStackRecord = this.f651c;
            while (backStackRecord != null) {
                String str3;
                switch (backStackRecord.f688c) {
                    case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                        str3 = "NULL";
                        break;
                    case ModuleDescriptor.MODULE_VERSION /*1*/:
                        str3 = "ADD";
                        break;
                    case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                        str3 = "REPLACE";
                        break;
                    case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                        str3 = "REMOVE";
                        break;
                    case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                        str3 = "HIDE";
                        break;
                    case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                        str3 = "SHOW";
                        break;
                    case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                        str3 = "DETACH";
                        break;
                    case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                        str3 = "ATTACH";
                        break;
                    default:
                        str3 = "cmd=" + backStackRecord.f688c;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str3);
                printWriter.print(" ");
                printWriter.println(backStackRecord.f689d);
                if (z) {
                    if (!(backStackRecord.f690e == 0 && backStackRecord.f691f == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(backStackRecord.f690e));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(backStackRecord.f691f));
                    }
                    if (!(backStackRecord.f692g == 0 && backStackRecord.f693h == 0)) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(backStackRecord.f692g));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(backStackRecord.f693h));
                    }
                }
                if (backStackRecord.f694i != null && backStackRecord.f694i.size() > 0) {
                    for (int i2 = 0; i2 < backStackRecord.f694i.size(); i2++) {
                        printWriter.print(str2);
                        if (backStackRecord.f694i.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str2);
                            printWriter.print("  #");
                            printWriter.print(i2);
                            printWriter.print(": ");
                        }
                        printWriter.println(backStackRecord.f694i.get(i2));
                    }
                }
                backStackRecord = backStackRecord.f686a;
                i++;
            }
        }
    }

    public BackStackRecord(af afVar) {
        this.f661m = true;
        this.f664p = -1;
        this.f650b = afVar;
    }

    void m1113a(BackStackRecord backStackRecord) {
        if (this.f651c == null) {
            this.f652d = backStackRecord;
            this.f651c = backStackRecord;
        } else {
            backStackRecord.f687b = this.f652d;
            this.f652d.f686a = backStackRecord;
            this.f652d = backStackRecord;
        }
        backStackRecord.f690e = this.f654f;
        backStackRecord.f691f = this.f655g;
        backStackRecord.f692g = this.f656h;
        backStackRecord.f693h = this.f657i;
        this.f653e++;
    }

    public ap m1110a(Fragment fragment, String str) {
        m1087a(0, fragment, str, 1);
        return this;
    }

    private void m1087a(int i, Fragment fragment, String str, int i2) {
        fragment.f703B = this.f650b;
        if (str != null) {
            if (fragment.f709H == null || str.equals(fragment.f709H)) {
                fragment.f709H = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.f709H + " now " + str);
            }
        }
        if (i != 0) {
            if (fragment.f707F == 0 || fragment.f707F == i) {
                fragment.f707F = i;
                fragment.f708G = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.f707F + " now " + i);
            }
        }
        BackStackRecord backStackRecord = new BackStackRecord();
        backStackRecord.f688c = i2;
        backStackRecord.f689d = fragment;
        m1113a(backStackRecord);
    }

    public ap m1109a(Fragment fragment) {
        BackStackRecord backStackRecord = new BackStackRecord();
        backStackRecord.f688c = 3;
        backStackRecord.f689d = fragment;
        m1113a(backStackRecord);
        return this;
    }

    void m1112a(int i) {
        if (this.f660l) {
            if (af.f495a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            for (BackStackRecord backStackRecord = this.f651c; backStackRecord != null; backStackRecord = backStackRecord.f686a) {
                Fragment fragment;
                if (backStackRecord.f689d != null) {
                    fragment = backStackRecord.f689d;
                    fragment.f702A += i;
                    if (af.f495a) {
                        Log.v("FragmentManager", "Bump nesting of " + backStackRecord.f689d + " to " + backStackRecord.f689d.f702A);
                    }
                }
                if (backStackRecord.f694i != null) {
                    for (int size = backStackRecord.f694i.size() - 1; size >= 0; size--) {
                        fragment = (Fragment) backStackRecord.f694i.get(size);
                        fragment.f702A += i;
                        if (af.f495a) {
                            Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.f702A);
                        }
                    }
                }
            }
        }
    }

    public int m1107a() {
        return m1108a(false);
    }

    public int m1117b() {
        return m1108a(true);
    }

    int m1108a(boolean z) {
        if (this.f663o) {
            throw new IllegalStateException("commit already called");
        }
        if (af.f495a) {
            Log.v("FragmentManager", "Commit: " + this);
            m1115a("  ", null, new PrintWriter(new LogWriter("FragmentManager")), null);
        }
        this.f663o = true;
        if (this.f660l) {
            this.f664p = this.f650b.m829a(this);
        } else {
            this.f664p = -1;
        }
        this.f650b.m848a((Runnable) this, z);
        return this.f664p;
    }

    public void run() {
        if (af.f495a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        if (!this.f660l || this.f664p >= 0) {
            BackStackRecord a;
            m1112a(1);
            if (f649a) {
                SparseArray sparseArray = new SparseArray();
                SparseArray sparseArray2 = new SparseArray();
                m1105b(sparseArray, sparseArray2);
                a = m1079a(sparseArray, sparseArray2, false);
            } else {
                a = null;
            }
            int i = a != null ? 0 : this.f659k;
            int i2 = a != null ? 0 : this.f658j;
            BackStackRecord backStackRecord = this.f651c;
            while (backStackRecord != null) {
                int i3 = a != null ? 0 : backStackRecord.f690e;
                int i4 = a != null ? 0 : backStackRecord.f691f;
                Fragment fragment;
                switch (backStackRecord.f688c) {
                    case ModuleDescriptor.MODULE_VERSION /*1*/:
                        fragment = backStackRecord.f689d;
                        fragment.f717P = i3;
                        this.f650b.m847a(fragment, false);
                        break;
                    case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                        Fragment fragment2 = backStackRecord.f689d;
                        int i5 = fragment2.f708G;
                        if (this.f650b.f502g != null) {
                            int size = this.f650b.f502g.size() - 1;
                            while (size >= 0) {
                                fragment = (Fragment) this.f650b.f502g.get(size);
                                if (af.f495a) {
                                    Log.v("FragmentManager", "OP_REPLACE: adding=" + fragment2 + " old=" + fragment);
                                }
                                if (fragment.f708G == i5) {
                                    if (fragment == fragment2) {
                                        fragment = null;
                                        backStackRecord.f689d = null;
                                        size--;
                                        fragment2 = fragment;
                                    } else {
                                        if (backStackRecord.f694i == null) {
                                            backStackRecord.f694i = new ArrayList();
                                        }
                                        backStackRecord.f694i.add(fragment);
                                        fragment.f717P = i4;
                                        if (this.f660l) {
                                            fragment.f702A++;
                                            if (af.f495a) {
                                                Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.f702A);
                                            }
                                        }
                                        this.f650b.m845a(fragment, i2, i);
                                    }
                                }
                                fragment = fragment2;
                                size--;
                                fragment2 = fragment;
                            }
                        }
                        if (fragment2 == null) {
                            break;
                        }
                        fragment2.f717P = i3;
                        this.f650b.m847a(fragment2, false);
                        break;
                    case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                        fragment = backStackRecord.f689d;
                        fragment.f717P = i4;
                        this.f650b.m845a(fragment, i2, i);
                        break;
                    case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                        fragment = backStackRecord.f689d;
                        fragment.f717P = i4;
                        this.f650b.m858b(fragment, i2, i);
                        break;
                    case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                        fragment = backStackRecord.f689d;
                        fragment.f717P = i3;
                        this.f650b.m863c(fragment, i2, i);
                        break;
                    case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                        fragment = backStackRecord.f689d;
                        fragment.f717P = i4;
                        this.f650b.m867d(fragment, i2, i);
                        break;
                    case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                        fragment = backStackRecord.f689d;
                        fragment.f717P = i3;
                        this.f650b.m869e(fragment, i2, i);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + backStackRecord.f688c);
                }
                backStackRecord = backStackRecord.f686a;
            }
            this.f650b.m837a(this.f650b.f509n, i2, i, true);
            if (this.f660l) {
                this.f650b.m856b(this);
                return;
            }
            return;
        }
        throw new IllegalStateException("addToBackStack() called after commit()");
    }

    private static void m1099a(SparseArray sparseArray, SparseArray sparseArray2, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.f708G;
            if (i != 0 && !fragment.m1183m()) {
                if (fragment.m1181k() && fragment.m1184n() != null && sparseArray.get(i) == null) {
                    sparseArray.put(i, fragment);
                }
                if (sparseArray2.get(i) == fragment) {
                    sparseArray2.remove(i);
                }
            }
        }
    }

    private void m1106b(SparseArray sparseArray, SparseArray sparseArray2, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.f708G;
            if (i != 0) {
                if (!fragment.m1181k()) {
                    sparseArray2.put(i, fragment);
                }
                if (sparseArray.get(i) == fragment) {
                    sparseArray.remove(i);
                }
            }
        }
    }

    private void m1105b(SparseArray sparseArray, SparseArray sparseArray2) {
        if (this.f650b.f511p.m749a()) {
            for (BackStackRecord backStackRecord = this.f651c; backStackRecord != null; backStackRecord = backStackRecord.f686a) {
                switch (backStackRecord.f688c) {
                    case ModuleDescriptor.MODULE_VERSION /*1*/:
                        m1106b(sparseArray, sparseArray2, backStackRecord.f689d);
                        break;
                    case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                        Fragment fragment = backStackRecord.f689d;
                        if (this.f650b.f502g != null) {
                            Fragment fragment2 = fragment;
                            for (int i = 0; i < this.f650b.f502g.size(); i++) {
                                Fragment fragment3 = (Fragment) this.f650b.f502g.get(i);
                                if (fragment2 == null || fragment3.f708G == fragment2.f708G) {
                                    if (fragment3 == fragment2) {
                                        fragment2 = null;
                                        sparseArray2.remove(fragment3.f708G);
                                    } else {
                                        BackStackRecord.m1099a(sparseArray, sparseArray2, fragment3);
                                    }
                                }
                            }
                        }
                        m1106b(sparseArray, sparseArray2, backStackRecord.f689d);
                        break;
                    case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                        BackStackRecord.m1099a(sparseArray, sparseArray2, backStackRecord.f689d);
                        break;
                    case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                        BackStackRecord.m1099a(sparseArray, sparseArray2, backStackRecord.f689d);
                        break;
                    case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                        m1106b(sparseArray, sparseArray2, backStackRecord.f689d);
                        break;
                    case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                        BackStackRecord.m1099a(sparseArray, sparseArray2, backStackRecord.f689d);
                        break;
                    case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                        m1106b(sparseArray, sparseArray2, backStackRecord.f689d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void m1114a(SparseArray sparseArray, SparseArray sparseArray2) {
        if (this.f650b.f511p.m749a()) {
            for (BackStackRecord backStackRecord = this.f652d; backStackRecord != null; backStackRecord = backStackRecord.f687b) {
                switch (backStackRecord.f688c) {
                    case ModuleDescriptor.MODULE_VERSION /*1*/:
                        BackStackRecord.m1099a(sparseArray, sparseArray2, backStackRecord.f689d);
                        break;
                    case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                        if (backStackRecord.f694i != null) {
                            for (int size = backStackRecord.f694i.size() - 1; size >= 0; size--) {
                                m1106b(sparseArray, sparseArray2, (Fragment) backStackRecord.f694i.get(size));
                            }
                        }
                        BackStackRecord.m1099a(sparseArray, sparseArray2, backStackRecord.f689d);
                        break;
                    case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                        m1106b(sparseArray, sparseArray2, backStackRecord.f689d);
                        break;
                    case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                        m1106b(sparseArray, sparseArray2, backStackRecord.f689d);
                        break;
                    case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                        BackStackRecord.m1099a(sparseArray, sparseArray2, backStackRecord.f689d);
                        break;
                    case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                        m1106b(sparseArray, sparseArray2, backStackRecord.f689d);
                        break;
                    case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                        BackStackRecord.m1099a(sparseArray, sparseArray2, backStackRecord.f689d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public BackStackRecord m1111a(boolean z, BackStackRecord backStackRecord, SparseArray sparseArray, SparseArray sparseArray2) {
        if (af.f495a) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            m1115a("  ", null, new PrintWriter(new LogWriter("FragmentManager")), null);
        }
        if (f649a) {
            if (backStackRecord == null) {
                if (!(sparseArray.size() == 0 && sparseArray2.size() == 0)) {
                    backStackRecord = m1079a(sparseArray, sparseArray2, true);
                }
            } else if (!z) {
                BackStackRecord.m1095a(backStackRecord, this.f670v, this.f669u);
            }
        }
        m1112a(-1);
        int i = backStackRecord != null ? 0 : this.f659k;
        int i2 = backStackRecord != null ? 0 : this.f658j;
        BackStackRecord backStackRecord2 = this.f652d;
        while (backStackRecord2 != null) {
            int i3 = backStackRecord != null ? 0 : backStackRecord2.f692g;
            int i4 = backStackRecord != null ? 0 : backStackRecord2.f693h;
            Fragment fragment;
            Fragment fragment2;
            switch (backStackRecord2.f688c) {
                case ModuleDescriptor.MODULE_VERSION /*1*/:
                    fragment = backStackRecord2.f689d;
                    fragment.f717P = i4;
                    this.f650b.m845a(fragment, af.m827c(i2), i);
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                    fragment = backStackRecord2.f689d;
                    if (fragment != null) {
                        fragment.f717P = i4;
                        this.f650b.m845a(fragment, af.m827c(i2), i);
                    }
                    if (backStackRecord2.f694i == null) {
                        break;
                    }
                    for (int i5 = 0; i5 < backStackRecord2.f694i.size(); i5++) {
                        fragment2 = (Fragment) backStackRecord2.f694i.get(i5);
                        fragment2.f717P = i3;
                        this.f650b.m847a(fragment2, false);
                    }
                    break;
                case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    fragment2 = backStackRecord2.f689d;
                    fragment2.f717P = i3;
                    this.f650b.m847a(fragment2, false);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                    fragment2 = backStackRecord2.f689d;
                    fragment2.f717P = i3;
                    this.f650b.m863c(fragment2, af.m827c(i2), i);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    fragment = backStackRecord2.f689d;
                    fragment.f717P = i4;
                    this.f650b.m858b(fragment, af.m827c(i2), i);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    fragment2 = backStackRecord2.f689d;
                    fragment2.f717P = i3;
                    this.f650b.m869e(fragment2, af.m827c(i2), i);
                    break;
                case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    fragment2 = backStackRecord2.f689d;
                    fragment2.f717P = i3;
                    this.f650b.m867d(fragment2, af.m827c(i2), i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + backStackRecord2.f688c);
            }
            backStackRecord2 = backStackRecord2.f687b;
        }
        if (z) {
            this.f650b.m837a(this.f650b.f509n, af.m827c(i2), i, true);
            backStackRecord = null;
        }
        if (this.f664p >= 0) {
            this.f650b.m855b(this.f664p);
            this.f664p = -1;
        }
        return backStackRecord;
    }

    public String m1118c() {
        return this.f662n;
    }

    private BackStackRecord m1079a(SparseArray sparseArray, SparseArray sparseArray2, boolean z) {
        int i = 0;
        m1098a(sparseArray2);
        BackStackRecord backStackRecord = new BackStackRecord(this);
        backStackRecord.f698d = new View(this.f650b.f510o.m801g());
        int i2 = 0;
        int i3 = 0;
        while (i2 < sparseArray.size()) {
            int i4;
            if (m1101a(sparseArray.keyAt(i2), backStackRecord, z, sparseArray, sparseArray2)) {
                i4 = 1;
            } else {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        while (i < sparseArray2.size()) {
            i4 = sparseArray2.keyAt(i);
            if (sparseArray.get(i4) == null && m1101a(i4, backStackRecord, z, sparseArray, sparseArray2)) {
                i3 = 1;
            }
            i++;
        }
        if (i3 == 0) {
            return null;
        }
        return backStackRecord;
    }

    private void m1098a(SparseArray sparseArray) {
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = (Fragment) sparseArray.valueAt(i);
            if (fragment.f728k < 1) {
                this.f650b.m862c(fragment);
                this.f650b.m846a(fragment, 1, 0, 0, false);
            }
        }
    }

    private static Object m1085a(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return aq.m898a(z ? fragment.m1193w() : fragment.m1190t());
    }

    private static Object m1103b(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return aq.m898a(z ? fragment.m1191u() : fragment.m1192v());
    }

    private static Object m1084a(Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return aq.m917b(z ? fragment2.m1195y() : fragment.m1194x());
    }

    private static Object m1086a(Object obj, Fragment fragment, ArrayList arrayList, ArrayMap arrayMap, View view) {
        if (obj != null) {
            return aq.m899a(obj, fragment.m1184n(), arrayList, arrayMap, view);
        }
        return obj;
    }

    private ArrayMap m1081a(BackStackRecord backStackRecord, Fragment fragment, boolean z) {
        ArrayMap arrayMap = new ArrayMap();
        if (this.f669u != null) {
            aq.m912a((Map) arrayMap, fragment.m1184n());
            if (z) {
                arrayMap.m1467a(this.f670v);
            } else {
                arrayMap = BackStackRecord.m1083a(this.f669u, this.f670v, arrayMap);
            }
        }
        if (z) {
            if (fragment.ag != null) {
                fragment.ag.m1062a(this.f670v, arrayMap);
            }
            m1093a(backStackRecord, arrayMap, false);
        } else {
            if (fragment.ah != null) {
                fragment.ah.m1062a(this.f670v, arrayMap);
            }
            m1104b(backStackRecord, arrayMap, false);
        }
        return arrayMap;
    }

    private boolean m1101a(int i, BackStackRecord backStackRecord, boolean z, SparseArray sparseArray, SparseArray sparseArray2) {
        View view = (ViewGroup) this.f650b.f511p.m748a(i);
        if (view == null) {
            return false;
        }
        Object obj;
        ArrayList arrayList;
        Object a;
        View view2;
        aw backStackRecord2;
        ArrayList arrayList2;
        Map arrayMap;
        boolean z2;
        Object a2;
        Fragment fragment = (Fragment) sparseArray2.get(i);
        Fragment fragment2 = (Fragment) sparseArray.get(i);
        Object a3 = BackStackRecord.m1085a(fragment, z);
        Object a4 = BackStackRecord.m1084a(fragment, fragment2, z);
        Object b = BackStackRecord.m1103b(fragment2, z);
        Map map = null;
        ArrayList arrayList3 = new ArrayList();
        if (a4 != null) {
            map = m1081a(backStackRecord, fragment2, z);
            if (map.isEmpty()) {
                map = null;
                obj = null;
                if (a3 != null && obj == null && b == null) {
                    return false;
                }
                arrayList = new ArrayList();
                a = BackStackRecord.m1086a(b, fragment2, arrayList, (ArrayMap) map, backStackRecord.f698d);
                if (!(this.f670v == null || map == null)) {
                    view2 = (View) map.get(this.f670v.get(0));
                    if (view2 != null) {
                        if (a != null) {
                            aq.m905a(a, view2);
                        }
                        if (obj != null) {
                            aq.m905a(obj, view2);
                        }
                    }
                }
                backStackRecord2 = new BackStackRecord(this, fragment);
                arrayList2 = new ArrayList();
                arrayMap = new ArrayMap();
                z2 = true;
                if (fragment != null) {
                    z2 = z ? fragment.m1126A() : fragment.m1196z();
                }
                a2 = aq.m900a(a3, a, obj, z2);
                if (a2 != null) {
                    aq.m908a(a3, obj, view, backStackRecord2, backStackRecord.f698d, backStackRecord.f697c, backStackRecord.f695a, arrayList2, map, arrayMap, arrayList3);
                    m1100a(view, backStackRecord, i, a2);
                    aq.m907a(a2, backStackRecord.f698d, true);
                    m1091a(backStackRecord, i, a2);
                    aq.m904a((ViewGroup) view, a2);
                    aq.m903a(view, backStackRecord.f698d, a3, arrayList2, a, arrayList, obj, arrayList3, a2, backStackRecord.f696b, arrayMap);
                }
                if (a2 == null) {
                    return true;
                }
                return false;
            }
            db dbVar = z ? fragment2.ag : fragment.ag;
            if (dbVar != null) {
                dbVar.m1061a(new ArrayList(map.keySet()), new ArrayList(map.values()), null);
            }
            m1094a(backStackRecord, view, a4, fragment, fragment2, z, arrayList3);
        }
        obj = a4;
        if (a3 != null) {
        }
        arrayList = new ArrayList();
        a = BackStackRecord.m1086a(b, fragment2, arrayList, (ArrayMap) map, backStackRecord.f698d);
        view2 = (View) map.get(this.f670v.get(0));
        if (view2 != null) {
            if (a != null) {
                aq.m905a(a, view2);
            }
            if (obj != null) {
                aq.m905a(obj, view2);
            }
        }
        backStackRecord2 = new BackStackRecord(this, fragment);
        arrayList2 = new ArrayList();
        arrayMap = new ArrayMap();
        z2 = true;
        if (fragment != null) {
            if (z) {
            }
        }
        a2 = aq.m900a(a3, a, obj, z2);
        if (a2 != null) {
            aq.m908a(a3, obj, view, backStackRecord2, backStackRecord.f698d, backStackRecord.f697c, backStackRecord.f695a, arrayList2, map, arrayMap, arrayList3);
            m1100a(view, backStackRecord, i, a2);
            aq.m907a(a2, backStackRecord.f698d, true);
            m1091a(backStackRecord, i, a2);
            aq.m904a((ViewGroup) view, a2);
            aq.m903a(view, backStackRecord.f698d, a3, arrayList2, a, arrayList, obj, arrayList3, a2, backStackRecord.f696b, arrayMap);
        }
        if (a2 == null) {
            return false;
        }
        return true;
    }

    private void m1094a(BackStackRecord backStackRecord, View view, Object obj, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList) {
        view.getViewTreeObserver().addOnPreDrawListener(new BackStackRecord(this, view, obj, arrayList, backStackRecord, z, fragment, fragment2));
    }

    private void m1092a(BackStackRecord backStackRecord, Fragment fragment, Fragment fragment2, boolean z, ArrayMap arrayMap) {
        db dbVar = z ? fragment2.ag : fragment.ag;
        if (dbVar != null) {
            dbVar.m1063b(new ArrayList(arrayMap.keySet()), new ArrayList(arrayMap.values()), null);
        }
    }

    private void m1096a(ArrayMap arrayMap, BackStackRecord backStackRecord) {
        if (this.f670v != null && !arrayMap.isEmpty()) {
            View view = (View) arrayMap.get(this.f670v.get(0));
            if (view != null) {
                backStackRecord.f697c.f554a = view;
            }
        }
    }

    private ArrayMap m1082a(BackStackRecord backStackRecord, boolean z, Fragment fragment) {
        ArrayMap b = m1102b(backStackRecord, fragment, z);
        if (z) {
            if (fragment.ah != null) {
                fragment.ah.m1062a(this.f670v, b);
            }
            m1093a(backStackRecord, b, true);
        } else {
            if (fragment.ag != null) {
                fragment.ag.m1062a(this.f670v, b);
            }
            m1104b(backStackRecord, b, true);
        }
        return b;
    }

    private static ArrayMap m1083a(ArrayList arrayList, ArrayList arrayList2, ArrayMap arrayMap) {
        if (arrayMap.isEmpty()) {
            return arrayMap;
        }
        ArrayMap arrayMap2 = new ArrayMap();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) arrayMap.get(arrayList.get(i));
            if (view != null) {
                arrayMap2.put(arrayList2.get(i), view);
            }
        }
        return arrayMap2;
    }

    private ArrayMap m1102b(BackStackRecord backStackRecord, Fragment fragment, boolean z) {
        ArrayMap arrayMap = new ArrayMap();
        View n = fragment.m1184n();
        if (n == null || this.f669u == null) {
            return arrayMap;
        }
        aq.m912a((Map) arrayMap, n);
        if (z) {
            return BackStackRecord.m1083a(this.f669u, this.f670v, arrayMap);
        }
        arrayMap.m1467a(this.f670v);
        return arrayMap;
    }

    private void m1100a(View view, BackStackRecord backStackRecord, int i, Object obj) {
        view.getViewTreeObserver().addOnPreDrawListener(new BackStackRecord(this, view, backStackRecord, i, obj));
    }

    private void m1091a(BackStackRecord backStackRecord, int i, Object obj) {
        if (this.f650b.f502g != null) {
            for (int i2 = 0; i2 < this.f650b.f502g.size(); i2++) {
                Fragment fragment = (Fragment) this.f650b.f502g.get(i2);
                if (!(fragment.f719R == null || fragment.f718Q == null || fragment.f708G != i)) {
                    if (!fragment.f710I) {
                        aq.m907a(obj, fragment.f719R, false);
                        backStackRecord.f696b.remove(fragment.f719R);
                    } else if (!backStackRecord.f696b.contains(fragment.f719R)) {
                        aq.m907a(obj, fragment.f719R, true);
                        backStackRecord.f696b.add(fragment.f719R);
                    }
                }
            }
        }
    }

    private static void m1097a(ArrayMap arrayMap, String str, String str2) {
        if (str != null && str2 != null) {
            for (int i = 0; i < arrayMap.size(); i++) {
                if (str.equals(arrayMap.m1464c(i))) {
                    arrayMap.m1459a(i, (Object) str2);
                    return;
                }
            }
            arrayMap.put(str, str2);
        }
    }

    private static void m1095a(BackStackRecord backStackRecord, ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                BackStackRecord.m1097a(backStackRecord.f695a, (String) arrayList.get(i), (String) arrayList2.get(i));
            }
        }
    }

    private void m1093a(BackStackRecord backStackRecord, ArrayMap arrayMap, boolean z) {
        int size = this.f670v == null ? 0 : this.f670v.size();
        for (int i = 0; i < size; i++) {
            String str = (String) this.f669u.get(i);
            View view = (View) arrayMap.get((String) this.f670v.get(i));
            if (view != null) {
                String a = aq.m901a(view);
                if (z) {
                    BackStackRecord.m1097a(backStackRecord.f695a, str, a);
                } else {
                    BackStackRecord.m1097a(backStackRecord.f695a, a, str);
                }
            }
        }
    }

    private void m1104b(BackStackRecord backStackRecord, ArrayMap arrayMap, boolean z) {
        int size = arrayMap.size();
        for (int i = 0; i < size; i++) {
            String str = (String) arrayMap.m1463b(i);
            String a = aq.m901a((View) arrayMap.m1464c(i));
            if (z) {
                BackStackRecord.m1097a(backStackRecord.f695a, str, a);
            } else {
                BackStackRecord.m1097a(backStackRecord.f695a, a, str);
            }
        }
    }
}
