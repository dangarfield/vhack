package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

/* compiled from: FragmentTransitionCompat21 */
final class ar extends EpicenterCallback {
    final /* synthetic */ Rect f533a;

    ar(Rect rect) {
        this.f533a = rect;
    }

    public Rect onGetEpicenter(Transition transition) {
        return this.f533a;
    }
}
