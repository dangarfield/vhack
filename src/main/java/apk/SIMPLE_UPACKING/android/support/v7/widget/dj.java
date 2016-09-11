package android.support.v7.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: ListPopupWindow */
class dj implements OnTouchListener {
    final /* synthetic */ cy f2125a;

    private dj(cy cyVar) {
        this.f2125a = cyVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (action == 0 && this.f2125a.f1962e != null && this.f2125a.f1962e.isShowing() && x >= 0 && x < this.f2125a.f1962e.getWidth() && y >= 0 && y < this.f2125a.f1962e.getHeight()) {
            this.f2125a.f1956C.postDelayed(this.f2125a.f1981x, 250);
        } else if (action == 1) {
            this.f2125a.f1956C.removeCallbacks(this.f2125a.f1981x);
        }
        return false;
    }
}
