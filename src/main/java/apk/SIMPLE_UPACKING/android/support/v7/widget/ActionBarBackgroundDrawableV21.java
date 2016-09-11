package android.support.v7.widget;

import android.graphics.Outline;

/* renamed from: android.support.v7.widget.d */
class ActionBarBackgroundDrawableV21 extends ActionBarBackgroundDrawable {
    public ActionBarBackgroundDrawableV21(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    public void getOutline(Outline outline) {
        if (this.a.f1589d) {
            if (this.a.f1588c != null) {
                this.a.f1588c.getOutline(outline);
            }
        } else if (this.a.f1586a != null) {
            this.a.f1586a.getOutline(outline);
        }
    }
}
