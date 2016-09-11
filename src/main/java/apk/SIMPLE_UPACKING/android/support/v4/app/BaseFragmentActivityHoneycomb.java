package android.support.v4.app;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: android.support.v4.app.r */
abstract class BaseFragmentActivityHoneycomb extends BaseFragmentActivityDonut {
    BaseFragmentActivityHoneycomb() {
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View a = m1122a(view, str, context, attributeSet);
        if (a != null || VERSION.SDK_INT < 11) {
            return a;
        }
        return super.onCreateView(view, str, context, attributeSet);
    }
}
