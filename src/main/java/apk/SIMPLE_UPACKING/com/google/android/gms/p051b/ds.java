package com.google.android.gms.p051b;

import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.provider.CalendarContract.Events;
import android.text.TextUtils;
import com.google.android.gms.C0001R;
import com.google.android.gms.ads.internal.C0056g;
import java.util.Map;

@fi
/* renamed from: com.google.android.gms.b.ds */
public class ds extends ef {
    private final Map f3549a;
    private final Context f3550b;
    private String f3551c;
    private long f3552d;
    private long f3553e;
    private String f3554f;
    private String f3555g;

    public ds(hb hbVar, Map map) {
        super(hbVar, "createCalendarEvent");
        this.f3549a = map;
        this.f3550b = hbVar.m6646e();
        m6391c();
    }

    private String m6390a(String str) {
        return TextUtils.isEmpty((CharSequence) this.f3549a.get(str)) ? "" : (String) this.f3549a.get(str);
    }

    private void m6391c() {
        this.f3551c = m6390a("description");
        this.f3554f = m6390a("summary");
        this.f3552d = m6392e("start_ticks");
        this.f3553e = m6392e("end_ticks");
        this.f3555g = m6390a("location");
    }

    private long m6392e(String str) {
        String str2 = (String) this.f3549a.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void m6393a() {
        if (this.f3550b == null) {
            m6386b("Activity context is not available.");
        } else if (C0056g.m5439c().m6550c(this.f3550b).m6083f()) {
            Builder b = C0056g.m5439c().m6544b(this.f3550b);
            b.setTitle(C0056g.m5442f().m6498a(C0001R.string.create_calendar_title, "Create calendar event"));
            b.setMessage(C0056g.m5442f().m6498a(C0001R.string.create_calendar_message, "Allow Ad to create a calendar event?"));
            b.setPositiveButton(C0056g.m5442f().m6498a(C0001R.string.accept, "Accept"), new dt(this));
            b.setNegativeButton(C0056g.m5442f().m6498a(C0001R.string.decline, "Decline"), new du(this));
            b.create().show();
        } else {
            m6386b("This feature is not available on the device.");
        }
    }

    @TargetApi(14)
    Intent m6394b() {
        Intent data = new Intent("android.intent.action.EDIT").setData(Events.CONTENT_URI);
        data.putExtra("title", this.f3551c);
        data.putExtra("eventLocation", this.f3555g);
        data.putExtra("description", this.f3554f);
        if (this.f3552d > -1) {
            data.putExtra("beginTime", this.f3552d);
        }
        if (this.f3553e > -1) {
            data.putExtra("endTime", this.f3553e);
        }
        data.setFlags(268435456);
        return data;
    }
}
