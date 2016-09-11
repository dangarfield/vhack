package android.support.v7.p017a;

import android.content.Context;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.ar;
import android.view.KeyEvent;
import android.view.MotionEvent;

/* compiled from: AppCompatDelegateImplV7 */
/* renamed from: android.support.v7.a.ap */
class ap extends ContentFrameLayout {
    final /* synthetic */ ae f1144a;

    public ap(ae aeVar, Context context) {
        this.f1144a = aeVar;
        super(context);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f1144a.m2829a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || !m2886a((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        this.f1144a.m2803d(0);
        return true;
    }

    public void setBackgroundResource(int i) {
        setBackgroundDrawable(ar.m3972a().m3993a(getContext(), i));
    }

    private boolean m2886a(int i, int i2) {
        return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
    }
}
