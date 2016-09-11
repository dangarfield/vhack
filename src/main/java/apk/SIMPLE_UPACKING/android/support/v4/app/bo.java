package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;

/* compiled from: NotificationCompat */
public class bo {
    Notification f593A;
    public Notification f594B;
    public ArrayList f595C;
    public Context f596a;
    public CharSequence f597b;
    public CharSequence f598c;
    PendingIntent f599d;
    PendingIntent f600e;
    RemoteViews f601f;
    public Bitmap f602g;
    public CharSequence f603h;
    public int f604i;
    int f605j;
    boolean f606k;
    public boolean f607l;
    public ca f608m;
    public CharSequence f609n;
    int f610o;
    int f611p;
    boolean f612q;
    String f613r;
    boolean f614s;
    String f615t;
    public ArrayList f616u;
    boolean f617v;
    String f618w;
    Bundle f619x;
    int f620y;
    int f621z;

    public bo(Context context) {
        this.f606k = true;
        this.f616u = new ArrayList();
        this.f617v = false;
        this.f620y = 0;
        this.f621z = 0;
        this.f594B = new Notification();
        this.f596a = context;
        this.f594B.when = System.currentTimeMillis();
        this.f594B.audioStreamType = -1;
        this.f605j = 0;
        this.f595C = new ArrayList();
    }

    public bo m1001a(int i) {
        this.f594B.icon = i;
        return this;
    }

    public bo m1004a(CharSequence charSequence) {
        this.f597b = m999d(charSequence);
        return this;
    }

    public bo m1008b(CharSequence charSequence) {
        this.f598c = m999d(charSequence);
        return this;
    }

    public bo m1002a(PendingIntent pendingIntent) {
        this.f599d = pendingIntent;
        return this;
    }

    public bo m1007b(PendingIntent pendingIntent) {
        this.f594B.deleteIntent = pendingIntent;
        return this;
    }

    public bo m1010c(CharSequence charSequence) {
        this.f594B.tickerText = m999d(charSequence);
        return this;
    }

    public bo m1003a(Uri uri) {
        this.f594B.sound = uri;
        this.f594B.audioStreamType = -1;
        return this;
    }

    public bo m1005a(boolean z) {
        m998a(16, z);
        return this;
    }

    private void m998a(int i, boolean z) {
        if (z) {
            Notification notification = this.f594B;
            notification.flags |= i;
            return;
        }
        notification = this.f594B;
        notification.flags &= i ^ -1;
    }

    public bo m1006b(int i) {
        this.f620y = i;
        return this;
    }

    public Notification m1000a() {
        return bj.f579a.m1012a(this, m1009b());
    }

    protected bp m1009b() {
        return new bp();
    }

    protected static CharSequence m999d(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 5120) {
            return charSequence.subSequence(0, 5120);
        }
        return charSequence;
    }
}
