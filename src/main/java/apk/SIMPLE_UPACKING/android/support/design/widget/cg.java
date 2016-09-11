package android.support.design.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: ViewGroupUtils */
class cg implements cf {
    private cg() {
    }

    public void m664a(ViewGroup viewGroup, View view, Rect rect) {
        viewGroup.offsetDescendantRectToMyCoords(view, rect);
        rect.offset(view.getScrollX(), view.getScrollY());
    }
}
