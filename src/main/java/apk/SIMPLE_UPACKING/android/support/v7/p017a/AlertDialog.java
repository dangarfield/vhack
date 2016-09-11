package android.support.v7.p017a;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ListAdapter;

/* renamed from: android.support.v7.a.t */
public class AlertDialog {
    private final AlertController f1350a;
    private int f1351b;

    public AlertDialog(Context context) {
        this(context, AlertDialog.m3079a(context, 0));
    }

    public AlertDialog(Context context, int i) {
        this.f1350a = new AlertController(new ContextThemeWrapper(context, AlertDialog.m3079a(context, i)));
        this.f1351b = i;
    }

    public Context m3081a() {
        return this.f1350a.f1310a;
    }

    public AlertDialog m3086a(CharSequence charSequence) {
        this.f1350a.f1315f = charSequence;
        return this;
    }

    public AlertDialog m3084a(View view) {
        this.f1350a.f1316g = view;
        return this;
    }

    public AlertDialog m3083a(Drawable drawable) {
        this.f1350a.f1313d = drawable;
        return this;
    }

    public AlertDialog m3082a(OnKeyListener onKeyListener) {
        this.f1350a.f1327r = onKeyListener;
        return this;
    }

    public AlertDialog m3085a(ListAdapter listAdapter, OnClickListener onClickListener) {
        this.f1350a.f1329t = listAdapter;
        this.f1350a.f1330u = onClickListener;
        return this;
    }

    public AlertDialog m3087b() {
        AlertDialog alertDialog = new AlertDialog(this.f1350a.f1310a, this.f1351b, false);
        this.f1350a.m3077a(alertDialog.f1349a);
        alertDialog.setCancelable(this.f1350a.f1324o);
        if (this.f1350a.f1324o) {
            alertDialog.setCanceledOnTouchOutside(true);
        }
        alertDialog.setOnCancelListener(this.f1350a.f1325p);
        alertDialog.setOnDismissListener(this.f1350a.f1326q);
        if (this.f1350a.f1327r != null) {
            alertDialog.setOnKeyListener(this.f1350a.f1327r);
        }
        return alertDialog;
    }
}
