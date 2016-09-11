package android.support.v4.p002h.p015a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v7.p018b.R;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* renamed from: android.support.v4.h.a.g */
public class AccessibilityNodeInfoCompat {
    private static final AccessibilityNodeInfoCompat f896a;
    private final Object f897b;

    static {
        if (VERSION.SDK_INT >= 22) {
            f896a = new AccessibilityNodeInfoCompat();
        } else if (VERSION.SDK_INT >= 21) {
            f896a = new AccessibilityNodeInfoCompat();
        } else if (VERSION.SDK_INT >= 19) {
            f896a = new AccessibilityNodeInfoCompat();
        } else if (VERSION.SDK_INT >= 18) {
            f896a = new AccessibilityNodeInfoCompat();
        } else if (VERSION.SDK_INT >= 17) {
            f896a = new AccessibilityNodeInfoCompat();
        } else if (VERSION.SDK_INT >= 16) {
            f896a = new AccessibilityNodeInfoCompat();
        } else if (VERSION.SDK_INT >= 14) {
            f896a = new AccessibilityNodeInfoCompat();
        } else {
            f896a = new AccessibilityNodeInfoCompat();
        }
    }

    public AccessibilityNodeInfoCompat(Object obj) {
        this.f897b = obj;
    }

    public Object m1615a() {
        return this.f897b;
    }

    public int m1621b() {
        return f896a.m1639a(this.f897b);
    }

    public void m1616a(int i) {
        f896a.m1642a(this.f897b, i);
    }

    public void m1617a(Rect rect) {
        f896a.m1643a(this.f897b, rect);
    }

    public void m1622b(Rect rect) {
        f896a.m1648b(this.f897b, rect);
    }

    public boolean m1624c() {
        return f896a.m1653f(this.f897b);
    }

    public boolean m1625d() {
        return f896a.m1654g(this.f897b);
    }

    public boolean m1626e() {
        return f896a.m1657j(this.f897b);
    }

    public boolean m1627f() {
        return f896a.m1658k(this.f897b);
    }

    public boolean m1628g() {
        return f896a.m1662o(this.f897b);
    }

    public boolean m1629h() {
        return f896a.m1655h(this.f897b);
    }

    public boolean m1630i() {
        return f896a.m1659l(this.f897b);
    }

    public boolean m1631j() {
        return f896a.m1656i(this.f897b);
    }

    public boolean m1632k() {
        return f896a.m1660m(this.f897b);
    }

    public boolean m1633l() {
        return f896a.m1661n(this.f897b);
    }

    public void m1620a(boolean z) {
        f896a.m1646a(this.f897b, z);
    }

    public CharSequence m1634m() {
        return f896a.m1651d(this.f897b);
    }

    public CharSequence m1635n() {
        return f896a.m1647b(this.f897b);
    }

    public void m1618a(CharSequence charSequence) {
        f896a.m1644a(this.f897b, charSequence);
    }

    public CharSequence m1636o() {
        return f896a.m1652e(this.f897b);
    }

    public CharSequence m1637p() {
        return f896a.m1650c(this.f897b);
    }

    public String m1638q() {
        return f896a.m1663p(this.f897b);
    }

    public void m1619a(Object obj) {
        f896a.m1645a(this.f897b, ((AccessibilityNodeInfoCompat) obj).f898a);
    }

    public void m1623b(Object obj) {
        f896a.m1649b(this.f897b, ((AccessibilityNodeInfoCompat) obj).f899a);
    }

    public int hashCode() {
        return this.f897b == null ? 0 : this.f897b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) obj;
        if (this.f897b == null) {
            if (accessibilityNodeInfoCompat.f897b != null) {
                return false;
            }
            return true;
        } else if (this.f897b.equals(accessibilityNodeInfoCompat.f897b)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        m1617a(rect);
        stringBuilder.append("; boundsInParent: " + rect);
        m1622b(rect);
        stringBuilder.append("; boundsInScreen: " + rect);
        stringBuilder.append("; packageName: ").append(m1634m());
        stringBuilder.append("; className: ").append(m1635n());
        stringBuilder.append("; text: ").append(m1636o());
        stringBuilder.append("; contentDescription: ").append(m1637p());
        stringBuilder.append("; viewId: ").append(m1638q());
        stringBuilder.append("; checkable: ").append(m1624c());
        stringBuilder.append("; checked: ").append(m1625d());
        stringBuilder.append("; focusable: ").append(m1626e());
        stringBuilder.append("; focused: ").append(m1627f());
        stringBuilder.append("; selected: ").append(m1628g());
        stringBuilder.append("; clickable: ").append(m1629h());
        stringBuilder.append("; longClickable: ").append(m1630i());
        stringBuilder.append("; enabled: ").append(m1631j());
        stringBuilder.append("; password: ").append(m1632k());
        stringBuilder.append("; scrollable: " + m1633l());
        stringBuilder.append("; [");
        int b = m1621b();
        while (b != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(b);
            b &= numberOfTrailingZeros ^ -1;
            stringBuilder.append(AccessibilityNodeInfoCompat.m1613b(numberOfTrailingZeros));
            if (b != 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static String m1613b(int i) {
        switch (i) {
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                return "ACTION_FOCUS";
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                return "ACTION_CLEAR_FOCUS";
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                return "ACTION_SELECT";
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                return "ACTION_CLEAR_SELECTION";
            case C0001R.styleable.MapAttrs_ambientEnabled /*16*/:
                return "ACTION_CLICK";
            case R.AppCompatTheme_actionModeCutDrawable /*32*/:
                return "ACTION_LONG_CLICK";
            case R.AppCompatTheme_imageButtonStyle /*64*/:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }
}
