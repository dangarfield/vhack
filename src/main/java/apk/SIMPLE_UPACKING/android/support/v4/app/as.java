package android.support.v4.app;

import android.transition.Transition;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: FragmentTransitionCompat21 */
final class as implements OnPreDrawListener {
    final /* synthetic */ View f534a;
    final /* synthetic */ Transition f535b;
    final /* synthetic */ View f536c;
    final /* synthetic */ aw f537d;
    final /* synthetic */ Map f538e;
    final /* synthetic */ Map f539f;
    final /* synthetic */ ArrayList f540g;

    as(View view, Transition transition, View view2, aw awVar, Map map, Map map2, ArrayList arrayList) {
        this.f534a = view;
        this.f535b = transition;
        this.f536c = view2;
        this.f537d = awVar;
        this.f538e = map;
        this.f539f = map2;
        this.f540g = arrayList;
    }

    public boolean onPreDraw() {
        this.f534a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.f535b != null) {
            this.f535b.removeTarget(this.f536c);
        }
        View a = this.f537d.m921a();
        if (a != null) {
            if (!this.f538e.isEmpty()) {
                aq.m912a(this.f539f, a);
                this.f539f.keySet().retainAll(this.f538e.values());
                for (Entry entry : this.f538e.entrySet()) {
                    View view = (View) this.f539f.get((String) entry.getValue());
                    if (view != null) {
                        view.setTransitionName((String) entry.getKey());
                    }
                }
            }
            if (this.f535b != null) {
                aq.m919b(this.f540g, a);
                this.f540g.removeAll(this.f539f.values());
                this.f540g.add(this.f536c);
                aq.m918b(this.f535b, this.f540g);
            }
        }
        return true;
    }
}
