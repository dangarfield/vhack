package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p002h.p015a.AccessibilityEventCompat;
import android.support.v4.p002h.p015a.AccessibilityNodeInfoCompat;
import android.support.v4.p002h.p015a.aj;
import android.support.v7.p018b.R;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends ei {
    private final Runnable f1772A;
    dp f1773a;
    dp f1774b;
    boolean f1775c;
    int f1776d;
    int f1777e;
    LazySpanLookup f1778f;
    private int f1779g;
    private ft[] f1780h;
    private int f1781i;
    private int f1782j;
    private cr f1783k;
    private boolean f1784l;
    private BitSet f1785m;
    private int f1786n;
    private boolean f1787o;
    private boolean f1788t;
    private SavedState f1789u;
    private int f1790v;
    private final Rect f1791w;
    private final fp f1792x;
    private boolean f1793y;
    private boolean f1794z;

    class LazySpanLookup {
        int[] f1760a;
        List f1761b;

        class FullSpanItem implements Parcelable {
            public static final Creator CREATOR;
            int f1756a;
            int f1757b;
            int[] f1758c;
            boolean f1759d;

            public FullSpanItem(Parcel parcel) {
                boolean z = true;
                this.f1756a = parcel.readInt();
                this.f1757b = parcel.readInt();
                if (parcel.readInt() != 1) {
                    z = false;
                }
                this.f1759d = z;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.f1758c = new int[readInt];
                    parcel.readIntArray(this.f1758c);
                }
            }

            int m3744a(int i) {
                return this.f1758c == null ? 0 : this.f1758c[i];
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f1756a);
                parcel.writeInt(this.f1757b);
                parcel.writeInt(this.f1759d ? 1 : 0);
                if (this.f1758c == null || this.f1758c.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(this.f1758c.length);
                parcel.writeIntArray(this.f1758c);
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f1756a + ", mGapDir=" + this.f1757b + ", mHasUnwantedGapAfter=" + this.f1759d + ", mGapPerSpan=" + Arrays.toString(this.f1758c) + '}';
            }

            static {
                CREATOR = new fr();
            }
        }

        LazySpanLookup() {
        }

        int m3748a(int i) {
            if (this.f1761b != null) {
                for (int size = this.f1761b.size() - 1; size >= 0; size--) {
                    if (((FullSpanItem) this.f1761b.get(size)).f1756a >= i) {
                        this.f1761b.remove(size);
                    }
                }
            }
            return m3754b(i);
        }

        int m3754b(int i) {
            if (this.f1760a == null || i >= this.f1760a.length) {
                return -1;
            }
            int g = m3747g(i);
            if (g == -1) {
                Arrays.fill(this.f1760a, i, this.f1760a.length, -1);
                return this.f1760a.length;
            }
            Arrays.fill(this.f1760a, i, g + 1, -1);
            return g + 1;
        }

        int m3756c(int i) {
            if (this.f1760a == null || i >= this.f1760a.length) {
                return -1;
            }
            return this.f1760a[i];
        }

        void m3752a(int i, ft ftVar) {
            m3758e(i);
            this.f1760a[i] = ftVar.f2258d;
        }

        int m3757d(int i) {
            int length = this.f1760a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        void m3758e(int i) {
            if (this.f1760a == null) {
                this.f1760a = new int[(Math.max(i, 10) + 1)];
                Arrays.fill(this.f1760a, -1);
            } else if (i >= this.f1760a.length) {
                Object obj = this.f1760a;
                this.f1760a = new int[m3757d(i)];
                System.arraycopy(obj, 0, this.f1760a, 0, obj.length);
                Arrays.fill(this.f1760a, obj.length, this.f1760a.length, -1);
            }
        }

        void m3750a() {
            if (this.f1760a != null) {
                Arrays.fill(this.f1760a, -1);
            }
            this.f1761b = null;
        }

        void m3751a(int i, int i2) {
            if (this.f1760a != null && i < this.f1760a.length) {
                m3758e(i + i2);
                System.arraycopy(this.f1760a, i + i2, this.f1760a, i, (this.f1760a.length - i) - i2);
                Arrays.fill(this.f1760a, this.f1760a.length - i2, this.f1760a.length, -1);
                m3745c(i, i2);
            }
        }

        private void m3745c(int i, int i2) {
            if (this.f1761b != null) {
                int i3 = i + i2;
                for (int size = this.f1761b.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = (FullSpanItem) this.f1761b.get(size);
                    if (fullSpanItem.f1756a >= i) {
                        if (fullSpanItem.f1756a < i3) {
                            this.f1761b.remove(size);
                        } else {
                            fullSpanItem.f1756a -= i2;
                        }
                    }
                }
            }
        }

        void m3755b(int i, int i2) {
            if (this.f1760a != null && i < this.f1760a.length) {
                m3758e(i + i2);
                System.arraycopy(this.f1760a, i, this.f1760a, i + i2, (this.f1760a.length - i) - i2);
                Arrays.fill(this.f1760a, i, i + i2, -1);
                m3746d(i, i2);
            }
        }

        private void m3746d(int i, int i2) {
            if (this.f1761b != null) {
                for (int size = this.f1761b.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = (FullSpanItem) this.f1761b.get(size);
                    if (fullSpanItem.f1756a >= i) {
                        fullSpanItem.f1756a += i2;
                    }
                }
            }
        }

        private int m3747g(int i) {
            if (this.f1761b == null) {
                return -1;
            }
            FullSpanItem f = m3759f(i);
            if (f != null) {
                this.f1761b.remove(f);
            }
            int size = this.f1761b.size();
            int i2 = 0;
            while (i2 < size) {
                if (((FullSpanItem) this.f1761b.get(i2)).f1756a >= i) {
                    break;
                }
                i2++;
            }
            i2 = -1;
            if (i2 == -1) {
                return -1;
            }
            f = (FullSpanItem) this.f1761b.get(i2);
            this.f1761b.remove(i2);
            return f.f1756a;
        }

        public void m3753a(FullSpanItem fullSpanItem) {
            if (this.f1761b == null) {
                this.f1761b = new ArrayList();
            }
            int size = this.f1761b.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = (FullSpanItem) this.f1761b.get(i);
                if (fullSpanItem2.f1756a == fullSpanItem.f1756a) {
                    this.f1761b.remove(i);
                }
                if (fullSpanItem2.f1756a >= fullSpanItem.f1756a) {
                    this.f1761b.add(i, fullSpanItem);
                    return;
                }
            }
            this.f1761b.add(fullSpanItem);
        }

        public FullSpanItem m3759f(int i) {
            if (this.f1761b == null) {
                return null;
            }
            for (int size = this.f1761b.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f1761b.get(size);
                if (fullSpanItem.f1756a == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem m3749a(int i, int i2, int i3, boolean z) {
            if (this.f1761b == null) {
                return null;
            }
            int size = this.f1761b.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f1761b.get(i4);
                if (fullSpanItem.f1756a >= i2) {
                    return null;
                }
                if (fullSpanItem.f1756a >= i) {
                    if (i3 == 0 || fullSpanItem.f1757b == i3) {
                        return fullSpanItem;
                    }
                    if (z && fullSpanItem.f1759d) {
                        return fullSpanItem;
                    }
                }
            }
            return null;
        }
    }

    public class SavedState implements Parcelable {
        public static final Creator CREATOR;
        int f1762a;
        int f1763b;
        int f1764c;
        int[] f1765d;
        int f1766e;
        int[] f1767f;
        List f1768g;
        boolean f1769h;
        boolean f1770i;
        boolean f1771j;

        SavedState(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            this.f1762a = parcel.readInt();
            this.f1763b = parcel.readInt();
            this.f1764c = parcel.readInt();
            if (this.f1764c > 0) {
                this.f1765d = new int[this.f1764c];
                parcel.readIntArray(this.f1765d);
            }
            this.f1766e = parcel.readInt();
            if (this.f1766e > 0) {
                this.f1767f = new int[this.f1766e];
                parcel.readIntArray(this.f1767f);
            }
            this.f1769h = parcel.readInt() == 1;
            if (parcel.readInt() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.f1770i = z;
            if (parcel.readInt() != 1) {
                z2 = false;
            }
            this.f1771j = z2;
            this.f1768g = parcel.readArrayList(FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f1764c = savedState.f1764c;
            this.f1762a = savedState.f1762a;
            this.f1763b = savedState.f1763b;
            this.f1765d = savedState.f1765d;
            this.f1766e = savedState.f1766e;
            this.f1767f = savedState.f1767f;
            this.f1769h = savedState.f1769h;
            this.f1770i = savedState.f1770i;
            this.f1771j = savedState.f1771j;
            this.f1768g = savedState.f1768g;
        }

        void m3760a() {
            this.f1765d = null;
            this.f1764c = 0;
            this.f1766e = 0;
            this.f1767f = null;
            this.f1768g = null;
        }

        void m3761b() {
            this.f1765d = null;
            this.f1764c = 0;
            this.f1762a = -1;
            this.f1763b = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            int i3 = 1;
            parcel.writeInt(this.f1762a);
            parcel.writeInt(this.f1763b);
            parcel.writeInt(this.f1764c);
            if (this.f1764c > 0) {
                parcel.writeIntArray(this.f1765d);
            }
            parcel.writeInt(this.f1766e);
            if (this.f1766e > 0) {
                parcel.writeIntArray(this.f1767f);
            }
            if (this.f1769h) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (this.f1770i) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (!this.f1771j) {
                i3 = 0;
            }
            parcel.writeInt(i3);
            parcel.writeList(this.f1768g);
        }

        static {
            CREATOR = new fs();
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        boolean z = true;
        this.f1779g = -1;
        this.f1784l = false;
        this.f1775c = false;
        this.f1776d = -1;
        this.f1777e = Integer.MIN_VALUE;
        this.f1778f = new LazySpanLookup();
        this.f1786n = 2;
        this.f1791w = new Rect();
        this.f1792x = new fp();
        this.f1793y = false;
        this.f1794z = true;
        this.f1772A = new fo(this);
        ej a = ei.m3481a(context, attributeSet, i, i2);
        m3832b(a.f2145a);
        m3814a(a.f2146b);
        m3826a(a.f2147c);
        if (this.f1786n == 0) {
            z = false;
        }
        m3563c(z);
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        boolean z = true;
        this.f1779g = -1;
        this.f1784l = false;
        this.f1775c = false;
        this.f1776d = -1;
        this.f1777e = Integer.MIN_VALUE;
        this.f1778f = new LazySpanLookup();
        this.f1786n = 2;
        this.f1791w = new Rect();
        this.f1792x = new fp();
        this.f1793y = false;
        this.f1794z = true;
        this.f1772A = new fo(this);
        this.f1781i = i2;
        m3814a(i);
        if (this.f1786n == 0) {
            z = false;
        }
        m3563c(z);
    }

    private boolean m3762H() {
        if (m3603s() == 0 || this.f1786n == 0 || !m3597n()) {
            return false;
        }
        int L;
        int M;
        if (this.f1775c) {
            L = m3766L();
            M = m3767M();
        } else {
            L = m3767M();
            M = m3766L();
        }
        if (L == 0 && m3847f() != null) {
            this.f1778f.m3750a();
            m3496F();
            m3595m();
            return true;
        } else if (!this.f1793y) {
            return false;
        } else {
            int i = this.f1775c ? -1 : 1;
            FullSpanItem a = this.f1778f.m3749a(L, M + 1, i, true);
            if (a == null) {
                this.f1793y = false;
                this.f1778f.m3748a(M + 1);
                return false;
            }
            FullSpanItem a2 = this.f1778f.m3749a(L, a.f1756a, i * -1, true);
            if (a2 == null) {
                this.f1778f.m3748a(a.f1756a);
            } else {
                this.f1778f.m3748a(a2.f1756a + 1);
            }
            m3496F();
            m3595m();
            return true;
        }
    }

    public void m3854k(int i) {
        if (i == 0) {
            m3762H();
        }
    }

    public void m3821a(RecyclerView recyclerView, ep epVar) {
        m3540a(this.f1772A);
        for (int i = 0; i < this.f1779g; i++) {
            this.f1780h[i].m4606e();
        }
    }

    View m3847f() {
        int i;
        int i2;
        int s = m3603s() - 1;
        BitSet bitSet = new BitSet(this.f1779g);
        bitSet.set(0, this.f1779g, true);
        boolean z = (this.f1781i == 1 && m3850h()) ? true : true;
        if (this.f1775c) {
            i = -1;
        } else {
            i = s + 1;
            s = 0;
        }
        if (s < i) {
            i2 = 1;
        } else {
            i2 = -1;
        }
        int i3 = s;
        while (i3 != i) {
            View h = m3585h(i3);
            fq fqVar = (fq) h.getLayoutParams();
            if (bitSet.get(fqVar.f2253e.f2258d)) {
                if (m3781a(fqVar.f2253e)) {
                    return h;
                }
                bitSet.clear(fqVar.f2253e.f2258d);
            }
            if (!(fqVar.f2254f || i3 + i2 == i)) {
                boolean z2;
                View h2 = m3585h(i3 + i2);
                int b;
                if (this.f1775c) {
                    s = this.f1773a.m4304b(h);
                    b = this.f1773a.m4304b(h2);
                    if (s < b) {
                        return h;
                    }
                    if (s == b) {
                        z2 = true;
                    }
                    z2 = false;
                } else {
                    s = this.f1773a.m4300a(h);
                    b = this.f1773a.m4300a(h2);
                    if (s > b) {
                        return h;
                    }
                    if (s == b) {
                        z2 = true;
                    }
                    z2 = false;
                }
                if (z2) {
                    if (fqVar.f2253e.f2258d - ((fq) h2.getLayoutParams()).f2253e.f2258d < 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2 != (z >= false)) {
                        return h;
                    }
                } else {
                    continue;
                }
            }
            i3 += i2;
        }
        return null;
    }

    private boolean m3781a(ft ftVar) {
        boolean z = true;
        if (this.f1775c) {
            if (ftVar.m4604d() < this.f1773a.m4307d()) {
                return !ftVar.m4601c((View) ftVar.f2260f.get(ftVar.f2260f.size() + -1)).f2254f;
            }
        } else if (ftVar.m4598b() > this.f1773a.m4305c()) {
            if (ftVar.m4601c((View) ftVar.f2260f.get(0)).f2254f) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void m3814a(int i) {
        m3825a(null);
        if (i != this.f1779g) {
            m3849g();
            this.f1779g = i;
            this.f1785m = new BitSet(this.f1779g);
            this.f1780h = new ft[this.f1779g];
            for (int i2 = 0; i2 < this.f1779g; i2++) {
                this.f1780h[i2] = new ft(i2, null);
            }
            m3595m();
        }
    }

    public void m3832b(int i) {
        if (i == 0 || i == 1) {
            m3825a(null);
            if (i != this.f1781i) {
                this.f1781i = i;
                if (!(this.f1773a == null || this.f1774b == null)) {
                    dp dpVar = this.f1773a;
                    this.f1773a = this.f1774b;
                    this.f1774b = dpVar;
                }
                m3595m();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void m3826a(boolean z) {
        m3825a(null);
        if (!(this.f1789u == null || this.f1789u.f1769h == z)) {
            this.f1789u.f1769h = z;
        }
        this.f1784l = z;
        m3595m();
    }

    public void m3825a(String str) {
        if (this.f1789u == null) {
            super.m3529a(str);
        }
    }

    public void m3849g() {
        this.f1778f.m3750a();
        m3595m();
    }

    private void m3763I() {
        if (this.f1773a == null) {
            this.f1773a = dp.m4298a(this, this.f1781i);
            this.f1774b = dp.m4298a(this, 1 - this.f1781i);
            this.f1783k = new cr();
        }
    }

    private void m3764J() {
        boolean z = true;
        if (this.f1781i == 1 || !m3850h()) {
            this.f1775c = this.f1784l;
            return;
        }
        if (this.f1784l) {
            z = false;
        }
        this.f1775c = z;
    }

    boolean m3850h() {
        return m3601q() == 1;
    }

    public void m3815a(Rect rect, int i, int i2) {
        int z = m3610z() + m3608x();
        int y = m3609y() + m3491A();
        if (this.f1781i == 1) {
            y = ei.m3479a(i2, y + rect.height(), m3494D());
            z = ei.m3479a(i, z + (this.f1782j * this.f1779g), m3493C());
        } else {
            z = ei.m3479a(i, z + rect.width(), m3493C());
            y = ei.m3479a(i2, y + (this.f1782j * this.f1779g), m3494D());
        }
        m3569d(z, y);
    }

    public void m3839c(ep epVar, ev evVar) {
        m3774a(epVar, evVar, true);
    }

    private void m3774a(ep epVar, ev evVar, boolean z) {
        m3763I();
        fp fpVar = this.f1792x;
        fpVar.m4583a();
        if (!(this.f1789u == null && this.f1776d == -1) && evVar.m4487e() == 0) {
            m3559c(epVar);
            return;
        }
        boolean z2;
        if (this.f1789u != null) {
            m3775a(fpVar);
        } else {
            m3764J();
            fpVar.f2250c = this.f1775c;
        }
        m3823a(evVar, fpVar);
        if (this.f1789u == null && !(fpVar.f2250c == this.f1787o && m3850h() == this.f1788t)) {
            this.f1778f.m3750a();
            fpVar.f2251d = true;
        }
        if (m3603s() > 0 && (this.f1789u == null || this.f1789u.f1764c < 1)) {
            int i;
            if (fpVar.f2251d) {
                for (i = 0; i < this.f1779g; i++) {
                    this.f1780h[i].m4606e();
                    if (fpVar.f2249b != Integer.MIN_VALUE) {
                        this.f1780h[i].m4603c(fpVar.f2249b);
                    }
                }
            } else {
                for (i = 0; i < this.f1779g; i++) {
                    this.f1780h[i].m4597a(this.f1775c, fpVar.f2249b);
                }
            }
        }
        m3515a(epVar);
        this.f1783k.f2072a = false;
        this.f1793y = false;
        m3844e(this.f1774b.m4310f());
        m3771a(fpVar.f2248a, evVar);
        if (fpVar.f2250c) {
            m3793l(-1);
            m3768a(epVar, this.f1783k, evVar);
            m3793l(1);
            this.f1783k.f2074c = fpVar.f2248a + this.f1783k.f2075d;
            m3768a(epVar, this.f1783k, evVar);
        } else {
            m3793l(1);
            m3768a(epVar, this.f1783k, evVar);
            m3793l(-1);
            this.f1783k.f2074c = fpVar.f2248a + this.f1783k.f2075d;
            m3768a(epVar, this.f1783k, evVar);
        }
        m3765K();
        if (m3603s() > 0) {
            if (this.f1775c) {
                m3784b(epVar, evVar, true);
                m3788c(epVar, evVar, false);
            } else {
                m3788c(epVar, evVar, true);
                m3784b(epVar, evVar, false);
            }
        }
        if (!z || evVar.m4483a()) {
            z2 = false;
        } else {
            if (this.f1786n == 0 || m3603s() <= 0 || (!this.f1793y && m3847f() == null)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                m3540a(this.f1772A);
                if (m3762H()) {
                    z2 = true;
                    this.f1776d = -1;
                    this.f1777e = Integer.MIN_VALUE;
                }
            }
            z2 = false;
            this.f1776d = -1;
            this.f1777e = Integer.MIN_VALUE;
        }
        this.f1787o = fpVar.f2250c;
        this.f1788t = m3850h();
        this.f1789u = null;
        if (z2) {
            m3774a(epVar, evVar, false);
        }
    }

    private void m3765K() {
        if (this.f1774b.m4312h() != 1073741824) {
            float f = 0.0f;
            int s = m3603s();
            int i = 0;
            while (i < s) {
                float f2;
                View h = m3585h(i);
                float c = (float) this.f1774b.m4306c(h);
                if (c < f) {
                    f2 = f;
                } else {
                    if (((fq) h.getLayoutParams()).m4586a()) {
                        f2 = (1.0f * c) / ((float) this.f1779g);
                    } else {
                        f2 = c;
                    }
                    f2 = Math.max(f, f2);
                }
                i++;
                f = f2;
            }
            i = this.f1782j;
            int round = Math.round(((float) this.f1779g) * f);
            if (this.f1774b.m4312h() == Integer.MIN_VALUE) {
                round = Math.min(round, this.f1774b.m4310f());
            }
            m3844e(round);
            if (this.f1782j != i) {
                for (int i2 = 0; i2 < s; i2++) {
                    View h2 = m3585h(i2);
                    fq fqVar = (fq) h2.getLayoutParams();
                    if (!fqVar.f2254f) {
                        if (m3850h() && this.f1781i == 1) {
                            h2.offsetLeftAndRight(((-((this.f1779g - 1) - fqVar.f2253e.f2258d)) * this.f1782j) - ((-((this.f1779g - 1) - fqVar.f2253e.f2258d)) * i));
                        } else {
                            int i3 = fqVar.f2253e.f2258d * this.f1782j;
                            round = fqVar.f2253e.f2258d * i;
                            if (this.f1781i == 1) {
                                h2.offsetLeftAndRight(i3 - round);
                            } else {
                                h2.offsetTopAndBottom(i3 - round);
                            }
                        }
                    }
                }
            }
        }
    }

    private void m3775a(fp fpVar) {
        if (this.f1789u.f1764c > 0) {
            if (this.f1789u.f1764c == this.f1779g) {
                for (int i = 0; i < this.f1779g; i++) {
                    this.f1780h[i].m4606e();
                    int i2 = this.f1789u.f1765d[i];
                    if (i2 != Integer.MIN_VALUE) {
                        if (this.f1789u.f1770i) {
                            i2 += this.f1773a.m4307d();
                        } else {
                            i2 += this.f1773a.m4305c();
                        }
                    }
                    this.f1780h[i].m4603c(i2);
                }
            } else {
                this.f1789u.m3760a();
                this.f1789u.f1762a = this.f1789u.f1763b;
            }
        }
        this.f1788t = this.f1789u.f1771j;
        m3826a(this.f1789u.f1769h);
        m3764J();
        if (this.f1789u.f1762a != -1) {
            this.f1776d = this.f1789u.f1762a;
            fpVar.f2250c = this.f1789u.f1770i;
        } else {
            fpVar.f2250c = this.f1775c;
        }
        if (this.f1789u.f1766e > 1) {
            this.f1778f.f1760a = this.f1789u.f1767f;
            this.f1778f.f1761b = this.f1789u.f1768g;
        }
    }

    void m3823a(ev evVar, fp fpVar) {
        if (!m3835b(evVar, fpVar) && !m3789c(evVar, fpVar)) {
            fpVar.m4585b();
            fpVar.f2248a = 0;
        }
    }

    private boolean m3789c(ev evVar, fp fpVar) {
        fpVar.f2248a = this.f1787o ? m3805v(evVar.m4487e()) : m3804u(evVar.m4487e());
        fpVar.f2249b = Integer.MIN_VALUE;
        return true;
    }

    boolean m3835b(ev evVar, fp fpVar) {
        boolean z = false;
        if (evVar.m4483a() || this.f1776d == -1) {
            return false;
        }
        if (this.f1776d < 0 || this.f1776d >= evVar.m4487e()) {
            this.f1776d = -1;
            this.f1777e = Integer.MIN_VALUE;
            return false;
        } else if (this.f1789u == null || this.f1789u.f1762a == -1 || this.f1789u.f1764c < 1) {
            View c = m3555c(this.f1776d);
            if (c != null) {
                fpVar.f2248a = this.f1775c ? m3766L() : m3767M();
                if (this.f1777e != Integer.MIN_VALUE) {
                    if (fpVar.f2250c) {
                        fpVar.f2249b = (this.f1773a.m4307d() - this.f1777e) - this.f1773a.m4304b(c);
                        return true;
                    }
                    fpVar.f2249b = (this.f1773a.m4305c() + this.f1777e) - this.f1773a.m4300a(c);
                    return true;
                } else if (this.f1773a.m4306c(c) > this.f1773a.m4310f()) {
                    fpVar.f2249b = fpVar.f2250c ? this.f1773a.m4307d() : this.f1773a.m4305c();
                    return true;
                } else {
                    int a = this.f1773a.m4300a(c) - this.f1773a.m4305c();
                    if (a < 0) {
                        fpVar.f2249b = -a;
                        return true;
                    }
                    a = this.f1773a.m4307d() - this.f1773a.m4304b(c);
                    if (a < 0) {
                        fpVar.f2249b = a;
                        return true;
                    }
                    fpVar.f2249b = Integer.MIN_VALUE;
                    return true;
                }
            }
            fpVar.f2248a = this.f1776d;
            if (this.f1777e == Integer.MIN_VALUE) {
                if (m3803t(fpVar.f2248a) == 1) {
                    z = true;
                }
                fpVar.f2250c = z;
                fpVar.m4585b();
            } else {
                fpVar.m4584a(this.f1777e);
            }
            fpVar.f2251d = true;
            return true;
        } else {
            fpVar.f2249b = Integer.MIN_VALUE;
            fpVar.f2248a = this.f1776d;
            return true;
        }
    }

    void m3844e(int i) {
        this.f1782j = i / this.f1779g;
        this.f1790v = MeasureSpec.makeMeasureSpec(i, this.f1774b.m4312h());
    }

    public boolean m3834b() {
        return this.f1789u == null;
    }

    public int m3830b(ev evVar) {
        return m3769a(evVar);
    }

    private int m3769a(ev evVar) {
        boolean z = false;
        if (m3603s() == 0) {
            return 0;
        }
        m3763I();
        dp dpVar = this.f1773a;
        View a = m3813a(!this.f1794z, true);
        if (!this.f1794z) {
            z = true;
        }
        return fc.m4563a(evVar, dpVar, a, m3831b(z, true), this, this.f1794z, this.f1775c);
    }

    public int m3837c(ev evVar) {
        return m3769a(evVar);
    }

    public int m3840d(ev evVar) {
        return m3791h(evVar);
    }

    private int m3791h(ev evVar) {
        boolean z = false;
        if (m3603s() == 0) {
            return 0;
        }
        m3763I();
        dp dpVar = this.f1773a;
        View a = m3813a(!this.f1794z, true);
        if (!this.f1794z) {
            z = true;
        }
        return fc.m4562a(evVar, dpVar, a, m3831b(z, true), this, this.f1794z);
    }

    public int m3843e(ev evVar) {
        return m3791h(evVar);
    }

    public int m3846f(ev evVar) {
        return m3792i(evVar);
    }

    private int m3792i(ev evVar) {
        boolean z = false;
        if (m3603s() == 0) {
            return 0;
        }
        m3763I();
        dp dpVar = this.f1773a;
        View a = m3813a(!this.f1794z, true);
        if (!this.f1794z) {
            z = true;
        }
        return fc.m4564b(evVar, dpVar, a, m3831b(z, true), this, this.f1794z);
    }

    public int m3848g(ev evVar) {
        return m3792i(evVar);
    }

    private void m3779a(View view, fq fqVar, boolean z) {
        if (fqVar.f2254f) {
            if (this.f1781i == 1) {
                m3777a(view, this.f1790v, ei.m3480a(m3607w(), m3605u(), 0, fqVar.height, true), z);
            } else {
                m3777a(view, ei.m3480a(m3606v(), m3604t(), 0, fqVar.width, true), this.f1790v, z);
            }
        } else if (this.f1781i == 1) {
            m3777a(view, ei.m3480a(this.f1782j, m3604t(), 0, fqVar.width, false), ei.m3480a(m3607w(), m3605u(), 0, fqVar.height, true), z);
        } else {
            m3777a(view, ei.m3480a(m3606v(), m3604t(), 0, fqVar.width, true), ei.m3480a(this.f1782j, m3605u(), 0, fqVar.height, false), z);
        }
    }

    private void m3777a(View view, int i, int i2, boolean z) {
        m3525a(view, this.f1791w);
        fq fqVar = (fq) view.getLayoutParams();
        int b = m3782b(i, fqVar.leftMargin + this.f1791w.left, fqVar.rightMargin + this.f1791w.right);
        int b2 = m3782b(i2, fqVar.topMargin + this.f1791w.top, fqVar.bottomMargin + this.f1791w.bottom);
        if (z ? m3538a(view, b, b2, (ek) fqVar) : m3552b(view, b, b2, fqVar)) {
            view.measure(b, b2);
        }
    }

    private int m3782b(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(i) - i2) - i3), mode);
        }
        return i;
    }

    public void m3816a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f1789u = (SavedState) parcelable;
            m3595m();
        }
    }

    public Parcelable m3838c() {
        if (this.f1789u != null) {
            return new SavedState(this.f1789u);
        }
        SavedState savedState = new SavedState();
        savedState.f1769h = this.f1784l;
        savedState.f1770i = this.f1787o;
        savedState.f1771j = this.f1788t;
        if (this.f1778f == null || this.f1778f.f1760a == null) {
            savedState.f1766e = 0;
        } else {
            savedState.f1767f = this.f1778f.f1760a;
            savedState.f1766e = savedState.f1767f.length;
            savedState.f1768g = this.f1778f.f1761b;
        }
        if (m3603s() > 0) {
            m3763I();
            savedState.f1762a = this.f1787o ? m3766L() : m3767M();
            savedState.f1763b = m3851i();
            savedState.f1764c = this.f1779g;
            savedState.f1765d = new int[this.f1779g];
            for (int i = 0; i < this.f1779g; i++) {
                int b;
                if (this.f1787o) {
                    b = this.f1780h[i].m4599b(Integer.MIN_VALUE);
                    if (b != Integer.MIN_VALUE) {
                        b -= this.f1773a.m4307d();
                    }
                } else {
                    b = this.f1780h[i].m4593a(Integer.MIN_VALUE);
                    if (b != Integer.MIN_VALUE) {
                        b -= this.f1773a.m4305c();
                    }
                }
                savedState.f1765d[i] = b;
            }
        } else {
            savedState.f1762a = -1;
            savedState.f1763b = -1;
            savedState.f1764c = 0;
        }
        return savedState;
    }

    public void m3822a(ep epVar, ev evVar, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof fq) {
            fq fqVar = (fq) layoutParams;
            if (this.f1781i == 0) {
                accessibilityNodeInfoCompat.m1623b(AccessibilityNodeInfoCompat.m1717a(fqVar.m4587b(), fqVar.f2254f ? this.f1779g : 1, -1, -1, fqVar.f2254f, false));
                return;
            } else {
                accessibilityNodeInfoCompat.m1623b(AccessibilityNodeInfoCompat.m1717a(-1, -1, fqVar.m4587b(), fqVar.f2254f ? this.f1779g : 1, fqVar.f2254f, false));
                return;
            }
        }
        super.m3526a(view, accessibilityNodeInfoCompat);
    }

    public void m3824a(AccessibilityEvent accessibilityEvent) {
        super.m3528a(accessibilityEvent);
        if (m3603s() > 0) {
            aj a = AccessibilityEventCompat.m1546a(accessibilityEvent);
            View a2 = m3813a(false, true);
            View b = m3831b(false, true);
            if (a2 != null && b != null) {
                int d = m3566d(a2);
                int d2 = m3566d(b);
                if (d < d2) {
                    a.m1567b(d);
                    a.m1568c(d2);
                    return;
                }
                a.m1567b(d2);
                a.m1568c(d);
            }
        }
    }

    int m3851i() {
        View b = this.f1775c ? m3831b(true, true) : m3813a(true, true);
        return b == null ? -1 : m3566d(b);
    }

    public int m3808a(ep epVar, ev evVar) {
        if (this.f1781i == 0) {
            return this.f1779g;
        }
        return super.m3499a(epVar, evVar);
    }

    public int m3829b(ep epVar, ev evVar) {
        if (this.f1781i == 1) {
            return this.f1779g;
        }
        return super.m3542b(epVar, evVar);
    }

    View m3813a(boolean z, boolean z2) {
        m3763I();
        int c = this.f1773a.m4305c();
        int d = this.f1773a.m4307d();
        int s = m3603s();
        View view = null;
        for (int i = 0; i < s; i++) {
            View h = m3585h(i);
            int a = this.f1773a.m4300a(h);
            if (this.f1773a.m4304b(h) > c && a < d) {
                if (a >= c || !z) {
                    return h;
                }
                if (z2 && view == null) {
                    view = h;
                }
            }
        }
        return view;
    }

    View m3831b(boolean z, boolean z2) {
        m3763I();
        int c = this.f1773a.m4305c();
        int d = this.f1773a.m4307d();
        View view = null;
        for (int s = m3603s() - 1; s >= 0; s--) {
            View h = m3585h(s);
            int a = this.f1773a.m4300a(h);
            int b = this.f1773a.m4304b(h);
            if (b > c && a < d) {
                if (b <= d || !z) {
                    return h;
                }
                if (z2 && view == null) {
                    view = h;
                }
            }
        }
        return view;
    }

    private void m3784b(ep epVar, ev evVar, boolean z) {
        int q = m3799q(Integer.MIN_VALUE);
        if (q != Integer.MIN_VALUE) {
            q = this.f1773a.m4307d() - q;
            if (q > 0) {
                q -= -m3836c(-q, epVar, evVar);
                if (z && q > 0) {
                    this.f1773a.m4302a(q);
                }
            }
        }
    }

    private void m3788c(ep epVar, ev evVar, boolean z) {
        int p = m3797p(Integer.MAX_VALUE);
        if (p != Integer.MAX_VALUE) {
            p -= this.f1773a.m4305c();
            if (p > 0) {
                p -= m3836c(p, epVar, evVar);
                if (z && p > 0) {
                    this.f1773a.m4302a(-p);
                }
            }
        }
    }

    private void m3771a(int i, ev evVar) {
        int c;
        int i2;
        cr crVar;
        boolean z = false;
        this.f1783k.f2073b = 0;
        this.f1783k.f2074c = i;
        if (m3600p()) {
            c = evVar.m4485c();
            if (c != -1) {
                if (this.f1775c == (c < i)) {
                    c = this.f1773a.m4310f();
                    i2 = 0;
                } else {
                    i2 = this.f1773a.m4310f();
                    c = 0;
                }
                if (m3599o()) {
                    this.f1783k.f2078g = c + this.f1773a.m4309e();
                    this.f1783k.f2077f = -i2;
                } else {
                    this.f1783k.f2077f = this.f1773a.m4305c() - i2;
                    this.f1783k.f2078g = c + this.f1773a.m4307d();
                }
                this.f1783k.f2079h = false;
                this.f1783k.f2072a = true;
                crVar = this.f1783k;
                if (this.f1773a.m4312h() == 0) {
                    z = true;
                }
                crVar.f2080i = z;
            }
        }
        c = 0;
        i2 = 0;
        if (m3599o()) {
            this.f1783k.f2078g = c + this.f1773a.m4309e();
            this.f1783k.f2077f = -i2;
        } else {
            this.f1783k.f2077f = this.f1773a.m4305c() - i2;
            this.f1783k.f2078g = c + this.f1773a.m4307d();
        }
        this.f1783k.f2079h = false;
        this.f1783k.f2072a = true;
        crVar = this.f1783k;
        if (this.f1773a.m4312h() == 0) {
            z = true;
        }
        crVar.f2080i = z;
    }

    private void m3793l(int i) {
        int i2 = 1;
        this.f1783k.f2076e = i;
        cr crVar = this.f1783k;
        if (this.f1775c != (i == -1)) {
            i2 = -1;
        }
        crVar.f2075d = i2;
    }

    public void m3852i(int i) {
        super.m3587i(i);
        for (int i2 = 0; i2 < this.f1779g; i2++) {
            this.f1780h[i2].m4605d(i);
        }
    }

    public void m3853j(int i) {
        super.m3589j(i);
        for (int i2 = 0; i2 < this.f1779g; i2++) {
            this.f1780h[i2].m4605d(i);
        }
    }

    public void m3833b(RecyclerView recyclerView, int i, int i2) {
        m3787c(i, i2, 2);
    }

    public void m3818a(RecyclerView recyclerView, int i, int i2) {
        m3787c(i, i2, 1);
    }

    public void m3817a(RecyclerView recyclerView) {
        this.f1778f.m3750a();
        m3595m();
    }

    public void m3819a(RecyclerView recyclerView, int i, int i2, int i3) {
        m3787c(i, i2, 8);
    }

    public void m3820a(RecyclerView recyclerView, int i, int i2, Object obj) {
        m3787c(i, i2, 4);
    }

    private void m3787c(int i, int i2, int i3) {
        int i4;
        int i5;
        int L = this.f1775c ? m3766L() : m3767M();
        if (i3 != 8) {
            i4 = i + i2;
            i5 = i;
        } else if (i < i2) {
            i4 = i2 + 1;
            i5 = i;
        } else {
            i4 = i + 1;
            i5 = i2;
        }
        this.f1778f.m3754b(i5);
        switch (i3) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                this.f1778f.m3755b(i, i2);
                break;
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                this.f1778f.m3751a(i, i2);
                break;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                this.f1778f.m3751a(i, 1);
                this.f1778f.m3755b(i2, 1);
                break;
        }
        if (i4 > L) {
            if (i5 <= (this.f1775c ? m3767M() : m3766L())) {
                m3595m();
            }
        }
    }

    private int m3768a(ep epVar, cr crVar, ev evVar) {
        int i;
        int d;
        int q;
        this.f1785m.set(0, this.f1779g, true);
        if (this.f1783k.f2080i) {
            if (crVar.f2076e == 1) {
                i = Integer.MAX_VALUE;
            } else {
                i = Integer.MIN_VALUE;
            }
        } else if (crVar.f2076e == 1) {
            i = crVar.f2078g + crVar.f2073b;
        } else {
            i = crVar.f2077f - crVar.f2073b;
        }
        m3790e(crVar.f2076e, i);
        if (this.f1775c) {
            d = this.f1773a.m4307d();
        } else {
            d = this.f1773a.m4305c();
        }
        Object obj = null;
        while (crVar.m4259a(evVar) && (this.f1783k.f2080i || !this.f1785m.isEmpty())) {
            ft ftVar;
            int c;
            int c2;
            View a = crVar.m4258a(epVar);
            fq fqVar = (fq) a.getLayoutParams();
            int e = fqVar.m4251e();
            int c3 = this.f1778f.m3756c(e);
            Object obj2 = c3 == -1 ? 1 : null;
            if (obj2 != null) {
                ft a2 = fqVar.f2254f ? this.f1780h[0] : m3770a(crVar);
                this.f1778f.m3752a(e, a2);
                ftVar = a2;
            } else {
                ftVar = this.f1780h[c3];
            }
            fqVar.f2253e = ftVar;
            if (crVar.f2076e == 1) {
                m3549b(a);
            } else {
                m3550b(a, 0);
            }
            m3779a(a, fqVar, false);
            if (crVar.f2076e == 1) {
                if (fqVar.f2254f) {
                    q = m3799q(d);
                } else {
                    q = ftVar.m4599b(d);
                }
                c = q + this.f1773a.m4306c(a);
                if (obj2 == null || !fqVar.f2254f) {
                    c3 = q;
                } else {
                    FullSpanItem m = m3794m(q);
                    m.f1757b = -1;
                    m.f1756a = e;
                    this.f1778f.m3753a(m);
                    c3 = q;
                }
            } else {
                if (fqVar.f2254f) {
                    q = m3797p(d);
                } else {
                    q = ftVar.m4593a(d);
                }
                c3 = q - this.f1773a.m4306c(a);
                if (obj2 != null && fqVar.f2254f) {
                    FullSpanItem n = m3795n(q);
                    n.f1757b = 1;
                    n.f1756a = e;
                    this.f1778f.m3753a(n);
                }
                c = q;
            }
            if (fqVar.f2254f && crVar.f2075d == -1) {
                if (obj2 != null) {
                    this.f1793y = true;
                } else {
                    obj = crVar.f2076e == 1 ? !m3855k() ? 1 : null : !m3856l() ? 1 : null;
                    if (obj != null) {
                        FullSpanItem f = this.f1778f.m3759f(e);
                        if (f != null) {
                            f.f1759d = true;
                        }
                        this.f1793y = true;
                    }
                }
            }
            m3778a(a, fqVar, crVar);
            if (m3850h() && this.f1781i == 1) {
                q = fqVar.f2254f ? this.f1774b.m4307d() : this.f1774b.m4307d() - (((this.f1779g - 1) - ftVar.f2258d) * this.f1782j);
                c2 = q - this.f1774b.m4306c(a);
                e = q;
            } else {
                q = fqVar.f2254f ? this.f1774b.m4305c() : (ftVar.f2258d * this.f1782j) + this.f1774b.m4305c();
                e = q + this.f1774b.m4306c(a);
                c2 = q;
            }
            if (this.f1781i == 1) {
                m3785b(a, c2, c3, e, c);
            } else {
                m3785b(a, c3, c2, c, e);
            }
            if (fqVar.f2254f) {
                m3790e(this.f1783k.f2076e, i);
            } else {
                m3776a(ftVar, this.f1783k.f2076e, i);
            }
            m3773a(epVar, this.f1783k);
            if (this.f1783k.f2079h && a.isFocusable()) {
                if (fqVar.f2254f) {
                    this.f1785m.clear();
                } else {
                    this.f1785m.set(ftVar.f2258d, false);
                }
            }
            obj = 1;
        }
        if (obj == null) {
            m3773a(epVar, this.f1783k);
        }
        if (this.f1783k.f2076e == -1) {
            q = this.f1773a.m4305c() - m3797p(this.f1773a.m4305c());
        } else {
            q = m3799q(this.f1773a.m4307d()) - this.f1773a.m4307d();
        }
        return q > 0 ? Math.min(crVar.f2073b, q) : 0;
    }

    private FullSpanItem m3794m(int i) {
        FullSpanItem fullSpanItem = new FullSpanItem();
        fullSpanItem.f1758c = new int[this.f1779g];
        for (int i2 = 0; i2 < this.f1779g; i2++) {
            fullSpanItem.f1758c[i2] = i - this.f1780h[i2].m4599b(i);
        }
        return fullSpanItem;
    }

    private FullSpanItem m3795n(int i) {
        FullSpanItem fullSpanItem = new FullSpanItem();
        fullSpanItem.f1758c = new int[this.f1779g];
        for (int i2 = 0; i2 < this.f1779g; i2++) {
            fullSpanItem.f1758c[i2] = this.f1780h[i2].m4593a(i) - i;
        }
        return fullSpanItem;
    }

    private void m3778a(View view, fq fqVar, cr crVar) {
        if (crVar.f2076e == 1) {
            if (fqVar.f2254f) {
                m3798p(view);
            } else {
                fqVar.f2253e.m4600b(view);
            }
        } else if (fqVar.f2254f) {
            m3800q(view);
        } else {
            fqVar.f2253e.m4596a(view);
        }
    }

    private void m3773a(ep epVar, cr crVar) {
        if (crVar.f2072a && !crVar.f2080i) {
            if (crVar.f2073b == 0) {
                if (crVar.f2076e == -1) {
                    m3783b(epVar, crVar.f2078g);
                } else {
                    m3772a(epVar, crVar.f2077f);
                }
            } else if (crVar.f2076e == -1) {
                r0 = crVar.f2077f - m3796o(crVar.f2077f);
                if (r0 < 0) {
                    r0 = crVar.f2078g;
                } else {
                    r0 = crVar.f2078g - Math.min(r0, crVar.f2073b);
                }
                m3783b(epVar, r0);
            } else {
                r0 = m3801r(crVar.f2078g) - crVar.f2078g;
                if (r0 < 0) {
                    r0 = crVar.f2077f;
                } else {
                    r0 = Math.min(r0, crVar.f2073b) + crVar.f2077f;
                }
                m3772a(epVar, r0);
            }
        }
    }

    private void m3798p(View view) {
        for (int i = this.f1779g - 1; i >= 0; i--) {
            this.f1780h[i].m4600b(view);
        }
    }

    private void m3800q(View view) {
        for (int i = this.f1779g - 1; i >= 0; i--) {
            this.f1780h[i].m4596a(view);
        }
    }

    private void m3785b(View view, int i, int i2, int i3, int i4) {
        fq fqVar = (fq) view.getLayoutParams();
        m3523a(view, i + fqVar.leftMargin, i2 + fqVar.topMargin, i3 - fqVar.rightMargin, i4 - fqVar.bottomMargin);
    }

    private void m3790e(int i, int i2) {
        for (int i3 = 0; i3 < this.f1779g; i3++) {
            if (!this.f1780h[i3].f2260f.isEmpty()) {
                m3776a(this.f1780h[i3], i, i2);
            }
        }
    }

    private void m3776a(ft ftVar, int i, int i2) {
        int i3 = ftVar.m4610i();
        if (i == -1) {
            if (i3 + ftVar.m4598b() <= i2) {
                this.f1785m.set(ftVar.f2258d, false);
            }
        } else if (ftVar.m4604d() - i3 >= i2) {
            this.f1785m.set(ftVar.f2258d, false);
        }
    }

    private int m3796o(int i) {
        int a = this.f1780h[0].m4593a(i);
        for (int i2 = 1; i2 < this.f1779g; i2++) {
            int a2 = this.f1780h[i2].m4593a(i);
            if (a2 > a) {
                a = a2;
            }
        }
        return a;
    }

    private int m3797p(int i) {
        int a = this.f1780h[0].m4593a(i);
        for (int i2 = 1; i2 < this.f1779g; i2++) {
            int a2 = this.f1780h[i2].m4593a(i);
            if (a2 < a) {
                a = a2;
            }
        }
        return a;
    }

    boolean m3855k() {
        int b = this.f1780h[0].m4599b(Integer.MIN_VALUE);
        for (int i = 1; i < this.f1779g; i++) {
            if (this.f1780h[i].m4599b(Integer.MIN_VALUE) != b) {
                return false;
            }
        }
        return true;
    }

    boolean m3856l() {
        int a = this.f1780h[0].m4593a(Integer.MIN_VALUE);
        for (int i = 1; i < this.f1779g; i++) {
            if (this.f1780h[i].m4593a(Integer.MIN_VALUE) != a) {
                return false;
            }
        }
        return true;
    }

    private int m3799q(int i) {
        int b = this.f1780h[0].m4599b(i);
        for (int i2 = 1; i2 < this.f1779g; i2++) {
            int b2 = this.f1780h[i2].m4599b(i);
            if (b2 > b) {
                b = b2;
            }
        }
        return b;
    }

    private int m3801r(int i) {
        int b = this.f1780h[0].m4599b(i);
        for (int i2 = 1; i2 < this.f1779g; i2++) {
            int b2 = this.f1780h[i2].m4599b(i);
            if (b2 < b) {
                b = b2;
            }
        }
        return b;
    }

    private void m3772a(ep epVar, int i) {
        while (m3603s() > 0) {
            View h = m3585h(0);
            if (this.f1773a.m4304b(h) <= i) {
                fq fqVar = (fq) h.getLayoutParams();
                if (fqVar.f2254f) {
                    int i2 = 0;
                    while (i2 < this.f1779g) {
                        if (this.f1780h[i2].f2260f.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.f1779g; i2++) {
                        this.f1780h[i2].m4609h();
                    }
                } else if (fqVar.f2253e.f2260f.size() != 1) {
                    fqVar.f2253e.m4609h();
                } else {
                    return;
                }
                m3527a(h, epVar);
            } else {
                return;
            }
        }
    }

    private void m3783b(ep epVar, int i) {
        int s = m3603s() - 1;
        while (s >= 0) {
            View h = m3585h(s);
            if (this.f1773a.m4300a(h) >= i) {
                fq fqVar = (fq) h.getLayoutParams();
                if (fqVar.f2254f) {
                    int i2 = 0;
                    while (i2 < this.f1779g) {
                        if (this.f1780h[i2].f2260f.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.f1779g; i2++) {
                        this.f1780h[i2].m4608g();
                    }
                } else if (fqVar.f2253e.f2260f.size() != 1) {
                    fqVar.f2253e.m4608g();
                } else {
                    return;
                }
                m3527a(h, epVar);
                s--;
            } else {
                return;
            }
        }
    }

    private boolean m3802s(int i) {
        if (this.f1781i == 0) {
            boolean z;
            if (i == -1) {
                z = true;
            } else {
                z = false;
            }
            if (z != this.f1775c) {
                return true;
            }
            return false;
        }
        if (((i == -1) == this.f1775c) != m3850h()) {
            return false;
        }
        return true;
    }

    private ft m3770a(cr crVar) {
        int i;
        int i2;
        ft ftVar = null;
        int i3 = -1;
        if (m3802s(crVar.f2076e)) {
            i = this.f1779g - 1;
            i2 = -1;
        } else {
            i = 0;
            i2 = this.f1779g;
            i3 = 1;
        }
        int c;
        int i4;
        ft ftVar2;
        int b;
        ft ftVar3;
        if (crVar.f2076e == 1) {
            c = this.f1773a.m4305c();
            i4 = i;
            i = Integer.MAX_VALUE;
            while (i4 != i2) {
                ftVar2 = this.f1780h[i4];
                b = ftVar2.m4599b(c);
                if (b < i) {
                    ftVar3 = ftVar2;
                } else {
                    b = i;
                    ftVar3 = ftVar;
                }
                i4 += i3;
                ftVar = ftVar3;
                i = b;
            }
        } else {
            c = this.f1773a.m4307d();
            i4 = i;
            i = Integer.MIN_VALUE;
            while (i4 != i2) {
                ftVar2 = this.f1780h[i4];
                b = ftVar2.m4593a(c);
                if (b > i) {
                    ftVar3 = ftVar2;
                } else {
                    b = i;
                    ftVar3 = ftVar;
                }
                i4 += i3;
                ftVar = ftVar3;
                i = b;
            }
        }
        return ftVar;
    }

    public boolean m3845e() {
        return this.f1781i == 1;
    }

    public boolean m3842d() {
        return this.f1781i == 0;
    }

    public int m3807a(int i, ep epVar, ev evVar) {
        return m3836c(i, epVar, evVar);
    }

    public int m3828b(int i, ep epVar, ev evVar) {
        return m3836c(i, epVar, evVar);
    }

    private int m3803t(int i) {
        int i2 = -1;
        if (m3603s() != 0) {
            if ((i < m3767M()) == this.f1775c) {
                i2 = 1;
            }
            return i2;
        } else if (this.f1775c) {
            return 1;
        } else {
            return -1;
        }
    }

    public void m3841d(int i) {
        if (!(this.f1789u == null || this.f1789u.f1762a == i)) {
            this.f1789u.m3761b();
        }
        this.f1776d = i;
        this.f1777e = Integer.MIN_VALUE;
        m3595m();
    }

    int m3836c(int i, ep epVar, ev evVar) {
        int L;
        int i2;
        m3763I();
        if (i > 0) {
            L = m3766L();
            i2 = 1;
        } else {
            i2 = -1;
            L = m3767M();
        }
        this.f1783k.f2072a = true;
        m3771a(L, evVar);
        m3793l(i2);
        this.f1783k.f2074c = this.f1783k.f2075d + L;
        int abs = Math.abs(i);
        this.f1783k.f2073b = abs;
        i2 = m3768a(epVar, this.f1783k, evVar);
        if (abs >= i2) {
            i = i < 0 ? -i2 : i2;
        }
        this.f1773a.m4302a(-i);
        this.f1787o = this.f1775c;
        return i;
    }

    private int m3766L() {
        int s = m3603s();
        return s == 0 ? 0 : m3566d(m3585h(s - 1));
    }

    private int m3767M() {
        if (m3603s() == 0) {
            return 0;
        }
        return m3566d(m3585h(0));
    }

    private int m3804u(int i) {
        int s = m3603s();
        for (int i2 = 0; i2 < s; i2++) {
            int d = m3566d(m3585h(i2));
            if (d >= 0 && d < i) {
                return d;
            }
        }
        return 0;
    }

    private int m3805v(int i) {
        for (int s = m3603s() - 1; s >= 0; s--) {
            int d = m3566d(m3585h(s));
            if (d >= 0 && d < i) {
                return d;
            }
        }
        return 0;
    }

    public ek m3809a() {
        if (this.f1781i == 0) {
            return new fq(-2, -1);
        }
        return new fq(-1, -2);
    }

    public ek m3810a(Context context, AttributeSet attributeSet) {
        return new fq(context, attributeSet);
    }

    public ek m3811a(LayoutParams layoutParams) {
        if (layoutParams instanceof MarginLayoutParams) {
            return new fq((MarginLayoutParams) layoutParams);
        }
        return new fq(layoutParams);
    }

    public boolean m3827a(ek ekVar) {
        return ekVar instanceof fq;
    }

    public View m3812a(View view, int i, ep epVar, ev evVar) {
        int i2 = 0;
        if (m3603s() == 0) {
            return null;
        }
        View e = m3573e(view);
        if (e == null) {
            return null;
        }
        m3763I();
        m3764J();
        int w = m3806w(i);
        if (w == Integer.MIN_VALUE) {
            return null;
        }
        int L;
        View a;
        fq fqVar = (fq) e.getLayoutParams();
        boolean z = fqVar.f2254f;
        ft ftVar = fqVar.f2253e;
        if (w == 1) {
            L = m3766L();
        } else {
            L = m3767M();
        }
        m3771a(L, evVar);
        m3793l(w);
        this.f1783k.f2074c = this.f1783k.f2075d + L;
        this.f1783k.f2073b = (int) (0.33333334f * ((float) this.f1773a.m4310f()));
        this.f1783k.f2079h = true;
        this.f1783k.f2072a = false;
        m3768a(epVar, this.f1783k, evVar);
        this.f1787o = this.f1775c;
        if (!z) {
            a = ftVar.m4594a(L, w);
            if (!(a == null || a == e)) {
                return a;
            }
        }
        if (m3802s(w)) {
            for (int i3 = this.f1779g - 1; i3 >= 0; i3--) {
                View a2 = this.f1780h[i3].m4594a(L, w);
                if (a2 != null && a2 != e) {
                    return a2;
                }
            }
        } else {
            while (i2 < this.f1779g) {
                a = this.f1780h[i2].m4594a(L, w);
                if (a != null && a != e) {
                    return a;
                }
                i2++;
            }
        }
        return null;
    }

    private int m3806w(int i) {
        int i2 = 1;
        int i3 = Integer.MIN_VALUE;
        switch (i) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                return -1;
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                return 1;
            case R.Toolbar_maxButtonHeight /*17*/:
                if (this.f1781i != 0) {
                    return Integer.MIN_VALUE;
                }
                return -1;
            case R.AppCompatTheme_actionModeCopyDrawable /*33*/:
                if (this.f1781i != 1) {
                    return Integer.MIN_VALUE;
                }
                return -1;
            case R.AppCompatTheme_textAppearanceSearchResultSubtitle /*66*/:
                if (this.f1781i != 0) {
                    i2 = Integer.MIN_VALUE;
                }
                return i2;
            case 130:
                if (this.f1781i == 1) {
                    i3 = 1;
                }
                return i3;
            default:
                return Integer.MIN_VALUE;
        }
    }
}
