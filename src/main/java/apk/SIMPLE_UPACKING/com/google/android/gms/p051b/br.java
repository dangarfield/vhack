package com.google.android.gms.p051b;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.C0056g;
import com.google.android.gms.ads.internal.util.client.C0099b;
import java.util.Map;

@fi
/* renamed from: com.google.android.gms.b.br */
public final class br implements ce {
    private long m6168a(long j) {
        return (j - C0056g.m5443g().m6913a()) + C0056g.m5443g().m6914b();
    }

    private void m6169b(hb hbVar, Map map) {
        String str = (String) map.get("label");
        String str2 = (String) map.get("start_label");
        String str3 = (String) map.get("timestamp");
        if (TextUtils.isEmpty(str)) {
            C0099b.m5643d("No label given for CSI tick.");
        } else if (TextUtils.isEmpty(str3)) {
            C0099b.m5643d("No timestamp given for CSI tick.");
        } else {
            try {
                long a = m6168a(Long.parseLong(str3));
                if (TextUtils.isEmpty(str2)) {
                    str2 = "native:view_load";
                }
                hbVar.m6662u().m6125a(str, str2, a);
            } catch (Throwable e) {
                C0099b.m5642c("Malformed timestamp for CSI tick.", e);
            }
        }
    }

    private void m6170c(hb hbVar, Map map) {
        String str = (String) map.get("value");
        if (TextUtils.isEmpty(str)) {
            C0099b.m5643d("No value given for CSI experiment.");
            return;
        }
        az a = hbVar.m6662u().m6123a();
        if (a == null) {
            C0099b.m5643d("No ticker for WebView, dropping experiment ID.");
        } else {
            a.m6129a("e", str);
        }
    }

    private void m6171d(hb hbVar, Map map) {
        String str = (String) map.get("name");
        String str2 = (String) map.get("value");
        if (TextUtils.isEmpty(str2)) {
            C0099b.m5643d("No value given for CSI extra.");
        } else if (TextUtils.isEmpty(str)) {
            C0099b.m5643d("No name given for CSI extra.");
        } else {
            az a = hbVar.m6662u().m6123a();
            if (a == null) {
                C0099b.m5643d("No ticker for WebView, dropping extra parameter.");
            } else {
                a.m6129a(str, str2);
            }
        }
    }

    public void m6172a(hb hbVar, Map map) {
        String str = (String) map.get("action");
        if ("tick".equals(str)) {
            m6169b(hbVar, map);
        } else if ("experiment".equals(str)) {
            m6170c(hbVar, map);
        } else if ("extra".equals(str)) {
            m6171d(hbVar, map);
        }
    }
}
