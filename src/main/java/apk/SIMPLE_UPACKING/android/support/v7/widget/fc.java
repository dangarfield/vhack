package android.support.v7.widget;

import android.view.View;

/* compiled from: ScrollbarHelper */
class fc {
    static int m4563a(ev evVar, dp dpVar, View view, View view2, ei eiVar, boolean z, boolean z2) {
        if (eiVar.m3603s() == 0 || evVar.m4487e() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z2 ? Math.max(0, (evVar.m4487e() - Math.max(eiVar.m3566d(view), eiVar.m3566d(view2))) - 1) : Math.max(0, Math.min(eiVar.m3566d(view), eiVar.m3566d(view2)));
        if (!z) {
            return max;
        }
        return Math.round((((float) max) * (((float) Math.abs(dpVar.m4304b(view2) - dpVar.m4300a(view))) / ((float) (Math.abs(eiVar.m3566d(view) - eiVar.m3566d(view2)) + 1)))) + ((float) (dpVar.m4305c() - dpVar.m4300a(view))));
    }

    static int m4562a(ev evVar, dp dpVar, View view, View view2, ei eiVar, boolean z) {
        if (eiVar.m3603s() == 0 || evVar.m4487e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(eiVar.m3566d(view) - eiVar.m3566d(view2)) + 1;
        }
        return Math.min(dpVar.m4310f(), dpVar.m4304b(view2) - dpVar.m4300a(view));
    }

    static int m4564b(ev evVar, dp dpVar, View view, View view2, ei eiVar, boolean z) {
        if (eiVar.m3603s() == 0 || evVar.m4487e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return evVar.m4487e();
        }
        return (int) ((((float) (dpVar.m4304b(view2) - dpVar.m4300a(view))) / ((float) (Math.abs(eiVar.m3566d(view) - eiVar.m3566d(view2)) + 1))) * ((float) evVar.m4487e()));
    }
}
