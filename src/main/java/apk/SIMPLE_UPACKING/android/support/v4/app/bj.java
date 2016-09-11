package android.support.v4.app;

import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: NotificationCompat */
public class bj {
    private static final br f579a;

    private static void m985b(bh bhVar, ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bhVar.m979a((bk) it.next());
        }
    }

    private static void m986b(bi biVar, ca caVar) {
        if (caVar == null) {
            return;
        }
        if (caVar instanceof bn) {
            bn bnVar = (bn) caVar;
            cm.m1038a(biVar, bnVar.d, bnVar.f, bnVar.e, bnVar.f592a);
        } else if (caVar instanceof bq) {
            bq bqVar = (bq) caVar;
            cm.m1039a(biVar, bqVar.d, bqVar.f, bqVar.e, bqVar.f622a);
        } else if (caVar instanceof bm) {
            bm bmVar = (bm) caVar;
            cm.m1037a(biVar, bmVar.d, bmVar.f, bmVar.e, bmVar.f589a, bmVar.f590b, bmVar.f591c);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f579a = new bt();
        } else if (VERSION.SDK_INT >= 20) {
            f579a = new bs();
        } else if (VERSION.SDK_INT >= 19) {
            f579a = new bz();
        } else if (VERSION.SDK_INT >= 16) {
            f579a = new by();
        } else if (VERSION.SDK_INT >= 14) {
            f579a = new bx();
        } else if (VERSION.SDK_INT >= 11) {
            f579a = new bw();
        } else if (VERSION.SDK_INT >= 9) {
            f579a = new bv();
        } else {
            f579a = new bu();
        }
    }
}
