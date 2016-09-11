package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

/* compiled from: RecyclerView */
public abstract class eh {
    public void m4390a(Canvas canvas, RecyclerView recyclerView, ev evVar) {
        m4389a(canvas, recyclerView);
    }

    @Deprecated
    public void m4389a(Canvas canvas, RecyclerView recyclerView) {
    }

    public void m4394b(Canvas canvas, RecyclerView recyclerView, ev evVar) {
        m4393b(canvas, recyclerView);
    }

    @Deprecated
    public void m4393b(Canvas canvas, RecyclerView recyclerView) {
    }

    @Deprecated
    public void m4391a(Rect rect, int i, RecyclerView recyclerView) {
        rect.set(0, 0, 0, 0);
    }

    public void m4392a(Rect rect, View view, RecyclerView recyclerView, ev evVar) {
        m4391a(rect, ((ek) view.getLayoutParams()).m4251e(), recyclerView);
    }
}
