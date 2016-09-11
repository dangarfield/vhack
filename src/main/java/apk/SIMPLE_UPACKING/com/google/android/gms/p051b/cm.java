package com.google.android.gms.p051b;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.client.C0046n;
import com.google.android.gms.ads.internal.overlay.C0073p;
import com.google.android.gms.ads.internal.util.client.C0099b;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

@fi
/* renamed from: com.google.android.gms.b.cm */
public final class cm implements ce {
    private final Map f3526a;

    public cm() {
        this.f3526a = new WeakHashMap();
    }

    private static int m6241a(Context context, Map map, String str, int i) {
        String str2 = (String) map.get(str);
        if (str2 != null) {
            try {
                i = C0046n.m5409a().m5628a(context, Integer.parseInt(str2));
            } catch (NumberFormatException e) {
                C0099b.m5643d("Could not parse " + str + " in a video GMSG: " + str2);
            }
        }
        return i;
    }

    public void m6242a(hb hbVar, Map map) {
        String str = (String) map.get("action");
        if (str == null) {
            C0099b.m5643d("Action missing from video GMSG.");
            return;
        }
        if (C0099b.m5638a(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            C0099b.m5636a("Video GMSG: " + str + " " + jSONObject.toString());
        }
        String str2;
        if ("background".equals(str)) {
            str2 = (String) map.get("color");
            if (TextUtils.isEmpty(str2)) {
                C0099b.m5643d("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                int parseColor = Color.parseColor(str2);
                ha s = hbVar.m6660s();
                if (s != null) {
                    C0073p a = s.m6626a();
                    if (a != null) {
                        a.setBackgroundColor(parseColor);
                        return;
                    }
                }
                this.f3526a.put(hbVar, Integer.valueOf(parseColor));
                return;
            } catch (IllegalArgumentException e) {
                C0099b.m5643d("Invalid color parameter in video GMSG.");
                return;
            }
        }
        ha s2 = hbVar.m6660s();
        if (s2 == null) {
            C0099b.m5643d("Could not get underlay container for a video GMSG.");
            return;
        }
        boolean equals = "new".equals(str);
        boolean equals2 = "position".equals(str);
        int a2;
        int a3;
        if (equals || equals2) {
            int parseInt;
            Context context = hbVar.getContext();
            int a4 = cm.m6241a(context, map, "x", 0);
            a2 = cm.m6241a(context, map, "y", 0);
            a3 = cm.m6241a(context, map, "w", -1);
            int a5 = cm.m6241a(context, map, "h", -1);
            try {
                parseInt = Integer.parseInt((String) map.get("player"));
            } catch (NumberFormatException e2) {
                parseInt = 0;
            }
            if (equals && s2.m6626a() == null) {
                s2.m6628a(a4, a2, a3, a5, parseInt);
                if (this.f3526a.containsKey(hbVar)) {
                    a4 = ((Integer) this.f3526a.get(hbVar)).intValue();
                    C0073p a6 = s2.m6626a();
                    a6.setBackgroundColor(a4);
                    a6.m5542f();
                    return;
                }
                return;
            }
            s2.m6627a(a4, a2, a3, a5);
            return;
        }
        C0073p a7 = s2.m6626a();
        if (a7 == null) {
            C0073p.m5525a(hbVar);
        } else if ("click".equals(str)) {
            Context context2 = hbVar.getContext();
            a2 = cm.m6241a(context2, map, "x", 0);
            a3 = cm.m6241a(context2, map, "y", 0);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) a2, (float) a3, 0);
            a7.m5535a(obtain);
            obtain.recycle();
        } else if ("currentTime".equals(str)) {
            str2 = (String) map.get("time");
            if (str2 == null) {
                C0099b.m5643d("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                a7.m5533a((int) (Float.parseFloat(str2) * 1000.0f));
            } catch (NumberFormatException e3) {
                C0099b.m5643d("Could not parse time parameter from currentTime video GMSG: " + str2);
            }
        } else if ("hide".equals(str)) {
            a7.setVisibility(4);
        } else if ("load".equals(str)) {
            a7.m5531a();
        } else if ("mimetype".equals(str)) {
            a7.setMimeType((String) map.get("mimetype"));
        } else if ("muted".equals(str)) {
            if (Boolean.parseBoolean((String) map.get("muted"))) {
                a7.m5540d();
            } else {
                a7.m5541e();
            }
        } else if ("pause".equals(str)) {
            a7.m5538b();
        } else if ("play".equals(str)) {
            a7.m5539c();
        } else if ("show".equals(str)) {
            a7.setVisibility(0);
        } else if ("src".equals(str)) {
            a7.m5536a((String) map.get("src"));
        } else if ("volume".equals(str)) {
            str2 = (String) map.get("volume");
            if (str2 == null) {
                C0099b.m5643d("Level parameter missing from volume video GMSG.");
                return;
            }
            try {
                a7.m5532a(Float.parseFloat(str2));
            } catch (NumberFormatException e4) {
                C0099b.m5643d("Could not parse volume parameter from volume video GMSG: " + str2);
            }
        } else if ("watermark".equals(str)) {
            a7.m5542f();
        } else {
            C0099b.m5643d("Unknown video action: " + str);
        }
    }
}
