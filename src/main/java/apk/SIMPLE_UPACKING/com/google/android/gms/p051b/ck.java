package com.google.android.gms.p051b;

import android.content.Intent;
import android.net.Uri;

/* renamed from: com.google.android.gms.b.ck */
public class ck extends fn {
    private final String f3520a;
    private final String f3521b;
    private final int f3522c;
    private final String f3523d;
    private final hb f3524e;

    public ck(hb hbVar, String str) {
        this.f3520a = "play.google.com";
        this.f3521b = "market";
        this.f3522c = 10;
        this.f3524e = hbVar;
        this.f3523d = str;
    }

    public Intent m6234a(String str) {
        Uri parse = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setData(parse);
        return intent;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m6235a() {
        /*
        r8 = this;
        r0 = 0;
        r2 = r8.f3523d;
    L_0x0003:
        r1 = 10;
        if (r0 >= r1) goto L_0x0119;
    L_0x0007:
        r4 = r0 + 1;
        r0 = new java.net.URL;	 Catch:{ IndexOutOfBoundsException -> 0x00b6, IOException -> 0x00d1, RuntimeException -> 0x00ec }
        r0.<init>(r2);	 Catch:{ IndexOutOfBoundsException -> 0x00b6, IOException -> 0x00d1, RuntimeException -> 0x00ec }
        r1 = "play.google.com";
        r3 = r0.getHost();	 Catch:{ IndexOutOfBoundsException -> 0x00b6, IOException -> 0x00d1, RuntimeException -> 0x00ec }
        r1 = r1.equalsIgnoreCase(r3);	 Catch:{ IndexOutOfBoundsException -> 0x00b6, IOException -> 0x00d1, RuntimeException -> 0x00ec }
        if (r1 == 0) goto L_0x002d;
    L_0x001a:
        r0 = r2;
    L_0x001b:
        r0 = r8.m6234a(r0);
        r1 = com.google.android.gms.ads.internal.C0056g.m5439c();
        r2 = r8.f3524e;
        r2 = r2.getContext();
        r1.m6533a(r2, r0);
        return;
    L_0x002d:
        r1 = "market";
        r3 = r0.getProtocol();	 Catch:{ IndexOutOfBoundsException -> 0x00b6, IOException -> 0x00d1, RuntimeException -> 0x00ec }
        r1 = r1.equalsIgnoreCase(r3);	 Catch:{ IndexOutOfBoundsException -> 0x00b6, IOException -> 0x00d1, RuntimeException -> 0x00ec }
        if (r1 == 0) goto L_0x003b;
    L_0x0039:
        r0 = r2;
        goto L_0x001b;
    L_0x003b:
        r0 = r0.openConnection();	 Catch:{ IndexOutOfBoundsException -> 0x00b6, IOException -> 0x00d1, RuntimeException -> 0x00ec }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ IndexOutOfBoundsException -> 0x00b6, IOException -> 0x00d1, RuntimeException -> 0x00ec }
        r1 = com.google.android.gms.ads.internal.C0056g.m5439c();	 Catch:{ all -> 0x00b1 }
        r3 = r8.f3524e;	 Catch:{ all -> 0x00b1 }
        r3 = r3.getContext();	 Catch:{ all -> 0x00b1 }
        r5 = r8.f3524e;	 Catch:{ all -> 0x00b1 }
        r5 = r5.m6655n();	 Catch:{ all -> 0x00b1 }
        r5 = r5.f3092b;	 Catch:{ all -> 0x00b1 }
        r6 = 0;
        r1.m6539a(r3, r5, r6, r0);	 Catch:{ all -> 0x00b1 }
        r1 = r0.getResponseCode();	 Catch:{ all -> 0x00b1 }
        r5 = r0.getHeaderFields();	 Catch:{ all -> 0x00b1 }
        r3 = "";
        r6 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r1 < r6) goto L_0x0116;
    L_0x0065:
        r6 = 399; // 0x18f float:5.59E-43 double:1.97E-321;
        if (r1 > r6) goto L_0x0116;
    L_0x0069:
        r1 = 0;
        r6 = "Location";
        r6 = r5.containsKey(r6);	 Catch:{ all -> 0x00b1 }
        if (r6 == 0) goto L_0x0099;
    L_0x0072:
        r1 = "Location";
        r1 = r5.get(r1);	 Catch:{ all -> 0x00b1 }
        r1 = (java.util.List) r1;	 Catch:{ all -> 0x00b1 }
    L_0x007a:
        if (r1 == 0) goto L_0x0116;
    L_0x007c:
        r5 = r1.size();	 Catch:{ all -> 0x00b1 }
        if (r5 <= 0) goto L_0x0116;
    L_0x0082:
        r3 = 0;
        r1 = r1.get(r3);	 Catch:{ all -> 0x00b1 }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x00b1 }
    L_0x0089:
        r3 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x00b1 }
        if (r3 == 0) goto L_0x00aa;
    L_0x008f:
        r1 = "Arrived at landing page, this ideally should not happen. Will open it in browser.";
        com.google.android.gms.ads.internal.util.client.C0099b.m5643d(r1);	 Catch:{ all -> 0x00b1 }
        r0.disconnect();	 Catch:{ IndexOutOfBoundsException -> 0x00b6, IOException -> 0x00d1, RuntimeException -> 0x00ec }
        r0 = r2;
        goto L_0x001b;
    L_0x0099:
        r6 = "location";
        r6 = r5.containsKey(r6);	 Catch:{ all -> 0x00b1 }
        if (r6 == 0) goto L_0x007a;
    L_0x00a1:
        r1 = "location";
        r1 = r5.get(r1);	 Catch:{ all -> 0x00b1 }
        r1 = (java.util.List) r1;	 Catch:{ all -> 0x00b1 }
        goto L_0x007a;
    L_0x00aa:
        r0.disconnect();	 Catch:{ IndexOutOfBoundsException -> 0x0111, IOException -> 0x010c, RuntimeException -> 0x0107 }
        r0 = r4;
        r2 = r1;
        goto L_0x0003;
    L_0x00b1:
        r1 = move-exception;
        r0.disconnect();	 Catch:{ IndexOutOfBoundsException -> 0x00b6, IOException -> 0x00d1, RuntimeException -> 0x00ec }
        throw r1;	 Catch:{ IndexOutOfBoundsException -> 0x00b6, IOException -> 0x00d1, RuntimeException -> 0x00ec }
    L_0x00b6:
        r0 = move-exception;
        r1 = r0;
        r0 = r2;
    L_0x00b9:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Error while parsing ping URL: ";
        r2 = r2.append(r3);
        r2 = r2.append(r0);
        r2 = r2.toString();
        com.google.android.gms.ads.internal.util.client.C0099b.m5642c(r2, r1);
        goto L_0x001b;
    L_0x00d1:
        r0 = move-exception;
        r1 = r0;
        r0 = r2;
    L_0x00d4:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Error while pinging URL: ";
        r2 = r2.append(r3);
        r2 = r2.append(r0);
        r2 = r2.toString();
        com.google.android.gms.ads.internal.util.client.C0099b.m5642c(r2, r1);
        goto L_0x001b;
    L_0x00ec:
        r0 = move-exception;
        r1 = r0;
        r0 = r2;
    L_0x00ef:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Error while pinging URL: ";
        r2 = r2.append(r3);
        r2 = r2.append(r0);
        r2 = r2.toString();
        com.google.android.gms.ads.internal.util.client.C0099b.m5642c(r2, r1);
        goto L_0x001b;
    L_0x0107:
        r0 = move-exception;
        r7 = r0;
        r0 = r1;
        r1 = r7;
        goto L_0x00ef;
    L_0x010c:
        r0 = move-exception;
        r7 = r0;
        r0 = r1;
        r1 = r7;
        goto L_0x00d4;
    L_0x0111:
        r0 = move-exception;
        r7 = r0;
        r0 = r1;
        r1 = r7;
        goto L_0x00b9;
    L_0x0116:
        r1 = r3;
        goto L_0x0089;
    L_0x0119:
        r0 = r2;
        goto L_0x001b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.ck.a():void");
    }
}
