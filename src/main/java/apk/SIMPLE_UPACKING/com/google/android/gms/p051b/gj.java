package com.google.android.gms.p051b;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.C0056g;
import com.google.android.gms.ads.internal.util.client.C0099b;
import java.util.Map;

@fi
/* renamed from: com.google.android.gms.b.gj */
public class gj {
    private final Context f3688a;
    private String f3689b;
    private final float f3690c;
    private float f3691d;
    private float f3692e;
    private float f3693f;
    private int f3694g;

    public gj(Context context) {
        this.f3694g = 0;
        this.f3688a = context;
        this.f3690c = context.getResources().getDisplayMetrics().density;
    }

    public gj(Context context, String str) {
        this(context);
        this.f3689b = str;
    }

    static String m6596a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "No debug information";
        }
        Uri build = new Builder().encodedQuery(str.replaceAll("\\+", "%20")).build();
        StringBuilder stringBuilder = new StringBuilder();
        Map a = C0056g.m5439c().m6528a(build);
        for (String str2 : a.keySet()) {
            stringBuilder.append(str2).append(" = ").append((String) a.get(str2)).append("\n\n");
        }
        Object trim = stringBuilder.toString().trim();
        return TextUtils.isEmpty(trim) ? "No debug information" : trim;
    }

    private void m6597a() {
        if (this.f3688a instanceof Activity) {
            Object a = gj.m6596a(this.f3689b);
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f3688a);
            builder.setMessage(a);
            builder.setTitle("Ad Information");
            builder.setPositiveButton("Share", new gk(this, a));
            builder.setNegativeButton("Close", new gl(this));
            builder.create().show();
            return;
        }
        C0099b.m5641c("Can not create dialog without Activity Context");
    }

    void m6598a(int i, float f, float f2) {
        if (i == 0) {
            this.f3694g = 0;
            this.f3691d = f;
            this.f3692e = f2;
            this.f3693f = f2;
        } else if (this.f3694g == -1) {
        } else {
            if (i == 2) {
                if (f2 > this.f3692e) {
                    this.f3692e = f2;
                } else if (f2 < this.f3693f) {
                    this.f3693f = f2;
                }
                if (this.f3692e - this.f3693f > 30.0f * this.f3690c) {
                    this.f3694g = -1;
                    return;
                }
                if (this.f3694g == 0 || this.f3694g == 2) {
                    if (f - this.f3691d >= 50.0f * this.f3690c) {
                        this.f3691d = f;
                        this.f3694g++;
                    }
                } else if ((this.f3694g == 1 || this.f3694g == 3) && f - this.f3691d <= -50.0f * this.f3690c) {
                    this.f3691d = f;
                    this.f3694g++;
                }
                if (this.f3694g == 1 || this.f3694g == 3) {
                    if (f > this.f3691d) {
                        this.f3691d = f;
                    }
                } else if (this.f3694g == 2 && f < this.f3691d) {
                    this.f3691d = f;
                }
            } else if (i == 1 && this.f3694g == 4) {
                m6597a();
            }
        }
    }

    public void m6599a(MotionEvent motionEvent) {
        int historySize = motionEvent.getHistorySize();
        for (int i = 0; i < historySize; i++) {
            m6598a(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, i), motionEvent.getHistoricalY(0, i));
        }
        m6598a(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
    }
}
