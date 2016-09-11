package android.support.v4.p002h;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory;
import android.view.View;

/* compiled from: LayoutInflaterCompatBase */
/* renamed from: android.support.v4.h.ah */
class ah implements Factory {
    final al f908a;

    ah(al alVar) {
        this.f908a = alVar;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return this.f908a.m819a(null, str, context, attributeSet);
    }

    public String toString() {
        return getClass().getName() + "{" + this.f908a + "}";
    }
}
