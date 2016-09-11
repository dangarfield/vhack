package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.p013f.TextUtilsCompat;
import android.support.v4.widget.ag;
import android.support.v7.p018b.R;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.google.android.gms.C0001R;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.lang.reflect.Method;

/* compiled from: ListPopupWindow */
public class cy {
    private static Method f1952a;
    private static Method f1953c;
    private final dg f1954A;
    private Runnable f1955B;
    private final Handler f1956C;
    private Rect f1957D;
    private boolean f1958E;
    private int f1959F;
    int f1960b;
    private Context f1961d;
    private PopupWindow f1962e;
    private ListAdapter f1963f;
    private dc f1964g;
    private int f1965h;
    private int f1966i;
    private int f1967j;
    private int f1968k;
    private int f1969l;
    private boolean f1970m;
    private int f1971n;
    private boolean f1972o;
    private boolean f1973p;
    private View f1974q;
    private int f1975r;
    private DataSetObserver f1976s;
    private View f1977t;
    private Drawable f1978u;
    private OnItemClickListener f1979v;
    private OnItemSelectedListener f1980w;
    private final dk f1981x;
    private final dj f1982y;
    private final di f1983z;

    static {
        try {
            f1952a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            f1953c = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
        } catch (NoSuchMethodException e2) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
    }

    public cy(Context context) {
        this(context, null, R.listPopupWindowStyle);
    }

