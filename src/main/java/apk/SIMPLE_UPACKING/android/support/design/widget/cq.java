package android.support.design.widget;

import android.widget.ImageButton;

/* compiled from: VisibilityAwareImageButton */
class cq extends ImageButton {
    private int f251a;

    public void setVisibility(int i) {
        m405a(i, true);
    }

    final void m405a(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.f251a = i;
        }
    }

    final int getUserSetVisibility() {
        return this.f251a;
    }
}
