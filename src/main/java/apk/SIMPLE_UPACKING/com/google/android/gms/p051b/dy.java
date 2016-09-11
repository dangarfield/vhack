package com.google.android.gms.p051b;

import android.app.AlertDialog.Builder;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.C0001R;
import com.google.android.gms.ads.internal.C0056g;
import java.util.Map;

@fi
/* renamed from: com.google.android.gms.b.dy */
public class dy extends ef {
    private final Map f3581a;
    private final Context f3582b;

    public dy(hb hbVar, Map map) {
        super(hbVar, "storePicture");
        this.f3581a = map;
        this.f3582b = hbVar.m6646e();
    }

    Request m6407a(String str, String str2) {
        Request request = new Request(Uri.parse(str));
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
        C0056g.m5441e().m6564a(request);
        return request;
    }

    String m6408a(String str) {
        return Uri.parse(str).getLastPathSegment();
    }

    public void m6409a() {
        if (this.f3582b == null) {
            m6386b("Activity context is not available");
        } else if (C0056g.m5439c().m6550c(this.f3582b).m6081c()) {
            String str = (String) this.f3581a.get("iurl");
            if (TextUtils.isEmpty(str)) {
                m6386b("Image url cannot be empty.");
            } else if (URLUtil.isValidUrl(str)) {
                String a = m6408a(str);
                if (C0056g.m5439c().m6548b(a)) {
                    Builder b = C0056g.m5439c().m6544b(this.f3582b);
                    b.setTitle(C0056g.m5442f().m6498a(C0001R.string.store_picture_title, "Save image"));
                    b.setMessage(C0056g.m5442f().m6498a(C0001R.string.store_picture_message, "Allow Ad to store image in Picture gallery?"));
                    b.setPositiveButton(C0056g.m5442f().m6498a(C0001R.string.accept, "Accept"), new dz(this, str, a));
                    b.setNegativeButton(C0056g.m5442f().m6498a(C0001R.string.decline, "Decline"), new ea(this));
                    b.create().show();
                    return;
                }
                m6386b("Image type not recognized: " + a);
            } else {
                m6386b("Invalid image url: " + str);
            }
        } else {
            m6386b("Feature is not supported by the device.");
        }
    }
}
