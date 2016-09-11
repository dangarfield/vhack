package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p002h.bo;
import android.support.v4.p007b.ContextCompat;
import android.support.v7.p018b.R;
import android.support.v7.view.ContextThemeWrapper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

/* compiled from: AppCompatSpinner */
public class bj extends Spinner implements bo {
    private static final boolean f1936a;
    private static final boolean f1937b;
    private static final int[] f1938c;
    private ar f1939d;
    private am f1940e;
    private Context f1941f;
    private dd f1942g;
    private SpinnerAdapter f1943h;
    private boolean f1944i;
    private bm f1945j;
    private int f1946k;
    private final Rect f1947l;

    static {
        boolean z;
        if (VERSION.SDK_INT >= 23) {
            z = true;
        } else {
            z = false;
        }
        f1936a = z;
        if (VERSION.SDK_INT >= 16) {
            z = true;
        } else {
            z = false;
        }
        f1937b = z;
        f1938c = new int[]{16843505};
    }

    public bj(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.spinnerStyle);
    }

    public bj(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public bj(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    public bj(Context context, AttributeSet attributeSet, int i, int i2, Theme theme) {
        Throwable e;
        CharSequence[] e2;
        SpinnerAdapter arrayAdapter;
        super(context, attributeSet, i);
        this.f1947l = new Rect();
        gb a = gb.m4646a(context, attributeSet, R.Spinner, i, 0);
        this.f1939d = ar.m3972a();
        this.f1940e = new am(this, this.f1939d);
        if (theme != null) {
            this.f1941f = new ContextThemeWrapper(context, theme);
        } else {
            int g = a.m4662g(R.Spinner_popupTheme, 0);
            if (g != 0) {
                this.f1941f = new ContextThemeWrapper(context, g);
            } else {
                this.f1941f = !f1936a ? context : null;
            }
        }
        if (this.f1941f != null) {
            bm bmVar;
            gb a2;
            if (i2 == -1) {
                if (VERSION.SDK_INT >= 11) {
                    TypedArray obtainStyledAttributes;
                    try {
                        obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1938c, i, 0);
                        try {
                            if (obtainStyledAttributes.hasValue(0)) {
                                i2 = obtainStyledAttributes.getInt(0, 0);
                            }
                            if (obtainStyledAttributes != null) {
                                obtainStyledAttributes.recycle();
                            }
                        } catch (Exception e3) {
                            e = e3;
                            try {
                                Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                                if (obtainStyledAttributes != null) {
                                    obtainStyledAttributes.recycle();
                                }
                                if (i2 == 1) {
                                    bmVar = new bm(this, this.f1941f, attributeSet, i);
                                    a2 = gb.m4646a(this.f1941f, attributeSet, R.Spinner, i, 0);
                                    this.f1946k = a2.m4660f(R.Spinner_android_dropDownWidth, -2);
                                    bmVar.m4034a(a2.m4649a(R.Spinner_android_popupBackground));
                                    bmVar.m4064a(a.m4657d(R.Spinner_android_prompt));
                                    a2.m4650a();
                                    this.f1945j = bmVar;
                                    this.f1942g = new bk(this, this, bmVar);
                                }
                                e2 = a.m4659e(R.Spinner_android_entries);
                                if (e2 != null) {
                                    arrayAdapter = new ArrayAdapter(context, R.support_simple_spinner_dropdown_item, e2);
                                    arrayAdapter.setDropDownViewResource(R.support_simple_spinner_dropdown_item);
                                    setAdapter(arrayAdapter);
                                }
                                a.m4650a();
                                this.f1944i = true;
                                if (this.f1943h != null) {
                                    setAdapter(this.f1943h);
                                    this.f1943h = null;
                                }
                                this.f1940e.m3955a(attributeSet, i);
                            } catch (Throwable th) {
                                e = th;
                                if (obtainStyledAttributes != null) {
                                    obtainStyledAttributes.recycle();
                                }
                                throw e;
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        obtainStyledAttributes = null;
                        Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                        if (i2 == 1) {
                            bmVar = new bm(this, this.f1941f, attributeSet, i);
                            a2 = gb.m4646a(this.f1941f, attributeSet, R.Spinner, i, 0);
                            this.f1946k = a2.m4660f(R.Spinner_android_dropDownWidth, -2);
                            bmVar.m4034a(a2.m4649a(R.Spinner_android_popupBackground));
                            bmVar.m4064a(a.m4657d(R.Spinner_android_prompt));
                            a2.m4650a();
                            this.f1945j = bmVar;
                            this.f1942g = new bk(this, this, bmVar);
                        }
                        e2 = a.m4659e(R.Spinner_android_entries);
                        if (e2 != null) {
                            arrayAdapter = new ArrayAdapter(context, R.support_simple_spinner_dropdown_item, e2);
                            arrayAdapter.setDropDownViewResource(R.support_simple_spinner_dropdown_item);
                            setAdapter(arrayAdapter);
                        }
                        a.m4650a();
                        this.f1944i = true;
                        if (this.f1943h != null) {
                            setAdapter(this.f1943h);
                            this.f1943h = null;
                        }
                        this.f1940e.m3955a(attributeSet, i);
                    } catch (Throwable th2) {
                        e = th2;
                        obtainStyledAttributes = null;
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                        throw e;
                    }
                }
                i2 = 1;
            }
            if (i2 == 1) {
                bmVar = new bm(this, this.f1941f, attributeSet, i);
                a2 = gb.m4646a(this.f1941f, attributeSet, R.Spinner, i, 0);
                this.f1946k = a2.m4660f(R.Spinner_android_dropDownWidth, -2);
                bmVar.m4034a(a2.m4649a(R.Spinner_android_popupBackground));
                bmVar.m4064a(a.m4657d(R.Spinner_android_prompt));
                a2.m4650a();
                this.f1945j = bmVar;
                this.f1942g = new bk(this, this, bmVar);
            }
        }
        e2 = a.m4659e(R.Spinner_android_entries);
        if (e2 != null) {
            arrayAdapter = new ArrayAdapter(context, R.support_simple_spinner_dropdown_item, e2);
            arrayAdapter.setDropDownViewResource(R.support_simple_spinner_dropdown_item);
            setAdapter(arrayAdapter);
        }
        a.m4650a();
        this.f1944i = true;
        if (this.f1943h != null) {
            setAdapter(this.f1943h);
            this.f1943h = null;
        }
        this.f1940e.m3955a(attributeSet, i);
    }

    public Context getPopupContext() {
        if (this.f1945j != null) {
            return this.f1941f;
        }
        if (f1936a) {
            return super.getPopupContext();
        }
        return null;
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.f1945j != null) {
            this.f1945j.m4034a(drawable);
        } else if (f1937b) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(ContextCompat.m741a(getPopupContext(), i));
    }

    public Drawable getPopupBackground() {
        if (this.f1945j != null) {
            return this.f1945j.m4043d();
        }
        if (f1937b) {
            return super.getPopupBackground();
        }
        return null;
    }

    public void setDropDownVerticalOffset(int i) {
        if (this.f1945j != null) {
            this.f1945j.m4042c(i);
        } else if (f1937b) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public int getDropDownVerticalOffset() {
        if (this.f1945j != null) {
            return this.f1945j.m4049g();
        }
        if (f1937b) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    public void setDropDownHorizontalOffset(int i) {
        if (this.f1945j != null) {
            this.f1945j.m4040b(i);
        } else if (f1937b) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public int getDropDownHorizontalOffset() {
        if (this.f1945j != null) {
            return this.f1945j.m4047f();
        }
        if (f1937b) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    public void setDropDownWidth(int i) {
        if (this.f1945j != null) {
            this.f1946k = i;
        } else if (f1937b) {
            super.setDropDownWidth(i);
        }
    }

    public int getDropDownWidth() {
        if (this.f1945j != null) {
            return this.f1946k;
        }
        if (f1937b) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.f1944i) {
            super.setAdapter(spinnerAdapter);
            if (this.f1945j != null) {
                this.f1945j.m4063a(new bl(spinnerAdapter, (this.f1941f == null ? getContext() : this.f1941f).getTheme()));
                return;
            }
            return;
        }
        this.f1943h = spinnerAdapter;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1945j != null && this.f1945j.m4055k()) {
            this.f1945j.m4053i();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f1942g == null || !this.f1942g.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1945j != null && MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), m4018a(getAdapter(), getBackground())), MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public boolean performClick() {
        if (this.f1945j == null || this.f1945j.m4055k()) {
            return super.performClick();
        }
        this.f1945j.m4066c();
        return true;
    }

    public void setPrompt(CharSequence charSequence) {
        if (this.f1945j != null) {
            this.f1945j.m4064a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public CharSequence getPrompt() {
        return this.f1945j != null ? this.f1945j.m4062a() : super.getPrompt();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1940e != null) {
            this.f1940e.m3951a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1940e != null) {
            this.f1940e.m3954a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1940e != null) {
            this.f1940e.m3952a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1940e != null ? this.f1940e.m3950a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1940e != null) {
            this.f1940e.m3953a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1940e != null ? this.f1940e.m3956b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1940e != null) {
            this.f1940e.m3958c();
        }
    }

    private int m4018a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int max2 = Math.max(0, max - (15 - (min - max)));
        View view = null;
        int i = 0;
        max = 0;
        while (max2 < min) {
            View view2;
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != max) {
                view2 = null;
            } else {
                itemViewType = max;
                view2 = view;
            }
            view = spinnerAdapter.getView(max2, view2, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i = Math.max(i, view.getMeasuredWidth());
            max2++;
            max = itemViewType;
        }
        if (drawable == null) {
            return i;
        }
        drawable.getPadding(this.f1947l);
        return (this.f1947l.left + this.f1947l.right) + i;
    }
}
