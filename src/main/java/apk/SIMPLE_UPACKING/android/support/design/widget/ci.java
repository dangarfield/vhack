package android.support.design.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* compiled from: ViewGroupUtilsHoneycomb */
class ci {
    private static final ThreadLocal f404a;
    private static final ThreadLocal f405b;
    private static final Matrix f406c;

    static {
        f404a = new ThreadLocal();
        f405b = new ThreadLocal();
        f406c = new Matrix();
    }

    public static void m666a(ViewGroup viewGroup, View view, Rect rect) {
        Matrix matrix;
        Matrix matrix2 = (Matrix) f404a.get();
        if (matrix2 == null) {
            matrix2 = new Matrix();
            f404a.set(matrix2);
            matrix = matrix2;
        } else {
            matrix2.set(f406c);
            matrix = matrix2;
        }
        m667a((ViewParent) viewGroup, view, matrix);
        RectF rectF = (RectF) f405b.get();
        if (rectF == null) {
            rectF = new RectF();
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    static void m667a(ViewParent viewParent, View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            View view2 = (View) parent;
            m667a(viewParent, view2, matrix);
            matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        if (!view.getMatrix().isIdentity()) {
            matrix.preConcat(view.getMatrix());
        }
    }
}