    public cy(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public cy(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f1965h = -2;
        this.f1966i = -2;
        this.f1969l = 1002;
        this.f1971n = 0;
        this.f1972o = false;
        this.f1973p = false;
        this.f1960b = Integer.MAX_VALUE;
        this.f1975r = 0;
        this.f1981x = new dk();
        this.f1982y = new dj();
        this.f1983z = new di();
        this.f1954A = new dg();
        this.f1957D = new Rect();
        this.f1961d = context;
        this.f1956C = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.ListPopupWindow, i, i2);
        this.f1967j = obtainStyledAttributes.getDimensionPixelOffset(R.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.f1968k = obtainStyledAttributes.getDimensionPixelOffset(R.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.f1968k != 0) {
            this.f1970m = true;
        }
        obtainStyledAttributes.recycle();
        this.f1962e = new bc(context, attributeSet, i);
        this.f1962e.setInputMethodMode(1);
        this.f1959F = TextUtilsCompat.m1447a(this.f1961d.getResources().getConfiguration().locale);
    }

    public void m4037a(ListAdapter listAdapter) {
        if (this.f1976s == null) {
            this.f1976s = new dh();
        } else if (this.f1963f != null) {
            this.f1963f.unregisterDataSetObserver(this.f1976s);
        }
        this.f1963f = listAdapter;
        if (this.f1963f != null) {
            listAdapter.registerDataSetObserver(this.f1976s);
        }
        if (this.f1964g != null) {
            this.f1964g.setAdapter(this.f1963f);
        }
    }

    public void m4033a(int i) {
        this.f1975r = i;
    }

    public void m4039a(boolean z) {
        this.f1958E = z;
        this.f1962e.setFocusable(z);
    }

    public Drawable m4043d() {
        return this.f1962e.getBackground();
    }

    public void m4034a(Drawable drawable) {
        this.f1962e.setBackgroundDrawable(drawable);
    }

    public View m4045e() {
        return this.f1977t;
    }

    public void m4035a(View view) {
        this.f1977t = view;
    }

    public int m4047f() {
        return this.f1967j;
    }

    public void m4040b(int i) {
        this.f1967j = i;
    }

    public int m4049g() {
        if (this.f1970m) {
            return this.f1968k;
        }
        return 0;
    }

    public void m4042c(int i) {
        this.f1968k = i;
        this.f1970m = true;
    }

    public void m4044d(int i) {
        this.f1971n = i;
    }

    public int m4051h() {
        return this.f1966i;
    }

    public void m4046e(int i) {
        this.f1966i = i;
    }

    public void m4048f(int i) {
        Drawable background = this.f1962e.getBackground();
        if (background != null) {
            background.getPadding(this.f1957D);
            this.f1966i = (this.f1957D.left + this.f1957D.right) + i;
            return;
        }
        m4046e(i);
    }

    public void m4036a(OnItemClickListener onItemClickListener) {
        this.f1979v = onItemClickListener;
    }

    public void m4041c() {
        boolean z = true;
        boolean z2 = false;
        int i = -1;
        int b = m4028b();
        boolean l = m4056l();
        ag.m2497a(this.f1962e, this.f1969l);
        int i2;
        if (this.f1962e.isShowing()) {
            int i3;
            int i4;
            if (this.f1966i == -1) {
                i3 = -1;
            } else if (this.f1966i == -2) {
                i3 = m4045e().getWidth();
            } else {
                i3 = this.f1966i;
            }
            if (this.f1965h == -1) {
                if (!l) {
                    b = -1;
                }
                PopupWindow popupWindow;
                if (l) {
                    popupWindow = this.f1962e;
                    if (this.f1966i == -1) {
                        i2 = -1;
                    } else {
                        i2 = 0;
                    }
                    popupWindow.setWidth(i2);
                    this.f1962e.setHeight(0);
                    i4 = b;
                } else {
                    popupWindow = this.f1962e;
                    if (this.f1966i == -1) {
                        i2 = -1;
                    } else {
                        i2 = 0;
                    }
                    popupWindow.setWidth(i2);
                    this.f1962e.setHeight(-1);
                    i4 = b;
                }
            } else if (this.f1965h == -2) {
                i4 = b;
            } else {
                i4 = this.f1965h;
            }
            PopupWindow popupWindow2 = this.f1962e;
            if (!(this.f1973p || this.f1972o)) {
                z2 = true;
            }
            popupWindow2.setOutsideTouchable(z2);
            popupWindow2 = this.f1962e;
            View e = m4045e();
            b = this.f1967j;
            int i5 = this.f1968k;
            if (i3 < 0) {
                i3 = -1;
            }
            if (i4 >= 0) {
                i = i4;
            }
            popupWindow2.update(e, b, i5, i3, i);
            return;
        }
        if (this.f1966i == -1) {
            i2 = -1;
        } else if (this.f1966i == -2) {
            i2 = m4045e().getWidth();
        } else {
            i2 = this.f1966i;
        }
        if (this.f1965h == -1) {
            b = -1;
        } else if (this.f1965h != -2) {
            b = this.f1965h;
        }
        this.f1962e.setWidth(i2);
        this.f1962e.setHeight(b);
        m4030b(true);
        popupWindow2 = this.f1962e;
        if (this.f1973p || this.f1972o) {
            z = false;
        }
        popupWindow2.setOutsideTouchable(z);
        this.f1962e.setTouchInterceptor(this.f1982y);
        ag.m2498a(this.f1962e, m4045e(), this.f1967j, this.f1968k, this.f1971n);
        this.f1964g.setSelection(-1);
        if (!this.f1958E || this.f1964g.isInTouchMode()) {
            m4054j();
        }
        if (!this.f1958E) {
            this.f1956C.post(this.f1954A);
        }
    }

    public void m4053i() {
        this.f1962e.dismiss();
        m4027a();
        this.f1962e.setContentView(null);
        this.f1964g = null;
        this.f1956C.removeCallbacks(this.f1981x);
    }

    public void m4038a(OnDismissListener onDismissListener) {
        this.f1962e.setOnDismissListener(onDismissListener);
    }

    private void m4027a() {
        if (this.f1974q != null) {
            ViewParent parent = this.f1974q.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1974q);
            }
        }
    }

    public void m4050g(int i) {
        this.f1962e.setInputMethodMode(i);
    }

    public void m4052h(int i) {
        dc dcVar = this.f1964g;
        if (m4055k() && dcVar != null) {
            dcVar.f2115g = false;
            dcVar.setSelection(i);
            if (VERSION.SDK_INT >= 11 && dcVar.getChoiceMode() != 0) {
                dcVar.setItemChecked(i, true);
            }
        }
    }

    public void m4054j() {
        dc dcVar = this.f1964g;
        if (dcVar != null) {
            dcVar.f2115g = true;
            dcVar.requestLayout();
        }
    }

    public boolean m4055k() {
        return this.f1962e.isShowing();
    }

    public boolean m4056l() {
        return this.f1962e.getInputMethodMode() == 2;
    }

    public ListView m4057m() {
        return this.f1964g;
    }

    private int m4028b() {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z = true;
        LayoutParams layoutParams;
        View view;
        if (this.f1964g == null) {
            Context context = this.f1961d;
            this.f1955B = new da(this);
            this.f1964g = new dc(context, !this.f1958E);
            if (this.f1978u != null) {
                this.f1964g.setSelector(this.f1978u);
            }
            this.f1964g.setAdapter(this.f1963f);
            this.f1964g.setOnItemClickListener(this.f1979v);
            this.f1964g.setFocusable(true);
            this.f1964g.setFocusableInTouchMode(true);
            this.f1964g.setOnItemSelectedListener(new db(this));
            this.f1964g.setOnScrollListener(this.f1983z);
            if (this.f1980w != null) {
                this.f1964g.setOnItemSelectedListener(this.f1980w);
            }
            View view2 = this.f1964g;
            View view3 = this.f1974q;
            if (view3 != null) {
                View linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, 0, 1.0f);
                switch (this.f1975r) {
                    case C0001R.styleable.WalletFragmentStyle_buyButtonHeight /*0*/:
                        linearLayout.addView(view3);
                        linearLayout.addView(view2, layoutParams2);
                        break;
                    case ModuleDescriptor.MODULE_VERSION /*1*/:
                        linearLayout.addView(view2, layoutParams2);
                        linearLayout.addView(view3);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.f1975r);
                        break;
                }
                if (this.f1966i >= 0) {
                    i = this.f1966i;
                    i2 = Integer.MIN_VALUE;
                } else {
                    i2 = 0;
                    i = 0;
                }
                view3.measure(MeasureSpec.makeMeasureSpec(i, i2), 0);
                layoutParams = (LayoutParams) view3.getLayoutParams();
                i2 = layoutParams.bottomMargin + (view3.getMeasuredHeight() + layoutParams.topMargin);
                view = linearLayout;
            } else {
                view = view2;
                i2 = 0;
            }
            this.f1962e.setContentView(view);
            i3 = i2;
        } else {
            ViewGroup viewGroup = (ViewGroup) this.f1962e.getContentView();
            view = this.f1974q;
            if (view != null) {
                layoutParams = (LayoutParams) view.getLayoutParams();
                i3 = layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
            } else {
                i3 = 0;
            }
        }
        Drawable background = this.f1962e.getBackground();
        if (background != null) {
            background.getPadding(this.f1957D);
            i2 = this.f1957D.top + this.f1957D.bottom;
            if (this.f1970m) {
                i4 = i2;
            } else {
                this.f1968k = -this.f1957D.top;
                i4 = i2;
            }
        } else {
            this.f1957D.setEmpty();
            i4 = 0;
        }
        if (this.f1962e.getInputMethodMode() != 2) {
            z = false;
        }
        i = m4025a(m4045e(), this.f1968k, z);
        if (this.f1972o || this.f1965h == -1) {
            return i + i4;
        }
        int makeMeasureSpec;
        switch (this.f1966i) {
            case -2:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f1961d.getResources().getDisplayMetrics().widthPixels - (this.f1957D.left + this.f1957D.right), Integer.MIN_VALUE);
                break;
            case -1:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f1961d.getResources().getDisplayMetrics().widthPixels - (this.f1957D.left + this.f1957D.right), 1073741824);
                break;
            default:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f1966i, 1073741824);
                break;
        }
        i2 = this.f1964g.m4276a(makeMeasureSpec, 0, -1, i - i3, -1);
        if (i2 > 0) {
            i3 += i4;
        }
        return i2 + i3;
    }

    private void m4030b(boolean z) {
        if (f1952a != null) {
            try {
                f1952a.invoke(this.f1962e, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    private int m4025a(View view, int i, boolean z) {
        if (f1953c != null) {
            try {
                return ((Integer) f1953c.invoke(this.f1962e, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z)})).intValue();
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.f1962e.getMaxAvailableHeight(view, i);
    }
}
