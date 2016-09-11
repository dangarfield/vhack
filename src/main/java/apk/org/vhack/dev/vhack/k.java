package org.vhack.dev.vhack;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/* compiled from: AdWareListAdapter */
public class k extends ArrayAdapter {
    private final Activity a;
    private final String[] b;
    private final String[] c;
    private final String[] d;
    private final String[] e;

    public k(Activity activity, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
        super(activity, 2130968624, strArr);
        this.a = activity;
        this.b = strArr;
        this.c = strArr2;
        this.d = strArr3;
        this.e = strArr4;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = this.a.getLayoutInflater().inflate(2130968624, null, true);
        TextView textView = (TextView) inflate.findViewById(2131558962);
        TextView textView2 = (TextView) inflate.findViewById(2131558963);
        TextView textView3 = (TextView) inflate.findViewById(2131558964);
        ((TextView) inflate.findViewById(2131558961)).setText(this.b[i]);
        textView.setText(this.c[i]);
        textView2.setText(this.e[i]);
        textView3.setText(a(this.d[i]));
        return inflate;
    }

    public String a(String str) {
        return String.format("%,d", new Object[]{Integer.valueOf(Integer.parseInt(str))}).replace(",", ".");
    }
}
