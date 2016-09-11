package android.support.v7.widget;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.PopupWindow.OnDismissListener;

/* compiled from: AppCompatSpinner */
class bp implements OnDismissListener {
    final /* synthetic */ OnGlobalLayoutListener f1991a;
    final /* synthetic */ bm f1992b;

    bp(bm bmVar, OnGlobalLayoutListener onGlobalLayoutListener) {
        this.f1992b = bmVar;
        this.f1991a = onGlobalLayoutListener;
    }

    public void onDismiss() {
        ViewTreeObserver viewTreeObserver = this.f1992b.f1984a.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f1991a);
        }
    }
}
