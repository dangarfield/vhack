package com.google.android.gms.p051b;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.PopupWindow;
import com.google.android.gms.ads.internal.C0056g;
import com.google.android.gms.ads.internal.client.C0046n;
import com.google.android.gms.ads.internal.util.client.C0099b;
import com.google.android.gms.common.C0273r;
import com.google.android.gms.common.internal.bf;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@fi
/* renamed from: com.google.android.gms.b.fx */
public class fx {
    public static final Handler f3679a;
    private final Object f3680b;
    private boolean f3681c;
    private String f3682d;
    private boolean f3683e;

    static {
        f3679a = new fq(Looper.getMainLooper());
    }

    public fx() {
        this.f3680b = new Object();
        this.f3681c = true;
        this.f3683e = false;
    }

    private JSONArray m6514a(Collection collection) {
        JSONArray jSONArray = new JSONArray();
        for (Object a : collection) {
            m6517a(jSONArray, a);
        }
        return jSONArray;
    }

    private JSONObject m6515a(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            m6518a(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    public static void m6516a(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            f3679a.post(runnable);
        }
    }

    private void m6517a(JSONArray jSONArray, Object obj) {
        if (obj instanceof Bundle) {
            jSONArray.put(m6515a((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONArray.put(m6530a((Map) obj));
        } else if (obj instanceof Collection) {
            jSONArray.put(m6514a((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONArray.put(m6529a((Object[]) obj));
        } else {
            jSONArray.put(obj);
        }
    }

    private void m6518a(JSONObject jSONObject, String str, Object obj) {
        if (obj instanceof Bundle) {
            jSONObject.put(str, m6515a((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONObject.put(str, m6530a((Map) obj));
        } else if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, m6514a((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, m6514a(Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    public int m6519a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            C0099b.m5643d("Could not parse value:" + e);
            return 0;
        }
    }

    public Bitmap m6520a(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public DisplayMetrics m6521a(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public PopupWindow m6522a(View view, int i, int i2, boolean z) {
        return new PopupWindow(view, i, i2, z);
    }

    String m6523a() {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("Mozilla/5.0 (Linux; U; Android");
        if (VERSION.RELEASE != null) {
            stringBuffer.append(" ").append(VERSION.RELEASE);
        }
        stringBuffer.append("; ").append(Locale.getDefault());
        if (Build.DEVICE != null) {
            stringBuffer.append("; ").append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                stringBuffer.append(" Build/").append(Build.DISPLAY);
            }
        }
        stringBuffer.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return stringBuffer.toString();
    }

    protected String m6524a(Context context) {
        return new WebView(context).getSettings().getUserAgentString();
    }

    public String m6525a(Context context, C0202f c0202f, String str) {
        if (c0202f != null) {
            try {
                Uri parse = Uri.parse(str);
                if (c0202f.m6482c(parse)) {
                    parse = c0202f.m6477a(parse, context);
                }
                str = parse.toString();
            } catch (Exception e) {
            }
        }
        return str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String m6526a(android.content.Context r4, java.lang.String r5) {
        /*
        r3 = this;
        r1 = r3.f3680b;
        monitor-enter(r1);
        r0 = r3.f3682d;	 Catch:{ all -> 0x005e }
        if (r0 == 0) goto L_0x000b;
    L_0x0007:
        r0 = r3.f3682d;	 Catch:{ all -> 0x005e }
        monitor-exit(r1);	 Catch:{ all -> 0x005e }
    L_0x000a:
        return r0;
    L_0x000b:
        r0 = com.google.android.gms.ads.internal.C0056g.m5441e();	 Catch:{ Exception -> 0x0095 }
        r0 = r0.m6559a(r4);	 Catch:{ Exception -> 0x0095 }
        r3.f3682d = r0;	 Catch:{ Exception -> 0x0095 }
    L_0x0015:
        r0 = r3.f3682d;	 Catch:{ all -> 0x005e }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x005e }
        if (r0 == 0) goto L_0x0067;
    L_0x001d:
        r0 = com.google.android.gms.ads.internal.client.C0046n.m5409a();	 Catch:{ all -> 0x005e }
        r0 = r0.m5630a();	 Catch:{ all -> 0x005e }
        if (r0 != 0) goto L_0x0061;
    L_0x0027:
        r0 = 0;
        r3.f3682d = r0;	 Catch:{ all -> 0x005e }
        r0 = f3679a;	 Catch:{ all -> 0x005e }
        r2 = new com.google.android.gms.b.fy;	 Catch:{ all -> 0x005e }
        r2.<init>(r3, r4);	 Catch:{ all -> 0x005e }
        r0.post(r2);	 Catch:{ all -> 0x005e }
    L_0x0034:
        r0 = r3.f3682d;	 Catch:{ all -> 0x005e }
        if (r0 != 0) goto L_0x0067;
    L_0x0038:
        r0 = r3.f3680b;	 Catch:{ InterruptedException -> 0x003e }
        r0.wait();	 Catch:{ InterruptedException -> 0x003e }
        goto L_0x0034;
    L_0x003e:
        r0 = move-exception;
        r0 = r3.m6523a();	 Catch:{ all -> 0x005e }
        r3.f3682d = r0;	 Catch:{ all -> 0x005e }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x005e }
        r0.<init>();	 Catch:{ all -> 0x005e }
        r2 = "Interrupted, use default user agent: ";
        r0 = r0.append(r2);	 Catch:{ all -> 0x005e }
        r2 = r3.f3682d;	 Catch:{ all -> 0x005e }
        r0 = r0.append(r2);	 Catch:{ all -> 0x005e }
        r0 = r0.toString();	 Catch:{ all -> 0x005e }
        com.google.android.gms.ads.internal.util.client.C0099b.m5643d(r0);	 Catch:{ all -> 0x005e }
        goto L_0x0034;
    L_0x005e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x005e }
        throw r0;
    L_0x0061:
        r0 = r3.m6524a(r4);	 Catch:{ Exception -> 0x008d }
        r3.f3682d = r0;	 Catch:{ Exception -> 0x008d }
    L_0x0067:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x005e }
        r0.<init>();	 Catch:{ all -> 0x005e }
        r2 = r3.f3682d;	 Catch:{ all -> 0x005e }
        r0 = r0.append(r2);	 Catch:{ all -> 0x005e }
        r2 = " (Mobile; ";
        r0 = r0.append(r2);	 Catch:{ all -> 0x005e }
        r0 = r0.append(r5);	 Catch:{ all -> 0x005e }
        r2 = ")";
        r0 = r0.append(r2);	 Catch:{ all -> 0x005e }
        r0 = r0.toString();	 Catch:{ all -> 0x005e }
        r3.f3682d = r0;	 Catch:{ all -> 0x005e }
        r0 = r3.f3682d;	 Catch:{ all -> 0x005e }
        monitor-exit(r1);	 Catch:{ all -> 0x005e }
        goto L_0x000a;
    L_0x008d:
        r0 = move-exception;
        r0 = r3.m6523a();	 Catch:{ all -> 0x005e }
        r3.f3682d = r0;	 Catch:{ all -> 0x005e }
        goto L_0x0067;
    L_0x0095:
        r0 = move-exception;
        goto L_0x0015;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.fx.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public String m6527a(hb hbVar, String str) {
        return m6525a(hbVar.getContext(), hbVar.m6654m(), str);
    }

    public Map m6528a(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : C0056g.m5441e().m6561a(uri)) {
            hashMap.put(str, uri.getQueryParameter(str));
        }
        return hashMap;
    }

    JSONArray m6529a(Object[] objArr) {
        JSONArray jSONArray = new JSONArray();
        for (Object a : objArr) {
            m6517a(jSONArray, a);
        }
        return jSONArray;
    }

    public JSONObject m6530a(Map map) {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                m6518a(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            throw new JSONException("Could not convert map to JSON: " + e.getMessage());
        }
    }

    public void m6531a(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public void m6532a(Activity activity, OnScrollChangedListener onScrollChangedListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().addOnScrollChangedListener(onScrollChangedListener);
        }
    }

    public void m6533a(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable th) {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public void m6534a(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(m6526a(context, str));
    }

    public void m6535a(Context context, String str, String str2) {
        List arrayList = new ArrayList();
        arrayList.add(str2);
        m6537a(context, str, arrayList);
    }

    public void m6536a(Context context, String str, String str2, Bundle bundle, boolean z) {
        if (z) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
            bundle.putString("os", VERSION.RELEASE);
            bundle.putString("api", String.valueOf(VERSION.SDK_INT));
            bundle.putString("device", C0056g.m5439c().m6551c());
            bundle.putString("appid", applicationContext.getPackageName());
            bundle.putString("eids", TextUtils.join(",", an.m6108a()));
            if (str != null) {
                bundle.putString("js", str);
            } else {
                bundle.putString("gmscore_version", Integer.toString(C0273r.m7668g(context)));
            }
        }
        Builder appendQueryParameter = new Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", str2);
        for (String str3 : bundle.keySet()) {
            appendQueryParameter.appendQueryParameter(str3, bundle.getString(str3));
        }
        C0056g.m5439c().m6535a(context, str, appendQueryParameter.toString());
    }

    public void m6537a(Context context, String str, List list) {
        for (String gtVar : list) {
            new gt(context, str, gtVar).m5505b();
        }
    }

    public void m6538a(Context context, String str, List list, String str2) {
        for (String gtVar : list) {
            new gt(context, str, gtVar, str2).m5505b();
        }
    }

    public void m6539a(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        m6541a(context, str, z, httpURLConnection, false);
    }

    public void m6540a(Context context, String str, boolean z, HttpURLConnection httpURLConnection, String str2) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", str2);
        httpURLConnection.setUseCaches(false);
    }

    public void m6541a(Context context, String str, boolean z, HttpURLConnection httpURLConnection, boolean z2) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", m6526a(context, str));
        httpURLConnection.setUseCaches(z2);
    }

    public boolean m6542a(PackageManager packageManager, String str, String str2) {
        return packageManager.checkPermission(str2, str) == 0;
    }

    public int[] m6543a(Activity activity) {
        Window window = activity.getWindow();
        if (window == null || window.findViewById(16908290) == null) {
            return m6553d();
        }
        return new int[]{window.findViewById(16908290).getWidth(), window.findViewById(16908290).getHeight()};
    }

    public AlertDialog.Builder m6544b(Context context) {
        return new AlertDialog.Builder(context);
    }

    public Bitmap m6545b(Context context, String str) {
        bf.m7883c("getBackgroundImage must not be called on the main UI thread.");
        try {
            InputStream openFileInput = context.openFileInput(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(openFileInput);
            openFileInput.close();
            return decodeStream;
        } catch (Exception e) {
            C0099b.m5639b("Fail to get background image");
            return null;
        }
    }

    public String m6546b() {
        UUID randomUUID = UUID.randomUUID();
        byte[] toByteArray = BigInteger.valueOf(randomUUID.getLeastSignificantBits()).toByteArray();
        byte[] toByteArray2 = BigInteger.valueOf(randomUUID.getMostSignificantBits()).toByteArray();
        String bigInteger = new BigInteger(1, toByteArray).toString();
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(toByteArray);
                instance.update(toByteArray2);
                Object obj = new byte[8];
                System.arraycopy(instance.digest(), 0, obj, 0, 8);
                bigInteger = new BigInteger(1, obj).toString();
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return bigInteger;
    }

    public void m6547b(Activity activity, OnScrollChangedListener onScrollChangedListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().removeOnScrollChangedListener(onScrollChangedListener);
        }
    }

    public boolean m6548b(String str) {
        return TextUtils.isEmpty(str) ? false : str.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    public int[] m6549b(Activity activity) {
        int[] a = m6543a(activity);
        return new int[]{C0046n.m5409a().m5632b((Context) activity, a[0]), C0046n.m5409a().m5632b((Context) activity, a[1])};
    }

    public ad m6550c(Context context) {
        return new ad(context);
    }

    public String m6551c() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        return str2.startsWith(str) ? str2 : str + " " + str2;
    }

    public int[] m6552c(Activity activity) {
        Window window = activity.getWindow();
        if (window == null || window.findViewById(16908290) == null) {
            return m6553d();
        }
        return new int[]{window.findViewById(16908290).getTop(), window.findViewById(16908290).getBottom()};
    }

    protected int[] m6553d() {
        return new int[]{0, 0};
    }

    public int[] m6554d(Activity activity) {
        int[] c = m6552c(activity);
        return new int[]{C0046n.m5409a().m5632b((Context) activity, c[0]), C0046n.m5409a().m5632b((Context) activity, c[1])};
    }
}
