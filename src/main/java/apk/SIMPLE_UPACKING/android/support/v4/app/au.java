package android.support.v4.app;

import android.transition.Transition;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: FragmentTransitionCompat21 */
final class au implements OnPreDrawListener {
    final /* synthetic */ View f543a;
    final /* synthetic */ Transition f544b;
    final /* synthetic */ ArrayList f545c;
    final /* synthetic */ Transition f546d;
    final /* synthetic */ ArrayList f547e;
    final /* synthetic */ Transition f548f;
    final /* synthetic */ ArrayList f549g;
    final /* synthetic */ Map f550h;
    final /* synthetic */ ArrayList f551i;
    final /* synthetic */ Transition f552j;
    final /* synthetic */ View f553k;

    au(View view, Transition transition, ArrayList arrayList, Transition transition2, ArrayList arrayList2, Transition transition3, ArrayList arrayList3, Map map, ArrayList arrayList4, Transition transition4, View view2) {
        this.f543a = view;
        this.f544b = transition;
        this.f545c = arrayList;
        this.f546d = transition2;
        this.f547e = arrayList2;
        this.f548f = transition3;
        this.f549g = arrayList3;
        this.f550h = map;
        this.f551i = arrayList4;
        this.f552j = transition4;
        this.f553k = view2;
    }

    public boolean onPreDraw() {
        this.f543a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.f544b != null) {
            aq.m909a(this.f544b, this.f545c);
        }
        if (this.f546d != null) {
            aq.m909a(this.f546d, this.f547e);
        }
        if (this.f548f != null) {
            aq.m909a(this.f548f, this.f549g);
        }
        for (Entry entry : this.f550h.entrySet()) {
            ((View) entry.getValue()).setTransitionName((String) entry.getKey());
        }
        int size = this.f551i.size();
        for (int i = 0; i < size; i++) {
            this.f552j.excludeTarget((View) this.f551i.get(i), false);
        }
        this.f552j.excludeTarget(this.f553k, false);
        return true;
    }
}
