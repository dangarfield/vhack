package org.vhack.dev.vhack;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/* compiled from: ClusterMemberAdapter */
public class bg extends ArrayAdapter {
    private final Activity a;
    private final String[] b;
    private final String[] c;
    private final String[] d;

    public bg(Activity activity, String[] strArr, String[] strArr2, String[] strArr3) {
        super(activity, 2130968627, strArr);
        this.a = activity;
        this.b = strArr;
        this.c = strArr2;
        this.d = strArr3;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = this.a.getLayoutInflater().inflate(2130968627, null, true);
        TextView textView = (TextView) inflate.findViewById(2131558976);
        TextView textView2 = (TextView) inflate.findViewById(2131558975);
        ((TextView) inflate.findViewById(2131558974)).setText(this.b[i]);
        textView.setText("Rep.: " + a(this.d[i]));
        textView2.setText("Score: " + a(this.c[i]));
        return inflate;
    }

    public String a(String str) {
        return String.format("%,d", new Object[]{Integer.valueOf(Integer.parseInt(str))}).replace(",", ".");
    }
}
