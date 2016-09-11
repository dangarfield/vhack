package org.vhack.dev.vhack;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/* compiled from: BotnetListAdapter */
public class ai extends ArrayAdapter {
    private final Activity f5264a;
    private final String[] f5265b;
    private final String[] f5266c;
    private final String[] f5267d;
    private final String[] f5268e;

    public ai(Activity activity, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
        super(activity, 2130968625, strArr);
        this.f5264a = activity;
        this.f5265b = strArr;
        this.f5266c = strArr2;
        this.f5267d = strArr3;
        this.f5268e = strArr4;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = this.f5264a.getLayoutInflater().inflate(2130968625, null, true);
        TextView textView = (TextView) inflate.findViewById(2131558967);
        TextView textView2 = (TextView) inflate.findViewById(2131558968);
        TextView textView3 = (TextView) inflate.findViewById(2131558969);
        ((TextView) inflate.findViewById(2131558966)).setText("#" + this.f5265b[i]);
        textView.setText(this.f5266c[i] + " / 100");
        textView2.setText(this.f5267d[i] + " / 100");
        textView3.setText("$" + m9072a(this.f5268e[i]));
        return inflate;
    }

    public String m9072a(String str) {
        return String.format("%,d", new Object[]{Long.valueOf(Long.parseLong(str))}).replace(",", ".");
    }
}
