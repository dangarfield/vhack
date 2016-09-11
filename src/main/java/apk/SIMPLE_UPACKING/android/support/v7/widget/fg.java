package android.support.v7.widget;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ScrollingTabContainerView */
class fg implements OnClickListener {
    final /* synthetic */ fd f2236a;

    private fg(fd fdVar) {
        this.f2236a = fdVar;
    }

    public void onClick(View view) {
        ((fh) view).m4575b().m3032d();
        int childCount = this.f2236a.f2228e.getChildCount();
        for (int i = 0; i < childCount; i++) {
            boolean z;
            View childAt = this.f2236a.f2228e.getChildAt(i);
            if (childAt == view) {
                z = true;
            } else {
                z = false;
            }
            childAt.setSelected(z);
        }
    }
}
