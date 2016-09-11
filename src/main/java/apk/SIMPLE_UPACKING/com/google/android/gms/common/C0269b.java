package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.gms.C0001R;

/* renamed from: com.google.android.gms.common.b */
public class C0269b extends C0268j {
    public static final int f4323a;
    private static final C0269b f4324c;

    static {
        f4324c = new C0269b();
        f4323a = C0268j.f4322b;
    }

    C0269b() {
    }

    public static C0269b m7645a() {
        return f4324c;
    }

    public int m7646a(Context context) {
        return super.m7638a(context);
    }

    public Dialog m7647a(Activity activity, OnCancelListener onCancelListener) {
        View progressBar = new ProgressBar(activity, null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        Builder builder = new Builder(activity);
        builder.setView(progressBar);
        String f = C0273r.m7667f(activity);
        builder.setMessage(activity.getResources().getString(C0001R.string.common_google_play_services_updating_text, new Object[]{f}));
        builder.setTitle(C0001R.string.common_google_play_services_updating_title);
        builder.setPositiveButton("", null);
        Dialog create = builder.create();
        C0274e.m7673a(activity, onCancelListener, "GooglePlayServicesUpdatingDialog", create);
        return create;
    }

    public Intent m7648a(Context context, int i, String str) {
        return super.m7639a(context, i, str);
    }

    public final boolean m7649a(int i) {
        return super.m7640a(i);
    }

    public boolean m7650a(Context context, int i) {
        return super.m7641a(context, i);
    }

    @Deprecated
    public Intent m7651b(int i) {
        return super.m7643b(i);
    }
}
