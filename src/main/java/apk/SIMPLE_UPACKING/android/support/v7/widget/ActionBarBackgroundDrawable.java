package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.v7.widget.c */
class ActionBarBackgroundDrawable extends Drawable {
    final ActionBarContainer f2026a;

    public ActionBarBackgroundDrawable(ActionBarContainer actionBarContainer) {
        this.f2026a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        if (!this.f2026a.f1589d) {
            if (this.f2026a.f1586a != null) {
                this.f2026a.f1586a.draw(canvas);
            }
            if (this.f2026a.f1587b != null && this.f2026a.f1590e) {
                this.f2026a.f1587b.draw(canvas);
            }
        } else if (this.f2026a.f1588c != null) {
            this.f2026a.f1588c.draw(canvas);
        }
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
