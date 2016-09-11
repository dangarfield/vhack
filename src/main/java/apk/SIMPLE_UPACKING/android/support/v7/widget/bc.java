package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.widget.ag;
import android.support.v7.p018b.R;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

/* compiled from: AppCompatPopupWindow */
public class bc extends PopupWindow {
    private static final boolean f1919a;
    private boolean f1920b;

    static {
        f1919a = VERSION.SDK_INT < 21;
    }

    public bc(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        gb a = gb.m4646a(context, attributeSet, R.PopupWindow, i, 0);
        if (a.m4661f(R.PopupWindow_overlapAnchor)) {
            m4010a(a.m4651a(R.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(a.m4649a(R.PopupWindow_android_popupBackground));
        a.m4650a();
        if (VERSION.SDK_INT < 14) {
            m4009a((PopupWindow) this);
        }
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (f1919a && this.f1920b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @TargetApi(19)
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f1919a && this.f1920b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        int height;
        if (f1919a && this.f1920b) {
            height = i2 - view.getHeight();
        } else {
            height = i2;
        }
        super.update(view, i, height, i3, i4);
    }

    private static void m4009a(PopupWindow popupWindow) {
        try {
            Field declaredField = PopupWindow.class.getDeclaredField("mAnchor");
            declaredField.setAccessible(true);
            Field declaredField2 = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
            declaredField2.setAccessible(true);
            declaredField2.set(popupWindow, new bd(declaredField, popupWindow, (OnScrollChangedListener) declaredField2.get(popupWindow)));
        } catch (Throwable e) {
            Log.d("AppCompatPopupWindow", "Exception while installing workaround OnScrollChangedListener", e);
        }
    }

    public void m4010a(boolean z) {
        if (f1919a) {
            this.f1920b = z;
        } else {
            ag.m2499a((PopupWindow) this, z);
        }
    }
}
