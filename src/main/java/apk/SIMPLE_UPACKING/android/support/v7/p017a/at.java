package android.support.v7.p017a;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.p002h.bu;
import android.support.v4.p014g.ArrayMap;
import android.support.v7.p018b.R;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.al;
import android.support.v7.widget.an;
import android.support.v7.widget.ao;
import android.support.v7.widget.ap;
import android.support.v7.widget.ax;
import android.support.v7.widget.ay;
import android.support.v7.widget.ba;
import android.support.v7.widget.bb;
import android.support.v7.widget.bf;
import android.support.v7.widget.bg;
import android.support.v7.widget.bh;
import android.support.v7.widget.bj;
import android.support.v7.widget.bs;
import android.support.v7.widget.fy;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.lang.reflect.Constructor;
import java.util.Map;

/* compiled from: AppCompatViewInflater */
/* renamed from: android.support.v7.a.at */
class at {
    private static final Class[] f1166a;
    private static final int[] f1167b;
    private static final String[] f1168c;
    private static final Map f1169d;
    private final Object[] f1170e;

    at() {
        this.f1170e = new Object[2];
    }

    static {
        f1166a = new Class[]{Context.class, AttributeSet.class};
        f1167b = new int[]{16843375};
        f1168c = new String[]{"android.widget.", "android.view.", "android.webkit."};
        f1169d = new ArrayMap();
    }

    public final View m2906a(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        Context context2;
        View view2;
        if (!z || view == null) {
            context2 = context;
        } else {
            context2 = view.getContext();
        }
        if (z2 || z3) {
            context2 = at.m2902a(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = fy.m4641a(context2);
        }
        View view3 = null;
        Object obj = -1;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    obj = 11;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    obj = 8;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    obj = 10;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    obj = null;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    obj = 5;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    obj = 12;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    obj = 4;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    obj = 7;
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    obj = 1;
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    obj = 9;
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    obj = 6;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    obj = 3;
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                view3 = new bs(context2, attributeSet);
                break;
            case ModuleDescriptor.MODULE_VERSION /*1*/:
                view3 = new ba(context2, attributeSet);
                break;
            case C0001R.styleable.WalletFragmentStyle_buyButtonText /*2*/:
                view3 = new an(context2, attributeSet);
                break;
            case C0001R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                view3 = new ax(context2, attributeSet);
                break;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance /*4*/:
                view3 = new bj(context2, attributeSet);
                break;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                view3 = new ay(context2, attributeSet);
                break;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                view3 = new ao(context2, attributeSet);
                break;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                view3 = new bf(context2, attributeSet);
                break;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground /*8*/:
                view3 = new ap(context2, attributeSet);
                break;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                view3 = new al(context2, attributeSet);
                break;
            case C0001R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                view3 = new bb(context2, attributeSet);
                break;
            case C0001R.styleable.MapAttrs_uiZoomControls /*11*/:
                view3 = new bg(context2, attributeSet);
                break;
            case C0001R.styleable.MapAttrs_uiZoomGestures /*12*/:
                view3 = new bh(context2, attributeSet);
                break;
        }
        if (view3 != null || context == context2) {
            view2 = view3;
        } else {
            view2 = m2903a(context2, str, attributeSet);
        }
        if (view2 != null) {
            m2905a(view2, attributeSet);
        }
        return view2;
    }

    private View m2903a(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.f1170e[0] = context;
            this.f1170e[1] = attributeSet;
            View a;
            if (-1 == str.indexOf(46)) {
                for (String a2 : f1168c) {
                    a = m2904a(context, str, a2);
                    if (a != null) {
                        return a;
                    }
                }
                this.f1170e[0] = null;
                this.f1170e[1] = null;
                return null;
            }
            a = m2904a(context, str, null);
            this.f1170e[0] = null;
            this.f1170e[1] = null;
            return a;
        } catch (Exception e) {
            return null;
        } finally {
            this.f1170e[0] = null;
            this.f1170e[1] = null;
        }
    }

    private void m2905a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (!(context instanceof ContextWrapper)) {
            return;
        }
        if (VERSION.SDK_INT < 15 || bu.m1918D(view)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1167b);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new au(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    private View m2904a(Context context, String str, String str2) {
        Constructor constructor = (Constructor) f1169d.get(str);
        if (constructor == null) {
            try {
                constructor = context.getClassLoader().loadClass(str2 != null ? str2 + str : str).asSubclass(View.class).getConstructor(f1166a);
                f1169d.put(str, constructor);
            } catch (Exception e) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f1170e);
    }

    private static Context m2902a(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        int resourceId;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.View, 0, 0);
        if (z) {
            resourceId = obtainStyledAttributes.getResourceId(R.View_android_theme, 0);
        } else {
            resourceId = 0;
        }
        if (z2 && r0 == 0) {
            resourceId = obtainStyledAttributes.getResourceId(R.View_theme, 0);
            if (resourceId != 0) {
                Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
            }
        }
        int i = resourceId;
        obtainStyledAttributes.recycle();
        if (i == 0) {
            return context;
        }
        if ((context instanceof ContextThemeWrapper) && ((ContextThemeWrapper) context).m3113a() == i) {
            return context;
        }
        return new ContextThemeWrapper(context, i);
    }
}
