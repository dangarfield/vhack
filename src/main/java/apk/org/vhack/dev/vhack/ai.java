package org.vhack.dev.vhack;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/* compiled from: BotnetListAdapter */
public class ai extends ArrayAdapter {
    private final Activity a;
    private final String[] b;
    private final String[] c;
    private final String[] d;
    private final String[] e;

    public ai(Activity activity, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
        super(activity, 2130968625, strArr);
        this.a = activity;
        this.b = strArr;
        this.c = strArr2;
        this.d = strArr3;
        this.e = strArr4;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = this.a.getLayoutInflater().inflate(2130968625, null, true);
        TextView textView = (TextView) inflate.findViewById(2131558967);
        TextView textView2 = (TextView) inflate.findViewById(2131558968);
        TextView textView3 = (TextView) inflate.findViewById(2131558969);
        ((TextView) inflate.findViewById(2131558966)).setText("#" + this.b[i]);
        textView.setText(this.c[i] + " / 100");
        textView2.setText(this.d[i] + " / 100");
        textView3.setText("$" + a(this.e[i]));
        return inflate;
    }

    public String a(String str) {
        return String.format("%,d", new Object[]{Long.valueOf(Long.parseLong(str))}).replace(",", ".");
    }
}
