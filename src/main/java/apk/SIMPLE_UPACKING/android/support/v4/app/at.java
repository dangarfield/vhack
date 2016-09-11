package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

/* compiled from: FragmentTransitionCompat21 */
final class at extends EpicenterCallback {
    final /* synthetic */ av f541a;
    private Rect f542b;

    at(av avVar) {
        this.f541a = avVar;
    }

    public Rect onGetEpicenter(Transition transition) {
        if (this.f542b == null && this.f541a.f554a != null) {
            this.f542b = aq.m920c(this.f541a.f554a);
        }
        return this.f542b;
    }
}
