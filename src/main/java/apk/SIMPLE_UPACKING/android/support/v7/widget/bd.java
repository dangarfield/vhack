package android.support.v7.widget;

import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* compiled from: AppCompatPopupWindow */
final class bd implements OnScrollChangedListener {
    final /* synthetic */ Field f1921a;
    final /* synthetic */ PopupWindow f1922b;
    final /* synthetic */ OnScrollChangedListener f1923c;

    bd(Field field, PopupWindow popupWindow, OnScrollChangedListener onScrollChangedListener) {
        this.f1921a = field;
        this.f1922b = popupWindow;
        this.f1923c = onScrollChangedListener;
    }

    public void onScrollChanged() {
        try {
            WeakReference weakReference = (WeakReference) this.f1921a.get(this.f1922b);
            if (weakReference != null && weakReference.get() != null) {
                this.f1923c.onScrollChanged();
            }
        } catch (IllegalAccessException e) {
        }
    }
}
