package com.google.android.gms.p051b;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;

/* renamed from: com.google.android.gms.b.f */
public class C0202f {
    private static final String[] f3620c;
    private String f3621a;
    private String[] f3622b;
    private C0201e f3623d;

    static {
        f3620c = new String[]{"/aclk", "/pcs/click"};
    }

    private Uri m6474a(Uri uri, Context context, String str, boolean z) {
        try {
            boolean a = m6480a(uri);
            if (a) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new C0203g("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new C0203g("Query parameter already exists: ms");
            }
            String a2 = z ? this.f3623d.m6411a(context, str) : this.f3623d.m6410a(context);
            return a ? m6476b(uri, "dc_ms", a2) : m6475a(uri, "ms", a2);
        } catch (UnsupportedOperationException e) {
            throw new C0203g("Provided Uri is not in a valid state");
        }
    }

    private Uri m6475a(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl");
        }
        return indexOf != -1 ? Uri.parse(new StringBuilder(uri2.substring(0, indexOf + 1)).append(str).append("=").append(str2).append("&").append(uri2.substring(indexOf + 1)).toString()) : uri.buildUpon().appendQueryParameter(str, str2).build();
    }

    private Uri m6476b(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf(";adurl");
        if (indexOf != -1) {
            return Uri.parse(new StringBuilder(uri2.substring(0, indexOf + 1)).append(str).append("=").append(str2).append(";").append(uri2.substring(indexOf + 1)).toString());
        }
        String encodedPath = uri.getEncodedPath();
        int indexOf2 = uri2.indexOf(encodedPath);
        return Uri.parse(new StringBuilder(uri2.substring(0, encodedPath.length() + indexOf2)).append(";").append(str).append("=").append(str2).append(";").append(uri2.substring(encodedPath.length() + indexOf2)).toString());
    }

    public Uri m6477a(Uri uri, Context context) {
        try {
            return m6474a(uri, context, uri.getQueryParameter("ai"), true);
        } catch (UnsupportedOperationException e) {
            throw new C0203g("Provided Uri is not in a valid state");
        }
    }

    public C0201e m6478a() {
        return this.f3623d;
    }

    public void m6479a(MotionEvent motionEvent) {
        this.f3623d.m6413a(motionEvent);
    }

    public boolean m6480a(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.f3621a);
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean m6481b(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String endsWith : this.f3622b) {
                if (host.endsWith(endsWith)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean m6482c(Uri uri) {
        if (!m6481b(uri)) {
            return false;
        }
        for (String endsWith : f3620c) {
            if (uri.getPath().endsWith(endsWith)) {
                return true;
            }
        }
        return false;
    }
}
